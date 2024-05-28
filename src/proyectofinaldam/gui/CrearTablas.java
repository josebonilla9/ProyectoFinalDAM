package proyectofinaldam.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import proyectofinaldam.db.DataBase;

public class CrearTablas {
    
    DataBase db;
    
    public void conectarTablas() {
        db = new DataBase();
        db.conectar("tfgdam");
    }
    
    public JTable crearTabla(GraphicInterface gui, String citaTarea) {
        conectarTablas();
        
        //Creación de la tabla
        JTable tablaNueva = gui.getJTable();
        DefaultTableModel tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        //Se añaden las columnas a la tabla
        tabla.addColumn("Estado");
        tabla.addColumn("Hora");
        tabla.addColumn("Evento");
        tabla.addColumn("Notas");
        tabla.addColumn("");
        tabla.addColumn("ID");

        tablaNueva.setModel(tabla);
        
        //Se edita el ancho de cada columna según su contenido
        tablaNueva.getColumnModel().getColumn(2).setPreferredWidth(200);
        tablaNueva.getColumnModel().getColumn(3).setPreferredWidth(600);
        tablaNueva.getColumnModel().getColumn(4).setPreferredWidth(50);
        tablaNueva.getColumnModel().getColumn(5).setMinWidth(0);
        tablaNueva.getColumnModel().getColumn(5).setMaxWidth(0);
        tablaNueva.getColumnModel().getColumn(5).setWidth(0);
        
        //Se centra el contenido de cada celda
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tablaNueva.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tablaNueva.setDefaultRenderer(Object.class, cellRenderer);
        
        tablaNueva.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                //Obtienen la columna y fila en la que se hizo click
                int fila = tablaNueva.rowAtPoint(e.getPoint());
                int columna = tablaNueva.columnAtPoint(e.getPoint());

                if (columna == 0) {
                    DefaultTableModel model = (DefaultTableModel) tablaNueva.getModel();
                    String currentState = (String) model.getValueAt(fila, columna);
                    int idTabla = (int) model.getValueAt(fila, 5);
                    
                    db.cambiarEstado(idTabla, citaTarea);
                    
                    //Según el símbolo que tenga si se pulsa se cambia por el otro, lo que hace que en la base de datos también cambie
                    if (currentState.equals("\u2713")) {
                        model.setValueAt("\u2717", fila, columna);
                    } else {
                        model.setValueAt("\u2713", fila, columna);
                    }
                } else if (columna == 4) {
                    DefaultTableModel model = (DefaultTableModel) tablaNueva.getModel();
                    int idTabla = (int) model.getValueAt(fila, 5);
                    
                    int confirmar = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar esta cita?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                        if (confirmar == JOptionPane.YES_OPTION) {
                            if (citaTarea.equals("citas")){
                                db.eliminarCitas(gui, idTabla);
                            } else if (citaTarea.equals("tareas")){
                                db.eliminarTareas(gui, idTabla);
                            }                            
                        }
                }
            }
        });
                
        return tablaNueva;
    }
}
