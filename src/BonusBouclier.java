import iut.Game;
import iut.Objet;
import iut.ObjetTouchable;

/**
 * Created by MrMan on 30/05/2016.
 */
public class BonusBouclier extends ObjetTouchable {
    public BonusBouclier(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    @Override
    public void effect(Objet objet) {
        if (objet.isFriend()){
            Joueur joueur = (Joueur) objet;
            Bouclier bouclier = new Bouclier(joueur);
            joueur.game().add(bouclier);
            joueur.ajouteBonus(bouclier);
            joueur.game().remove(this);
        }

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
    private double getVitesse(){
        return 0.0;
    }
}
