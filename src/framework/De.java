package framework;

public abstract class De implements Comparable<De>{

    private int nbrFace;
    private int faceCourante;

    public De(int nbrFace) {
        this.nbrFace = nbrFace;
    }

    public int getFaceCourante() {
        return faceCourante;
    }

    public void setFaceCourante(int faceCourante) {
        this.faceCourante = faceCourante;
    }

    public int getNbrFace (){
        return this.nbrFace;
    }

    /**
     * Compare les dés selon leur faceCourante
     * @param de : le dé avec lequel on va comparer this.
     * @return : 0 si leur faceCourante est la même pour les deux dés
     *          1 Si le numéro de face courant du dé this est plus grand
     *          -1 Si le numéro de face courant du dé passé en paramettres est plus grand
     */
    @Override
    public int compareTo(De de) throws IllegalArgumentException {

        if(de == null) {
            throw new IllegalArgumentException("De can't be null but De is null.");
        }

        if (this.faceCourante == de.faceCourante) {
            return 0;
        } else if (this.faceCourante > de.faceCourante) {
            return 1;
        } else {
            return -1;
        }

    }

    /**
     * Lancer ce dé entre 1 et le nombre de faces.
     * On fait getNbrFace()+1 car le max est non compris.
     * Cette méthode definit la face courrant.
     */
    public void lancerCeDe () {
        setFaceCourante(getEntierAleatoire(1,getNbrFace()+1));
    }

    /**
     * Méthode pour calculer un nombre aléatoire entre un min et un max.
     * @param min : le minmum compris.
     * @param max : le maximum non-compris.
     * @return : int le nombre aléatoire
     */
    private int getEntierAleatoire(int min, int max){
        return ((int) (Math.random()*(max - min))) + min;
    }
}
