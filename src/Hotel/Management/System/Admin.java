package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame  implements ActionListener {
    JButton add_employee,add_room,add_diver,logout,back;
     Admin(){
         add_employee=new JButton("Add Employee");
         add_employee.setBounds(350,190,200,40);
         add_employee.setBackground(Color.black);
         add_employee.setForeground(Color.white);
         add_employee.setFont(new Font("Tahoma",Font.BOLD,22));
         add_employee.addActionListener(this);
         add(add_employee);

         add_room=new JButton("Add Room");
         add_room.setFont(new Font("Tahoma",Font.BOLD,22));
         add_room.setBackground(Color.black);
         add_room.setForeground(Color.white);
         add_room.setBounds(350,400,200,40);
         add_room.addActionListener(this);
         add(add_room);

         add_diver=new JButton("Add Driver");
         add_diver.setBounds(350,650,200,40);
         add_diver.setFont(new Font("Tahoma",Font.BOLD,22));
         add_diver.setForeground(Color.white);
         add_diver.setBackground(Color.black);
         add_diver.addActionListener(this);
         add(add_diver);

         logout=new JButton("Logout");
         logout.setBackground(Color.white);
         logout.setForeground(Color.black);
         logout.setFont(new Font("Tahoma",Font.BOLD,22));
         logout.setBounds(10,950,120,35);
         logout.addActionListener(this);
         add(logout);

         back=new JButton("Back");
         back.setBounds(150,950,120,35);
         back.setFont(new Font("Tahoma",Font.BOLD,22));
         back.setForeground(Color.black);
         back.setBackground(Color.white);
         back.addActionListener(this);
         add(back);

         ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
         Image i2=I1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel label=new JLabel(i3);
         label.setBounds(70,100,200,200);
         add(label);

         ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
         Image ii2=ii1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
         ImageIcon ii3=new ImageIcon(ii2);
         JLabel label1=new JLabel(ii3);
         label1.setBounds(70,340,200,200);
         add(label1);

         ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
         Image iii2=iii1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
         ImageIcon iii3=new ImageIcon(iii2);
         JLabel label2=new JLabel(iii3);
         label2.setBounds(70,580,200,200);
         add(label2);

         ImageIcon iiii1=new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
         Image iiii2=iiii1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
         ImageIcon iiii3=new ImageIcon(iiii2);
         JLabel label3=new JLabel(iiii3);
         label3.setBounds(1000,250,400,400);
         add(label3);

         getContentPane().setBackground(new Color(3,45,48));
        setSize(1950,1090);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add_employee){
            new AddEmployee();
            setVisible(false);

        } else if (e.getSource()==add_room) {
            new Addroom();
            setVisible(false);
        } else if (e.getSource()==add_diver) {
            new add_diver();
            setVisible(false);
        } else if (e.getSource()==logout) {
            System.exit(117);
        } else if (e.getSource()==back) {
            new Dashboars();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
