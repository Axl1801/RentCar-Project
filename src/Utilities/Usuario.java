package Utilities;

public class Usuario {
	
	private static Usuario instance;
    private int idAgente;
    private String usuario;
    private String correo;
    private String nivelAcceso;

    private Usuario(int id_agente, String usuario, String correo, String nivel_acceso) {
    	this.idAgente = id_agente;
        this.usuario = usuario;
        this.correo = correo;
        this.nivelAcceso = nivel_acceso;
    }
    
    public static void crearUsuarioMostrar(int id_agente, String usuario, String correo, String nivel_acceso) {
        instance = new Usuario(id_agente, usuario, correo, nivel_acceso);
    }
    
    public static Usuario getInstance() {
        return instance;
    }
	
    public int getIdAgente() { 
    	return idAgente; 
    }
    
    public String getUsuario() {
    	return usuario; 
    }
    
    public String getCorreo() { 
    	return correo; 
    }
    
    public String getNivelAcceso() {
    	return nivelAcceso;
    }

    
}
