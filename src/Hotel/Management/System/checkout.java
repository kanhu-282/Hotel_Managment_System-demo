package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class checkout extends JFrame {
    checkout(){

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,790,490);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel label=new JLabel("Check-Out");
        label.setFont(new Font("Tahoma",Font.PLAIN,20));
        label.setBounds(100,20,150,30);
        label.setForeground(Color.white);
        panel.add(label);

        JLabel userid=new JLabel("ID :");
        userid.setFont(new Font("Tahoma",Font.BOLD,17));
        userid.setBounds(30,80,150,30);
        userid.setForeground(Color.white);
        panel.add(userid);

        Choice customerr=new Choice();
        customerr.setBounds(200,80,200,25);
        customerr.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(customerr);

        JLabel rn=new JLabel("Room-No :");
        rn.setFont(new Font("Tahoma",Font.BOLD,17));
        rn.setBounds(30,130,150,30);
        rn.setForeground(Color.white);
        panel.add(rn);

        JLabel lablerromnu=new JLabel();
        lablerromnu.setFont(new Font("Tahoma",Font.BOLD,17));
        lablerromnu.setBounds(200,130,150,30);
        lablerromnu.setForeground(Color.white);
        panel.add(lablerromnu);

        JLabel cit=new JLabel("City-In-Time :");
        cit.setFont(new Font("Tahoma",Font.BOLD,17));
        cit.setBounds(30,180,150,30);
        cit.setForeground(Color.white);
        panel.add(cit);

        JLabel labelcit=new JLabel();
        labelcit.setFont(new Font("Tahoma",Font.BOLD,17));
        labelcit.setBounds(200,180,150,30);
        labelcit.setForeground(Color.white);
        panel.add(labelcit);

        JLabel checkouttime=new JLabel("City-Out-Time :");
        checkouttime.setFont(new Font("Tahoma",Font.BOLD,17));
        checkouttime.setBounds(30,230,200,30);
        checkouttime.setForeground(Color.white);
        panel.add(checkouttime);

        Date date=new Date();

        JLabel labelcheckout=new JLabel(""+date);
        labelcheckout.setFont(new Font("Tahoma",Font.BOLD,17));
        labelcheckout.setBounds(200,230,270,30);
        labelcheckout.setForeground(Color.white);
        panel.add(labelcheckout);

        try{
            Conn con=new Conn();
            String query="select * from customer";
            ResultSet resultSet=con.statement.executeQuery(query);
            while (resultSet.next()){
                customerr.add(resultSet.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JButton checkOut=new JButton("Check-Out");
        checkOut.setBounds(30,300,180,30);
        checkOut.setForeground(Color.white);
        checkOut.setBackground(Color.black);
        checkOut.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(checkOut);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Conn con=new Conn();
                    con.statement.executeUpdate("delete  from customer where number='"+customerr.getSelectedItem()+"'");
                    con.statement.executeUpdate("update room set availiblity='Available' where room_no='"+lablerromnu.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton check=new JButton("Check");
        check.setBounds(290,300,120,30);
        check.setForeground(Color.white);
        check.setBackground(Color.black);
        check.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conn con=new Conn();
                try{
                    ResultSet resultSet1=con.statement.executeQuery("select * from customer where number='"+customerr.getSelectedItem()+"' ");
                    while (resultSet1.next()){
                        lablerromnu.setText(resultSet1.getString("room"));
                        labelcit.setText(resultSet1.getString("checkintime"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton cancel=new JButton("Cancel");
        cancel.setBounds(290,380,120,30);
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JButton back=new JButton("Back");
        back.setBounds(30,380,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Reception();
            }
        });



        setUndecorated(true);
        setLayout(null);
        setSize(800,500);
        setLocation(500,210);
        setVisible(true);
    }
    public static void main(String[] args) {
        new checkout();
    }
}
