/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe:  08
 Projet: Laboratoire #2
 Étudiant(e)s: Kathleen Francis
               Jérémie Bergeron
               Julian Maldonado
 Professeur :
 Nom du fichier: JeuTest.java
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
import bunco.JoueurBunco;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuncoTest {

    private Bunco bunco;
    private JoueurBunco joueurBunco;

    @Before
    public void faireAvant(){
        bunco = new Bunco();
        bunco.initialiserJeu();

        joueurBunco = new JoueurBunco(5,3);
        bunco.setJoueurCourant(joueurBunco);

        bunco.setTourCourant(1);
    }

    @Test
    public void tourCourantTest() {
        assertEquals(joueurBunco, bunco.getJoueurCourant());
    }

    @Test(expected=IllegalArgumentException.class)
    public void tourCourantNullTest(){
        bunco.setTourCourant(0);
        bunco.getTourCourant();
    }

    @Test
    public void joueurCourantTest() {
        assertEquals(1, bunco.getTourCourant());
    }

    @Test(expected=IllegalArgumentException.class)
    public void joueurCourantNullTest(){
        bunco.setJoueurCourant(null);
        assertNull(bunco.getJoueurCourant());
    }

}
