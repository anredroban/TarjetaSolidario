package callcenter
import com.pw.security.*
import grails.converters.JSON
import jxl.Cell
import jxl.Sheet
import jxl.Workbook
import jxl.WorkbookSettings
import liquibase.util.file.FilenameUtils
import org.codehaus.groovy.runtime.StringGroovyMethods
import utilitarios.Util

class GestionController {



	static beforeInterceptor = {
		String accion = actionUri;
		if(!accion.equals("/usuario/login") && !accion.equals("/usuario/logout")){
			if(!session.user){
				redirect(uri: "/usuario/login");
				return false;
			}else{
				boolean tienePermiso = utilitarios.Util.checkAccess(session.user.usuario, accion)
				if(!tienePermiso){
					render "No tienes permiso para ingresar a este sitio-> "+accion;
				}
			}
		}
	}

	/**
	 * @author Giovanny Granda
	 * Muestra en pantalla los clientes asignados
	 * @return
	 */
	def index() {
		Usuario usuario = Usuario.findById(session.user.id);
		def plataforma = 'PURE CLOUD'
		def clients = Clientes.withCriteria {
			eq('usuario',usuario)
				eq('isActive', true)
			    eq('isBaseActiva', true)
			notEqual('plataforma', plataforma)
			subestadoGestion {
				or{
					eq('type', Subestado.constraints.type.inList[0].toString())
					eq('type', Subestado.constraints.type.inList[1].toString())
				}
			}
			order("intentos")
			//order("nombreBase")
		}
		def clientsNoManagement = Clientes.withCriteria {
			eq('usuario',usuario)
			eq('isActive', true)
			eq('isBaseActiva', true)
			notEqual('plataforma', plataforma)
			isNull('subestadoGestion')
		}

		clients.each {client ->
			clientsNoManagement.add(client)
		}
		[clientesGestionar: clientsNoManagement]
	}

	/**
	 * @author Giovanny Granda
	 * Muestra la pantalla de gestion donde se hara rectificación de datos
	 * @param id
	 * @return
	 */
	def gestionCliente(long id){
		long idCliente = id
		Clientes cliente = Clientes.findById(idCliente)
		long idManagement = cliente.id
        session.user
		Clientes.executeUpdate("update Clientes set isManagement = true where id = :idManagement", [idManagement: idManagement])
		[cliente: cliente,usuario: session.user]

	}

	/*def gestionCliente(long id){
		long idCliente = id
		Clientes cliente = Clientes.findById(idCliente)
		if (cliente.subSubEstado.equalsIgnoreCase("VENTA")){
		}else{
			session.user
			[cliente: cliente,usuario: session.user]
		}

	}*/

