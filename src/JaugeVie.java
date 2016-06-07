import iut.Game;

import java.util.ArrayList;

/**
 * Created by MrMan on 30/05/2016.
 */
public class JaugeVie extends Afficheurs {
    private static ArrayList<JaugeVie> list = new ArrayList<>();
    public JaugeVie(Joueur j) {
        super(j.game(), "JaugeVie", list.size()*40, 20);
    }
}
