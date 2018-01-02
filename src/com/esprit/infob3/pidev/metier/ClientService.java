/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.metier;

import com.esprit.infob3.pidev.dao.impl.CarteBancaireDao;
import com.esprit.infob3.pidev.dao.impl.CarteDao;
import com.esprit.infob3.pidev.dao.impl.ClientDao;
import com.esprit.infob3.pidev.dao.impl.ProduitDao;
import java.sql.SQLException;

/**
 *
 * @author ahmed
 */
public class ClientService 
{   
    public boolean achatProduitSpeciale(long numero,int code,int idProduit,int identifiant,int reference) throws SQLException
    {
        CarteBancaireDao c=new CarteBancaireDao();
        ProduitDao p=new ProduitDao();
        ClientDao cl=new ClientDao();
        CarteDao ca=new CarteDao();
        if(ca.findReference(reference)==reference)
        {
      if (p.findPrix(idProduit) <= c.findSolde(numero, code)) 
      {
            c.updateSolde(numero, code,p.findPrix(idProduit));
            cl.updateNbrAchat(identifiant);
            ca.updatePtFidelite(reference);
            return true;
      }
      return false;
    }
        return false;
    }
    public boolean achatProduitSpeciale20(long numero,int code,int idProduit,int identifiant,int reference) throws SQLException
    {
        CarteBancaireDao c=new CarteBancaireDao();
        ProduitDao p=new ProduitDao();
        ClientDao cl=new ClientDao();
        CarteDao ca=new CarteDao();
       if(ca.findReference(reference)==reference)
       {
     if (ca.findPtFidelite(reference) >= 50 && p.findPrix(idProduit)*0.8f <= c.findSolde(numero, code)) 
            {
                c.updateSolde(numero, code,p.findPrix(idProduit)*0.8f);
                cl.updateNbrAchat(identifiant);
                ca.updatePtFidelite20(reference);
                return true;
            }
     return false;
        }
       return false;
    }
    public boolean achatProduitSpeciale40(long numero,int code,int idProduit,int identifiant,int reference) throws SQLException
    {
        CarteBancaireDao c=new CarteBancaireDao();
        ProduitDao p=new ProduitDao();
        ClientDao cl=new ClientDao();
        CarteDao ca=new CarteDao();
       if(ca.findReference(reference)==reference)
       {
     if (ca.findPtFidelite(reference) >= 100 && p.findPrix(idProduit)*0.6f <= c.findSolde(numero, code)) 
            {
                c.updateSolde(numero, code,p.findPrix(idProduit)*0.6f);
                cl.updateNbrAchat(identifiant);
                ca.updatePtFidelite40(reference);
                return true;
            }
     return false;
        }
       return false;
    }
    public boolean achatProduitSpeciale50(long numero,int code,int idProduit,int identifiant,int reference) throws SQLException
    {
        CarteBancaireDao c=new CarteBancaireDao();
        ProduitDao p=new ProduitDao();
        ClientDao cl=new ClientDao();
        CarteDao ca=new CarteDao();
       if(ca.findReference(reference)==reference)
       {
     if (ca.findPtFidelite(reference) >= 150 && p.findPrix(idProduit)*0.5f <= c.findSolde(numero, code)) 
            {
                c.updateSolde(numero, code,p.findPrix(idProduit)*0.5f);
                cl.updateNbrAchat(identifiant);
                ca.updatePtFidelite50(reference);
                return true;
            }
     return false;
        }
       return false;
    }
    public boolean achatProduit(long numero,int code,int idProduit,int identifiant) throws SQLException 
    {
        CarteBancaireDao c=new CarteBancaireDao();
        ProduitDao p=new ProduitDao();
        ClientDao cl=new ClientDao();
        CarteDao ca=new CarteDao();
        if (c.findSolde(numero,code) >= p.findPrix(idProduit)) 
        {
            c.updateSolde(numero, code,p.findPrix(idProduit));
            cl.updateNbrAchat( identifiant);
            return true;
        } 
        return false;
    }
}
