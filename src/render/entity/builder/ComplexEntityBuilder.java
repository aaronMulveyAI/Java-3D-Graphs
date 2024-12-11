package render.entity.builder;

import java.awt.*;
import java.util.ArrayList;

import render.point.MyPoint;
import render.shapes.MyPoligon;
import render.shapes.Tetraedron;

public class ComplexEntityBuilder {
    
    public static IEntity createRubiksCube(Color color, double size, double centerX, double centerY, double centerZ){
        
        ArrayList<Tetraedron> tetras = new ArrayList<Tetraedron>();

        double cubeSpacing = 100;

        for (int i = -1; i < 2; i++) {
            double cubeCenterX = i * (size + cubeSpacing) + centerX;
            for (int j = -1; j < 2; j++) {
                double cubeCenterY = j * (size + cubeSpacing) + centerY;
                for (int x = -1; x < 2; x++) {

                    if(i == 0 && j == 0 && x == 0) continue;
                        
                    
                    double cubeCenterZ = x * (size + cubeSpacing) + centerZ;

                    MyPoint p1 = new MyPoint(cubeCenterX - size / 2, cubeCenterY - size / 2, cubeCenterZ - size / 2);
                    MyPoint p2 = new MyPoint(cubeCenterX - size / 2, cubeCenterY - size / 2, cubeCenterZ + size / 2);
                    MyPoint p3 = new MyPoint(cubeCenterX - size / 2, cubeCenterY + size / 2, cubeCenterZ - size / 2);
                    MyPoint p4 = new MyPoint(cubeCenterX - size / 2, cubeCenterY + size / 2, cubeCenterZ + size / 2);
                    MyPoint p5 = new MyPoint(cubeCenterX + size / 2, cubeCenterY - size / 2, cubeCenterZ - size / 2);
                    MyPoint p6 = new MyPoint(cubeCenterX + size / 2, cubeCenterY - size / 2, cubeCenterZ + size / 2);
                    MyPoint p7 = new MyPoint(cubeCenterX + size / 2, cubeCenterY + size / 2, cubeCenterZ - size / 2);
                    MyPoint p8 = new MyPoint(cubeCenterX + size / 2, cubeCenterY + size / 2, cubeCenterZ + size / 2);

                    MyPoligon polyRed = new MyPoligon(Color.RED, p5, p6, p8, p7);
                    MyPoligon polyWhite = new MyPoligon(Color.WHITE, p2, p4, p8, p6);
                    MyPoligon polyBlue = new MyPoligon(Color.BLUE, p3, p4, p8, p7);
                    MyPoligon polyGreen = new MyPoligon(Color.GREEN, p1, p2, p6, p5);
                    MyPoligon polyOrange = new MyPoligon(Color.ORANGE, p1, p2, p4, p3);
                    MyPoligon polyYellow = new MyPoligon(Color.YELLOW, p1, p3, p7, p5);

                    Tetraedron tetra = new Tetraedron(polyRed, polyWhite, polyBlue, polyGreen, polyOrange, polyYellow);
                    tetras.add(tetra);
                }
            }
        }
       

        return new Entity(tetras);
    }

    public static final int SIZE = 10;


