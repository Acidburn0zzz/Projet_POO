import iut.Game;
import iut.Objet;
import iut.ObjetTouchable;

/**
 * Created by MrMan on 13/06/2016.
 */
public class MalusAngleTir extends ObjetTouchable{

    public MalusAngleTir(Game g, int x, int y) {
        super(g, "MalusAngleTir", x, y);
    }

    @Override
    public void effect(Objet objet) {
        if(objet.isFriend() && !objet.isEnnemy()){
            Joueur joueur = (Joueur) objet;
            joueur.tirAleatoire(10000);
            game().add(new JaugeMalusAngle(game()));
            game().remove(this);
        }
    }

    @Override public boolean isFriend() {return false;}

    @Override public boolean isEnnemy() {return false;}

    @Override
    public void move(long l) {
        moveX(-10);
    }
}
