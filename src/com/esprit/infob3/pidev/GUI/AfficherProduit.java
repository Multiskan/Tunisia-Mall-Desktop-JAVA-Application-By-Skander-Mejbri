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

/**
 *
 * @author ahmed
 */

  public class AfficherProduit extends AbstractTableModel{
    String [] columns  = {"Product ID","Product Name" , " Product Price" , "Product Mark"};
    List<Produit> vectorhictor ;
    
   ProduitDao gamer = new ProduitDao();
    public AfficherProduit() { 
       
        try {
            vectorhictor = gamer.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherProduit.class.getName()).log(Level.SEVERE, null, ex);
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
        return vectorhictor.get(rowIndex).getIdproduit();
        case 1 :
        return vectorhictor.get(rowIndex).getLibelle();
            case 2:
        return vectorhictor.get(rowIndex).getMarque();
            case 3:
                return vectorhictor.get(rowIndex).getPrix();
            default: return null ;
}
    }
@Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
}  

  

