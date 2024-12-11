package render.entity.builder;

import render.point.MyPoint;
import render.shapes.MyPoligon;
import render.shapes.Tetraedron;
import java.awt.*;
import java.util.ArrayList;

public class BasicEntityBuilder {
    
    public static IEntity createCube(double size, double centerX, double centerY, double centerZ){
       
        int s = (int)size;

        MyPoint p1 = new MyPoint(centerX + s/2, -centerY + s/2, -centerZ + s/2);
        MyPoint p2 = new MyPoint(centerX + s/2, centerY + s/2, -centerZ + s/2);
        MyPoint p3 = new MyPoint(centerX + s/2, centerY + s/2, centerZ + s/2);
        MyPoint p4 = new MyPoint(centerX + s/2, -centerY + s/2, centerZ + s/2);
        MyPoint p5 = new MyPoint(-centerX + s/2, -centerY + s/2, -centerZ + s/2);
        MyPoint p6 = new MyPoint(-centerX + s/2, centerY + s/2, -centerZ + s/2);
        MyPoint p7 = new MyPoint(-centerX + s/2, centerY + s/2, centerZ + s/2);
        MyPoint p8 = new MyPoint(-centerX + s/2, -centerY + s/2, centerZ + s/2);

        Tetraedron tetra = new Tetraedron(
        new MyPoligon(Color.CYAN,p1, p2, p3, p4),
        new MyPoligon(Color.RED, p5, p6, p7, p8),
        new MyPoligon(Color.DARK_GRAY, p1, p2, p6, p5),
        new MyPoligon(Color.GREEN, p1, p5, p8, p4),
        new MyPoligon(Color.ORANGE, p2, p6, p7, p3),
        new MyPoligon(Color.PINK, p4, p3, p7, p8));

        ArrayList<Tetraedron> tetras = new ArrayList<Tetraedron>();

        tetras.add(tetra);


        return new Entity(tetras);

    }

    public static IEntity createColorCube(Color color, double size, double centerX, double centerY, double centerZ){
       
        int s = (int)size;

        MyPoint p1 = new MyPoint(centerX + s/2, -centerY + s/2, -centerZ + s/2);
        MyPoint p2 = new MyPoint(centerX + s/2, centerY + s/2, -centerZ + s/2);
        MyPoint p3 = new MyPoint(centerX + s/2, centerY + s/2, centerZ + s/2);
        MyPoint p4 = new MyPoint(centerX + s/2, -centerY + s/2, centerZ + s/2);
        MyPoint p5 = new MyPoint(-centerX + s/2, -centerY + s/2, -centerZ + s/2);
        MyPoint p6 = new MyPoint(-centerX + s/2, centerY + s/2, -centerZ + s/2);
        MyPoint p7 = new MyPoint(-centerX + s/2, centerY + s/2, centerZ + s/2);
        MyPoint p8 = new MyPoint(-centerX + s/2, -centerY + s/2, centerZ + s/2);

        Tetraedron tetra = new Tetraedron(Color.BLUE,
        true,
        new MyPoligon(color,p1, p2, p3, p4),
        new MyPoligon(color, p5, p6, p7, p8),
        new MyPoligon(color, p1, p2, p6, p5),
        new MyPoligon(color, p1, p5, p8, p4),
        new MyPoligon(color, p2, p6, p7, p3),
        new MyPoligon(color, p4, p3, p7, p8));

        ArrayList<Tetraedron> tetras = new ArrayList<Tetraedron>();

        tetras.add(tetra);


        return new Entity(tetras);

    }

    public static IEntity createDiamond(Color color, double size, double centerX, double centerY, double centerZ){

        ArrayList<Tetraedron> tetras = new ArrayList<Tetraedron>();

        int edges = 10;

        double inFactor = 0.80;

        MyPoint bottom = new MyPoint(centerX, centerY, centerZ - size/2);
        MyPoint[] outerPoints = new MyPoint[edges];
        MyPoint[] innerPoints = new MyPoint[edges];

        for (int i = 0; i < edges; i++) {
            double theta = 2 * Math.PI / edges * i;
            double xPos = -Math.sin(theta) * size/2;
            double yPos = Math.cos(theta) * size/2;
            double zPos = size/2;
            outerPoints[i] = new MyPoint(centerX + xPos, centerY + yPos, centerZ + zPos);
            innerPoints[i] = new MyPoint(centerX + xPos * inFactor, centerY + yPos * inFactor, centerZ + zPos / inFactor);
        }

        MyPoligon poligons[] = new MyPoligon[2 * edges + 1];

        for (int i = 0; i < edges; i++) {
            poligons[i] = new MyPoligon(outerPoints[i], bottom, outerPoints[(i + 1) % edges]);
        }

        for (int i = 0; i < edges; i++) {
            poligons[i + edges] = new MyPoligon(outerPoints[i], outerPoints[(i + 1) % edges], innerPoints[(i + 1) % edges], innerPoints[i]);
        }

        poligons[edges * 2] = new MyPoligon(innerPoints);

        Tetraedron tetra = new Tetraedron(color, true, poligons);
        tetras.add(tetra);

        return new Entity(tetras);
    }
}
