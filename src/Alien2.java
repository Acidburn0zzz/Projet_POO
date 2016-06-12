import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Alien2 extends Vaisseau {
    public Alien2(Game g, int x, int y, double _coefVitesse) {
        super(g, "Alien2", x, y, _coefVitesse, 8, Math.PI);
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
