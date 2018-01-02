/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.dao.impl;

import com.esprit.infob3.pidev.connexion.Connexion;
import com.esprit.infob3.pidev.entites.Carte;
import com.esprit.infob3.pidev.entites.Client;
import com.esprit.infob3.pidev.entites.Responsable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ahmed
 */
public class CarteDao 
{
    public void ajouterCarte(Carte c,String login) 
    {
        ClientDao cdao=new ClientDao();
        try {
            String req1 = "insert into carte (identifiant,nom,reference,ptFidelite) values (?,?,?,?)";
            PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req1);
            ps.setInt(1, cdao.findIdentifiant(login));
            ps.setString(2, c.getNom());
            ps.setInt(3, c.getReference());
            ps.setInt(4, c.getPtFidelite());
            ps.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
            
        }
    }
    
    
    public void updatePtFidelite(int reference) 
    {
       

        String req = "update carte set ptFidelite=ptFidelite + 5 where reference='"+reference+"'";
        try 
        {
            PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
            ps.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }

    }
    public void updatePtFidelite20(int reference) 
    {
       

        String req = "update carte set ptFidelite=ptFidelite - 50 where reference='"+reference+"'";
        try 
        {
            PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
            ps.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }

    }
    public void updatePtFidelite40(int reference) 
    {
       

        String req = "update carte set ptFidelite=ptFidelite - 100 where reference='"+reference+"'";
        try 
        {
            PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
            ps.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }

    }
    public void updatePtFidelite50(int reference) 
    {
       

        String req = "update carte set ptFidelite=ptFidelite - 150 where reference='"+reference+"'";
        try 
        {
            PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
            ps.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }

    }
    public int findPtFidelite(int reference) throws SQLException
    {
	int a = 0;
	String req="Select ptFidelite from carte where reference='"+reference+"'";
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
	ResultSet rs=ps.executeQuery(req);
    while (rs.next()) {
  	 a=(rs.getInt("ptFidelite"));
   		
    }
return a;
    }
    public int findReference(int reference) throws SQLException
    {
	int a = 0;
	String req="Select reference from carte where reference='"+reference+"'";
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
	ResultSet rs=ps.executeQuery(req);
    while (rs.next()) {
  	 a=(rs.getInt("reference"));
   		
    }
return a;
    }
    
}
