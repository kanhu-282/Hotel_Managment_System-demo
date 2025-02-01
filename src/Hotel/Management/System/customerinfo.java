package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class customerinfo extends JFrame implements ActionListener {
    JButton adb,back,cancel;
    customerinfo(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        panel.add(table);

        try{
            Conn con=new Conn();
            String query="select * from customer";
            ResultSet resultSet=con.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel id=new JLabel("ID");
        id.setBounds(31,11,46,14);
        id.setFont(new Font("Tahoma",Font.BOLD,14));
        id.setForeground(Color.white);
        panel.add(id);

        JLabel number=new JLabel("Number");
        number.setBounds(130,11,70,14);
        number.setFont(new Font("Tahoma",Font.BOLD,14));
        number.setForeground(Color.white);
        panel.add(number);

        JLabel name=new JLabel("Name");
        name.setBounds(240,11,70,14);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setForeground(Color.white);
        panel.add(name);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(350,11,70,14);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        gender.setForeground(Color.white);
        panel.add(gender);

        JLabel country=new JLabel("Country");
        country.setBounds(460,11,70,14);
        country.setFont(new Font("Tahoma",Font.BOLD,14));
        country.setForeground(Color.white);
        panel.add(country);

        JLabel rn=new JLabel("Room-No");
        rn.setBounds(570,11,70,14);
        rn.setFont(new Font("Tahoma",Font.BOLD,14));
        rn.setForeground(Color.white);
        panel.add(rn);

        JLabel date=new JLabel("Date");
        date.setBounds(680,11,70,14);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        date.setForeground(Color.white);
        panel.add(date);

        JLabel price=new JLabel("Deposite");
        price.setBounds(790,11,70,14);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        price.setForeground(Color.white);
        panel.add(price);

        back=new JButton("BACK");
        back.setBounds(100,480,170,40);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setFont(new Font("Tahoma",Font.BOLD,25));
        back.addActionListener(this);
        panel.add(back);

        cancel=new JButton("Cancel");
        cancel.setBounds(400,480,170,40);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        cancel.setFont(new Font("Tahoma",Font.BOLD,25));
        cancel.addActionListener(this);
        panel.add(cancel);

        setUndecorated(true);
        setLayout(null);
        setSize(900,600);
        setLocation(500,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if (e.getSource()==back) {
            setVisible(false);
            new Reception();
        } else if (e.getSource()==cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new customerinfo();
    }
}
