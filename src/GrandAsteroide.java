import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class GrandAsteroide extends Asteroide {
    public GrandAsteroide(Game g, int x, int y, double coefVitesse) {
        super(g, "GrandAsteroide", x, y, coefVitesse, 0.4, MathJeu.randomizeDirection45());
    }

    protected static int getHauteurSprite(){return 0;}

    @Override
    protected void detruit() {
        split();
    }

    @Override
    protected void split() {
        game().add(new AsteroideMoyen(game(), getMiddleX(), getMiddleY()+100, getCoefVitesse(), (3*Math.PI)/4));
        game().add(new AsteroideMoyen(game(), getMiddleX(), getMiddleY()-100, getCoefVitesse(), -(3*Math.PI)/4));
        game().remove(this);
    }
}
