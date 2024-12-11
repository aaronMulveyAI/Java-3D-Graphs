package render.entity.builder;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import render.shapes.MyPoligon;
import render.shapes.Tetraedron;

public class Entity implements IEntity {

    private List<Tetraedron> tetraedrons;
    private MyPoligon[] polygons;

    public Entity(List<Tetraedron> tetraedrons){
        this.tetraedrons = tetraedrons;
        List<MyPoligon> tempList = new ArrayList<MyPoligon>();
        for (Tetraedron tetra : tetraedrons) {
            tempList.addAll(Arrays.asList(tetra.getPoligons()));
        }
        this.polygons = new MyPoligon[tempList.size()];
        this.polygons = tempList.toArray(this.polygons);
        this.sortPoligons();
    }

    @Override
    public void render(Graphics g) {
        // TODO Auto-generated method stub
        for (MyPoligon tetra : this.polygons) {
            tetra.render(g);
        }
        this.sortPoligons();
    }

    @Override
    public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees) {
        // TODO Auto-generated method stub
        for (Tetraedron tetra : tetraedrons) {
            tetra.rotate(CW, xDegrees, yDegrees, zDegrees);
        }
    }
    
    private void sortPoligons(){
        MyPoligon.sortPoligons(this.polygons);
    }
}
