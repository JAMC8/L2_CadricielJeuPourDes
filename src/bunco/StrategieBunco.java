package bunco;

import framework.Collection.Iterateur;
import framework.De;
import framework.IStrategie;
import framework.Jeu;
import framework.Joueur;

import java.util.LinkedList;

public class StrategieBunco implements IStrategie {

    /**
     * Méthode pour calculer le vainqueur à la fin de la partie.
     * On compare les tours. Celui qui a gagné le plus de tours gagne.
     * Si deux joueurs ont gagné le même nombre de tours on compare les scores cumulatifs.
     * Si les scores sont les mêmes on a une vraie égalité.

     *
     * @param jeu : instance de la classe jeu, la partie de jeu.
     * @return
     */
    @Override
    public LinkedList<Joueur> calculerLeVainqueur(Jeu jeu) {
        Iterateur iterateurJoueurs = jeu.getCollectionJoueur().creerIterateur();
        LinkedList<Joueur> joueurs = new LinkedList<>();

        // On ajoutes les joueurs du jeu à une liste local
        while (iterateurJoueurs.hasNext()) {

            joueurs.add((JoueurBunco) iterateurJoueurs.next());

        }

        // Algorithme de trie par sélection basé sur https://waytolearnx.com/2018/11/tri-par-selection-en-java.html
        for (int i = 0; i < joueurs.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < joueurs.size(); j++) {
                int comparerTour = ((JoueurBunco) joueurs.get(j)).comparerTours(((JoueurBunco)joueurs.get(index)));
                if (comparerTour == 1) {
                    index = j;
                } else if (comparerTour == 0) {
                    int compareScoreCumulatif = ((JoueurBunco) joueurs.get(j)).comparerScoreCumulatif(((JoueurBunco)joueurs.get(index)));
                    if (compareScoreCumulatif == 1) {
                        index = j;
                    }
                }
            }

            JoueurBunco max = ((JoueurBunco)joueurs.get(index));
            joueurs.set(index, joueurs.get(i));
            joueurs.set(i, max);

        }

        return joueurs;

    }

    /**
     * Méthode pour calculer le score des joueurs à chaque tour.
     * Cette méthode compare les dés et le tour courant.
     * @param jeu : instance de la classe jeu, la partie de jeu.
     */
    @Override
    public void calculerScoreTour(Jeu jeu) {

        Iterateur iterateur = jeu.getCollectionDe().creerIterateur();

        int points = 0;

        De de1 = (De) iterateur.next();
        De de2 = (De) iterateur.next();
        De de3 = (De) iterateur.next();

        boolean de1EgalDe2 = false;
        boolean de2EgalDe3 = false;

        // Vérifier si la face du dé 1 est égale à la face du dé 2
        if (de1.compareTo(de2) == 0) {
            de1EgalDe2 = true;

            // Vérifier si la face du dé 2 est égale à la face du dé 3
            // Ce if est dans le if précédent, car il est inutile de comparer le de2 avec le de3, si le de1 n'est pas égal au de2
            if (de2.compareTo(de3) == 0) {

                de2EgalDe3 = true;
            }
        }


        // Vérifier si tous les dés sont égaux
        if (de1EgalDe2 && de2EgalDe3) {
            if (de1.getFaceCourante() == jeu.getTourCourant()) {
                // Bunco pour joueur courant
                points = 21;

                // Message pour jeu
                System.out.println();
                System.out.println("========================");
                System.out.println("BUNCO!!!");
                System.out.println("========================");

            } else {
                // 5 points pour joueur courant
                points = 5;
            }

            // 1 point pour chaque face de dé égale au tour courant
        } else {

            if(de1.getFaceCourante() == jeu.getTourCourant()) {
                points++;
            }

            if(de2.getFaceCourante() == jeu.getTourCourant()) {
                points++;
            }

            if(de3.getFaceCourante() == jeu.getTourCourant()) {
                points++;
            }

        }
        // Augmenter le score du joueur courant
        jeu.getJoueurCourant().augmenterScore(points);
        ((JoueurBunco) jeu.getJoueurCourant()).augmenterScoreCumulatif(points);

        if(points != 21) {

            System.out.println("Le " + jeu.getJoueurCourant() + " a obtenu " + points + " point(s).");
        }

        if (points == 0 || points == 21) {
            jeu.setPasserMain(true);

            // Message pour le jeu
            System.out.println();
            System.out.println("Au total, le " + jeu.getJoueurCourant() + " a obtenu " + jeu.getJoueurCourant().getScore() + " point(s).");
            System.out.println();
            System.out.println("Le " + jeu.getJoueurCourant() + " passe la main au prochain joueur.");
            System.out.println();
        } else {

            System.out.println();
            System.out.println("Le " + jeu.getJoueurCourant() + " lance encore...");
        }

    }

}
