package modelo.entities;

public class Usuario {

	private Integer id;
	private String nombre;
	private String clave;
	private boolean isadmin;
	
	public Usuario() {}
	
	

	public Usuario(Integer id, String nombre, String clave, boolean isadmin) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
		this.isadmin = isadmin;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isIsadmin() {
		return isadmin;
	}

	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}
	
	
	
}
