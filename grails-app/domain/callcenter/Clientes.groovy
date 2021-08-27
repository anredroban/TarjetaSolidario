package callcenter

import com.pw.security.*
import com.sun.org.apache.xpath.internal.operations.Bool

class Clientes {

	String cupo //SI
	String direccionTrabajo //SI
	String nivelEstudios //SI
	String origenIngresos //SI
	String cargasFamiliares //SI
	String tipoIdentificacion //SI
	String identificacion //SI
	String apellidoPaterno //SI
	String apellidoMaterno //SI
	String primerNombre //SI
	String segundoNombre //SI
	String estadoCivil //SI
	String genero //SI
	String fechaNacimiento //SI
	String fechaNacimientoGestion //SI
	String edad //SI
	String profesion //SI
	String email //SI
	String emailEstadoCuenta //SI
	String emailPersonal //SI
	String provinciaDomicilio //SI
	String ciudadDomicilio //SI
	String parroquiaDomicilio //SI
	String barrioDomicilio //SI
	String callePrincipalDomicilio //SI
	String numeracionDomicilio //SI
	String calletransversalDomicilio //SI
	String referenciaDomicilio //SI
	String telefono1 //SI
	String telefono2 //SI
	String telefono3 //SI
	String telefono4 //SI
	String telefono5 //SI
	String telefono6 //SI

	String telefono7 //SI
	String telefono8 //SI
	String telefono9 //SI
	String telefono10 //SI
	String telefonoSecundarioGestion //SI Campo que es utilizado para almacenar el telefono secundario del cliente
	String telefonoTrabajoGestion //SI Campo que es utilizado para almacenar el telefono de trabajo del cliente
	String rucEmpresa //SI
	String nombreLabora //SI
	String fechaIngreso //SI
	String cargo //SI
	String provinciaTrabajo //SI
	String ciudadTrabajo //SI
	String parroquiaTrabajo //SI
	String barrioTrabajo //SI
	String callePrincipalTrabajo //SI
	String numeracionTrabajo //SI
	String calletransversalTrabajo //SI
	String referenciaTrabajo //SI
	String telefonoTrabajo //SI
	String aceptaPlanConmigo //SI
	String identificacionConyuge //SI
	String apellido1Conyuge //SI
	String apellido2Conyuge //SI
	String nombre1Conyuge //SI
	String nombre2Conyuge //SI
	String telefonoCelularGestion //SI Campo utilizado para almacenar el telefono de celular del cliente
	String apellido1RefPersonal //SI
	String apellido2RefPersonal //SI
	String nombre1RefPersonal //SI
	String nombre2RefPersonal //SI
	String telefonoRefPersonal //SI
	String parentescoRefPersonal //SI
	String apellido1RefPersonal2 //SI
	String apellido2RefPersonal2 //SI
	String nombre1RefPersonal2 //SI
	String nombre2RefPersonal2 //SI
	String telefonoRefPersonal2 //SI
	String parentescoRefPersonal2 //SI
	String seguroDesgravamen //SI
	String sueldoIngresos //SI
	String rentas //SI
	String remesas //SI
	String ingresoFamiliares //SI
	String otrosIngresos //SI
	String gastosBasicos  //SI
	String serviciosBasicos //SI
	String transporte //SI
	String otrosGastos //SI
	String telefonoPrincipalGestion //SI Campo que es utilizado para almacenar el telefono principal del cliente
	String activoBien //SI
	String valorUnitarioBien //SI
	String institucionPasivo //SI
	String fechaEmisionPasivo //SI
	String valorCuotaPasivo //SI
	String plazoPasivo //SI
	String saldoPasivo //SI
	String celularRefPersonal //SI CAMPO UTILIZADO PARA TELEFONO CLULAR DE REFERENCIA PERSONAL DE CLIENTE EN LA GESTION
	String nombreImpreso //SI
	String celularSms //SI CAMPO UTILIZADO PARA LA EMISION DE MENSAJES DE TEXTO A TELEFONO CELULAR
	String celularRefPersonal2 //SI CAMPO UTILIZADO PARA TELEFONO CLULAR DE REFERENCIA PERSONAL 2 DE CLIENTE EN LA GESTION
	Date fechaEntrega //SI
	String lugarEntrega //SI
	String horarioEntrega //SI
	String ubicacionProvinciaDomicilio //SI
	String ubicacionCantonDomicilio //SI
	String ubicacionParroquiaDomicilio //SI
	String ubicacionBarrioDomicilio //SI
	String ubicacionProvinciaTrabajo //SI
	String ubicacionCantonTrabajo //SI
	String ubicacionParroquiaTrabajo //SI
	String ubicacionBarrioTrabajo //SI
	String lugarEntregaECuenta //SI
	Boolean esImpreso //SI
	String tipoVivienda //SI
	String valorVivienda //SI
	String barrioNoDefinidoDomicilio //SI
	String barrioNoDefinidoTrabajo //SI
	String diaFechaCorte //SI
	String diaFechaPago //SI
	String nombreLaboraConyuge //SI




