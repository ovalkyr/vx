package vx;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class frame4 extends JFrame {
    private JTextPane jTextPane1 = new JTextPane();
    private String textMolA = "Дух Машины,\n" + 
    "С верой и почтением обращаюсь,\n" + 
    "Со смирением молю,\n" + 
    "Открой мне глаза, проясни разум,\n" + 
    "Дозволь увидеть тайну, что сокрыта до поры.";
    
    private String textMolS = "Дух Машины,\n" + 
    "С верой и почтением обращаюсь,\n" + 
    "Со смирением молю,\n" + 
    "Яви свое могущество,\n" + 
    "Соедини две части в одно целое.";
    public frame4() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize( new Dimension(400, 300) );
        jTextPane1.setBounds(new Rectangle(25, 25, 345, 215));
        this.getContentPane().add(jTextPane1, null);
        jTextPane1.setText(textMolA);
    }
}
