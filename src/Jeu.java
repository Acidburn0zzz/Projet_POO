/**
 * Created by MrMan on 30/05/2016.
 */
import iut.Game;
import iut.Sprite;
import iut.SpriteStore;

import java.awt.*;

public class Jeu extends Game {
    public Jeu(int largeur, int hauteur, String title) {
        super(largeur, hauteur, title);
    }

    private Joueur joueur;
    @Override
    protected void createObjects() {
        joueur = new Joueur(this, "Joueur", 100, this.getHeight()/2);
        JaugeVie jaugeVie = new JaugeVie(joueur);
        this.add(joueur);
        addMouseInteractiveObject(joueur);
        Niveau niveau = new Niveau(1, this);
        this.add(new Horloge(this, niveau));
    }

    @Override
    protected void drawBackground(Graphics graphics) {
        Sprite sprite = null;
        try {
            sprite = SpriteStore.get().getSprite("Background");
        } catch (Exception e) {
            e.printStackTrace();
        }
        sprite.draw(graphics, 0, 0);
    }

    @Override
    protected void perdu() {
    }

    @Override
    protected void gagne() {

    }


}
