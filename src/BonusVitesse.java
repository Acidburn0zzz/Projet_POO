import iut.Game;
import iut.Objet;
import iut.ObjetTouchable;

/**
 * Created by MrMan on 14/06/2016.
 */
public class BonusVitesse extends ObjetTouchable {
    public BonusVitesse(Game g, int x, int y) {
        super(g, "BonusVitesse", x, y);
    }

    @Override
    public void effect(Objet objet) {
        if (objet.isFriend() && !objet.isEnnemy()){
            Joueur joueur = (Joueur) objet;
            game().add(new JaugeBonusVitesse(joueur));
            joueur.game().remove(this);
        }
    }

    @Override public boolean isFriend() {return false;}
    @Override public boolean isEnnemy() {return false;}

    @Override
    public void move(long l) {
        moveX(-10);
        if(getLeft()<0)
            game().remove(this);
    }
}
