import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Vaisseau extends Ennemi {
    private boolean destructible;

    public Vaisseau(Game g, String nom, boolean destructible, int x, int y) {
        super(g, nom, x, y);
    }

    public boolean isDestructible(){
        return destructible;
    }
}
