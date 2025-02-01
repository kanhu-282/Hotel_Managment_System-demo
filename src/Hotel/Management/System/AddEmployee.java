package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {
        JTextField textname,textage,textsalary,textphone,textadar,textemail;
        JRadioButton r1,r2,r3;
        JComboBox comboBox;
        JButton add,back;
    AddEmployee(){

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,990,590);
        panel.setBackground(Color.black);
        add(panel);

        JLabel name=new JLabel("Name");
        name.setBounds(60,30,200,30);
        name.setFont(new Font("Tahoma",Font.BOLD,22));
        name.setForeground(Color.white);
        panel.add(name);

        textname=new JTextField();
        textname.setFont(new Font("Tahoma",Font.BOLD,22));
        textname.setBounds(200,30,250,30);
        textname.setBackground(Color.white);
        textname.setForeground(Color.black);
        panel.add(textname);

        JLabel age=new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.BOLD,22));
        age.setBounds(60,80,200,30);
        age.setForeground(Color.white);
        panel.add(age);

        textage=new JTextField();
        textage.setBackground(Color.white);
        textage.setForeground(Color.black);
        textage.setBounds(200,80,250,30);
        textage.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(textage);

        JLabel gender=new JLabel("Gender");
        gender.setForeground(Color.white);
        gender.setBounds(60,130,200,30);
        gender.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(gender);

        r1=new JRadioButton("Male");
        r1.setBackground(Color.white);
        r1.setBounds(200,130,80,30);
        r1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(r1);

        r2=new JRadioButton("Female");
        r2.setBackground(Color.white);
        r2.setBounds(290,130,80,30);
        r2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(r2);

        r3=new JRadioButton("Other");
        r3.setBackground(Color.white);
        r3.setBounds(378,130,80,30);
        r3.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(r3);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);

        JLabel job=new JLabel("JOB");
        job.setBounds(60,180,200,30);
        job.setForeground(Color.white);
        job.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(job);

        comboBox=new JComboBox<>(new String[] {"Front Dask","Housekeepinh","Kitchen Staff","Room Service","Manager","Accountent","Chef"});
        comboBox.setForeground(Color.black);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,20));
        comboBox.setBounds(200,180,200,30);
        panel.add(comboBox);

        JLabel salary=new JLabel("Salary");
        salary.setFont(new Font("Tahoma",Font.BOLD,22));
        salary.setForeground(Color.white);
        salary.setBounds(60,230,200,30);
        panel.add(salary);

        textsalary=new JTextField();
        textsalary.setFont(new Font("Tahoma",Font.BOLD,22));
        textsalary.setBounds(200,230,250,30);
        textsalary.setForeground(Color.black);
        panel.add(textsalary);

        JLabel phone=new JLabel("Phone");
        phone.setFont(new Font("Tahoma",Font.BOLD,22));
        phone.setForeground(Color.white);
        phone.setBounds(60,280,200,30);
        panel.add(phone);

        textphone=new JTextField();
        textphone.setFont(new Font("Tahoma",Font.BOLD,22));
        textphone.setBounds(200,280,250,30);
        textphone.setForeground(Color.black);
        panel.add(textphone);

        JLabel aadhar=new JLabel("Aadhar");
        aadhar.setFont(new Font("Tahoma",Font.BOLD,22));
        aadhar.setForeground(Color.white);
        aadhar.setBounds(60,330,200,30);
        panel.add(aadhar);

        textadar=new JTextField();
        textadar.setFont(new Font("Tahoma",Font.BOLD,22));
        textadar.setBounds(200,330,250,30);
        textadar.setForeground(Color.black);
        panel.add(textadar);

        JLabel email=new JLabel("Email");
        email.setFont(new Font("Tahoma",Font.BOLD,22));
        email.setForeground(Color.white);
        email.setBounds(60,380,200,30);
        panel.add(email);

        textemail=new JTextField();
        textemail.setFont(new Font("Tahoma",Font.BOLD,22));
        textemail.setBounds(200,380,250,30);
        textemail.setForeground(Color.black);
        panel.add(textemail);

        JLabel AED=new JLabel("Add Employee Detail");
        AED.setFont(new Font("Tahoma",Font.BOLD,35));
        AED.setForeground(Color.white);
        AED.setBounds(550,24,400,35);
        panel.add(AED);

        add=new JButton("ADD");
        add.setBounds(120,480,150,30);
        add.setBackground(Color.white);
        add.setForeground(Color.black);
        add.setFont(new Font("Tahoma",Font.BOLD,25));
        add.addActionListener(this);
        panel.add(add);

        back=new JButton("BACK");
        back.setBounds(300,480,150,30);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setFont(new Font("Tahoma",Font.BOLD,25));
        back.addActionListener(this);
        panel.add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(550,100,300,300);
        panel.add(image);

        setUndecorated(true);
        setLayout(null);
        setSize(1000,600);
        setLocation(80,160);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name=textname.getText();
            String age=textage.getText();
            String saary=textsalary.getText();
            String phone=textphone.getText();
            String email=textemail.getText();
            String aadhar=textadar.getText();
            String job=(String) comboBox.getSelectedItem();
            String gender=null;
            if (r1.isSelected()){
                gender="Male";
            } else if (r2.isSelected()) {
                gender="female";
            } else if (r3.isSelected()) {
                gender="Other";
            }

            try{
               if(textemail.getText().equals("")){
                   JOptionPane.showMessageDialog(null,"All the field are madatory");
               }else {
                   Conn con=new Conn();
                   String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+saary+"','"+phone+"','"+email+"','"+aadhar+"')";
                   con.statement.executeUpdate(query);
                   JOptionPane.showMessageDialog(null,"Congruluation Your data add sussfully");
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
        new AddEmployee();
    }
}
