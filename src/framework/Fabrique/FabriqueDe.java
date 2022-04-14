package framework.Fabrique;

import framework.De;
import bunco.DeBunco;

public class FabriqueDe implements Fabrique {

    private final int buncoNbrFace = 6;

    @Override
    public De instancier(String typeDe) {
        if(typeDe.equals("bunco")) {
            return new DeBunco(buncoNbrFace);
        } else  {
            return null;
        }
    }




}
