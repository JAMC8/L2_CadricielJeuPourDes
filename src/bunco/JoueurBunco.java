package bunco;

import framework.Joueur;

public class JoueurBunco extends Joueur {

    private int scoreCumulatif; // (Bunco)
    private int nbrToursGagnes; // (Bunco)

    public JoueurBunco(int id, int nbrDes) {
        super(id, nbrDes);

        // Tours gagnés par défaut
        this.nbrToursGagnes = 0;
    }

    /**
     * Méthode pour définir le score cumulatif.
     * @param scoreCumulatif : le score cumulatif, int. (Bunco)
     */
    public void setScoreCumulatif(int scoreCumulatif) {
        this.scoreCumulatif = scoreCumulatif;
    }

    /**
     * Méthode pour récupérer le score cumulatif de tous les tours.
     * @return : le score cumulatif. (Bunco)
     */
    public int getScoreCumulatif() {
        return scoreCumulatif;
    }

    /**
     * Méthode pour augmenter le score cumulatif des tours, soit la somme des scores de tous les tours.
     * @param cumulatif : la somme cumulative à additionner au score du joueur. (Bunco)
     */
    public void augmenterScoreCumulatif(int cumulatif){
        this.scoreCumulatif += cumulatif;
    }

    /**
     * Méthode pour récupérer le nombre de tours gagnés.
     * @return : le nombre de tours gagnés. (Bunco)
     */
    public int getNbrToursGagnes() {
        return nbrToursGagnes;
    }

    /**
     * Méthode pour définir le nombre de tours gagnés.
     * @param nbrToursGagnes : le nombre de tours gagnés. (Bunco)
     */
    public void setNbrToursGagnes(int nbrToursGagnes) {
        this.nbrToursGagnes = nbrToursGagnes;
    }

    /**
     * Méthode pour augmenter le nombre de tours gagnés par le joueur. (Bunco)
     */
    public void augmenterToursGagnes() {
        this.nbrToursGagnes++;
    }

    /**
     * Compare les scores de joueurs.
     * @param joueur : Le joueur à comparer.
     * @return : 0 si le score des deux joueurs est le même,
     *           1 si le score du joueur this est plus grand que celui du joueur passé en paramettres,
     *           0 dans tous les autres cas.
     */
    @Override
    public int compareTo(Joueur joueur) throws IllegalArgumentException {

        if(joueur == null) {
            throw new IllegalArgumentException("Joueur ne peut être égal à null.");
        }

        if (super.score == joueur.getScore()) {
            return 0;
        } else if (this.score > joueur.getScore()) {
            return 1;
        } else {
            return -1;
        }
    }


    /**
     * Compare le nombre de tours gagnés entre les joueurs.
     * @param joueur : le joueur à comparer.
     * @return 0 si les tours gagnés des deux joueurs est le même,
     *         1 si le nbr de tours gagnés du joueur this est plus grand que celui du joueur passé en paramettres,
     *         0 dans tous les autres cas.
     */
    public int comparerTours(JoueurBunco joueur) throws IllegalArgumentException {

        if(joueur == null) {
            throw new IllegalArgumentException("Joueur ne peut être égal à null.");
        }

        if (this.nbrToursGagnes == joueur.nbrToursGagnes) {
            return 0;
        } else if (this.nbrToursGagnes > joueur.nbrToursGagnes) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Compare les scores cumulatifs entre les joueurs.
     * @param joueur : le joueur à comparer.
     * @return 0 si le score des deux joueurs est le même,
     *         1 si le score du joueur this est plus grand que celui du joueur passé en paramettres,
     *         0 dans tous les autres cas.
     */
    public int comparerScoreCumulatif(JoueurBunco joueur) throws IllegalArgumentException {

        if(joueur == null) {
            throw new IllegalArgumentException("Joueur ne peut être égal à null.");
        }

        if (this.scoreCumulatif == joueur.scoreCumulatif) {
            return 0;
        } else if (this.scoreCumulatif > joueur.scoreCumulatif) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(JoueurBunco joueurBunco) {

        if (joueurBunco == null) {
            return false;
        } else {
            if (this.getId() == joueurBunco.getId() &&
            this.getScore() == joueurBunco.getScore() &&
            this.getScoreCumulatif() == joueurBunco.getScoreCumulatif() &&
            this.getNbrToursGagnes() == joueurBunco.getNbrToursGagnes()) {
                return true;
            }
        }

        return false;

    }
}
