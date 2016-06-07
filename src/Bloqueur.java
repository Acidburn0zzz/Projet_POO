import iut.Game;
import iut.Objet;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Bloqueur extends BonusMalus {
    private int duree;
    private Joueur joueur;
    public Bloqueur(Game g, int x, int y, Joueur j) {
        super(g, "Bloqueur", x, y);
        duree = 100;
        joueur = j;
    }

    @Override
    public void effect(Objet objet) {

    }

    @Override
    public void move(long l) {
        duree -= l;
        if (duree<0){
            joueur.enleveBonus(this);
            joueur.debloque();
            game().remove(this);
        }
    }
}
