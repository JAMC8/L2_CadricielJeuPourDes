
/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe:  08
 Projet: Laboratoire #2
 Étudiant(e)s: Kathleen Francis
               Jérémie Bergeron
               Julian Maldonado
 Professeur :
 Nom du fichier: JoueurTest.java
 Date créé: 2020-02-23
 Date dern. modif. 2020-02-23
 *******************************************************
 Historique des modifications
 *******************************************************
 2020-02-23 Version initiale (et1)
 2020-02-23 Ajout de la fonction (et2)
 *******************************************************/

package testsUnitaires;

import bunco.JoueurBunco;
import framework.Joueur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class JoueurBuncoTest {

    private JoueurBunco joueur1;
    private JoueurBunco joueur2;

    @Before
    public void faireAvant(){
        joueur1 = new JoueurBunco(1, 3);
        joueur2 = new JoueurBunco(2, 3);
    }

    @Test
    public void joueurScoreSuperieurTest(){
        joueur1.setScore(5);
        joueur2.setScore(25);
        assertEquals(1, joueur2.compareTo(joueur1));
    }

    @Test
    public void joueurScoreInferieurTest(){
        joueur1.setScore(3);
        joueur2.setScore(0);
        assertEquals(-1, joueur2.compareTo(joueur1));
    }

    @Test
    public void joueurMemeScoreTest(){
        joueur1.setScore(2);
        joueur2.setScore(2);
        assertEquals(0, joueur2.compareTo(joueur1));
    }

    @Test(expected=IllegalArgumentException.class)
    public void joueurNullTest(){
        joueur1.compareTo(null);
    }

}
