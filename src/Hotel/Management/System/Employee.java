package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee extends JFrame {

    Employee(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,34,950,450);
        table.setForeground(Color.black);
        table.setBackground(Color.white);
        panel.add(table);
        try{
            Conn con=new Conn();
            String query="select * from employee";
            ResultSet resultSet=con.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton back=new JButton("Back");
        back.setBounds(350,500,120,30);
        back.setForeground(Color.black);
        back.setBackground(Color.white);
        back.setFont(new Font("Tahoma",Font.BOLD,23));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Reception();
            }
        });

        JButton cancel=new JButton("Cancel");
        cancel.setBounds(650,500,120,30);
        cancel.setForeground(Color.black);
        cancel.setBackground(Color.white);
        cancel.setFont(new Font("Tahoma",Font.BOLD,23));
        panel.add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });

        JLabel name=new JLabel("Name");
        name.setBounds(41,11,70,19);
        name.setForeground(Color.white);
        name.setBackground(Color.black);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);

        JLabel age=new JLabel("Age");
        age.setBounds(125,11,70,19);
        age.setForeground(Color.white);
        age.setBackground(Color.black);
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(age);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(241,11,70,19);
        gender.setForeground(Color.white);
        gender.setBackground(Color.black);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);

        JLabel job=new JLabel("Job");
        job.setBounds(361,11,70,19);
        job.setForeground(Color.white);
        job.setBackground(Color.black);
        job.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(job);

        JLabel salary=new JLabel("Salary");
        salary.setBounds(481,11,70,19);
        salary.setForeground(Color.white);
        salary.setBackground(Color.black);
        salary.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(salary);

        JLabel phno=new JLabel("Phone-No");
        phno.setBounds(600,11,70,19);
        phno.setForeground(Color.white);
        phno.setBackground(Color.black);
        phno.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(phno);

        JLabel email=new JLabel("Email");
        email.setBounds(721,11,70,19);
        email.setForeground(Color.white);
        email.setBackground(Color.black);
        email.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(email);

        JLabel ac=new JLabel("Aadar-card");
        ac.setBounds(841,11,150,19);
        ac.setForeground(Color.white);
        ac.setBackground(Color.black);
        ac.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(ac);

        setUndecorated(true);
        setLayout(null);
        setSize(1000,600);
        setLocation(430,100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee();
    }
}
