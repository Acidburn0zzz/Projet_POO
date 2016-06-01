import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public abstract class Asteroide extends Ennemi {
    public Asteroide(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    protected abstract void split();
}
