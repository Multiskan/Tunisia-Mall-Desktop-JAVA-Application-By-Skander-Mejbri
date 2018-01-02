/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.infob3.pidev.GUI;


import com.esprit.infob3.pidev.connexion.Myconnection;
import com.esprit.infob3.pidev.dao.impl.CatalogueDao;
import com.esprit.infob3.pidev.entites.Produit;
import com.esprit.infob3.pidev.entites.catalogue;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author sinda
 */
public class Tableprodparmag extends javax.swing.JFrame {
    private final Connection con = Myconnection.getInstance() ;

    /**
     * Creates new form Tableprodparmag
     */
    public Tableprodparmag() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new Afficherlesproduits());
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 380, 490));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nomProd", "prix", "marque", "idproduit"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 240, 340, 470));

        jButton1.setText("ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 110, 50));

        jButton2.setText("supprimer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 520, 110, 50));

        jButton3.setText("print");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 600, 110, 40));

        jButton4.setText("retour");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 660, 110, 40));

        jButton5.setText("pdf");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 670, 90, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/infob3/pidev/GUI/shpping.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 470));

        setBounds(0, 0, 1405, 781);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TableModel model1 = jTable1.getModel();
        int index = jTable1.getSelectedRow();
        String idProduit=model1.getValueAt( index,3).toString() ;
         int qs =Integer.parseInt(idProduit);
        CatalogueDao rdqo = new CatalogueDao();
        Produit p = new Produit();
        String nomcat = Catatlogueshow.jTextField1.getText();
        catalogue c = new catalogue();
        try {
            p= rdqo.returnproductbyid(qs);
            c= rdqo.returncatbyname(nomcat);
            int idcat = c.getIdcatalogue();
            catalogue catrr=new catalogue();
            int catr = idcat+1;
            catrr.setIdcatalogue(catr);
            catrr.setNom(nomcat);
            String type = c.getType();
            catrr.setType(type);
            catrr.setIdproduit(idcat);
            System.out.println(type);
            rdqo.ajouterCatalogue(catrr);
            rdqo.modifierCatalogueparid(catr, qs);  
        } catch (SQLException ex)
        {
            Logger.getLogger(Tableprodparmag.class.getName()).log(Level.SEVERE, null, ex);
        }
            int[] indexs= jTable1.getSelectedRows();    
             System.out.println(idProduit);
            Object[] row = new Object[5];
            DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
            for(int i = 0; i < indexs.length; i++)   
         {  
           row[0] = model1.getValueAt(indexs[i], 0);
           row[1] = model1.getValueAt(indexs[i], 1);
           row[2] = model1.getValueAt(indexs[i], 2);
           row[3] = model1.getValueAt(indexs[i], 3);
           row[4] = model1.getValueAt(indexs[i], 4);
          model2.addRow(row);    
        }
       JOptionPane.showMessageDialog(null, "Produit ajouter");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          
         TableModel model1 = jTable1.getModel();
        int index = jTable1.getSelectedRow();
        String idProduit=model1.getValueAt( index,3).toString() ;
        int qs =Integer.parseInt(idProduit);
        CatalogueDao rdqo = new CatalogueDao();
        Produit p = new Produit();
      
    try {
            rdqo.supprimerProduitCatalogue(qs);
         
        } catch (SQLException ex)
       {
            Logger.getLogger(Tableprodparmag.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
                 int i = jTable2.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    model2.removeRow(i);
                }
                else
                {
                    System.out.println("Delete Error");
                }
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 
        MessageFormat header = new MessageFormat("Catalogue ");
        MessageFormat footer = new MessageFormat("Page {0,number,integer} ");
        try {
            jTable2.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            //table.print(JTable.PrintMode.FIT_WIDTH, header, null);
        
        } catch (java.awt.print.PrinterException e) {
            System.err.format("Cannot print %s%n", e.getMessage());

      }  
          
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
          Catatlogueshow mr = new Catatlogueshow();
       mr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       /*TableModel model1 = jTable1.getModel();
        int indexs = jTable1.getSelectedRow();
        String idProduit=model1.getValueAt( indexs,3).toString() ;
         int qs =Integer.parseInt(idProduit);
        ResponsableDAO rdqo = new ResponsableDAO();
        Produit p = new Produit();
        String Table_click=(jTable1.getModel().getValueAt(indexs),0).toString());
        try {
    if (rdqo.next()){
    byte[] imagedata=rs.getBytes("image");
   
    format=new ImageIcon(imagedata);
    labelimage.setIcon(format);
    }
        } catch (SQLException ex) {
            System.out.println(ex);
        }*/
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
      
        try{ 
             
             int rowno=0;int i;
                String sql="select * from catalogue ";
         catalogue g = null ;
      Statement ste = Myconnection.getInstance().prepareStatement(sql);
       ste=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs=ste.executeQuery(sql);
       java.sql.ResultSetMetaData rsmd=rs.getMetaData();
         int colno=rsmd.getColumnCount();
                  
           while    (rs.next())         
               
     { rowno=rowno+1;}
           rs.first();
            Document document=new Document();
            PdfWriter.getInstance(document,new FileOutputStream("catalogue.pdf") );
            PdfPTable pt=new PdfPTable(colno);
            
            document.open();
            for(i=0;i<rowno;i++){
            pt.addCell(""+rs.getInt(1));
            pt.addCell(""+rs.getString(2)); 
            pt.addCell(""+rs.getString(3));
            pt.addCell(""+rs.getInt(4));
            rs.next();
            }
            document.add(pt);
            document.close();
            JOptionPane.showMessageDialog(null, "pdf enregistré");
        } 
        catch(Exception e)
        { 
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Tableprodparmag.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tableprodparmag.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tableprodparmag.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tableprodparmag.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tableprodparmag().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
 


}