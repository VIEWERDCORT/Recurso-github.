/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author VIEWERDCORT
 */
public class Cubo extends javax.swing.JFrame {
    Graphics lapiz;
    private int horizontal, vertical;
    private int derecha, izquierda;
     private int tamaño=50;
     private int altop, largop;
    
     private void refrescar(){
         lapiz.setColor(Color.decode("#ffffff"));
         lapiz.fillRect(0, 0, largop, altop);
         lapiz.setColor(Color.decode("#171717"));
         
     }
    
     private void crearCubo(){
         lapiz.drawRect(horizontal + derecha, (tamaño/2) + vertical, tamaño, tamaño);
         lapiz.drawRect((tamaño / 2) + horizontal + izquierda, vertical, tamaño, tamaño);
         
         lapiz.drawLine(horizontal+derecha,(tamaño/2)+vertical,(tamaño/2)+horizontal+izquierda,vertical);
         lapiz.drawLine(tamaño+horizontal+derecha, (tamaño/2)+vertical, (tamaño+(tamaño/2))+horizontal+izquierda,vertical);
         lapiz.drawLine(tamaño+horizontal+derecha,(tamaño+(tamaño/2))+vertical, tamaño+(tamaño/2)+horizontal+izquierda, tamaño+vertical);
         lapiz.drawLine(horizontal+derecha, (tamaño+(tamaño/2))+vertical, (tamaño/2)+horizontal+izquierda, tamaño+vertical);
         
     }
     
     public void limites(){
         int limite;
         if (tamaño>altop-(tamaño/2)||tamaño>largop-(tamaño/2)){
             tamaño=largop-(tamaño/2);
         }
         limite=largop-(tamaño+(tamaño/2));
         if(horizontal>limite){
             horizontal = limite -1;
         }
         limite=altop-(tamaño+(tamaño/2));
         if (vertical > limite){
             vertical = limite -1;
         }
     }
    /**
     * Creates new form Cubo
     */
     
     int izq=1,der=1;
     
    public Cubo() {
        this.setResizable(false);
        initComponents();
        this.setLocationRelativeTo(null);
        
        lapiz = fondo.getGraphics();
        altop = fondo.getHeight();
        largop = fondo.getWidth();
        horizontal = 0;
        vertical = 0;
        derecha = 0;
        izquierda = 0;
        
        btnCrear.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if (e.getKeyChar() == '+'){
                    refrescar();
                    tamaño += 10;
                    crearCubo();
                    limites();
                }
                else if (e.getKeyChar() =='-'){
                    refrescar();
                    tamaño=tamaño>10? (tamaño-10): 10;
                    crearCubo();
                }
                else if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                    refrescar();
                    horizontal +=10;
                    limites();
                    crearCubo();
                }
                else if (e.getKeyCode()==KeyEvent.VK_LEFT){
                    refrescar();
                    horizontal=horizontal>0?(horizontal-10):0;
                    crearCubo();
                
                }
                else if (e.getKeyCode()==KeyEvent.VK_UP){
                    refrescar();
                    vertical=vertical>0?(vertical-10):0;
                    crearCubo();
                }
                else if (e.getKeyCode()==KeyEvent.VK_DOWN){
                    refrescar();
                    vertical+=10;
                    limites();
                    crearCubo();
                }
                else if (e.getKeyChar()=='q'){
                    refrescar();
                    if (izquierda > - (tamaño/2) && izq == 1){
                        izquierda -=2;
                        derecha+=2;
                        
                    }
                    else if (izq==0){
                        izq =1;
                        
                    }
                else{
                        izquierda +=2;
                        derecha -=2;
                                
                    }
                    limites();
                    crearCubo();
                }
                else if (e.getKeyChar()=='w'){
                    refrescar();
                    if (izquierda < 0 && der == 1){
                        izquierda +=2;
                        derecha-=2;
                        
                    }
                    else if (der==0){
                        der =1;
                        
                    }
                else{
                        izquierda -=2;
                        derecha +=2;
                                
                    }
                    limites();
                    crearCubo();
                }
            }
        }); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fondo = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        fondo.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        btnCrear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCrear.setText("CREAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnCrear)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrear)
                    .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        refrescar();
        crearCubo();
        
// TODO add your handling code here:
        
    }//GEN-LAST:event_btnCrearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cubo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cubo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cubo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cubo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cubo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JPanel fondo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
