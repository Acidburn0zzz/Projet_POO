import iut.Game;
import iut.Objet;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Missile extends BonusMalus {
    public Missile(Game g, String nom, int x, int y, Joueur j) {
        super(g, nom, x, y, j);
    }
    @Override
    public void effect(Objet o){

    }
    @Override
    public void move(long dt){

    }
}
