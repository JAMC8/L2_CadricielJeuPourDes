/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe:  08
 Projet: Laboratoire #2
 Étudiant(e)s: Kathleen Francis
               Jérémie Bergeron
               Julian Maldonado
 Professeur :
 Nom du fichier: DeTest.java
 Date créé: 2020-02-23
 Date dern. modif. 2020-02-23
 *******************************************************
 Historique des modifications
 *******************************************************
 2020-02-23 Version initiale (et1)
 2020-02-23 Ajout de la fonction (et2)
 *******************************************************/

package testsUnitaires;

import bunco.DeBunco;
import framework.De;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeBuncoTest {

    private DeBunco de1;
    private DeBunco de2;

    @Before
    public void faireAvant(){
        de1 = new DeBunco(6);
        de2 = new DeBunco(6);
    }

    @Test
    public void deSuperieurTest(){
        de1.setFaceCourante(4);
        de2.setFaceCourante(5);
        assertEquals(1, de2.compareTo(de1));
    }

    @Test
    public void deInferieurTest(){
        de1.setFaceCourante(4);
        de2.setFaceCourante(5);
        assertEquals(-1, de1.compareTo(de2));
    }

    @Test
    public void memeDeTest(){
        de1.setFaceCourante(6);
        de2.setFaceCourante(6);
        assertEquals(0, de1.compareTo(de2));
    }

    @Test(expected=IllegalArgumentException.class)
    public void deNullTest(){
        de1.setFaceCourante(4);
        de1.compareTo(null);
    }
}
