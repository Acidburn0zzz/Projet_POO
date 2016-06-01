import iut.Game;
import iut.Objet;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Bloqueur extends BonusMalus {
    private int duree;
    public Bloqueur(Game g, String nom, int x, int y, Joueur j) {
        super(g, nom, x, y, j);
    }

    @Override
    public void effect(Objet objet) {
        super.effect(objet);
    }

    @Override
    public void move(long l) {
        super.move(l);
    }
}
