package modelo;

public class Coches {
	private String modelo;
	private String detalles;
	private Integer precio;
	private Integer ayo;
	private String img;
	public Coches(String modelo, String detalles, Integer precio, Integer ayo, String img) {
		super();
		this.modelo = modelo;
		this.detalles = detalles;
		this.precio = precio;
		this.ayo = ayo;
		this.img = img;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public Integer getAyo() {
		return ayo;
	}
	public void setAyo(Integer ayo) {
		this.ayo = ayo;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}
