package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboars extends JFrame  implements ActionListener {
        JButton add,res;
    Dashboars(){
        super("HOTEL MANAGEMENT SYSTEM");

        res=new JButton("Reception");
        res.setFont(new Font("Tahoma",Font.BOLD,40));
        res.setBounds(425,710,500,50);
        res.addActionListener(this);
        add(res);

        add=new JButton("Admin");
        add.setBounds(1100,710,500,50);
        add.setFont(new Font("Tahoma",Font.BOLD,40));
        add.addActionListener(this);
        add(add);

        ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image ii2=ii1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon ii3=new ImageIcon(ii2);
        JLabel label2=new JLabel(ii3);
        label2.setBounds(1100,200,500,500);
        add(label2);

        ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
        Image iii2=iii1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon iii3=new ImageIcon(iii2);
        JLabel label3=new JLabel(iii3);
        label3.setBounds(425,200,500,500);
        add(label3);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));
        Image i2=i1.getImage().getScaledInstance(1950,1090,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label1=new JLabel(i3);
        label1.setBounds(0,0,1950,1090);
        add(label1);


        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==res){
            new Reception();
            setVisible(false);
        }else if(e.getSource()==add){
            new Login();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Dashboars();
    }
}
