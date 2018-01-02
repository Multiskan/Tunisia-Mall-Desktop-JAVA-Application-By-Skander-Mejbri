/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.esprit.infob3.pidev.connexion.Connexion;
import com.esprit.infob3.pidev.dao.impl.ClientDao;
import com.esprit.infob3.pidev.entites.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ahmed
 */
public class ListeClient extends AbstractTableModel {

    List<Client> listClient;
    String[] colonne = {"id", "Nom", "Prenom", "Email","usernme","password","Etat"};
    private Connection c;
    private PreparedStatement pst;

    public ListeClient() {
        //récupération des données
        c = Connexion.getConnexion().getConnection();
        ClientDao cdao = new ClientDao();
        listClient = cdao.findAll2();
    }

    @Override
    public int getRowCount() {
        return listClient.size();
    }

    @Override
    public int getColumnCount() {
        return colonne.length;
    }

    @Override
    public Object getValueAt(int rowI, int colI) {
        switch (colI) {
            case 0: {
                return listClient.get(rowI).getIdentifiant();
            }
            case 1: {
                return listClient.get(rowI).getNom();
            }
            case 2: {
                return listClient.get(rowI).getPrenom();
            }
            case 3: {
                return listClient.get(rowI).getMail();
            }
            case 4: {
                return listClient.get(rowI).getLogin();
            }
            case 5: {
                return listClient.get(rowI).getMdp();
            }



            case 6: {
                if (listClient.get(rowI).getEtat()==1)
                    return "Activé";
                else
                    return "Desactivé";
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return colonne[i];
    }

}
