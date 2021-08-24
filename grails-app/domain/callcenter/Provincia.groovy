package callcenter

class Provincia {

    String nombre
    String prefijo

    static constraints = {
        prefijo nullable: true
    }

    static mapping = {
        version false
    }

}
