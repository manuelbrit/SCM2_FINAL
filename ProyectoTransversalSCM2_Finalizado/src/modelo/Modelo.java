package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.JsonObject;


import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Modelo
 */
@Stateless
@Local
public class Modelo {
	private List<Usuario> usuarios;
	private List<Coches> coches;
    /**
     * Default constructor. 
     */
    public Modelo() {
        // TODO Auto-generated constructor stub
    }

	
	public List<Usuario> getUsuarios() {
		DataBaseConnection db = new DataBaseConnection("mabrito", "Temp2019$$");
		
		usuarios = new ArrayList<>();
		
		try {
			ResultSet rs = db.dameUsuarios();
			while(rs.next()) {
				usuarios.add(new Usuario(
						rs.getString("usuario"), 
						rs.getString("contrasena")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public Boolean setUsuario(String usuario, String password) {
		Boolean response = false;
		DataBaseConnection db = new DataBaseConnection("mabrito", "Temp2019$$");
		List<Usuario> listaUsuarios = getUsuarios();
		
		List<Usuario> usuarioFiltrado = null;
		
		usuarioFiltrado = listaUsuarios.stream()
			.filter(e -> e.getUsuario().equals(usuario) && e.getContraseya().equals(password))
			.collect(Collectors.toList());
		if(usuarioFiltrado.size() == 0) {
			try {
				db.setUsuario(usuario, password);
				response = true;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				response = false;
			}
		} else {
			response = false;
		}
		
		return response;
		
	}


	public ArrayList<Object> getCoches() {
		DataBaseConnection db = new DataBaseConnection("mabrito", "Temp2019$$");
		
		ArrayList<Object> arrayCoches = new ArrayList<>();
		
		try {
			ResultSet rs = db.dameCoches();
			while(rs.next()) {
				Coches tmpCoches = new Coches(
						rs.getString("modelo"), 
						rs.getString("detalles"),
						rs.getInt("precio"),
						rs.getInt("ayo"),
						rs.getString("img")
						);
				JsonObject item = new JsonObject();
				item.addProperty("Modelo", tmpCoches.getModelo());
				item.addProperty("Detalles", tmpCoches.getDetalles());
				item.addProperty("Precio", tmpCoches.getPrecio());
				item.addProperty("Ayo", tmpCoches.getAyo());
				item.addProperty("IMG", tmpCoches.getImg());
				arrayCoches.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrayCoches;
	}


	public void setCoches(List<Coches> coches) {
		this.coches = coches;
	}

	
}








