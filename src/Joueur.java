import iut.Game;
import iut.Objet;
import iut.ObjetTouchable;

import java.awt.*;
import java.awt.event.*;
import java.awt.peer.KeyboardFocusManagerPeer;

/**
 * Created by MrMan on 30/05/2016.
 */

public class Joueur extends ObjetTouchable implements KeyListener, MouseListener, MouseMotionListener {
    private int vie;
    private double vitesse;
    private String nom;
    private boolean bloque;

    public Joueur(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
        bloque = false;
        vie = 1;
        vitesse = 1;
    }

    @Override
    public void effect(Objet objet) {
        if (objet.isFriend()) {
            ajouteBonus((BonusMalus) objet);
            game().remove(objet);
        }
        if(objet.isEnnemy()) {
            vie--;
            if(vie>=0)
                game().remove(this);
        }
    }

    @Override
    public boolean isFriend() {
        return true;
    }

    @Override
    public boolean isEnnemy() {
        return false;
    }

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void ajouteBonus(BonusMalus b){

    }
    public void enleveBonus(BonusMalus b){

    }
    public void debloque(){
        bloque = false;
    }
    public void bloque(){
        bloque = true;
    }

    //KeyListenerInterface
        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyPressed(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}

    //MouseListener Interface
        @Override
        public void mousePressed(MouseEvent e) {
            game().add(new Missile(this, getMiddleX()+40, getMiddleY()));
        }

        @Override public void mouseClicked(MouseEvent e) {}
        @Override public void mouseReleased(MouseEvent e) {}
        @Override public void mouseEntered(MouseEvent e) {}
        @Override public void mouseExited(MouseEvent e) {}
        @Override public void mouseDragged(MouseEvent e) {}
        @Override public void mouseMoved(MouseEvent e) {}
}

