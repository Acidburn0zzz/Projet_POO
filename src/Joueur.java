import iut.Game;
import iut.Objet;
import iut.ObjetTouchable;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by MrMan on 30/05/2016.
 */

public class Joueur extends ObjetTouchable implements KeyListener, MouseListener, MouseMotionListener {
    private int vie;
    private int cartouches;
    private double vitesse;
    private String nom;
    private boolean bloque;
    /*
    Array list qui stocke les ennemis et bonus touché par le joueur afin d'éviter le BUG qui se produit
    quand un ennemis n'as pas eu le temps d'être remove mais que le effect est réappellé par le jeu
     */
    private ArrayList<Objet> listeCollision = new ArrayList<>();

    public Joueur(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
        bloque = false;
        vie = 3;
        vitesse = 1;
        cartouches = 0;
    }

    @Override
    public void effect(Objet objet) {
        if (objet.isFriend() && !listeCollision.contains(objet)) {
            listeCollision.add(objet);
            game().remove(objet); //C'est un bonus
        }
        if(objet.isEnnemy() && !listeCollision.contains(objet)) {
            listeCollision.add(objet);
            game().remove(objet);
            vie--;
            JaugeVie.remove();
            if(vie<=0) {
                game().remove(this);
                Cartouches.removeAll();
                cartouches = 0;
            }
        }
    }

    @Override public boolean isFriend() {return true;}
    @Override public boolean isEnnemy() {return false;}

    @Override
    public void move(long l) {
        double px = MouseInfo.getPointerInfo().getLocation().getY()-getMiddleY();
        if(Math.abs(px)>2) {
            if (Math.abs(px) <= vitesse * l) {
                moveY(px);
            } else {
                if(px>0)
                    moveY(vitesse*l);
                else
                    moveY(-vitesse*l);
            }
        }
    }

    public void addCartouches(int nb){cartouches += nb;}
    public int getCartouches(){return cartouches;}

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public void debloque(){bloque = false;}
    public void bloque(){bloque = true;}

    //KeyListenerInterface
        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyPressed(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}

    //MouseListener Interface
        @Override
        public void mousePressed(MouseEvent e) {
            if(cartouches!=0) {
                game().add(new Missile(this, getMiddleX() + 80, getMiddleY()));
                cartouches--;
                Cartouches.remove();
            }
        }
        @Override public void mouseClicked(MouseEvent e) {}
        @Override public void mouseReleased(MouseEvent e) {}
        @Override public void mouseEntered(MouseEvent e) {}
        @Override public void mouseExited(MouseEvent e) {}
        @Override public void mouseDragged(MouseEvent e) {}
        @Override public void mouseMoved(MouseEvent e) {}
}

