/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.entites;

/**
 *
 * @author ahmed
 */
public class Admin extends User 
{
public Admin(){}

public Admin(String nom, String prenom, String mail, String login, String mdp, CarteBancaire carteBancaire) 
{
    super(nom, prenom, mail, login, mdp, carteBancaire);
}
public Admin(int identifiant, String nom, String prenom, String mail, String login, String mdp){
    super(identifiant,nom, prenom, mail, login, mdp);
}
public Admin( String nom, String prenom,String mail,  String login, String mdp){
    super(nom, prenom,  mail , login, mdp);
}

@Override
public String toString()
{
    return "admin: "+super.toString();
}
}
