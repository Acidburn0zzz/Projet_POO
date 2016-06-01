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

    @Override
    protected void createObjects() {
        Joueur joueur = new Joueur(this, "Joueur", 0, this.getHeight()/2);
        this.add(joueur);
        //this.add(new JaugeVie(this, "JaugeVie", 0, 0, joueur));
        this.add(new GrandAsteroide(this, "GrandAsteroide", 1800, 500));
        this.add(new AsteroideMoyen(this, "AsteroideMoyen", 1400, 500));
        this.add(new PetitAsteroide(this, "PetitAsteroide", 1200, 500));
        this.add(new Cartouches(this, "Cartouches", 0, 0, joueur));
        Niveau niveau = new Niveau(1);
        //this.add(new Horloge(this, "Horloge", 0, 100));
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
