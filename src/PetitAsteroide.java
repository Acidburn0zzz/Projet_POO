import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class PetitAsteroide extends Asteroide {
    public PetitAsteroide(Game g, int x, int y, double coefVitesse, double direction) {
        super(g, "PetitAsteroide", x, y, coefVitesse, 0.4, direction);
    }

    @Override
    protected void detruit() {
        game().remove(this);
    }

    @Override
    protected void split() {

    }
}
