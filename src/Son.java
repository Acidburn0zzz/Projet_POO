import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class Son extends Thread{
    private String file;
    public Son(String _file){
        file = _file;
    }

    @Override
    public void run() {
        try {
            ClassLoader c = this.getClass().getClassLoader();
            InputStream fis = c.getResourceAsStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            Player player = new Player(bis);
            player.play();

        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
}
