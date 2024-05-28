package proyectofinaldam.gui;

import java.awt.Color;
import java.time.LocalTime;
import java.util.Date;
import javax.swing.JTable;
import proyectofinaldam.db.DataBase;


public class GraphicInterface extends javax.swing.JFrame {
    
    DataBase db = new DataBase();
    
    
    public GraphicInterface(String nombreDB) {
        initComponents();
        db.conectar(nombreDB);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogErrorFecha = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jFrameTabla = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCitas = new javax.swing.JTable();
        jLabelTus = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jFormattedFechaTabla = new javax.swing.JFormattedTextField();
        jDialogAdd = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonAddFinal = new javax.swing.JButton();
        jFormattedTextFieldHora = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaEvento = new javax.swing.JTextArea();
        jFormattedFecha = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaNotas = new javax.swing.JTextArea();
        jPanelMain = new javax.swing.JPanel();
        jDateSeleccion = new com.toedter.calendar.JDateChooser();
        jLabelFecha = new javax.swing.JLabel();
        jLabelTitulo1 = new javax.swing.JLabel();
        jLabelTitulo2 = new javax.swing.JLabel();
        jButtonTareas = new javax.swing.JButton();
        jButtonCitas = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Por favor elija una fecha");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ERROR:");

        javax.swing.GroupLayout jDialogErrorFechaLayout = new javax.swing.GroupLayout(jDialogErrorFecha.getContentPane());
        jDialogErrorFecha.getContentPane().setLayout(jDialogErrorFechaLayout);
        jDialogErrorFechaLayout.setHorizontalGroup(
            jDialogErrorFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDialogErrorFechaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogErrorFechaLayout.setVerticalGroup(
            jDialogErrorFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogErrorFechaLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jFrameTabla.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jFrameTabla.setBackground(new java.awt.Color(255, 255, 255));

        jTableCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableCitas.setColumnSelectionAllowed(true);
        jTableCitas.getTableHeader().setReorderingAllowed(false);
        jTableCitas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTableCitasPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCitas);
        jTableCitas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabelTus.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTus.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabelTus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTus.setText("Tus citas:");

        jButtonAdd.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButtonAdd.setText("Añadir cita");
        jButtonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddMouseClicked(evt);
            }
        });

        jFormattedFechaTabla.setEditable(false);
        jFormattedFechaTabla.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d MMMM y"))));
        jFormattedFechaTabla.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedFechaTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jFormattedFechaTabla.setEnabled(false);

        javax.swing.GroupLayout jFrameTablaLayout = new javax.swing.GroupLayout(jFrameTabla.getContentPane());
        jFrameTabla.getContentPane().setLayout(jFrameTablaLayout);
        jFrameTablaLayout.setHorizontalGroup(
            jFrameTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(jFrameTablaLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabelTus, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAdd)
                .addGap(130, 130, 130))
            .addGroup(jFrameTablaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jFormattedFechaTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFrameTablaLayout.setVerticalGroup(
            jFrameTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrameTablaLayout.createSequentialGroup()
                .addGroup(jFrameTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrameTablaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAdd))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrameTablaLayout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addComponent(jFormattedFechaTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTus)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jFrameTabla.setBackground(Color.WHITE);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("Hora:");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Evento:");

        jButtonAddFinal.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButtonAddFinal.setText("Añadir");
        jButtonAddFinal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddFinalMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonAddFinalMouseReleased(evt);
            }
        });

        jFormattedTextFieldHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm"))));
        jFormattedTextFieldHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextFieldHora.setText("00:00");

        jTextAreaEvento.setColumns(20);
        jTextAreaEvento.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextAreaEvento.setRows(2);
        jTextAreaEvento.setToolTipText("");
        jScrollPane2.setViewportView(jTextAreaEvento);

        jFormattedFecha.setEditable(false);
        jFormattedFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d MMMM y"))));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setText("Notas:");

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextAreaNotas.setColumns(20);
        jTextAreaNotas.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextAreaNotas.setRows(5);
        jTextAreaNotas.setWrapStyleWord(true);
        jScrollPane3.setViewportView(jTextAreaNotas);

        javax.swing.GroupLayout jDialogAddLayout = new javax.swing.GroupLayout(jDialogAdd.getContentPane());
        jDialogAdd.getContentPane().setLayout(jDialogAddLayout);
        jDialogAddLayout.setHorizontalGroup(
            jDialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jDialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jDialogAddLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(34, 34, 34)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jDialogAddLayout.createSequentialGroup()
                            .addGroup(jDialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(34, 34, 34)
                            .addGroup(jDialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jFormattedTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogAddLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246))
        );
        jDialogAddLayout.setVerticalGroup(
            jDialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jFormattedFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jFormattedTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jDialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonAddFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda Digital");
        setName("framePrincipal"); // NOI18N

        jPanelMain.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelMain.setFocusTraversalKeysEnabled(false);
        jPanelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDateSeleccion.setForeground(new java.awt.Color(255, 255, 255));
        jDateSeleccion.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jPanelMain.add(jDateSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 400, 30));
        Date fechaActual = new Date();
        jDateSeleccion.setDate(fechaActual);

        jLabelFecha.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabelFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFecha.setText("Elija una fecha:");
        jPanelMain.add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 800, 60));

        jLabelTitulo1.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jLabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo1.setText("Agenda Digital:");
        jPanelMain.add(jLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 60));

        jLabelTitulo2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabelTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo2.setText("Organiza Tu Tiempo con Eficiencia ");
        jPanelMain.add(jLabelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 800, 60));

        jButtonTareas.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButtonTareas.setText("Ver Tareas");
        jButtonTareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonTareasMouseClicked(evt);
            }
        });
        jButtonTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTareasActionPerformed(evt);
            }
        });
        jPanelMain.add(jButtonTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 120, 40));

        jButtonCitas.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButtonCitas.setText("Ver Citas");
        jButtonCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCitasMouseClicked(evt);
            }
        });
        jButtonCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCitasActionPerformed(evt);
            }
        });
        jPanelMain.add(jButtonCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTareasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTareasActionPerformed

    public JTable getJTable() {
        return jTableCitas;
    }
    
    public Date getDate() {
        return jDateSeleccion.getDate();
    }
    
    
    private void jButtonCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCitasMouseClicked
        if (jDateSeleccion.getDate() != null) {
                
        JTable tabla = db.VerEventos(this, "citas");
        
        jFormattedFechaTabla.setValue(jDateSeleccion.getDate());
        
        jLabelTus.setText("Tus citas:");
        jButtonAdd.setText("Añadir cita");
        
        jFrameTabla.setVisible(true);
        jFrameTabla.setSize(800, 500);
        
        
        } else {
            jDialogErrorFecha.setVisible(true);
            jDialogErrorFecha.setSize(400, 100);
        }
        
    }//GEN-LAST:event_jButtonCitasMouseClicked

    private void jButtonCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCitasActionPerformed

    }//GEN-LAST:event_jButtonCitasActionPerformed

    private void jButtonTareasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTareasMouseClicked
        if (jDateSeleccion.getDate() != null) {
                
        JTable tabla = db.VerEventos(this, "tareas");
        
        jFormattedFechaTabla.setValue(jDateSeleccion.getDate());
        
        jLabelTus.setText("Tus tareas:");
        jButtonAdd.setText("Añadir tarea");
        
        jFrameTabla.setVisible(true);
        jFrameTabla.setSize(800, 500);
        
        
        } else {
            jDialogErrorFecha.setVisible(true);
            jDialogErrorFecha.setSize(400, 100);
        }
        
    }//GEN-LAST:event_jButtonTareasMouseClicked

    private void jTableCitasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTableCitasPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableCitasPropertyChange

    private void jButtonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddMouseClicked
        jDialogAdd.setVisible(true);
        jDialogAdd.setSize(600, 400);
        
        jFormattedFecha.setValue(jDateSeleccion.getDate());
    }//GEN-LAST:event_jButtonAddMouseClicked

    private void jButtonAddFinalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddFinalMouseClicked
        LocalTime hora = LocalTime.parse(jFormattedTextFieldHora.getText());
        
        if (jLabelTus.getText().equals("Tus citas:")) {
            db.insertarEventos(0, jDateSeleccion.getDate(), hora, jTextAreaEvento.getText(), jTextAreaNotas.getText(), "citas");
            db.VerEventos(this, "citas");
        }
        else {
            db.insertarEventos(0, jDateSeleccion.getDate(), hora, jTextAreaEvento.getText(), jTextAreaNotas.getText(), "tareas");
            db.VerEventos(this, "tareas");
        }
        
        jFormattedTextFieldHora.setText("00:00");
        jTextAreaEvento.setText("");
        jTextAreaNotas.setText("");
    }//GEN-LAST:event_jButtonAddFinalMouseClicked

    private void jButtonAddFinalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddFinalMouseReleased
    }//GEN-LAST:event_jButtonAddFinalMouseReleased

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAddFinal;
    private javax.swing.JButton jButtonCitas;
    private javax.swing.JButton jButtonTareas;
    private com.toedter.calendar.JDateChooser jDateSeleccion;
    private javax.swing.JDialog jDialogAdd;
    private javax.swing.JDialog jDialogErrorFecha;
    private javax.swing.JFormattedTextField jFormattedFecha;
    private javax.swing.JFormattedTextField jFormattedFechaTabla;
    private javax.swing.JFormattedTextField jFormattedTextFieldHora;
    private javax.swing.JFrame jFrameTabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JLabel jLabelTitulo2;
    private javax.swing.JLabel jLabelTus;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableCitas;
    private javax.swing.JTextArea jTextAreaEvento;
    private javax.swing.JTextArea jTextAreaNotas;
    // End of variables declaration//GEN-END:variables
}
