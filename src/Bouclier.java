import iut.Game;
import iut.Objet;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Bouclier extends BonusMalus {
    private int duree;
    private int energie;
    public Bouclier(Game g, String nom, int x, int y, Joueur j) {
        super(g, nom, x, y, j);
    }

    @Override
    public void effect(Objet objet) {

    }

    @Override
    public void move(long l) {

    }
}
