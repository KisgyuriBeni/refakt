/*
* File: MainWindow.javaut
* Author: Kisgyorgy Bendeguz
* Copyright: 2023, Kisgyorgy Bendeguz
* Date: 2023-12-05
* Licenc: MIT
*
*/
package views;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
    public JButton startButton = new JButton("Start");
    public JButton stopButton = new JButton("Stop");
    public JButton nextButton = new JButton("Következő");

    public JPanel tablePanel = new JPanel();
    public JPanel handPanel = new JPanel();
    public JPanel buttonPanel = new JPanel();

    public JButton flop1Button = new JButton("");
    public JButton flop2Button = new JButton("");
    public JButton flop3Button = new JButton("");

    public JButton humanCard1Button = new JButton();
    public JButton humanCard2Button = new JButton();

    public JButton turnButton = new JButton();
    public JButton riverButton = new JButton();


    public MainWindow() {
        this.tablePanel.setSize(100, 100);
        this.tablePanel.setBackground(Color.LIGHT_GRAY);
        this.tablePanel.add(flop1Button);
        this.tablePanel.add(flop2Button);
        this.tablePanel.add(flop3Button);
        /* A flop-nak nem kell megjelennie flop előtti állapotban */
        this.flop1Button.setVisible(false);
        this.flop2Button.setVisible(false);
        this.flop3Button.setVisible(false);
        this.handPanel.add(this.humanCard1Button);
        this.handPanel.add(this.humanCard2Button);

        this.buttonPanel.add(startButton);
        this.buttonPanel.add(nextButton);
        this.buttonPanel.add(stopButton);
        this.tablePanel.add(turnButton);
        this.tablePanel.add(riverButton);
        this.turnButton.setVisible(false);
        this.riverButton.setVisible(false);
                

        this.setLayout(new BoxLayout(
            this.getContentPane(), 
            BoxLayout.PAGE_AXIS));

        this.add(buttonPanel);
        this.add(tablePanel);
        this.add(handPanel);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 250);
    }
    
}