	/**
	 * @author Giovanny Granda
	 * Guarda la gestion del call center
	 * @param id
	 * @return
	 */
	def guardarCliente(){

		Usuario usuario = Usuario.findById(session.user.id.toString().toLong())
		Date fechaActual = new Date()
		long idCliente = params.idCliente.toLong()
		long idEstadoGestion = params.status.toLong()
		long idSubestadoGestion = params.substatus.toLong()
		long idSubSubestadoGestion = params.subSubStatus.toLong()
		String estadoGestion = Estado.findById(idEstadoGestion).nombre
		Subestado objSubestadoGestion = Subestado.findById(idSubestadoGestion)
		SubSubestado objSubSubestadoGestion = SubSubestado.findById(idSubSubestadoGestion)
		int tiempoLlamada = 0
		if(objSubestadoGestion.rangoTiempo){
			String[] tiempos = objSubestadoGestion.rangoTiempo.split('-')
			int t0 = tiempos[0].toInteger()
			int t1 = tiempos[1].toInteger()
			tiempoLlamada = Math.floor(Math.random()*(t1-t0+1)+t0)
		}

		//Busco el cliente por su id
		Clientes cliente = Clientes.findById(idCliente)
		int intentos = cliente.intentos?: 0

		if(cliente.registroExitoso != "SI"){
		if(objSubSubestadoGestion.name.equalsIgnoreCase("VENTA")){
			cliente.lugarEntrega = params.lugarEntrega
			cliente.horarioEntrega = params.horarioEntrega
			cliente.fechaEntrega = new Date().parse('yyyy-MM-dd HH:mm:ss', params.fechaHoraEntrega.toString().replace('/','-') + ':00')
			cliente.nombreImpreso = formatearTexto(params.primerNombre.toString() + ' ' + params.apellidoPaterno.toString()).toUpperCase()
			cliente.lugarEntregaECuenta = params.lugarEntregaECuenta
			cliente.seguroDesgravamen=params.seguroDesgravamen
			cliente.aceptaPlanConmigo = params.aceptaPlanConmigo//PLAN CONMIGO
			cliente.tipoIdentificacion = params.tipoIdentificacion
			cliente.identificacion = params.cedula
			cliente.apellidoPaterno = params.apellidoPaterno
			cliente.apellidoMaterno = params.apellidoMaterno
			cliente.primerNombre = params.primerNombre
			cliente.segundoNombre = params.segundoNombre
			cliente.genero = params.genero
			cliente.estadoCivil = params.estadoCivil
			cliente.identificacionConyuge = params.identificacionConyuge
			cliente.apellido1Conyuge = formatearTexto(params.apellido1Conyuge.toString()).toUpperCase()
			cliente.apellido2Conyuge = formatearTexto(params.apellido2Conyuge.toString()).toUpperCase()
			cliente.nombre1Conyuge = formatearTexto(params.nombre1Conyuge.toString()).toUpperCase()
			cliente.nombre2Conyuge = formatearTexto(params.nombre2Conyuge.toString()).toUpperCase()
			//cliente.nombreLaboraConyuge = formatearTexto(params.nombreLaboraConyuge.toString()).toUpperCase()
			cliente.nivelEstudios = "SECUNDARIA"
			cliente.profesion = "NINGUNA"
			cliente.cargasFamiliares = params.cargasFamiliares
			cliente.ubicacionProvinciaDomicilio = params.provinciaDomicilio.toString()
			cliente.ubicacionCantonDomicilio = Ciudad.findById(params.ciudadDomicilio.toString().toLong()).codigoUbicacion
			cliente.ciudadDomicilio = Ciudad.findById(params.ciudadDomicilio.toString().toLong()).nombre
			cliente.ubicacionParroquiaDomicilio = Parroquia.findById(params.sectorDomicilio.toString().toLong()).codigoUbicacion
			cliente.ubicacionBarrioDomicilio = Barrio.findById(params.barrioDomicilio.toString().toLong()).codigoUbicacion
			cliente.barrioNoDefinidoDomicilio = params.barrioNoDefinidoDomicilio
			cliente.referenciaDomicilio = removeSpecialCharacters(params.referenciaDomicilio.toString())
			cliente.callePrincipalDomicilio = formatearTexto(params.callePrincipalDomicilio.toString())
			cliente.numeracionDomicilio = formatearTexto(params.numeracionDomicilio.toString())
			cliente.calletransversalDomicilio = formatearTexto(params.calleTransversalDomicilio.toString())
			cliente.tipoVivienda = params.tipoVivienda
			cliente.valorVivienda = params.valorVivienda
			cliente.emailEstadoCuenta = params.emailEstadoCuenta
			cliente.emailPersonal = params.emailPersonal
			cliente.fechaNacimientoGestion = params.fechaNacimientoGestion

            //DATOS DEL TRABAJO
			cliente.origenIngresos = params.origenIngresos
			cliente.rucEmpresa = params.rucEmpresa
			cliente.nombreLabora = params.nombreLabora
			cliente.fechaIngreso =  params.fechaInicioTrabajoActual
			cliente.cargo = params.cargo
			cliente.ubicacionProvinciaTrabajo = params.provinciaTrabajo.toString()
			cliente.ubicacionCantonTrabajo = Ciudad.findById(params.ciudadTrabajo.toString()).codigoUbicacion
			cliente.ubicacionParroquiaTrabajo = Parroquia.findById(params.sectorTrabajo.toString().toLong()).codigoUbicacion
			cliente.ubicacionBarrioTrabajo = Barrio.findById(params.barrioTrabajodiv.toString().toLong()).codigoUbicacion
			cliente.barrioNoDefinidoTrabajo = params.barrioNoDefinidoTrabajo
			cliente.referenciaTrabajo = removeSpecialCharacters(params.referenciaTrabajo.toString())
			cliente.callePrincipalTrabajo = formatearTexto(params.callePrincipalTrabajo.toString())
			cliente.numeracionTrabajo = formatearTexto(params.numeracionTrabajo.toString())
			cliente.calletransversalTrabajo = formatearTexto(params.calleTransversalTrabajo.toString())
			cliente.telefonoPrincipalGestion = params.telefonoPrincipal //Campo utilizado para guardar el teléfono Principal
			cliente.telefonoSecundarioGestion = params.telefonoSecundario //Campo utilizado para guardar el telefono Secundario
			cliente.telefonoTrabajoGestion = params.telefonoTrabajo //Campo utilizado para almacenar el telefono de trabajo
			cliente.telefonoCelularGestion = params.celular //Campo utilizado para almacenar el telefono de celular
			//INGRESOS MENSUALES
			cliente.sueldoIngresos = params.sueldoIngresos
			cliente.rentas = params.rentas
			cliente.remesas = params.remesas
			cliente.ingresoFamiliares = params.ingresoFamiliares
			cliente.otrosIngresos = params.otrosIngresos
			//GASTOS MENSUALES
			cliente.gastosBasicos = params.gastosBasicos
			cliente.serviciosBasicos = params.serviciosBasicos
			cliente.transporte = params.transporte
			cliente.otrosGastos = params.otrosGastos
			//ACTIVOS (Bienes)
			cliente.activoBien = params.activoBien
			cliente.valorUnitarioBien = params.valorUnitarioBien
			//PASIVOS
			cliente.institucionPasivo = params.institucionPasivo
			cliente.fechaEmisionPasivo = params.fechaEmisionPasivo
			cliente.valorCuotaPasivo = params.valorCuotaPasivo
			cliente.plazoPasivo = params.plazoPasivo
			cliente.saldoPasivo = params.saldoPasivo
			//REFERENCIA PERSONAL
			cliente.apellido1RefPersonal = params.apellido1RefPersonal
			cliente.apellido2RefPersonal = params.apellido2RefPersonal
			cliente.nombre1RefPersonal = params.nombre1RefPersonal
			cliente.nombre2RefPersonal = params.nombre2RefPersonal
			cliente.telefonoRefPersonal = params.telefonoRefPersonal
			cliente.celularRefPersonal = params.celularRefPersonal // Campo utilizado para guardar el celular de la referencia personal del cliente
            cliente.parentescoRefPersonal = params.parentescoRefPersonal

			//REFERENCIA PERSONAL2
			cliente.apellido1RefPersonal2 = params.apellido1RefPersonal2
			cliente.apellido2RefPersonal2 = params.apellido2RefPersonal2
			cliente.nombre1RefPersonal2 = params.nombre1RefPersonal2
			cliente.nombre2RefPersonal2 = params.nombre2RefPersonal2
			cliente.telefonoRefPersonal2 = params.telefonoRefPersonal2
			cliente.celularRefPersonal2 = params.celularRefPersonal2 // Campo utilizado para guardar el celular de la referencia personal del cliente
			cliente.parentescoRefPersonal2 = params.parentescoRefPersonal2

			//campo que es utilizado para guardar el telefono SMS
			cliente.celularSms = params.telefonoCelularSMS

			//campos que guarda el dia de corte y pago
			cliente.diaFechaCorte = formateaDiaPago(params.diaPago, "1")
			cliente.diaFechaPago = formateaDiaPago(params.diaPago, "2")

			//campo para notar si esta impreso o no por defecto guarda 0
			cliente.esImpreso = 0

			if(params.provinciaTrabajo != ""){
				cliente.provinciaTrabajo = params.provinciaTrabajo.toString()
			}
			if(params.ciudadTrabajo != ""){
				cliente.ciudadTrabajo = params.ciudadTrabajo.toString()
			}
			if(params.sectorDomicilio != ""){
				cliente.parroquiaDomicilio = params.sectorDomicilio.toString()
			}
			cliente.referenciaTrabajo = removeSpecialCharacters(params.referenciaTrabajo.toString())
			//cliente.telefonoTrabajo = params.telefonoTrabajo
			cliente.sueldoIngresos = params.sueldoIngresos
			cliente.gastosBasicos = params.gastosBasicos
			//PARA QUE DESAPAREZCA AL CARGAR CLIENTES
			cliente.isActive = false
			cliente.registroExitoso = 'SI'
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("VOLVER A LLAMAR")){
			cliente.fechaRellamada = new Date().parse('yyyy-MM-dd HH:mm:ss', params.recall.toString().replace('/','-') + ':00')
		}else{
			cliente.fechaRellamada = null
		}
		//VALIDACIONES PARA LA REGESTION
		if(objSubSubestadoGestion.name.equalsIgnoreCase("CLIENTE MOLESTO - MALA EXPERIENCIA CON EL BANCO")){
			cliente.isActive = false
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("NO ACEPTA SEGURO")){
			cliente.isActive = false
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("NO LE INTERESA")){
			cliente.isActive = false
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("NO APLICA - CLIENTE SIN FUENTE DE INGRESOS AL MOMENTO")){
			cliente.isActive = false
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("SE ACERCARA AL BANCO")){
			cliente.isActive = false
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("TIENE VARIAS TARJETAS")){
			cliente.isActive = false
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("YA ACCEDIO AL PRODUCTO")){
			cliente.isActive = false
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("MONTO O CUPO MUY BAJO - NO LE INTERESA")){
			cliente.isActive = false
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("TIENE OTRAS MEJORES PROPUESTAS DE CREDITO")){
			cliente.isActive = false
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("PREFIERE INCREMENTO DE CUPO O CUPO BAJO")){
			cliente.isActive = false
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("YA TUVO EL PRODUCTO")){
			cliente.isActive = false
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("CLIENTE RESIDE EN CANTON SIN COBERTURA DEL CANAL EXTERNO")){
			cliente.isActive = false
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("CLIENTE VIVE EN EL EXTERIOR")){
			cliente.isActive = false
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("CLIENTE NO CUENTA CON DOCUMENTACIÓN HABILITANTE")){
			cliente.isActive = false
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("TITULAR FALLECIDO")){
			cliente.isActive = false
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("NÚMERO EQUIVOCADO")){
			cliente.isActive = false
		}
		if(objSubSubestadoGestion.name.equalsIgnoreCase("NÚMERO NO EXISTE")){
			cliente.isActive = false
		}

		cliente.estadoGestion = estadoGestion
		cliente.subestadoGestion = objSubestadoGestion
        if(estadoGestion == "CONTACTADO"){
            cliente.telefonoContactado = params.telefonoContactado
        }
			if(estadoGestion == "NO CONTACTADO"){
				cliente.telefonoContactado = ""
			}
		if (params.subSubStatus != ""){
			String nombreSubSubEstado = SubSubestado.findById(params.subSubStatus.toString().toLong()).name
			cliente.subSubEstado = nombreSubSubEstado
		}
		else
			cliente.subSubEstado = ""

		cliente.intentos = intentos+1
		cliente.fechaGestion = fechaActual
		cliente.usuario = usuario
		cliente.nombreVendedor = usuario.nombre
		cliente.isManagement = false
		cliente.observaciones = formatearTexto(params.observaciones.toString())
		cliente.save(flush: true)

		//Se guarda informacion en el historial
		Historial historial = new Historial()
		historial.cliente = Clientes.findById(cliente.id.toLong())
		historial.estadoGestion = cliente.estadoGestion
		historial.subestadoGestion = cliente.subestadoGestion
		historial.subSubEstado = cliente.subSubEstado
		historial.fechaGestion = fechaActual
		historial.intentos = cliente.intentos
		historial.nombreVendedor = cliente.nombreVendedor
		historial.observacionesGestion = cliente.observaciones.toString().toUpperCase()
		historial.usuario = cliente.usuario
		historial.duracionLlamada = tiempoLlamada
		historial.plataforma = cliente.plataforma
		historial.save(flush: true)
		redirect(uri: "/gestion/index")
		}
		else{
			render "Cliente ya se encuentra guardado como exitoso o ha sido dado de baja. Consulte con el Administrador. No se puede continuar ---> " + cliente.id
		}
	}

