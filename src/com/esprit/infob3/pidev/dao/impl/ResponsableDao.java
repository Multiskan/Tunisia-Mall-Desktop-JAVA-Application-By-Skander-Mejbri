/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.dao.impl;

import com.esprit.infob3.pidev.connexion.Connexion;
import com.esprit.infob3.pidev.entites.Client;
import com.esprit.infob3.pidev.entites.Responsable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;

/**
 *
 * @author ahmed
 */
public class ResponsableDao 
{
  public void ajouterResponsable(Responsable r) 
    {
        try {
            String req = "insert into responsable (type,nom,prenom,email,login,mdp) values ('responsable',?,?,?,?,?)";
            PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
            ps.setString(3, r.getNom());
            ps.setString(4, r.getPrenom());
            ps.setString(5, r.getMail());
            ps.setString(6, r.getLogin());
            ps.setString(7, r.getMdp());
            ps.executeUpdate();
        } catch (SQLException ex) 
        {
            System.out.println(ex);
        }
    }
public Vector<Responsable> readAll() throws SQLException
    {
	Vector<Responsable> v=new Vector<>();
	String req="Select * from responsable";
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
	ResultSet rs=ps.executeQuery(req);
    while (rs.next()) {
  	Responsable r=new Responsable(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9));
   		v.add(r);
    }
return v;
    }
public void modifierResponsable(String identifiant,String login,String mdp)
{
        
          String     req="UPDATE responsable SET mdp='"+mdp+"' and login='"+login+"' WHERE IdResponsable= '"+identifiant+"' " ;
         try 
         {
         PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
          ps.executeUpdate(req);
         } 
     catch (SQLException ex) 
    {
        System.out.println(ex);
    }
}
 public void add2(Responsable p) throws NoSuchAlgorithmException {
        String req = "insert into user (identifiant,type,nom,prenom,email,login,mdp,etat) values (?,?,?,?,?,?,?,1)";
        try {
       PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
            
            ps.setInt(1, p.getIdentifiant());
            ps.setString(2, "Responsable");
            
            ps.setString(3, p.getNom());
            ps.setString(4, p.getPrenom());
            ps.setString(5, p.getMail());
            ps.setString(6, p.getLogin());
            ps.setString(7, hashPassword2(p.getMdp()));
        
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    
    }
    
    public void update2(Responsable p) {
        String req = "UPDATE user SET nom = ? , prenom= ? , email = ?, login= ? , mdp= ?   WHERE identifiant =? ";
        try {
             PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
            
            
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getMail());
            ps.setString(4, p.getLogin());
            ps.setString(5, hashPassword2(p.getMdp()));
            
            
            ps.setInt(6, p.getIdentifiant());
            ps.executeUpdate();
        } catch (SQLException ex) {
            printStackTrace(ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ResponsableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
    public void updateEtat2(Responsable p) {
        String req = "UPDATE user SET Etat=?  WHERE identifiant =?";
        try {
             PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
            
            ps.setInt(1, p.getEtat());
            ps.setInt(2,p.getIdentifiant());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            printStackTrace(ex);
        }
    }

    
    public void removeById2(int id) {
        String requete = "delete from user where identifiant=?";
        try {
            PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    
    public List<Responsable> findAll2() 
    {
        List<Responsable> Responsable = new ArrayList<Responsable>();

        String req = "SELECT identifiant,nom,prenom,email,login,mdp,Etat FROM  user where type='Responsable' ";

        ResultSet rs;

        try {
             PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
            rs = ps.executeQuery(req);

            Responsable c;

            while (rs.next()) {
                c = new Responsable(
                        rs.getInt("identifiant"),
                        
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("login"),
                        rs.getString("mdp"),
                        
                        rs.getInt("etat")
                );
                Responsable.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Responsable;
    }

   
    public Responsable findById2(int id) {
        Responsable c = new Responsable();
        String requete = "select identifiant,nom,prenom,email,login,mdp FROM  user where identifiant=?";
        try {
           PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                c.setIdentifiant(resultat.getInt(1));
            c.setNom(resultat.getString(2));    
            c.setPrenom(resultat.getString(3));
            c.setMail(resultat.getString(4));
            c.setLogin(resultat.getString(5));
            c.setMdp(resultat.getString(6));
            

            }
            return c;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'un Responsable " + ex.getMessage());
            return null;
        }

    }

    public boolean verifLogin2(Responsable user) {

        String query = "select * from user where login=? and mdp=? where type='Responsable'";

        ResultSet res;
        try {
             PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(query);
            ps.setString(6, user.getLogin());
            ps.setString(7, user.getMdp());
            res = ps.executeQuery();
            if (res.next()) {
                return true;
            }
            ps.close();
            res.close();

        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public boolean verifUser2(String username) {

        String query = "select * from user where login=? ";

        ResultSet res;
        try {
             PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(query);
            
            ps.setString(6, username);
            
            res = ps.executeQuery();
            if (res.next()) {
                return true;
            }
            ps.close();
            res.close();

        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

   

    public Responsable findBylogs2(Responsable user) {
        Responsable m = new Responsable();
        String requete = "select identifiant,nom,prenom,email,login,mdp FROM  Responsable where login=? and mdp=?";
        try {
             PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(requete);
            ps.setString(6, user.getLogin());
            ps.setString(7, user.getMdp());
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
               m.setIdentifiant(resultat.getInt(1));
               m.setLogin(resultat.getString(6));
               m.setMdp(resultat.getString(7));

                m.setPrenom(resultat.getString(4));
                m.setNom(resultat.getString(3));
                m.setMail(resultat.getString(5));

            }
            

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'un Responsable " + ex.getMessage());
            return null;
        }
            return m;
    }
     private String hashPassword2(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(password.getBytes());
        byte[] b = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b1 : b) {
            sb.append(Integer.toString((b1 & 0xff) + 0x100, 16).substring(1));

        }

        return sb.toString();
    }


public Responsable returnclientauth2(String login,String mdp) throws SQLException
    {
        List<Client> list=new ArrayList<>();
    String sql="select * from user where login='"+login+"' and type='responsable' and mdp='"+mdp+"'";
    Responsable g = null ;
   PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(sql);
	ResultSet rs=ps.executeQuery(sql);
     while    (rs.next()) 
     {            
   g = new Responsable(rs.getInt(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
      return g;      
     }
   return g;
    }

}
