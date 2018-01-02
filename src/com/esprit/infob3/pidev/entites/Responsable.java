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
public class Responsable extends User
{
private Boutique boutique;
private int etat;
private String type;
private int nbrAchat;
  
public Responsable()
{
   
}

    

    public Responsable(String nom, String prenom, String mail, String login, String mdp) 
    {
        super(nom, prenom, mail, login, mdp);
    }
    public Responsable (int identifiant,String nom, String prenom, String mail, String login, String mdp,int etat) 
    {
        super(identifiant,nom, prenom, mail, login, mdp);
        this.etat =etat;
        
    }

    public Responsable(int identifiant, String nom, String prenom, String mail, String login, String mdp) 
    {
        super(identifiant,nom, prenom, mail, login, mdp);
 
    }
     public Responsable(int identifiant,String type, String nom, String prenom, String mail, String login, String mdp , int nbrAchat,int etat) 
    {
        super(identifiant,nom, prenom, mail, login, mdp);
         this.nbrAchat = nbrAchat;                   
        this.type = type;
        this.etat = etat;
    }
    
   




   

   

   

   

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    


@Override
public String toString()
{
    return "Responsable: "+super.toString();
}
}
