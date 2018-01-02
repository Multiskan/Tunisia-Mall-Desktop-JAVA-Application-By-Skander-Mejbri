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
public class Panier 
{
private String nom;
private int  idclient;
private int  idproduit;
public Panier(){}
public Panier(String nom)
{
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

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

   
    
    @Override
    public String toString()
    {
        return "nom de la panier: "+nom;
    }
}
