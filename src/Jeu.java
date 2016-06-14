/**
 * Created by MrMan on 30/05/2016.
 */
import iut.Game;
import iut.Objet;
import iut.Sprite;
import iut.SpriteStore;

import javax.swing.*;
import java.awt.*;

public class Jeu extends Game {
    private boolean perdu = false;
    private Horloge horloge;

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

        Object[] options = {"Oui",
                "Non"};
        int n = JOptionPane.showOptionDialog(getParent(),
                "Voulez vous changer le nom du vaisseau à chaque niveau",
                "Configuration",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if(n==0)
            horloge = new Horloge(this, joueur, true);
        else
            horloge = new Horloge(this, joueur, false);
        this.add(horloge);

        Son son = new Son("Musique.mp3");
        son.start();
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
        if(perdu) {
            graphics.setFont(new Font("Consolas", Font.BOLD, 100));
            graphics.setColor(Color.RED);
            graphics.drawString("Vous avez perdu !", getWidth()/4, getHeight()/2);
        }
    }

    @Override
    public void dead() {
        perdu();
    }

    @Override
    protected void perdu() {
        JaugeBouclier.removeAll();
        perdu = true;
        Objet ennemi = new Objet(this, "", 0, 0) {
            @Override public boolean collision(Objet objet) {return false;}
            @Override public void effect(Objet objet) {}
            @Override public boolean isFriend() {return false;}
            @Override public boolean isEnnemy() {return true;}
            @Override public void move(long l) {}
            @Override public void draw(Graphics g) throws Exception {}
        };
        this.add(ennemi);
        this.remove(horloge);
    }

    @Override
    protected void gagne() {

    }


}
