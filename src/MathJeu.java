/**
 * Created by Antoine on 12/06/2016.
 */
public class MathJeu {
    /**
     * @param a borne inférieur (inclus pour l'interval de retour)
     * @param b borne supérieur (inclus dans l'interval de retour)
     * @return nombre aléatoire dans l'interval [a;b]
     */
    public static int randBorne(int a, int b){
        return (a<b)?
                (int) (Math.random() * (b - a) + a):
                (int) (Math.random() * (a - b) + b);
    }

    public static double randBorne(double a, double b){
        return (a<b)?
                 Math.random() * (b - a) + a:
                 Math.random() * (a - b) + b;
    }

    /**
     * @return une direction en radian entre -3pi/4 et 3pi/4
     */
    public static double randomizeDirection45() {
        return (randBorne(3d, 5d)*Math.PI)/4; // On génére une direction aléatoire entre 45 et -45
    }

    /**
     * @return une direction entre -10 et 10 degrès
     */
    public static double randomizeMalusTir20(){
        return (randBorne(-1d, 1d)*Math.PI)/18;
    }


}