	String utilidad
	String pasivos
	String binPlastico


	//Campos que SIEMPRE van en la gestión
	Date fechaGestion
	int intentos
	String estadoGestion
	Subestado subestadoGestion
	String subSubEstado
	Usuario usuario
	String nombreBase
	String nombreVendedor
	Date fechaRellamada
	String observaciones
	String codigoAsignacion
	String registroExitoso //SI
	boolean isActive //Será falso cuando se deshabilite una cliente
	boolean isBaseActiva //Será falso cuando se deshabilite una base
	boolean isManagement //Campo utilizado para mostrar si se encuentro en gestión o no el registro
	String telefonoContactado
	String mesCargaBase

	/*Creacion de campos solicitados por el area de Reporting 2019-05-11*/
	String gama
	String regional
	String rangoEdad
	String rangoCupo
	String segmentacionAd1
	String segmentacionAd2
	String segmentacionAd3
	String segmentacionAd4
	String segmentacionAd5
	String easyCodeRegional
	String easyCodeEdad
	String easyCodeCupo
	String easyCodeEdadCupo
	String easyCodeGamaEdad
	String easyCodeAd1
	String easyCodeAd2
	String easyCodeAd3
	String easyCodeAd4
	String easyCodeAd5
	String prioridadCampania
	String fechaCaducidad
	String deudaProtegida
	String metaContactabilidad
	String metaEfectividadTelefonica
	String metaEfectividadReal
	String tipoGestion
	String plataforma

	String creadas_nocreadas
	String imputable
	String detalle_imputable
	String fecha_envio_creacion
	String status_courier
	String ciclo_courier
	String guia_courier
	String codigoCampania
	String cierre_ciclo

