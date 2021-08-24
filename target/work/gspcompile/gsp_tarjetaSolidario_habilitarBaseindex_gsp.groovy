import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tarjetaSolidario_habilitarBaseindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/habilitarBase/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
invokeTag('captureMeta','sitemesh',1,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(0)
invokeTag('select','g',12,['name':("habiles"),'size':("10"),'class':("form-control"),'multiple':(""),'from':(utilitarios.Util.getNombresBase())],-1)
printHtmlPart(1)
invokeTag('select','g',20,['name':("noHabiles"),'size':("10"),'class':("form-control"),'multiple':(""),'from':(utilitarios.Util.getBasesNoHabiles())],-1)
printHtmlPart(2)
invokeTag('select','g',35,['name':("habilesNovedades"),'size':("10"),'class':("form-control"),'multiple':(""),'from':(utilitarios.Util.getNombresBaseNovedades())],-1)
printHtmlPart(3)
invokeTag('select','g',43,['name':("noHabilesNovedades"),'size':("10"),'class':("form-control"),'multiple':(""),'from':(utilitarios.Util.getBasesNoHabilesNovedades())],-1)
printHtmlPart(4)
invokeTag('javascript','asset',1,['src':("habilitarBase/index.js")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1554342146807L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
