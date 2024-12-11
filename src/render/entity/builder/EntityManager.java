package render.entity.builder;

import java.util.ArrayList;

import render.input.ClickType;
import render.input.Mouse;
import render.point.PointConverter;
import render.shapes.Tetraedron;
import java.awt.*;

public class EntityManager {
    
    ArrayList<IEntity> entities;
    Tetraedron tetra;
    Mouse mouse;
    ClickType previousMouse = ClickType.Unknow;
    int initialX, initialY;
    double mouseSensitivity = 2.5;

    public EntityManager(){
        this.entities = new ArrayList<IEntity>();
    }

    public void init(){ 
        
        //this.entities.add(BasicEntityBuilder.createDiamond(Color.BLUE, 100, 10, 10, 10)); 
        //this.entities.add(BasicEntityBuilder.createColorCube(Color.DARK_GRAY, 100, 10, 10, 10)); 
        //this.entities.add(ComplexEntityBuilder.createRubiksCube(Color.BLUE, 100, 10, 10, 10));
        //this.entities.add(ComplexEntityBuilder.createParcel("A", 0, 10, 10,2,2,4));
        //this.entities.add(ComplexEntityBuilder.createParcel("CONTAINER", 10, 10, 10, 33, 5, 8));
        //this.entities.add(ComplexEntityBuilder.createParcel("A", 165, 25, 30, 2, 2, 4));
        //this.entities.add(ComplexEntityBuilder.createParcel("B", 100, 25, 30, 2, 2, 4));
        this.entities.add(ComplexEntityBuilder.createPentomino("P", 1, 105, 300, 10));
        //this.entities.add(ComplexEntityBuilder.createPentomino("L", 200, 25, 30, 100));
        //this.entities.add(ComplexEntityBuilder.createPentomino("T", 300, -125, -330, mouseSensitivity));
        
    }

    public void update(Mouse mouse){
        
        int x = mouse.getX();
        int y = mouse.getY();

        if (mouse.getButtom() == ClickType.leftClick) {

            int xDif = x - initialX;
            int yDif = y - initialY;

            this.rotate(true, 0, -yDif/mouseSensitivity, -xDif/mouseSensitivity);

        }

        if (mouse.getButtom() == ClickType.RightClick) {

            int xDif = x - initialX;

            this.rotate(true, -xDif/mouseSensitivity, 0, 0);

        }

        if (mouse.isScrollingUp()) {
            PointConverter.zoomIn();

        }else if(mouse.isScrollingDown()){
            PointConverter.zoomOut();
        }

        mouse.resetScroll();
        
        //this.rotate(true, 1, 1, 1);
        initialX = x;
        initialY = y;

        //System.out.println(mouse.getX() + " " + mouse.getY());

        
    }

    public void render(Graphics g){
        for (IEntity entity : entities) {
            entity.render(g);
        }
    }

    private void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees){
        for (IEntity entity : this.entities) {
            entity.rotate(CW, xDegrees, yDegrees, zDegrees);
        }
    }
}
