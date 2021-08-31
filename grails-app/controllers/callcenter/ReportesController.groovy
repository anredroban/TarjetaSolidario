
package callcenter

import com.pw.security.*
import jxl.Workbook

//import javafx.scene.control.Cell
import jxl.WorkbookSettings
import jxl.format.*
import jxl.write.WritableFont
import jxl.write.WritableSheet
import jxl.write.WritableWorkbook
import utilitarios.ExcelUtils
import utilitarios.Util

import java.text.DecimalFormat

//import pl.touk.excel.export.WebXlsxExporter

class ReportesController {

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

	def baseGestionada(){
		if(params.fechas){
			Date[] fechas = Util.formatearFechasReporte(params.fechas.toString())
			def nombresBase = params.list("nombreBase")
			def subestados = params.list("subestados")
			def condiciones = [fechaInicio: fechas[0], fechaFin: fechas[1], nombresBase: nombresBase, subestados: subestados]
			String sql = "from Clientes where fechaGestion between :fechaInicio and :fechaFin and nombreBase in (:nombresBase) and subestadoGestion.nombre in (:subestados)"
			def base = Clientes.executeQuery(sql, condiciones)

			//Empezamos a crear y llenar el Excel
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder)
			File file = new File(webrootDir, "temporal.xls")
			WorkbookSettings workbookSettings = new WorkbookSettings()
			workbookSettings.setLocale(new Locale("es", "ES"))
			workbookSettings.setEncoding("Cp1252")
			WritableWorkbook workbook = Workbook.createWorkbook(file, workbookSettings)
			workbook.createSheet("baseGestionada", 0)
			WritableSheet sheet = workbook.getSheet(0)
			String[] headers = [
					"CEDULA",
					"NOMBRES COMPLETOS ",
					"CIUDAD",
					"ESTADO GESTION",
					"SUBESTADOGESTION",
					"SUBSUBESTADO",
					"FECHA GESTION",
					"OBSERVACIONES",
					"ULTIMO TELEFONO CONTACTADO",
					"NOMBRE VENDEDOR",
					"NOMBRE BASE",
					"SEGURO DESGRAVAMEN",
					"PLAN CONMIGO"
			]
			ExcelUtils.addCells(headers, sheet, 0, Colour.GRAY_25, Alignment.LEFT, VerticalAlignment.CENTRE, null, Border.ALL, BorderLineStyle.HAIR)
			for(int i = 0; i < base.size(); i++){
				String[] campos = new String[headers.length]
				Clientes c = base.get(i)
				campos[0] = c.identificacion
				campos[1] = c.apellidoPaterno + ' ' + c.apellidoMaterno + ' ' + c.primerNombre + ' ' + c.segundoNombre
				campos[2] = c.ciudadTrabajo
				campos[3] = c.estadoGestion
				campos[4] = c.subestadoGestion.nombre
				campos[5] = c.subSubEstado
				campos[6] = c.fechaGestion.toString()
				campos[7] = c.observaciones
				campos[8] = c.telefonoContactado
				campos[9] = c.nombreVendedor
				campos[10] = c.nombreBase
				campos[11] = c.seguroDesgravamen
				campos[12] = c.aceptaPlanConmigo

				ExcelUtils.addCells(campos, sheet, i+1, Colour.WHITE, Alignment.LEFT, VerticalAlignment.CENTRE, null, null, null)
			}
			workbook.write()
			workbook.close()
			response.setHeader("Content-disposition", "filename=baseGestionadaTarjetasAustro.xls")
			response.setContentType("application/octet-stream")
			response.outputStream << file.getBytes()
			return

		}
	}

	/**
	 * @author Andres Redroban
	 * Genera archivo de ventas gestionadas para el envio al SFTP de Banco Solidario
	 * @param
	 * @return
	 */

	def bitacoraPrincipales(){
		if(params.fechaInicio && params.fechaFin){

			//Obtenemos los datos
			Date fechaInicio = new Date().parse('yyyy-MM-dd HH:mm:ss', params.fechaInicio.toString().replace('/','-') + ':00')
			Date fechaFin = new Date().parse('yyyy-MM-dd HH:mm:ss', params.fechaFin.toString().replace('/','-') + ':59')
			String fechaActual = new Date().format('yyyyMMdd')
			ArrayList<SubSubestado> subestados = Subestado.executeQuery("from Subestado where id in (1)")
			def nombresBase = params.list("nombreBase")
			def condiciones = [fechaInicio: fechaInicio, fechaFin: fechaFin, subestados: subestados]
			String sqlPrincipales = "from Clientes where fechaGestion between :fechaInicio and :fechaFin and subestadoGestion in (:subestados) and subSubEstado = 'VENTA' order by fechaGestion"
			def principalesList = Clientes.executeQuery(sqlPrincipales, condiciones)


			//Empezamos a crear y llenar el Excel
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder)
			File file = new File(webrootDir, "temporal.xls")
			WorkbookSettings workbookSettings = new WorkbookSettings()
			workbookSettings.setLocale(new Locale("es", "ES"))
			workbookSettings.setEncoding("UTF-8")
			WritableWorkbook workbook = Workbook.createWorkbook(file)
			workbook.createSheet("Clientes Efectivos", 0)
			WritableSheet sheetPrincipales = workbook.getSheet(0)
			String[] headersPrincipales = ["CODIGO MARCA", "CODIGO EMISOR", "CODIGO BIN", "CODIGO AFINIDAD", "TIPO IDENTIFICACION", "IDENTIFICACION", "PRIMER APELLIDO",
										   "SEGUNDO APELLIDO", "PRIMER NOMBRE", "SEGUNDO NOMBRE", "NOMBRE PLASTICO", "UBICACION GEOGRAFICA 1",
										   "UBICACION GEOGRAFICA 2", "UBICACION GEOGRAFICA 3", "UBICACION GEOGRAFICA 4", "CALLE PRINCIPAL", "NUMERO",
										   "TRANSVERSAL", "REFERENCIA", "TELEFONO 1", "TELEFONO 2", "CELULAR", "LUGAR ENTREGA TARJETA",
										   "FECHA ENTREGA TARJETA", "HORA APROXIMADA", "OBSERVACION", "CODIGO ASESOR"]
			for (int i = 0; i < principalesList.size(); i++){
				String[] campos = new String[headersPrincipales.length]
				Clientes princ = principalesList.get(i)
				campos[0] = "ALIA"
				campos[1] = "SOLIDARIO"
				campos[2] = "505874"
				campos[3] = "03"
				campos[4] = "CED"
				campos[5] = princ.identificacion
				campos[6] = princ.apellidoPaterno
				campos[7] = princ.apellidoMaterno
				campos[8] = princ.primerNombre
				campos[9] = princ.segundoNombre
				campos[10] = princ.nombreImpreso
				if (princ.lugarEntrega.toString().equalsIgnoreCase("DOMICILIO")){
					campos[11] = princ.ubicacionProvinciaDomicilio
					campos[12] = princ.ubicacionCantonDomicilio
					campos[13] = princ.ubicacionParroquiaDomicilio
					campos[14] = princ.ubicacionBarrioDomicilio
					campos[15] = princ.callePrincipalDomicilio
					campos[16] = princ.numeracionDomicilio
					campos[17] = princ.calletransversalDomicilio
					campos[18] = princ.referenciaDomicilio
				}else{
					campos[11] = princ.ubicacionProvinciaTrabajo
					campos[12] = princ.ubicacionCantonTrabajo
					campos[13] = princ.ubicacionParroquiaTrabajo
					campos[14] = princ.ubicacionBarrioTrabajo
					campos[15] = princ.callePrincipalTrabajo
					campos[16] = princ.numeracionTrabajo
					campos[17] = princ.calletransversalTrabajo
					campos[18] = princ.referenciaTrabajo
				}
				campos[19] = princ.telefonoPrincipalGestion //Telefono principal
				campos[20] = princ.telefonoSecundarioGestion // Telefono Secundario
				campos[21] = princ.telefonoCelularGestion // Telefono Celular
				campos[22] = princ.lugarEntrega
				campos[23] = princ.fechaEntrega.toString().substring(0,10).replace("-","")
				campos[24] = princ.horarioEntrega
				campos[25] = princ.horarioEntrega
				campos[26] = "21713"
				ExcelUtils.addCells(campos, sheetPrincipales, i, Colour.WHITE, Alignment.LEFT, VerticalAlignment.CENTRE, null, null, null)
			}
			workbook.write()
			workbook.close()
			response.setHeader("Content-disposition", "filename=GestionadasFUENTEPLUSWIRELE"+fechaActual+".xls")
			response.setContentType("application/octet-stream")
			response.outputStream << file.getBytes()
			return
		}
	}

	def bitacoraPrincipales2(){
		if(params.fechaInicio && params.fechaFin){

			//Obtenemos los datos
			Date fechaInicio = new Date().parse('yyyy-MM-dd HH:mm:ss', params.fechaInicio.toString().replace('/','-') + ':00')
			Date fechaFin = new Date().parse('yyyy-MM-dd HH:mm:ss', params.fechaFin.toString().replace('/','-') + ':59')
			String fechaActual = new Date().format('yyyyMMdd')
			ArrayList<SubSubestado> subestados = Subestado.executeQuery("from Subestado where id in (1)")
			def nombresBase = params.list("nombreBase")
			def condiciones = [fechaInicio: fechaInicio, fechaFin: fechaFin, subestados: subestados, nombresBase: nombresBase]
			String sqlPrincipales = "from Clientes where fechaGestion between :fechaInicio and :fechaFin and subestadoGestion in (:subestados) and subSubEstado = 'VENTA'  and nombreBase in (:nombresBase) order by fechaGestion"
			def principalesList = Clientes.executeQuery(sqlPrincipales, condiciones)


			//Empezamos a crear y llenar el archivo TXT
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder)
			File file = new File(webrootDir, "temporal.txt")
			file.delete()
			for (int i = 0; i < principalesList.size(); i++){
				String campos = ""
				Clientes princ = principalesList.get(i)
				campos += "ALIA" + "    "
				campos += "SOLIDARIO" + "    "
				campos += "505874" + "    "
				campos += "03" + "    "
				campos += "CED" + "    "
				campos += princ.identificacion + "    "
				campos += princ.apellidoPaterno + "    "
				campos += princ.apellidoMaterno + "    "
				campos += princ.primerNombre + "    "
				campos += princ.segundoNombre + "    "
				campos += princ.nombreImpreso + "    "
				if (princ.lugarEntrega.toString().equalsIgnoreCase("DOMICILIO")){
					campos += princ.ubicacionProvinciaDomicilio + "    "
					campos += princ.ubicacionCantonDomicilio + "    "
					campos += princ.ubicacionParroquiaDomicilio + "    "
					campos += princ.ubicacionBarrioDomicilio + "    "
					campos += princ.callePrincipalDomicilio + "    "
					campos += princ.numeracionDomicilio + "    "
					campos += princ.calletransversalDomicilio + "    "
					campos += princ.referenciaDomicilio + "    "
				}else{
					campos += princ.ubicacionProvinciaTrabajo + "    "
					campos += princ.ubicacionCantonTrabajo + "    "
					campos += princ.ubicacionParroquiaTrabajo + "    "
					campos += princ.ubicacionBarrioTrabajo + "    "
					campos += princ.callePrincipalTrabajo + "    "
					campos += princ.numeracionTrabajo + "    "
					campos += princ.calletransversalTrabajo + "    "
					campos += princ.referenciaTrabajo + "    "
				}
				campos += princ.telefonoPrincipalGestion + "    "  //Telefono Principal
				campos += princ.telefonoSecundarioGestion + "    " //Telefono Secundario
				campos += princ.telefonoCelularGestion + "    " //Telefono Celular
				campos += princ.lugarEntrega + "    "
				campos += princ.fechaEntrega.toString().substring(0,10).replace("-","") + "    "
				campos += princ.horarioEntrega + "    "
				campos += princ.horarioEntrega + "    "
				campos += "21713" + "    "
				campos += "\r\n"
				file.append(campos)
			}
			response.setHeader("Content-disposition", "filename=GestionadasFUENTEPLUSWIRELE"+fechaActual+".txt")
			response.setContentType("application/octet-stream")
			response.outputStream << file.getBytes()
			return
		}
	}

	/**
	 * @author Andres Redroban
	 * Genera archivo para generacion y envio de tarjetas de parte de Courier
	 * @param
	 * @return
	 */


	def bitacoraCourier(){
		if(params.fechaInicio && params.fechaFin){

			//Obtenemos los datos
			Date fechaInicio = new Date().parse('yyyy-MM-dd HH:mm:ss', params.fechaInicio.toString().replace('/','-') + ':00')
			Date fechaFin = new Date().parse('yyyy-MM-dd HH:mm:ss', params.fechaFin.toString().replace('/','-') + ':59')
			ArrayList<SubSubestado> subestados = Subestado.executeQuery("from Subestado where id in (1)")
			def nombresBase = params.list("nombreBase")
			def condiciones = [fechaInicio: fechaInicio, fechaFin: fechaFin, subestados: subestados, nombresBase: nombresBase]
			String sqlPrincipales = "from Clientes where fechaGestion between :fechaInicio and :fechaFin and subestadoGestion in (:subestados) and subSubEstado = 'VENTA'  and nombreBase in (:nombresBase) order by fechaGestion"
			def principalesList = Clientes.executeQuery(sqlPrincipales, condiciones)

			//Empezamos a crear y llenar el Excel
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder)
			File file = new File(webrootDir, "temporal.xls")
			WorkbookSettings workbookSettings = new WorkbookSettings()
			workbookSettings.setLocale(new Locale("es", "ES"))
			workbookSettings.setEncoding("UTF-8")
			WritableWorkbook workbook = Workbook.createWorkbook(file)
			workbook.createSheet("Clientes Efectivos", 0)
			WritableFont cellFont = new WritableFont(WritableFont.createFont("Calibri"), 11, WritableFont.BOLD)
			WritableFont cellFont2 = new WritableFont(WritableFont.createFont("Calibri"), 11)
			WritableSheet sheetPrincipales = workbook.getSheet(0)
			String[] headersPrincipales = ["CEDULA", "NOMBRES COMPLETOS", "CIUDAD DOMICILIO", "CIUDAD TRABAJO", "DIRECCION DOMICILIO", "REFERENCIA UBICACION DOMICILIO", "DIRECCION TRABAJO", "REFERENCIA UBICACION TRABAJO", "LUGAR ENTREGA", "NOMBRES REFERENCIA 1", "TELEFONO REFERENCIA 1",
										   "CELULAR REFERENCIA 1","NOMBRES REFERENCIA 2", "TELEFONO REFERENCIA 2", "CELULAR REFERENCIA 2", "TELEFONO TRABAJO", "TELEFONO CONTACTADO", "CELULAR SMS", "TELÉFONO PRINCIPAL BASE",
										   "TELEFONO SECUNDARIO BASE", "TELEFONO TRABAJO BASE", "TELEFONO CELULAR BASE", "TELEFONO PRINCIPAL GESTION", "TELEFONO SECUNDARIO GESTION", "TELEFONO TRABAJO GESTION", "TELEFONO CELULAR GESTION"]
			ExcelUtils.addCells(headersPrincipales, sheetPrincipales, 0, Colour.ICE_BLUE, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont, Border.ALL, BorderLineStyle.THIN)

			for (int i = 0; i < principalesList.size(); i++){
				String[] campos = new String[headersPrincipales.length]
				Clientes princ = principalesList.get(i)
				campos[0] = princ.identificacion
				campos[1] = princ.apellidoPaterno + ' ' + princ.apellidoMaterno + ' ' + princ.primerNombre + ' ' + princ.segundoNombre
				campos[2] = Ciudad.findByCodigoUbicacion(princ.ubicacionCantonDomicilio.toString()).nombre
				campos[3] = Ciudad.findByCodigoUbicacion(princ.ubicacionCantonTrabajo.toString()).nombre
				campos[4] = princ.callePrincipalDomicilio + ' ' + princ.numeracionDomicilio + ' ' + princ.calletransversalDomicilio
				campos[5] = princ.referenciaDomicilio
				campos[6] = princ.callePrincipalTrabajo + ' ' + princ.numeracionTrabajo + ' ' + princ.calletransversalTrabajo
				campos[7] = princ.referenciaTrabajo
				campos[8] = princ.lugarEntrega
				campos[9] = princ.apellido1RefPersonal + ' ' + princ.apellido2RefPersonal + ' ' + princ.nombre1RefPersonal + ' ' + princ.nombre2RefPersonal
				campos[10] = princ.telefonoRefPersonal
				campos[11] = princ.celularRefPersonal
				campos[12] = princ.apellido1RefPersonal2 + ' ' + princ.apellido2RefPersonal2 + ' ' + princ.nombre1RefPersonal2 + ' ' + princ.nombre2RefPersonal2
				campos[13] = princ.telefonoRefPersonal2
				campos[14] = princ.celularRefPersonal2
				campos[15] = princ.telefonoTrabajoGestion
				campos[16] = princ.telefonoContactado
				campos[17] = princ.celularSms //TELÉFONO SMS
				campos[18] = princ.telefono2
				campos[19] = princ.telefono3
				campos[20] = princ.telefonoTrabajo
				campos[21] = princ.telefono1
				campos[22] = princ.telefonoPrincipalGestion //TELEFONO PRINCIPAL GESTION
				campos[23] = princ.telefonoSecundarioGestion //TELEFONO SECUNDARIO GESTION
				campos[24] = princ.telefonoTrabajo  //TELEFONO TRABAJO GESTION
				campos[25] = princ.telefonoCelularGestion //TELEFONO CELULAR GESTION
				ExcelUtils.addCells(campos, sheetPrincipales, i+1, Colour.WHITE, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont2, null, null)
			}
			workbook.write()
			workbook.close()
			response.setHeader("Content-disposition", "filename=Bitacora_Courier.xls")
			response.setContentType("application/octet-stream")
			response.outputStream << file.getBytes()
			return
		}
	}
	/**
	 * @author Andres Redroban
	 * Genera archivo para impresión de solicitudes de Tarjetas
	 * @param
	 * @return
	 */

	def bitacoraSolicitudes(){
		if(params.fechaInicio && params.fechaFin) {

			//Obtenemos los datos
			Date fechaInicio = new Date().parse('yyyy-MM-dd HH:mm:ss', params.fechaInicio.toString().replace('/', '-') + ':00')
			Date fechaFin = new Date().parse('yyyy-MM-dd HH:mm:ss', params.fechaFin.toString().replace('/', '-') + ':59')
			String fechaActual = new Date().format('yyyyMMdd')
			ArrayList<SubSubestado> subestados = Subestado.executeQuery("from Subestado where id in (1)")
			def nombresBase = params.list("nombreBase")
			def condiciones = [fechaInicio: fechaInicio, fechaFin: fechaFin, subestados: subestados]
			String sqlPrincipales = "from Clientes where fechaGestion between :fechaInicio and :fechaFin and subestadoGestion in (:subestados) and subSubEstado = 'VENTA' order by fechaGestion"
			def principalesList = Clientes.executeQuery(sqlPrincipales, condiciones)

			String nombre1_ref_2
			String nombre2_ref_2

			//Empezamos a crear y llenar el Excel
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder)
			File file = new File(webrootDir, "temporal.xls")
			WorkbookSettings workbookSettings = new WorkbookSettings()
			workbookSettings.setLocale(new Locale("es", "ES"))
			workbookSettings.setEncoding("UTF-8")
			WritableWorkbook workbook = Workbook.createWorkbook(file)
			WritableFont cellFont = new WritableFont(WritableFont.TAHOMA, 10)
			WritableFont cellFont2 = new WritableFont(WritableFont.createFont("Calibri"), 11)
			workbook.createSheet("Clientes Efectivos", 0)
			WritableSheet sheetPrincipales = workbook.getSheet(0)
			String[] headersPrincipales = ["fecha_gestion", "lugar_entregaecuenta", "email_estado_cuenta", "cedula", "apellido_paterno", "apellido_materno", "nombres", "nombres_completos",
										   "genero", "estado_civil", "fecha_nacimiento", "cargas_familiares", "nivel_estudios", "profesion", "tipo_documento_conyugue",
										   "identificacion_conyuge", "apellido1conyuge", "apellido2conyuge", "nombres_conyugue", "provincia_domicilio", "canton_domicilio",
										   "parroquia_domicilio", "barrio_domicilio", "numeracion_domicilio", "referencia_domicilio", "calle_principal_domicilio", "calletransversal_domicilio",
										   "tipo_vivienda", "avaluo", "telefono_principal", "telefono_celular", "email", "origen_ingresos", "ruc_empresa", "nombre_labora", "fecha_ingreso",
										   "cargo", "provincia_trabajo", "ciudad_trabajo", "parroquia_trabajo", "barrio_trabajo", "numeracion_trabajo", "referencia_trabajo", "calle_principal_trabajo",
										   "calletransversal_trabajo", "telefono_trabajo", "apellido1ref_personal", "apellido2ref_personal", "nombres_referencia", "telefono_ref_personal", "celular_ref_personal",
					                       "apellido1ref_personal_2", "apellido2ref_personal_2", "nombres_referencia_2", "telefono_ref_personal_2", "celular_ref_personal_2",
										   "ingresos_personales", "rentas", "remesas", "ingreso_familiares", "otros_ingresos", "alimentacion", "servicios_basicos", "transporte", "otros_gastos",
										   "descripcion_activo", "valor_unitario_bien", "institucion_pasivo", "fecha_emision_pasivo", "valor_cuota_pasivo", "plazo_pasivo", "saldo_pasivo", "telefono_contactado", "mes_gestion", "nombre_vendedor",
			                               "seguro_desgravamen", "acepta_plan_conmigo","dia_fecha_corte","dia_fecha_pago", "lugar_entrega_tarjeta", "horario_entrega_tarjeta", "fecha_hora_entrega",
			 								"creadas_nocreadas", "imputable", "detalle_imputable", "fecha_envio_creacion", "status_courier", "ciclo_courier", "telefono_contactado", "guia_courier"]
			ExcelUtils.addCells(headersPrincipales, sheetPrincipales, 0, Colour.LIGHT_ORANGE, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont, Border.ALL, BorderLineStyle.HAIR)
			for (int i = 0; i < principalesList.size(); i++) {
				String[] campos = new String[headersPrincipales.length]
				Clientes princ = principalesList.get(i)
				campos[0] = princ.fechaGestion.toString().substring(0, 11)
				campos[1] = princ.lugarEntregaECuenta
				if (princ.lugarEntregaECuenta.toString().equalsIgnoreCase("DIGITAL")){
					campos[2] = princ.emailEstadoCuenta
				}else{
					campos[2] = ""
				}
				campos[3] = princ.identificacion
				campos[4] = princ.apellidoPaterno
				campos[5] = princ.apellidoMaterno
				campos[6] = princ.primerNombre + ' ' + princ.segundoNombre
				campos[7] = princ.apellidoPaterno + ' ' + princ.apellidoMaterno + ' ' + princ.primerNombre + ' ' + princ.segundoNombre
				campos[8] = princ.genero
				campos[9] = princ.estadoCivil
				campos[10] = princ.fechaNacimientoGestion
				campos[11] = princ.cargasFamiliares
				campos[12] = princ.nivelEstudios
				campos[13] = princ.profesion
				campos[14] = "CEDULA"
				if (princ.identificacionConyuge != null){
					campos[15] = princ.identificacionConyuge
				}else{
					campos[15] = ""
				}
				if (princ.apellido1Conyuge != null){
					campos[16] = princ.apellido1Conyuge
				}else{
					campos[16] = ""
				}
				if (princ.apellido2Conyuge != null){
					campos[17] = princ.apellido2Conyuge
				}else{
					campos[17] = ""
				}
				campos[18] = princ.nombre1Conyuge + ' ' + princ.nombre2Conyuge
				campos[19] = Provincia.findById(princ.ubicacionProvinciaDomicilio.toString().toLong()).nombre
				campos[20] = Ciudad.findByCodigoUbicacion(princ.ubicacionCantonDomicilio.toString()).nombre
				campos[21] = Parroquia.findByCodigoUbicacion(princ.ubicacionParroquiaDomicilio.toString()).nombre
				if(princ.barrioNoDefinidoDomicilio != ""){
					campos[22] = princ.barrioNoDefinidoDomicilio
				}else{
					campos[22] = Barrio.findByCodigoUbicacion(princ.ubicacionBarrioDomicilio.toString()).nombre
				}
				campos[23] = princ.numeracionDomicilio
				campos[24] = princ.referenciaDomicilio
				campos[25] = princ.callePrincipalDomicilio
				campos[26] = princ.calletransversalDomicilio
				campos[27] = princ.tipoVivienda
				campos[28] = princ.valorVivienda
				campos[29] = princ.telefonoPrincipalGestion //TELEFONO PRINCIPAL
				campos[30] = princ.telefonoCelularGestion //TELEFONO CELULAR
				campos[31] = princ.emailPersonal
				campos[32] = princ.origenIngresos
				campos[33] = princ.rucEmpresa
				campos[34] = princ.nombreLabora
				campos[35] = princ.fechaIngreso
				campos[36] = princ.cargo
				campos[37] = Provincia.findById(princ.ubicacionProvinciaTrabajo.toString().toLong()).nombre
				campos[38] = Ciudad.findByCodigoUbicacion(princ.ubicacionCantonTrabajo.toString()).nombre
				campos[39] = Parroquia.findByCodigoUbicacion(princ.ubicacionParroquiaTrabajo.toString()).nombre
				if(princ.barrioNoDefinidoTrabajo != ""){
					campos[40] = princ.barrioNoDefinidoTrabajo
				}else{
					campos[40] = Barrio.findByCodigoUbicacion(princ.ubicacionBarrioTrabajo.toString()).nombre
				}
				campos[41] = princ.numeracionTrabajo
				campos[42] = princ.referenciaTrabajo
				campos[43] = princ.callePrincipalTrabajo
				campos[44] = princ.calletransversalTrabajo
				campos[45] = princ.telefonoTrabajoGestion
				campos[46] = princ.apellido1RefPersonal
				campos[47] = princ.apellido2RefPersonal
				if (princ.nombre1RefPersonal != null){
					nombre1_ref_2 = princ.nombre1RefPersonal
				}else{
					nombre1_ref_2 = " "
				}
				if (princ.nombre2RefPersonal != null){
					nombre2_ref_2 =  princ.nombre2RefPersonal
				}else{
					nombre2_ref_2 = " "
				}
				campos[48] = nombre1_ref_2.toString() + ' ' + nombre2_ref_2.toString()
				campos[49] = princ.telefonoRefPersonal
				campos[50] = princ.celularRefPersonal // Celular de referencia personal
				campos[51] = princ.apellido1RefPersonal2
				campos[52] = princ.apellido2RefPersonal2
				campos[53] = princ.nombre1RefPersonal2 + ' ' + princ.nombre2RefPersonal2
				campos[54] = princ.telefonoRefPersonal2
				campos[55] = princ.celularRefPersonal2 // Campo utilizado para guardar el celular de la referencia personal 2 del cliente
				campos[56] = princ.sueldoIngresos
				campos[57] = princ.rentas
				campos[58] = princ.remesas
				campos[59] = princ.ingresoFamiliares
				campos[60] = princ.otrosIngresos
				campos[61] = princ.gastosBasicos
				campos[62] = princ.serviciosBasicos
				campos[63] = princ.transporte
				campos[64] = princ.otrosGastos
				campos[65] = princ.activoBien
				campos[66] = princ.valorUnitarioBien
				campos[67] = princ.institucionPasivo
				campos[68] = princ.fechaEmisionPasivo
				campos[69] = princ.valorCuotaPasivo
				campos[70] = princ.plazoPasivo
				campos[71] = princ.saldoPasivo
				campos[72] = princ.telefonoContactado
				campos[73] = princ.mesCargaBase
                campos[74] = princ.nombreVendedor.toUpperCase()
				campos[75] = princ.seguroDesgravamen
				campos[76] = princ.aceptaPlanConmigo // acepta plan conmigo
				campos[77] = princ.diaFechaCorte // acepta plan conmigo
				campos[78] = princ.diaFechaPago // acepta plan conmigo
				campos[79] = princ.lugarEntrega // acepta plan conmigo
				campos[80] = princ.horarioEntrega // acepta plan conmigo
				campos[81] = princ.fechaEntrega.toString() // acepta plan conmigo
				campos[82] = princ.creadas_nocreadas
				campos[83] = princ.imputable
				campos[84] = princ.detalle_imputable
				campos[85] = princ.fecha_envio_creacion
				campos[86] = princ.status_courier
				campos[87] = princ.ciclo_courier
				campos[88] = princ.telefonoContactado
				campos[89] = princ.guia_courier
				ExcelUtils.addCells(campos, sheetPrincipales, i+1, Colour.WHITE, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont2, null, null)
			}
			workbook.write()
			workbook.close()
			response.setHeader("Content-disposition", "filename=Ventas_Tarjetas_Solidario"+fechaActual+".xls")
			response.setContentType("application/octet-stream")
			response.outputStream << file.getBytes()
			return
		}
	}

	/**
	 * @author Andres Redroban
	 * Genera archivo de Ventas Diarias de Tarjetas
	 * @param
	 * @return
	 */

	def bitacoraVentas(){
		if(params.fechaInicio && params.fechaFin){

			//Obtenemos los datos
			Date fechaInicio = new Date().parse('yyyy-MM-dd HH:mm:ss', params.fechaInicio.toString().replace('/','-') + ':00')
			Date fechaFin = new Date().parse('yyyy-MM-dd HH:mm:ss', params.fechaFin.toString().replace('/','-') + ':59')
			String fechaActual = new Date().format('yyyyMMdd')
			ArrayList<SubSubestado> subestados = Subestado.executeQuery("from Subestado where id in (1)")
			def nombresBase = params.list("nombreBase")
			def condiciones = [fechaInicio: fechaInicio, fechaFin: fechaFin]
			String sqlPrincipales = "from Clientes where fechaGestion between :fechaInicio and :fechaFin and subSubEstado = 'VENTA' order by fechaGestion"
			def principalesList = Clientes.executeQuery(sqlPrincipales, condiciones)

			//Empezamos a crear y llenar el Excel
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder)
			File file = new File(webrootDir, "temporal.xls")
			WorkbookSettings workbookSettings = new WorkbookSettings()
			workbookSettings.setLocale(new Locale("es", "ES"))
			workbookSettings.setEncoding("UTF-8")
			WritableWorkbook workbook = Workbook.createWorkbook(file)
			workbook.createSheet("Clientes Efectivos", 0)
			WritableFont cellFont = new WritableFont(WritableFont.createFont("Calibri"), 11, WritableFont.BOLD)
			WritableFont cellFont2 = new WritableFont(WritableFont.createFont("Calibri"), 11)
			WritableSheet sheetPrincipales = workbook.getSheet(0)
			String[] headersPrincipales = ["CEDULA", "NOMBRES COMPLETOS", "TELEFONO CONTACTADO", "CORREO", "CELULAR SMS"]
			ExcelUtils.addCells(headersPrincipales, sheetPrincipales, 0, Colour.GOLD, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont, Border.ALL, BorderLineStyle.THIN)

			for (int i = 0; i < principalesList.size(); i++){
				String[] campos = new String[headersPrincipales.length]
				Clientes princ = principalesList.get(i)
				campos[0] = princ.identificacion
				campos[1] = princ.apellidoPaterno + ' ' + princ.apellidoMaterno + ' ' + princ.primerNombre + ' ' + princ.segundoNombre
				campos[2] = princ.telefonoContactado
				campos[3] = princ.emailPersonal
				campos[4] = princ.celularSms //CELULAR SMS
				ExcelUtils.addCells(campos, sheetPrincipales, i+1, Colour.WHITE, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont2, null, null)
			}
			workbook.write()
			workbook.close()
			response.setHeader("Content-disposition", "filename=VENTAS"+fechaActual+".xls")
			response.setContentType("application/octet-stream")
			response.outputStream << file.getBytes()
			return
		}
	}

	def bitacoraPlanificacion(){
		if(params.fechas){

			//Obtenemos los datos
			Date[] fechas = Util.formatearFechasReporte(params.fechas.toString())
			ArrayList<SubSubestado> subestados = Subestado.findAllByEnableManagement(true)
			def nombresBase = params.list("nombreBase")
			def condiciones = [fechaInicio: fechas[0], fechaFin: fechas[1], subestados: subestados]
			String sql = "from Clientes a where fechaGestion between :fechaInicio and :fechaFin and subestadoGestion in (:subestados)"
			def clientesList = Clientes.executeQuery(sql, condiciones)
			int secuencial = 1
			//Empezamos a crear y llenar el Excel
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder)
			File file = new File(webrootDir, "temporal.xls")
			WorkbookSettings workbookSettings = new WorkbookSettings()
			workbookSettings.setLocale(new Locale("es", "ES"))
			workbookSettings.setEncoding("Cp1252")
			WritableWorkbook workbook = Workbook.createWorkbook(file, workbookSettings)
			workbook.createSheet("BitacoraAdicionales", 0)
			WritableFont cellFont = new WritableFont(WritableFont.createFont("Calibri"), 11, WritableFont.BOLD)
			WritableFont cellFont2 = new WritableFont(WritableFont.createFont("Calibri"), 11)
			WritableSheet sheet = workbook.getSheet(0)
			String[] headers = ['CEDULA',	'NOMBRES',	'APELLIDOS',	'NOMBRES Y APELLIDOS',	'PROVINCIA DOMICILIO',
								'CIUDAD DOMICILIO',	'PARROQUIA DOMICILIO',	'CLL P DOMICILIO',	'NEMERACION',
								'CALL SEUNDARIA',	'REEERENCIAS',	'DIRECCION COMPLETA DOMICILIO',
								'PROVINCIA TRABAJO',	'CIUDAD TRABAJO',	'PARROQUIA TRABAJO',
								'CLL P TRABAJO',	'NEMERACION',	'CALL SEUNDARIA',	'REEERENCIAS',
								'DIRECCION COMPLETA TRABAJO',	'TELEFONO CONTACTADO',	'TELEFONO REFERENCIA',
								'TELEFONO 1',	'TELEFONO 2',	'TELEFONO 3',	'TELEFONO 4',	'TELEFONO 5',
								'TELEFONO 6',	'TELEFONO 7',	'TELEFONO 8',	'TELEFONO 9',	'TELEFONO 10',
								'ID CLIENTE',	'FECHA GESTION',	'CREADAS NO CREADAS',	'IMPUTABLE',
								'DETALLE IMPUTABLE',	'FECHA ENVIO CREACION',	'NOMBRE DE LA BASE',	'LOTE',
								'CODIGO CAMPANIA',	'STATUS COURIER',	'CICLO COURIER',	'CIERRE DE CICLO',
								'GUIA COURIER',	' CEDULA TITULAR']
			ExcelUtils.addCells(headers, sheet, 0, Colour.GOLD, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont, Border.ALL, BorderLineStyle.HAIR)
			for(int i = 0; i < clientesList.size(); i++){
				String[] campos = new String[headers.length]
				Clientes cli = clientesList.get(i)
				campos[0] = cli.identificacion
				campos[1] = cli.primerNombre + ' ' + cli.segundoNombre
				campos[2] = cli.apellidoPaterno + ' ' + cli.apellidoMaterno
				campos[3] = cli.apellidoPaterno + ' ' + cli.apellidoMaterno + ' ' + cli.primerNombre + ' ' + cli.segundoNombre
				campos[4] = cli.provinciaDomicilio
				campos[5] = cli.ciudadDomicilio
				campos[6] = Parroquia.findByCodigoUbicacion(cli.ubicacionParroquiaDomicilio.toString()).nombre
				campos[7] = cli.callePrincipalDomicilio
				campos[8] = cli.numeracionDomicilio
				campos[9] = cli.calletransversalDomicilio
				campos[10] = cli.referenciaDomicilio
				campos[11] = cli.ciudadDomicilio + ' ' + Parroquia.findByCodigoUbicacion(cli.ubicacionParroquiaDomicilio.toString()).nombre + ' ' + cli.callePrincipalDomicilio + ' ' + cli.numeracionDomicilio + ' ' + cli.referenciaDomicilio
				campos[12] = Provincia.findById(cli.ubicacionProvinciaTrabajo.toString().toLong()).nombre
				campos[13] = Ciudad.findByCodigoUbicacion(cli.ubicacionCantonTrabajo.toString()).nombre
				campos[14] = Parroquia.findByCodigoUbicacion(cli.ubicacionParroquiaTrabajo.toString()).nombre
				campos[15] = cli.callePrincipalTrabajo
				campos[16] = cli.numeracionTrabajo
				campos[17] = cli.calletransversalTrabajo
				campos[18] = cli.referenciaTrabajo
				campos[19] = Ciudad.findByCodigoUbicacion(cli.ubicacionCantonTrabajo.toString()).nombre + ' ' + Parroquia.findByCodigoUbicacion(cli.ubicacionParroquiaTrabajo.toString()).nombre + ' ' + cli.callePrincipalTrabajo + ' ' + cli.numeracionTrabajo + ' ' + cli.referenciaTrabajo
				campos[20] = cli.telefonoContactado
				campos[21] = cli.telefonoRefPersonal
				campos[22] = cli.telefono1
				campos[23] = cli.telefono2
				campos[24] = cli.telefono3
				campos[25] = cli.telefono4
				campos[26] = cli.telefono5
				campos[27] = cli.telefono6
				campos[28] = cli.telefono7
				campos[29] = cli.telefono8
				campos[30] = cli.telefono9
				campos[31] = cli.telefono10
				campos[32] = cli.id
				campos[33] = cli.fechaGestion.toString()
				campos[34] = cli.creadas_nocreadas
				campos[35] = cli.imputable
				campos[36] = cli.detalle_imputable
				campos[37] = cli.fecha_envio_creacion
				campos[38] = cli.nombreBase
				campos[39] = "202"
				campos[40] = cli.codigoCampania
				campos[41] = cli.status_courier
				campos[42] = cli.ciclo_courier
				campos[43] = cli.cierre_ciclo
				campos[44] = cli.guia_courier
				campos[45] = cli.identificacion
				ExcelUtils.addCells(campos, sheet, i+1, Colour.WHITE, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont2, null, null)
			}

			workbook.write()
			workbook.close()
			response.setHeader("Content-disposition", "filename=BitacoraPlanificacionSolidario.xls")
			response.setContentType("application/octet-stream")
			response.outputStream << file.getBytes()
			return
		}
	}

	/**
	 * @author Andres Redroban
	 * Genera archivo para generacion y envio de tarjetas de parte de Courier
	 * @param
	 * @return
	 */
	def bitacoraCallTypes(){
		if(params.nombreBase){

			//Obtenemos los datos
			def nombresBase = params.list("nombreBase")
			def condiciones = [nombresBase: nombresBase]
			String sqlCallTypes = "from Clientes where nombreBase in (:nombresBase) order by subestadoGestion, subSubEstado"
			def principalesList = Clientes.executeQuery(sqlCallTypes, condiciones)

			//Empezamos a crear y llenar el Excel
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder)
			File file = new File(webrootDir, "temporal.xls")
			WorkbookSettings workbookSettings = new WorkbookSettings()
			workbookSettings.setLocale(new Locale("es", "ES"))
			workbookSettings.setEncoding("UTF-8")
			WritableWorkbook workbook = Workbook.createWorkbook(file)
			workbook.createSheet("Clientes Efectivos", 0)
			WritableFont cellFont = new WritableFont(WritableFont.createFont("Calibri"), 11, WritableFont.BOLD)
			WritableFont cellFont2 = new WritableFont(WritableFont.createFont("Calibri"), 11)
			WritableSheet sheetPrincipales = workbook.getSheet(0)
			String[] headersPrincipales = ["CEDULA", "CLIENTE", "NIVEL 1", "NIVEL 2", "NIVEL 3", "TELÉFONO CONTACTADO", "NÚMERO DE BARRIDOS", "FECHA ÚLTIMA GESTIÓN", "PROVINCIA",
										   "EJECUTIVO"]
			ExcelUtils.addCells(headersPrincipales, sheetPrincipales, 0, Colour.GOLD, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont, Border.ALL, BorderLineStyle.THIN)

			for (int i = 0; i < principalesList.size(); i++){
				String[] campos = new String[headersPrincipales.length]
				Clientes princ = principalesList.get(i)
				campos[0] = princ.identificacion
				campos[1] = princ.apellidoPaterno.toUpperCase() + ' ' + princ.apellidoMaterno.toUpperCase() + ' ' + princ.primerNombre.toUpperCase() + ' ' + princ.segundoNombre.toUpperCase()
				campos[2] = princ.estadoGestion
				if (princ.subestadoGestion == null){
					campos[3] = ""
				}else{
					campos[3] = princ.subestadoGestion.nombre//Subestado.findById(princ.subestadoGestion.toString().toLong()).nombre
				}
				campos[4] = princ.subSubEstado
				campos[5] = princ.telefonoContactado
				campos[6] = princ.intentos
				if (princ.fechaGestion == null){
					campos[7] = ""
				}else{
					campos[7] = princ.fechaGestion.toString().substring(0,10)
				}

				if(princ.ubicacionProvinciaDomicilio != null){
					campos[8] = Provincia.findById(princ.ubicacionProvinciaDomicilio.toString().toLong()).nombre

				}else {
					campos[8] = ""
				}
				campos[9] = princ.nombreVendedor.toUpperCase()
				ExcelUtils.addCells(campos, sheetPrincipales, i+1, Colour.WHITE, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont2, null, null)
			}
			workbook.write()
			workbook.close()
			response.setHeader("Content-disposition", "filename=Bitacora_CallTypes.xls")
			response.setContentType("application/octet-stream")
			response.outputStream << file.getBytes()
			return
		}
	}

	def bitacoraNovedades(){
		if(params.fechaInicio && params.fechaFin){

			//Obtenemos los datos
			Date fechaInicio = new Date().parse('yyyy-MM-dd HH:mm:ss', params.fechaInicio.toString().replace('/','-') + ':00')
			Date fechaFin = new Date().parse('yyyy-MM-dd HH:mm:ss', params.fechaFin.toString().replace('/','-') + ':59')
			ArrayList<SubSubestado> subestados = Subestado.executeQuery("from Subestado where id in (1)")
			def nombresBase = params.list("nombreBase")
			def condiciones = [fechaInicio: fechaInicio, fechaFin: fechaFin, subestados: subestados, nombresBase: nombresBase]
			String sqlPrincipales = "from ClientesNovedades where fechaGestion between :fechaInicio and :fechaFin and subestadoGestion in (:subestados) and subSubEstado = 'VENTA'  and nombreBase in (:nombresBase) order by fechaGestion"
			def principalesList = Clientes.executeQuery(sqlPrincipales, condiciones)

			//Empezamos a crear y llenar el Excel
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder)
			File file = new File(webrootDir, "temporal.xls")
			WorkbookSettings workbookSettings = new WorkbookSettings()
			workbookSettings.setLocale(new Locale("es", "ES"))
			workbookSettings.setEncoding("UTF-8")
			WritableWorkbook workbook = Workbook.createWorkbook(file)
			workbook.createSheet("Clientes Efectivos", 0)
			WritableFont cellFont = new WritableFont(WritableFont.createFont("Calibri"), 11, WritableFont.BOLD)
			WritableFont cellFont2 = new WritableFont(WritableFont.createFont("Calibri"), 11)
			WritableSheet sheetPrincipales = workbook.getSheet(0)
			String[] headersPrincipales = ["CEDULA", "NOMBRES COMPLETOS", "FECHA ENTREGA", "HORA ENTREGA", "PROVINCIA ENTREGA", "CIUDAD ENTREGA", "PARROQUIA ENTREGA", "BARRIO ENTREGA", "DIRECCION ENTREGA",
										   "TELEFONO PRINCIPAL", "TELEFONO ADICIONAL", "IMPUTABLE", "OBSERVACIONES IMPUTABLE", "TELEFONO CONTACTADO", "NOMBRE VENDEDOR", "NOMBRE BASE"]
			ExcelUtils.addCells(headersPrincipales, sheetPrincipales, 0, Colour.ICE_BLUE, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont, Border.ALL, BorderLineStyle.THIN)

			for (int i = 0; i < principalesList.size(); i++){
				String[] campos = new String[headersPrincipales.length]
				ClientesNovedades princ = principalesList.get(i)
				campos[0] = princ.cedula
				campos[1] = princ.nombres
				campos[2] = princ.fechaGestion.toString().substring(0,10)
				campos[3] = princ.fechaGestion.toString().substring(11,19)
				campos[4] = princ.provinciaEntrega
				campos[5] = princ.ciudadEntrega
				campos[6] = princ.parroquiaEntrega
				if(princ.barrioNoDefinido != ""){
					campos[7] = princ.barrioNoDefinido
				}else {
					campos[7] = princ.barrioEntrega
				}
				campos[8] = princ.callePrincipalEntrega + ' ' + princ.numeracionEntrega + ' ' + princ.calletransversalEntrega + ' ' + princ.referenciaEntrega
				campos[9] = princ.telefonoPrincipal
				campos[10] = princ.telefonoSecundario
				campos[11] = princ.imputable
				campos[12] = princ.observacionesImputable
				campos[13] = princ.telefonoContactado
				campos[14] = princ.nombreVendedor
				campos[15] = princ.nombreBase
				ExcelUtils.addCells(campos, sheetPrincipales, i+1, Colour.WHITE, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont2, null, null)
			}
			workbook.write()
			workbook.close()
			response.setHeader("Content-disposition", "filename=Bitacora_Novedades.xls")
			response.setContentType("application/octet-stream")
			response.outputStream << file.getBytes()
			return
		}
	}

	def baseGestionadaNovedades(){
		if(params.nombreBase){

			//Obtenemos los datos
			def nombresBase = params.list("nombreBase")
			def condiciones = [nombresBase: nombresBase]
			String sqlPrincipales = "from ClientesNovedades where nombreBase in (:nombresBase) order by subestadoGestion, nombreVendedor"
			def principalesList = ClientesNovedades.executeQuery(sqlPrincipales, condiciones)

			//Empezamos a crear y llenar el Excel
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder)
			File file = new File(webrootDir, "temporal.xls")
			WorkbookSettings workbookSettings = new WorkbookSettings()
			workbookSettings.setLocale(new Locale("es", "ES"))
			workbookSettings.setEncoding("UTF-8")
			WritableWorkbook workbook = Workbook.createWorkbook(file)
			workbook.createSheet("Base Gestionada", 0)
			WritableFont cellFont = new WritableFont(WritableFont.createFont("Calibri"), 11, WritableFont.BOLD)
			WritableFont cellFont2 = new WritableFont(WritableFont.createFont("Calibri"), 11)
			WritableSheet sheetPrincipales = workbook.getSheet(0)
			String[] headersPrincipales = ["CEDULA", "NOMBRES_COMPLETOS", "ESTADO_GESTION", "SUBESTADO_GESTION", "SUB_SUB_ESTADO", "FECHA_GESTION", "NOMBRE_VENDEDOR", "NOMBRE_BASE", "INTENTOS", "DIRECCION ERRONEA"]
			ExcelUtils.addCells(headersPrincipales, sheetPrincipales, 0, Colour.ICE_BLUE, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont, Border.ALL, BorderLineStyle.THIN)

			for (int i = 0; i < principalesList.size(); i++){
				String[] campos = new String[headersPrincipales.length]
				ClientesNovedades princ = principalesList.get(i)
				campos[0] = princ.cedula
				campos[1] = princ.nombres
				campos[2] = princ.estadoGestion
				if(princ.subestadoGestion == null){
					campos[3] = princ.subestadoGestion
				}else{
					campos[3] = princ.subestadoGestion.nombre
				}
				campos[4] = princ.subSubEstado
				if (princ.fechaGestion == null){
					campos[5] = ""
				} else{
					campos[5] = princ.fechaGestion.toString()
				}
				campos[6] = princ.nombreVendedor
				campos[7] = princ.nombreBase
				campos[8] = princ.intentos
				campos[9] = princ.direccionCorreccion
				ExcelUtils.addCells(campos, sheetPrincipales, i+1, Colour.WHITE, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont2, null, null)
			}
			workbook.write()
			workbook.close()
			response.setHeader("Content-disposition", "filename=Bitacora_Courier.xls")
			response.setContentType("application/octet-stream")
			response.outputStream << file.getBytes()
			return
		}
	}

	def indicadoresGestion(){
		boolean visibilizar = false
		if(params.fechas){
			visibilizar = true
			DecimalFormat df = new DecimalFormat("#.00")
			Date[] fechas = Util.formatearFechasReporte(params.fechas.toString())
			def nombresBase = params.list("nombreBase")
			Date fechaInicio = fechas[0]
			Date fechaFin = fechas[1]

			int Exitosas = 0
			int Contactados = 0
			int NoDesea = 0
			int exitosasPdp = 0
			int exitosasCredito = 0
			double Efectividad = 0
			double EfectividadPdp = 0
			double EfectividadCredito = 0
			double NoDeseaPorcentaje = 0

			int totalGestionados = 0
			int totalContactados = 0
			int totalNoContactados = 0
			int totalExitosos = 0
			int totalCruzadasCU2 = 0
			int totalCruzadasCU3 = 0
			int totalNoDeseaCU5 = 0
			int totalTarjetasCreadas = 0
			int totalDiferenciaTarjetas = 0
			String totalPorcentajeContactabilidad = ""
			String totalPorcentajeEfectividad = ""
			String totalPorcentajeEfectividadPdp = ""
			String totalPorcentajeEfectividadCredito = ""
			String totalPorcentajeReales = ""
			def subestadosEfectivos = Subestado.executeQuery("from Subestado where id in (1)")
			def subestadosCruzadas = Subestado.executeQuery("from Subestado where id in (2)")
			def subestadosCU3 = Subestado.executeQuery("from Subestado where id in (3)")
			def subestadosCU5 = Subestado.executeQuery("from Subestado where id in (5)")
			def ventasPorUsuario = Clientes.executeQuery("select nombreVendedor, count(*), substring(fechaGestion,1,10) from Historial where subestadoGestion = :subestadosEfectivos and fechaGestion between :fechaInicio and :fechaFin group by nombreVendedor, substring(fechaGestion,1,10) order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin/*, nombresBase: nombresBase*/, subestadosEfectivos: subestadosEfectivos])
			def cruzadasPorUsuario = Clientes.executeQuery("select nombreVendedor, count(*), substring(fechaGestion,1,10) from Historial where (subSubEstado = 'PDP' or subSubEstado = 'CREDITO+PDP') and fechaGestion between :fechaInicio and :fechaFin group by nombreVendedor , substring(fechaGestion,1,10) order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin/*, nombresBase: nombresBase*/])
			def CU3PorUsuario = Clientes.executeQuery("select nombreVendedor, count(*), substring(fechaGestion,1,10) from Historial where (subSubEstado = 'CREDITO' or subSubEstado = 'TDC+CREDITO' or subSubEstado = 'CREDITO+PDP') and fechaGestion between :fechaInicio and :fechaFin group by nombreVendedor, substring(fechaGestion,1,10) order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin/*, nombresBase: nombresBase*/])
			def noDeseaPorUsuario = Clientes.executeQuery("select nombreVendedor, count(*), substring(fechaGestion,1,10) from Historial where subestadoGestion in (:subestadosCU5) and fechaGestion between :fechaInicio and :fechaFin  group by nombreVendedor , substring(fechaGestion,1,10) order by nombreVendedor", [subestadosCU5: subestadosCU5, fechaInicio: fechaInicio, fechaFin: fechaFin/*, nombresBase: nombresBase*/])
			def gestionadosAgente = Clientes.executeQuery("select nombreVendedor, count(*), substring(fechaGestion,1,10) from Historial where intentos != 0 and fechaGestion between :fechaInicio and :fechaFin  group by nombreVendedor, substring(fechaGestion,1,10) order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin/*, nombresBase: nombresBase*/])
			def contactadosAgente = Clientes.executeQuery("select nombreVendedor, count(*), substring(fechaGestion,1,10) from Historial where intentos != 0 and estadoGestion = 'CONTACTADO' and fechaGestion between :fechaInicio and :fechaFin group by nombreVendedor, substring(fechaGestion,1,10) order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin/*, nombresBase: nombresBase*/])
			def noContactadosAgente = Clientes.executeQuery("select nombreVendedor, count(*), substring(fechaGestion,1,10) from Historial where intentos != 0 and estadoGestion = 'NO CONTACTADO' and fechaGestion between :fechaInicio and :fechaFin group by nombreVendedor, substring(fechaGestion,1,10) order by nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin/*, nombresBase: nombresBase*/])

			String[][] tablaResult = new String[gestionadosAgente.size()][12]
			//Lleno la matriz de resultados con los resultados de las onsultas anteriores
			for(int i = 0; i < tablaResult.size(); i++){
				tablaResult[i][0] = gestionadosAgente[i][0]
				tablaResult[i][1] = gestionadosAgente[i][1]
				tablaResult[i][10] = gestionadosAgente[i][2]

				//Lleno información de contactados y % de contactabilidad
				for(int j = 0; j < contactadosAgente.size(); j++){
					if(contactadosAgente[j][0] == gestionadosAgente[i][0] && contactadosAgente[j][2] == gestionadosAgente[i][2]){
						tablaResult[i][2] = contactadosAgente[j][1]
						Contactados = tablaResult[i][2].toInteger()
						break
					}
				}
				if(tablaResult[i][2] == null){
					Contactados = 0
				}
				//Lleno información de no contactados
				/*for(int j = 0; j < noContactadosAgente.size(); j++){
                    if(noContactadosAgente[j][0] == gestionadosAgente[i][0] && noContactadosAgente[j][2] == gestionadosAgente[i][2]){
                        tablaResult[i][3] = noContactadosAgente[j][1]
                        break
                    }
                }*/
				//LLeno la información de las ventas
				for(int j = 0; j < ventasPorUsuario.size(); j++){
					if(ventasPorUsuario[j][0] == gestionadosAgente[i][0] && ventasPorUsuario[j][2] == gestionadosAgente[i][2]){
						tablaResult[i][4] = ventasPorUsuario[j][1]
						Exitosas = tablaResult[i][4].toInteger()
						break
					}
				}
				if(tablaResult[i][4] == null){
					Exitosas = 0
				}
				//LLeno la información de las ventas cruzadas
				for(int j = 0; j < cruzadasPorUsuario.size(); j++){
					if(cruzadasPorUsuario[j][0] == gestionadosAgente[i][0] && cruzadasPorUsuario[j][2] == gestionadosAgente[i][2]){
						tablaResult[i][5] = cruzadasPorUsuario[j][1]
						exitosasPdp = tablaResult[i][5].toInteger()
						break
					}
				}
				if(tablaResult[i][5] == null){
					exitosasPdp = 0
				}

				//LLeno la información de las ventas CU3
				for(int j = 0; j < CU3PorUsuario.size(); j++){
					if(CU3PorUsuario[j][0] == gestionadosAgente[i][0] && CU3PorUsuario[j][2] == gestionadosAgente[i][2]){
						tablaResult[i][6] = CU3PorUsuario[j][1]
						exitosasCredito = tablaResult[i][6].toInteger()
						break
					}
				}
				if(tablaResult[i][6] == null){
					exitosasCredito = 0
				}

				//LLeno la información de los No Desea
				for(int j = 0; j < noDeseaPorUsuario.size(); j++){
					if(noDeseaPorUsuario[j][0] == gestionadosAgente[i][0] && noDeseaPorUsuario[j][2] == gestionadosAgente[i][2]){
						tablaResult[i][7] = noDeseaPorUsuario[j][1]
						NoDesea = tablaResult[i][7].toInteger()
						break
					}
				}
				if(tablaResult[i][7] == null){
					NoDesea = 0
				}

				//Pra calcular los procentajes de efectividad y no desea
				if(Exitosas != 0 && Exitosas != null){
					Efectividad = (Exitosas / Contactados) * 100
					tablaResult[i][8] = df.format(Double.parseDouble(Efectividad.toString())).replace(".", ",")
					//tablaResult[i][8] = 0
				}else{
					tablaResult[i][8] = 0
				}

				if(exitosasPdp != 0 && exitosasPdp != null){
					EfectividadPdp = (exitosasPdp / Contactados) * 100
					tablaResult[i][3] = df.format(Double.parseDouble(EfectividadPdp.toString())).replace(",", ".")
				}else{
					tablaResult[i][3] = 0
				}

				if(NoDesea != 0 && NoDesea != null){
					NoDeseaPorcentaje = (NoDesea / Contactados) * 100
					tablaResult[i][9] = df.format(Double.parseDouble(NoDeseaPorcentaje.toString())).replace(".", ",")
					//tablaResult[i][9] = 0
				}else{
					tablaResult[i][9] = 0
				}

				if(exitosasCredito != 0 && exitosasCredito != null){
					EfectividadCredito = (exitosasCredito / Contactados) * 100
					tablaResult[i][11] = df.format(Double.parseDouble(EfectividadCredito.toString())).replace(",", ".")
					//tablaResult[i][9] = 0
				}else{
					tablaResult[i][11] = 0
				}
				//println(Contactados + " " + Exitosas + " " + NoDesea)
			}

			//Recorro la matriz de resultados para obtener los totales
			for(int i = 0; i < tablaResult.size(); i++){
				totalGestionados = totalGestionados + tablaResult[i][1].toInteger()
				if(tablaResult[i][2] != null)
					totalContactados = totalContactados + tablaResult[i][2].toInteger()
				/*if(tablaResult[i][3] != null)
                    totalNoContactados = totalNoContactados + tablaResult[i][3].toInteger()*/
				if(tablaResult[i][4] != null)
					totalExitosos = totalExitosos + tablaResult[i][4].toInteger()
				if(tablaResult[i][5] != null)
					totalCruzadasCU2 = totalCruzadasCU2 + tablaResult[i][5].toInteger()
				if(tablaResult[i][6] != null)
					totalCruzadasCU3 = totalCruzadasCU3 + tablaResult[i][6].toInteger()
				if(tablaResult[i][7] != null)
					totalNoDeseaCU5 = totalNoDeseaCU5 + tablaResult[i][7].toInteger()
			}

			if(totalGestionados == 0){
				totalPorcentajeContactabilidad = "0.00"
				totalPorcentajeEfectividad = "0.00"
				totalPorcentajeEfectividadPdp = "0.00"
				totalPorcentajeEfectividadCredito = "0.00"
			}else{
				totalPorcentajeContactabilidad = df.format((totalExitosos/totalContactados)*100).replace(".",",")
				totalPorcentajeEfectividad = df.format((totalNoDeseaCU5/totalContactados)*100).replace(".",",")
				totalPorcentajeEfectividadPdp = df.format((totalCruzadasCU2/totalContactados)*100).replace(".",",")
				totalPorcentajeEfectividadCredito = df.format((totalCruzadasCU3/totalContactados)*100).replace(".",",")
			}
			[visibilizar: visibilizar, tablaResult: tablaResult, totalGestionados: totalGestionados, totalContactados: totalContactados,
			 totalNoContactados: totalNoContactados, totalExitosos:totalExitosos, totalCruzadasCU2: totalCruzadasCU2, totalCruzadasCU3: totalCruzadasCU3,
			 totalNoDeseaCU5: totalNoDeseaCU5, totalPorcentajeContactabilidad: totalPorcentajeContactabilidad, totalPorcentajeEfectividad: totalPorcentajeEfectividad,
			 totalPorcentajeEfectividadPdp: totalPorcentajeEfectividadPdp, totalPorcentajeEfectividadCredito: totalPorcentajeEfectividadCredito]
		}
	}

	def tiemposBreak() {
		if (params.fechas) {
			Date[] fechas = Util.formatearFechasReporte(params.fechas.toString())
			ArrayList<SubSubestado> subestados = Subestado.executeQuery("from Subestado where id in (1)")
			def nombresBase = params.list("nombreBase")
			def condiciones = [fechaInicio: fechas[0], fechaFin: fechas[1]]
			String sqlPrincipales = "from BreakTime where dateBreak between :fechaInicio and :fechaFin"
			def principalesList = BreakTime.executeQuery(sqlPrincipales, condiciones)
			//Empezamos a crear y llenar el Excel
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder)
			File file = new File(webrootDir, "temporal.xls")
			WorkbookSettings workbookSettings = new WorkbookSettings()
			workbookSettings.setLocale(new Locale("es", "ES"))
			workbookSettings.setEncoding("UTF-8")
			WritableWorkbook workbook = Workbook.createWorkbook(file)
			workbook.createSheet("Clientes Efectivos", 0)
			WritableFont cellFont = new WritableFont(WritableFont.createFont("Calibri"), 11, WritableFont.BOLD)
			cellFont.setColour(Colour.WHITE);
			WritableFont cellFont2 = new WritableFont(WritableFont.createFont("Calibri"), 11)
			WritableSheet sheetPrincipales = workbook.getSheet(0)
			String[] headersPrincipales = ["FECHA/HORA", "TIEMPO", "OPCION", "NOMBRE USUARIO"]
			ExcelUtils.addCells(headersPrincipales, sheetPrincipales, 0, Colour.GREEN, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont, Border.ALL, BorderLineStyle.THIN)
			for (int i = 0; i < principalesList.size(); i++) {
				String[] campos = new String[headersPrincipales.length]
				BreakTime cli = principalesList.get(i)
				campos[0] = cli.dateBreak.toString()
				campos[1] = cli.timeBreak.toString()
				campos[2] = cli.typeBreak
				campos[3] = cli.user.nombre
				ExcelUtils.addCells(campos, sheetPrincipales, i + 1, Colour.WHITE, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont2, null, null)
			}
			workbook.write()
			workbook.close()
			response.setHeader("Content-disposition", "filename=tiemposBreakAsesores.xls")
			response.setContentType("application/octet-stream")
			response.outputStream << file.getBytes()
			return
		}
	}

	def loginAgentes(){
		boolean visibilizar = false
		if(params.fechas) {
			visibilizar = true
			Date[] fechas = Util.formatearFechasReporte(params.fechas.toString())
			def nombresBase = params.list("nombreBase")
			Date fechaInicio = fechas[0]
			Date fechaFin = fechas[1]
			println(fechaInicio)
			def consulta = Clientes.executeQuery("select substring(fechaGestion,1,10), nombreVendedor, substring(min(fechaGestion),11,12), substring(max(fechaGestion),11,12) from Clientes where fechaGestion between :fechaInicio and :fechaFin group by substring(fechaGestion,1,10), nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin])
			String[][] tablaResult = new String[consulta.size()][5]
			//Lleno la matriz de resultados con los resultados de las onsultas anteriores
			for(int i = 0; i < tablaResult.size(); i++) {
				tablaResult[i][0] = consulta[i][0]
				tablaResult[i][1] = consulta[i][1]
				tablaResult[i][2] = consulta[i][2]
				tablaResult[i][3] = consulta[i][3]
			}
			[visibilizar: visibilizar, tablaResult: tablaResult]
		}
	}

}
