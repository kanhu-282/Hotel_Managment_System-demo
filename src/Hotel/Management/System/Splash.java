package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/splash.gif"));
        JLabel label=new JLabel(i1);
        label.setBounds(0,0,1000,800);
        add(label);


        setLayout(null);
        getContentPane().setBackground(Color.black);
        setLocation(360,100);
        setSize(1000,800);
        setVisible(true);
        try{
            Thread.sleep(5000);
            new Login();
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
