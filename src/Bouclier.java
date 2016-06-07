import iut.Game;
import iut.Objet;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Bouclier extends BonusMalus {
    private int duree;
    private Joueur joueur;
    private int energie;
    public Bouclier(Joueur j) {
        super(j.game(), "Bouclier", j.getMiddleX(), j.getMiddleY());
        joueur = j;
    }

    @Override
    public void effect(Objet objet) {
        if (objet.isEnnemy()){
            energie--;
            if(energie<0){
                joueur.enleveBonus(this);
                game().remove(this);
            }
        }
    }

    @Override
    public void move(long l) {
        duree -= l;
        if (duree<0){
            joueur.enleveBonus(this);
            game().remove(this);
        }
        move(joueur.getRight(), joueur.getTop());
    }
}
