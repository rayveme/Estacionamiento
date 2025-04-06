package poo.ulsa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class BaseDatos {
    public static void main(String[] args) {
        // Archivo donde se guardará la base de datos
        String url = "jdbc:sqlite:mi_base_de_datos.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Base de datos creada o abierta exitosamente.");

                // Crear tabla
                String sql = ""+ "CREATE TABLE IF NOT EXISTS VEHICULOS ("
                		+ "id_vehiculo INTEGER PRIMARY KEY AUTOINCREMENT,"
                		+ "placa TEXT,"
                		+ "marca TEXT,"
                		+ "color TEXT,"
                		+ "tipo TEXT"
                		+ ");"

                		+ "CREATE TABLE IF NOT EXISTS ESPACIO ("
                		+ "id_espacio INTEGER PRIMARY KEY AUTOINCREMENT,"
                		+ "num_espacio INTEGER,"
                		+ "tipo_espacio TEXT,"
                		+ "estado TEXT"
                		+ ");"

                		+ "CREATE TABLE IF NOT EXISTS TICKET ("
                		+ "id_ticket INTEGER PRIMARY KEY AUTOINCREMENT,"
                		+ "id_vehiculo INTEGER NOT NULL,"
                		+ "id_espacio INTEGER NOT NULL,"
                		+ "hora_entrada DATETIME,"
                		+ "hora_salida DATETIME,"
                		+ "monto DECIMAL(10,2),"
                		+ "estado_pago TEXT,"
                		+ "FOREIGN KEY (id_vehiculo) REFERENCES VEHICULOS(id_vehiculo),"
                		+ "FOREIGN KEY (id_espacio) REFERENCES ESPACIO(id_espacio)"
                		+ ");"

                		+ "CREATE TABLE IF NOT EXISTS PAGOS ("
                		+ "id_pago INTEGER PRIMARY KEY AUTOINCREMENT,"
                		+ "id_ticket INTEGER,"
                		+ "monto DECIMAL(10,2),"
                		+ "metodo_pago TEXT,"
                		+ "fecha_pago DATETIME,"
                		+ "FOREIGN KEY (id_ticket) REFERENCES TICKET(id_ticket)"
                		+ ");";

                Statement stmt = conn.createStatement();
                stmt.execute(sql);

                System.out.println("Tabla 'usuarios' creada o ya existente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al crear la base de datos:");
            e.printStackTrace();
        }
    }
}
