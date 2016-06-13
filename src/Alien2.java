import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Alien2 extends Vaisseau {
    public Alien2(Game g, String nom, int x, int y, double _coefVitesse, double _vitesse, double direction) {
        super(g, nom, x, y, _coefVitesse, _vitesse, direction);
    }

    public Alien2(Game g, int x, int y, double _coefVitesse) {
        super(g, "Alien2", x, y, _coefVitesse, 0.3, Math.PI);
    }

    protected static int getHauteurSprite(){return 0;}

    public void specialMove(long dt){
        setTempsTotal(getTempsTotal()+dt);
        moveX(Math.cos(getDirectionRad())*getCoefVitesse()*getVitesse()*dt*(Math.sin(getTempsTotal()/100)+1));
        moveY(Math.sin(getDirectionRad())*getCoefVitesse()*getVitesse()*dt);
    }

    @Override
    protected void detruit() {
        game().remove(this);
    }
}
