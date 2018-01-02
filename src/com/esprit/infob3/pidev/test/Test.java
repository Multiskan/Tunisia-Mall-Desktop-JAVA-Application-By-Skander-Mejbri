/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.test;

import com.esprit.infob3.pidev.dao.impl.BoutiqueDao;
import com.esprit.infob3.pidev.dao.impl.CarteBancaireDao;
import com.esprit.infob3.pidev.dao.impl.CarteDao;
import com.esprit.infob3.pidev.dao.impl.ClientDao;
import com.esprit.infob3.pidev.dao.impl.ProduitDao;
import com.esprit.infob3.pidev.entites.Boutique;
import com.esprit.infob3.pidev.entites.Carte;
import com.esprit.infob3.pidev.entites.CarteBancaire;
import com.esprit.infob3.pidev.entites.Client;
import com.esprit.infob3.pidev.entites.Produit;
import com.esprit.infob3.pidev.metier.ClientService;
import com.esprit.infob3.pidev.metier.ResponsableService;
import java.sql.SQLException;

/**
 *
 * @author ahmed
 */
public class Test 
{
  public static void main(String[] args) throws SQLException
  {
      //Client c=new Client("lamouri","farah","ahmed.selmi@esprit.tn","abab","abab");
      //Client c1=new Client("selmi","ahmed","farah.lamouri@esprit.tn","baba","baba");
      //ClientDao cdao=new ClientDao();
     // cdao.ajouterClient(c);
      //cdao.ajouterClient(c1);
      //cdao.updateNbrAchat(c1, cdao.findIdentifiant("baba"));
      Produit p=new Produit(123,"pull","zara",55.f);
      ProduitDao pdao=new ProduitDao();
      //pdao.ajouterProduitStock(p);
      //Boutique b=new Boutique("zara", "rue de marseille");
      //BoutiqueDao bdao=new BoutiqueDao();
      //bdao.ajouterBoutique(b);
      //bdao.ajouterProduitBoutique(p,"zara");
      //Carte t=new Carte(cdao.findIdentifiant("abab"),"zara",123,0);
      //CarteDao d=new CarteDao();
      //d.updatePtFidelite50(123);
     //d.updatePtFidelite(t, 123);
      //System.out.println(d.findPtFidelite(123));
      //d.ajouterCarte(t);
      //CarteBancaire carte=new CarteBancaire(12333,1445,100.f,c);
      //ClientService s=new ClientService();
      //s.achatProduit(c, p);
      //ResponsableService s=new ResponsableService();
      //s.creerCarte(t, cdao, d, "abab");
      //System.out.println( cdao.findNbrAchat(1));
      //System.out.println(cdao.findIdentifiant("mmmm"));
      //CarteBancaireDao c=new CarteBancaireDao();
      //System.out.println(c.findSolde(505050, 1212));
      //c.updateSolde(505050, 1212,50.f);
      //System.out.println(pdao.findPrix(123));
      ClientService r=new ClientService();
      System.out.println(r.achatProduitSpeciale50(505050, 1212, 123, 2, 123));
      
  }
}
