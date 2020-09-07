/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import estructural.Matricula;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ServicioLocalEstudiante;
import model.ServicioLocalMateria;
import model.ServicioLocalMatricula;

/**
 *
 * @author felip
 */
public class JDialogListarMatriculasTodas extends javax.swing.JFrame {

    /**
     * Creates new form JDialogListarMatriculasTodas
     */
    public JDialogListarMatriculasTodas(){
        initComponents();
        cambiarDatosTabla();
        setTitle("Lista de matriculas");
        setLocationRelativeTo(null);
        setSize(810, 520);
        
    }

    
    private void cambiarDatosTabla(){

        DefaultTableModel modelo = (DefaultTableModel)tablaDatos.getModel();
        modelo.getDataVector().removeAllElements();
        revalidate();

        ArrayList<Matricula> matriculas = (ArrayList<Matricula>) ServicioLocalMatricula.darMatriculas();

        for (int i = 0; i < matriculas.size(); i++) {
            Vector fila = new Vector();
            fila.add(matriculas.get(i).getCodigo());
            fila.add(matriculas.get(i).getPkEstudiante());
            fila.add(matriculas.get(i).getPkMateria());
           
            //fila.add(ServicioLocalEstudiante.getServicio().buscarEstudiante(matriculas.get(i).getPkEstudiante()).getNombres());
            //fila.add(ServicioLocalMateria.getServicio().darMateriaPorCodigo(matriculas.get(i).getPkMateria()).getNombre());
            fila.add(matriculas.get(i).getNotaDefinitiva());
            fila.add(matriculas.get(i).getFechaInscripcion());
            fila.add(matriculas.get(i).getFechaInicio());
            fila.add(matriculas.get(i).getFechaFinal());
            String inf = "";
            if(matriculas.get(i).getEstado() == 0){
                inf = "Matriculada";
            }else if(matriculas.get(i).getEstado() == 1){
                inf = "Cursando";
            }else if(matriculas.get(i).getEstado() == 2){
                inf = "Reprobada";
            }else if(matriculas.get(i).getEstado() == 3){
                inf = "Aprobada";
            }
            fila.add(inf);
            modelo.addRow(fila);
        }
         repaint();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(6, 58, 88));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTA DE MATRICULAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 670, 60));

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Estudiante", "Materia", "Definitiva", "Fecha Inscripción", "Fecha Inicio", "Fecha Final", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tablaDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 760, 350));

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, -1, -1));

        jLabel2.setText("Filtrar por estudiante (documento):");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 130, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        cambiarDatosTabla();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
