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
public class Boutique 
{
private String nom;
private String adresse;
private Produit produit;
public Boutique(){}

    public Boutique(String nom) {
        this.nom = nom;
    }

    public Boutique(String nom, String adresse,Produit produit) {
        this.nom = nom;
        this.adresse = adresse;
        this.produit=produit ;
        
    }

public Boutique(String nom,String adresse)
{
    this.adresse=adresse;
    this.nom=nom;
}
public String getNom()
    {
        return nom;
    }
    public void setNom(String nom)
    {
        this.nom=nom;
    }
    public String getAdresse()
    {
        return adresse;
    }
    public void setAdresse(String adresse)
    {
        this.adresse=adresse;
    }

    public Produit getProduit() 
    {
        return produit;
    }

    public void setProduit(Produit produit) 
    {
        this.produit = produit;
    }
    
    @Override
    public String toString()
    {
        return "nom de la boutique: "+nom+"\n l'adresse de la boutique"+adresse;
    }
}
