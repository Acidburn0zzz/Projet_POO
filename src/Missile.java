import iut.Game;
import iut.Objet;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Missile extends BonusMalus {
    private double vitesse;
    private double coefVitesse;
    private double directionRad;

    public Missile(Joueur j, int x, int y, double direction, double _coefVitesse) {
        super(j.game(), "Missile", x, y);
        setDirectionRad(direction);
        setCoefVitesse(_coefVitesse);
        setVitesse(1);
    }
    @Override
    public void effect(Objet o){
        if (o.isEnnemy() && !o.isFriend()){
            Ennemi ennemi = (Ennemi) o;
            if(ennemi!=null)
                ennemi.detruit();
            game().remove(this);
        }
    }

    @Override
    public boolean isFriend() {
        return false;
    }

    @Override
    public void move(long dt){
        moveX(Math.cos(getDirectionRad())*getCoefVitesse()*getVitesse()*dt);
        moveY(Math.sin(getDirectionRad())*getCoefVitesse()*getVitesse()*dt);
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
        if(this.directionRad<0)
            this.directionRad += 2*Math.PI;
    }

    public double getCoefVitesse() {
        return coefVitesse;
    }

    public void setCoefVitesse(double coefVitesse) {
        this.coefVitesse = coefVitesse;
    }
}
