import iut.Game;
import iut.Objet;
import iut.ObjetTouchable;


public abstract class Ennemi extends ObjetTouchable {

    private double coefVitesse;
    private double vitesse;
    private double directionRad;

    public Ennemi(Game g, String nom, int x, int y, double _coefVitesse) {
        super(g, nom, x, y);
        coefVitesse = _coefVitesse;
    }

    public Ennemi(Game g, String nom, int x, int y, double _coefVitesse, double _vitesse, double direction) {
        super(g, nom, x, y);
        coefVitesse = _coefVitesse;
        vitesse = _vitesse;
        directionRad = direction;
    }

    @Override
    public void effect(Objet objet) {
        if(objet.isFriend() && isDestructible()){
            detruit();
        }
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
    public void move(long l) {  //Ennemi.move
        if (getLeft()<0)
            game().remove(this);
        else{                  //Vitesse attribut privé ?
            specialMove(l);
        }

    }

    protected abstract void specialMove(long dt);

    protected abstract boolean isDestructible();

    protected abstract void detruit();

    public double getCoefVitesse() {
        return coefVitesse;
    }

    public void setCoefVitesse(double coefVitesse) {
        this.coefVitesse = coefVitesse;
    }

    public double getVitesse() {
        return vitesse;
    }

    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }

    public double getDirectionRad() {
        return directionRad;
    }

    public void setDirectionRad(double directionRad) {
        this.directionRad = directionRad % (2.0*Math.PI);
    }
}
