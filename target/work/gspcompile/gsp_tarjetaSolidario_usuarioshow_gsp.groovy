import com.pw.security.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tarjetaSolidario_usuarioshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'usuario.label', default: 'Usuario'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',14,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',14,['class':("list"),'action':("index")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('fieldValue','g',27,['bean':(usuarioInstance),'field':("nombre")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',36,['bean':(usuarioInstance),'field':("cedula")],-1)
printHtmlPart(11)
invokeTag('fieldValue','g',40,['bean':(usuarioInstance),'field':("nombre")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',44,['bean':(usuarioInstance),'field':("usuario")],-1)
printHtmlPart(13)
createTagBody(2, {->
expressionOut.print(usuarioInstance?.rol.nombre?.encodeAsHTML())
})
invokeTag('link','g',52,['controller':("rol"),'action':("show"),'id':(usuarioInstance?.rol?.id)],2)
printHtmlPart(14)
invokeTag('fieldValue','g',56,['bean':(usuarioInstance),'field':("estado")],-1)
printHtmlPart(15)
invokeTag('formatDate','g',60,['date':(usuarioInstance?.dateCreated),'format':("yyyy-MM-dd HH:mm:ss")],-1)
printHtmlPart(16)
invokeTag('formatDate','g',64,['date':(usuarioInstance?.lastUpdated),'format':("yyyy-MM-dd HH:mm:ss")],-1)
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
invokeTag('actionSubmit','g',76,['class':("form-control btn btn-success"),'action':("edit"),'value':("Editar")],-1)
printHtmlPart(19)
})
invokeTag('form','g',76,['url':([resource:usuarioInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',77,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1556134743315L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
