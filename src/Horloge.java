import iut.Game;
import iut.Objet;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Horloge extends Objet {
    private long heureDebut;
    private Niveau niveau;

    public Horloge(Game g, Niveau n) {
        super(g, "Horloge", 0, 0); //Coordonées ?
        heureDebut = 0;
        niveau = n;
    }

    @Override
    public boolean collision(Objet objet) {
        return false;
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
        return false;
    }

    @Override
    public void move(long l) {
        heureDebut += l;
        Objet objet = niveau.NouvelObjet(l);
        if(objet!=null)
            game().add(objet);
    }

    public void changeNiveau(Niveau n){
        niveau = n;
    }
}
