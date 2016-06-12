import iut.Game;

import java.util.ArrayList;

/**
 * Created by MrMan on 30/05/2016.
 */
public class JaugeBouclier extends Afficheurs {
    private static ArrayList<JaugeBouclier> list = new ArrayList<>();
    public JaugeBouclier(Joueur j) {
        super(j.game(), "JaugeBouclier", list.size()*40, 60);
    }

    @Override
    public void remove() {
        JaugeBouclier JaugeBouclier = list.get(list.size());
        game().remove(JaugeBouclier);
        list.remove(JaugeBouclier);
    }
}
