import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Alien1 extends Vaisseau {
    public Alien1(Game g, int x, int y) {
        super(g, "GrandAsteroide", true, x, y);
    }
    public void move(long dt){
        moveX(-10);
        if (getMiddleX()<0)
            detruit();
    }
    public void specialMove(long dt) {

    }

    @Override
    protected void detruit() {
        game().add(new Alien1(game(), game().getWidth(), (int)(Math.random()*game().height())));
        game().remove(this);
    }
}
