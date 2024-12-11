package render;
/**
 * Display
 */
import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import javax.swing.*;

import render.entity.builder.EntityManager;
import render.input.Mouse;
import render.shapes.Tetraedron;

import java.awt.*;


public class Display extends Canvas implements Runnable{

    private Thread thread;
    private JFrame frame;
    private static String title = "3D Render";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private static boolean runing = false;
    public Tetraedron tetra;
    private Mouse mouse;
    private EntityManager entityManager;


    public Display(){
        
        this.frame = new JFrame();
        Dimension size = new Dimension(WIDTH,HEIGHT);
        this.setPreferredSize(size);
        this.mouse = new Mouse();
        this.entityManager = new EntityManager();
        this.addMouseListener(this.mouse);
        this.addMouseMotionListener(this.mouse);
        this.addMouseWheelListener(this.mouse);
        this.addKeyListener(mouse);

    }

    public static void main(String[] args) {
        
        Display display = new Display();
        display.frame.setTitle(title);
        display.frame.add(display);
        display.frame.pack();
        display.frame.setSize(WIDTH, HEIGHT);
        display.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.frame.setLocationRelativeTo(null);
        display.frame.setResizable(false);
        display.frame.setVisible(true);

        display.start();
    }

    public synchronized void start(){
        runing = true;
        this.thread = new Thread(this, "Display");
        this.thread.start();
        
    }

    public synchronized void stop(){

        runing = false;

        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void run(){
        
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000/60;
        double delta = 0; 
        int frames = 0; 

        this.entityManager.init();

        while(runing){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
                render();
                frames++;
            }
            

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                this.frame.setTitle(title + " | " + frames + " fps.");
            }
        }
        stop();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
         
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        this.entityManager.render(g);

        g.dispose();
        bs.show();

    }
    
    private void update(){
        this.entityManager.update(this.mouse);
    }
}