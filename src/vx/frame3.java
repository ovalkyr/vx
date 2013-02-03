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
import javax.swing.filechooser.FileFilter;
import javax.swing.text.PlainDocument;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;
import jp.sourceforge.qrcode.util.ContentConverter;


public class frame3 extends JFrame {
    private JButton jButton1 = new JButton();
    private JTextArea jTextArea1 = new JTextArea();
    private JButton jButton2 = new JButton();
    private JFileChooser JFileChooser1 = new JFileChooser();
    private BufferedImage image1;
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JLabel jLabel2 = new JLabel();
    private JTextPane jTextPane1 = new JTextPane();
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
    private JCheckBox jCheckBox1 = new JCheckBox();
    private JPasswordField jPasswordField1 = new JPasswordField();
    private JScrollPane jScrollPane2 = new JScrollPane();


    public frame3() {
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
        this.setTitle("\u041c\u0410\u0421\u0422\u0415\u0420\u041a\u0410");
        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                this_windowOpened(e);
            }
        });
        jButton1.setText("\u0412\u044b\u043f\u043e\u043b\u043d\u0438\u0442\u044c \u0430\u043d\u0430\u043b\u0438\u0437");
        jButton1.setBounds(new Rectangle(585, 10, 175, 25));
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
        jButton2.setText("\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c \u043e\u0431\u0440\u0430\u0437\u0435\u0446");
        jButton2.setBounds(new Rectangle(395, 10, 185, 25));
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton2_actionPerformed(e);
            }
        });
        JFileChooser1.setFileFilter(new ImageFileFilter());
        jScrollPane1.setBounds(new Rectangle(20, 65, 365, 200));
        jScrollPane1.setBorder(BorderFactory.createLineBorder(SystemColor.windowText, 1));
        jLabel2.setText("\u043a\u0430\u0440\u0442\u0438\u043d\u043a\u0430");
        jLabel2.setVerticalAlignment(SwingConstants.TOP);
        jLabel2.setVerticalTextPosition(SwingConstants.TOP);
        jLabel2.setAutoscrolls(true);
        jTextPane1.setBorder(BorderFactory.createLineBorder(SystemColor.windowText, 1));
        //дата время анализа
        jTextPane1.setFont(new Font("Courier New", 0, 14));
        jTextPane1.setSelectionColor(new Color(165, 165, 255));
        jTextPane1.setDragEnabled(true);
        jTextField1.setBounds(new Rectangle(220, 300, 35, 20));

        jTextField1.setBackground(new Color(214, 247, 255));
        jTextField2.setBounds(new Rectangle(260, 300, 35, 20));

        jTextField2.setBackground(new Color(214, 247, 255));
        jTextField2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jTextField2_actionPerformed(e);
            }
        });
        jTextField3.setBounds(new Rectangle(300, 300, 35, 20));
        jTextField3.setBackground(new Color(214, 247, 255));
        jTextField4.setBounds(new Rectangle(340, 300, 35, 20));

        jTextField4.setBackground(new Color(214, 247, 255));
        jTextField4.setText("00");
        jLabel1.setBounds(new Rectangle(20, 340, 365, 25));
        jLabel1.setBorder(BorderFactory.createLineBorder(SystemColor.windowText, 1));
        jLabel3.setText("DD31");
        jLabel3.setBounds(new Rectangle(220, 280, 40, 20));
        jLabel3.setLabelFor(jTextField1);
        jLabel4.setText("HH24");
        jLabel4.setBounds(new Rectangle(260, 280, 35, 20));
        jLabel4.setLabelFor(jTextField2);
        jLabel5.setText("MI60");
        jLabel5.setBounds(new Rectangle(300, 280, 35, 20));
        jLabel6.setText("SS60");
        jLabel6.setBounds(new Rectangle(340, 280, 35, 20));
        jLabel7.setText("Дата, время взятия образца");
        jLabel7.setBounds(new Rectangle(45, 290, 155, 35));
        jCheckBox1.setText("\u0410\u0432\u0430\u0440\u0438\u0439\u043d\u044b\u0439 \u0432\u0432\u043e\u0434");
        jCheckBox1.setBounds(new Rectangle(425, 305, 110, 20));
        jCheckBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                jCheckBox1_itemStateChanged(e);
            }
        });
        jPasswordField1.setBounds(new Rectangle(395, 340, 365, 25));
        jPasswordField1.setEnabled(false);
        jScrollPane2.setBounds(new Rectangle(395, 65, 365, 200));
        jScrollPane2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        JFileChooser1.setLocation(300, 200);

        jScrollPane2.getViewport().add(jTextPane1, null);
        this.getContentPane().add(jScrollPane2, null);
        this.getContentPane().add(jPasswordField1, null);
        this.getContentPane().add(jCheckBox1, null);
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
        jTextField1.setText("18");
        jTextField1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                jTextField1_keyPressed(e);
            }
        });
        jTextField2.setBackground(Color.LIGHT_GRAY);
        jTextField2.setText("06");
        jTextField2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                jTextField2_keyPressed(e);
            }
        });
        jTextField3.setBackground(Color.LIGHT_GRAY);
        jTextField3.setText("40");
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


    }


    //кнопка анализа - ВЫПОЛНИТЬ-------------------------------------------------------------------------------------------
    private void jButton1_actionPerformed(ActionEvent e) {
       //рисуем расход энергии сразу
        try {
            jLabel1.setText(db2.getEnergyLevel("A"));
            jTextPane1.setText("");
        } catch (Exception f) {
        }

        //проверяем дату
        String r =
            checkDateFormat(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText());
        if (r == "OK") {
            jTextField1.setBackground(Color.LIGHT_GRAY);
            jTextField2.setBackground(Color.LIGHT_GRAY);
            jTextField3.setBackground(Color.LIGHT_GRAY);
            jTextField4.setBackground(Color.LIGHT_GRAY);
        } else {
            jTextPane1.setText("Что-то с форматом даты фигня какая-то..." + r);
            //красим поля в красный цвет
            jTextField1.setBackground(Color.RED);
            jTextField2.setBackground(Color.RED);
            jTextField3.setBackground(Color.RED);
            jTextField4.setBackground(Color.RED);
            //отваливаемся
            return;
        }

        //слепляем дату анализа
        String dt_analiza =
            jTextField1.getText() + " " + jTextField2.getText() + ":" + jTextField3.getText() + ":" + jTextField4.getText();

        String decodedString = "";


        // проверяем картинку
        if ((image1 != null) && (!jCheckBox1.isSelected())) {
            try {
                QRCodeDecoder decoder = new QRCodeDecoder();
                decodedString = new String(decoder.decode(new J2SEImage(image1)));
                decodedString = ContentConverter.convert(decodedString);
                //проверяем есть ли в базе такой айдишник юзера
                String s;
                s = db2.checkQRcode(decodedString);

                if (Integer.parseInt(s) > 0) {
                    jTextPane1.setText("Распознано...");
                } else {
                    jTextPane1.setText("Плохой образец. Не распознан...");
                    return;
                }
            } catch (Exception f) {
                jTextPane1.setText("Ошибка. Плохой образец. Не распознан..." + f.getMessage());
                return;
            }
        } else if ((jCheckBox1.isSelected())) {
            decodedString = jPasswordField1.getText();
            if (decodedString.isEmpty()) {
                jTextPane1.setText("Не загружен образец...");
                return;
            }

        } else {
            jTextPane1.setText("Не загружен образец...");
            return;
                   }


        //обращаемся к базе
        String s;
        try {
            s = db2.analyzer_master_main(decodedString, dt_analiza);

            //рисуем ген
            jTextPane1.setText(s);

            //рисуем расход энергии
            jLabel1.setText(db2.getEnergyLevel("A"));

            //зачищаем поле аварийного ввода
            if (jCheckBox1.isSelected()) {
                jPasswordField1.setText("");
            }

        } catch (Exception f) { jTextPane1.setText(f.getMessage());
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


        if (DD.length() == 1) {
            jTextField1.setText("0" + jTextField1.getText());
        } else if (HH.length() == 1) {
            jTextField2.setText("0" + jTextField2.getText());
        } else if (MI.length() == 1) {
            jTextField3.setText("0" + jTextField3.getText());
        } else if (SS.length() == 1) {
            jTextField4.setText("0" + jTextField4.getText());
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
            jButton2.setText("Загрузить образец");
        }
    }

    private void this_windowOpened(WindowEvent e) {
        try {
            jLabel1.setText(db2.getEnergyLevel("A"));
        } catch (Exception f) {
        }
    }

    private void jTextField2_actionPerformed(ActionEvent e) {
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


}
