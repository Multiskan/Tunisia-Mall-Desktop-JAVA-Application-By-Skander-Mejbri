/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.dao.impl;

import com.esprit.infob3.pidev.connexion.Connexion;
import com.esprit.infob3.pidev.entites.Panier;
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
public class PanierDao 
{
  public void ajouterPanier(Panier p) 
    {
        try {
            String req1 = "insert into panier (nom,IdClient,IdProduit) values (?,?,?)";
            PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req1);
            ps.setString(1, p.getNom());
            ps.setInt(2, p.getIdclient());
            ps.setInt(3, p.getIdproduit());
            ps.executeUpdate();
        } catch (SQLException ex) 
        {
            System.out.println(ex);
        }
    }
public void supprimerPanier(String nom) throws SQLException
{
    try
    {
        String req ="DELETE FROM panier WHERE nom= '"+nom+"'" ;
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
        ps.executeUpdate(req);
    }
    catch(SQLException ex) 
    {
     System.out.println(ex);   
    }
 }
public void ajouterProduitPanier(Produit p) 
    {
        try {
            String req1 = "insert into panier (IdProduit) values (?)";
            PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req1);
            ps.setInt(1, p.getIdproduit());
            ps.executeUpdate();
        } catch (SQLException ex) 
        {
            System.out.println(ex);
        }
    }
public void supprimerProduitPanier(String id) throws SQLException
{
    try
    {
        String req ="DELETE FROM panier WHERE nom= '"+id+"'" ;
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
        ps.executeUpdate(req);
    }
    catch(SQLException ex) 
    {
     System.out.println(ex);   
    }
 } 
public List<Produit> readAllbyname(int idclient) throws SQLException
    {
	List<Produit> v=new ArrayList<>();
       // SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate
//FROM Orders
//INNER JOIN Customers
//ON Orders.CustomerID=Customers.CustomerID;
	String req="Select produit.libelle,produit.IdProduit from produit  INNER join panier ON produit.IdProduit=panier.IdProduit  where panier.IdClient='"+idclient+"' ";
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
	ResultSet rs=ps.executeQuery(req);
    while (rs.next()) 
    {
  	Produit p=new Produit(rs.getString(1));
   	v.add(p);
    }
return v;
    }




















}
