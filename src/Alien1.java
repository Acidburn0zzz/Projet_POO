import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Alien1 extends Vaisseau {
    public Alien1(Game g, int x, int y, double _coefVitesse) {
        super(g, "Alien1", x, y, _coefVitesse, 8, Math.PI);
    }

    protected static int getHauteurSprite(){return 0;}

    public void specialMove(long dt){
        moveX(-10);
    }
    @Override
    protected void detruit() {
        game().remove(this);
    }
}
