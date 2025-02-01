package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception(){

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(400,5,1494,1000);
        panel.setBackground(new Color(2,45,48));
        add(panel);

        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,388,1000);
        panel1.setBackground(new Color(3,45,48));
        add(panel1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/cccc.gif"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label1=new JLabel(i3);
        label1.setBounds(300,14,800,800);
        panel.add(label1);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image i22=i11.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel label2=new JLabel(i33);
        label2.setBounds(7,650,300,250);
        panel1.add(label2);

        JButton btnncf=new JButton("New Customer Form");
        btnncf.setBounds(30,30,300,40);
        btnncf.setForeground(Color.white);
        btnncf.setBackground(Color.black);
        btnncf.setFont(new Font("Tahoma",Font.BOLD,23));
        add(btnncf);
        btnncf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                        new New_customer();
                        setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton btnroom=new JButton("Room");
        btnroom.setBounds(30,75,300,40);
        btnroom.setForeground(Color.white);
        btnroom.setBackground(Color.black);
        btnroom.setFont(new Font("Tahoma",Font.BOLD,23));
        add(btnroom);
        btnroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new room();
                    setVisible(false);

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });
        JButton btndep=new JButton("Department");
        btndep.setBounds(30,120,300,40);
        btndep.setForeground(Color.white);
        btndep.setBackground(Color.black);
        btndep.setFont(new Font("Tahoma",Font.BOLD,23));
        add(btndep);
        btndep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                        new Department();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });
        JButton btnemp=new JButton("All Employee Info");
        btnemp.setBounds(30,165,300,40);
        btnemp.setForeground(Color.white);
        btnemp.setBackground(Color.black);
        btnemp.setFont(new Font("Tahoma",Font.BOLD,23));
        add(btnemp);
        btnemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Employee();
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });
        JButton btnci=new JButton("Customer Info");
        btnci.setBounds(30,210,300,40);
        btnci.setForeground(Color.white);
        btnci.setBackground(Color.black);
        btnci.setFont(new Font("Tahoma",Font.BOLD,23));
        add(btnci);
        btnci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new customerinfo();
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });
        JButton btnman=new JButton("Manager Info");
        btnman.setFont(new Font("Tahoma",Font.BOLD,23));
        btnman.setBackground(Color.black);
        btnman.setForeground(Color.white);
        btnman.setBounds(30,255,300,40);
        add(btnman);
        btnman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Managerinfo();
            }
        });
        JButton btnc=new JButton("Check out");
        btnc.setFont(new Font("Tahoma",Font.BOLD,23));
        btnc.setBackground(Color.black);
        btnc.setForeground(Color.white);
        btnc.setBounds(30,305,300,40);
        add(btnc);
        btnc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new checkout();
                setVisible(false);
            }
        });
        JButton btnuc=new JButton("Update Check in detail");
        btnuc.setFont(new Font("Tahoma",Font.BOLD,23));
        btnuc.setBackground(Color.black);
        btnuc.setForeground(Color.white);
        btnuc.setBounds(30,350,300,40);
        add(btnuc);
        btnuc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Udatecheck();
                setVisible(false);
            }
        });
        JButton btnrm=new JButton("Update Room status");
        btnrm.setFont(new Font("Tahoma",Font.BOLD,23));
        btnrm.setBackground(Color.black);
        btnrm.setForeground(Color.white);
        btnrm.setBounds(30,395,300,40);
        add(btnrm);
        btnrm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new updateroom();
                setVisible(false);
            }
        });
        JButton btnpus=new JButton("Pick up servise");
        btnpus.setFont(new Font("Tahoma",Font.BOLD,23));
        btnpus.setBackground(Color.black);
        btnpus.setForeground(Color.white);
        btnpus.setBounds(30,440,300,40);
        add(btnpus);
        btnpus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new pickup();
            }
        });
        JButton btnsr=new JButton("Search Room");
        btnsr.setFont(new Font("Tahoma",Font.BOLD,23));
        btnsr.setBackground(Color.black);
        btnsr.setForeground(Color.white);
        btnsr.setBounds(30,485,300,40);
        add(btnsr);
        btnsr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new SearchRooom();
            }
        });
        JButton btnback=new JButton("Back");
        btnback.setFont(new Font("Tahoma",Font.BOLD,23));
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        btnback.setBounds(30,530,300,40);
        add(btnback);
        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Dashboars();
                setVisible(false);
            }
        });
        JButton btncancel=new JButton("Cancel");
        btncancel.setFont(new Font("Tahoma",Font.BOLD,23));
        btncancel.setBackground(Color.black);
        btncancel.setForeground(Color.white);
        btncancel.setBounds(30,575,300,40);
        add(btncancel);
        btncancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setSize(1950,1080);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Reception();
    }
}
