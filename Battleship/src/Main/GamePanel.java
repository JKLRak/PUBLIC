package Main;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GamePanel extends JPanel {
    final int originalTileSize = 16;
    final int scale = 5;
    final int TileSize = originalTileSize * scale;
    final int maxScreenCol = 10;
    final int maxScreenRow = 10;
    final int ScreenWidth = maxScreenCol * TileSize;
    final int ScreenHeight = maxScreenRow * TileSize;
    private Image imageGray;
    private Image imageRed;
    private Image imageWhite;
    Board B;
    GameLogic G;
    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight) );
        this.setBackground(Color.pink);
        this.setDoubleBuffered(true);
        this.G = new GameLogic();
        this.B = new Board(G);
        loadImages();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i = 0; i < maxScreenRow; i++) {
            for (int j = 0; j < maxScreenCol; j++) {
                if(B.getTile(i,j) == TileState.STATE_UNGUESSED) {
                    g.drawImage(imageGray, i * TileSize, j * TileSize, TileSize, TileSize, this);
                }
                else if(B.getTile(i,j) == TileState.STATE_SHIP) {
                    g.drawImage(imageRed, i * TileSize, j * TileSize, TileSize, TileSize, this);
                }
                else if(B.getTile(i,j) == TileState.STATE_EMPTY){
                    g.drawImage(imageWhite, i * TileSize, j * TileSize, TileSize, TileSize, this);
                }
                else{
                    System.out.println("ERROR");
                }
            }
        }
    }

    private void loadImages() {
        // Use getResource to load images from the classpath
        imageGray = loadImage("/res/gray.png");
        imageWhite = loadImage("/res/white.png");
        imageRed = loadImage("/res/red.png");
        // Optionally load other images similarly
    }

    private Image loadImage(String path) {
        // Load the image from the classpath
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL).getImage();
        } else {
            System.out.println("Image resource not found: " + path);
            return null;
        }
    }
    public void HandleMouseClick(int x, int y){
        int i = x  / TileSize;
        int j = y / TileSize;
        System.out.println(i + " " + j);
        B.Click(i,j);
        repaint();
    }
}
