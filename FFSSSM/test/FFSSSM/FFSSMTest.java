/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSSM;
import ffsssm.Club;
import ffsssm.GroupeSanguin;
import ffsssm.Licence;
import ffsssm.Moniteur;
import ffsssm.Personne;
import ffsssm.Plongeur;
import ffsssm.Plongee;
import ffsssm.Site;
import ffsssm.Embauche;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vdelpy
 */
public class FFSSMTest {
    public Calendar ddn;
    public Calendar delivrance;
    public Calendar delivrancefausse;
    public Calendar dateval;
    public Licence licenceMomo;
    public Licence licenceInvalide;
    public Plongeur pv;
    public Plongeur pf;
    public Moniteur momo;
    public Club club;
    public Personne momoo;
    public Plongee plongee;
    public Site site;
    

    @Before
    public void setUp() {
        Calendar ddn = Calendar.getInstance();
        Calendar delivrance = Calendar.getInstance();
        Calendar delivrancefausse =  Calendar.getInstance();
        Calendar dateval = Calendar.getInstance();
        dateval.set(2019,01,01);
        delivrancefausse.set(2015,11,20);
        delivrance.set(2018,11,17);
        ddn.set(1988, 11,2);
        Personne momoo = new Personne("1","Momo","Robot","14 Avenue des Bouftous","06.07.08.09.10",ddn);
        Licence licenceMomo = new Licence(momoo,"1",delivrance,4);
        Licence licenceInvalide = new Licence(momoo,"2",delivrancefausse,2);
        Plongeur pv = new Plongeur("2","Curt","Bryan","20 Rue des Champs","04.05.07.06.08",ddn,4,licenceInvalide,GroupeSanguin.BMOINS);
        Plongeur pf = new Plongeur("3","Abdo","Alexandre","10 Rue de Montcuq","01.23.56.78.95",ddn,3,licenceMomo,GroupeSanguin.AMOINS);
        Moniteur momo = new Moniteur("1","Momo","Robot","14 Avenue des Bouftous","06.07.08.09.10",ddn,4,licenceMomo,GroupeSanguin.APLUS,1);
        Club club = new Club(momo,"Mon club","06.08.09.10.11");
        Site site = new Site("oui","test");
        Plongee plongee = new Plongee(site,momo,dateval,4,4);
        licenceMomo.setClub(club);
        this.ddn = ddn;
        this.delivrance = delivrance;
        this.delivrancefausse = delivrancefausse;
        this.momoo = momoo;
        this.licenceMomo = licenceMomo;
        this.licenceInvalide = licenceInvalide;
        this.pv = pv;
        this.pf = pf;
        this.momo = momo;
        this.club = club;
        this.dateval = dateval;
        this.site = site;
        this.plongee = plongee;
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testLicence(){
        assertEquals(true,licenceMomo.estValide(dateval));
        assertEquals(false,licenceInvalide.estValide(dateval));
    }
    
    @Test
    public void testEmbauche(){
        Embauche e = new Embauche(delivrance,momo,club);
        Embauche f = new Embauche(dateval,momo,club);
        Calendar date = Calendar.getInstance();
        date.set(2018,11,20);
        e.terminer(date);
        assertEquals(true,e.estTerminee());
        assertEquals(false,f.estTerminee());
    }
    
    @Test
    public void testMoniteur(){
        assertEquals(null,momo.employeur());
        Calendar date = Calendar.getInstance();
        date.set(2018,11,20);
        momo.nouvelleEmbauche(club, date);
        assertEquals(club,momo.employeur());
    }
    
    @Test
    public void testLicencesValides(){
        assertEquals(true,momo.licencesValides(dateval));
        assertEquals(false,pv.licencesValides(dateval));
    }
    
    @Test
    public void testPlongee(){
        plongee.ajouteParticipant(momo);
        assertEquals(1,plongee.lesPlongeurs.size());
        assertEquals(true,plongee.estConforme());
        plongee.ajouteParticipant(pv);
        assertEquals(false,plongee.estConforme());
    }
}

