/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package timerytransformaciones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author andra
 */
public class Lienzo extends JPanel implements KeyListener {
    private Rectangle2D r;
    private double lado, xOriginalFrame, yOriginalFrame;
    private boolean ar,ab,izq,der;
    
    public Lienzo(){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.lightGray);
        this.addKeyListener(this);
        this.setFocusable(true);
        lado=50;
        xOriginalFrame=500;
        yOriginalFrame=500;
        r = new Rectangle2D.Double(xOriginalFrame/2-lado/2,yOriginalFrame/2-lado/2,lado,lado);
        Timer t = new Timer(10,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ar){
                    r.setFrame(r.getX(),r.getY()-5,r.getWidth(),r.getHeight());
                    if(r.getY()==0){
                        ar=false;
                        ab=true;
                    }
                }
                if(ab){
                    r.setFrame(r.getX(),r.getY()+5,r.getWidth(),r.getHeight());
                    if(r.getY()+lado==getHeight()){
                        ab=false;
                        ar=true;
                    }
                }if(izq){
                    r.setFrame(r.getX()-5,r.getY(),r.getWidth(),r.getHeight());
                    if(r.getX()==0){
                        izq=false;
                        der=true;
                    }
                }if(der){
                    r.setFrame(r.getX()+5,r.getY(),r.getWidth(),r.getHeight());
                    if(r.getX()+lado==getWidth()){
                        der=false;
                        izq=true;
                    }
                }
                
                
                repaint();
            }
            
        });
        t.start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.draw(r);
        getHeight();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            ar=true;
            ab=false;
            izq=false;
            der=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){ 
            ab=true;
            ar=false;
            izq=false;
            der=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){ 
            izq=true;
            ab=false;
            ar=false;
            der=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            der=true;
            ab=false;
            izq=false;
            ar=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
