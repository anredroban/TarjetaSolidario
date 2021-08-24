package callcenter

class Subestado {
	
	String nombre
	boolean enableManagement
	String type
	boolean isActive
	Estado estado
	String alias
	String rangoTiempo

    static constraints = {
		enableManagement nullable: true
		type nullable: true
		type inList: ['No Exitoso','No Contactado','Exitoso','Rellamada','']
		isActive nullable: true
		alias nullable: true
		rangoTiempo nullable: true
    }
	
	static mapping = {
		version false
	}
	
}
