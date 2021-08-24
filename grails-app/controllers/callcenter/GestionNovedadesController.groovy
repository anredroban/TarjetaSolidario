package callcenter

import com.pw.security.Usuario

class GestionNovedadesController {

    static beforeInterceptor = {
        String accion = actionUri
        if(!accion.equals("/usuario/login") && !accion.equals("/usuario/logout")){
            if(!session.user){
                redirect(uri: "/usuario/login")
                return false;
            }else{
                boolean tienePermiso = utilitarios.Util.checkAccess(session.user.usuario, accion)
                if(!tienePermiso){
                    render "No tienes permiso para ingresar a este sitio-> "+accion
                }
            }
        }
    }

    /**
     * @author Giovanny Granda
     * Muestra en pantalla los clientes asignados
     * @return
     */
    def index() {
        Usuario usuario = Usuario.findById(session.user.id)

        def clients = ClientesNovedades.withCriteria {
            eq('usuario',usuario)
            eq('isEnable', true)
            subestadoGestion {
                or{
                    eq('type', Subestado.constraints.type.inList[0].toString())
                    eq('type', Subestado.constraints.type.inList[1].toString())
                }
            }
            order("intentos")
        }
        def clientsNoManagement = ClientesNovedades.withCriteria {
            eq('usuario',usuario)
            eq('isEnable', true)
            isNull('subestadoGestion')
        }

        clients.each {client ->
            clientsNoManagement.add(client)
        }

        [clientesGestionar: clientsNoManagement]
    }

    /**
     * @author Giovanny Granda
     * Muestra la pantalla de gestion donde se hara rectificación de datos
     * @param id
     * @return
     */
    def gestionCliente(long id){

        int idCliente = id
        ClientesNovedades cliente = ClientesNovedades.findById(idCliente)
        [cliente: cliente]
    }

