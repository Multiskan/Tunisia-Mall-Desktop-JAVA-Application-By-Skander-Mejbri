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
public class Pack 
{
private Float prix;
private catalogue catalogue;
private Responsable responsable;
    public Pack() {}

    public Pack(catalogue catalogue, Responsable responsable) 
    {
        this.catalogue = catalogue;
        this.responsable = responsable;
    }

    public catalogue getCatalogue() 
    {
        return catalogue;
    }

    public Responsable getResponsable() 
    {
        return responsable;
    }

    public void setCatalogue(catalogue catalogue) 
    {
        this.catalogue = catalogue;
    }

    public void setResponsable(Responsable responsable) 
    {
        this.responsable = responsable;
    }
    

    public Pack(Float prix) 
    {
        this.prix = prix;
    }

    public Float getPrix() 
    {
        return prix;
    }

    public void setPrix(Float prix) 
    {
        this.prix = prix;
    }

    @Override
    public String toString() 
    {
        return  "prix=" + prix ;
    }
}
