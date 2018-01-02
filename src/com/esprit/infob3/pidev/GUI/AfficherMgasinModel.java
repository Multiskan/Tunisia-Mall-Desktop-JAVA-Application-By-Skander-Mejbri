/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.infob3.pidev.GUI;

import com.esprit.infob3.pidev.dao.impl.BoutiqueDao;
import com.esprit.infob3.pidev.dao.impl.ClientDao;
import com.esprit.infob3.pidev.entites.Boutique;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */

public class AfficherMgasinModel extends AbstractTableModel{
    String [] columns  = {"Nom Magasin"};
    List<Boutique> vectorhictor ;
    BoutiqueDao gamer = new BoutiqueDao();
    public AfficherMgasinModel() { 
        try{
        vectorhictor = gamer.readAll();
                }
        catch (SQLException ex) {
        Logger.getLogger(AfficherMgasinModel.class.getName()).log(Level.SEVERE,null,ex);
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
        return vectorhictor.get(rowIndex).getNom();
        
          
       
            default: return null ;
}
    }
@Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
}
        