	private String formatearTexto(String entrada){
		return entrada.toUpperCase().replace('Ñ', 'N').replace('-', ' ').replace('Á', 'A').replace('É', 'E').replace('Í', 'I').replace('Ó', 'O').replace('Ú', 'U')
	}

	private String formateaDiaPago (String diaPago, String tipo){
		String[] datos = diaPago.trim().split('-')
		String dato1 = datos[0]
		String dato2 = datos[1]
		String salida = ""

		if (tipo.equalsIgnoreCase("1")){
			salida = dato1
		}
		if (tipo.equalsIgnoreCase("2")){
			salida = dato2
		}
		return salida
	}

	def retirarBase(){
		boolean updateRealizado = false
		int resultado = 0
		if(params.usuario != null && params.tipo != null && params.nombrebase != null){

			String desde = params.desde
			String hasta = params.hasta
			String sql = ""

			updateRealizado = true
			Usuario usuarioAdministrador = Usuario.findById(1)

			def subestados
			if(params.tipo != "RELLAMADAS"){
				 sql = "update Clientes set usuario = :usuario where (subSubEstado = 'INTERESADO A FUTURO' or subSubEstado = 'NO CONTESTA' or subSubEstado = 'CELULAR APAGADO' or subSubEstado = 'MENSAJE A TERCERO' or subSubEstado = 'LINEA AVERIADA' or subSubEstado = 'LINEA OCUPADA'  or subestadoGestion is null) and usuario != :usuario and isBaseActiva = true and plataforma != 'PURE CLOUD' "
			}else {
				sql = "update Clientes set usuario = :usuario where (subSubEstado = 'VOLVER A LLAMAR') and usuario != :usuario isBaseActiva = true and plataforma != 'PURE CLOUD' "
			}

			def condiciones = [usuario: usuarioAdministrador]
			String condicionUsuario = ""
			String condicionTipo = ""
			String condicionNombreBase = ""
			String condicionDesde = ""
			String condicionHasta = ""

			if(params.desde != ""){
				condicionDesde = " and cast(codigoAsignacion as integer) >= :desde"
				condiciones.put("desde", desde.toString().toInteger())
			}

			if(params.hasta != ""){
				condicionHasta = " and cast(codigoAsignacion as integer) <= :hasta"
				condiciones.put("hasta", hasta.toString().toInteger())
			}

			if(params.usuario != ""){
				Usuario usuarioVendedor = Usuario.findById(params.usuario)
				condicionUsuario = " and usuario = :vendedor"
				condiciones.put("vendedor", usuarioVendedor)
			}

			if(params.tipo != ""){
				if(params.tipo == "REGESTIONABLE" || params.tipo == "RELLAMADAS"){
					condicionTipo = " and intentos > 0"
				}
				if(params.tipo == "SIN GESTION"){
					condicionTipo = " and intentos = 0"
				}
			}

			if(params.nombrebase != ""){
				condicionNombreBase = " and nombreBase = :nombreBase"
				condiciones.put("nombreBase", params.nombrebase)
			}

			Util.saveLog(session.user.id, "Se ha retirado la base ${params.nombrebase}")

			resultado = Clientes.executeUpdate(sql+condicionUsuario+condicionTipo+condicionNombreBase+condicionDesde+condicionHasta, condiciones)

		}
		[updateRealizado: updateRealizado, resultado: resultado]
	}

