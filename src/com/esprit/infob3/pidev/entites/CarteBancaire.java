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
public class CarteBancaire 
{
private long numero;
private int code;
private Float solde;
private Client client;

    public CarteBancaire() 
    {
        
    }

    public CarteBancaire(long numero, int code, Float solde, Client client) 
    {
        this.numero = numero;
        this.code = code;
        this.solde = solde;
        this.client = client;
    }

    public CarteBancaire(long numero, int code, Float solde) 
    {
        this.numero = numero;
        this.code = code;
        this.solde=solde;
    }

    public long getNumero() 
    {
        return numero;
    }

    public int getCode() 
    {
        return code;
    }

    public void setNumero(long numero) 
    {
        this.numero = numero;
    }

    public void setCode(int code) 
    {
        this.code = code;
    }

    public Float getSolde() 
    {
        return solde;
    }

    public void setSolde(Float solde) 
    {
        if(solde>=0)
        {
        this.solde = solde;
        }
    }

    public Client getClient() 
    {
        return client;
    }

    public void setClient(Client client) 
    {
        this.client = client;
    }

    @Override
    public String toString() 
    {
        return "numero de la carte bancaire: "+numero+"\n code de la carte bancaire: "+code;
    }
}
