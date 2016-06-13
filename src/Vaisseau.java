import iut.Game;

/**
 * Created by MrMan on 30/05/2016.
 */
public abstract class Vaisseau extends Ennemi {
    private long tempsTotal;
    public Vaisseau(Game g, String nom, int x, int y, double _coefVitesse, double _vitesse, double direction) {
        super(g, nom, x, y, _coefVitesse, _vitesse, direction);
        tempsTotal = 0;
    }

    @Override
    protected void detruit() {
        game().remove(this);
    }

    public long getTempsTotal() {
        return tempsTotal;
    }

    public void setTempsTotal(long tempsTotal) {
        this.tempsTotal = tempsTotal;
    }
}