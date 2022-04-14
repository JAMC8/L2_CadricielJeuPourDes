package framework.Fabrique;

import bunco.Bunco;
import framework.Jeu;

public class FabriqueJeu implements Fabrique {

    @Override
    public Jeu instancier(String typeJeu) {
        if(typeJeu.equals("bunco")) {
            return new Bunco();
        } else {
            return null;
        }
    }

}