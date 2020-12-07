package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class addDrivers extends JFrame implements ActionListener {

    private JTextField t1, t2, t3, t4, t5;
    private JComboBox c1, c2;
    JButton b1, b2;

    public addDrivers() {
        setBounds(350, 100, 700, 500);
        setLayout(null);

        //ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
        // Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        // ImageIcon i2 = new ImageIcon(i3);
        //JLabel l15 = new JLabel(i2);
        //l15.setBounds(400,30,500,370);
        //add(l15);
        JLabel l1 = new JLabel("Add Drivers");
        l1.setBounds(194, 15, 150, 22);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("sanserif", Font.BOLD, 25));
        l1.setBackground(Color.DARK_GRAY);
        add(l1);

        JLabel name = new JLabel("Name");

        name.setBounds(64, 70, 102, 22);
        add(name);

        t1 = new JTextField();
        t1.setBounds(174, 70, 156, 30);
        add(t1);

        JLabel age = new JLabel("Age");

        age.setBounds(64, 110, 102, 22);
        add(age);

        t2 = new JTextField();
        t2.setBounds(174, 110, 156, 30);
        add(t2);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(64, 150, 102, 22);
        add(gender);

        c1 = new JComboBox(new String[]{"null","Male", "Female"});
        c1.setBounds(176, 150, 154, 20);
        add(c1);

        JLabel company = new JLabel("Car Company");
        company.setBounds(64, 190, 102, 22);
        add(company);

        t3 = new JTextField();
        t3.setBounds(174, 190, 156, 30);
        add(t3);

        JLabel brand = new JLabel("Car Model");
        brand.setBounds(64, 230, 102, 22);
        add(brand);

        t4 = new JTextField();
        t4.setBounds(174, 230, 156, 30);
        add(t4);

        JLabel available = new JLabel("Available");
        available.setBounds(64, 270, 102, 22);
        add(available);

        c2 = new JComboBox(new String[]{"null","Yes", "No"});
        c2.setBounds(176, 270, 154, 20);
        add(c2);

        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBounds(64, 350, 111, 33);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("sanserif", Font.BOLD, 20));
        b1.setBackground(Color.DARK_GRAY);
        add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(200, 350, 111, 33);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("sanserif", Font.BOLD, 20));
        b2.setBackground(Color.DARK_GRAY);
        add(b2);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String) c1.getSelectedItem();
            String company = t3.getText();
            String brand = t4.getText();
            String available = (String) c2.getSelectedItem();

            conn c = new conn();
            try {
                String str = "INSERT INTO drivers values( '" + name + "', '" + age + "', '" + gender + "','" + company + "', '" + brand + "', '" + available + "')";

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                new carservice().setVisible(true);
                this.setVisible(false);

            } catch (Exception ee) {
                System.out.println(ee);
            }
        } else if (ae.getSource() == b2) {
            new carservice().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new addDrivers().setVisible(true);
    }

}
