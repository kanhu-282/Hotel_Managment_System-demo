package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login2 extends JFrame implements ActionListener {
    JTextField textField1;
    JPasswordField passwordField1;

    JButton b1,b2,b3;
    Login2(){
        super("LOGIN FORM2");

        JLabel label=new JLabel("User name");
        label.setBounds(40,20,150,30);
        label.setForeground(Color.white);
        label.setFont(new Font("Tahoma",Font.BOLD,23));
        add(label);

        JLabel label2=new JLabel("Password");
        label2.setBounds(40,90,150,30);
        label2.setFont(new Font("Tahoma",Font.BOLD,23));
        label2.setForeground(Color.white);
        add(label2);

        textField1=new JTextField();
        textField1.setBounds(200,20,200,30);
        textField1.setFont(new Font("Tahoma",Font.BOLD,20));
        add(textField1);

        passwordField1=new JPasswordField();
        passwordField1.setFont(new Font("Tahoma",Font.BOLD,18));
        passwordField1.setBounds(200,90,200,30);
        add(passwordField1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        JLabel label1=new JLabel(i1);
        label1.setBounds(470,30,265,320);
        add(label1);

        b1=new JButton("Login");
        b1.setFont(new Font("Tahoma",Font.BOLD,20));
        b1.setBounds(40,220,130,50);
        b1.setBackground(Color.green);
        b1.setForeground(Color.black);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setFont(new Font("Tahoma",Font.BOLD,20));
        b2.setBounds(180,220,130,50);
        b2.setBackground(Color.red);
        b2.setForeground(Color.black);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Clear");
        b3.setFont(new Font("Tahoma",Font.BOLD,20));
        b3.setBounds(330,220,130,50);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b3);

        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setLocation(500,300);
        setSize(800,400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try{
                Conn con1=new Conn();
                String user=textField1.getText();
                String pass=passwordField1.getText();
                String query="select * from login2 where user_name='"+user+"' and password='"+pass+"'";
                ResultSet resultSet=con1.statement.executeQuery(query);
                if(resultSet.next()){
                    new Admin();
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Sorrey! invalid username and password");
                }

            } catch (Exception E) {
                E.printStackTrace();
            }
        }else if (e.getSource()==b3){
            textField1.setText("");
            passwordField1.setText("");
        }
        else if(e.getSource()==b2){
            new Dashboars();
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Login2();
    }
}