	static constraints = {
		cupo nullable: true
		direccionTrabajo nullable: true
		nivelEstudios nullable: true
		origenIngresos nullable: true
		tipoVivienda nullable: true
		valorVivienda nullable: true
		cargasFamiliares nullable: true
		tipoIdentificacion nullable: true
		aceptaPlanConmigo nullable: true
		identificacion nullable: true
		apellidoPaterno nullable: true
		apellidoMaterno nullable: true
		primerNombre nullable: true
		segundoNombre nullable: true
		fechaNacimiento nullable: true
		fechaNacimientoGestion nullable: true
		genero nullable: true
		estadoCivil nullable: true
		edad nullable: true
		profesion nullable: true
		email nullable: true
		emailEstadoCuenta nullable: true
		emailPersonal nullable: true
		parroquiaDomicilio nullable: true
		barrioDomicilio nullable: true
		callePrincipalDomicilio nullable: true
		numeracionDomicilio nullable: true
		calletransversalDomicilio nullable: true
		telefono1 nullable: true
		telefono2 nullable: true
		telefono3 nullable: true
		telefono4 nullable: true
		telefono5 nullable: true
		telefono6 nullable: true
		telefono7 nullable: true
		telefono8 nullable: true
		telefono9 nullable: true
		telefono10 nullable: true
		telefonoTrabajo nullable: true
		provinciaDomicilio nullable: true
		ciudadDomicilio nullable: true
		referenciaDomicilio nullable: true
		provinciaTrabajo nullable: true
		ciudadTrabajo nullable: true
		referenciaTrabajo nullable: true
		telefonoSecundarioGestion nullable: true
		telefonoTrabajoGestion nullable: true
		rucEmpresa nullable: true
		nombreLabora nullable: true
		fechaIngreso nullable: true
		cargo nullable: true
		parroquiaTrabajo nullable: true
		barrioTrabajo nullable: true
		callePrincipalTrabajo nullable: true
		numeracionTrabajo nullable: true
		calletransversalTrabajo nullable: true
		lugarEntrega nullable: true
		horarioEntrega nullable: true
		sueldoIngresos nullable: true
		rentas nullable: true
		remesas nullable: true
		ingresoFamiliares nullable: true
		otrosIngresos nullable: true
		gastosBasicos nullable: true
		serviciosBasicos nullable: true
		transporte nullable: true
		otrosGastos nullable: true
		fechaEntrega nullable: true
		celularRefPersonal nullable: true
		nombreImpreso nullable: true
		telefonoPrincipalGestion nullable: true
		activoBien nullable: true
		valorUnitarioBien nullable: true
		institucionPasivo nullable: true
		fechaEmisionPasivo nullable: true
		valorCuotaPasivo nullable: true
		plazoPasivo nullable: true
		saldoPasivo nullable: true
		celularSms nullable: true
		celularRefPersonal2 nullable: true
		apellido1RefPersonal nullable: true
		apellido2RefPersonal nullable: true
		nombre1RefPersonal nullable: true
		nombre2RefPersonal nullable: true
		telefonoRefPersonal nullable: true
		parentescoRefPersonal nullable: true
		identificacionConyuge nullable: true
		apellido1Conyuge nullable: true
		apellido2Conyuge nullable: true
		nombre1Conyuge nullable: true
		nombre2Conyuge nullable: true
		telefonoCelularGestion nullable: true
		nombreLaboraConyuge nullable: true
	     apellido1RefPersonal2 nullable: true
		 apellido2RefPersonal2 nullable: true
		 nombre1RefPersonal2 nullable: true
		 nombre2RefPersonal2 nullable: true
		 telefonoRefPersonal2  nullable: true
		 parentescoRefPersonal2 nullable: true
		 seguroDesgravamen nullable: true
		//Campos que SIEMPRE van en la gestión
		fechaGestion nullable: true
		intentos nullable: true
		estadoGestion nullable: true
		subestadoGestion nullable: true
		subSubEstado nullable: true
		usuario nullable: true
		nombreBase nullable: true
		nombreVendedor nullable: true
		fechaRellamada nullable: true
		observaciones nullable: true
		codigoAsignacion nullable: true
		ubicacionProvinciaDomicilio nullable: true
		ubicacionCantonDomicilio nullable: true
		ubicacionParroquiaDomicilio nullable: true
		ubicacionBarrioDomicilio nullable: true
		ubicacionProvinciaTrabajo nullable: true
		ubicacionCantonTrabajo nullable: true
		ubicacionParroquiaTrabajo nullable: true
		ubicacionBarrioTrabajo nullable: true
		esImpreso nullable: true
		lugarEntregaECuenta nullable: true
		telefonoContactado nullable: true
		isBaseActiva nullable: true
		mesCargaBase nullable: true
		barrioNoDefinidoDomicilio nullable: true
		barrioNoDefinidoTrabajo nullable: true
		diaFechaCorte nullable: true
		diaFechaPago nullable: true
		isManagement nullable: true
		registroExitoso nullable: true
		codigoCampania nullable: true


		utilidad nullable: true
		pasivos nullable: true
		binPlastico nullable: true
		/*Creacion de campos solicitados por el area de Reporting 2019-05-11*/
		gama nullable: true
		regional nullable: true
		rangoEdad nullable: true
		rangoCupo nullable: true
		segmentacionAd1 nullable: true
		segmentacionAd2 nullable: true
		segmentacionAd3 nullable: true
		segmentacionAd4 nullable: true
		segmentacionAd5 nullable: true
		easyCodeRegional nullable: true
		easyCodeEdad nullable: true
		easyCodeCupo nullable: true
		easyCodeEdadCupo nullable: true
		easyCodeGamaEdad nullable: true
		easyCodeAd1 nullable: true
		easyCodeAd2 nullable: true
		easyCodeAd3 nullable: true
		easyCodeAd4 nullable: true
		easyCodeAd5 nullable: true
		prioridadCampania nullable: true
		fechaCaducidad nullable: true
		deudaProtegida nullable: true
		metaContactabilidad nullable: true
		metaEfectividadTelefonica nullable: true
		metaEfectividadReal nullable: true
		tipoGestion nullable: true
		plataforma nullable: true
		creadas_nocreadas nullable: true
		imputable nullable: true
		detalle_imputable nullable: true
		fecha_envio_creacion nullable: true
		status_courier nullable: true
		ciclo_courier nullable: true
		guia_courier nullable: true
		cierre_ciclo nullable: true
	}
	
	static mapping = {
		version false
		observaciones type: 'text'
	}

