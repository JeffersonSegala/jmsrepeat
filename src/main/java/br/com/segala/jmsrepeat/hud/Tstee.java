package br.com.segala.jmsrepeat.hud;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.prevayler.implementation.PrevaylerDirectory;

public class Tstee {
    
    private static final String PATH_NAME = "C:\\Java\\Prev";
    private static Date d = new Date();
    private static int times = 0;

    public static void main(String[] args) throws Exception {
//        Prevayler<Root> prevayler = PrevaylerFactory.createPrevayler(new Root(), PATH_NAME);
//        final Person person = prevayler.execute(new CreatePersonTransaction("002"));
//        Person queryResponse = prevayler.execute(new GetPerson("001"));
//        Person queryResponse2 = prevayler.execute(new GetPerson("002"));
//        prevayler.execute(new UpdatePersonNameTransaction("001", "Rodolfo"));
//        prevayler.execute(new UpdatePersonNameTransaction("002", "Rodolfo 4"));
        
        final Window w = new Window(null) {
            private static final long serialVersionUID = 1L;

            @Override
            public void paint(Graphics g) {                
                int s = 60;
                int pX = Double.valueOf(MouseInfo.getPointerInfo().getLocation().getX()).intValue();
                int pY = Double.valueOf(MouseInfo.getPointerInfo().getLocation().getY()).intValue();
                
                g.setColor(Color.GREEN);
                
//                g.drawOval(
//                        pX - s/2,
//                        pY - s/2, 
//                        s, s);
                
                if (times < 60) {
                    times++;
                    times++;
                    g.drawOval(
                            pX - (s-times)/2,
                            pY - (s-times)/2,
                            s-times, s-times);
                } else {
                    times = 0;
                }
                
                final Font font = getFont().deriveFont(12f);
                g.setFont(font);
                g.setColor(Color.BLACK);
                final String message = "Recording";
                FontMetrics metrics = g.getFontMetrics();
                g.drawString(message,
                        (pX - (metrics.stringWidth(message)/2)),
                        pY + s/2 + 1);
            }

            @Override
            public void update(Graphics g) {
                paint(g);
            }
        };
        w.setAlwaysOnTop(true);
        w.setBounds(w.getGraphicsConfiguration().getBounds());
//        w.setBounds(new Rectangle(600, 600));
        w.setBackground(new Color(0, true));
        com.sun.awt.AWTUtilities.setWindowOpaque(w, false);
        w.setVisible(true);
        
        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
               d = new Date();
               w.repaint();
               w.validate();
            }
        },0,17);
//        
//        prevayler.takeSnapshot();
//        cleanUp();
    }
    
    private static void cleanUp( ) throws IOException {
        File dir = new File(PATH_NAME);
        Set<File> necessaryFiles = new PrevaylerDirectory(PATH_NAME).necessaryFiles();
        File[] listFiles = dir.listFiles();
        for (File file : listFiles) {
            if (!necessaryFiles.contains(file)) {
                System.out.println("Deleting "+file.getName());
                file.delete();
            }
        }
        
    }
}
