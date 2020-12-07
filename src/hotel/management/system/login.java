package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class login extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField t1, t2;
    JButton b1, b2;
    JPanel contentPane;

    login() {
        super("Login Page");
        contentPane = new JPanel();

        setContentPane(contentPane);
        contentPane.setBackground(Color.LIGHT_GRAY);

        l3 = new JLabel("Login");
        l3.setBounds(170, 20, 100, 50);
        l3.setFont(new Font("sanserif", Font.BOLD, 30));
        add(l3);

        l1 = new JLabel("Username");
        l1.setBounds(50, 100, 100, 30);
        l1.setFont(new Font("sanserif", Font.BOLD, 15));
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(50, 150, 100, 30);
        l2.setFont(new Font("sanserif", Font.BOLD, 15));
        add(l2);

        t1 = new JTextField();
        t1.setBounds(150, 100, 200, 30);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150, 150, 200, 30);
        add(t2);

        b1 = new JButton("Login");
        b1.setBounds(50, 250, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("cancel");
        b2.setBounds(190, 250, 100, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(260, 260, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l5 = new JLabel(i3);
        l5.setBounds(400, 30, 260, 260);
        add(l5);

        setLayout(null);
        setBounds(400, 200, 700, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String username = t1.getText();
            String password = t2.getText();
            conn c = new conn();

            String str = "select * from login where username = '" + username + "'and password='" + password + "'";
            try {
                ResultSet rs = c.s.executeQuery(str);
                if (rs.next()) {
                    new Loading().setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "invalid usename and password");
                    this.setVisible(false);
                }
            } catch (Exception e) {

            }

        } else if (ae.getSource() == b2) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new login();
    }

}
