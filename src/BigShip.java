import iut.Game;
import iut.Objet;

/**
 * Created by MrMan on 30/05/2016.
 */
public class BigShip extends Vaisseau {
    public BigShip(Game g, String nom, boolean destructible, int x, int y) {
        super(g, nom, destructible, x, y);
    }

    @Override
    public void effect(Objet objet) {
        super.effect(objet);
    }

    @Override
    public void move(long l) {
        super.move(l);
    }

    @Override
    public boolean isDestructible() {
        return super.isDestructible();
    }

}
