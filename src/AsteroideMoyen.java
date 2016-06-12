import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class AsteroideMoyen extends Asteroide {
    public AsteroideMoyen(Game g, int x, int y, double coefVitesse, double direction) {
        super(g, "AsteroideMoyen", x, y, coefVitesse, 0.6, direction);
    }

    protected static int getHauteurSprite(){return 0;}


    @Override
    protected void detruit() {
        split();
    }

    @Override
    protected void split() {
        game().add(new PetitAsteroide(game(), getMiddleX(), getMiddleY()+40, getCoefVitesse(), (3*Math.PI)/4));
        game().add(new PetitAsteroide(game(), getMiddleX(), getMiddleY()-40, getCoefVitesse(), -(3*Math.PI)/4));
        game().remove(this);
    }
}
