/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.esprit.infob3.pidev.connexion.Connexion;
import com.esprit.infob3.pidev.dao.impl.ResponsableDao;
import com.esprit.infob3.pidev.entites.Responsable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ahmed
 */
public class ListeResponsable extends AbstractTableModel {

    List<Responsable> listResponsable;
    String[] colonne = {"id", "Nom", "Prenom", "Email","usernme","password","Etat"};
    private Connection c;
    private PreparedStatement pst;

    public ListeResponsable() {
        //récupération des données
        c = Connexion.getConnexion().getConnection();
        ResponsableDao cdao = new ResponsableDao();
        listResponsable = cdao.findAll2();
    }

    @Override
    public int getRowCount() {
        return listResponsable.size();
    }

    @Override
    public int getColumnCount() {
        return colonne.length;
    }

    @Override
    public Object getValueAt(int rowI, int colI) {
        switch (colI) {
            case 0: {
                return listResponsable.get(rowI).getIdentifiant();
            }
            case 1: {
                return listResponsable.get(rowI).getNom();
            }
            case 2: {
                return listResponsable.get(rowI).getPrenom();
            }
            case 3: {
                return listResponsable.get(rowI).getMail();
            }
            case 4: {
                return listResponsable.get(rowI).getLogin();
            }
            case 5: {
                return listResponsable.get(rowI).getMdp();
            }



            case 6: {
                if (listResponsable.get(rowI).getEtat()==1)
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
