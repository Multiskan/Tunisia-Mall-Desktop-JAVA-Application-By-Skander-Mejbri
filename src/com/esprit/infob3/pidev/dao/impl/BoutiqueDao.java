/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.dao.impl;

import com.esprit.infob3.pidev.connexion.Connexion;
import com.esprit.infob3.pidev.entites.Boutique;
import com.esprit.infob3.pidev.entites.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class BoutiqueDao 
{
  public void ajouterBoutique(Boutique b) 
    {
        try {
            String req1 = "insert into boutique (nom,adresse) values (?,?)";
            PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req1);
            ps.setString(1, b.getNom());
            ps.setString(2, b.getAdresse());
            ps.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
    }
public void supprimerBoutique(String nom,String adresse) throws SQLException
{
    try
    {
        String req ="DELETE FROM boutique WHERE nom= '"+nom+"' and adresse='"+adresse+"'" ;
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
        ps.executeUpdate(req);
    }
    catch(SQLException ex) 
    {
     System.out.println(ex);   
    }
 }
public void ajouterProduitBoutique(Produit p, String nom) 
    {
        try {
            String req1 = "insert into boutique (IdProduit) values (?) where nom='"+nom+"' ";
            PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req1);
            ps.setInt(3, p.getIdproduit());
            ps.executeUpdate();
        } catch (SQLException ex) 
        {
            System.out.println(ex);
        }
    }
public void supprimerProduitBoutique(int id) throws SQLException
{
    try
    {
        String req ="DELETE produit FROM boutique WHERE IdProduit= '"+id+"'" ;
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
        ps.executeUpdate(req);
    }
    catch(SQLException ex) 
    {
     System.out.println(ex);   
    }
 }  
public List<Boutique> readAll() throws SQLException
    {
	List<Boutique> v=new ArrayList<>();
	String req="Select * from boutique";
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
	ResultSet rs=ps.executeQuery(req);
    while (rs.next()) 
    {
  	Boutique p=new Boutique(rs.getString(1));
   	v.add(p);
    }
return v;
    }









}
