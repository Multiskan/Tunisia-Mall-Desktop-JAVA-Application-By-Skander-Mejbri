/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.infob3.pidev.GUI;

import com.esprit.infob3.pidev.dao.impl.CatalogueDao;
import com.esprit.infob3.pidev.entites.catalogue;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author sinda
 */
public class AfficherCatalogue extends AbstractTableModel{
   String [] columns  = {" Catalogue id" , " Catalogue Name" , "Catalogue type" , "Cataogue Produit"};
    List<catalogue> vectcatal ;
    
    CatalogueDao gamer = new CatalogueDao();
    public AfficherCatalogue() { 
        try{
        vectcatal = gamer.afficherCatalogue();
                }
        catch (SQLException ex) {
        Logger.getLogger(AfficherCatalogue.class.getName()).log(Level.SEVERE,null,ex);
               }
    }

@Override
    public int getRowCount() {
 return vectcatal.size();
    }

    @Override
    public int getColumnCount() {
return columns.length ;    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
switch(columnIndex){
    case 0 :
        return vectcatal.get(rowIndex).getIdcatalogue();
        case 1 :
        return vectcatal.get(rowIndex).getNom();
            case 2:
        return vectcatal.get(rowIndex).getType();
                    case 3:
        return vectcatal.get(rowIndex).getIdproduit();
            default: return null ;
}
    }
@Override
    public String getColumnName(int column) {
        return columns[column];
    }}
    
    