	def retirarBaseNovedades(){
		boolean updateRealizado = false
		int resultado = 0
		if(params.usuario != null && params.tipo != null && params.nombrebase != null){

			String desde = params.desde
			String hasta = params.hasta
			String sql = ""

			updateRealizado = true
			Usuario usuarioAdministrador = Usuario.findById(1)

			def subestados
			if(params.tipo != "RELLAMADAS"){
				sql = "update ClientesNovedades set usuario = :usuario where (subSubEstado = 'INTERESADO A FUTURO' or subSubEstado = 'NO CONTESTA' or subSubEstado = 'CELULAR APAGADO' or subSubEstado = 'MENSAJE A TERCERO' or subSubEstado = 'LINEA AVERIADA' or subSubEstado = 'LINEA OCUPADA'  or subestadoGestion is null) and usuario != :usuario and isBaseActiva = true"
			}else {
				sql = "update ClientesNovedades set usuario = :usuario where (subSubEstado = 'VOLVER A LLAMAR') and usuario != :usuario and isBaseActiva = true"
			}
			def condiciones = [usuario: usuarioAdministrador]
			String condicionUsuario = ""
			String condicionTipo = ""
			String condicionNombreBase = ""
			String condicionDesde = ""
			String condicionHasta = ""

			if(params.desde != ""){
				condicionDesde = " and cast(codigoAsignacion as integer) >= :desde"
				condiciones.put("desde", desde.toString().toInteger())
			}

			if(params.hasta != ""){
				condicionHasta = " and cast(codigoAsignacion as integer) <= :hasta"
				condiciones.put("hasta", hasta.toString().toInteger())
			}

			if(params.usuario != ""){
				Usuario usuarioVendedor = Usuario.findById(params.usuario)
				condicionUsuario = " and usuario = :vendedor"
				condiciones.put("vendedor", usuarioVendedor)
			}

			if(params.tipo != ""){
				if(params.tipo == "REGESTIONABLE" || params.tipo == "RELLAMADAS"){
					condicionTipo = " and intentos > 0"
				}
				if(params.tipo == "SIN GESTION"){
					condicionTipo = " and intentos = 0"
				}
			}

			if(params.nombrebase != ""){
				condicionNombreBase = " and nombreBase = :nombreBase"
				condiciones.put("nombreBase", params.nombrebase)
			}

			Util.saveLog(session.user.id, "Se ha retirado la base ${params.nombrebase}")

			resultado = ClientesNovedades.executeUpdate(sql+condicionUsuario+condicionTipo+condicionNombreBase+condicionDesde+condicionHasta, condiciones)

		}
		[updateRealizado: updateRealizado, resultado: resultado]
	}

