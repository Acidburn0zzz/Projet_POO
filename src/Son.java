import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Antoine on 13/06/2016.
 */

public class Son extends Thread{
    private String fichier;
    public Son(String _fichier){
        fichier = _fichier;
    }

    @Override
    public void run() {
        try {
            ClassLoader c = this.getClass().getClassLoader();
            FileInputStream fis = new FileInputStream(c.getResource(fichier).getFile());
            BufferedInputStream bis = new BufferedInputStream(fis);
            Player player = new Player(bis);
            player.play();

        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
