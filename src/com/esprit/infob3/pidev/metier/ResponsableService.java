/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.metier;

import com.esprit.infob3.pidev.dao.impl.CarteDao;
import com.esprit.infob3.pidev.dao.impl.ClientDao;
import com.esprit.infob3.pidev.entites.Carte;
import com.esprit.infob3.pidev.entites.Pack;
import com.esprit.infob3.pidev.entites.Responsable;
import java.sql.SQLException;

/**
 *
 * @author ahmed
 */
public class ResponsableService 
{
  public boolean creerCarte(Carte carte,String login) throws SQLException
{   
    ClientDao c = new ClientDao();
    CarteDao ca=new CarteDao();
    int a=c.findIdentifiant(login);
    if(c.findNbrAchat(a)<5)
    {
        return false;
    }
    else
    {
    ca.ajouterCarte(carte,login);
    return true;  
    }
}
  public boolean acheterPack(Pack p,Responsable r)
  {
      if(r.getCarteBancaire().getSolde()<p.getPrix())
      {
          return false;
      }
      return true;
  }
}
