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

 public class catalogue {
    private int idcatalogue;
    private String nom ; 
     private String type;
     private int idproduit;
     
     
    public catalogue() {
    }
    
    public catalogue(String nom) {
        this.nom = nom;
    }
    
     public catalogue(String nom, String type) {
        this.nom = nom;
        this.type = type;
    }
    
    public catalogue(String nom, String type, int idproduit) {
        this.nom = nom;
        this.type = type;
        this.idproduit = idproduit;
    }

    public catalogue(int idcatalogue, String nom, String type, int idproduit) {
        this.idcatalogue = idcatalogue;
        this.nom = nom;
        this.type = type;
        this.idproduit = idproduit;
    }

    public int getIdcatalogue() {
        return idcatalogue;
    }

    public void setIdcatalogue(int idcatalogue) {
        this.idcatalogue = idcatalogue;
    }  

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    @Override
    public String toString() {
        return "catalogue{" + "idcatalogue=" + idcatalogue + ", nom=" + nom + ", type=" + type + ", idproduit=" + idproduit + '}';
    }
  }
    



