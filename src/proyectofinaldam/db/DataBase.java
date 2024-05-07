package proyectofinaldam.db;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import proyectofinaldam.gui.GraphicInterface;


public class DataBase {
    private Connection conexion;
    
    private static final String USER = "root";
    private static final String PWD = "";
    private static final String URL = "jdbc:mysql://localhost:3308/";
    
    private java.sql.Date fechaSQL;
    
    public void conectar(String nombreDB) {
        try {
            conexion = DriverManager.getConnection(URL + nombreDB, USER, PWD);
            System.out.println("Se ha conectado correctamente");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public void obtenerFecha(GraphicInterface gui) {
        Date fechaElegida = gui.getDate();
        fechaSQL = new java.sql.Date(fechaElegida.getTime());
    }
    
    public void InsertarCitas(int estado, Date fecha, LocalTime hora, String evento, String notas) {
        fecha = fechaSQL;
        
        try {
            String queryMax = "SELECT MAX(id) AS id_nuevo FROM citas";
            PreparedStatement statement = conexion.prepareStatement(queryMax);
            ResultSet resultado = statement.executeQuery();

            int idMayor = 1;
            if (resultado.next()) {
                idMayor = resultado.getInt("id_nuevo");
            }
            
            int idNuevo = idMayor + 1;
            
            String query = "INSERT INTO citas (Estado, Fecha, Hora, Evento, Notas, id) VALUES (?, ?, ?, ?, ?, ?)";
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
    
    public void InsertarTareas(int estado, Date fecha, LocalTime hora, String evento, String notas) {
        fecha = fechaSQL;
        
        try {
            String queryMax = "SELECT MAX(id) AS id_nuevo FROM tareas";
            PreparedStatement statement = conexion.prepareStatement(queryMax);
            ResultSet resultado = statement.executeQuery();

            int idMayor = 1;
            if (resultado.next()) {
                idMayor = resultado.getInt("id_nuevo");
            }
            
            int idNuevo = idMayor + 1;
            
            String query = "INSERT INTO tareas (Estado, Fecha, Hora, Evento, Notas, id) VALUES (?, ?, ?, ?, ?, ?)";
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
    
    public JTable VerCitas(GraphicInterface gui) {
        
        JTable jTableCitas = gui.getJTableCitas();
         DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Date fechaElegida = gui.getDate();
        fechaSQL = new java.sql.Date(fechaElegida.getTime());

        model.addColumn("Estado");
        model.addColumn("Hora");
        model.addColumn("Evento");
        model.addColumn("Notas");
        model.addColumn("ID");

        jTableCitas.setModel(model);
        
        jTableCitas.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableCitas.getColumnModel().getColumn(3).setPreferredWidth(600);
        jTableCitas.getColumnModel().getColumn(4).setMinWidth(0);
        jTableCitas.getColumnModel().getColumn(4).setMaxWidth(0);
        jTableCitas.getColumnModel().getColumn(4).setWidth(0);

        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTableCitas.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTableCitas.setDefaultRenderer(Object.class, cellRenderer);
        
        Object[] dato = new Object[5];
        
        jTableCitas.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {

                int row = jTableCitas.rowAtPoint(e.getPoint());
                int column = jTableCitas.columnAtPoint(e.getPoint());

                if (column == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTableCitas.getModel();
                    String currentState = (String) model.getValueAt(row, column);
                    int idTabla = (int) model.getValueAt(row, column + 4);

                    if (currentState.equals("\u2713")) {
                        model.setValueAt("\u2717", row, column);
                        actualizarEstadoCitas(idTabla, 0);

                    } else {
                        model.setValueAt("\u2713", row, column);
                        actualizarEstadoCitas(idTabla, 1);
                    }
                }
            }
        });
        
        try {
            String query = "SELECT Estado, Hora, Evento, Notas, id FROM citas WHERE Fecha = '" + fechaSQL + "' ";
            PreparedStatement instruccion = conexion.prepareStatement(query);
            ResultSet resultado = instruccion.executeQuery();
            
            while (resultado.next()) {
                int estado = resultado.getInt("Estado");
                if (estado != 0) {
                    dato[0] = "\u2713";
                } else {
                    dato[0] = "\u2717";
                }
                
                Time horaSQL = resultado.getTime("Hora");
                LocalTime hora = horaSQL.toLocalTime();
                int horas = hora.getHour();
                int minutos = hora.getMinute();
                String horaFormateada = String.format("%02d:%02d", horas, minutos);
                dato[1] = horaFormateada;
                
                dato[2] = resultado.getString("Evento");
                dato[3] = resultado.getString("Notas");
                dato[4] = resultado.getInt("id");
                
                model.addRow(dato);
            }
            
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return jTableCitas;
    }
    
    public JTable VerTareas(GraphicInterface gui) {
        
        JTable jTableCitas = gui.getJTableCitas();
         DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Date fechaElegida = gui.getDate();
        fechaSQL = new java.sql.Date(fechaElegida.getTime());

        model.addColumn("Estado");
        model.addColumn("Hora");
        model.addColumn("Evento");
        model.addColumn("Notas");
        model.addColumn("ID");

        jTableCitas.setModel(model);
        
        jTableCitas.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableCitas.getColumnModel().getColumn(3).setPreferredWidth(600);
        jTableCitas.getColumnModel().getColumn(4).setMinWidth(0);
        jTableCitas.getColumnModel().getColumn(4).setMaxWidth(0);
        jTableCitas.getColumnModel().getColumn(4).setWidth(0);

        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTableCitas.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTableCitas.setDefaultRenderer(Object.class, cellRenderer);
        
        Object[] dato = new Object[5];
        
        jTableCitas.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {

                int row = jTableCitas.rowAtPoint(e.getPoint());
                int column = jTableCitas.columnAtPoint(e.getPoint());

                if (column == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTableCitas.getModel();
                    String currentState = (String) model.getValueAt(row, column);
                    int idTabla = (int) model.getValueAt(row, column + 4);

                    if (currentState.equals("\u2713")) {
                        model.setValueAt("\u2717", row, column);
                        actualizarEstadoTareas(idTabla, 0);

                    } else {
                        model.setValueAt("\u2713", row, column);
                        actualizarEstadoTareas(idTabla, 1);
                    }
                }
            }
        });
        
        try {
            String query = "SELECT Estado, Hora, Evento, Notas, id FROM tareas WHERE Fecha = '" + fechaSQL + "' ";
            PreparedStatement instruccion = conexion.prepareStatement(query);
            ResultSet resultado = instruccion.executeQuery();
            
            while (resultado.next()) {
                int estado = resultado.getInt("Estado");
                if (estado != 0) {
                    dato[0] = "\u2713";
                } else {
                    dato[0] = "\u2717";
                }
                
                Time horaSQL = resultado.getTime("Hora");
                LocalTime hora = horaSQL.toLocalTime();
                int horas = hora.getHour();
                int minutos = hora.getMinute();
                String horaFormateada = String.format("%02d:%02d", horas, minutos);
                dato[1] = horaFormateada;
                
                dato[2] = resultado.getString("Evento");
                dato[3] = resultado.getString("Notas");
                dato[4] = resultado.getInt("id");
                
                model.addRow(dato);
            }
            
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return jTableCitas;
    }
    
    public void actualizarEstadoCitas(int idTabla, int estadoNuevo) {
        
        try {
            String query = "UPDATE citas SET Estado = "+ estadoNuevo + " WHERE id = " + idTabla + "";
            PreparedStatement actualizar = conexion.prepareStatement(query);
            actualizar.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void actualizarEstadoTareas(int idTabla, int estadoNuevo) {
        
        try {
            String query = "UPDATE tareas SET Estado = "+ estadoNuevo + " WHERE id = " + idTabla + "";
            PreparedStatement actualizar = conexion.prepareStatement(query);
            actualizar.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}
    
    
