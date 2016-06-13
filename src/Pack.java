import iut.Game;
import iut.Objet;
import iut.ObjetTouchable;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Pack extends ObjetTouchable {
    public Pack(Game g, int x, int y) {
        super(g, "Pack", x, y);
    }

    @Override
    public void effect(Objet objet) {
        if (objet.isFriend()){
            Joueur joueur = (Joueur) objet;
            Cartouches cartouches = new Cartouches(joueur);
            joueur.game().remove(this);
        }
    }

    @Override
    public void move(long l) {
        if(getLeft()<=0)
            game().remove(this);
        else
            moveX(-10);
    }

    @Override public boolean isFriend() {return false;}
    @Override public boolean isEnnemy() {return false;}
}
