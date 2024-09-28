package Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouseHandler implements MouseListener {
    GamePanel G;
    public mouseHandler(GamePanel G){
        this.G = G;
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        // This method is triggered when a mouse button has been clicked (pressed and released).
        System.out.println("Mouse clicked at X: " + mouseEvent.getX() + " Y: " + mouseEvent.getY());
        G.HandleMouseClick(mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
}

