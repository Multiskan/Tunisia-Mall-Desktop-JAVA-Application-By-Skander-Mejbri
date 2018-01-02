/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.GUI;

import com.esprit.infob3.pidev.dao.impl.ClientDao;
import com.esprit.infob3.pidev.entites.Client;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ahmed
 */

public class AffichageClientsupachat extends AbstractTableModel{
    String [] columns  = {"Nom" , "Prenom" , "Email" , "Login" , "Mot de Passe" , "Nombre d'Achat"};
    List<Client> vectorhictor ;
    ClientDao gamer = new ClientDao();
    public AffichageClientsupachat() { 
        try{
        vectorhictor = gamer.readAll();
                }
        catch (SQLException ex) {
        Logger.getLogger(AffichageClientsupachat.class.getName()).log(Level.SEVERE,null,ex);
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
        case 1 :
        return vectorhictor.get(rowIndex).getPrenom();
            case 2:
        return vectorhictor.get(rowIndex).getMail();
        case 3 :
        return vectorhictor.get(rowIndex).getLogin();
        case 4 :
        return vectorhictor.get(rowIndex).getMdp();
            case 5:
        return vectorhictor.get(rowIndex).getNbrAchat();
            default: return null ;
}
    }
@Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
}
    

