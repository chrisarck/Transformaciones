/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package timerytransformaciones;

import javax.swing.JFrame;

/**
 *
 * @author andra
 */
public class TimeryTransformaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here     
        JFrame f = new JFrame();
        Lienzo l = new Lienzo();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(l);
        f.pack();
        f.setVisible(true);
        
        
    }
    
}
