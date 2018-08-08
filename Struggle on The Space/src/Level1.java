
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



class Shot{
    private int x;
    private int y;

    public Shot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}

public class Level1 extends JPanel implements KeyListener,ActionListener{

    
    Timer timer = new Timer(5, this);
    
    private int passingTime = 0;
    private int spentShot = 0;
    private BufferedImage image;
    ArrayList<Shot> shots = new ArrayList<Shot>();
    private int shotAddX = 1;
    private int ballX = 0;
    private int ballAddX = 2;
    private int spacecraftX = 0;
    private int spacecraftAddX = 20;
    
    
    public boolean controlGame(){
        for(Shot shot : shots){
            if(new Rectangle(shot.getX(),shot.getY(),10,20).intersects(new Rectangle(ballX,0,20,20))){
                return true;
            }
        }
        return false;
    }
    
    public Level1(){
        try {
            image = ImageIO.read(new FileImageInputStream(new File("spaceCraft.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setBackground(Color.WHITE);
        timer.start();
        
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        passingTime += 5;
        
        g.setColor(Color.red);
        g.fillOval(ballX, 0, 30, 30);
        
        g.drawImage(image, spacecraftX, 470,image.getWidth()/10,image.getHeight()/10,this);
        
        for(Shot shot : shots){
            if (shot.getY() < 0) {
                shots.remove(shot);
            }
        }
        
        g.setColor(Color.yellow);
        
        for(Shot shot : shots){
            g.fillRect(shot.getX(), shot.getY(), 10, 20);
        }
        
        if(controlGame()){
            try {
                timer.stop();
                String message = "You Win!\n"
                        + "Spent Shot : " + spentShot
                        + "\nThe Passing Time : " + passingTime/1000.0+" second";
                
                //JOptionPane.showMessageDialog(this, message);
                Thread thread = new Thread();
                thread.sleep(3000);
                System.exit(0);
            } catch (InterruptedException ex) {
                Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }
    
    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        
        if(c == KeyEvent.VK_LEFT){
            if(spacecraftX <= 0){
                spacecraftX = 0;
            }
            else{
                spacecraftX -= spacecraftAddX;
            }
        }
        else if(c == KeyEvent.VK_RIGHT){
            if(spacecraftX >= 750){
                spacecraftX = 750;
            }
            else{
                spacecraftX += spacecraftAddX;
            }
        }
        else if(c == KeyEvent.VK_CONTROL){
            shots.add(new Shot(spacecraftX, 470));
            spentShot++;
            
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         for(Shot shot : shots){
            shot.setY(shot.getY()-shotAddX);
        }
        ballX += ballAddX;
        
        if (ballX >= 750) {
            ballAddX = -ballAddX;
            
        }
        if (ballX <= 0) {
            ballAddX = -ballAddX;
        }
        
        
        repaint();
        
    }
    
}