import iut.Game;
import iut.Objet;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Missile extends BonusMalus {
    public Missile(Joueur j, int x, int y) {
        super(j.game(), "Missile", x, y);
    }
    @Override
    public void effect(Objet o){
        if (o.isEnnemy()){
            Ennemi ennemi = (Ennemi) o;
            if(ennemi!=null)
                ennemi.detruit();
            game().remove(this);
        }
    }

    @Override
    public boolean isFriend() {
        return false;
    }

    @Override
    public void move(long dt){
        moveX(10);
    }
}
