package com.jakobniinja;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Framed extends JFrame {

  public static final long serialVersionUID = 1L;

  public Framed() {
    setTitle("Framed");
    setResizable(false);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    try {
      String className = UIManager.getCrossPlatformLookAndFeelClassName();
      UIManager.setLookAndFeel(className);
    } catch (Exception e) {
    }
    EventQueue.invokeLater(Framed::new);
  }
}
