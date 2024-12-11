package render.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;


import java.awt.event.MouseWheelEvent;

public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener{
    
    public int mouseX = -1;
    public int mouseY = -1;
    public int mouseB = -1;
    public int scroll = -1;

    public int getX(){
        return mouseX;
    }

    public int getY(){
        return mouseY;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        // TODO Auto-generated method stub
        scroll = e.getWheelRotation();

    }

    public boolean isScrollingUp(){
        return this.scroll == -1;
    }

    public boolean isScrollingDown(){
        return this.scroll == 1;
    }

    public void resetScroll(){
        this.scroll = 0;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

        this.mouseX = e.getX();
        this.mouseY = e.getY();

       
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        this.mouseX = e.getX();
        this.mouseY = e.getY();

    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        this.mouseB = e.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        this.mouseB = -1;
    }

    public void resetButtom(){
        this.mouseB = -1;
    }

    public ClickType getButtom(){
        switch (this.mouseB) {
            case 1:
                return ClickType.leftClick;
            case 2:
                return ClickType.ScrollClick;    
            case 3:
                return ClickType.RightClick;
            case 4:
                return ClickType.BackClick;
            case 5:
                return ClickType.ForwardPage;
            default:
                return ClickType.Unknow;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
public void keyPressed(KeyEvent e) {
    
    switch (e.getKeyCode()) {
        case KeyEvent.VK_W: // Tecla W
            this.scroll = -1; // Simula un desplazamiento hacia arriba
            break;
        case KeyEvent.VK_S: // Tecla S
            this.scroll = 1; // Simula un desplazamiento hacia abajo
            break;
        default:
            break;
    }
}

@Override
public void keyReleased(KeyEvent e) {
    // Al liberar la tecla, reseteamos el scroll
    if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
        resetScroll();
    }
}



}
