import callcenter.Clientes
import com.pw.security.*
import utilitarios.Util
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tarjetaSolidario_usuariodashboard_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/dashboard.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
createTagBody(2, {->
createClosureForHtmlPart(5, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
invokeTag('javascript','asset',10,['src':("usogeneral/moment.min.js")],-1)
printHtmlPart(4)
invokeTag('javascript','asset',11,['src':("usuario/dashboard.js")],-1)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
expressionOut.print(createLink(uri:'/usuario/'))
printHtmlPart(9)
expressionOut.print(Util.getOperadoresLogueados())
printHtmlPart(10)
expressionOut.print(createLink(uri:'#'))
printHtmlPart(11)
expressionOut.print(Util.getContactados())
printHtmlPart(12)
expressionOut.print(createLink(uri:'#'))
printHtmlPart(13)
expressionOut.print(Util.getCantidadVentasExitosas())
printHtmlPart(14)
expressionOut.print(createLink(uri:'#'))
printHtmlPart(15)
expressionOut.print(Util.getAExitosasMes())
printHtmlPart(16)
expressionOut.print(createLink(uri:'#'))
printHtmlPart(17)
expressionOut.print(Util.getContactabilidadMensual())
printHtmlPart(18)
for( _it1952013049 in (inicioSesion) ) {
changeItVariable(_it1952013049)
printHtmlPart(19)
expressionOut.print(it[0])
printHtmlPart(20)
expressionOut.print(it[1])
printHtmlPart(20)
expressionOut.print(it[2]?:'Activa')
printHtmlPart(21)
}
printHtmlPart(22)
for( _it375639324 in (tablaResultAgente) ) {
changeItVariable(_it375639324)
printHtmlPart(19)
expressionOut.print(it[0])
printHtmlPart(20)
expressionOut.print(it[1])
printHtmlPart(20)
expressionOut.print(it[2]?:0)
printHtmlPart(21)
}
printHtmlPart(23)
for( _it1915679935 in (tablaResult) ) {
changeItVariable(_it1915679935)
printHtmlPart(19)
expressionOut.print(it[0])
printHtmlPart(20)
expressionOut.print(it[1])
printHtmlPart(20)
expressionOut.print(it[2]?:0)
printHtmlPart(20)
expressionOut.print(it[3]?:0)
printHtmlPart(21)
}
printHtmlPart(24)
expressionOut.print(totalGestionados)
printHtmlPart(25)
expressionOut.print(totalContactados)
printHtmlPart(25)
expressionOut.print(totalNoContactados)
printHtmlPart(26)
for( _it1757831721 in (tablaResult1) ) {
changeItVariable(_it1757831721)
printHtmlPart(19)
expressionOut.print(it[0])
printHtmlPart(20)
expressionOut.print(it[1])
printHtmlPart(20)
expressionOut.print(it[2]?:0)
printHtmlPart(21)
}
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',357,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1628185905474L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
