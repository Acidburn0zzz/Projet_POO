import iut.Game;
import iut.Objet;

import java.awt.*;

/**
 * Created by MrMan on 14/06/2016.
 */
public class JaugeBonusVitesse extends Objet {
    Joueur joueur;
    int duree = 10000;

    public JaugeBonusVitesse(Joueur j) {
        super(j.game(), "JaugeBonusVitesse", 0, 0);
        joueur = j;
        j.setVitesse(4);
    }

    @Override
    public void draw(Graphics g) throws Exception {
        g.setColor(Color.YELLOW);
        g.fillRect(joueur.getLeft()-14, joueur.getTop()+(193*(10000-duree)/10000), 4, (193-(193*(10000-duree)/10000)));
    }

    @Override
    public void move(long l) {
        duree -= l;
        if(duree<0){
            joueur.setVitesse(1);
            game().remove(this);
        }
    }

    @Override public boolean collision(Objet objet) {return false;}
    @Override public void effect(Objet objet) {}
    @Override public boolean isFriend() {return false;}
    @Override public boolean isEnnemy() {return false;}

}
