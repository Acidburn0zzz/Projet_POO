import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class AsteroideMoyen extends Asteroide {
    public AsteroideMoyen(Game g, int x, int y) {
        super(g, "AsteroideMoyen", x, y);
    }

    @Override
    protected void specialMove(long dt) {

    }

    @Override
    protected void detruit() {
        split();
    }

    @Override
    protected void split() {
        game().add(new PetitAsteroide(game(), getMiddleX(), getMiddleY()+40));
        game().add(new PetitAsteroide(game(), getMiddleX(), getMiddleY()-40));
        game().remove(this);
    }
}
