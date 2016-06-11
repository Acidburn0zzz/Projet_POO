/**
 * Created by MrMan on 30/05/2016.
 */
import iut.Game;
import iut.Objet;

public class Niveau {
    private Game game;
    private int tempsActuel;
    private int tempsVague;

    private int nbAsteroide;
    private int nbAlien1;
    private int nbAlien2;

    private int nxtAsteroide;
    private int nxtAlien1;
    private int nxtAlien2;

    Niveau(int numero, Game game){
        this.game = game;
        int coef = (int) (7*Math.sqrt(numero));
        tempsVague = (int) (2.8*coef)*1000;
        tempsActuel = 0;

        nbAsteroide = (int) (1.08 * coef);
        nbAlien1 = (int) (0.75*coef);
        nbAlien2 = (int) (0.6*coef);

        nxtAsteroide = tempsVague/nbAsteroide;
        nxtAlien1 = tempsVague/nbAlien1;
        nxtAlien2 = tempsVague/nbAlien2;
    }
    public Objet NouvelObjet(long time){
        tempsActuel += time;
        Objet objet = null;
        if(tempsActuel>=nxtAsteroide){  //à reproduire pour les autres ennemie.
            nxtAsteroide += tempsVague/nbAsteroide;
            objet = new GrandAsteroide(game, game.getWidth(),(int)(Math.random()*game.getHeight()));
        }
        return objet;
    }
}
