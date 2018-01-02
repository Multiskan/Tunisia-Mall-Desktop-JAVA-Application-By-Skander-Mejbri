/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.dao.impl;

import com.esprit.infob3.pidev.connexion.Connexion;
import com.esprit.infob3.pidev.entites.CarteBancaire;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ahmed
 */
public class CarteBancaireDao
{
  public void updateSolde(long numero,int code,Float solde) 
  {
        String req = "update CarteBancaire set solde=solde - '"+solde+"' where numeroCarte='"+numero+"' and code='"+code+"'";
        try {
            PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    } 
  public Float findSolde(long numero,int code) throws SQLException
    {
	Float a = 0.f;
	String req="Select solde from carteBancaire where numeroCarte='"+numero+"' and code='"+code+"'";
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
	ResultSet rs=ps.executeQuery(req);
    while (rs.next()) {
  	 a=(rs.getFloat("solde"));
   		
    }
return a;
    }
}
