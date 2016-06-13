import iut.*;
import java.awt.*;

import java.util.ArrayList;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Bouclier extends ObjetTouchable {
    private int duree;
    private Joueur joueur;
    private int energie;
    private ArrayList<Objet> listeCollision = new ArrayList<>();

    public Bouclier(Joueur j) {
        super(j.game(), "Bouclier", j.getMiddleX()+80, j.getMiddleY());
        joueur = j;
        duree = 10000;
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
        if (objet.isEnnemy() && !objet.isFriend() && !listeCollision.contains(objet)){
            listeCollision.add(objet);
            System.out.println("Bouclier removed by : " + objet);
            energie--;
            JaugeBouclier.remove();
            if(energie<=0){
                game().remove(this);
            }
        }
    }

    @Override
    public void draw(Graphics g) throws Exception {
        g.setColor(Color.green);
        g.fillRect(5, 120, 120-(120*(10000-duree)/10000), 20);

        Sprite s = SpriteStore.get().getSprite("Bouclier");
        s.draw(g, getLeft(), getTop());
    }

    @Override public boolean isFriend() {return true;}
    @Override public boolean isEnnemy() {return true;}
}
