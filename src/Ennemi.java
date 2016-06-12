import iut.*;

import java.awt.*;


public abstract class Ennemi extends ObjetTouchable {

    private double coefVitesse;
    private double vitesse;
    private double directionRad;
    private String nom;

    public Ennemi(Game g, String nom, int x, int y, double _coefVitesse) {
        super(g, nom, x, y);
        this.nom = nom;
        coefVitesse = _coefVitesse;
    }

    public Ennemi(Game g, String nom, int x, int y, double _coefVitesse, double _vitesse, double direction) {
        super(g, nom, x, y);
        this.nom = nom;
        coefVitesse = _coefVitesse;
        vitesse = _vitesse;
        setDirectionRad(direction);
    }

    @Override public boolean isFriend() {return false;}
    @Override public boolean isEnnemy() {return true;}

    @Override
    public void effect(Objet objet) {
        if(objet.isFriend() && isDestructible()){
            detruit();
        }
    }

    @Override
    public void move(long l) {  //Ennemi.move
        if (getLeft()<0)
            game().remove(this);
        else{                  //Vitesse attribut privé ?
            specialMove(l);
        }

    }

    public void draw(Graphics g) throws Exception {
        Sprite s = SpriteStore.get().getSprite(this.getNom());
        s.draw(g, (int)getLeft(), (int)getTop());
        g.setColor(Color.RED);

        g.setFont(new Font("Dialog", Font.PLAIN, 30));
        g.setColor(Color.BLACK);
        g.drawString(Double.toString(directionRad), getLeft(), getTop());

        Graphics2D g1 = (Graphics2D) g;
        g1.setStroke(new BasicStroke(5));
        g1.drawLine(getMiddleX(), getMiddleY(),
                getMiddleX()+(int)(Math.cos(getDirectionRad())*getCoefVitesse()*getVitesse()*100),
                getMiddleY()+(int)(Math.sin(getDirectionRad())*getCoefVitesse()*getVitesse()*100));

    }

    protected abstract void specialMove(long dt);
    protected abstract boolean isDestructible();
    protected abstract void detruit();

    public double getCoefVitesse() {
        return coefVitesse;
    }
    public void setCoefVitesse(double coefVitesse) {
        this.coefVitesse = coefVitesse;
    }
    public double getVitesse() {
        return vitesse;
    }
    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }
    public double getDirectionRad() {
        return directionRad;
    }
    public void setDirectionRad(double _directionRad) {
        this.directionRad = _directionRad % (2.0*Math.PI);
        if(this.directionRad<0)
            this.directionRad += 2*Math.PI;
    }

    public String getNom() {
        return nom;
    }
}
