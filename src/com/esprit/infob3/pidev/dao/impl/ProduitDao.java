/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.dao.impl;

import com.esprit.infob3.pidev.connexion.Connexion;
import com.esprit.infob3.pidev.entites.Client;
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
public class ProduitDao 
{
    public void ajouterProduitStock(Produit p) 
    {
        try 
        {
            String req1 = "insert into produit (IdProduit,libelle,marque,prix) values (?,?,?,?)";
            PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req1);
            ps.setInt(1, p.getIdproduit());
            ps.setString(2, p.getLibelle());
            ps.setString(3, p.getMarque());
            ps.setFloat(4, p.getPrix());
            ps.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
    }
public void supprimerProduitStock(int id) throws SQLException
{
    try
    {
        String req ="DELETE FROM produit WHERE IdProduit= '"+id+"'" ;
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
        ps.executeUpdate(req);
    }
    catch(SQLException ex) 
    {
     System.out.println(ex);   
    }
 }
public Float findPrix(int identifiant) throws SQLException
    {
	Float a = 0.f;
	String req="Select prix from produit where IdProduit='"+identifiant+"'";
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
	ResultSet rs=ps.executeQuery(req);
    while (rs.next()) 
    {
  	 a=(rs.getFloat("prix"));		
    }
return a;
    }
public List<Produit> readAll() throws SQLException
    {
	List<Produit> v=new ArrayList<>();
	String req="Select * from produit";
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
	ResultSet rs=ps.executeQuery(req);
    while (rs.next()) 
    {
  	Produit p=new Produit(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4));
   	v.add(p);
    }
return v;
    }
public List<Produit> readAllbyname(String id) throws SQLException
    {
	List<Produit> v=new ArrayList<>();
	String req="Select * from produit where nom_magasin='"+id+"' ";
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
	ResultSet rs=ps.executeQuery(req);
    while (rs.next()) 
    {
  	Produit p=new Produit(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4));
   	v.add(p);
    }
return v;
    }
             public int returnidprod(String nommag) throws SQLException{
             String req="Select idProduit from produit where libelle='"+nommag+"' ";    
                PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
	ResultSet rs=ps.executeQuery(req);
    while (rs.next()) 
    {
         int p=(rs.getInt(1)); 
         return p ;
       
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
}
return 0 ;}}













