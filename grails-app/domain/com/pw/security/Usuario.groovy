package com.pw.security

class Usuario {
	
	String nombre
	String cedula
	String usuario
	String password
	String estado
	String extent
	
	Date dateCreated
	Date lastUpdated
	
	Rol rol

    static constraints = {
		estado inList: ['ACTIVO', 'INACTIVO']
		usuario unique: true
		cedula unique: true
		extent nullable:true
    }
	
	static mapping = {
		version false
	  }
}
