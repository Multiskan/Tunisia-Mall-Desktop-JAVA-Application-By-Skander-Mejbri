/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.infob3.pidev.GUI;

import com.esprit.infob3.pidev.dao.impl.ProduitDao;
import com.esprit.infob3.pidev.entites.Produit;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author HP
 */

 public class  AfficheragsinSelonnom extends AbstractTableModel {
     
    String [] columns  = {"Product Name" , " Product Price" , "Product Mark"};
    List<Produit> vectorhictor ;
    
   
     ProduitDao gamer = new ProduitDao();
    public  AfficheragsinSelonnom() { 
       
        try {
            int index = ListedesMagasin.jTable1.getSelectedRow();
        
        TableModel model = ListedesMagasin.jTable1.getModel();
        String nom = model.getValueAt(index, 0).toString();
          
          vectorhictor=gamer.readAllbyname(nom);
        } catch (SQLException ex) {
            Logger.getLogger(AfficheragsinSelonnom.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }

@Override
    public int getRowCount() {
 return vectorhictor.size();
    }

    @Override
    public int getColumnCount() {
return columns.length ;    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
switch(columnIndex){
    case 0 :
        return vectorhictor.get(rowIndex).getLibelle();
        case 1 :
        return vectorhictor.get(rowIndex).getPrix();
            case 2:
        return vectorhictor.get(rowIndex).getMarque();
            default: return null ;
}
    }
@Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    }     