    public static IEntity createParcel(String ID, double centerX, double centerY, double centerZ, int x, int y, int z){
        
        Color color;
       

        if (ID.equals("A")) {
            color = Color.BLUE;
        } else if(ID.equals("B")){
            color = Color.GREEN;
        } else if(ID.equals("C")){
            color = Color.MAGENTA;
        }else if(ID.equals("CONTAINER")){
            color = new Color(20,20,20,50);
        }else{
            color = null;
        }

        MyPoint p1 = new MyPoint(centerX   + SIZE/2 * x, centerY   - SIZE/2 * y, centerZ  - SIZE/2 * z);
        MyPoint p2 = new MyPoint(centerX   + SIZE/2 * x, centerY   + SIZE/2 * y, centerZ  - SIZE/2 * z);
        MyPoint p3 = new MyPoint(centerX   + SIZE/2 * x, centerY   + SIZE/2 * y, centerZ  + SIZE/2 * z);
        MyPoint p4 = new MyPoint(centerX   + SIZE/2 * x, centerY   - SIZE/2 * y, centerZ  + SIZE/2 * z);
        MyPoint p5 = new MyPoint(centerX   - SIZE/2 * x, centerY   - SIZE/2 * y, centerZ  - SIZE/2 * z);
        MyPoint p6 = new MyPoint(centerX   - SIZE/2 * x, centerY   + SIZE/2 * y, centerZ  - SIZE/2 * z);
        MyPoint p7 = new MyPoint(centerX   - SIZE/2 * x, centerY   + SIZE/2 * y, centerZ  + SIZE/2 * z);
        MyPoint p8 = new MyPoint(centerX   - SIZE/2 * x, centerY   - SIZE/2 * y, centerZ  + SIZE/2 * z);

        Tetraedron tetra = new Tetraedron(color,
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

    public static IEntity createPentomino(String ID, int rotation, double centerX, double centerY, double centerZ){
        
        ArrayList<Tetraedron> tetras = new ArrayList<Tetraedron>();
        Color color;
        double cubeSpacing = 10;
        int size = 100;

        if (ID.equals("P")) {
            color = Color.BLUE;


            double cubeCenterZ = -1 * (size + cubeSpacing) + centerZ;

            for (int i = -1; i < 2; i++) {
                double cubeCenterX = i * (size + cubeSpacing) + centerX;
                for (int j = -1; j < 1; j++) {
                    double cubeCenterY = j * (size + cubeSpacing) + centerY;


                    if(i == 1 && j == -1) continue;
    

                    MyPoint p1 = new MyPoint(cubeCenterX - size / 2, cubeCenterY - size / 2, cubeCenterZ - size / 2);
                    MyPoint p2 = new MyPoint(cubeCenterX - size / 2, cubeCenterY - size / 2, cubeCenterZ + size / 2);
                    MyPoint p3 = new MyPoint(cubeCenterX - size / 2, cubeCenterY + size / 2, cubeCenterZ - size / 2);
                    MyPoint p4 = new MyPoint(cubeCenterX - size / 2, cubeCenterY + size / 2, cubeCenterZ + size / 2);
                    MyPoint p5 = new MyPoint(cubeCenterX + size / 2, cubeCenterY - size / 2, cubeCenterZ - size / 2);
                    MyPoint p6 = new MyPoint(cubeCenterX + size / 2, cubeCenterY - size / 2, cubeCenterZ + size / 2);
                    MyPoint p7 = new MyPoint(cubeCenterX + size / 2, cubeCenterY + size / 2, cubeCenterZ - size / 2);
                    MyPoint p8 = new MyPoint(cubeCenterX + size / 2, cubeCenterY + size / 2, cubeCenterZ + size / 2);

                    MyPoligon polyRed = new MyPoligon(color, p5, p6, p8, p7);
                    MyPoligon polyWhite = new MyPoligon(color, p2, p4, p8, p6);
                    MyPoligon polyBlue = new MyPoligon(color, p3, p4, p8, p7);
                    MyPoligon polyGreen = new MyPoligon(color, p1, p2, p6, p5);
                    MyPoligon polyOrange = new MyPoligon(color, p1, p2, p4, p3);
                    MyPoligon polyYellow = new MyPoligon(color, p1, p3, p7, p5);

                    Tetraedron tetra = new Tetraedron(color, true, polyRed, polyWhite, polyBlue, polyGreen, polyOrange, polyYellow);
                    tetras.add(tetra);
                }
            }
            

        } else if(ID.equals("L")){
            color = Color.GREEN;

            double cubeCenterZ = -1 * (size + cubeSpacing) + centerZ;

            for (int i = -1; i < 3; i++) {
                double cubeCenterX = i * (size + cubeSpacing) + centerX;
                for (int j = -1; j < 1; j++) {
                    double cubeCenterY = j * (size + cubeSpacing) + centerY;


                    if(i == -1 && j == -1) continue;
                    if(i == 1 && j == -1) continue;
                    if(i == 0 && j == -1) continue;
    

                    MyPoint p1 = new MyPoint(cubeCenterX - size / 2, cubeCenterY - size / 2, cubeCenterZ - size / 2);
                    MyPoint p2 = new MyPoint(cubeCenterX - size / 2, cubeCenterY - size / 2, cubeCenterZ + size / 2);
                    MyPoint p3 = new MyPoint(cubeCenterX - size / 2, cubeCenterY + size / 2, cubeCenterZ - size / 2);
                    MyPoint p4 = new MyPoint(cubeCenterX - size / 2, cubeCenterY + size / 2, cubeCenterZ + size / 2);
                    MyPoint p5 = new MyPoint(cubeCenterX + size / 2, cubeCenterY - size / 2, cubeCenterZ - size / 2);
                    MyPoint p6 = new MyPoint(cubeCenterX + size / 2, cubeCenterY - size / 2, cubeCenterZ + size / 2);
                    MyPoint p7 = new MyPoint(cubeCenterX + size / 2, cubeCenterY + size / 2, cubeCenterZ - size / 2);
                    MyPoint p8 = new MyPoint(cubeCenterX + size / 2, cubeCenterY + size / 2, cubeCenterZ + size / 2);

                    MyPoligon polyRed = new MyPoligon(color, p5, p6, p8, p7);
                    MyPoligon polyWhite = new MyPoligon(color, p2, p4, p8, p6);
                    MyPoligon polyBlue = new MyPoligon(color, p3, p4, p8, p7);
                    MyPoligon polyGreen = new MyPoligon(color, p1, p2, p6, p5);
                    MyPoligon polyOrange = new MyPoligon(color, p1, p2, p4, p3);
                    MyPoligon polyYellow = new MyPoligon(color, p1, p3, p7, p5);

                    Tetraedron tetra = new Tetraedron(color, true, polyRed, polyWhite, polyBlue, polyGreen, polyOrange, polyYellow);
                    tetras.add(tetra);
                }
            }
            
        } else if(ID.equals("T")){
            color = Color.MAGENTA;

            double cubeCenterZ = -1 * (size + cubeSpacing) + centerZ;

            for (int i = -1; i < 2; i++) {
                double cubeCenterX = i * (size + cubeSpacing) + centerX;
                for (int j = -1; j < 2; j++) {
                    double cubeCenterY = j * (size + cubeSpacing) + centerY;


                    if(i == -1 && j == 0) continue;
                    if(i == 1 && j == 0) continue;
                    if(i == 1 && j == 1) continue;
                    if(i == -1 && j == 1) continue;

                    MyPoint p1 = new MyPoint(cubeCenterX - size / 2, cubeCenterY - size / 2, cubeCenterZ - size / 2);
                    MyPoint p2 = new MyPoint(cubeCenterX - size / 2, cubeCenterY - size / 2, cubeCenterZ + size / 2);
                    MyPoint p3 = new MyPoint(cubeCenterX - size / 2, cubeCenterY + size / 2, cubeCenterZ - size / 2);
                    MyPoint p4 = new MyPoint(cubeCenterX - size / 2, cubeCenterY + size / 2, cubeCenterZ + size / 2);
                    MyPoint p5 = new MyPoint(cubeCenterX + size / 2, cubeCenterY - size / 2, cubeCenterZ - size / 2);
                    MyPoint p6 = new MyPoint(cubeCenterX + size / 2, cubeCenterY - size / 2, cubeCenterZ + size / 2);
                    MyPoint p7 = new MyPoint(cubeCenterX + size / 2, cubeCenterY + size / 2, cubeCenterZ - size / 2);
                    MyPoint p8 = new MyPoint(cubeCenterX + size / 2, cubeCenterY + size / 2, cubeCenterZ + size / 2);

                    MyPoligon polyRed = new MyPoligon(color, p5, p6, p8, p7);
                    MyPoligon polyWhite = new MyPoligon(color, p2, p4, p8, p6);
                    MyPoligon polyBlue = new MyPoligon(color, p3, p4, p8, p7);
                    MyPoligon polyGreen = new MyPoligon(color, p1, p2, p6, p5);
                    MyPoligon polyOrange = new MyPoligon(color, p1, p2, p4, p3);
                    MyPoligon polyYellow = new MyPoligon(color, p1, p3, p7, p5);

                    Tetraedron tetra = new Tetraedron(color, true, polyRed, polyWhite, polyBlue, polyGreen, polyOrange, polyYellow);
                    tetras.add(tetra);
                }
            }
            
        }else{
            color = null;
        }


        return new Entity(tetras);
    }
}
