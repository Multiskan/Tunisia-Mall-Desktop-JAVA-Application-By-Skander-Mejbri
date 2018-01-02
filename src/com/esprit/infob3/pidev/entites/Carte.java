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
public class Carte 
{
    private String nom;
    private Integer reference;
    private Integer ptFidelite;
    private Client client;
    private int identifiant;
    public Carte(){}

    public Carte(int identifiant,String nom,Integer reference,Integer ptFidelite) 
    {
        this.nom = nom;
        this.reference = reference;
        this.ptFidelite = ptFidelite;
        this.identifiant = identifiant;
    }

    public Carte(String nom, Integer reference, Client client, int identifiant) 
    {
        this.nom = nom;
        this.reference = reference;
        this.client = client;
        this.identifiant = identifiant;
    }
    
    public Carte(Client client,String nom,Integer reference,Integer ptFfidelite)
    {
        this.nom=nom;
        this.reference=reference;
        this.client=client;
        this.ptFidelite=ptFfidelite;
    }
    public String getNom()
    {
        return nom;
    }
    public void setNom(String nom)
    {
        this.nom=nom;
    }
    public Integer getReference()
    {
        return reference;
    }
    public void setReference(Integer reference)
    {
        this.reference=reference;
    }

    public Client getClient() 
    {
        return client;
    }

    public void setClient(Client client) 
    {
        this.client = client;
    }

    public Integer getPtFidelite() 
    {
        return ptFidelite;
    }

    public void setPtFidelite(Integer ptFidelite) 
    {
        if(ptFidelite>=0)
        {
        this.ptFidelite = ptFidelite;
        }
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public int getIdentifiant() {
        return identifiant;
    }

   
    
    @Override
    public String toString()
    {
        return "nom de la carte de fidélité: "+nom+"\n la référence de la carte de fédilité: "+reference;
    }
}
