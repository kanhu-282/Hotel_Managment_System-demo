package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department(){
        JPanel panel=new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(new Color(4,45,48));
        table.setForeground(Color.black);
        table.setBackground(Color.white);
        panel.add(table);

        try {
            Conn con=new Conn();
            String dep="select * from department";
            ResultSet resultSet=con.statement.executeQuery(dep);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JButton back=new JButton("Back");
        back.setBounds(400,410,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel label=new JLabel("Department");
        label.setBounds(145,11,155,20);
        label.setForeground(Color.white);
        label.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(label);

        JLabel label1=new JLabel("Budget");
        label1.setBounds(431,11,155,20);
        label1.setForeground(Color.white);
        label1.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(label1);

        setUndecorated(true);
        setLayout(null);
        setLocation(600,200);
        setSize(700,500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Department();
    }
}
