import iut.Game;

import java.util.ArrayList;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Cartouches extends Afficheurs {
    private static ArrayList<Cartouches> list = new ArrayList<>();
    public Cartouches(Joueur j) {
        super(j.game(), "Cartouches", list.size()*40, 40);
    }
}
