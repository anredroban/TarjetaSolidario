package callcenter

class ActividadEconomica {

    String codigo
    String descripcion

    static constraints = {
    }

    static mapping = {
        version false
        descripcion type: 'text'
    }

}
