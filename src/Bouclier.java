import iut.Game;
import iut.Objet;
import iut.ObjetTouchable;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Bouclier extends ObjetTouchable {
    private int duree;
    private Joueur joueur;
    private int energie;
    public Bouclier(Joueur j) {
        super(j.game(), "Bouclier", j.getMiddleX()+80, j.getMiddleY());
        joueur = j;
        duree = 1000;
        energie = 3;
    }

    @Override
    public void move(long l) {
        duree -= l;
        if (duree<0){
            JaugeBouclier.removeAll();
            game().remove(this);
        }else
            moveY(joueur.getMiddleY()-getMiddleY());
    }

    @Override
    public void effect(Objet objet) {
        if (objet.isEnnemy()){
            energie--;
            JaugeBouclier.remove();
            if(energie<=0){
                game().remove(this);
            }
        }
    }

    @Override public boolean isFriend() {return false;}
    @Override public boolean isEnnemy() {return false;}
}
