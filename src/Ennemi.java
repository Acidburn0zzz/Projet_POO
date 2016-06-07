import iut.Game;
import iut.Objet;
import iut.ObjetTouchable;

/**
 * Created by MrMan on 30/05/2016.
 */
public abstract class Ennemi extends ObjetTouchable {
    public Ennemi(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    @Override
    public void effect(Objet objet) {
        if(objet.isFriend() && isDestructible()){
            detruit();
        }
    }

    @Override
    public boolean isFriend() {
        return false;
    }

    @Override
    public boolean isEnnemy() {
        return true;
    }

    @Override
    public void move(long l) {  //Ennemi.move
        if (getLeft()<0)
            game().remove(this);
        else{                  //Vitesse attribut privé ?

        }

    }

    protected abstract void specialMove(long dt);

    protected abstract boolean isDestructible();

    protected abstract void detruit();
}
