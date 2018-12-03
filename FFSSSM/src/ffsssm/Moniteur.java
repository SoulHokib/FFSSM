/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ffsssm;

import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    private LinkedList<Embauche> lesEmployeurs = new LinkedList<>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int niveau, Licence l, GroupeSanguin gs, int numeroDiplome){
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau, l, gs);
        this.numeroDiplome = numeroDiplome;
    }


    public Club employeur() {
        int res = -1;
        for (int i =0;i<lesEmployeurs.size();i++){
            if(!lesEmployeurs.get(i).estTerminee()){
                res = i;
            }
        }
        if(res<0){
            return null;
        }
        else{
            return lesEmployeurs.get(res).getEmployeur();
        }
    }
    
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {  
        lesEmployeurs.add(new Embauche(debutNouvelle,this,employeur));
    }

    public List<Embauche> emplois() {
        return lesEmployeurs;
    }

}
