/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe:  08
 Projet: Laboratoire #2
 Étudiant(e)s: Kathleen Francis
               Jérémie Bergeron
               Julian Maldonado
 Professeur :
 Nom du fichier: BuncoStrategieTest.java
 Date créé: 2020-02-23
 Date dern. modif. 2020-02-23
 *******************************************************
 Historique des modifications
 *******************************************************
 2020-02-23 Version initiale (et1)
 2020-02-23 Ajout de la fonction (et2)
 *******************************************************/

package testsUnitaires;

import bunco.Bunco;
import bunco.DeBunco;
import bunco.JoueurBunco;
import framework.Collection.CollectionJoueur;
import framework.Collection.Iterateur;
import framework.Joueur;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class BuncoStrategieTest {

    private Bunco bunco;
    private JoueurBunco joueurBunco;
    private DeBunco de1;
    private DeBunco de2;
    private DeBunco de3;

    @Before
    public void faireAvant(){
        bunco = new Bunco();
        bunco.setNbJoueurs(5);
        bunco.initialiserJeu();

        joueurBunco = new JoueurBunco(0,3);
        bunco.setJoueurCourant(joueurBunco);

        Iterateur iterateur = bunco.getCollectionDe().creerIterateur();
        de1 = (DeBunco) iterateur.next();
        de2 = (DeBunco) iterateur.next();
        de3 = (DeBunco) iterateur.next();
    }

    @Test
    public void calculerScoreJoueurBuncoPasseMain() {
        bunco.setTourCourant(1);

        de1.setFaceCourante(1);
        de2.setFaceCourante(1);
        de3.setFaceCourante(1);

        bunco.getStrategie().calculerScoreTour(bunco);

        assertEquals(21, joueurBunco.getScore());
        assertTrue(bunco.getPasserMain());
    }

    @Test
    public void calculerScoreJoueurMemeFaceGarderMain() {
        bunco.setTourCourant(1);

        de1.setFaceCourante(4);
        de2.setFaceCourante(4);
        de3.setFaceCourante(4);

        bunco.getStrategie().calculerScoreTour(bunco);

        assertEquals(5, joueurBunco.getScore());
        assertFalse(bunco.getPasserMain());
    }

    @Test
    public void calculerScoreJoueurFaceCorrespondTourGardeMain() {
        bunco.setTourCourant(1);

        de1.setFaceCourante(1);
        de2.setFaceCourante(3);
        de3.setFaceCourante(4);

        bunco.getStrategie().calculerScoreTour(bunco);

        assertEquals(1, joueurBunco.getScore());
        assertFalse(bunco.getPasserMain());
    }

    @Test
    public void calculerScoreJoueurSi0PasseMain() {
        bunco.setTourCourant(1);

        de1.setFaceCourante(2);
        de2.setFaceCourante(3);
        de3.setFaceCourante(4);

        bunco.getStrategie().calculerScoreTour(bunco);

        assertEquals(0, joueurBunco.getScore());
        assertTrue(bunco.getPasserMain());
    }


    @Test
    public void classement() {
        // Get les joueurs
        Iterateur iterateurJoueur = bunco.getCollectionJoueur().creerIterateur();
        JoueurBunco joueur1 = (JoueurBunco) iterateurJoueur.next();
        JoueurBunco joueur2 = (JoueurBunco) iterateurJoueur.next();
        JoueurBunco joueur3 = (JoueurBunco) iterateurJoueur.next();
        JoueurBunco joueur4 = (JoueurBunco) iterateurJoueur.next();
        JoueurBunco joueur5 = (JoueurBunco) iterateurJoueur.next();

        // Set le nombres de tours gagnés + le score
        joueur1.setNbrToursGagnes(1);
        joueur1.setScore(5);
        joueur1.setScoreCumulatif(5);

        joueur2.setNbrToursGagnes(0);
        joueur2.setScore(8);
        joueur2.setScoreCumulatif(8);

        joueur3.setNbrToursGagnes(0);
        joueur3.setScore(0);
        joueur3.setScoreCumulatif(0);

        joueur4.setNbrToursGagnes(0);
        joueur4.setScore(1);
        joueur4.setScoreCumulatif(1);

        joueur5.setNbrToursGagnes(1);
        joueur5.setScore(8);
        joueur5.setScoreCumulatif(8);

        // On trie manuellement les joueurs
        LinkedList<JoueurBunco> listeJoueurBuncoGagnantTrierALaMain = new LinkedList<>();
        listeJoueurBuncoGagnantTrierALaMain.add(joueur5);
        listeJoueurBuncoGagnantTrierALaMain.add(joueur1);
        listeJoueurBuncoGagnantTrierALaMain.add(joueur2);
        listeJoueurBuncoGagnantTrierALaMain.add(joueur4);
        listeJoueurBuncoGagnantTrierALaMain.add(joueur3);

        // On récupère ce que la méthode calculerLeVainqueur calcule
        LinkedList<Joueur> listeJoueurGagnant = bunco.getStrategie().calculerLeVainqueur(bunco);
        LinkedList<JoueurBunco> listeJoueurBuncoGagnant = new LinkedList<>();
        listeJoueurGagnant.forEach(joueur -> {
            listeJoueurBuncoGagnant.add((JoueurBunco) joueur);
        });

        assertEquals(listeJoueurBuncoGagnantTrierALaMain, listeJoueurBuncoGagnant);
    }


}
