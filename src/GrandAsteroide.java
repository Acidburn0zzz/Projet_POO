import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class GrandAsteroide extends Asteroide {
    public GrandAsteroide(Game g, int x, int y) {
        super(g, "GrandAsteroide", x, y);
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
        game().add(new AsteroideMoyen(game(), getMiddleX(), getMiddleY()+100));
        game().add(new AsteroideMoyen(game(), getMiddleX(), getMiddleY()-100));
        game().remove(this);
    }
}
