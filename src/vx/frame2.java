package vx;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.text.PlainDocument;
import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.util.ContentConverter;


public class frame2 extends JFrame {
    private JButton jButton1 = new JButton();
    private JTextArea jTextArea1 = new JTextArea();
    private JButton jButton2 = new JButton();
    private JFileChooser JFileChooser1 = new JFileChooser();
    private BufferedImage image1;
    private BufferedImage image2;
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JLabel jLabel2 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private JTextField jTextField3 = new JTextField();
    private JTextField jTextField4 = new JTextField();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel6 = new JLabel();
    private JLabel jLabel7 = new JLabel();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JTextPane jTextPane1 = new JTextPane();
    private JButton jButton3 = new JButton();
    private JTextArea jTextArea2 = new JTextArea();
    private JLabel jLabel8 = new JLabel();
    private JLabel jLabel9 = new JLabel();
    private JTextField jTextField5 = new JTextField();
    private JTextField jTextField6 = new JTextField();
    private JTextField jTextField7 = new JTextField();
    private JTextField jTextField8 = new JTextField();
    private JLabel jLabel10 = new JLabel();
    private JLabel jLabel11 = new JLabel();
    private JLabel jLabel12 = new JLabel();
    private JLabel jLabel13 = new JLabel();
    private JCheckBox jCheckBox1 = new JCheckBox();
    private JCheckBox jCheckBox2 = new JCheckBox();
    private JPasswordField jPasswordField1 = new JPasswordField();
    private JPasswordField jPasswordField2 = new JPasswordField();

