import iut.Game;

import java.util.ArrayList;

/**
 * Created by MrMan on 30/05/2016.
 */
public class JaugeBouclier extends Afficheurs {
    private static ArrayList<JaugeBouclier> list = new ArrayList<>();
    public JaugeBouclier(Joueur j) {
        super(j.game(), "JaugeBouclier", list.size()*40+5, 70);
        j.game().add(this);

        if(list.isEmpty()){ //Crée premier
            list.add(this);
            JaugeBouclier jaugeBouclier = new JaugeBouclier(j);
            JaugeBouclier jaugeBouclier1 = new JaugeBouclier(j);
        }else
            list.add(this);
    }

    public static void remove() {
        if(!list.isEmpty()) {
            JaugeBouclier jaugeBouclier = list.get(list.size() - 1);
            jaugeBouclier.game().remove(jaugeBouclier);
            list.remove(jaugeBouclier);
        }
    }

    public static void removeAll() {
        while(!list.isEmpty()){
            JaugeBouclier jaugeBouclier = list.get(list.size() - 1);
            jaugeBouclier.game().remove(jaugeBouclier);
            list.remove(jaugeBouclier);
        }
    }
}
