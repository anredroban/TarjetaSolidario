import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tarjetaSolidario_gestionNovedadesgestionCliente_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/gestionNovedades/gestionCliente.gsp" }
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
printHtmlPart(0)
invokeTag('javascript','asset',7,['src':("gestionNovedades/gestionCliente.js")],-1)
printHtmlPart(4)
expressionOut.print(cliente.cedula)
printHtmlPart(5)
expressionOut.print(cliente.nombres)
printHtmlPart(6)
if(true && (cliente.direccionCorreccion && cliente.direccionCorreccion.trim() != '')) {
printHtmlPart(7)
expressionOut.print(cliente.direccionCorreccion)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (cliente.telefonoCelular && cliente.telefonoCelular.trim() != '')) {
printHtmlPart(10)
expressionOut.print(cliente.telefonoCelular)
printHtmlPart(8)
}
printHtmlPart(11)
if(true && (cliente.telefono3 && cliente.telefono3.trim() != '')) {
printHtmlPart(12)
expressionOut.print(cliente.telefono3)
printHtmlPart(8)
}
printHtmlPart(11)
if(true && (cliente.telefono4 && cliente.telefono4.trim() != '')) {
printHtmlPart(13)
expressionOut.print(cliente.telefono4)
printHtmlPart(8)
}
printHtmlPart(11)
if(true && (cliente.telefono5 && cliente.telefono5.trim() != '')) {
printHtmlPart(14)
expressionOut.print(cliente.telefono5)
printHtmlPart(8)
}
printHtmlPart(11)
if(true && (cliente.celular2 && cliente.celular2.trim() != '')) {
printHtmlPart(15)
expressionOut.print(cliente.celular2)
printHtmlPart(8)
}
printHtmlPart(11)
if(true && (cliente.celular3 && cliente.celular3.trim() != '')) {
printHtmlPart(16)
expressionOut.print(cliente.celular3)
printHtmlPart(8)
}
printHtmlPart(11)
if(true && (cliente.celular4 && cliente.celular4.trim() != '')) {
printHtmlPart(17)
expressionOut.print(cliente.celular4)
printHtmlPart(8)
}
printHtmlPart(11)
if(true && (cliente.celular5 && cliente.celular5.trim() != '')) {
printHtmlPart(18)
expressionOut.print(cliente.celular5)
printHtmlPart(8)
}
printHtmlPart(19)
createTagBody(1, {->
printHtmlPart(20)
expressionOut.print(cliente.id)
printHtmlPart(21)
invokeTag('select','g',106,['class':("form-control"),'name':("status"),'id':("status"),'from':(callcenter.Estado.list()),'optionKey':("id"),'optionValue':({it.nombre	}),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(22)
invokeTag('select','g',112,['class':("form-control"),'name':("substatus"),'id':("substatus"),'from':(""),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(23)
invokeTag('select','g',118,['id':("subSubStatus"),'class':("form-control"),'name':("subSubStatus"),'from':("")],-1)
printHtmlPart(24)
invokeTag('textField','g',124,['id':("recall"),'name':("recall"),'class':("recall form-control")],-1)
printHtmlPart(25)
invokeTag('textField','g',130,['maxlength':("10"),'minlength':("9"),'id':("telefonoContactado"),'name':("telefonoContactado"),'class':("form-control")],-1)
printHtmlPart(26)
invokeTag('select','g',140,['class':("form-control"),'name':("lugarEntrega"),'from':(['DOMICILIO', 'TRABAJO']),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(27)
invokeTag('textField','g',145,['id':("fechaHoraEntrega"),'name':("fechaHoraEntrega"),'class':("recall form-control")],-1)
printHtmlPart(28)
invokeTag('select','g',150,['class':("form-control"),'id':("provinciaEntrega"),'name':("provinciaEntrega"),'optionKey':("id"),'noSelection':(['': '-- Seleccione --']),'from':(callcenter.Provincia.list(sort: "nombre", order: "asc")),'optionValue':({it.nombre})],-1)
printHtmlPart(29)
invokeTag('select','g',155,['class':("form-control"),'id':("ciudadEntrega"),'name':("ciudadEntrega"),'optionKey':({it.codigoUbicacion}),'noSelection':(['': '-- Seleccione --']),'from':(""),'optionValue':({it.nombre})],-1)
printHtmlPart(30)
invokeTag('select','g',160,['class':("form-control"),'id':("parroquiaEntrega"),'name':("parroquiaEntrega"),'optionKey':({it.codigoUbicacion}),'noSelection':(['': '-- Seleccione --']),'from':(""),'optionValue':({it.nombre})],-1)
printHtmlPart(31)
invokeTag('select','g',165,['class':("form-control"),'name':("barrioEntrega"),'optionKey':("id"),'noSelection':(['': '-- Seleccione --']),'from':(""),'optionValue':({it.nombre})],-1)
printHtmlPart(32)
invokeTag('textField','g',170,['class':("form-control"),'name':("barrioNoDefinido")],-1)
printHtmlPart(33)
invokeTag('textField','g',175,['class':("form-control"),'name':("callePrincipalEntrega")],-1)
printHtmlPart(34)
invokeTag('textField','g',179,['class':("form-control"),'name':("numeracionEntrega")],-1)
printHtmlPart(35)
invokeTag('textField','g',184,['class':("form-control"),'name':("calletransversalEntrega")],-1)
printHtmlPart(36)
invokeTag('textArea','g',189,['class':("form-control"),'name':("referenciaEntrega")],-1)
printHtmlPart(37)
invokeTag('textField','g',197,['maxlength':("10"),'minlength':("8"),'class':("form-control"),'id':("telefonoPrincipal"),'name':("telefonoPrincipal"),'value':(cliente?.telefonoPrincipal)],-1)
printHtmlPart(38)
invokeTag('textField','g',201,['maxlength':("10"),'minlength':("8"),'class':("form-control"),'id':("telefonoSecundario"),'name':("telefonoSecundario"),'value':(cliente?.telefonoSecundario)],-1)
printHtmlPart(39)
invokeTag('select','g',209,['class':("form-control"),'name':("imputable"),'from':(['CALL CENTER', 'COURIER', 'NO IMPUTABLE']),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(40)
invokeTag('textArea','g',214,['class':("form-control"),'id':("observacionesImputable"),'name':("observacionesImputable")],-1)
printHtmlPart(41)
invokeTag('textArea','g',223,['class':("form-control"),'name':("observaciones"),'value':(cliente?.observaciones)],-1)
printHtmlPart(42)
invokeTag('submitButton','g',227,['id':("send"),'name':("btnGuardarCliente"),'class':("btn btn-success"),'value':("Guardar Gestión")],-1)
printHtmlPart(43)
})
invokeTag('form','g',230,['action':("guardarCliente")],1)
printHtmlPart(3)
invokeTag('javascript','asset',232,['src':("gestionNovedades/gestionCliente.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',233,['src':("usogeneral/datetimepicker.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',234,['src':("usogeneral/customdatetimepicker.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',235,['src':("usogeneral/bootstrap-datepicker.min.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',236,['src':("usogeneral/customdatepicker.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',237,['src':("usogeneral/bootstrap-datepicker.es.min.js")],-1)
printHtmlPart(44)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1556071036897L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
