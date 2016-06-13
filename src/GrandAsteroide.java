import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class GrandAsteroide extends Asteroide {
    private boolean detruit;
    public GrandAsteroide(Game g, int x, int y, double coefVitesse) {
        super(g, "GrandAsteroide", x, y, coefVitesse, 0.2, MathJeu.randomizeDirection45());
        detruit = false;
    }

    @Override
    protected void detruit() {
        if(!detruit) {
            detruit = true;
            split();
        }
    }

    @Override
    protected void split() {
        game().add(new AsteroideMoyen(game(), getMiddleX(), getMiddleY()+100, getCoefVitesse(), MathJeu.randBorne(2.8,3.5)*Math.PI/4));
        game().add(new AsteroideMoyen(game(), getMiddleX(), getMiddleY()-100, getCoefVitesse(), -MathJeu.randBorne(2.8,3.5)*Math.PI/4));
        game().remove(this);
    }
}
