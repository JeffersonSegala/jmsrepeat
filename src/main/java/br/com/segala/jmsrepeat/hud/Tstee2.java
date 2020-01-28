package br.com.segala.jmsrepeat.hud;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Window;
import java.util.Timer;
import java.util.TimerTask;

public class Tstee2 {
    
    private static int times = 0;

    public static void main(String[] args) throws Exception {
        final Window w = new Window(null) {
            private static final long serialVersionUID = 1L;

            @Override
            public void paint(Graphics g) {                
                
                final Font font = getFont().deriveFont(12f);
                g.setFont(font);
                g.setColor(Color.BLACK);
                final String message = "REC";
                FontMetrics metrics = g.getFontMetrics();
                
                int s = 10;
                int pX = Double.valueOf(MouseInfo.getPointerInfo().getLocation().getX()).intValue() - (metrics.stringWidth(message)/2);
                int pY = Double.valueOf(MouseInfo.getPointerInfo().getLocation().getY()).intValue() + s + 20;
                
                g.drawString(message,
                        pX,
                        pY);
                
                if (times < 50) {
                    g.setColor(Color.RED);
                    g.fillOval(
                    pX-s,
                    pY-s, 
                    s, s);                    
                } else if (times > 100) {
                    times = 0;
                }
                System.out.println(pX + " - "+ pY);
                times++;
            }

            @Override
            public void update(Graphics g) {
                paint(g);
            }
        };
        w.setAlwaysOnTop(true);
        w.setBounds(w.getGraphicsConfiguration().getBounds());
        w.setBackground(new Color(0, true));
        com.sun.awt.AWTUtilities.setWindowOpaque(w, false);
        w.setVisible(true);
        
        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
               w.repaint();
            }
        },0,17);
    }
    
}
