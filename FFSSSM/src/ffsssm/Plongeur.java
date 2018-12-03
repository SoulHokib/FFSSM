/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ffsssm;

import java.util.Calendar;
import java.util.HashSet;

public class Plongeur extends Personne {
    private int niveau;
    private HashSet<Licence> lesLicences = new HashSet<>();
    private GroupeSanguin gs;
    
    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int niveau, Licence l, GroupeSanguin gs) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        lesLicences.add(l);
        this.gs = gs;
    }
    
    public Plongeur(Personne p, int niveau, Licence l, GroupeSanguin gs){
        super(p.getNumeroINSEE(),p.getNom(),p.getPrenom(),p.getAdresse(),p.getTelephone(),p.getNaissance());
        this.niveau = niveau;
        lesLicences.add(l);
        this.gs = gs;
    }
    
    public void ajouterLicence(Licence l){
        lesLicences.add(l);
    }
    
    public HashSet<Licence> getLicences(){
        return this.lesLicences;
    }
    
    public void setGS(GroupeSanguin gs){
        this.gs = gs;
    }
    
    public GroupeSanguin getGS(){
        return this.gs;
    }
    
    public void setNiveau(int nv){
        this.niveau = nv;
    }
    
    public int getNiveau(){
        return this.niveau;
    }
    
    public boolean licencesValides(Calendar d){
        boolean valid = false;
        for(Licence l : lesLicences){
            if(l.estValide(d)){
                valid = true;
            }
        }
        return valid;
    }
}