    def guardarCliente(){
        Usuario usuario = Usuario.findById(session.user.id.toString().toLong())
        Date fechaActual = new Date()
        long idCliente = params.idCliente.toLong()
        long idEstadoGestion = params.status.toLong()
        long idSubestadoGestion = params.substatus.toLong()
        long idSubSubestadoGestion = params.subSubStatus.toLong()
        String estadoGestion = Estado.findById(idEstadoGestion).nombre
        Subestado objSubestadoGestion = Subestado.findById(idSubestadoGestion)
        SubSubestado objSubSubestadoGestion = SubSubestado.findById(idSubSubestadoGestion)
        int tiempoLlamada = 0
        if(objSubestadoGestion.rangoTiempo){
            String[] tiempos = objSubestadoGestion.rangoTiempo.split('-')
            int t0 = tiempos[0].toInteger()
            int t1 = tiempos[1].toInteger()
            tiempoLlamada = Math.floor(Math.random()*(t1-t0+1)+t0)
        }

        //Busco el cliente por su id
        ClientesNovedades cliente = ClientesNovedades.findById(idCliente)
        int intentos = cliente.intentos?: 0
        if(objSubSubestadoGestion.name.equalsIgnoreCase("VENTA")){
            cliente.lugarEntrega = params.lugarEntrega
            cliente.fechaEntrega = new Date().parse('yyyy-MM-dd HH:mm:ss', params.fechaHoraEntrega.toString().replace('/','-') + ':00')

            cliente.provinciaEntrega =  Provincia.findById(params.provinciaEntrega.toString().toLong()).nombre
            cliente.ciudadEntrega = Ciudad.findById(params.ciudadEntrega.toString().toLong()).nombre
            cliente.parroquiaEntrega = Parroquia.findById(params.parroquiaEntrega.toString().toLong()).nombre
            cliente.barrioEntrega = Barrio.findById(params.barrioEntrega.toString().toLong()).nombre
            cliente.barrioNoDefinido = params.barrioNoDefinido
            cliente.callePrincipalEntrega = formatearTexto(params.callePrincipalEntrega.toString())
            cliente.numeracionEntrega = formatearTexto(params.numeracionEntrega.toString())
            cliente.calletransversalEntrega = formatearTexto(params.calletransversalEntrega.toString())
            cliente.referenciaEntrega = removeSpecialCharacters(params.referenciaEntrega.toString())
            cliente.telefonoPrincipal = params.telefonoPrincipal
            cliente.telefonoSecundario = params.telefonoSecundario
            cliente.imputable = params.imputable
            cliente.observacionesImputable = params.observacionesImputable

            cliente.isEnable = false


          /*  if(params.provinciaTrabajo != ""){
                cliente.provinciaTrabajo = params.provinciaTrabajo.toString()
            }
            if(params.ciudadTrabajo != ""){
                cliente.ciudadTrabajo = params.ciudadTrabajo.toString()
            }
            if(params.sectorDomicilio != ""){
                cliente.parroquiaDomicilio = params.sectorDomicilio.toString()
            }*/
        }
        if(objSubSubestadoGestion.name.equalsIgnoreCase("VOLVER A LLAMAR")){
            cliente.fechaRellamada = new Date().parse('yyyy-MM-dd HH:mm:ss', params.recall.toString().replace('/','-') + ':00')
        }else{
            cliente.fechaRellamada = null
        }
        //VALIDACIONES PARA LA REGESTION
        if(objSubSubestadoGestion.name.equalsIgnoreCase("CLIENTE MOLESTO - MALA EXPERIENCIA CON EL BANCO")){
            cliente.isEnable = false
        }
        if(objSubSubestadoGestion.name.equalsIgnoreCase("NO LE INTERESA")){
            cliente.isEnable = false
        }
        if(objSubSubestadoGestion.name.equalsIgnoreCase("NO APLICA - CLIENTE SIN FUENTE DE INGRESOS AL MOMENTO")){
            cliente.isEnable = false
        }
        if(objSubSubestadoGestion.name.equalsIgnoreCase("SE ACERCARA AL BANCO")){
            cliente.isEnable = false
        }
        if(objSubSubestadoGestion.name.equalsIgnoreCase("TIENE VARIAS TARJETAS")){
            cliente.isEnable = false
        }
        if(objSubSubestadoGestion.name.equalsIgnoreCase("YA ACCEDIO AL PRODUCTO")){
            cliente.isEnable = false
        }
        if(objSubSubestadoGestion.name.equalsIgnoreCase("MONTO O CUPO MUY BAJO - NO LE INTERESA")){
            cliente.isEnable = false
        }
        if(objSubSubestadoGestion.name.equalsIgnoreCase("TIENE OTRAS MEJORES PROPUESTAS DE CREDITO")){
            cliente.isEnable = false
        }
        if(objSubSubestadoGestion.name.equalsIgnoreCase("YA TUVO EL PRODUCTO")){
            cliente.isEnable = false
        }
        if(objSubSubestadoGestion.name.equalsIgnoreCase("CLIENTE VIVE EN EL EXTERIOR")){
            cliente.isEnable = false
        }
        if(objSubSubestadoGestion.name.equalsIgnoreCase("TITULAR FALLECIDO")){
            cliente.isEnable = false
        }
        if(objSubSubestadoGestion.name.equalsIgnoreCase("NÚMERO EQUIVOCADO")){
            cliente.isEnable = false
        }
        if(objSubSubestadoGestion.name.equalsIgnoreCase("NÚMERO NO EXISTE")){
            cliente.isEnable = false
        }

        cliente.estadoGestion = estadoGestion
        cliente.subestadoGestion = objSubestadoGestion
        if(objSubestadoGestion.nombre == "CONTACTO EFECTIVO"){
            cliente.telefonoContactado = params.telefonoContactado
        }
        if (params.subSubStatus != ""){
            String nombreSubSubEstado = SubSubestado.findById(params.subSubStatus.toString().toLong()).name
            cliente.subSubEstado = nombreSubSubEstado
        }
        else
            cliente.subSubEstado = ""

        cliente.intentos = intentos + 1
        cliente.fechaGestion = fechaActual
        cliente.usuario = usuario
        cliente.nombreVendedor = usuario.nombre.toUpperCase()
        cliente.observaciones = formatearTexto(params.observaciones.toString())
        cliente.save(flush: true)

        //Se guarda informacion en el historial
        HistorialNovedades historial = new HistorialNovedades()
        historial.cliente = ClientesNovedades.findById(cliente.id.toLong())
        historial.estadoGestion = cliente.estadoGestion
        historial.subestadoGestion = cliente.subestadoGestion
        historial.motivoNoDesea = cliente.subSubEstado
        historial.fechaGestion = fechaActual
        historial.intentos = cliente.intentos
        historial.nombreVendedor = cliente.nombreVendedor
        historial.observacionesGestion = cliente.observaciones.toString().toUpperCase()
        historial.usuario = cliente.usuario
        //historial.duracionLlamada = tiempoLlamada
        historial.save(flush: true)
        redirect(uri: "/gestionNovedades/index")
    }

    private String formatearTexto(String entrada){
        return entrada.toUpperCase().replace('Ñ', 'N').replace('-', ' ').replace('Á', 'A').replace('É', 'E').replace('Í', 'I').replace('Ó', 'O').replace('Ú', 'U')
    }

    private removeSpecialCharacters(value){
        if(value != null){
            def newValue = value.replace("-"," ").replace("!","").replace("@","").replace("#","").replace("\$","")
                    .replace("&","").replace("/","").replace("(","").replace(")","").replace("=","")
                    .replace("?","").replace("¿","").replace("ç","").replace("{","").replace("}","")
                    .replace("\\","").replace("á","a").replace("é","e").replace("í","i").replace("ó","o")
                    .replace("ú","u").replace("\"","").replace("Á","A").replace("É","E").replace("Í","I")
                    .replace("Ó","O").replace("Ú","U").replace("\'","").replace("  "," ").replace("  "," ")
                    .replace("  "," ").replace("%","").replace(".","").replace(",","").replace("º","")
                    .replace("ª","").replace("|","").replace("\$","").replace("¬","").replace("%","")
                    .replace("*","").replace("+","").replace("_","").replace("Ñ", "N").replace("ñ", "n")
            return newValue
        }
    }

}
