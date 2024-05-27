package proyectofinaldam.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import proyectofinaldam.gui.CrearTablas;
import proyectofinaldam.gui.GraphicInterface;


public class DataBase {
    
    private java.sql.Date fechaSQL;
    private Connection conexion;
    
    private static final String USER = "root";
    private static final String PWD = "";
    private static final String URL = "jdbc:mysql://localhost:3308/";
        
    //Método para la conexión a la base de datos
    public void conectar(String nombreDB) {
        try {
            conexion = DriverManager.getConnection(URL + nombreDB, USER, PWD);
            System.out.println("Se ha conectado correctamente");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    //Método para obtener la fecha
    public void obtenerFecha(GraphicInterface gui) {
        Date fechaElegida = gui.getDate();
        fechaSQL = new java.sql.Date(fechaElegida.getTime());
    }
    
    //Método para insertar citas y tareas nuevas en la base de datos
    public void InsertarEventos(int estado, Date fecha, LocalTime hora, String evento, String notas, String citaTarea) {
        fecha = fechaSQL;
        
        try {
            //Se busca el id más alto para que al añadir una tarea se sume 1 
            String queryMax = "SELECT MAX(id) AS id_nuevo FROM " + citaTarea;
            PreparedStatement statement = conexion.prepareStatement(queryMax);
            ResultSet resultado = statement.executeQuery();

            int idMayor = 1;
            if (resultado.next()) {
                idMayor = resultado.getInt("id_nuevo");
            }
            
            int idNuevo = idMayor + 1;
            
            //Insertamos todos los datos en la base de datos en la tabla citas o tareas según hayamos entrado en la interfaz
            String query = "INSERT INTO " + citaTarea + " (Estado, Fecha, Hora, Evento, Notas, id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement queryInsert = conexion.prepareStatement(query);
            queryInsert.setInt(1, estado);
            queryInsert.setDate(2, new java.sql.Date(fecha.getTime()));
            queryInsert.setTime(3, java.sql.Time.valueOf(hora));
            queryInsert.setString(4, evento);
            queryInsert.setString(5, notas);
            queryInsert.setInt(6, idNuevo);
            
            
            queryInsert.executeUpdate();
            System.out.println("Se han introducido correctamente los datos");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public ResultSet BuscarEventos(String citaTarea) {
        ResultSet resultado = null;
        
        try {
            String query = "SELECT Estado, Hora, Evento, Notas, id FROM " + citaTarea + " WHERE Fecha = '" + fechaSQL + "' ";
            PreparedStatement instruccion = conexion.prepareStatement(query);
            resultado = instruccion.executeQuery();
            
            return resultado;
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return resultado;
    }
    
    //Método para ver las citas o tareas en una tabla
    public JTable VerEventos(GraphicInterface gui, String citaTarea) {
        JTable tablaCitas = new CrearTablas().crearTabla(gui, citaTarea);
        DefaultTableModel tabla = (DefaultTableModel) tablaCitas.getModel();
        
        Date fechaElegida = gui.getDate();
        fechaSQL = new java.sql.Date(fechaElegida.getTime());
        
        Object[] dato = new Object[6];
        
        //Se busca en la base de datos la diferente información que mostrar en la tabla con SELECT
        try {
            BuscarEventos(citaTarea);
            ResultSet resultado = BuscarEventos(citaTarea);
            
            //En la base de datos el estado está añadido con 1 si está finalizado el evento y 0 si no lo está
            //por lo que aquí si tiene un 1 ponemos un tick y si la base de datos tiene un 0 ponemos una cruz
            while (resultado.next()) {
                int estado = resultado.getInt("Estado");
                if (estado != 0) {
                    dato[0] = "\u2713";
                } else {
                    dato[0] = "\u2717";
                }
                
                //Pasamos el formato de la hora de la base de datos a la que nosotros necesitamos
                Time horaSQL = resultado.getTime("Hora");
                LocalTime hora = horaSQL.toLocalTime();
                int horas = hora.getHour();
                int minutos = hora.getMinute();
                String horaFormateada = String.format("%02d:%02d", horas, minutos);
                
                dato[1] = horaFormateada;
                dato[2] = resultado.getString("Evento");
                dato[3] = resultado.getString("Notas");
                dato[4] = "\uD83D\uDDD1";
                dato[5] = resultado.getInt("id");
                
                tabla.addRow(dato);
            }
            
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return tablaCitas;
    }
    
    public void cambiarEstado(int idTabla, String citaTarea) {
        ResultSet resultado;
        try {
            // Busca la cita o tarea específica con el ID dado
            String query = "SELECT Estado FROM " + citaTarea + " WHERE id = ?";
            PreparedStatement instruccion = conexion.prepareStatement(query);
            instruccion.setInt(1, idTabla);
            resultado = instruccion.executeQuery();

            if (resultado.next()) {
            int estado = resultado.getInt("Estado");
            int estadoNuevo = (estado == 1) ? 0 : 1;

            // Actualiza el estado
            String queryUpdate = "UPDATE " + citaTarea + " SET Estado = ? WHERE id = ?";
            PreparedStatement actualizar = conexion.prepareStatement(queryUpdate);
            actualizar.setInt(1, estadoNuevo);
            actualizar.setInt(2, idTabla);
            actualizar.executeUpdate();
        }
        } catch (SQLException e) {
            System.err.println(e);
        } 
    }
    
    public void eliminarCitas(GraphicInterface gui, int idTabla) {
        try {
            String query = "DELETE FROM citas WHERE id = ?";
            PreparedStatement eliminar = conexion.prepareStatement(query);
            eliminar.setInt(1, idTabla);
            int filasEliminadas = eliminar.executeUpdate();
            System.out.println("Filas eliminadas: " + filasEliminadas);
            
            VerEventos(gui, "citas");

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void eliminarTareas (GraphicInterface gui, int idTabla) {
        try {
            String query = "DELETE FROM tareas WHERE id = ?";
            PreparedStatement eliminar = conexion.prepareStatement(query);
            eliminar.setInt(1, idTabla);
            int filasEliminadas = eliminar.executeUpdate();
            System.out.println("Filas eliminadas: " + filasEliminadas);
            
            VerEventos(gui, "tareas");

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}