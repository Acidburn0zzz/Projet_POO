import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Vaisseau extends Ennemi {

    public Vaisseau(Game g, String nom, boolean destructible, int x, int y) {
        super(g, nom, x, y);
    }

    protected static int getHauteurSprite(){return 0;}

    @Override
    protected void specialMove(long dt) {

    }

    public boolean isDestructible(){
        return true;
    }

    @Override
    protected void detruit() {
        game().remove(this);
    }
}
