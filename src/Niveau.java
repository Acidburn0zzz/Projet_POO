/**
 * Created by MrMan on 30/05/2016.
 */
import iut.Game;
import iut.Objet;

public class Niveau {
    private int tempsActuel;
    private int nbAsteroide;
    private int nbAlien1;
    private int nbAlien2;
    private int niveau;
    private int dureeNiveau;
    private int coefDifficulte;
    private int nbAsteroideTotal;

    private Game g;

    Niveau(int numero, Game game){
        niveau = numero;
        dureeNiveau = 8000;
        coefDifficulte = 2;
        g = game;
        nbAsteroideTotal = 4;
    }
    public Objet NouvelObjet(long time){
        tempsActuel += time;
        if(tempsActuel < dureeNiveau){
            if((dureeNiveau/nbAsteroideTotal) * (nbAsteroide + 1) <= tempsActuel){
                GrandAsteroide res = new GrandAsteroide(g, g.getWidth(), (int)(Math.random()*g.getHeight()));
                nbAsteroide += 1;
                return res;
            }
        }
        return null;
    }
}
