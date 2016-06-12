import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public abstract class Asteroide extends Ennemi {

    public Asteroide(Game g, String nom, int x, int y, double coefVitesse, double vitesse, double direction) {
        super(g, nom, x, y, coefVitesse, vitesse, direction);
    }

    @Override
    protected void specialMove(long dt) {
        if(getTop() <= 100){
                if (getDirectionRad() > Math.PI)
                    setDirectionRad(-getDirectionRad());

        }
        else if( getBottom() >= game().getHeight()-100){
                if(getDirectionRad() < Math.PI)
                    setDirectionRad(-getDirectionRad());
        }

        moveX(Math.cos(getDirectionRad())*getCoefVitesse()*getVitesse()*dt);
        moveY(Math.sin(getDirectionRad())*getCoefVitesse()*getVitesse()*dt);
    }


    protected static int getHauteurSprite(){return 0;}

    @Override
    protected boolean isDestructible() {
        return true;
    }


    protected abstract void split();

}
