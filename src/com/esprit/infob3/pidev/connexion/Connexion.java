/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
/**
 *
 * @author ahmed
 */
public class Connexion 
{
    private String url;
    private String login;
    private String password;
    private Connection conn;
    private static Connexion connexion;
    public Connexion()
    {
        url="jdbc:mysql://localhost:3306/tnmall";
        login="root";
        password="";
        try
        {
            conn=DriverManager.getConnection(url,login,password);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    public Connection getConnection()
    {
        return conn;
    }
    public static Connexion getConnexion()
    {
        if(connexion==null)
        {
            connexion=new Connexion();
        }
        return connexion;
    }
}
