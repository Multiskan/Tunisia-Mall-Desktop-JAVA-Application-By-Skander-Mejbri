/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.dao.impl;

import com.esprit.infob3.pidev.connexion.Connexion;
import com.esprit.infob3.pidev.entites.Client;
import com.esprit.infob3.pidev.entites.Compte;
import com.esprit.infob3.pidev.entites.Responsable;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ahmed
 */
public class CompteDao 
{
  public void validerClient(Client c,Compte p) 
    {
        try {
            String req1 = "insert into compte (numero,iduser) values (?,?)";
            PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req1);
            ps.setInt(1, p.getNum());
           
            ps.setInt(2, c.getIdentifiant());        
            ps.executeUpdate();
        } catch (SQLException ex) 
        {
            System.out.println(ex);
        }
    }
    public void validerResponsable(Responsable r,Compte p) 
    {
        try {
            String req1 = "insert into compte (numero,type,IdResponsable) values (?,?,?)";
            PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req1);
            ps.setInt(1, p.getNum());
            ps.setInt(2, r.getIdentifiant());        
            ps.executeUpdate();
        } catch (SQLException ex) 
        {
            System.out.println(ex);
        }
    }
    public void bloquerClient(int identifiant) throws SQLException
{
    try
    {
        String req ="DELETE FROM compte WHERE type= 'client' and IdClient='"+identifiant+"'" ;
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
        ps.executeUpdate(req);
    }
    catch(SQLException ex) 
    {
     System.out.println(ex);   
    }
 }
    public void bloquerResponsable(int identifiant) throws SQLException
{
    try
    {
        String req ="DELETE FROM compte WHERE type= 'responsable' and IdResponsable='"+identifiant+"'" ;
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
        ps.executeUpdate(req);
    }
    catch(SQLException ex) 
    {
     System.out.println(ex);   
    }
 }  
}
