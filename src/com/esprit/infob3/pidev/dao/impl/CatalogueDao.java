/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.dao.impl;

import com.esprit.infob3.pidev.connexion.Connexion;
import com.esprit.infob3.pidev.connexion.Myconnection;
import com.esprit.infob3.pidev.entites.catalogue;
import com.esprit.infob3.pidev.entites.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class CatalogueDao 
{
  
       private final Connection con = Myconnection.getInstance() ; 
private Statement ste ;
PreparedStatement pste ;   

 public CatalogueDao(){
    

      try {
    
    System.out.println("connexion établie");
    ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
   }
 public List<catalogue> afficherCatalogue() throws SQLException
    {
     List<catalogue> list=new ArrayList<>();
    String sql="select * from catalogue  ";
   catalogue g = null ;
    ResultSet rs=ste.executeQuery(sql);
     while    (rs.next()) 
     {   
              g = new catalogue(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
            list.add(g);
     }
             return list;
    }
    public void ajouterCatalogue(catalogue c)  throws SQLException
    {
            String req1 = "insert into catalogue(`idcatalogue`,`nom`, `type`,`idProduit_fk` ) VALUES ('"+c.getIdcatalogue()+"','"+c.getNom()+"','"+c.getType()+"',0)" ;
             ste.executeUpdate(req1);
    }
public void ajouterProduitCatalogue(Produit p,catalogue c) throws SQLException
    {
            String req1 = "insert into catalogue (`idcatalogue`,`nom`, `type`,`IdProduit_fk`) values ('"+c.getIdcatalogue()+"','"+c.getNom()+"','"+c.getType()+"','"+p.getIdproduit()+"')";
             ste.executeUpdate(req1);
    }

public void supprimerProduitCatalogue(int id) throws SQLException
{
        String req ="delete  from catalogue WHERE idProduit_fk= '"+id+"'" ;
         PreparedStatement ps = Myconnection.getInstance().prepareStatement(req);
    ps.executeUpdate(req);
      
 }

public void supprimerCatalogue(String nom,String type) throws SQLException
{
        String req ="DELETE FROM catalogue WHERE nom= '"+nom+"' and type='"+type+"'" ;
        ste.executeUpdate(req);
 }

    public Produit returnproductbyid(int id) throws SQLException
    {
    String sql="select * from produit where  idproduit='"+id+"'";
    Produit g = null ;
    PreparedStatement ps = Myconnection.getInstance().prepareStatement(sql);
    ResultSet rs=ps.executeQuery(sql);
     while    (rs.next())            
   g = new Produit(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5));  
    return g;
    }
    
     public     catalogue returncatbyname(String nom) throws SQLException
    {  
    String sql="select * from catalogue where nom ='"+nom+"' ";
   catalogue g = null ;
    PreparedStatement ps = Myconnection.getInstance().prepareStatement(sql);
    ResultSet rs=ps.executeQuery(sql);
     while    (rs.next())             
     {
         g = new catalogue(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
     }
    return g;
    }
     
     public void modifierCatalogue(String nom,int id) throws SQLException
{    
        String req ="update `catalogue` set  idProduit_fk='"+id+"' WHERE nom= '"+nom+"' " ;
        PreparedStatement ps = Myconnection.getInstance().prepareStatement(req);
        ps.executeUpdate(req);
 }
     
     public void modifierCatalogueparid(int idc,int id) throws SQLException
{
        String req ="update `catalogue` set  `idProduit_fk`='"+id+"' WHERE Idcatalogue= '"+idc+"' " ;
        PreparedStatement ps = Myconnection.getInstance().prepareStatement(req);
        ps.executeUpdate(req);
 }
     public catalogue printcatalogue() throws SQLException
     {
         String sql="select * from catalogue ' ";
         catalogue g = null ;
      PreparedStatement ps = Myconnection.getInstance().prepareStatement(sql);
    ResultSet rs=ps.executeQuery(sql);
       while    (rs.next())             
     {
         g = new catalogue(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
     }
    return g;
     }
     
     
        public int PDFcatalogue() throws SQLException
     {
         int rowno=0;
         String sql="select * from catalogue ";
         catalogue g = null ;
      Statement ste = Myconnection.getInstance().prepareStatement(sql);
       ste=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs=ste.executeQuery(sql);
       java.sql.ResultSetMetaData rsmd=rs.getMetaData();
         int colno=rsmd.getColumnCount();
       while    (rs.next())             
     { rowno=rowno+1;
         g = new catalogue(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
       
     }
       
    return colno;
     }}

