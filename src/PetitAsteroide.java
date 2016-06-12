import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class PetitAsteroide extends Asteroide {
    public PetitAsteroide(Game g, int x, int y) {
        super(g, "PetitAsteroide", x, y);
    }

    protected static int getHauteurSprite(){return 0;}

    @Override
    protected void specialMove(long dt) {
        moveY(Math.sin(dt)*20);
    }

    @Override
    protected void detruit() {
        game().remove(this);
    }

    @Override
    protected void split() {

    }
}
