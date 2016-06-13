import iut.Game;

import java.util.ArrayList;

/**
 * Created by MrMan on 30/05/2016.
 */
public class Cartouches extends Afficheurs {
    private static ArrayList<Cartouches> list = new ArrayList<>();
    public Cartouches(Joueur j) {
        super(j.game(), "Cartouches", 125+(list.size()/5)*70, (list.size()%5)*10+10);
        if(list.size()<20){
            list.add(this);
            j.game().add(this);
            if(list.size()%20<=20) {
                Cartouches cartouches = new Cartouches(j);
            }
            j.addCartouches(20-j.getCartouches());
        }
    }

    public static void remove() {
        Cartouches cartouches = list.get(list.size()-1);
        cartouches.game().remove(cartouches);
        list.remove(cartouches);
    }

    public static void removeAll() {
        while (!list.isEmpty()) {
            Cartouches cartouches = list.get(list.size() - 1);
            cartouches.game().remove(cartouches);
            list.remove(cartouches);
        }
    }
}
