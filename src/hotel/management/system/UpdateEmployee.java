package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9;
    JRadioButton r1, r2;
    JButton b1, b2, b3;
    JComboBox c1, c2;
    Choice c3;

    UpdateEmployee() {

        JLabel name = new JLabel("NAME :");
        name.setFont(new Font("sanserif", Font.BOLD, 20));
        name.setBounds(70, 50, 100, 50);
        add(name);
         c3=new Choice();
        try {
            conn c = new conn();
            String str = "select * from employee";
            ResultSet rs = c.s.executeQuery(str);
            while (rs.next()) {
                c3.add(rs.getString("name"));
            }
            c3.setBounds(180, 65, 150, 30);
            add(c3);

        } catch (Exception e) {
            System.out.println(e);
        }

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

        t3 = new JTextField();
        t3.setBounds(180, 160, 200, 30);
        add(t3);

        JLabel job = new JLabel("JOB :");
        job.setFont(new Font("sanserif", Font.BOLD, 20));
        job.setBounds(70, 200, 100, 50);
        add(job);

        t4 = new JTextField();
        t4.setBounds(180, 210, 200, 30);
        add(t4);

        JLabel salary = new JLabel("SALARY:");
        salary.setFont(new Font("sanserif", Font.BOLD, 20));
        salary.setBounds(70, 250, 100, 50);
        add(salary);

        t5 = new JTextField();
        t5.setBounds(180, 260, 200, 30);
        add(t5);

        JLabel phone = new JLabel("PHONE :");
        phone.setFont(new Font("sanserif", Font.BOLD, 20));
        phone.setBounds(70, 300, 100, 50);
        add(phone);

        t6 = new JTextField();
        t6.setBounds(180, 310, 200, 30);
        add(t6);

        JLabel nid = new JLabel("NID :");
        nid.setFont(new Font("sanserif", Font.BOLD, 20));
        nid.setBounds(70, 350, 100, 50);
        add(nid);

        t7 = new JTextField();
        t7.setBounds(180, 360, 200, 30);
        add(t7);

        JLabel email = new JLabel("EMAIL:");
        email.setFont(new Font("sanserif", Font.BOLD, 20));
        email.setBounds(70, 400, 100, 50);
        add(email);

        t8 = new JTextField();
        t8.setBounds(180, 410, 200, 30);
        add(t8);

        //getContentPane().setBackground(Color.white);
        JLabel l2 = new JLabel("Update Employee Details");
        l2.setBounds(350, 3, 450, 50);
        l2.setFont(new Font("sanserif", Font.BOLD, 25));
        add(l2);

        b1 = new JButton("Check");
        b1.setBounds(100, 480, 150, 40);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("sanserif", Font.BOLD, 20));
        b1.setBackground(Color.DARK_GRAY);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Update");
        b2.setBounds(300, 480, 150, 40);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("sanserif", Font.BOLD, 20));
        b2.setBackground(Color.DARK_GRAY);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBounds(500, 480, 150, 40);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("sanserif", Font.BOLD, 20));
        b3.setBackground(Color.DARK_GRAY);
        b3.addActionListener(this);
        add(b3);

        setLayout(null);
        setBounds(250, 100, 900, 600);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            String s1 = c3.getSelectedItem();

            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from employee where name='" + s1 + "'");
                while (rs.next()) {

                    t2.setText(rs.getString("age"));
                    t3.setText(rs.getString("gender"));
                    t4.setText(rs.getString("job"));
                    t5.setText(rs.getString("salary"));
                    t6.setText(rs.getString("phone"));
                    t7.setText(rs.getString("nid"));
                    t8.setText(rs.getString("email"));

                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }
        if (ae.getSource() == b2) {

            String name = c3.getSelectedItem();
            String age = t2.getText();
            String gender = t3.getText();
            String job = t4.getText();
            String salary = t5.getText();
            String phone = t6.getText();
            String nid = t7.getText();
            String email = t8.getText();

            conn c = new conn();
            try {
                String str = "update employee set age='" + age + "',gender='" + gender + "',job='" + job + "',salary='" + salary + "',phone='" + phone + "',nid='" + nid + "',email='" + email + "' where name='" + name + "'";

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Employee Updated successfully");
                new EmployeeInfo().setVisible(true);
                dispose();

            } catch (Exception ee) {
                System.out.println(ee);
            }
        }
        if (ae.getSource() == b3) {
            new EmployeeInfo().setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee().setVisible(true);
    }

}
