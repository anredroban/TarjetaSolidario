package com.pw.security

class Rol {
	
	String nombre;
	
	Date dateCreated;
	Date lastUpdated;
	
	static hasMany = [permisos: Permiso];

    static constraints = {
		nombre unique: true
    }
	
	static mapping = {
		version false
	  }
}