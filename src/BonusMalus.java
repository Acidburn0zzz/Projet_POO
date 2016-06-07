import iut.Game;
import iut.Objet;
import iut.ObjetTouchable;

/**
 * Created by MrMan on 30/05/2016.
 */
public abstract class BonusMalus extends ObjetTouchable {

    public BonusMalus(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    @Override
    public boolean isFriend() {
        return true;
    }

    @Override
    public boolean isEnnemy() {
        return false;
    }

    @Override
    public void move(long l) {
        moveX(l*1);
        if(getLeft()<0)
            game().remove(this);
    }
}
