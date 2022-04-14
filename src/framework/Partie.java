package framework;

import bunco.Bunco;
import framework.Fabrique.Fabrique;
import framework.Fabrique.FabriqueJeu;
import java.util.Scanner;

public class Partie {

    static Fabrique fabriqueJeu = new FabriqueJeu();

    public static void main(String[] args) {
        Bunco bunco = (Bunco) fabriqueJeu.instancier("bunco");

        //
        Scanner scanner = new Scanner(System.in);
        System.out.print("Écrivez le nombre de joueurs pour la partie : ");
        int nbJoueurs = Integer.parseInt(scanner.nextLine());
        bunco.setNbJoueurs(nbJoueurs);

        bunco.initialiserJeu();
        bunco.jouerPartie();
    }
}
