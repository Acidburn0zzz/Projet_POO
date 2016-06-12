import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Alien1 extends Vaisseau {
    public Alien1(Game g, int x, int y) {
        super(g, "Alien1", true, x, y);
    }

    protected static int getHauteurSprite(){return 0;}

    public void move(long dt){
        if (getMiddleX()<0)
            detruit();
        moveX(-10);
    }
    public void specialMove(long dt) {
        System.out.println(dt);
    }

    @Override
    protected void detruit() {
        game().remove(this);
    }
}
