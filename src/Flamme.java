import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Flamme extends Vaisseau {
    public Flamme(Game g, String nom, boolean destructible, int x, int y) {
        super(g, nom, destructible, x, y);
    }

    protected static int getHauteurSprite(){return 0;}

    public void move(long dt){

    }
    public void specialMove(long dt) {

    }
}
