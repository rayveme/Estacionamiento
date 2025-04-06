package poo.ulsa;

	import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
	import java.sql.SQLException;
	
	public class Registro_Vehiculos{

	    public void registrarVehiculo(String placa, String marca, String color, String tipo) {
	        String sql = "INSERT INTO VEHICULOS (placa, marca, color, tipo) VALUES (?, ?, ?, ?)";

	        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:parqueo.db");
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setString(1, placa);
	            pstmt.setString(2, marca);
	            pstmt.setString(3, color);
	            pstmt.setString(4, tipo);

	            pstmt.executeUpdate();
	            System.out.println("Vehículo registrado exitosamente.");

	        } catch (SQLException e) {
	            System.out.println("Error al registrar el vehículo:");
	            e.printStackTrace();
	        }
	    }
	}



