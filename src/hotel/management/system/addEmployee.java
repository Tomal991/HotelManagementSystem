package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class addEmployee extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5, t6;
    JRadioButton r1, r2;
    JButton b1, b2, b3;
    JComboBox c1, c2;

    addEmployee() {

        JLabel name = new JLabel("NAME :");
        name.setFont(new Font("sanserif", Font.BOLD, 20));
        name.setBounds(70, 50, 100, 50);
        add(name);

        t1 = new JTextField();
        t1.setBounds(180, 60, 200, 30);
        add(t1);

        JLabel age = new JLabel("AGE :");
        age.setFont(new Font("sanserif", Font.BOLD, 20));
        age.setBounds(70, 100, 80, 50);
        add(age);

        t2 = new JTextField();
        t2.setBounds(180, 110, 200, 30);
        add(t2);

        JLabel gender = new JLabel("GENDER :");
        gender.setFont(new Font("sanserif", Font.BOLD, 18));
        gender.setBounds(70, 150, 100, 50);
        add(gender);

        r1 = new JRadioButton("Male");
        r1.setBounds(180, 150, 100, 50);
        r1.setFont(new Font("sanserif", Font.BOLD, 18));
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(280, 150, 250, 50);
        r2.setFont(new Font("sanserif", Font.BOLD, 18));
        add(r2);
        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);

        JLabel job = new JLabel("JOB :");
        job.setFont(new Font("sanserif", Font.BOLD, 20));
        job.setBounds(70, 200, 100, 50);
        add(job);

        String str[] = {"Manager", "Accountant", "Chef", "Front Desk Receptionist", "Maintenance Engineer", "Waiter/Waitress", "Kitchen Staff", "Room Service", "Housekeeping", "Porter", "other"};

        c1 = new JComboBox(str);
        c1.setBounds(180, 210, 200, 35);
        add(c1);

        JLabel salary = new JLabel("SALARY:");
        salary.setFont(new Font("sanserif", Font.BOLD, 20));
        salary.setBounds(70, 250, 100, 50);
        add(salary);

        t3 = new JTextField();
        t3.setBounds(180, 260, 200, 30);
        add(t3);

        JLabel phone = new JLabel("PHONE :");
        phone.setFont(new Font("sanserif", Font.BOLD, 20));
        phone.setBounds(70, 300, 100, 50);
        add(phone);

        t4 = new JTextField();
        t4.setBounds(180, 310, 200, 30);
        add(t4);

        JLabel nid = new JLabel("NID :");
        nid.setFont(new Font("sanserif", Font.BOLD, 20));
        nid.setBounds(70, 350, 100, 50);
        add(nid);

        t5 = new JTextField();
        t5.setBounds(180, 360, 200, 30);
        add(t5);

        JLabel email = new JLabel("EMAIL:");
        email.setFont(new Font("sanserif", Font.BOLD, 20));
        email.setBounds(70, 400, 100, 50);
        add(email);

        t6 = new JTextField();
        t6.setBounds(180, 410, 200, 30);
        add(t6);

        //getContentPane().setBackground(Color.white);
        JLabel l2 = new JLabel("ADD Employee Details");
        l2.setBounds(500, 30, 350, 50);
        l2.setFont(new Font("sanserif", Font.BOLD, 30));
        add(l2);

        b1 = new JButton("Submit");
        b1.setBounds(100, 480, 150, 40);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("sanserif", Font.BOLD, 20));
        b1.setBackground(Color.DARK_GRAY);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(300, 480, 150, 40);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("sanserif", Font.BOLD, 20));
        b2.setBackground(Color.DARK_GRAY);
        b2.addActionListener(this);
        add(b2);

        setLayout(null);
        setBounds(250, 100, 900, 600);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            String name = t1.getText();
            String age = t2.getText();
            String salary = t3.getText();
            String phone = t4.getText();
            String nid = t5.getText();
            String email = t6.getText();

            String gender = null;
            if (r1.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }

            String job = (String) c1.getSelectedItem();

            conn c = new conn();

            String str = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + nid + "','" + email + "')";

            try {

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Employee Added");
                new EmployeeInfo().setVisible(true);
                this.setVisible(false);
            } catch (Exception e) {
                System.out.print(e);

            }

        }
        if (ae.getSource() == b2) {
            new EmployeeInfo().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new addEmployee().setVisible(true);
    }

}
