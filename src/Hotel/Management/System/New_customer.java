package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class New_customer extends JFrame implements ActionListener {
    JComboBox comboBox;
    JRadioButton r1,r2;
    Choice c1;
    JTextField no,country,name,deposite;
    JLabel date;
    JButton add,back,cancel;
    New_customer(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(550,150,200,200);
        panel.add(image);

        JLabel labelf=new JLabel("New Customer Form");
        labelf.setBounds(118,11,2260,53);
        labelf.setFont(new Font("Tahoma",Font.BOLD,27));
        labelf.setForeground(Color.white);
        panel.add(labelf);

        JLabel labelid=new JLabel("ID :");
        labelid.setBounds(35,76,200,30);
        labelid.setForeground(Color.white);
        labelid.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(labelid);

        comboBox=new JComboBox(new String[] {"Password","Aadhar-card","Voter-id","Driving-liance"});
        comboBox.setBounds(271,76,200,25);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,19));
        panel.add(comboBox);

        JLabel labelno=new JLabel("Number :");
        labelno.setBounds(35,111,200,30);
        labelno.setForeground(Color.white);
        labelno.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(labelno);

        no=new JTextField();
        no.setBounds(271,111,200,25);
        no.setFont(new Font("Tahoma",Font.BOLD,19));
        panel.add(no);

        JLabel labelname=new JLabel("Name :");
        labelname.setBounds(35,151,200,30);
        labelname.setForeground(Color.white);
        labelname.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(labelname);

        name=new JTextField();
        name.setBounds(271,151,200,25);
        name.setFont(new Font("Tahoma",Font.BOLD,19));
        panel.add(name);

        JLabel labelgender=new JLabel("Gender :");
        labelgender.setBounds(35,191,200,30);
        labelgender.setForeground(Color.white);
        labelgender.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(labelgender);

        r1=new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,15));
        r1.setBounds(271,191,70,20);
        panel.add(r1);

        r2=new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,15));
        r2.setBounds(371,191,80,20);
        panel.add(r2);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel labelcountry=new JLabel("Country :");
        labelcountry.setBounds(35,231,200,30);
        labelcountry.setForeground(Color.white);
        labelcountry.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(labelcountry);

        country=new JTextField();
        country.setBounds(271,231,200,25);
        country.setFont(new Font("Tahoma",Font.BOLD,19));
        panel.add(country);

        JLabel labelRoom=new JLabel("Allocated Room Number :");
        labelRoom.setBounds(35,274,200,30);
        labelRoom.setForeground(Color.white);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(labelRoom);

        c1=new Choice();
        try {
            Conn con=new Conn();
            String query="select * from room";
            ResultSet resultSet=con.statement.executeQuery(query);
            while (resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        c1.setBounds(271,274,200,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(c1);

        JLabel labelcis=new JLabel("Check-In :");
        labelcis.setBounds(35,316,200,30);
        labelcis.setForeground(Color.white);
        labelcis.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(labelcis);

        Date date1=new Date();

        date=new JLabel(""+date1);
        date.setBounds(271,316,300,30);
        date.setForeground(Color.white);
        date.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(date);

        JLabel labeldeposite=new JLabel("Deposite :");
        labeldeposite.setBounds(35,359,200,30);
        labeldeposite.setForeground(Color.white);
        labeldeposite.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(labeldeposite);

        deposite=new JTextField();
        deposite.setBounds(271,359,200,25);
        deposite.setFont(new Font("Tahoma",Font.BOLD,19));
        panel.add(deposite);

        add=new JButton("Add");
        add.setBounds(100,430,120,30);
        add.setFont(new Font("Tahoma",Font.BOLD,22));
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        panel.add(add);

        back=new JButton("Back");
        back.setBounds(260,430,120,30);
        back.setFont(new Font("Tahoma",Font.BOLD,22));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        panel.add(back);

        cancel=new JButton("Cancel");
        cancel.setBounds(420,430,120,30);
        cancel.setFont(new Font("Tahoma",Font.BOLD,22));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        panel.add(cancel);

        setUndecorated(true);
        setLayout(null);
        setSize(850,550);
        setLocation(500,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String gender=null;
            if(r1.isSelected()){
                gender="male";
            } else if (r2.isSelected()) {
                gender="female";
            }
            String document=(String)comboBox.getSelectedItem();
            String number=no.getText();
            String namee=name.getText();
            String genderr=gender;
            String coutry=country.getText();
            String chpice=c1.getSelectedItem();
            String checkintime=date.getText();
            String amount=deposite.getText();

            if(deposite.getText().equals("") && no.getText().equals("")){
                JOptionPane.showMessageDialog(null," Sorry! All the feild are madatory");
            }else {
                try {
                    Conn con=new Conn();
                    String query="insert into customer values('"+document+"','"+number+"','"+namee+"','"+genderr+"','"+coutry+"','"+chpice+"','"+checkintime+"','"+amount+"')";
                    String query1="update room set availiblity='Occupied' where room_no="+chpice;
                    con.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Congrlutaion your data updated");
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        } else if (e.getSource()==cancel) {
            setVisible(false);
        } else if (e.getSource()==back) {
            new Reception();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new New_customer();
    }
}
