/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.dao.impl;
import com.esprit.infob3.pidev.connexion.Connexion;
import com.esprit.infob3.pidev.connexion.Myconnection;
import com.esprit.infob3.pidev.entites.Client;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
/**
 *
 * @author ahmed
 */
public class ClientDao 
{
        private final Connection con = Myconnection.getInstance() ; 
private Statement ste ;

    public ClientDao() {
        try {
    
    System.out.println("connexion établie");
    ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        
        }
    }

    public void ajouterClient(Client c) 
    {
        try 
        {
            String req1 = "insert into user (identifiant,type,nom,prenom,email,login,mdp) values (?,?,?,?,?,?,?)";
            PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req1);
            ps.setInt(1,c.getIdentifiant());
            ps.setString(2,"client");
            ps.setString(3, c.getNom());
            ps.setString(4, c.getPrenom());
            ps.setString(5, c.getMail());
            ps.setString(6, c.getLogin());
            ps.setString(7, c.getMdp());
            ps.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
    }
    
public void updateNbrAchat(int identifiant) 
    {
        String req = "update user set nbrAchat=nbrAchat + 1 where identifiant='"+identifiant+"'";
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
public List<Client> readAll() throws SQLException
    {
	List<Client> v=new ArrayList<>();
	String req="Select nom,prenom,email,login,mdp,nbrAchat from user where nbrAchat>=5 and type='client'";
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
	ResultSet rs=ps.executeQuery(req);
    while (rs.next()) 
    {
  	Client c=new Client(rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("login"),rs.getString("mdp"),rs.getInt("nbrAchat"));
   	v.add(c);
    }
return v;
    }
public int findNbrAchat(int identifiant) throws SQLException
    {
	int a = 0;
	String req="Select nbrAchat from user where identifiant='"+identifiant+"'";
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
	ResultSet rs=ps.executeQuery(req);
    while (rs.next()) 
    {
  	 a=(rs.getInt("nbrAchat"));		
    }
return a;
    }
public int findIdentifiant(String login) throws SQLException
    {
	int a = 0;
	String req="Select identifiant from user where login='"+login+"' and type='client'";
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
	ResultSet rs=ps.executeQuery(req);
    while (rs.next()) 
    {
  	 a=(rs.getInt("identifiant"));		
    }
return a;
    }
public Client returnclientauth(String login,String mdp) throws SQLException
    {
        List<Client> list=new ArrayList<>();
    String sql="select * from user where login='"+login+"' and type='client' and mdp='"+mdp+"'";
    Client g = null ;
   PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(sql);
	ResultSet rs=ps.executeQuery(sql);
     while    (rs.next()) 
     {            
   g = new Client(rs.getInt(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
      return g;      
     }
   return g;
    }

    public void add2(Client p) throws NoSuchAlgorithmException {
        String req = "insert into user (identifiant,type,nom,prenom,email,login,mdp,etat) values (?,?,?,?,?,?,?,1)";
        try {
       PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
            
            ps.setInt(1, p.getIdentifiant());
            ps.setString(2, "client");
            
            ps.setString(3, p.getNom());
            ps.setString(4, p.getPrenom());
            ps.setString(5, p.getMail());
            ps.setString(6, p.getLogin());
            ps.setString(7, hashPassword2(p.getMdp()));
        
            ps.executeUpdate();
        } catch (SQLException ex) {
            printStackTrace(ex);
        }
    
    
    }
    
    public void update2(Client p) {
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
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
    public void updateEtat2(Client p) {
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
     public void updateMdp(String login,String mdp) throws SQLException {
        String req = "UPDATE user SET mdp='"+mdp+"'  WHERE login ='"+login+"'" ;
        
            ste.executeUpdate(req);
      
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

    
    public List<Client> findAll2() 
    {
        List<Client> client = new ArrayList<Client>();

        String req = "SELECT identifiant,nom,prenom,email,login,mdp,etat FROM  user where type='client' ";

        ResultSet rs;

        try {
             PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
            rs = ps.executeQuery(req);

            Client c;

            while (rs.next()) {
                c = new Client(
                        rs.getInt("identifiant"),
                        
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("login"),
                        rs.getString("mdp"),
                        
                        rs.getInt("etat")
                );
                client.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

   
    public Client findById2(int id) {
        Client c = new Client();
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
            System.out.println("erreur lors de la recherche d'un Client " + ex.getMessage());
            return null;
        }

    }

    public boolean verifLogin2(Client user) {

        String query = "select * from user where login=? and mdp=? where type='client'";

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

   

    public Client findBylogs2(Client user) {
        Client m = new Client();
        String requete = "select identifiant,nom,prenom,email,login,mdp FROM  client where login=? and mdp=?";
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
            System.out.println("erreur lors de la recherche d'un Client " + ex.getMessage());
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
public List<Client> readAllS() throws SQLException
    {
	List<Client> v=new ArrayList<>();
	String req="Select nom,mdp,nbrAchat from user where nbrAchat>=5 and type='client'";
        PreparedStatement ps = Connexion.getConnexion().getConnection().prepareStatement(req);
	ResultSet rs=ps.executeQuery(req);
    while (rs.next()) 
    {
  	Client c=new Client(rs.getString("nom"),rs.getString("mdp"),rs.getInt("nbrAchat"));
   	v.add(c);
    }
return v;
    }

} 

