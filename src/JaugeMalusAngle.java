import iut.*;
import java.awt.*;

/**
 * Created by MrMan on 13/06/2016.
 */
public class JaugeMalusAngle extends Objet {
    private int duree = 10000;

    public JaugeMalusAngle(Game g) {
        super(g, "", 0, 0);
    }

    @Override public boolean collision(Objet objet) {return false;}
    @Override public void effect(Objet objet) {}
    @Override public boolean isFriend() {return false;}
    @Override public boolean isEnnemy() {return false;}

    @Override
    public void draw(Graphics g) throws Exception {
        Sprite s = SpriteStore.get().getSprite("IconMalusAngle");
        s.draw(g, 10, game().getHeight()-55);

        g.setColor(Color.RED);
        g.fillRect(50, game().getHeight()-55, 120-(120*(10000-duree)/10000), 20);
    }

    @Override
    public void move(long l) {
        duree -= l;
        if(duree<0)
            game().remove(this);
    }
}
