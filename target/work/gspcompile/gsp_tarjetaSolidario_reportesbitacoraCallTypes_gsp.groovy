import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tarjetaSolidario_reportesbitacoraCallTypes_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/reportes/bitacoraCallTypes.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',2,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',3,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',4,['src':("usogeneral/moment.min.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',5,['src':("usogeneral/daterangepicker.js")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',6,['src':("usogeneral/daterangepicker.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',7,['src':("usogeneral/datetimepicker.css")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',8,['src':("usogeneral/customdaterangepicker.js")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',9,['src':("usogeneral/customdaterangepicker.css")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',11,['src':("usogeneral/datetimepicker.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',12,['src':("usogeneral/customdatetimepicker.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',13,['src':("usogeneral/bootstrap-datepicker.min.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',14,['src':("usogeneral/customdatepicker.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',15,['src':("usogeneral/bootstrap-datepicker.es.min.js")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('select','g',34,['class':("form-control"),'name':("nombreBase"),'multiple':("true"),'size':("10"),'required':(""),'from':(utilitarios.Util.getNombresBaseCallTypes())],-1)
printHtmlPart(4)
invokeTag('submitButton','g',39,['class':("btn btn-success"),'name':("btnEnviar"),'value':("Generar archivo")],-1)
printHtmlPart(5)
})
invokeTag('form','g',41,['action':("bitacoraCallTypes"),'class':("col-lg-12")],1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1550593912710L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
