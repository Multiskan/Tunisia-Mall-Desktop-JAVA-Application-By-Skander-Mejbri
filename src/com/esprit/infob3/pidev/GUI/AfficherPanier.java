/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.infob3.pidev.GUI;

import com.esprit.infob3.pidev.dao.impl.ClientDao;
import com.esprit.infob3.pidev.dao.impl.PanierDao;
import com.esprit.infob3.pidev.dao.impl.ProduitDao;
import com.esprit.infob3.pidev.entites.Produit;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */

    public class AfficherPanier extends AbstractTableModel{
    String [] columns  = {"Product Name"};
    List<Produit> vectorhictor ;
    
   PanierDao gamer = new PanierDao();
   ClientDao cdao  = new ClientDao();
    public AfficherPanier() { 
       
        try {String login = ClientAuth.jTextField1.getText();
        int identifiantclient = cdao.findIdentifiant(login);
            vectorhictor = gamer.readAllbyname(identifiantclient);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherPanier.class.getName()).log(Level.SEVERE, null, ex);
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
          
            default: return null ;
}
    }
@Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
}
