package com.pw.security

import callcenter.Clientes
import callcenter.Historial
import callcenter.Subestado
import grails.transaction.Transactional
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import utilitarios.Util

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = false)
class UsuarioController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


	static beforeInterceptor = {
		String accion = actionUri
		if (!accion.equals("/usuario/login") && !accion.equals("/usuario/logout") && !accion.equals('/usuario/cargaConfiguracion')) {
			if (!session.user) {
				redirect(uri: "/usuario/login")
				return false
			} else {
				boolean tienePermiso = utilitarios.Util.checkAccess(session.user.usuario, accion)
				if (!tienePermiso) {
					render "No tienes permiso para ingresar a este sitio-> " + accion
				}
			}
		}
	}
	
	
	def login(){
		
		if(session.user){
			redirect(action:'dashboard')
		}
		
		if(params.usuario && params.password){
			def usuario = Usuario.findByUsuarioAndPasswordAndEstado(params.usuario.toString(), params.password.toString(), "ACTIVO");
			if(usuario){
				session.user = usuario
				def sesion = new Sesion()
				sesion.usuario = usuario
				sesion.idSesion = session.id
				sesion.fechaInicio = new Date()
				sesion.direccionIp = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes())
						.getRequest().getRemoteHost()

				if(!sesion.save(flush: true))
					println sesion.errors
				redirect(action:'dashboard')
			}else{
			flash.errorMessage = "Error al iniciar sesion"
				Util.saveLog(1, "Intento fallido de ingreso con usuario ${params.usuario} y password ${params.password}")
				usuario = new Usuario(params)
				[usuario: usuario]
			}
			
		}
	}
	
	def logout(){
		Sesion sesion = Sesion.findByIdSesion(session.id)
		sesion?.fechaFin = new Date()
		sesion?.save(flush: true)
		session.invalidate()
		redirect(uri: "/usuario/login");
	}
	def dashboard(){

			Date fechaInicio = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 00:00:00"))
			Date fechaFin = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 23:59:59"))
			def subestados = Subestado.findAllByType("Exitoso")
			Rol rol = Rol.findByNombre("OPERADOR")
			//def ventasPorUsuario = Clientes.executeQuery("select nombreVendedor, count(*) from Clientes where subestadoGestion in (:subestados) and fechaGestion between :fechaInicio and :fechaFin group by nombreVendedor order by count(*) desc", [subestados: subestados, fechaInicio: fechaInicio, fechaFin: fechaFin])
		    def ventasPorUsuario = Historial.executeQuery("select nombreVendedor, count(*) from Historial where subSubEstado = 'VENTA' and fechaGestion between :fechaInicio and :fechaFin group by nombreVendedor order by count(*) desc", [fechaInicio: fechaInicio, fechaFin: fechaFin])
			def inicioSesion = Sesion.executeQuery("select usuario.nombre, time(fechaInicio), time(fechaFin) from Sesion where fechaInicio between :fechaInicio and :fechaFin and usuario.rol = :rol order by fechaInicio desc", [fechaInicio: fechaInicio, fechaFin: fechaFin, rol: rol])
			
			//Para la tabla de gestionados contactados y no contactados
			int totalGestionados = 0
			int totalContactados = 0
			int totalNoContactados = 0
			def gestionadosAgente = Historial.executeQuery("select nombreVendedor, count(*) from Historial where intentos != 0 and fechaGestion between :fechaInicio and :fechaFin group by nombreVendedor order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin])
			def contactadosAgente = Historial.executeQuery("select nombreVendedor, count(*) from Historial where intentos != 0 and estadoGestion = 'CONTACTADO' and fechaGestion between :fechaInicio and :fechaFin group by nombreVendedor order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin])
			def noContactadosAgente = Historial.executeQuery("select nombreVendedor, count(*) from Historial where intentos != 0 and estadoGestion = 'NO CONTACTADO' and fechaGestion between :fechaInicio and :fechaFin group by nombreVendedor order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin])
		    def segurosAgente = Clientes.executeQuery("select nombreVendedor, count(*) from Clientes where fechaGestion between :fechaInicio and :fechaFin and seguroDesgravamen = 'SI' group by nombreVendedor order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin])

		    String[][] tablaResultAgente = new String[ventasPorUsuario.size()][4]
		    for(int x = 0; x < tablaResultAgente.size(); x++){
				tablaResultAgente[x][0] = ventasPorUsuario[x][0];
				tablaResultAgente[x][1] = ventasPorUsuario[x][1];
				for(int y = 0; y < segurosAgente.size(); y++){
					if(segurosAgente[y][0] == ventasPorUsuario[x][0]){
						tablaResultAgente[x][2] = segurosAgente[y][1];
						break;
					}
				}
		     }

			String[][] tablaResult = new String[gestionadosAgente.size()][4]
			//Lleno la matriz de resultados con los resultados de las onsultas anteriores
			for(int i = 0; i < tablaResult.size(); i++){
				tablaResult[i][0] = gestionadosAgente[i][0];
				tablaResult[i][1] = gestionadosAgente[i][1];
				for(int j = 0; j < contactadosAgente.size(); j++){
					if(contactadosAgente[j][0] == gestionadosAgente[i][0]){
						tablaResult[i][2] = contactadosAgente[j][1];
						break;						
					}					
				}
				for(int k = 0; k < noContactadosAgente.size(); k++){
					if(noContactadosAgente[k][0] == gestionadosAgente[i][0]){
						tablaResult[i][3] = noContactadosAgente[k][1];
						break;
					}
				}
			}
			//Recorro la matriz de resultados para obtener los totales
			for(int i = 0; i < tablaResult.size(); i++){
				totalGestionados = totalGestionados + tablaResult[i][1].toInteger();
				if(tablaResult[i][2] != null)
					totalContactados = totalContactados + tablaResult[i][2].toInteger();
				if(tablaResult[i][3] != null)
				totalNoContactados = totalNoContactados + tablaResult[i][3].toInteger();
			}

		def gestionadosPlusWireless = Historial.executeQuery("select nombreVendedor, count(*) from Historial where intentos != 0 and fechaGestion between :fechaInicio and :fechaFin and plataforma != 'PURE CLOUD' group by nombreVendedor order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin])
		def contactadosPlusWireless = Historial.executeQuery("select nombreVendedor, count(*) from Historial where intentos != 0 and estadoGestion = 'CONTACTADO' and fechaGestion between :fechaInicio and :fechaFin and plataforma != 'PURE CLOUD' group by nombreVendedor order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin])
		def ventasPlusWireless = Historial.executeQuery("select  nombreVendedor, count(*) from Historial where subSubEstado = 'VENTA' and fechaGestion between :fechaInicio and :fechaFin and plataforma != 'PURE CLOUD' group by nombreVendedor order by count(*) desc", [fechaInicio: fechaInicio, fechaFin: fechaFin])
		String[][] tablaResultPlusWireless = new String[gestionadosPlusWireless.size()][5]
		int totalGestionadosPlusWireless = 0;
		int totalContactadosPlusWireless = 0;
		int totalExitososPlusWireless = 0;
		//Lleno la matriz de resultados
		for(int k = 0; k < tablaResultPlusWireless.size(); k++){
			tablaResultPlusWireless[k][0] = gestionadosPlusWireless[k][0];
			tablaResultPlusWireless[k][1] = gestionadosPlusWireless[k][1];
			for(int l = 0; l < contactadosPlusWireless.size(); l++) {
				if (contactadosPlusWireless[l][0] == gestionadosPlusWireless[k][0]) {
					tablaResultPlusWireless[k][2] = contactadosPlusWireless[l][1];
					break;
				}
			}
			//LLeno la información de las ventas TDC
			for(int m = 0; m < ventasPlusWireless.size(); m++){
				if(ventasPlusWireless[m][0] == gestionadosPlusWireless[k][0]){
					tablaResultPlusWireless[k][3] = ventasPlusWireless[m][1]
					break
				}
			}
		}

		//Recorro la matriz de resultados para obtener los totales
		for(int i = 0; i < tablaResultPlusWireless.size(); i++){
			totalGestionadosPlusWireless = totalGestionadosPlusWireless + tablaResultPlusWireless[i][1].toInteger();
			if(tablaResultPlusWireless[i][2] != null)
				totalContactadosPlusWireless = totalContactadosPlusWireless + tablaResultPlusWireless[i][2].toInteger();
			if(tablaResultPlusWireless[i][3] != null)
				totalExitososPlusWireless = totalExitososPlusWireless + tablaResultPlusWireless[i][3].toInteger();
		}

		def gestionadosPureCloud = Historial.executeQuery("select nombreVendedor, count(*) from Historial where intentos != 0 and fechaGestion between :fechaInicio and :fechaFin and plataforma = 'PURE CLOUD' group by nombreVendedor order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin])
		def contactadosPureCloud = Historial.executeQuery("select nombreVendedor, count(*) from Historial where intentos != 0 and estadoGestion = 'CONTACTADO' and fechaGestion between :fechaInicio and :fechaFin and plataforma = 'PURE CLOUD' group by nombreVendedor order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin])
		def ventasPureCloud = Historial.executeQuery("select  nombreVendedor, count(*) from Historial where subSubEstado = 'VENTA' and fechaGestion between :fechaInicio and :fechaFin and plataforma = 'PURE CLOUD' group by nombreVendedor order by count(*) desc", [fechaInicio: fechaInicio, fechaFin: fechaFin])
		String[][] tablaResultPureCloud = new String[gestionadosPureCloud.size()][5]
		int totalGestionadosPureCloud = 0;
		int totalContactadosPureCloud = 0;
		int totalExitososPureCloud = 0;


		//Lleno la matriz de resultados
		for(int k = 0; k < tablaResultPureCloud.size(); k++){
			tablaResultPureCloud[k][0] = gestionadosPureCloud[k][0];
			tablaResultPureCloud[k][1] = gestionadosPureCloud[k][1];
			for(int l = 0; l < contactadosPureCloud.size(); l++) {
				if (contactadosPureCloud[l][0] == gestionadosPureCloud[k][0]) {
					tablaResultPureCloud[k][2] = contactadosPureCloud[l][1];
					break;
				}
			}
			//LLeno la información de las ventas TDC
			for(int m = 0; m < ventasPureCloud.size(); m++){
				if(ventasPureCloud[m][0] == gestionadosPureCloud[k][0]){
					tablaResultPureCloud[k][3] = ventasPureCloud[m][1]
					break
				}
			}
		}

		//Recorro la matriz de resultados para obtener los totales
		for(int i = 0; i < tablaResultPureCloud.size(); i++){
			totalGestionadosPureCloud = totalGestionadosPureCloud + tablaResultPureCloud[i][1].toInteger();
			if(tablaResultPureCloud[i][2] != null)
				totalContactadosPureCloud = totalContactadosPureCloud + tablaResultPureCloud[i][2].toInteger();
			if(tablaResultPureCloud[i][3] != null)
				totalExitososPureCloud = totalExitososPureCloud + tablaResultPureCloud[i][3].toInteger();
		}
//Para la tabla de gestionados, exitosos y contactados por base
		def contactadosPorBase = Clientes.executeQuery("select nombreBase, count(*) from Clientes where intentos != 0 and estadoGestion = 'CONTACTADO' and fechaGestion between :fechaInicio and :fechaFin group by nombreBase order by nombreBase", [fechaInicio: fechaInicio, fechaFin: fechaFin])
		def exitososPorBase = Clientes.executeQuery("select nombreBase, count(*) from Clientes where intentos != 0 and estadoGestion = 'CONTACTADO' and subestadoGestion in (:subestados) and fechaGestion between :fechaInicio and :fechaFin group by nombreBase order by nombreBase", [fechaInicio: fechaInicio, fechaFin: fechaFin, subestados: subestados])

		String[][] tablaResult1 = new String[contactadosPorBase.size()][4]
		//Lleno la matriz de resultados con los resultados de las consultas anteriores
		for(int i = 0; i < tablaResult1.size(); i++){
			tablaResult1[i][0] = contactadosPorBase[i][0]
			tablaResult1[i][1] = contactadosPorBase[i][1]
			for(int j = 0; j < exitososPorBase.size(); j++){
				if(exitososPorBase[j][0] == contactadosPorBase[i][0]){
					tablaResult1[i][2] = exitososPorBase[j][1]
					break
				}
			}
		}

						
			[tablaResultAgente: tablaResultAgente, inicioSesion: inicioSesion, tablaResult: tablaResult, totalGestionados: totalGestionados, totalContactados: totalContactados, totalNoContactados: totalNoContactados
			 ,tablaResultPlusWireless: tablaResultPlusWireless, totalGestionadosPlusWireless: totalGestionadosPlusWireless,
			  totalContactadosPlusWireless: totalContactadosPlusWireless,totalExitososPlusWireless: totalExitososPlusWireless, tablaResultPureCloud: tablaResultPureCloud,
			  totalGestionadosPureCloud: totalGestionadosPureCloud, totalContactadosPureCloud: totalContactadosPureCloud, totalExitososPureCloud: totalExitososPureCloud,
			 tablaResult1: tablaResult1];

	}

	private String[][] consolidarExitAdic(ArrayList exitosos, ArrayList adicionales){
		String[][] consolidado = new String[exitosos.size()][3]
		for(int i = 0; i < exitosos.size(); i++){
			boolean encontrado = false
			for(int j = 0; j < adicionales.size(); j++){
				if(exitosos[i][0] == adicionales[j][0]){
					consolidado[i][0] = exitosos[i][0]
					consolidado[i][1] = exitosos[i][1]
					consolidado[i][2] = adicionales[j][1]
					encontrado = true
					break
				}
			}
			if(!encontrado){
				consolidado[i][0] = exitosos[i][0]
				consolidado[i][1] = exitosos[i][1]
				consolidado[i][2] = "0"
			}
		}
		return consolidado
	}
	
	def dashboardAgente(){
		Date fechaInicio = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 00:00:00"));
		Date fechaFin = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 23:59:59"));
		Subestado subestado = Subestado.findByNombre("ACEPTA");
		Rol rol = Rol.findByNombre("OPERADOR");
		def ventasPorUsuario = Clientes.executeQuery("select nombreVendedor, count(*) from Clientes where subestadoGestion = :subestado and fechaGestion between :fechaInicio and :fechaFin group by nombreVendedor order by count(*) desc", [subestado: subestado, fechaInicio: fechaInicio, fechaFin: fechaFin]);
		def inicioSesion = Sesion.executeQuery("select usuario.nombre, time(min(dateCreated)) from Sesion where dateCreated between :fechaInicio and :fechaFin and usuario.rol = :rol group by usuario.nombre order by usuario.nombre", [fechaInicio: fechaInicio, fechaFin: fechaFin, rol: rol]);
		
		//Para la tabla de gestionados contactados y no contactados
		int totalGestionados = 0;
		int totalContactados = 0;
		int totalNoContactados = 0;
		def gestionadosAgente = Clientes.executeQuery("select nombreVendedor, count(*) from Clientes where intentos != 0 and fechaGestion between :fechaInicio and :fechaFin group by nombreVendedor order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin]);
		def contactadosAgente = Clientes.executeQuery("select nombreVendedor, count(*) from Clientes where intentos != 0 and estadoGestion = 'CONTACTADO' and fechaGestion between :fechaInicio and :fechaFin group by nombreVendedor order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin]);
		def noContactadosAgente = Clientes.executeQuery("select nombreVendedor, count(*) from Clientes where intentos != 0 and estadoGestion = 'NO CONTACTADO' and fechaGestion between :fechaInicio and :fechaFin group by nombreVendedor order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin]);
		String[][] tablaResult = new String[gestionadosAgente.size()][4];
		//Lleno la matriz de resultados con los resultados de las onsultas anteriores
		for(int i = 0; i < tablaResult.size(); i++){
			tablaResult[i][0] = gestionadosAgente[i][0];
			tablaResult[i][1] = gestionadosAgente[i][1];
			for(int j = 0; j < contactadosAgente.size(); j++){
				if(contactadosAgente[j][0] == gestionadosAgente[i][0]){
					tablaResult[i][2] = contactadosAgente[j][1];
					break;
				}
			}
			for(int k = 0; k < noContactadosAgente.size(); k++){
				if(noContactadosAgente[k][0] == gestionadosAgente[i][0]){
					tablaResult[i][3] = noContactadosAgente[k][1];
					break;
				}
			}
		}
		//Recorro la matriz de resultados para obtener los totales
		for(int i = 0; i < tablaResult.size(); i++){
			totalGestionados = totalGestionados + tablaResult[i][1].toInteger();
			if(tablaResult[i][2] != null)
				totalContactados = totalContactados + tablaResult[i][2].toInteger();
			if(tablaResult[i][3] != null)
			totalNoContactados = totalNoContactados + tablaResult[i][3].toInteger();
		}
					
		[ventasPorUsuario: ventasPorUsuario, inicioSesion: inicioSesion, tablaResult: tablaResult, totalGestionados: totalGestionados, totalContactados: totalContactados, totalNoContactados: totalNoContactados];
	}

    def index(Integer max) {
//        params.max = Math.min(max ?: 10, 100)
		Usuario usuario = Usuario.findById(session.user.id);
		if(Util.isAdmin(usuario.usuario))
        	respond Usuario.list(), model:[usuarioInstanceCount: Usuario.count()]
		else		
			respond Usuario.executeQuery("from Usuario where rol.nombre != 'ADMINISTRADOR'"), model:[usuarioInstanceCount: Usuario.count()]
    }

    def show(Usuario usuarioInstance) {
        respond usuarioInstance
    }

    def create() {
        respond new Usuario(params)
    }

    @Transactional
    def save(Usuario usuarioInstance) {
        if (usuarioInstance == null) {
            notFound()
            return
        }

        if (usuarioInstance.hasErrors()) {
            respond usuarioInstance.errors, view:'create'
            return
        }

		if (usuarioInstance.save(flush: true)) {
			Util.saveLog(session.user.id, "Creado usuario ${usuarioInstance.nombre}")
		}

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuarioInstance.id])
                redirect usuarioInstance
            }
            '*' { respond usuarioInstance, [status: CREATED] }
        }
    }

    def edit(Usuario usuarioInstance) {
        respond usuarioInstance
    }

    @Transactional
    def update(Usuario usuarioInstance) {
        if (usuarioInstance == null) {
            notFound()
            return
        }

        if (usuarioInstance.hasErrors()) {
            respond usuarioInstance.errors, view:'edit'
            return
        }

		if (usuarioInstance.save(flush: true)) {
			Util.saveLog(session.user.id, "Actualizado usuario ${usuarioInstance.nombre}")
		}

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Usuario.label', default: 'Usuario'), usuarioInstance.id])
                redirect usuarioInstance
            }
            '*'{ respond usuarioInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Usuario usuarioInstance) {

        if (usuarioInstance == null) {
            notFound()
            return
        }

        usuarioInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Usuario.label', default: 'Usuario'), usuarioInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
