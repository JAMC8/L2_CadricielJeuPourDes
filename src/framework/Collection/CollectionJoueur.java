package framework.Collection;

import framework.Joueur;

import java.util.LinkedList;


public class CollectionJoueur implements ICollection {

    //private int compteur = 0;
    private final LinkedList<Joueur> listeJoueurs = new LinkedList<>();


    /**
     * Ajoute un joueur à la liste.
     *
     * @param joueur : le nouveau joueur
     */
    public void ajouterJoueur(Joueur joueur) {
        listeJoueurs.add(joueur);
    }


    /**
     * Retourne un Iterateur pour cette collection
     *
     * Cette méthode est nécessaire à l'implémentation du patron Iterator.
     * Elle instancie un nouvel Iterateur et retourne l'instance à la méthode
     * appelante. Il est important d'instancier un nouvel Iterateur. Cela permet,
     * entre autres, de pourvoir utiliser plusieurs iterateurs en même temps.
     *
     * @return un Iterateur pour cette collection
     */
    public Iterateur creerIterateur() {
        return new IterateurJoueur();
    }

    /**
     * Classe MaCollectionIterateur
     *
     * La plupart des implémentations du patron Iterator déclare l'itérateur comme
     * une classe interne et privée de la collection, comme démontré dans ce cas-ci.
     * Bien que cette approche n'est pas une condition nécessaire pour l'implémentation
     * du patron, elle comporte plusieurs avantages: une bonne encapsulation, et la
     * classe MaCollectionIterateur a accès aux membres de la classe MaCollection.
     */
    private class IterateurJoueur implements Iterateur
    {
        int courant = 0;

        /**
         * Méthode pour récupérer le premier élément de la liste.
         * @return le premier élément de la liste.
         */
        @Override
        public Object first() {
            return listeJoueurs.getFirst();
        }

        /**
         * Méthode pour récupérer le dernier élément de la liste.
         * @return le dernier élément de la liste.
         */
        @Override
        public Object last() {
            return listeJoueurs.getLast();
        }

        /**
         * Méthode pour récupérer le prochain élément dans la liste.
         * @return le prochain élément dans la liste.
         */
        @Override
        public Object next() {
            if (hasNext()) {
                Joueur joueur = listeJoueurs.get(courant);
                courant++;
                return joueur;
            } else {
                return null;
            }
        }

        /**
         * Méthode pour vérifier s'il y a un autre élément dans la liste après l'élément courant.
         * @return vrai s'il y a un autre élément après l'élément courant, faux si contraire.
         */
        @Override
        public boolean hasNext() {
            return (courant) < listeJoueurs.size();
        }
    }
}

