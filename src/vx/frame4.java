package vx;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class frame4 extends JFrame {
    private JTextPane jTextPane1 = new JTextPane();
    private String textMolA = "��� ������,\n" + 
    "� ����� � ��������� ���������,\n" + 
    "�� ��������� ����,\n" + 
    "������ ��� �����, ������� �����,\n" + 
    "������� ������� �����, ��� ������� �� ����.";
    
    private String textMolS = "��� ������,\n" + 
    "� ����� � ��������� ���������,\n" + 
    "�� ��������� ����,\n" + 
    "��� ���� ����������,\n" + 
    "������� ��� ����� � ���� �����.";
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
