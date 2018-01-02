/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.dao.impl;

import com.esprit.infob3.pidev.connexion.Connexion;
import com.esprit.infob3.pidev.entites.Admin;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;

/**
 *
 * @author ahmed
 */
public class AdminDao 
{
    
    private final Connection connection;
    private PreparedStatement pst;

    public AdminDao() {
        connection = Connexion.getConnexion().getConnection();
        
    }

    

     public void add(Admin a) {
        String req = "insert into user (type,nom,prenom,email,login,mdp,etat) values ('admin',?,?,?,?,?,1)";
        try {
            pst = connection.prepareStatement(req);
            
            pst.setString(1, a.getNom());
            pst.setString(2, a.getPrenom());
            pst.setString(3, a.getMail());
            pst.setString(4, a.getLogin());
            pst.setString(5, hashPassword1(a.getMdp()));
            
            
        
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    public void update(Admin a) {
        String req = "UPDATE user SET nom = ? , prenom= ? , email = ?, username= ? , password= ?   WHERE identifiant =? and type='admin' ";
        try {
            pst = connection.prepareStatement(req);
            
            pst.setString(2, a.getNom());
            pst.setString(3, a.getPrenom());
            pst.setString(4, a.getMail());
            pst.setString(5, a.getLogin());
            
            pst.setString(6, a.getMdp());
            
            
            pst.setInt(6, a.getIdentifiant());
            pst.executeUpdate();
        } catch (SQLException ex) {
            printStackTrace(ex);
        }
    }

    
    
    
  

    public void removeById(int id) {
        
    }

    public List<Admin> findAll() {
        List<Admin> Admin = new ArrayList<Admin>();

        String req = "SELECT identifiant,nom,prenom,mail,login,mdp FROM  user where type = 'admin' ";

        ResultSet rs;

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery(req);

            Admin a;

            while (rs.next()) {
                a = new Admin(
                           rs.getInt("identifiant"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("mail"),
                        rs.getString("login"),
                        rs.getString("mdp")
                        
                       
                );
                Admin.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Admin;
    }

    public Admin findById(int id) {
        Admin a = new Admin();
        String requete = "select identifiant, nom,prenom,mail,login,mdp FROM  user where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
            a.setIdentifiant(resultat.getInt(1));    
            a.setNom(resultat.getString(3));
            a.setPrenom(resultat.getString(4));
            a.setMail(resultat.getString(5));
            a.setLogin(resultat.getString(6));
            a.setMdp(resultat.getString(7));
           

            }
            return a;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'un Admin " + ex.getMessage());
            return null;
        }

    }

    public boolean verifLogin(String username , String password) throws NoSuchAlgorithmException {

        String query = "select * from user where login=? and mdp=? ";

        ResultSet res;
        try {
            pst = connection.prepareStatement(query);
            pst.setString(1, username );
            pst.setString(2, hashPassword( password));
            res = pst.executeQuery();
            if (res.next()) {
                return true;
            }
            pst.close();
            res.close();

        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public boolean verifUser(String username) {

        String query = "select * from Admin where username=? ";

        ResultSet res;
        try {
            pst = connection.prepareStatement(query);
            pst.setString(1, username);
            
            res = pst.executeQuery();
            if (res.next()) {
                return true;
            }
            pst.close();
            res.close();

        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

   

    public Admin findBylogs(Admin user) {
        Admin m = new Admin();
        String requete = "select identifiant,nom,prenom,mail,login,mdp, FROM  Admin where username=? and password=?";
        try {
            pst = connection.prepareStatement(requete);
            pst.setString(1, user.getLogin());
            pst.setString(2, user.getMdp());
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                m.setIdentifiant(resultat.getInt(1));
                m.setLogin(resultat.getString(6));
                m.setMdp(resultat.getString(7));

                m.setPrenom(resultat.getString(4));
                m.setNom(resultat.getString(3));
                m.setMail(resultat.getString(5));

            }
            

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'un Admin " + ex.getMessage());
            return null;
        }
            return m;
    }
        private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(password.getBytes());
        byte[] b = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b1 : b) {
            sb.append(Integer.toString((b1 & 0xff) + 0x100, 16).substring(1));

        }

        return sb.toString();
    }
        private String hashPassword1(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(password.getBytes());
        byte[] b = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b1 : b) {
            sb.append(Integer.toString((b1 & 0xff) + 0x100, 16).substring(1));

        }

        return sb.toString();
    }
    
}
