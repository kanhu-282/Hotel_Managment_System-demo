package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addroom extends JFrame implements ActionListener {
    JTextField textField2,textField4;
    JComboBox textField3,textField5,textField6;
    JButton b1,b2;

    Addroom(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel label1=new JLabel("Add Room");
        label1.setBounds(194,10,160,30);
        label1.setFont(new Font("Tahoma",Font.BOLD,25));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2=new JLabel("Room Number");
        label2.setBounds(64,70,152,35);
        label2.setFont(new Font("Tahoma",Font.BOLD,20));
        label2.setForeground(Color.white);
        panel.add(label2);

        textField2=new JTextField();
        textField2.setBounds(250,70,250,30);
        textField2.setFont(new Font("Tahoma",Font.PLAIN,22));
        textField2.setForeground(Color.black);
        panel.add(textField2);

        JLabel label3=new JLabel("Availability");
        label3.setForeground(Color.white);
        label3.setFont(new Font("Tahoma",Font.BOLD,20));
        label3.setBounds(64,120,152,35);
        panel.add(label3);

        textField3=new JComboBox(new String[] {"Available","Occipied"});
        textField3.setBounds(250,120,250,30);
        textField3.setFont(new Font("Tahoma",Font.PLAIN,22));
        textField3.setForeground(Color.black);
        panel.add(textField3);

        JLabel label4=new JLabel("Price");
        label4.setForeground(Color.white);
        label4.setBounds(64,170,250,30);
        label4.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label4);

        textField4=new JTextField();
        textField4.setFont(new Font("Tahoma",Font.PLAIN,22));
        textField4.setForeground(Color.black);
        textField4.setBounds(250,170,250,30);
        panel.add(textField4);

        JLabel label5=new JLabel("Cleaning Status");
        label5.setForeground(Color.white);
        label5.setFont(new Font("Tahoma",Font.BOLD,20));
        label5.setBounds(64,220,250,30);
        panel.add(label5);

        textField5=new JComboBox(new String[] {"Cleaned","Dirty"});
        textField5.setFont(new Font("Tahoma",Font.PLAIN,22));
        textField5.setForeground(Color.black);
        textField5.setBounds(250,220,250,30);
        panel.add(textField5);

        JLabel label6=new JLabel("Bad Type");
        label6.setFont(new Font("Tahoma",Font.BOLD,20));
        label6.setBounds(64,270,250,30);
        label6.setForeground(Color.white);
        panel.add(label6);

        textField6=new JComboBox<>(new String[] {"Single","Double"});
        textField6.setFont(new Font("Tahoma",Font.PLAIN,22));
        textField6.setBounds(250,270,250,30);
        textField6.setForeground(Color.black);
        panel.add(textField6);

        b1=new JButton("Add");
        b1.setFont(new Font("Tahoma",Font.BOLD,20));
        b1.setBounds(64,350,111,33);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        panel.add(b1);

        b2=new JButton("Back");
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setFont(new Font("Tahoma",Font.BOLD,20));
        b2.setBounds(200,350,111,33);
        b2.addActionListener(this);
        panel.add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/roomser.png"));
        Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(550,60,300,300);
        panel.add(label);


        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLocation(20,200);
        setLayout(null);
        setSize(885,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try {
                Conn c=new Conn();
                String room=textField2.getText();
                String ava=(String)textField3.getSelectedItem();
                String status=(String) textField5.getSelectedItem();
                String price=textField4.getText();
                String type=(String) textField6.getSelectedItem();
                if(textField4.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"All the field are madatory");
                }else {
                    String query="insert into room values('"+room+"','"+ava+"','"+status+"','"+price+"','"+type+"')";
                    c.statement.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Congatulation Room successfully edit");
                    setVisible(false);
                    new Admin();
                }



            } catch (Exception E) {
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new Admin();
        }
    }

    public static void main(String[] args) {
        new Addroom();
    }
}
