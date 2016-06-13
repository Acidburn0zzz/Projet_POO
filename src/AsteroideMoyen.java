import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class AsteroideMoyen extends Asteroide {
    private boolean detruit;

    public AsteroideMoyen(Game g, int x, int y, double coefVitesse, double direction) {
        super(g, "AsteroideMoyen", x, y, coefVitesse, 0.3, direction);
        detruit = false;
    }


    @Override
    protected void detruit() {
        if(!detruit){
            detruit = true;
            split();
        }
    }

    @Override
    protected void split() {
        game().add(new PetitAsteroide(game(), getMiddleX(), getMiddleY()+40, getCoefVitesse(), MathJeu.randBorne(2.8,3.5)*Math.PI/4));
        game().add(new PetitAsteroide(game(), getMiddleX(), getMiddleY()-40, getCoefVitesse(), -MathJeu.randBorne(2.8,3.5)*Math.PI/4));
        game().remove(this);
    }
}
