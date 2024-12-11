package render.shapes;

import java.awt.*;

public class Tetraedron { 
    private MyPoligon[] poligons;
    private Color color;

    public Tetraedron(Color color, boolean decayColor, MyPoligon...poligons){
        this.color = color;
        this.poligons = poligons;
        if(decayColor){
            this.setDecayingPoligonColor();
        }else{
            this.setPolygonColor();
        }
        this.sortPolygons();
    }

    public Tetraedron(MyPoligon...poligons){
        this.color = Color.WHITE;
        this.poligons = poligons;
        this.sortPolygons();
    }

    public MyPoligon[] getPoligons(){
        return this.poligons;
    }

    public void render(Graphics g){
        for (MyPoligon poly : this.poligons) {
            poly.render(g);
        }
    }

    public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees){
        for (MyPoligon p : this.poligons) {
            p.rotate(CW, xDegrees, yDegrees, zDegrees);
        }

        this.sortPolygons();
    }
    public void sortPolygons(){
        MyPoligon.sortPoligons(this.poligons);
    }

    public void setPolygonColor(){
        for (MyPoligon poly : this.poligons) {
            poly.setColor(this.color);
        }
    }

    private void setDecayingPoligonColor(){
        double decayFactor = 0.97;
        for (MyPoligon poly : this.poligons) {
            poly.setColor(this.color);
            int r = (int)(this.color.getRed() * decayFactor);
            int g = (int)(this.color.getGreen() * decayFactor);
            int b = (int)(this.color.getBlue() * decayFactor);
            this.color = new Color(r, g, b);
        }
    }
}
