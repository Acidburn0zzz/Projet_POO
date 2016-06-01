import iut.Game;
import iut.Objet;
import iut.ObjetTouchable;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Joueur extends ObjetTouchable {
    private int vie;
    private double vitesse;
    private String nom;
    private boolean bloqué;

    public Joueur(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
        bloqué = false;
    }

    @Override
    public void effect(Objet objet) {

    }

    @Override
    public boolean isFriend() {
        return false;
    }

    @Override
    public boolean isEnnemy() {
        return true;
    }

    @Override
    public void move(long l) {

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
    public void débloque(){

    }
    public void bloque(){

    }
}
