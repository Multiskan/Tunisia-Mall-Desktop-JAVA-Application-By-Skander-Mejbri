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
public class Produit 
{
    private int idproduit ;
    private String libelle ;
    private String marque ;
    private Float prix ;
    private String nom_magasin;

    public Produit() {}

    public Produit(String libelle) {
        this.libelle = libelle;
    }

    public Produit(int idproduit, String libelle, String marque, Float prix, String nom_magasin) {
        this.idproduit = idproduit;
        this.libelle = libelle;
        this.marque = marque;
        this.prix = prix;
        this.nom_magasin = nom_magasin;
    }

    public Produit(int idproduit, String libelle) {
        this.idproduit = idproduit;
        this.libelle = libelle;
    }

    public Produit(int idproduit, String libelle, String marque, float prix) 
    {
        this.idproduit = idproduit;
        this.libelle = libelle;
        this.marque = marque;
        this.prix = prix;
    }

    public int getIdproduit() 
    {
        return idproduit;
    }

    public String getLibelle() 
    {
        return libelle;
    }

    public String getMarque() 
    {
        return marque;
    }

    public float getPrix() 
    {
        return prix;
    }

    public void setIdproduit(int idproduit) 
    {
        this.idproduit = idproduit;
    }

    public void setLibelle(String libelle) 
    {
        this.libelle = libelle;
    }

    public void setMarque(String marque) 
    {
        this.marque = marque;
    }

    public void setPrix(Float prix) 
    {
        if(prix>=0)
        this.prix = prix;
    }

    @Override
    public String toString() 
    {
        return "Produit{" + "idproduit=" + idproduit + ", libelle=" + libelle + ", marque=" + marque + ", prix=" + prix + '}';
    }
}
