import com.sun.org.apache.xalan.internal.xsltc.dom.NodeIteratorBase;
import iut.Game;
import iut.Objet;

import java.util.ArrayList;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Horloge extends Objet {
    private long heureDebut;
    private long tempsVague;
    private Niveau niveau;

    public Horloge(Game g ,Niveau n) {
        super(g, "Horloge", 0, 0); //Coordonées ?
        changeNiveau(n);
    }

    @Override public boolean collision(Objet objet) {return false;}
    @Override public void effect(Objet objet) {}
    @Override public boolean isFriend() {return false;}
    @Override public boolean isEnnemy() {return true;}

    @Override
    public void move(long l) {
        heureDebut += l;
        Objet objet = niveau.NouvelObjet(l);
        if(objet!=null)
            game().add(objet);

        if(heureDebut> tempsVague){
            changeNiveau(new Niveau(niveau.getNumero()+1, game()));

        }
    }

    public void changeNiveau(Niveau n){
        niveau = n;
        tempsVague = n.waveLength();
        heureDebut = 0;
    }
}