	def cargarBase(){

	}

	def saveFile(){
		String[] formFields = Clientes.getFields()
		def file = request.getFile('file')
		Cell[] cells
		String[] headers
		if(file.empty){
			flash.message = "Por favor selecciona un archivo"
		}else{
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder) //app directory
			File fileDest = new File(webrootDir,file.getOriginalFilename())
			if(fileDest.mkdirs()){
				println "directory created"
			}else{
				println "directory not created or already exists"
			}
			file.transferTo(fileDest)

			//Reading Excel
			String ext = FilenameUtils.getExtension(fileDest.path)
			if(ext.equalsIgnoreCase("xls")){
				try {
					WorkbookSettings ws = new WorkbookSettings()
					ws.setEncoding("Cp1252")
					Workbook workbook = Workbook.getWorkbook(fileDest, ws)
						Sheet sheet = workbook.getSheet(0)
						cells = sheet.getRow(0)
						workbook.close()
				}catch (IOException ex){
					flash.error = "Problemas al cargar el archivo"
					render(view: "cargarBase")
				}
				headers = new String[cells.length]
				for(int i = 0; i < cells.length; i++){
					headers[i] = cells[i].getContents()
				}
				render(view: "sortExcel", model: [headers: headers, formFields:formFields, filePath:fileDest.path])
			}else{
				flash.error = "El archivo debe ser una hoja de cálculo de Excel 97-2003"
				render(view: "cargarBase")
			}
		}
	}

	/**
	 * Status
	 * @return
	 */
	def getSubStatusByStatus(){
		if(params.id) {
			def status = Estado.findById(params.id)
			def subStatus = Subestado.findAllByEstado(status)
			def array = [subStatus.id, subStatus.nombre, subStatus.type, subStatus.enableManagement]
			render array as JSON
		}
	}

	/**
	 *
	 */


	/**
	 * make by someone
	 * @param value
	 * @return
	 */
	private removeSpecialCharacters(String value){
		if(value != null){
			while(true){
				if(value.indexOf("  ") >= 0){
					value = value.replace("  ", " ")
				}else{
					break
				}
			}

			def newValue = value.toUpperCase().replace("!","").replace("@","").replace("\$","")
					.replace("&","").replace("(","").replace(")","").replace("=","")
					.replace("?","").replace("¿","").replace("ç","").replace("{","").replace("}","")
					.replace("\\","").replace("\"","").replace("Á","A").replace("É","E").replace("Í","I")
					.replace("Ó","O").replace("Ú","U").replace("\'","").replace("  "," ").replace("  "," ")
					.replace("  "," ").replace("%","").replace(",","").replace("º","")
					.replace("ª","").replace("|","").replace("\$","").replace("¬","").replace("%","")
					.replace("*","").replace("+","").replace("_","").replace("-", " ").replace("#", "").replace(".", "")
					.replace(",", "")

			return newValue
		}
	}

}
