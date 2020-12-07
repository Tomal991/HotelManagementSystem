package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable {

    JLabel l1, l2, l3, l4;

    JProgressBar p;
    Thread t;

    public void run() {
        try {
            for (int i = 1; i <= 101; i++) {
                int m = p.getMaximum();
                int n = p.getValue();
                if (n < m) {
                    p.setValue(p.getValue() + 1);
                } else {
                    i = 101;
                    new Reception().setVisible(true);
                    setVisible(false);

                }
                Thread.sleep(50);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading() {

        l1 = new JLabel("Hotel Management System");
        l1.setBounds(150, 50, 500, 50);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("sanserif", Font.BOLD, 35));
        add(l1);

        p = new JProgressBar();
        p.setStringPainted(true);
        p.setBounds(210, 150, 300, 20);
        add(p);

        t = new Thread(this);

        l2 = new JLabel("Loading....Please Wait");
        l2.setBounds(230, 200, 400, 30);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("sanserif", Font.BOLD, 25));
        add(l2);

        setBounds(300, 100, 700, 400);
        setLayout(null);
        setVisible(true);

        t.start();
    }

    public static void main(String[] args) {
        new Loading().setVisible(true);
    }
}
