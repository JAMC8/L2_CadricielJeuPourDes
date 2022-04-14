package bunco;

import framework.Collection.Iterateur;
import framework.De;
import framework.Jeu;
import framework.Joueur;

import java.util.LinkedList;

public class Bunco extends Jeu {

    private final int NB_TOUR_BUNCO = 6;
    private final int NB_DES_BUNCO = 3;
    private int nbJoueurs;

    /**
     * Méthode pour définir le nombre de joueurs
     */
    public void setNbJoueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
    }

    /**
     * Méthode pour définir la stratégie utilisée dans le jeu.
     */
    @Override
    public  void setStrategie() {
        strategie = new StrategieBunco();
    }

    /**
     * Méthode pour définir le nombre de tours
     */
    @Override
    public void setNbTour(){
        super.nbTour = NB_TOUR_BUNCO;
    }

    /**
     * Méthode pour créer les dés pour les joueurs.
     */
    @Override
    public void creerDe() {

        for (int i = 0; i<NB_DES_BUNCO; i++ ) {
            DeBunco de = (DeBunco) fabriqueDe.instancier("bunco");
            collectionDes.ajouterDe(de);
        }
    }

    /**
     * Méthode pour créer les joueurs de la partie.
     */
    @Override
    public void creerJoueur() {

        for (int i = 0; i<nbJoueurs; i++ ) {

            JoueurBunco joueur = (JoueurBunco) fabriqueJoueur.instancier("bunco");

            collectionJoueur.ajouterJoueur(joueur);
        }
    }

    /**
     * Méthode pour démarrer la partie de jeu Bunco.
     */
    @Override
    public void jouerPartie() {
        setTourCourant(1); // Définir le premier tour

        // Pendant que le nombre de tours n'a pas été complété
        while (getTourCourant() <= NB_TOUR_BUNCO) {

            Iterateur iterateurJoueur = collectionJoueur.creerIterateur();

            System.out.println("Tour : " + this.getTourCourant());

            // Les autres joueurs jouent
            // pendant qu'il y a un autre dans la collection
            while (iterateurJoueur.hasNext()) {
                setJoueurCourant((JoueurBunco) iterateurJoueur.next());
                // le joueur courant joue
                joueurJoue();
            }

            System.out.println();
            // Comparer les joueurs pour savoir qui a gagné le tour.
            comparerJoueurs();

            System.out.println();
            // Changer de tour
            prochainTour();
        }

        // Calculer le ou les vainqueurs
        LinkedList<Joueur> joueurGagnant = getStrategie().calculerLeVainqueur(this);

        System.out.println("============================");
        System.out.println("Fin de la partie");
        System.out.println("============================");
        System.out.println();
        System.out.println("Classement");
        joueurGagnant.forEach(joueur -> {
            System.out.println("Joueur " + joueur.getId() + " : " + ((JoueurBunco) joueur).getScoreCumulatif());
        });
    }

    /**
     * Méthode qui simule un joueur en train de jouer
     */
    private void joueurJoue() {
        // Message qui montre quel joueur joue.
        System.out.println("Le " + getJoueurCourant() + " lance les dés...");
        System.out.println("Il obtient");

        do {
            // Lancer les dés
            lancerDes();

            // Comparer les dés
            getStrategie().calculerScoreTour(this);


        } while (!getPasserMain());

        // Réinitialiser l'état de passerMain
        setPasserMain(false);
    }

    /**
     * Méthode pour lancer les dés.
     */
    private void lancerDes() {
        Iterateur iterateur = collectionDes.creerIterateur();

        // Lancer le de courant pendant qu'il en reste dans la collection
        while (iterateur.hasNext()) {
            De de = ((De) iterateur.next());

            de.lancerCeDe();
            // Message montrant la face du dé lancé
            System.out.println(de.getFaceCourante());
        }

        System.out.println();


    }

    /**
     * Méthode pour comparer les joueurs et définir qui a gagné le tour.
     */
    private void comparerJoueurs() {
        LinkedList<Joueur> joueursGagnants = new LinkedList<>();

        Iterateur iterateurJoueurs = collectionJoueur.creerIterateur();

        // Le joueur avec le score courant le plus haut
        Joueur joueurA = ((Joueur) iterateurJoueurs.next());

        // Compare le score du joueur courant au prochain
        while (iterateurJoueurs.hasNext()) {

            // Le prochain joueur à comparer
            Joueur joueurB = ((Joueur) iterateurJoueurs.next());

            // En cas d'égalité
            if (joueurA.compareTo(joueurB) == 0) {

                // On ajoute le joueurA
                if(!joueursGagnants.contains(joueurA)) {
                    joueursGagnants.add(joueurA);
                }
                // On ajoute le joueurB
                joueursGagnants.add(joueurB);

            // JoueurA a un nombre plus grand que JoueurB
            } else if (joueurA.compareTo(joueurB) == 1) {

                // On ajoute le joueurA
                if(!joueursGagnants.contains(joueurA)) {
                    joueursGagnants.add(joueurA);
                }
            // JoueurB a un nombre plus grand que JoueurA
            } else if (joueurA.compareTo(joueurB) == -1) {
                // Effacer tous les éléments de la liste
                joueursGagnants.clear();

                // On ajoute le joueurB
                joueursGagnants.add(joueurB);


                // Réassignation
                joueurA = joueurB;
            }
        }

        joueursGagnants.forEach(joueur -> {
            ((JoueurBunco) joueur).augmenterToursGagnes();
            System.out.println("Le joueur " + joueur.getId() +
                    " gagne le tour " + this.getTourCourant() +
                    " avec " + joueur.getScore() + " points.");
        });
    }

    /**
     * Méthode pour changer de tour et Réinitialiser le score de tous les joueurs à 0
     */
    private void prochainTour() {

        System.out.println("============================");
        System.out.println("Fin du tour");
        System.out.println("============================");
        System.out.println();

        Iterateur iterateurJoueurs = collectionJoueur.creerIterateur();

        // Réinitialiser le score de tous les joueurs
        while (iterateurJoueurs.hasNext()) {
            ((Joueur) iterateurJoueurs.next()).setScore(0);
        }

        // Changer au prochain tour
        setTourCourant(getTourCourant() + 1);

    }

}
