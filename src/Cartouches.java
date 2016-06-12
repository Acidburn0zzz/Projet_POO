import iut.Game;

import java.util.ArrayList;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Cartouches extends Afficheurs {
    private static ArrayList<Cartouches> list = new ArrayList<>();
    public Cartouches(Joueur j) {
        super(j.game(), "Cartouches", 10, j.game().getHeight()-60-list.size()*10);
        list.add(this);
    }


    @Override
    public void remove() {
        Cartouches cartouches = list.get(list.size());
        game().remove(cartouches);
        list.remove(cartouches);
    }
}
