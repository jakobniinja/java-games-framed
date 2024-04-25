package com.jakobniinja;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Framed extends JFrame {

  private static final long serialVersionUID = 1L;

  private static final int GRIDSIZE = 3;

  private LightButton[][] lightButton = new LightButton[GRIDSIZE][GRIDSIZE];

  public Framed() {
    initGui();

    setTitle("Framed");
    setResizable(false);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private void initGui() {
    JLabel titleLabel = new JLabel("Framed");
    add(titleLabel, BorderLayout.PAGE_START);

    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE));
    add(centerPanel, BorderLayout.CENTER);

    for (int row = 0; row < GRIDSIZE; row++) {
      for (int col = 0; col < GRIDSIZE; col++) {
        lightButton[row][col] = new LightButton(row, col);
        lightButton[row][col].addActionListener(e -> {
          LightButton button = (LightButton) e.getSource();
          toggleLights(button.getRow(), button.getCol());
        });
        centerPanel.add(lightButton[row][col]);
      }
    }
  }

  private void toggleLights(int row, int col) {
    lightButton[row][col].toggle();

    // Top left corner
    if (row == 0 && col == 0) {
      lightButton[row][col + 1].toggle();
      lightButton[row + 1][col].toggle();
      lightButton[row + 1][col + 1].toggle();
    }

    // Top right corner
    else if (row == 0 && col == 2) {
      lightButton[row][col - 1].toggle();
      lightButton[row + 1][col].toggle();
      lightButton[row + 1][col - 1].toggle();
    }

    // Bottom left corner
    else if (row == 2 && col == 0) {
      lightButton[row][col + 1].toggle();
      lightButton[row - 1][col].toggle();
      lightButton[row - 1][col + 1].toggle();
    }
    // Bottom right corner
    else if (row == 2 && col == 2) {
      lightButton[row][col - 1].toggle();
      lightButton[row - 1][col].toggle();
      lightButton[row - 1][col - 1].toggle();
    }

    // Top row middle
    else if (row == 0 && col == 1) {
      lightButton[row][col - 1].toggle();
      lightButton[row][col + 1].toggle();
    }

    // Bottom row middle
    else if (row == 2 && col == 1) {
      lightButton[row][col - 1].toggle();
      lightButton[row][col + 1].toggle();
    }

    // Left side middle
    else if (row == 1 && col == 0) {
      lightButton[row - 1][col].toggle();
      lightButton[row + 1][col].toggle();
    }

    // Right side middle
    else if (row == 1 && col == 2) {
      lightButton[row - 1][col].toggle();
      lightButton[row + 1][col].toggle();
    }
  }

  public static void main(String[] args) {
    // TODO: 4-17
    try {
      String className = UIManager.getCrossPlatformLookAndFeelClassName();
      UIManager.setLookAndFeel(className);
    } catch (Exception e) {
    }
    EventQueue.invokeLater(Framed::new);
  }
}
