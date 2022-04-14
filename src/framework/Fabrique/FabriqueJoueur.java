package framework.Fabrique;

import framework.IdGenerator;
import framework.Joueur;
import bunco.JoueurBunco;

public class FabriqueJoueur implements Fabrique {

    private final int id = 0;
    private final int buncoNbrDe = 3;
    private final IdGenerator idGenerator = new IdGenerator();

    @Override
    public Joueur instancier(String typeJoueur) {
        if(typeJoueur.equals("bunco")) {
            return new JoueurBunco(idGenerator.generateId(), buncoNbrDe);
        }  else {
            return null;
        }
    }

}