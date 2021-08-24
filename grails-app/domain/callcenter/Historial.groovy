package callcenter

import com.pw.security.*

class Historial {

	String estadoGestion
	Subestado subestadoGestion
	String subSubEstado
	Date fechaGestion
	int intentos
	String nombreVendedor
	String observacionesGestion
	Usuario usuario
	Clientes cliente
	int duracionLlamada
	String plataforma

    static constraints = {
		estadoGestion nullable: true
		subestadoGestion nullable: true
		subSubEstado nullable: true
		fechaGestion nullable: true
		intentos nullable: true
		nombreVendedor nullable: true
		observacionesGestion nullable: true
		usuario nullable: true
		cliente nullable: true
		plataforma nullable: true
    }
	
	static mapping = {
		version false
		observacionesGestion type: "text"
	}
}
