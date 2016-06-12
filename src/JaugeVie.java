import iut.Game;

import java.util.ArrayList;

/**
 * Created by MrMan on 30/05/2016.
 */
public class JaugeVie extends Afficheurs {
    private static ArrayList<JaugeVie> list = new ArrayList<>();
    public JaugeVie(Joueur j) {
        super(j.game(), "JaugeVie", list.size()*40, 20);
        j.game().add(this);

        if(list.isEmpty()){ //Crée premier
            list.add(this);
            game().add(new JaugeVie(j));
            game().add(new JaugeVie(j));
        }else
            list.add(this);
    }

    @Override
    public void remove() {
        JaugeVie JaugeVie = list.get(list.size());
        game().remove(JaugeVie);
        list.remove(JaugeVie);
    }
}
