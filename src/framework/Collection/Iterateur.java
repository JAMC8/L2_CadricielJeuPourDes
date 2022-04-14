package framework.Collection;

public interface Iterateur {

    /**
     * Méthode pour récupérer le premier élément.
     * @return : le premier élément
     */
    Object first();

    /**
     * Méthode pour récupérer le dernier élément.
     * @return : le dernier élément
     */
    Object last();

    /**
     * Méthode pour récupérer le prochain élément.
     * @return : le prochain élément
     */
    Object next();

    /**
     * Méthode pour savoir si la liste possède un élément après l'élément courant.
     * @return : l'élément
     */
    boolean hasNext();
}
