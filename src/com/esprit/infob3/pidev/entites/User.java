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
public class User 
{
 private int identifiant;
 private String nom;
 private String prenom;
 private String mail;
 private String login;
 private String mdp;
 private CarteBancaire carteBancaire;

    public User() {}

    public User(String nom, String mdp) {
        this.nom = nom;
        this.mdp = mdp;
    }

    public User(int identifiant, String nom, String prenom, String mail, String login, String mdp) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.login = login;
        this.mdp = mdp;
    }

    public User(String nom, String prenom, String mail, String login, String mdp) 
    {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.login = login;
        this.mdp = mdp;
    }

    public User(String nom, String prenom, String mail, String login, String mdp, CarteBancaire carteBancaire) 
    {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.login = login;
        this.mdp = mdp;
        this.carteBancaire = carteBancaire;
    }

    public int getIdentifiant() 
    {
        return identifiant;
    }

    public String getNom() 
    {
        return nom;
    }

    public String getPrenom() 
    {
        return prenom;
    }

    public String getMail() 
    {
        return mail;
    }

    public String getLogin() 
    {
        return login;
    }

    public String getMdp() 
    {
        return mdp;
    }

    public CarteBancaire getCarteBancaire() 
    {
        return carteBancaire;
    }

    public void setIdentifiant(int identifiant) 
    {
        this.identifiant = identifiant;
    }

    public void setNom(String nom) 
    {
        this.nom = nom;
    }

    public void setPrenom(String prenom) 
    {
        this.prenom = prenom;
    }

    public void setMail(String mail) 
    {
        this.mail = mail;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public void setMdp(String mdp) 
    {
        this.mdp = mdp;
    }

    public void setCarteBancaire(CarteBancaire carteBancaire) 
    {
        this.carteBancaire = carteBancaire;
    }

    @Override
    public String toString() 
    {
        return "nom: "+nom+"\n prenom: "+prenom+"\n adresse email: "+mail+"\n login: "+login+"\n mot de passe: "+mdp;
    }
}
