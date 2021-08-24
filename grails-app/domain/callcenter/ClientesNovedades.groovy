package callcenter

import com.pw.security.Usuario

class ClientesNovedades {

    String cedula
    String nombres

    String direccionCorreccion

    String provinciaEntrega
    String ciudadEntrega
    String parroquiaEntrega
    String barrioEntrega
    String callePrincipalEntrega
    String numeracionEntrega
    String calletransversalEntrega
    String referenciaEntrega
    Date fechaEntrega //10 días laborables luego de la venta
    String lugarEntrega
    String imputable
    String observacionesImputable

    String telefonoPrincipal
    String telefonoSecundario
    String telefono3
    String telefono4
    String telefono5
    String telefonoCelular
    String celular2
    String celular3
    String celular4
    String celular5

    String telefonoContactado

    //Campos que SIEMPRE van en la gestión
    Date fechaGestion
    int intentos
    String estadoGestion
    Subestado subestadoGestion
    String subSubEstado
    Usuario usuario
    String nombreBase
    String nombreVendedor
    Date fechaRellamada
    String observaciones
    String codigoAsignacion
    String barrioNoDefinido

    boolean isEnable //Será falso cuando se deshabilite una cliente
    boolean isBaseActiva //Será falso cuando se deshabilite una cliente

    static constraints = {

        cedula nullable: true
        nombres nullable: true

        direccionCorreccion nullable: true

        provinciaEntrega nullable: true
        ciudadEntrega nullable: true
        parroquiaEntrega nullable: true
        barrioEntrega nullable: true
        callePrincipalEntrega nullable: true
        numeracionEntrega nullable: true
        calletransversalEntrega nullable: true
        referenciaEntrega nullable: true
        fechaEntrega nullable: true //10 días laborables luego de la venta
        lugarEntrega nullable: true
        imputable nullable: true
        observacionesImputable nullable: true

        telefonoPrincipal nullable: true
        telefonoSecundario nullable: true
        telefono3 nullable: true
        telefono4 nullable: true
        telefono5 nullable: true
        telefonoCelular nullable: true
        celular2 nullable: true
        celular3 nullable: true
        celular4 nullable: true
        celular5 nullable: true

        telefonoContactado nullable: true

        //Campos que SIEMPRE van en la gestión
        fechaGestion nullable: true
        intentos nullable: true
        estadoGestion nullable: true
        subestadoGestion nullable: true
        subSubEstado nullable: true
        usuario nullable: true
        nombreBase nullable: true
        nombreVendedor nullable: true
        fechaRellamada nullable: true
        observaciones nullable: true
        codigoAsignacion nullable: true
        barrioNoDefinido nullable: true
    }
    static mapping = {
        version false
        observaciones type: 'text'
    }
    static String[] getFields(){
        String[] fields = [
                "cedula",
                "nombres",
                "direccionCorreccion",
                "telefonoCelular",
                "telefono3",
                "telefono4",
                "telefono5",
                "celular2",
                "celular3",
                "celular4",
                "celular5",
                "codigoAsignacion"
        ]
        return fields
    }
}