	static String[] getFields(){
		String[] fields = [
				"identificacion",
				"primerNombre",
				"segundoNombre",
				"apellidoPaterno",
				"apellidoMaterno",
				"estadoCivil",
				"genero",
				"fechaNacimiento",
				"edad",
				"codigoAsignacion",
				"provinciaDomicilio",
				"ciudadDomicilio",
				"parroquiaDomicilio",
				"barrioDomicilio",
				"callePrincipalDomicilio",
				"numeracionDomicilio",
				"calletransversalDomicilio",
				"referenciaDomicilio",
				"email",
				"telefono1",
				"telefono2",
				"telefono3",
				"telefono4",
				"telefono5",
				"telefono6",
				"telefono7",
				"telefono8",
				"telefono9",
				"telefono10",
				"telefonoTrabajo",
				"provinciaTrabajo",
				"ciudadTrabajo",
				"nombreLabora",
				"direccionTrabajo",
				"profesion",
				"rucEmpresa",
				"fechaIngreso",
				"cargo",
				"cupo"
				, "gama"
				, "regional"
				, "rangoEdad"
				, "rangoCupo"
				, "segmentacionAd1"
				, "segmentacionAd2"
				, "segmentacionAd3"
				, "segmentacionAd4"
				, "segmentacionAd5"
				, "easyCodeRegional"
				, "easyCodeEdad"
				, "easyCodeCupo"
				, "easyCodeEdadCupo"
				, "easyCodeGamaEdad"
				, "easyCodeAd1"
				, "easyCodeAd2"
				, "easyCodeAd3"
				, "easyCodeAd4"
				, "easyCodeAd5"
				, "prioridadCampania"
				, "fechaCaducidad"
				, "deudaProtegida"
				, "metaContactabilidad"
				, "metaEfectividadTelefonica"
				, "metaEfectividadReal"
				, "tipoGestion"
				, "plataforma"
		]
		return fields
	}

	static HashMap getNivelesEstudio(){
		return ['': '-- Seleccione --', 'NINGUNO': 'NINGUNO', 'PRIMARIA': 'PRIMARIA', 'SECUNDARIA': 'SECUNDARIA', 'TECNICA': 'TECNICA', 'SUPERIOR': 'SUPERIOR', 'POSTGRADO': 'POSTGRADO', 'MASTERADO': 'MASTERADO', 'P.H.D.': 'P.H.D.', 'OTROS': 'OTROS']
	}

	static HashMap getOrigenesIngresos(){
		return ['': '-- Seleccione --', 'EMPLEADO PUBLICO': 'EMPLEADO PUBLICO', 'EMPLEADO PRIVADO': 'EMPLEADO PRIVADO', 'INDEPENDIENTE': 'INDEPENDIENTE']
	}

	static HashMap getRangosIngresos(){
		return ['': '-- Seleccione --', '1': 'MENOS DE 600', '2': '600 - 1000', '3': '1000 - 2000', '4': '2000 - 3500', '5': '3500 - 5000', '6': '5000 - 7500', '7': ' MAS DE 7500']
	}

	static HashMap getTiposVivienda(){
		return ['': '-- Seleccione --', 'VIVE CON FAMILIARES': 'VIVE CON FAMILIARES', 'PROPIA HIPOTECADA': 'PROPIA HIPOTECADA', 'PROPIA NO HIPOTECADA': 'PROPIA NO HIPOTECADA', 'ARRENDADA': 'ARRENDADA', 'PRESTADA': 'PRESTADA']
	}

	static HashMap getTiposParientes(){
		return ['': '-- Seleccione --', 'PARENTSP':'PADRE', 'PARENTSM': 'MADRE', 'PARENTSH': 'HIJO/HIJA', 'PARENTSAB': 'ABUELO/ABUELA', '04': 'Primo(a)',
		'05': 'Tío(a)', '06': 'Sobrino(a)', '07': 'Esposa(o)', '08': 'Cuñado', '09': 'Yerno (Nuera)', '10': 'Suegro(a)', '11': 'Hijo(a)',
		'12': 'Amigo(a)', '13': 'Abuelo(a)', '14': 'Novio (a)', '15': 'Nieto (a)', '16': 'Compañero de Trabajo', '17': 'Familiar',
		'18': 'Representante Legal', '19': 'Relación Comercial', '20': 'Relación Laboral', '21': 'Presidente', '22': 'Vice-presidente',
		'23': 'Funcionario', '24': 'Ejecutivo']
	}

}
