/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.infob3.pidev.entites;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class Compte 
{
private String typeCompte;
private Integer numCompte;
private List<Client> clients=new ArrayList<>();
private List<Responsable> responsables=new ArrayList<>();
public Compte(){}
public Compte(String typeCompte,Integer numCompte)
{
    this.numCompte=numCompte;
    this.typeCompte=typeCompte;
}
public String getType()
{
    return typeCompte;
}
public void setType(String typeCompte)
{
    this.typeCompte=typeCompte;
}
public Integer getNum()
{
    return numCompte;
}
public void setNum(Integer numCompte)
{
    this.numCompte=numCompte;
}

    public List<Client> getClients() {
        return clients;
    }

    public List<Responsable> getResponsables() {
        return responsables;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setResponsables(List<Responsable> responsables) {
        this.responsables = responsables;
    }

@Override
public String toString()
{
    return "type de compte: "+typeCompte+"\n numero de compte: "+numCompte;
}
}
