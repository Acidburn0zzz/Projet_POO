import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class PetitAsteroide extends Asteroide {
    public PetitAsteroide(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    @Override
    protected boolean isDestructible() {
        return false;
    }

    @Override
    protected void split() {

    }
}
