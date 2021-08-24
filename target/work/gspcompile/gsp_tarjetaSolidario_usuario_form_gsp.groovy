import com.pw.security.Usuario
import utilitarios.Util
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tarjetaSolidario_usuario_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'cedula', 'error'))
printHtmlPart(2)
invokeTag('message','g',6,['code':("usuario.nombre.label"),'default':("Cédula")],-1)
printHtmlPart(3)
invokeTag('textField','g',9,['class':("form-control"),'name':("cedula"),'required':(""),'value':(usuarioInstance?.cedula)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'nombre', 'error'))
printHtmlPart(2)
invokeTag('message','g',15,['code':("usuario.nombre.label"),'default':("Nombre")],-1)
printHtmlPart(3)
invokeTag('textField','g',18,['class':("form-control"),'name':("nombre"),'required':(""),'value':(usuarioInstance?.nombre)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'usuario', 'error'))
printHtmlPart(6)
invokeTag('message','g',26,['code':("usuario.usuario.label"),'default':("Usuario")],-1)
printHtmlPart(3)
invokeTag('textField','g',29,['class':("form-control"),'name':("usuario"),'required':(""),'value':(usuarioInstance?.usuario)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'password', 'error'))
printHtmlPart(8)
invokeTag('message','g',39,['code':("usuario.password.label"),'default':("Password")],-1)
printHtmlPart(3)
invokeTag('textField','g',42,['class':("form-control"),'name':("password"),'required':(""),'value':(usuarioInstance?.password)],-1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'extent', 'error'))
printHtmlPart(10)
invokeTag('message','g',50,['code':("usuario.extent.label"),'default':("Extension")],-1)
printHtmlPart(3)
invokeTag('textField','g',53,['class':("form-control"),'name':("extent"),'value':(usuarioInstance?.extent)],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'rol', 'error'))
printHtmlPart(12)
invokeTag('message','g',59,['code':("usuario.rol.label"),'default':("Rol")],-1)
printHtmlPart(3)
if(true && (Util.isAdmin(session.user.usuario))) {
printHtmlPart(13)
invokeTag('select','g',63,['id':("rol"),'name':("rol.id"),'from':(com.pw.security.Rol.list()),'optionKey':("id"),'required':(""),'value':(usuarioInstance?.rol?.id),'class':("form-control"),'optionValue':({it.nombre})],-1)
printHtmlPart(14)
}
else {
printHtmlPart(13)
invokeTag('select','g',66,['id':("rol"),'name':("rol.id"),'from':(utilitarios.Util.getRoles()),'optionKey':("id"),'required':(""),'value':(usuarioInstance?.rol?.id),'class':("form-control"),'optionValue':({it.nombre})],-1)
printHtmlPart(14)
}
printHtmlPart(15)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'estado', 'error'))
printHtmlPart(16)
invokeTag('message','g',73,['code':("usuario.estado.label"),'default':("Estado")],-1)
printHtmlPart(3)
invokeTag('select','g',76,['class':("form-control"),'name':("estado"),'from':(usuarioInstance.constraints.estado.inList),'required':(""),'value':(usuarioInstance?.estado),'valueMessagePrefix':("usuario.estado")],-1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1556131849197L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
