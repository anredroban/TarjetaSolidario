import utilitarios.Util
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tarjetaSolidario_layouts_sidebar_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/_sidebar.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (actionName == "dashboard")) {
printHtmlPart(1)
}
printHtmlPart(2)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(3)
if(true && (Util.checkAccess(session.user.usuario, '/permiso/index') || Util.checkAccess(session.user.usuario, '/rol/index') || Util.checkAccess(session.user.usuario, '/usuario/index'))) {
printHtmlPart(4)
if(true && (Util.checkAccess(session.user.usuario, '/permiso/index'))) {
printHtmlPart(5)
if(true && (controllerName == "permiso")) {
printHtmlPart(6)
}
printHtmlPart(7)
expressionOut.print(createLink(uri: '/permiso/'))
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (Util.checkAccess(session.user.usuario, '/rol/index'))) {
printHtmlPart(5)
if(true && (controllerName == "rol")) {
printHtmlPart(10)
}
printHtmlPart(7)
expressionOut.print(createLink(uri: '/rol/'))
printHtmlPart(11)
}
printHtmlPart(9)
if(true && (Util.checkAccess(session.user.usuario, '/usuario/index'))) {
printHtmlPart(5)
if(true && (controllerName == "usuario" && actionName != "dashboard")) {
printHtmlPart(12)
}
printHtmlPart(7)
expressionOut.print(createLink(uri: '/usuario/'))
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (controllerName == "gestion" && actionName == "cargarBase")) {
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(createLink(uri: '/gestion/cargarBase'))
printHtmlPart(17)
if(true && (controllerName == "cargarNovedades")) {
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(createLink(uri: '/cargarNovedades/cargarBase'))
printHtmlPart(18)
if(true && (controllerName == "gestion" && actionName == "retirarBase")) {
printHtmlPart(19)
}
printHtmlPart(16)
expressionOut.print(createLink(uri: '/gestion/retirarBase'))
printHtmlPart(20)
if(true && (controllerName == "gestion" && actionName == "retirarBaseNovedades")) {
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(createLink(uri: '/gestion/retirarBaseNovedades'))
printHtmlPart(21)
if(true && (controllerName == "asignarBaseNew" && actionName == "index")) {
printHtmlPart(19)
}
printHtmlPart(16)
expressionOut.print(createLink(uri: '/asignarBaseNew/index'))
printHtmlPart(22)
if(true && (controllerName == "asignarNovedades")) {
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(createLink(uri: '/asignarNovedades/index'))
printHtmlPart(23)
if(true && (controllerName == "habilitarBase")) {
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(createLink(uri: '/habilitarBase/index'))
printHtmlPart(24)
if(true && (Util.checkAccess(session.user.usuario, '/reportes/bitacoraPrincipales')||Util.checkAccess(session.user.usuario, '/reportes/gerencial'))) {
printHtmlPart(25)
if(true && (Util.checkAccess(session.user.usuario, '/reportes/baseGestionada'))) {
printHtmlPart(26)
if(true && (actionName == "baseGestionada")) {
printHtmlPart(19)
}
printHtmlPart(27)
expressionOut.print(createLink(uri: '/reportes/baseGestionada'))
printHtmlPart(28)
}
printHtmlPart(9)
if(true && (Util.checkAccess(session.user.usuario, '/reportes/bitacoraPrincipales'))) {
printHtmlPart(26)
if(true && (actionName == "bitacoraPrincipales")) {
printHtmlPart(19)
}
printHtmlPart(27)
expressionOut.print(createLink(uri: '/reportes/bitacoraPrincipales'))
printHtmlPart(29)
}
printHtmlPart(30)
if(true && (Util.checkAccess(session.user.usuario, '/reportes/bitacoraCourier'))) {
printHtmlPart(26)
if(true && (actionName == "bitacoraCourier")) {
printHtmlPart(19)
}
printHtmlPart(27)
expressionOut.print(createLink(uri: '/reportes/bitacoraCourier'))
printHtmlPart(31)
}
printHtmlPart(30)
if(true && (Util.checkAccess(session.user.usuario, '/reportes/bitacoraSolicitudes'))) {
printHtmlPart(26)
if(true && (actionName == "bitacoraSolicitudes")) {
printHtmlPart(19)
}
printHtmlPart(27)
expressionOut.print(createLink(uri: '/reportes/bitacoraSolicitudes'))
printHtmlPart(32)
}
printHtmlPart(30)
if(true && (Util.checkAccess(session.user.usuario, '/reportes/bitacoraVentas'))) {
printHtmlPart(26)
if(true && (actionName == "bitacoraVentas")) {
printHtmlPart(19)
}
printHtmlPart(27)
expressionOut.print(createLink(uri: '/reportes/bitacoraVentas'))
printHtmlPart(33)
}
printHtmlPart(30)
if(true && (Util.checkAccess(session.user.usuario, '/reportes/bitacoraCallTypes'))) {
printHtmlPart(26)
if(true && (actionName == "bitacoraCallTypes")) {
printHtmlPart(19)
}
printHtmlPart(27)
expressionOut.print(createLink(uri: '/reportes/bitacoraCallTypes'))
printHtmlPart(34)
}
printHtmlPart(30)
if(true && (Util.checkAccess(session.user.usuario, '/reportes/indicadoresGestion'))) {
printHtmlPart(26)
if(true && (actionName == "indicadoresGestion")) {
printHtmlPart(19)
}
printHtmlPart(27)
expressionOut.print(createLink(uri: '/reportes/indicadoresGestion'))
printHtmlPart(35)
}
printHtmlPart(9)
if(true && (Util.checkAccess(session.user.usuario, '/reportes/tiemposBreak'))) {
printHtmlPart(26)
if(true && (actionName == "tiemposBreak")) {
printHtmlPart(19)
}
printHtmlPart(27)
expressionOut.print(createLink(uri: '/reportes/tiemposBreak'))
printHtmlPart(36)
}
printHtmlPart(9)
if(true && (Util.checkAccess(session.user.usuario, '/reportes/loginAgentes'))) {
printHtmlPart(26)
if(true && (actionName == "loginAgentes")) {
printHtmlPart(19)
}
printHtmlPart(27)
expressionOut.print(createLink(uri: '/reportes/loginAgentes'))
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(39)
if(true && (Util.checkAccess(session.user.usuario, '/reportes/bitacoraPrincipales')||Util.checkAccess(session.user.usuario, '/reportes/gerencial'))) {
printHtmlPart(40)
if(true && (Util.checkAccess(session.user.usuario, '/reportes/bitacoraNovedades'))) {
printHtmlPart(41)
if(true && (actionName == "bitacoraNovedades")) {
printHtmlPart(42)
}
printHtmlPart(43)
expressionOut.print(createLink(uri: '/reportes/bitacoraNovedades'))
printHtmlPart(44)
}
printHtmlPart(45)
if(true && (Util.checkAccess(session.user.usuario, '/reportes/baseGestionadaNovedades'))) {
printHtmlPart(41)
if(true && (actionName == "baseGestionadaNovedades")) {
printHtmlPart(42)
}
printHtmlPart(43)
expressionOut.print(createLink(uri: '/reportes/baseGestionadaNovedades'))
printHtmlPart(46)
}
printHtmlPart(47)
}
printHtmlPart(48)
}
printHtmlPart(49)
if(true && (controllerName == "gestion" && (actionName == "index" || actionName == "gestionCliente"))) {
printHtmlPart(1)
}
printHtmlPart(2)
expressionOut.print(createLink(uri: '/gestion/index'))
printHtmlPart(50)
if(true && (controllerName == "gestionNovedades")) {
printHtmlPart(1)
}
printHtmlPart(2)
expressionOut.print(createLink(uri: '/gestionNovedades/index'))
printHtmlPart(51)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1581375481351L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
