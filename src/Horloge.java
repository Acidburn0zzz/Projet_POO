import com.sun.org.apache.xalan.internal.xsltc.dom.NodeIteratorBase;
import iut.Game;
import iut.Objet;

import java.awt.*;
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
    public void draw(Graphics g) throws Exception {
        g.setFont(new Font("Dialog", Font.PLAIN, 30));
        g.setColor(Color.BLACK);
        g.drawString(Integer.toString(niveau.getNumero()), 10, game().getHeight() -10);
        g.setFont(new Font("Dialog", Font.PLAIN, 28));
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(niveau.getNumero()), 10, game().getHeight() -10);
        g.setColor(Color.green);
        g.fillRect(50,game().height()-30, (int)(300*(tempsVague-heureDebut)/tempsVague), 20);
    }

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
