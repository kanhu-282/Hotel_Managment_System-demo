package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class pickup  extends JFrame  implements ActionListener {
        JButton back,cancel,display;
        JTable table;
        Choice c;
    pickup(){

        JPanel panel=new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        panel.setForeground(Color.white);
        panel.setBounds(5,5,790,590);
        add(panel);

        JLabel pus=new JLabel("Pick Up Service");
        pus.setBounds(90,11,200,30);
        pus.setForeground(Color.white);
        pus.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(pus);

        JLabel toc=new JLabel("Type of Car");
        toc.setBounds(32,97,89,30);
        toc.setForeground(Color.white);
        toc.setFont(new Font("Tahoma",Font.PLAIN,15));
        panel.add(toc);

        c=new Choice();
        c.setBounds(160,94,150,25);
        c.setForeground(Color.black);
        panel.add(c);
        try{
            Conn con=new Conn();
            String query="select * from driver";
            ResultSet resultSet=con.statement.executeQuery(query);
            while(resultSet.next()){
                c.add(resultSet.getString("car_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table=new JTable();
        table.setBounds(10,233,800,200);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        panel.add(table);
        try{
            Conn con=new Conn();
            String  query1="select * from driver";
            ResultSet resultSet1=con.statement.executeQuery(query1);
            table.setModel(DbUtils.resultSetToTableModel(resultSet1));
        } catch (Exception E) {
            E.printStackTrace();
        }

        JLabel name=new JLabel("Name");
        name.setBounds(10,195,45,40);
        name.setFont(new Font("Tahoma",Font.PLAIN,18));
        name.setForeground(Color.white);
        panel.add(name);

        JLabel age=new JLabel("Age");
        age.setBounds(120,195,45,40);
        age.setFont(new Font("Tahoma",Font.PLAIN,18));
        age.setForeground(Color.white);
        panel.add(age);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(230,195,80,40);
        gender.setFont(new Font("Tahoma",Font.PLAIN,18));
        gender.setForeground(Color.white);
        panel.add(gender);

        JLabel carCompany=new JLabel("Car_Company");
        carCompany.setBounds(340,195,150,40);
        carCompany.setFont(new Font("Tahoma",Font.PLAIN,18));
        carCompany.setForeground(Color.white);
        panel.add(carCompany);

        JLabel carName=new JLabel("Car_Name");
        carName.setBounds(470,195,150,40);
        carName.setFont(new Font("Tahoma",Font.PLAIN,18));
        carName.setForeground(Color.white);
        panel.add(carName);

        JLabel availibale=new JLabel("Available");
        availibale.setBounds(580,195,150,40);
        availibale.setFont(new Font("Tahoma",Font.PLAIN,18));
        availibale.setForeground(Color.white);
        panel.add(availibale);

        JLabel location=new JLabel("Location");
        location.setBounds(690,195,150,40);
        location.setFont(new Font("Tahoma",Font.PLAIN,18));
        location.setForeground(Color.white);
        panel.add(location);


        back=new JButton("Back");
        back.setBounds(160,490,120,30);
        back.setFont(new Font("Tahoma",Font.BOLD,22));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        panel.add(back);

        cancel=new JButton("Cancel");
        cancel.setBounds(420,490,120,30);
        cancel.setFont(new Font("Tahoma",Font.BOLD,22));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        panel.add(cancel);

        display=new JButton("Display");
        display.setBounds(620,490,120,30);
        display.setFont(new Font("Tahoma",Font.BOLD,22));
        display.setBackground(Color.black);
        display.setForeground(Color.white);
        display.addActionListener(this);
        panel.add(display);

        setUndecorated(true);
        setLayout(null);
        setSize(800,600);
        setLocation(500,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Reception();
        }else if (e.getSource()==display){
            try{
                Conn con=new Conn();
                String query3="select * from driver where car_name='"+ c.getSelectedItem()+"'";
                ResultSet resultSet3=con.statement.executeQuery(query3);
                table.setModel(DbUtils.resultSetToTableModel(resultSet3));
            } catch (Exception s) {
                s.printStackTrace();
            }

        } else if (e.getSource()==cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new pickup();
    }
}
