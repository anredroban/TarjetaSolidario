import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tarjetaSolidario_gestiongestionCliente_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/gestion/gestionCliente.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
invokeTag('captureMeta','sitemesh',1,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',2,['src':("usogeneral/bootstrap-datepicker.min.css")],-1)
printHtmlPart(1)
createTagBody(1, {->
createClosureForHtmlPart(2, 2)
invokeTag('captureTitle','sitemesh',4,[:],2)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],1)
printHtmlPart(3)
invokeTag('stylesheet','asset',6,['src':("usogeneral/datetimepicker.css")],-1)
printHtmlPart(4)
invokeTag('stylesheet','asset',7,['src':("gestion/gestionCliente.css")],-1)
printHtmlPart(5)
if(true && (cliente.registroExitoso == 'SI')) {
printHtmlPart(6)
}
printHtmlPart(7)
expressionOut.print(cliente.identificacion)
printHtmlPart(8)
expressionOut.print(cliente.apellidoPaterno)
printHtmlPart(9)
expressionOut.print(cliente.apellidoMaterno)
printHtmlPart(10)
expressionOut.print(cliente.primerNombre)
printHtmlPart(11)
expressionOut.print(cliente.segundoNombre)
printHtmlPart(12)
if(true && (cliente.estadoCivil && cliente.estadoCivil.trim() != '')) {
printHtmlPart(13)
expressionOut.print(cliente.estadoCivil)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (cliente.genero && cliente.genero.trim() != '')) {
printHtmlPart(16)
expressionOut.print(cliente.genero)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (cliente.fechaNacimiento && cliente.fechaNacimiento.trim() != '')) {
printHtmlPart(19)
expressionOut.print(cliente.fechaNacimiento)
printHtmlPart(17)
}
printHtmlPart(15)
if(true && (cliente.edad && cliente.edad.trim() != '')) {
printHtmlPart(20)
expressionOut.print(cliente.edad)
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (cliente.profesion && cliente.profesion.trim() != '')) {
printHtmlPart(23)
expressionOut.print(cliente.profesion)
printHtmlPart(12)
}
printHtmlPart(22)
if(true && (cliente.provinciaDomicilio && cliente.provinciaDomicilio.trim() != '')) {
printHtmlPart(24)
expressionOut.print(cliente.provinciaDomicilio)
printHtmlPart(25)
}
printHtmlPart(22)
if(true && (cliente.ciudadDomicilio && cliente.ciudadDomicilio.trim() != '')) {
printHtmlPart(26)
expressionOut.print(cliente.ciudadDomicilio)
printHtmlPart(25)
}
printHtmlPart(22)
if(true && (cliente.parroquiaDomicilio && cliente.parroquiaDomicilio.trim() != '')) {
printHtmlPart(27)
expressionOut.print(cliente.parroquiaDomicilio)
printHtmlPart(25)
}
printHtmlPart(22)
if(true && (cliente.barrioDomicilio && cliente.barrioDomicilio.trim() != '')) {
printHtmlPart(28)
expressionOut.print(cliente.barrioDomicilio)
printHtmlPart(25)
}
printHtmlPart(22)
if(true && (cliente.callePrincipalDomicilio && cliente.callePrincipalDomicilio.trim() != '')) {
printHtmlPart(29)
expressionOut.print(cliente.callePrincipalDomicilio)
printHtmlPart(30)
expressionOut.print(cliente.numeracionDomicilio)
printHtmlPart(30)
expressionOut.print(cliente.calletransversalDomicilio)
printHtmlPart(25)
}
printHtmlPart(22)
if(true && (cliente.nombreLabora && cliente.nombreLabora.trim() != '')) {
printHtmlPart(31)
expressionOut.print(cliente.nombreLabora)
printHtmlPart(25)
}
printHtmlPart(22)
if(true && (cliente.provinciaTrabajo && cliente.provinciaTrabajo.trim() != '')) {
printHtmlPart(32)
expressionOut.print(cliente.provinciaTrabajo)
printHtmlPart(25)
}
printHtmlPart(22)
if(true && (cliente.ciudadTrabajo && cliente.ciudadTrabajo.trim() != '')) {
printHtmlPart(33)
expressionOut.print(cliente.ciudadTrabajo)
printHtmlPart(25)
}
printHtmlPart(22)
if(true && (cliente.direccionTrabajo && cliente.direccionTrabajo.trim() != '')) {
printHtmlPart(34)
expressionOut.print(cliente.direccionTrabajo)
printHtmlPart(25)
}
printHtmlPart(15)
if(true && (cliente.fechaIngreso && cliente.fechaIngreso.trim() != '')) {
printHtmlPart(35)
expressionOut.print(cliente.fechaIngreso)
printHtmlPart(21)
}
printHtmlPart(36)
if(true && (cliente.email && cliente.email.trim() != '')) {
printHtmlPart(37)
expressionOut.print(cliente.email)
printHtmlPart(25)
}
printHtmlPart(38)
if(true && (cliente.telefono1 && cliente.telefono1.trim() != '')) {
printHtmlPart(39)
expressionOut.print(cliente.telefono1)
printHtmlPart(21)
}
printHtmlPart(15)
if(true && (cliente.telefono2 && cliente.telefono2.trim() != '')) {
printHtmlPart(40)
expressionOut.print(cliente.telefono2)
printHtmlPart(21)
}
printHtmlPart(15)
if(true && (cliente.telefono3 && cliente.telefono3.trim() != '')) {
printHtmlPart(41)
expressionOut.print(cliente.telefono3)
printHtmlPart(21)
}
printHtmlPart(15)
if(true && (cliente.telefono4 && cliente.telefono4.trim() != '')) {
printHtmlPart(42)
expressionOut.print(cliente.telefono4)
printHtmlPart(21)
}
printHtmlPart(15)
if(true && (cliente.telefono5 && cliente.telefono5.trim() != '')) {
printHtmlPart(43)
expressionOut.print(cliente.telefono5)
printHtmlPart(21)
}
printHtmlPart(15)
if(true && (cliente.telefono6 && cliente.telefono6.trim() != '')) {
printHtmlPart(44)
expressionOut.print(cliente.telefono6)
printHtmlPart(21)
}
printHtmlPart(15)
if(true && (cliente.telefono7 && cliente.telefono7.trim() != '')) {
printHtmlPart(45)
expressionOut.print(cliente.telefono7)
printHtmlPart(21)
}
printHtmlPart(15)
if(true && (cliente.telefono8 && cliente.telefono8.trim() != '')) {
printHtmlPart(46)
expressionOut.print(cliente.telefono8)
printHtmlPart(21)
}
printHtmlPart(15)
if(true && (cliente.telefono9 && cliente.telefono9.trim() != '')) {
printHtmlPart(47)
expressionOut.print(cliente.telefono9)
printHtmlPart(21)
}
printHtmlPart(15)
if(true && (cliente.telefono10 && cliente.telefono10.trim() != '')) {
printHtmlPart(48)
expressionOut.print(cliente.telefono10)
printHtmlPart(21)
}
printHtmlPart(49)
expressionOut.print(cliente.apellidoPaterno)
printHtmlPart(30)
expressionOut.print(cliente.apellidoMaterno)
printHtmlPart(30)
expressionOut.print(cliente.primerNombre)
printHtmlPart(30)
expressionOut.print(cliente.segundoNombre)
printHtmlPart(50)
expressionOut.print(cliente.apellidoPaterno)
printHtmlPart(30)
expressionOut.print(cliente.primerNombre)
printHtmlPart(51)
expressionOut.print(session?.user?.nombre)
printHtmlPart(52)
createTagBody(1, {->
printHtmlPart(53)
expressionOut.print(cliente.id)
printHtmlPart(54)
invokeTag('select','g',236,['class':("form-control"),'name':("status"),'id':("status"),'from':(callcenter.Estado.list()),'optionKey':("id"),'optionValue':({it.nombre	}),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(55)
invokeTag('select','g',242,['class':("form-control"),'name':("substatus"),'id':("substatus"),'from':(""),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(56)
invokeTag('select','g',248,['id':("subSubStatus"),'class':("form-control"),'name':("subSubStatus"),'from':("")],-1)
printHtmlPart(57)
invokeTag('textField','g',254,['id':("recall"),'name':("recall"),'class':("recall form-control")],-1)
printHtmlPart(58)
invokeTag('textField','g',260,['maxlength':("10"),'minlength':("9"),'id':("telefonoContactado"),'name':("telefonoContactado"),'class':("form-control")],-1)
printHtmlPart(59)
expressionOut.print(cliente.apellidoPaterno)
printHtmlPart(30)
expressionOut.print(cliente.primerNombre)
printHtmlPart(60)
expressionOut.print(cliente.apellidoPaterno)
printHtmlPart(30)
expressionOut.print(cliente.primerNombre)
printHtmlPart(61)
invokeTag('select','g',318,['class':("form-control"),'name':("lugarEntrega"),'from':(['DOMICILIO', 'TRABAJO']),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(62)
invokeTag('select','g',324,['class':("form-control"),'name':("horarioEntrega"),'from':(['MAÑANA', 'TARDE', 'NOCHE']),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(63)
invokeTag('textField','g',327,['id':("fechaHoraEntrega"),'name':("fechaHoraEntrega"),'class':("recall form-control")],-1)
printHtmlPart(64)
invokeTag('textField','g',333,['class':("form-control"),'name':("nombreImpreso"),'value':("${cliente.primerNombre} ${cliente.apellidoPaterno}"),'disabled':("true")],-1)
printHtmlPart(65)
invokeTag('select','g',341,['class':("form-control"),'name':("lugarEntregaECuenta"),'from':(['DIGITAL','DOMICILIO', 'TRABAJO']),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(66)
invokeTag('textField','g',346,['class':("form-control"),'name':("emailEstadoCuenta"),'value':(cliente?.email)],-1)
printHtmlPart(67)
invokeTag('select','g',351,['class':("form-control"),'name':("seguroDesgravamen"),'from':(['SI','NO']),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(68)
invokeTag('select','g',356,['class':("form-control"),'name':("aceptaPlanConmigo"),'from':(['SI','NO']),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(69)
invokeTag('textField','g',361,['class':("form-control"),'name':("cedula"),'value':(cliente?.identificacion)],-1)
printHtmlPart(70)
invokeTag('textField','g',367,['class':("form-control"),'name':("apellidoPaterno"),'value':(cliente?.apellidoPaterno)],-1)
printHtmlPart(71)
invokeTag('textField','g',370,['class':("form-control"),'name':("apellidoMaterno"),'value':(cliente?.apellidoMaterno)],-1)
printHtmlPart(72)
invokeTag('textField','g',376,['class':("form-control"),'name':("primerNombre"),'value':(cliente?.primerNombre)],-1)
printHtmlPart(73)
invokeTag('textField','g',379,['class':("form-control"),'name':("segundoNombre"),'value':(cliente?.segundoNombre)],-1)
printHtmlPart(74)
invokeTag('select','g',389,['class':("form-control"),'id':("estadoCivil"),'name':("estadoCivil"),'from':(['DIVORCIADO': 'DIVORCIADO', 'SOLTERO': 'SOLTERO', 'CASADO' : 'CASADO', 'UNION LIBRE' : 'UNION LIBRE', 'VIUDO' : 'VIUDO']),'noSelection':(['': '-- Seleccione --']),'optionKey':("key"),'optionValue':("value")],-1)
printHtmlPart(75)
invokeTag('select','g',393,['class':("form-control"),'id':("genero"),'name':("genero"),'from':(['MASCULINO': 'MASCULINO', 'FEMENINO': 'FEMENINO']),'noSelection':(['': '-- Seleccione --']),'optionKey':("key"),'optionValue':("value")],-1)
printHtmlPart(76)
invokeTag('textField','g',398,['class':("form-control"),'name':("cargasFamiliares")],-1)
printHtmlPart(77)
invokeTag('textField','g',403,['class':("form-control datepicker"),'name':("fechaNacimientoGestion"),'onkeypress':("return soloLetras(event)")],-1)
printHtmlPart(78)
invokeTag('textField','g',411,['class':("form-control"),'name':("identificacionConyuge")],-1)
printHtmlPart(79)
invokeTag('textField','g',416,['class':("form-control"),'name':("apellido1Conyuge")],-1)
printHtmlPart(80)
invokeTag('textField','g',420,['class':("form-control"),'name':("apellido2Conyuge")],-1)
printHtmlPart(81)
invokeTag('textField','g',422,['class':("form-control"),'name':("nombre1Conyuge")],-1)
printHtmlPart(82)
invokeTag('textField','g',426,['class':("form-control"),'name':("nombre2Conyuge")],-1)
printHtmlPart(83)
invokeTag('select','g',431,['class':("form-control"),'id':("provinciaDomicilio"),'name':("provinciaDomicilio"),'optionKey':("id"),'noSelection':(['': '-- Seleccione --']),'from':(callcenter.Provincia.list(sort: "nombre", order: "asc")),'optionValue':({it.nombre})],-1)
printHtmlPart(84)
invokeTag('select','g',436,['class':("form-control"),'id':("ciudadDomicilio"),'name':("ciudadDomicilio"),'optionKey':({it.codigoUbicacion}),'noSelection':(['': '-- Seleccione --']),'from':(""),'optionValue':({it.nombre})],-1)
printHtmlPart(85)
invokeTag('select','g',443,['class':("form-control"),'id':("sectorDomicilio"),'name':("sectorDomicilio"),'optionKey':({it.codigoUbicacion}),'noSelection':(['': '-- Seleccione --']),'from':(""),'optionValue':({it.nombre})],-1)
printHtmlPart(86)
invokeTag('select','g',446,['class':("form-control"),'optionKey':("id"),'name':("barrioDomicilio"),'noSelection':(['': '-- Seleccione --']),'from':(""),'optionValue':({it.nombre})],-1)
printHtmlPart(87)
invokeTag('textField','g',453,['class':("form-control"),'name':("barrioNoDefinidoDomicilio")],-1)
printHtmlPart(88)
invokeTag('textField','g',458,['class':("form-control"),'name':("callePrincipalDomicilio"),'value':(cliente?.callePrincipalDomicilio)],-1)
printHtmlPart(89)
invokeTag('textField','g',467,['class':("form-control"),'name':("numeracionDomicilio"),'value':(cliente?.numeracionDomicilio)],-1)
printHtmlPart(90)
invokeTag('textField','g',472,['class':("form-control"),'name':("calleTransversalDomicilio"),'value':(cliente?.calletransversalDomicilio)],-1)
printHtmlPart(91)
invokeTag('textField','g',480,['class':("form-control"),'name':("referenciaDomicilio"),'value':(cliente?.referenciaDomicilio)],-1)
printHtmlPart(92)
invokeTag('select','g',494,['class':("form-control"),'id':("tipoVivienda"),'name':("tipoVivienda"),'from':(['VIVE CON FAMILIARES' : 'VIVE CON FAMILIARES','PROPIA HIPOTECADA' : 'PROPIA HIPOTECADA', 'PROPIA NO HIPOTECADA' : 'PROPIA NO HIPOTECADA', 'ARRENDADA' : 'ARRENDADA', 'PRESTADA' : 'PRESTADA']),'noSelection':(['': '-- Seleccione --']),'optionKey':("key"),'optionValue':("value")],-1)
printHtmlPart(93)
invokeTag('textField','g',501,['class':("form-control"),'id':("valorVivienda"),'name':("valorVivienda")],-1)
printHtmlPart(94)
invokeTag('textField','g',510,['class':("form-control"),'name':("emailPersonal"),'value':(cliente?.email)],-1)
printHtmlPart(95)
invokeTag('select','g',515,['class':("form-control"),'optionKey':("key"),'optionValue':("value"),'name':("origenIngresos"),'from':(callcenter.Clientes.getOrigenesIngresos())],-1)
printHtmlPart(96)
invokeTag('textField','g',518,['class':("form-control"),'name':("rucEmpresa"),'value':(cliente?.rucEmpresa)],-1)
printHtmlPart(97)
invokeTag('textField','g',521,['class':("form-control"),'name':("nombreLabora"),'value':(cliente?.nombreLabora)],-1)
printHtmlPart(98)
invokeTag('textField','g',524,['class':("form-control datepicker"),'name':("fechaInicioTrabajoActual")],-1)
printHtmlPart(99)
invokeTag('select','g',533,['class':("form-control"),'optionKey':("key"),'optionValue':("value"),'name':("cargo"),'from':(['ADMINISTRATIVO': 'ADMINISTRATIVO', 'EJECUTIVO': 'EJECUTIVO', 'GERENTE': 'GERENTE', 'MANDO MEDIO': 'MANDO MEDIO', 'OBRERO': 'OBRERO', 'OPERARIO': 'OPERARIO', 'PROPIETARIO': 'PROPIETARIO', 'SUPERVISOR': 'SUPERVISOR', 'VENDEDOR': 'VENDEDOR', 'DOCENTE': 'DOCENTE']),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(100)
invokeTag('select','g',539,['class':("form-control"),'id':("provinciaTrabajo"),'name':("provinciaTrabajo"),'optionKey':("id"),'noSelection':(['': '-- Seleccione --']),'from':(callcenter.Provincia.list(sort: "nombre", order: "asc")),'optionValue':({it.nombre})],-1)
printHtmlPart(101)
invokeTag('select','g',545,['class':("form-control"),'id':("ciudadTrabajo"),'name':("ciudadTrabajo"),'optionKey':({it.codigoUbicacion}),'noSelection':(['': '-- Seleccione --']),'from':(""),'optionValue':({it.nombre})],-1)
printHtmlPart(102)
invokeTag('select','g',552,['class':("form-control"),'id':("sectorTrabajo"),'name':("sectorTrabajo"),'optionKey':({it.codigoUbicacion}),'noSelection':(['': '-- Seleccione --']),'from':(""),'optionValue':({it.nombre})],-1)
printHtmlPart(103)
invokeTag('select','g',558,['class':("form-control"),'id':("barrioTrabajodiv"),'name':("barrioTrabajodiv"),'optionKey':("id"),'noSelection':(['': '-- Seleccione --']),'from':(""),'optionValue':({it.nombre})],-1)
printHtmlPart(104)
invokeTag('textField','g',561,['class':("form-control"),'name':("barrioNoDefinidoTrabajo")],-1)
printHtmlPart(105)
invokeTag('textField','g',564,['class':("form-control"),'name':("callePrincipalTrabajo"),'value':(cliente?.callePrincipalTrabajo)],-1)
printHtmlPart(106)
invokeTag('textField','g',565,['class':("form-control"),'name':("numeracionTrabajo"),'value':(cliente?.numeracionTrabajo)],-1)
printHtmlPart(107)
invokeTag('textField','g',567,['class':("form-control"),'name':("calleTransversalTrabajo"),'value':(cliente?.calletransversalTrabajo)],-1)
printHtmlPart(108)
invokeTag('textField','g',572,['class':("form-control"),'name':("referenciaTrabajo"),'value':(cliente?.referenciaTrabajo)],-1)
printHtmlPart(109)
invokeTag('textField','g',580,['maxlength':("10"),'minlength':("8"),'class':("form-control"),'id':("telefonoPrincipal"),'name':("telefonoPrincipal"),'value':(cliente?.telefono1)],-1)
printHtmlPart(110)
invokeTag('textField','g',585,['maxlength':("10"),'minlength':("8"),'class':("form-control"),'id':("telefonoSecundario"),'name':("telefonoSecundario"),'value':(cliente?.telefono2)],-1)
printHtmlPart(111)
invokeTag('textField','g',590,['maxlength':("10"),'minlength':("8"),'class':("form-control"),'id':("telefonoTrabajo"),'name':("telefonoTrabajo"),'value':(cliente?.telefonoTrabajo)],-1)
printHtmlPart(112)
invokeTag('textField','g',595,['maxlength':("10"),'minlength':("8"),'class':("form-control"),'id':("celular"),'name':("celular"),'value':(cliente?.telefono3)],-1)
printHtmlPart(113)
invokeTag('textField','g',604,['class':("form-control"),'name':("sueldoIngresos"),'value':(cliente?.sueldoIngresos)],-1)
printHtmlPart(114)
invokeTag('textField','g',606,['class':("form-control"),'name':("rentas"),'value':("0")],-1)
printHtmlPart(115)
invokeTag('textField','g',608,['class':("form-control"),'name':("remesas"),'value':("0")],-1)
printHtmlPart(116)
invokeTag('textField','g',612,['class':("form-control"),'name':("ingresoFamiliares"),'value':("0")],-1)
printHtmlPart(117)
invokeTag('textField','g',616,['class':("form-control"),'name':("otrosIngresos"),'value':("0")],-1)
printHtmlPart(118)
invokeTag('textField','g',627,['class':("form-control"),'name':("gastosBasicos"),'value':(cliente?.gastosBasicos)],-1)
printHtmlPart(119)
invokeTag('textField','g',627,['class':("form-control"),'name':("serviciosBasicos"),'value':("0")],-1)
printHtmlPart(120)
invokeTag('textField','g',631,['class':("form-control"),'name':("transporte"),'value':("0")],-1)
printHtmlPart(121)
invokeTag('textField','g',634,['class':("form-control"),'name':("otrosGastos"),'value':("0")],-1)
printHtmlPart(122)
invokeTag('textField','g',642,['class':("form-control"),'name':("activoBien")],-1)
printHtmlPart(123)
invokeTag('textField','g',643,['class':("form-control"),'name':("valorUnitarioBien"),'value':("0")],-1)
printHtmlPart(124)
invokeTag('textField','g',649,['class':("form-control"),'name':("apellido1RefPersonal"),'value':(cliente?.apellido1RefPersonal)],-1)
printHtmlPart(71)
invokeTag('textField','g',652,['class':("form-control"),'name':("apellido2RefPersonal"),'value':(cliente?.apellido2RefPersonal)],-1)
printHtmlPart(72)
invokeTag('textField','g',657,['class':("form-control"),'name':("nombre1RefPersonal"),'value':(cliente?.nombre1RefPersonal)],-1)
printHtmlPart(73)
invokeTag('textField','g',659,['class':("form-control"),'name':("nombre2RefPersonal"),'value':(cliente?.nombre2RefPersonal)],-1)
printHtmlPart(125)
invokeTag('textField','g',665,['class':("form-control"),'name':("telefonoRefPersonal"),'maxlength':("9"),'minlength':("9"),'value':(cliente?.telefonoRefPersonal)],-1)
printHtmlPart(126)
invokeTag('textField','g',668,['class':("form-control"),'name':("celularRefPersonal"),'maxlength':("10"),'minlength':("8")],-1)
printHtmlPart(127)
invokeTag('textField','g',682,['class':("form-control"),'id':("telefonoCelularSMS"),'name':("telefonoCelularSMS"),'maxlength':("10"),'minlength':("10")],-1)
printHtmlPart(128)
expressionOut.print(cliente.apellidoPaterno)
printHtmlPart(30)
expressionOut.print(cliente.primerNombre)
printHtmlPart(129)
expressionOut.print(cliente.apellidoPaterno)
printHtmlPart(30)
expressionOut.print(cliente.primerNombre)
printHtmlPart(130)
invokeTag('select','g',750,['class':("form-control"),'optionKey':("key"),'optionValue':("value"),'name':("diaPago"),'from':(['1-15': '1-15', '3-17': '3-17', '6-20': '6-20', '7-21': '7-21', '11-25': '11-25', '13-27': '13-27', '14-28': '14-28',
																																  '18-1': '18-1', '21-4' : '21-4', '24-7' : '24-7', '27-10' : '27-10']),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(131)
invokeTag('textArea','g',782,['class':("form-control"),'name':("observaciones"),'value':(cliente?.observaciones)],-1)
printHtmlPart(132)
invokeTag('submitButton','g',786,['id':("send"),'name':("btnGuardarCliente"),'class':("btn btn-success"),'value':("Guardar Gestión")],-1)
printHtmlPart(133)
})
invokeTag('form','g',786,['action':("guardarCliente")],1)
printHtmlPart(134)
invokeTag('javascript','asset',788,['src':("gestion/gestionCliente.js")],-1)
printHtmlPart(4)
invokeTag('javascript','asset',790,['src':("usogeneral/datetimepicker.js")],-1)
printHtmlPart(4)
invokeTag('javascript','asset',791,['src':("usogeneral/customdatetimepicker.js")],-1)
printHtmlPart(4)
invokeTag('javascript','asset',793,['src':("usogeneral/bootstrap-datepicker.min.js")],-1)
printHtmlPart(4)
invokeTag('javascript','asset',794,['src':("usogeneral/customdatepicker.js")],-1)
printHtmlPart(4)
invokeTag('javascript','asset',795,['src':("usogeneral/bootstrap-datepicker.es.min.js")],-1)
printHtmlPart(135)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1626135828767L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
