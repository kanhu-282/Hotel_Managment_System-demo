package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateroom extends JFrame {
    Choice choice;
    JTextField textField,textFieldava,textFieldchekedin,textFieldeposi,textFieldpendingamot;
    updateroom(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,940,540);
        panel.setBackground(new Color(5,5,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1=new JLabel("Update-Romm-satus");
        label1.setBounds(124,11,500,40);
        label1.setFont(new Font("Tahoma",Font.BOLD,35));
        label1.setForeground(Color.black);
        panel.add(label1);

        JLabel label2=new JLabel("ID :");
        label2.setBounds(25,88,100,30);
        label2.setFont(new Font("Tahoma",Font.PLAIN,20));
        label2.setForeground(Color.black);
        panel.add(label2);

        choice=new Choice();
        choice.setBounds(225,85,200,30);
        choice.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(choice);
        try{
            Conn con=new Conn();
            String query="select * from customer";
            ResultSet resultSet=con.statement.executeQuery(query);
            while (resultSet.next()){
                choice.add(resultSet.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3=new JLabel("Room-No :");
        label3.setBounds(25,129,150,30);
        label3.setFont(new Font("Tahoma",Font.PLAIN,20));
        label3.setForeground(Color.black);
        panel.add(label3);

        textField=new JTextField();
        textField.setBounds(225,129,200,30);
        textField.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(textField);

        JLabel name=new JLabel("Available :");
        name.setBounds(25,174,150,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,20));
        name.setForeground(Color.black);
        panel.add(name);

        textFieldava=new JTextField();
        textFieldava.setBounds(225,174,200,30);
        textFieldava.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(textFieldava);

        JLabel label4=new JLabel("Claning status :");
        label4.setBounds(25,216,200,30);
        label4.setFont(new Font("Tahoma",Font.PLAIN,20));
        label4.setForeground(Color.black);
        panel.add(label4);

        textFieldchekedin=new JTextField();
        textFieldchekedin.setBounds(225,216,200,30);
        textFieldchekedin.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(textFieldchekedin);



        JButton back=new JButton("Update");
        back.setBounds(70,378,100,23);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn con=new Conn();
                    String status=textFieldchekedin.getText();
                    con.statement.executeUpdate("update room set cleaning_status='"+status+"' where room_no="+textField.getText());

                    JOptionPane.showMessageDialog(null,"Updated sussfully");
                    setVisible(false);
                }catch (Exception s){
                    s.printStackTrace();
                }
            }
        });

        JButton check=new JButton("Check");
        check.setBounds(181,378,89,23);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=choice.getSelectedItem();
                String q="select * from  customer where number='"+id+"'";
                try{
                    Conn con=new Conn();
                    ResultSet resultSet=con.statement.executeQuery(q);
                    while (resultSet.next()){
                        textField.setText(resultSet.getString("room"));
                    }
                    ResultSet resultSet1=con.statement.executeQuery("select * from room where room_no='"+textField.getText()+"'");
                    while (resultSet1.next()){
                        textFieldava.setText(resultSet1.getString("availiblity"));
                        textFieldchekedin.setText(resultSet1.getString("cleaning_status"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton back1=new JButton("Back");
        back1.setBounds(281,378,89,23);
        back1.setBackground(Color.black);
        back1.setForeground(Color.white);
        back1.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(back1);
        back1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Reception();
            }
        });

        JButton cancel=new JButton("Cancel");
        cancel.setBounds(381,378,100,23);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(950,500);
        setLayout(null);
        setLocation(400,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new updateroom();
    }
}
