package framework;

import java.util.LinkedList;

public interface IStrategie {

    /**
     *  Trie les joueurs en ordre décroissant selon la méthode du score du jeu
     * @param jeu
     */
    LinkedList<Joueur> calculerLeVainqueur(Jeu jeu);

    /**
     *
     * @param jeu
     */
    void calculerScoreTour(Jeu jeu);


}
