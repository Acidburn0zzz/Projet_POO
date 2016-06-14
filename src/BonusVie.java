import iut.Game;
import iut.Objet;
import iut.ObjetTouchable;

/**
 * Created by MrMan on 13/06/2016.
 */
public class BonusVie extends ObjetTouchable {
    public BonusVie(Game g, int x, int y) {
        super(g, "BonusVie", x, y);
    }

    @Override
    public void effect(Objet objet) {
        if (objet.isFriend() && !objet.isEnnemy()){
            Joueur joueur = (Joueur) objet;
            joueur.resetVie();
            game().remove(this);
        }
    }

    @Override public void move(long l) {
        moveX(-10);
        if(getLeft()<0)
            game().remove(this);
    }
    @Override public boolean isFriend() {return false;}
    @Override public boolean isEnnemy() {return false;}
}
