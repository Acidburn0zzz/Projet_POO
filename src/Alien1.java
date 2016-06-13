import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Alien1 extends Vaisseau {
    public Alien1(Game g, int x, int y, double _coefVitesse) {
        super(g, "Alien1", x, y, _coefVitesse, 0.4, Math.PI);
    }


    public void specialMove(long dt){
        setTempsTotal(getTempsTotal()+dt);
        setDirectionRad(Math.atan(Math.sin(getTempsTotal()/150)/0.8)+Math.PI); // on dessine un cosinus
        moveX(Math.cos(getDirectionRad())*getCoefVitesse()*getVitesse()*dt);
        moveY(Math.sin(getDirectionRad())*getCoefVitesse()*getVitesse()*dt);
    }
    @Override
    protected void detruit() {
        game().remove(this);
    }
}