package framework.Collection;

import framework.De;

import java.util.LinkedList;


public class CollectionDe implements ICollection {

    //private int compteur = 0;
    private final LinkedList<De> listeDes = new LinkedList<>();


    /**
     * Ajoute un joueur à la liste.
     *
     * @param de un nouveau dé
     */
    public void ajouterDe(De de) {
        listeDes.add(de);
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
        return new IterateurDe();
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
    private class IterateurDe implements Iterateur
    {
        int courant = 0;


        /**
         * Méthode pour récupérer le premier élément de la liste.
         * @return le premier élément de la liste.
         */
        @Override
        public Object first() {
            return listeDes.getFirst();
        }

        /**
         * Méthode pour récupérer le dernier élément de la liste.
         * @return le dernier élément de la liste.
         */
        @Override
        public Object last() {
            return listeDes.getLast();
        }

        /**
         * Méthode pour récupérer le prochain élément dans la liste.
         * @return le prochain élément dans la liste.
         */
        @Override
        public Object next() {
            if (hasNext()) {
                De de = listeDes.get(courant);
                courant++;
                return de;
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
            return (courant) < listeDes.size();
        }

    }
}

