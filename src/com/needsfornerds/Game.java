package com.needsfornerds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JButton[] buttons = new JButton[9];
    int buttonClicked = -1;
    boolean ifWin = false;

    public Game() {

        setTitle("Tic Tac Toe");
        setSize(500, 500);
        setLocation(500, 100);
        setIconImage(new ImageIcon("src\\img\\logo.png").getImage());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void createGUI() {

        this.setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(3, 3));

        for (int i=0; i<9; i++) {
            JButton button = new JButton();
            button.setBackground(Color.WHITE);
            button.setName(i+"");
            panel.add(button);
            buttons[i] = button;
            button.addActionListener(this);
        }
        this.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        buttonClicked++;

        if (buttonClicked % 2 == 0) {
            button.setIcon(new ImageIcon("src\\img\\cross.png"));
            button.setName("X");
        }
        else {
            button.setIcon(new ImageIcon("src\\img\\zero.png"));
            button.setName("O");
        }
        this.checkWin();
    }

    public void checkWin() {

        // horizontal wins
        if (buttons[0].getName().equals(buttons[1].getName())) {
            if (buttons[1].getName().equals(buttons[2].getName())) {
                this.setWinOption(buttons[0].getName());
            }
        }
        if (buttons[3].getName().equals(buttons[4].getName())) {
            if (buttons[4].getName().equals(buttons[5].getName())) {
                this.setWinOption(buttons[3].getName());
            }
        }
        if (buttons[6].getName().equals(buttons[7].getName())) {
            if (buttons[7].getName().equals(buttons[8].getName())) {
                this.setWinOption(buttons[6].getName());
            }
        }

        // vertical wins
        if (buttons[0].getName().equals(buttons[3].getName())) {
            if (buttons[3].getName().equals(buttons[6].getName())) {
                this.setWinOption(buttons[0].getName());
            }
        }
        if (buttons[1].getName().equals(buttons[4].getName())) {
            if (buttons[4].getName().equals(buttons[7].getName())) {
                this.setWinOption(buttons[1].getName());
            }
        }
        if (buttons[2].getName().equals(buttons[5].getName())) {
            if (buttons[5].getName().equals(buttons[8].getName())) {
                this.setWinOption(buttons[2].getName());
            }
        }

        // diagonally wins
        if (buttons[0].getName().equals(buttons[4].getName())) {
            if (buttons[4].getName().equals(buttons[8].getName())) {
                this.setWinOption(buttons[0].getName());
            }
        }
        if (buttons[2].getName().equals(buttons[4].getName())) {
            if (buttons[4].getName().equals(buttons[6].getName())) {
                this.setWinOption(buttons[2].getName());
            }
        }

        // check draw
        this.setDrawOption();
    }

    public void setWinOption(String player) {

        String text = "Player " + player + " wins!\nDo you want to play again?";
        int option = JOptionPane.showConfirmDialog((Component) null, text,"alert", JOptionPane.YES_NO_OPTION);
        ifWin = true;

        if (option == 0) {
            Main.callGame();
        }
        else {
            System.exit(0);
        }
    }

    public void setDrawOption() {

        for (int i=0; i<9; i++) {
            if (!buttons[i].getName().equals("X") && !buttons[i].getName().equals("O")) {
                int value = Integer.parseInt(buttons[i].getName());
                if (value >= 0 && value < 9) {
                    return;
                }
            }
        }

        if (!ifWin) {
            String text = "Draw game!\nDo you want to play again?";
            int option = JOptionPane.showConfirmDialog((Component) null, text, "alert", JOptionPane.YES_NO_OPTION);

            if (option == 0) {
                Main.callGame();
            } else {
                System.exit(0);
            }
        }
    }
}
