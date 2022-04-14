package framework;

import bunco.JoueurBunco;

public abstract class Joueur implements Comparable<Joueur> {

    private final int id;
    private int nbrDes;
    protected int score;

    /**
     * Constructeur du joueur.
     * @param id : int, l'id du joueur
     * @param nbrDes : int le nombre des dés du joueur
     */
    public Joueur(int id, int nbrDes) {
        this.id = id;
        this.nbrDes = nbrDes;

        // Score par défaut
        this.score = 0;

    }

    /**
     * Méthode pour récupérer l'id du joueur.
     * @return : l'id du joueur, int.
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode pour récupérer les nombre des dés.
     * @return : int, le nombre des dés.
     */
    public int getNbrDes() {
        return nbrDes;
    }

    /**
     * Méthode pour définir le nombre des dés.
     * @param nbrDes : le nombre des dés.
     */
    public void setNbrDes(int nbrDes) {
        this.nbrDes = nbrDes;
    }

    /**
     * Méthode pour récupérer le score actuel du joueur.
     * @return : le score actuel du joueur, int.
     */
    public int getScore() {
        return score;
    }

    /**
     * Méthode pour définir le score du joueur
     * @param score - Score du joueur
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Méthode pour augmenter le score du joueur.
     * @param score - la somme de score à additionner au score du joueur.
     */
    public void augmenterScore(int score) {
        this.score += score;
    }



    @Override
    public String toString() {
        return "Joueur " + id;
    }


    /**
     * Compare les scores de joueurs.
     * @param joueur : Le joueur à comparer.
     * @return : 0 si le score des deux joueurs est le même,
     *           1 si le score du joueur this est plus grand que celui du joueur passé en paramettres,
     *           0 dans tous les autres cas.
     */
    @Override
    public abstract int compareTo(Joueur joueur);

    public abstract boolean equals(JoueurBunco joueurBunco);
}
