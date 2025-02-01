package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_diver extends JFrame implements ActionListener {
    JTextField nametxt,agetxt,carcmp,carnametxt,carloctxt;
    JRadioButton r1,r2;
    JComboBox comboBox;
    JButton addbtn,back;
    add_diver(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.setBackground(Color.gray);
        panel.setLayout(null);
        add(panel);

        JLabel label=new JLabel("ADD DRIVER");
        label.setBounds(194,10,230,25);
        label.setForeground(Color.black);
        label.setFont(new Font("System",Font.BOLD,21));
        panel.add(label);

        JLabel name=new JLabel("Name");
        name.setBounds(64,70,150,25);
        name.setForeground(Color.black);
        name.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(name);

        nametxt=new JTextField();
        nametxt.setBounds(174,70,200,25);
        nametxt.setFont(new Font("Tahoma",Font.BOLD,18));
        nametxt.setForeground(Color.BLACK);
        nametxt.setBackground(Color.white);
        panel.add(nametxt);

        JLabel age=new JLabel("Age");
        age.setBounds(64,120,150,25);
        age.setForeground(Color.black);
        age.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(age);

        agetxt=new JTextField();
        agetxt.setBounds(174,120,200,25);
        agetxt.setFont(new Font("Tahoma",Font.BOLD,18));
        agetxt.setForeground(Color.BLACK);
        agetxt.setBackground(Color.white);
        panel.add(agetxt);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(64,170,150,25);
        gender.setForeground(Color.black);
        gender.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(gender);

        r1=new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,15));
        r1.setBounds(174,170,80,25);
        r1.setBackground(Color.white);
        r1.setForeground(Color.BLACK);
        panel.add(r1);

        r2=new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,15));
        r2.setBounds(280,170,80,25);
        r2.setBackground(Color.white);
        r2.setForeground(Color.BLACK);
        panel.add(r2);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel car=new JLabel("Car-cmy");
        car.setBounds(64,220,200,25);
        car.setFont(new Font("Tahoma",Font.BOLD,18));
        car.setForeground(Color.black);
        car.setLayout(null);
        panel.add(car);

        carcmp=new JTextField();
        carcmp.setBounds(174,220,200,25);
        carcmp.setFont(new Font("Tahoma",Font.BOLD,18));
        carcmp.setForeground(Color.BLACK);
        carcmp.setBackground(Color.white);
        panel.add(carcmp);

        JLabel carname=new JLabel("Car-Name");
        carname.setBounds(64,270,200,25);
        carname.setFont(new Font("Tahoma",Font.BOLD,18));
        carname.setForeground(Color.black);
        panel.add(carname);

        carnametxt=new JTextField();
        carnametxt.setBounds(174,270,200,25);
        carnametxt.setFont(new Font("Tahoma",Font.BOLD,18));
        carnametxt.setForeground(Color.BLACK);
        carnametxt.setBackground(Color.white);
        panel.add(carnametxt);

        JLabel available=new JLabel("Available");
        available.setBounds(64,320,150,25);
        available.setForeground(Color.black);
        available.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(available);

        comboBox=new JComboBox<>(new String[] {"Yes","No"});
        comboBox.setFont(new Font("Tahoma",Font.BOLD,20));
        comboBox.setBounds(174,320,200,25);
        comboBox.setForeground(Color.black);
        panel.add(comboBox);

        JLabel carloc=new JLabel("Car-Loca");
        carloc.setBounds(64,370,200,25);
        carloc.setFont(new Font("Tahoma",Font.BOLD,18));
        carloc.setForeground(Color.black);
        panel.add(carloc);

        carloctxt=new JTextField();
        carloctxt.setBounds(174,370,200,25);
        carloctxt.setFont(new Font("Tahoma",Font.BOLD,18));
        carloctxt.setForeground(Color.BLACK);
        carloctxt.setBackground(Color.white);
        panel.add(carloctxt);

        addbtn=new JButton("Add");
        addbtn.setBounds(64,480,111,33);
        addbtn.setBackground(Color.black);
        addbtn.setForeground(Color.white);
        addbtn.setFont(new Font("Tahoma",Font.BOLD,25));
        addbtn.addActionListener(this);
        panel.add(addbtn);

        back=new JButton("Back");
        back.setBounds(270,480,111,33);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("Tahoma",Font.BOLD,25));
        back.addActionListener(this);
        panel.add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label1=new JLabel(i3);
        label1.setBounds(500,60,300,300);
        panel.add(label1);

        setUndecorated(true);
        getContentPane().setBackground(Color.blue);
        setLocation(40,200);
        setLayout(null);
        setSize(900,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addbtn){
            String name=nametxt.getText();
            String age=agetxt.getText();
            String gender=null;
            if(r1.isSelected()){
                gender="Male";
            }else {
                gender="Female";
            }
//            setUndecorated(true);
            String company=carcmp.getText();
            String carname=carnametxt.getText();
            String available=(String) comboBox.getSelectedItem();
            String location=carloctxt.getText();

            try {
                if(carloctxt.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"All the are madatory");
                }else {
                    Conn con=new Conn();
                    String query="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+carname+"','"+available+"','"+location+"')";
                    con.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Congrtulation Driver Addes Sussfully");
                    setVisible(false);
                    new Admin();
                }

            } catch (Exception E) {
                E.printStackTrace();
            }

        }else {
            new Admin();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new add_diver();
    }

}
