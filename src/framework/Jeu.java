package framework;

import bunco.StrategieBunco;
import framework.Collection.CollectionDe;
import framework.Collection.CollectionJoueur;
import framework.Fabrique.Fabrique;
import framework.Fabrique.FabriqueDe;
import framework.Fabrique.FabriqueJoueur;

public abstract class Jeu{

    protected int nbTour;
    protected int tourCourant;
    protected IStrategie strategie;

    protected Fabrique fabriqueJoueur = new FabriqueJoueur();
    protected Fabrique fabriqueDe = new FabriqueDe();

    protected final CollectionJoueur collectionJoueur = new CollectionJoueur();
    protected final CollectionDe collectionDes = new CollectionDe();

    protected Joueur joueurCourant;

    protected boolean passerMain = false;

    /**
     * Méthode pour initialiser le jeu.
     */
    public final void initialiserJeu(){
        creerDe();
        creerJoueur();
        setNbTour();
        setStrategie();
    }

    /**
     * Méthode pour récupérer le tour courant.
     * @return le tour courant.
     */
    public int getTourCourant() {
        return this.tourCourant;
    }

    /**
     * Méthode pour définir le tour courant
     * @param tour : le tour courant.
     */
    public void setTourCourant(int tour) throws IllegalArgumentException {

        if(tour < 1) {
            throw new IllegalArgumentException("Le numéro du tour courant peut pas être inférieur à 1.");
        } else {
            this.tourCourant = tour;
        }

    }

    /**
     * Méthode pour récupérer la collection des dés.
     * @return : la collection des dés
     */
    public CollectionDe getCollectionDe() {
        return this.collectionDes;
    }

    /**
     * Méthode pour récupérer la collection de joueurs.
     * @return : la collection de joueurs.
     */
    public CollectionJoueur getCollectionJoueur() {
        return collectionJoueur;
    }

    /**
     * Méthode pour récupérer le joueur courant.
     * @return : le joueur courant.
     */
    public Joueur getJoueurCourant() {
        return this.joueurCourant;
    }

    /**
     * Méthode pour récupérer le joueur courant.
     * @param joueur: le joueur courant.
     */
    public void setJoueurCourant(Joueur joueur) throws IllegalArgumentException {
        if(joueur == null){
            throw new IllegalArgumentException("Joueur ne peut pas être null.");
        } else {
            this.joueurCourant = joueur;
        }
    }

    /**
     * Méthode pour récupérer l'état de passerMain pour savoir si le joueur doit passer la main.
     * @return : l'état de la variable passerMain.
     */
    public boolean getPasserMain() {
        return this.passerMain;
    }

    /**
     * Méthode pour définir l'état de la variable passerMain.
     * @param etat : l'état pour la variable, vrai ou faux.
     */
    public void setPasserMain(boolean etat) {
        this.passerMain = etat;
    }


    /**
     * Méthode pour récupérer la stratégie utilisée dans le jeu.
     * @return :
     */
    public IStrategie getStrategie() {
        return strategie;
    }

    /**
     * Méthode pour définir la stratégie utilisée dans le jeu.
     */
    public abstract void setStrategie();


    public abstract void creerDe();
    public abstract void creerJoueur();
    public abstract void setNbTour();
    public abstract void jouerPartie();
}