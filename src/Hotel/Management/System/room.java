package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class room extends JFrame implements  ActionListener{
    JTable table;
    JButton back,cancel;
    room(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setLayout(null);
        panel.setBackground(Color.black);
        add(panel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(600,200,200,200);
        panel.add(image);

        table=new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(table);

        try {
            Conn con=new Conn();
            String roominfo="select * from room";
            ResultSet resultSet=con.statement.executeQuery(roominfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setFont(new Font("Tahoma",Font.BOLD,20));
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setBounds(200,500,120,30);
        back.addActionListener(this);
        panel.add(back);

        cancel=new JButton("Cancel");
        cancel.setFont(new Font("Tahoma",Font.BOLD,20));
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        cancel.setBounds(400,500,120,30);
        cancel.addActionListener(this);
        panel.add(cancel);

        setUndecorated(true);
        setLayout(null);
        setLocation(500,100);
        setSize(900,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Reception();
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new room();
    }
}
