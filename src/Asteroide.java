import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public abstract class Asteroide extends Ennemi {
    public Asteroide(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    protected static int getHauteurSprite(){return 0;}

    @Override
    public void move(long l) {
        moveX(-10);
        if (getMiddleX()<0)
            detruit();
    }

    @Override
    protected boolean isDestructible() {
        return true;
    }


    protected abstract void split();

}
