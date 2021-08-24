import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tarjetaSolidario_cargarNovedadescargarBase_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cargarNovedades/cargarBase.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
invokeTag('stylesheet','asset',7,['src':("usogeneral/breadcrumb.css")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',8,['src':("usogeneral/breadcrumb.js")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(3)
if(true && (flash.error)) {
printHtmlPart(5)
expressionOut.print(flash.error)
printHtmlPart(6)
}
printHtmlPart(7)
invokeTag('render','g',17,['template':("/layouts/breadcrumb"),'model':([totalTabs:['Cargar archivo', 'Asignar Campos', 'Completar']])],-1)
printHtmlPart(1)
if(true && (!success)) {
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
invokeTag('submitButton','g',30,['name':("load"),'class':("save btn btn-navigation"),'value':("Siguiente")],-1)
printHtmlPart(10)
})
invokeTag('uploadForm','g',33,['action':("saveFile"),'class':("form-horizontal")],3)
printHtmlPart(11)
}
else {
printHtmlPart(12)
invokeTag('render','g',39,['template':("/layouts/completeMessage")],-1)
printHtmlPart(13)
createClosureForHtmlPart(14, 3)
invokeTag('javascript','g',41,[:],3)
printHtmlPart(1)
}
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',44,[:],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1554222080964L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
