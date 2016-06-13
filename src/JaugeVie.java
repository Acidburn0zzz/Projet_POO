import iut.Game;

import java.util.ArrayList;

/**
 * Created by MrMan on 30/05/2016.
 */
public class JaugeVie extends Afficheurs {
    private static ArrayList<JaugeVie> list = new ArrayList<>();
    public JaugeVie(Joueur j) {
        super(j.game(), "JaugeVie", list.size()*40+5, 10);
        j.game().add(this);

        if(list.isEmpty()){ //Crée premier
            list.add(this);
            JaugeVie jaugeVie = new JaugeVie(j);
            JaugeVie jaugeVie2 = new JaugeVie(j);
        }else
            list.add(this);
    }

    public static void remove() {
        if(!list.isEmpty()){
            JaugeVie jaugeVie = list.get(list.size()-1);
            list.remove(jaugeVie);
            jaugeVie.game().remove(jaugeVie);
        }
    }
}
