import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Alien2 extends Vaisseau {
    public Alien2(Game g, int x, int y) {
        super(g, "Alien2", true, x, y);
    }

    public void move(long dt){
        if (getMiddleX()<0)
            detruit();
        moveX(-10);
    }
    public void specialMove(long dt) {

    }

    @Override
    protected void detruit() {
        game().remove(this);
    }
}
