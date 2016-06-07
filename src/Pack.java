import iut.Game;
import iut.Objet;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Pack extends BonusMalus {
    public Pack(int x, int y, Joueur j) {
        super(j.game(), "Pack", x, y);
    }

    @Override
    public void effect(Objet objet) {

    }

    @Override
    public void move(long l) {

    }

}
