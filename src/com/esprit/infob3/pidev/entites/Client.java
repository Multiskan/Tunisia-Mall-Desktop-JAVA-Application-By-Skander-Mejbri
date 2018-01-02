/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.entites;

import com.esprit.infob3.pidev.metier.ResponsableService;

/**
 *
 * @author ahmed
 */
public class Client extends User 
{
   public int etat ;
private Panier panier;
private  Integer nbrAchat;
private Carte carteFidelite;
private ResponsableService r;
private CarteBancaire carteBancaire;
public Client()
{
   
}

    public Client(Integer nbrAchat) {
        this.nbrAchat = nbrAchat;
    }

    public Client(String nom, String prenom, String mail, String login, String mdp) 
    {
        super(nom, prenom, mail, login, mdp);
    }
       public Client(String nom,String mdp,Integer nbrAchat) 
    {
         super(nom,mdp);
        this.nbrAchat = nbrAchat;
    }
    public Client (int identifiant,String nom, String prenom, String mail, String login, String mdp,int etat) 
    {
        super(identifiant,nom, prenom, mail, login, mdp);
        this.etat =etat;
        
    }

    public Client(int identifiant, String nom, String prenom, String mail, String login, String mdp) 
    {
        super(identifiant,nom, prenom, mail, login, mdp);
 
    }
    
   
public Client(String nom, String prenom, String mail, String login, String mdp,Integer nbrAchat) 
    {
        super(nom, prenom, mail, login, mdp);
        this.nbrAchat=nbrAchat;
    }
public Integer getNbrAchat()
{
    return nbrAchat;
}


    public Panier getPanier() 
    {
        return panier;
    }

    public void setPanier(Panier panier) 
    {
        this.panier = panier;
    }

    public Carte getCarteFidelite() 
    {
        return carteFidelite;
    }

   /* public void setCarteFidelite(Carte carteFidelite) 
    {
        if(r.creerCarte(this)==true)
        this.carteFidelite = carteFidelite;
    }*/

@Override
    public CarteBancaire getCarteBancaire() 
    {
        return carteBancaire;
    }

    /**
     *
     * @param carteBancaire
     */
    @Override
    public void setCarteBancaire(CarteBancaire carteBancaire) 
    {
        this.carteBancaire = carteBancaire;
    }

    public void setNbrAchat(Integer nbrAchat) {
        this.nbrAchat = nbrAchat;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Client( int identifiant, String nom, String prenom, String mail, String login, String mdp,int nbrAchat,int etat) 
    {
        super(identifiant, nom, prenom, mail, login, mdp);
        this.etat = etat;
        this.nbrAchat=nbrAchat;
    }


@Override
public String toString()
{
    return "client: "+super.toString();
}
}
