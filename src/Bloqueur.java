import iut.Game;
import iut.Objet;
import iut.ObjetTouchable;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Bloqueur extends ObjetTouchable {
    private int duree;
    private boolean touched;
    private Joueur joueur;
    public Bloqueur(Game g, int x, int y) {
        super(g, "Bloqueur", x, y);
        duree = 1000;
        touched = false;
    }

    @Override
    public void effect(Objet objet) {
        if(objet.isFriend() && !objet.isEnnemy()){
            joueur = (Joueur) objet;
            joueur.bloque(duree);
            touched = true;
            game().remove(this);
        }
    }

    @Override
    public void move(long l) {
        moveX(-10);
    }

    @Override public boolean isFriend() {return false;}
    @Override public boolean isEnnemy() {return false;}
}
