package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRooom extends JFrame implements ActionListener {
        JCheckBox checkBox;
        Choice choice;
        JTable table;
        JButton adb ,back,cancel;
    SearchRooom(){

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.black);
        panel.setBounds(5,5,690,490);
        add(panel);

        JLabel searchroom=new JLabel("Search for Room");
        searchroom.setBounds(250,11,189,40);
        searchroom.setForeground(Color.white);
        searchroom.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(searchroom);

        checkBox=new JCheckBox("Only display available");
        checkBox.setBounds(400,69,200,23);
        checkBox.setForeground(Color.black);
        checkBox.setBackground(Color.gray);
        panel.add(checkBox);

        choice=new Choice();
        choice.add("Single Bad");
        choice.add("Double Bad");
        choice.setBounds(173,70,120,21);
        panel.add(choice);

        table=new JTable();
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setBounds(0,187,700,200);
        panel.add(table);
        try{
            Conn con=new Conn();
            String query="select * from room";
            ResultSet resultSet=con.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel rbd=new JLabel("Room Bad Type :");
        rbd.setBounds(20,73,189,15);
        rbd.setForeground(Color.white);
        rbd.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(rbd);

        JLabel rid=new JLabel("Room Number");
        rid.setBounds(17,162,153,15);
        rid.setForeground(Color.white);
        rid.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(rid);

        JLabel avali=new JLabel("Avalibility");
        avali.setBounds(160,162,153,15);
        avali.setForeground(Color.white);
        avali.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(avali);

        JLabel cs=new JLabel("Cleaning_status");
        cs.setBounds(280,162,153,15);
        cs.setForeground(Color.white);
        cs.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(cs);

        JLabel price=new JLabel("Price");
        price.setBounds(450,162,153,15);
        price.setForeground(Color.white);
        price.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(price);

        JLabel bt=new JLabel("Bad_Type");
        bt.setBounds(550,162,153,15);
        bt.setForeground(Color.white);
        bt.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(bt);

        adb =new JButton("Search");
        adb.setForeground(Color.BLACK);
        adb.setBackground(Color.white);
        adb.setBounds(100,400,120,30);
        adb.setFont(new Font("Tahoma",Font.BOLD,22));
        adb.addActionListener(this);
        panel.add(adb);

        back =new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.white);
        back.setBounds(250,400,120,30);
        back.setFont(new Font("Tahoma",Font.BOLD,22));
        back.addActionListener(this);
        panel.add(back);

        cancel =new JButton("Cancel");
        cancel.setForeground(Color.BLACK);
        cancel.setBackground(Color.white);
        cancel.setBounds(400,400,120,30);
        cancel.setFont(new Font("Tahoma",Font.BOLD,22));
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(null);
        setSize(700,500);
        setLocation(500,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==adb){
            String query="select * from room where bad_type='"+choice.getSelectedItem()+"'";
            String  query1="select * from room where availiblity='Available' AND bad_type='"+choice.getSelectedItem()+"'";
            try{
                Conn con=new Conn();
                ResultSet resultSet=con.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

                if(checkBox.isSelected()){
                    ResultSet resultSet1=con.statement.executeQuery(query1);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet1));
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource()==back) {
            new Reception();
            setVisible(false);
        } else if (e.getSource()==cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SearchRooom();
    }
}
