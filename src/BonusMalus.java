import iut.Game;
import iut.Objet;
import iut.ObjetTouchable;

/**
 * Created by MrMan on 30/05/2016.
 */
public class BonusMalus extends ObjetTouchable {
    public BonusMalus(Game g, String nom, int x, int y, Joueur j) {
        super(g, nom, x, y);
    }

    @Override
    public void effect(Objet objet) {

    }

    @Override
    public boolean isFriend() {
        return false;
    }

    @Override
    public boolean isEnnemy() {
        return false;
    }

    @Override
    public void move(long l) {

    }
}
