/**
 * Created by MrMan on 30/05/2016.
 */
import iut.Game;
import iut.Objet;

public class Niveau {
    private Game game;
    private int numero;
    private long tempsActuel; //Le temps écoulé depuis le début de la vague
    private long tempsVague; //La durée de la vague

    private int nbAsteroide, asteroideSpawned; //Le nombre d'ennemi créer et le nombre actuellement crée
    private int nbAlien1, alien1Spawned;
    private int nbAlien2, alien2Spawned;

    private int nxtAsteroide; //L'intervalle entre l'apparition de deux ennemie du même type
    private int nxtAlien1;
    private int nxtAlien2;

    private boolean bouclierSpawned;
    private boolean packSpawned;
    private boolean bloqueurSpawned;
    private boolean vieSpawned;
    private boolean vitesseSpawned= false;

    Niveau(int numero, Game game){
        this.game = game;
        this.numero = numero;
        int coef = numero; //7, 9, 12, 14, ...
        tempsVague = (int) (coef*1000*10); //*1000 pour le millisecondes.
        tempsActuel = 0;

        nbAsteroide = (int)  (coef*Math.sqrt(coef)*0.5); asteroideSpawned = 0;
        nbAlien1 = (int) (coef*Math.sqrt(coef)*4); alien1Spawned = 0;
        nbAlien2 = (int) (coef*Math.sqrt(coef)*2); alien2Spawned = 0;

        if(nbAsteroide!=0)
        nxtAsteroide = (int) (tempsVague/nbAsteroide);
        if(nxtAlien1!=0)
        nxtAlien1 = (int) (tempsVague/nbAlien1);
        if(nxtAlien2!=0)
        nxtAlien2 = (int) (tempsVague/nbAlien2);

        bouclierSpawned = false;
        packSpawned = false;
        bloqueurSpawned = false;
    }
    public Objet NouvelObjet(long time){
        tempsActuel += time;
        Objet objet = null;
        if(tempsActuel>=nxtAsteroide && nbAsteroide> asteroideSpawned && Math.random()>0.95){
            asteroideSpawned++;
            nxtAsteroide += tempsVague/nbAsteroide;
            objet = new GrandAsteroide(game, game.getWidth()-100, MathJeu.randBorne(0, game.getHeight()-100), 1);
        }else if(tempsActuel>=nxtAlien1 && nbAlien1 > alien1Spawned && Math.random()>0.95){
            alien1Spawned++;
            nxtAlien1 += tempsVague/nbAlien1;
            objet = new Alien1(game, game.getWidth(), MathJeu.randBorne(0, game.getHeight()-100), 1);
        }else if(tempsActuel>=nxtAlien2 && nbAlien2 > alien2Spawned && Math.random()>0.95){
            alien2Spawned++;
            nxtAlien2 += tempsVague/nbAlien2;
            objet = new Alien2(game, game.getWidth(), MathJeu.randBorne(0,game.getHeight()-100), 1);
        }else if(!bouclierSpawned && Math.random()>0.999){ //Ajouter des formules pour le spawn
            bouclierSpawned = true;
            objet = new BonusBouclier(game, game.getWidth(), MathJeu.randBorne(0, game.getHeight()-40));
        }else if(!packSpawned && Math.random()>0.99){
            packSpawned = true;
            objet = new Pack(game, game.getWidth(), MathJeu.randBorne(0, game.getHeight()-40));
        }else if(!bloqueurSpawned && Math.random()>0.999){
            bloqueurSpawned = true;
            objet = new Bloqueur(game, game.getWidth(), MathJeu.randBorne(0, game.getHeight()-40));
        }else if(!vieSpawned && Math.random()>0.999){
            vieSpawned = true;
            objet = new BonusVie(game ,game.getWidth(), MathJeu.randBorne(0, game.getHeight()-40));
        }else if(!vitesseSpawned && Math.random()>0.999){
            vitesseSpawned = true;
            objet = new BonusVitesse(game, game.getWidth(), MathJeu.randBorne(0, game.getHeight()-40));
        }
        return objet;
    }
    public long waveLength(){return tempsVague;}

    public int getNumero(){return numero;}

}
