/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ffsssm;

import java.util.Calendar;

public class Licence {

    public Personne possesseur;
    public String numero;
    public Calendar delivrance;
    public int niveau;
    public Club club;

    public Licence(Personne possesseur, String numero, Calendar delivrance, int niveau) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.niveau = niveau;
    }

    public Personne getPossesseur() {
        return possesseur;
    }
    
    public void setClub(Club c){
        this.club = c;
    }
    
    public String getNumero() {
        return numero;
    }

    public Calendar getDelivrance() {
        return delivrance;
    }

    public int getNiveau() {
        return niveau;
    }

    public Club getClub() {
        return club;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ?
     * @param d la date à tester
     * @return vrai si valide à la date d
     **/
    public boolean estValide(Calendar d) {
       // if(d.toString()==delivrance.toString()){
       //     return true;
       // }
       //else{
       //    return false;
       // }
       Calendar fin = (Calendar) delivrance.clone();
       fin.add(Calendar.YEAR,1);
       if((d.after(delivrance)==true)&&(d.before(fin))){
           return true;
       }
       else{
           return false;
       }
    }

}