    public frame2() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        this.setSize(new Dimension(786, 407));
        this.setForeground(new Color(247, 247, 247));
        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                this_windowOpened(e);
            }
        });
        jButton1.setText("Молитва...");
        jButton1.setBounds(new Rectangle(210, 340, 175, 25));
        jButton1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton1_actionPerformed(e);
            }
        });
        jTextArea1.setBounds(new Rectangle(20, 10, 365, 25));
        jTextArea1.setText("");
        jTextArea1.setFont(new Font("Tahoma", 0, 14));
        jTextArea1.setBorder(BorderFactory.createLineBorder(SystemColor.windowText, 1));
        jTextArea1.setEditable(false);
        jButton2.setText("\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c \u043e\u0431\u0440\u0430\u0437\u0435\u0446 \u21161");
        jButton2.setBounds(new Rectangle(200, 40, 185, 25));
        jButton2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton2_actionPerformed(e);
            }
        });
        JFileChooser1.setFileFilter(new ImageFileFilter());
        jScrollPane1.setBounds(new Rectangle(20, 65, 365, 200));
        jScrollPane1.setBorder(BorderFactory.createLineBorder(SystemColor.windowText, 1));
        jLabel2.setText("\u043a\u0430\u0440\u0442\u0438\u043d\u043a\u0430 1");
        jLabel2.setVerticalAlignment(SwingConstants.TOP);
        jLabel2.setVerticalTextPosition(SwingConstants.TOP);
        jLabel2.setAutoscrolls(true);
        //дата время анализа
        jTextField1.setBounds(new Rectangle(220, 315, 35, 20));
        jTextField1.setBackground(new Color(214, 247, 255));
        jTextField2.setBounds(new Rectangle(260, 315, 35, 20));
        jTextField2.setBackground(new Color(214, 247, 255));
        jTextField3.setBounds(new Rectangle(300, 315, 35, 20));
        jTextField3.setBackground(new Color(214, 247, 255));
        jTextField4.setBounds(new Rectangle(340, 315, 35, 20));
        jTextField4.setBackground(new Color(214, 247, 255));
        jTextField4.setText("00");
        jLabel1.setBounds(new Rectangle(20, 340, 190, 25));
        jLabel1.setBorder(BorderFactory.createLineBorder(SystemColor.windowText, 1));
        jLabel3.setText("DD31");
        jLabel3.setBounds(new Rectangle(220, 295, 40, 20));
        jLabel3.setLabelFor(jTextField1);
        jLabel4.setText("HH24");
        jLabel4.setBounds(new Rectangle(260, 295, 35, 20));
        jLabel4.setLabelFor(jTextField2);
        jLabel5.setText("MI60");
        jLabel5.setBounds(new Rectangle(300, 295, 35, 20));
        jLabel6.setText("SS60");
        jLabel6.setBounds(new Rectangle(340, 295, 35, 20));
        jLabel7.setText("\u0414\u0430\u0442\u0430, \u0432\u0440\u0435\u043c\u044f \u0432\u0437\u044f\u0442\u0438\u044f \u043e\u0431\u0440\u0430\u0437\u0446\u0430 1");
        jLabel7.setBounds(new Rectangle(45, 305, 155, 35));
        jScrollPane2.setBounds(new Rectangle(395, 65, 365, 200));
        jScrollPane2.setBorder(BorderFactory.createLineBorder(SystemColor.windowText, 1));
        jTextPane1.setBounds(new Rectangle(395, 340, 365, 25));
        jTextPane1.setBorder(BorderFactory.createLineBorder(SystemColor.windowText, 1));
        jTextPane1.setFont(new Font("Garamond", 0, 16));
        jTextPane1.setEditable(false);
        jButton3.setText("\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c \u043e\u0431\u0440\u0430\u0437\u0435\u0446 \u21162");
        jButton3.setBounds(new Rectangle(395, 40, 185, 25));
        jButton3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton3_actionPerformed(e);
            }
        });
        jTextArea2.setBounds(new Rectangle(395, 10, 365, 25));
        jTextArea2.setText("");
        jTextArea2.setFont(new Font("Tahoma", 0, 14));
        jTextArea2.setBorder(BorderFactory.createLineBorder(SystemColor.windowText, 1));
        jTextArea2.setLineWrap(true);
        jTextArea2.setEditable(false);
        JFileChooser1.setLocation(300, 200);

        this.getContentPane().add(jPasswordField2, null);
        this.getContentPane().add(jPasswordField1, null);
        this.getContentPane().add(jCheckBox2, null);
        this.getContentPane().add(jCheckBox1, null);
        this.getContentPane().add(jLabel13, null);
        this.getContentPane().add(jLabel12, null);
        this.getContentPane().add(jLabel11, null);
        this.getContentPane().add(jLabel10, null);
        this.getContentPane().add(jTextField8, null);
        this.getContentPane().add(jTextField7, null);
        this.getContentPane().add(jTextField6, null);
        this.getContentPane().add(jTextField5, null);
        this.getContentPane().add(jLabel9, null);
        this.getContentPane().add(jTextArea2, null);
        this.getContentPane().add(jButton3, null);
        this.getContentPane().add(jTextPane1, null);
        jScrollPane2.getViewport().add(jLabel8, null);
        this.getContentPane().add(jScrollPane2, null);
        this.getContentPane().add(jLabel7, null);
        this.getContentPane().add(jLabel6, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jTextField4, null);
        this.getContentPane().add(jTextField3, null);
        this.getContentPane().add(jTextField2, null);
        this.getContentPane().add(jTextField1, null);
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jTextArea1, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(JFileChooser1, null);
        jScrollPane1.getViewport().add(jLabel2, "jLabel2");
        this.getContentPane().add(jScrollPane1, null);
        jTextArea1.setDocument(new PlainDocument());
        jTextField1.setBackground(Color.LIGHT_GRAY);
        jTextField1.setText("10");
        jTextField1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                jTextField1_keyPressed(e);
            }
        });
        jTextField2.setBackground(Color.LIGHT_GRAY);
        jTextField2.setText("10");
        jTextField2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                jTextField2_keyPressed(e);
            }
        });
        jTextField3.setBackground(Color.LIGHT_GRAY);
        jTextField3.setText("10");
        jTextField3.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                jTextField3_keyPressed(e);
            }
        });
        jTextField4.setBackground(Color.LIGHT_GRAY);
        jTextField4.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                jTextField4_keyPressed(e);
            }
        });
        jTextArea2.setDocument(new PlainDocument());
        jLabel8.setText("\u043a\u0430\u0440\u0442\u0438\u043d\u043a\u0430 2");
        jLabel8.setVerticalTextPosition(SwingConstants.TOP);
        jLabel8.setVerticalAlignment(SwingConstants.TOP);
        jLabel9.setText("\u0414\u0430\u0442\u0430, \u0432\u0440\u0435\u043c\u044f \u0432\u0437\u044f\u0442\u0438\u044f \u043e\u0431\u0440\u0430\u0437\u0446\u0430 2");
        jLabel9.setBounds(new Rectangle(425, 305, 155, 35));
        jTextField5.setBounds(new Rectangle(595, 310, 35, 20));
        jTextField5.setBackground(new Color(214, 247, 255));
        jTextField5.setBackground(Color.LIGHT_GRAY);
        jTextField5.setText("10");
        jTextField5.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                jTextField5_keyPressed(e);
            }
        });
        jTextField6.setBounds(new Rectangle(635, 310, 35, 20));
        jTextField6.setBackground(new Color(214, 247, 255));
        jTextField6.setBackground(Color.LIGHT_GRAY);
        jTextField6.setText("10");
        jTextField6.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                jTextField6_keyPressed(e);
            }
        });
        jTextField7.setBounds(new Rectangle(675, 310, 35, 20));
        jTextField7.setBackground(new Color(214, 247, 255));
        jTextField7.setBackground(Color.LIGHT_GRAY);
        jTextField7.setText("10");
        jTextField7.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                jTextField7_keyPressed(e);
            }
        });
        jTextField8.setBounds(new Rectangle(715, 310, 35, 20));
        jTextField8.setBackground(new Color(214, 247, 255));
        jTextField8.setText("00");
        jTextField8.setBackground(Color.LIGHT_GRAY);
        jTextField8.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                jTextField8_keyPressed(e);
            }
        });
        jLabel10.setText("DD31");
        jLabel10.setBounds(new Rectangle(595, 290, 40, 20));
        jLabel10.setLabelFor(jTextField1);
        jLabel11.setText("HH24");
        jLabel11.setBounds(new Rectangle(635, 290, 35, 20));
        jLabel11.setLabelFor(jTextField2);
        jLabel12.setText("MI60");
        jLabel12.setBounds(new Rectangle(675, 290, 35, 20));
        jLabel13.setText("SS60");
        jLabel13.setBounds(new Rectangle(715, 290, 35, 20));
        jCheckBox1.setText("аварийный ввод");
        jCheckBox1.setBounds(new Rectangle(245, 270, 140, 20));
        jCheckBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                jCheckBox1_itemStateChanged(e);
            }
        });
        jCheckBox2.setText("аварийный ввод");
        jCheckBox2.setBounds(new Rectangle(640, 270, 120, 20));
        jCheckBox2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                jCheckBox2_itemStateChanged(e);
            }
        });
        jPasswordField1.setBounds(new Rectangle(20, 270, 205, 20));
        jPasswordField1.setEnabled(false);
        jPasswordField1.setBorder(BorderFactory.createLineBorder(SystemColor.windowText, 1));
        jPasswordField2.setBounds(new Rectangle(395, 270, 205, 20));
        jPasswordField2.setEnabled(false);
        jPasswordField2.setBorder(BorderFactory.createLineBorder(SystemColor.windowText, 1));
        //делаем невидимыми аварийные поля
        jPasswordField1.setVisible(false);
        jPasswordField2.setVisible(false);
        jCheckBox2.setVisible(false);
        jCheckBox1.setVisible(false);
    }
    //кнопка анализа степлера

    private void jButton1_actionPerformed(ActionEvent e) {
        if (jButton1.getText() != "Молитва...") {
            jButton1.setText("Молитва...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException f) {
            }
        //рисуем расход энергии сразу, для обновления

        try {
            jLabel1.setText(db2.getEnergyLevel("S"));

        } catch (Exception f) {
        }
        jTextPane1.setBackground(Color.WHITE);
        jTextPane1.setText("");
        //проверяем дату

        String r =
            checkDateFormat(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText());
        if (r == "OK") {
            jTextField1.setBackground(Color.LIGHT_GRAY);
            jTextField2.setBackground(Color.LIGHT_GRAY);
            jTextField3.setBackground(Color.LIGHT_GRAY);
            jTextField4.setBackground(Color.LIGHT_GRAY);
        } else {
            jTextPane1.setText("Хм..." + r);
            //красим поля в красный цвет
            jTextField1.setBackground(Color.RED);
            jTextField2.setBackground(Color.RED);
            jTextField3.setBackground(Color.RED);
            jTextField4.setBackground(Color.RED);
            //отваливаемся
            return;
        }
        r =
  checkDateFormat(jTextField5.getText(), jTextField6.getText(), jTextField7.getText(), jTextField8.getText());
        if (r == "OK") {
            jTextField5.setBackground(Color.LIGHT_GRAY);
            jTextField6.setBackground(Color.LIGHT_GRAY);
            jTextField7.setBackground(Color.LIGHT_GRAY);
            jTextField8.setBackground(Color.LIGHT_GRAY);
        } else {
            jTextPane1.setText("Хм..." + r);
            //красим поля в красный цвет
            jTextField5.setBackground(Color.RED);
            jTextField6.setBackground(Color.RED);
            jTextField7.setBackground(Color.RED);
            jTextField8.setBackground(Color.RED);
            //отваливаемся
            return;
        }

        // проверяем картинку
        String decodedString1 = "";
        String decodedString2 = "";

        if ((image1 != null) && (!jCheckBox1.isSelected())) {
            try {
                QRCodeDecoder decoder = new QRCodeDecoder();
                decodedString1 = new String(decoder.decode(new J2SEImage(image1)));
                decodedString1 = ContentConverter.convert(decodedString1);
                //проверяем есть ли в базе такой айдишник юзера
                String s;
                s = db2.checkQRcode(decodedString1);

                if (Integer.parseInt(s) > 0) {
                    jTextPane1.setText("Распознано...");
                } else {
                    jTextPane1.setText("Плохой образец слева. Не распознан...");
                    return;
                }
            } catch (Exception f) {
                jTextPane1.setText("Плохой образец слева. Не распознан...");
                return;
            }

        } else if ((jCheckBox1.isSelected())) {
            decodedString1 = jPasswordField1.getText();
            if (decodedString1.isEmpty()) {
                jTextPane1.setText("Не загружен образец...");
                return;
            }

        } else {
            jTextPane1.setText("Не загружен образец...");
            return;
            //  jTextPane1.setBackground(new java.awt.Color(255,0,0));
        }

        if ((image2 != null) && (!jCheckBox2.isSelected())) {
            try {
                String s;
                QRCodeDecoder decoder = new QRCodeDecoder();
                decodedString2 = new String(decoder.decode(new J2SEImage(image2)));
                decodedString2 = ContentConverter.convert(decodedString2);

                //проверяем есть ли в базе такой айдишник юзера
                s = db2.checkQRcode(decodedString2);

                if (Integer.parseInt(s) > 0) {
                    jTextPane1.setText("Распознано...");
                } else {
                    jTextPane1.setText("Плохой образец справа. Не распознан...");
                    return;
                }
            } catch (Exception f) {
                jTextPane1.setText("Плохой образец справа. Не распознан...");
                return;
            }

        } else if ((jCheckBox2.isSelected())) {
            decodedString2 = jPasswordField2.getText();
            if (decodedString2.isEmpty()) {
                jTextPane1.setText("Не загружен образец...");
                return;
            }

        } else {
            jTextPane1.setText("Не загружен образец...");
        }

        //обращаемся к базе
        String s;
        try {
            s = db2.stepler_main(decodedString1, decodedString2);

            //рисуем ответ
            jTextPane1.setText(s);
            if (s == "НЕТ")
                jTextPane1.setBackground(Color.RED);
            if (s == "ДА")
                jTextPane1.setBackground(Color.GREEN);

            //рисуем расход энергии
            jLabel1.setText(db2.getEnergyLevel("S"));


        } catch (Exception f) { //jTextPane1.setText("ошибка ..."+f.getMessage());
            jTextPane1.setText("НЕТ");
            jTextPane1.setBackground(Color.RED);
        }
        }
        else{
            jButton1.setText("Получить...");
       //     jTextPane1.setText(this.textMolS);
       JFrame frame1 = new frame5();
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       Dimension frameSize = frame1.getSize();
       if (frameSize.height > screenSize.height) {
           frameSize.height = screenSize.height;
       }
       if (frameSize.width > screenSize.width) {
           frameSize.width = screenSize.width;
       }
       frame1.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
       frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE   );// .DO_NOTHING_ON_CLOSE);// EXIT_ON_CLOSE);
       frame1.setVisible(true);
            
        }

    }

    //функция проверки даты
    private String checkDateFormat(String DD, String HH, String MI, String SS) {
        String resultMessage = "OK";

        if (DD.length() == 0) {
            resultMessage = "Не заполнен день...";
        } else if (HH.length() == 0) {
            resultMessage = "Не заполнен час...";
        } else if (MI.length() == 0) {
            resultMessage = "Не заполнены минуты...";
        } else if (SS.length() == 0) {
            resultMessage = "Не заполнены секунды...";
        } else if (Integer.valueOf(DD) > 31) {
            resultMessage = "" + "День > 31...";
        } else if (Integer.valueOf(HH) > 24) {
            resultMessage = "" + "Час > 24...";
        } else if (Integer.valueOf(MI) > 60) {
            resultMessage = "Минуты > 60...";
        } else if (Integer.valueOf(SS) > 60) {
            return "" + "Секунды > 60...";
        }

        return resultMessage;
    }


    //кнопка загрузки картинки

    private void jButton2_actionPerformed(ActionEvent e) {

        if (jButton2.getText() != "Очистить...") {

            JFileChooser1.showOpenDialog(this);
            File filename;
            filename = JFileChooser1.getSelectedFile();

            jTextArea1.setText(filename.getPath());

            try {
                image1 = ImageIO.read(filename);
            } catch (IOException f) {
            }

            jLabel2.setIcon(new ImageIcon(image1));
            jButton2.setText("Очистить...");
        } else {

            int h = jLabel2.getHeight();
            int w = jLabel2.getWidth();
            Graphics g = image1.getGraphics();
            g.setColor(this.getBackground());
            g.fillRect(0, 0, w, h);
            jLabel2.setIcon(new ImageIcon(image1));
            jTextArea1.setText("");
            jButton2.setText("Загрузить образец №1");
            jTextArea1.setText("");
        }
    }

    private void this_windowOpened(WindowEvent e) {
        try {
            jLabel1.setText(db2.getEnergyLevel("S"));
        } catch (Exception f) {
        }
    }


    private void jButton3_actionPerformed(ActionEvent e) {


        if (jButton3.getText() != "Очистить...") {
            JFileChooser1.showOpenDialog(this);
            File filename;
            filename = JFileChooser1.getSelectedFile();

            jTextArea2.setText(filename.getPath());

            try {
                image2 = ImageIO.read(filename);
            } catch (IOException f) {
            }

            jLabel8.setIcon(new ImageIcon(image2));
            jButton3.setText("Очистить...");
        } else {

            int h = jLabel8.getHeight();
            int w = jLabel8.getWidth();
            Graphics g = image2.getGraphics();
            g.setColor(this.getBackground());
            g.fillRect(0, 0, w, h);
            jLabel8.setIcon(new ImageIcon(image2));
            jButton3.setText("Загрузить образец №2");
            jTextArea2.setText("");
        }

    }

    private void jCheckBox1_itemStateChanged(ItemEvent e) {
        jPasswordField1.setText("");
        if (jCheckBox1.isSelected()) {
            jPasswordField1.setEnabled(true);
            jButton2.setEnabled(false);

        } else {
            jPasswordField1.setEnabled(false);
            jButton2.setEnabled(true);
        }
    }

    private void jCheckBox2_itemStateChanged(ItemEvent e) {
        jPasswordField2.setText("");
        if (jCheckBox2.isSelected()) {
            jPasswordField2.setEnabled(true);
            jButton3.setEnabled(false);

        } else {
            jPasswordField2.setEnabled(false);
            jButton3.setEnabled(true);
        }
    }

    private void jTextField1_keyPressed(KeyEvent e) {
        if (jTextField1.getText().length() > 2) {
            jTextField1.setText("00");
        }
    }

    private void jTextField2_keyPressed(KeyEvent e) {
        if (jTextField2.getText().length() > 2) {
            jTextField2.setText("00");
        }
    }

    private void jTextField3_keyPressed(KeyEvent e) {
        if (jTextField3.getText().length() > 2) {
            jTextField3.setText("00");
        }
    }

    private void jTextField4_keyPressed(KeyEvent e) {
        if (jTextField4.getText().length() > 2) {
            jTextField4.setText("00");
        }
    }

    private void jTextField5_keyPressed(KeyEvent e) {
        if (jTextField5.getText().length() > 2) {
            jTextField5.setText("00");
        }
    }

    private void jTextField6_keyPressed(KeyEvent e) {
        if (jTextField6.getText().length() > 2) {
            jTextField6.setText("00");
        }
    }

    private void jTextField7_keyPressed(KeyEvent e) {
        if (jTextField7.getText().length() > 2) {
            jTextField7.setText("00");
        }
    }

    private void jTextField8_keyPressed(KeyEvent e) {
        if (jTextField8.getText().length() > 2) {
            jTextField8.setText("00");
        }
    }

}
