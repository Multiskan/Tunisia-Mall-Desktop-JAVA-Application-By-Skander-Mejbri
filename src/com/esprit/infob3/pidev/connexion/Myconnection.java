/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.infob3.pidev.connexion;

/**
 *
 * @author HP
 */
import java.sql.* ;
import java.lang.NullPointerException ;
public class Myconnection {
    
    static String url = "jdbc:mysql://localhost:3306/tnmall";
    static String user = "root";
    static String pwd = "";
    private static  Connection con;
    private static Statement ste;
private Myconnection()
{
     try {
    con = DriverManager.getConnection(url, user, pwd);
    System.out.println("connexion établie");
    ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
}
public static Connection getInstance()
{
    if (con==null)
      new Myconnection();
    return con ;
}
}