/*
* File: MainController.java
* Author: Kisgyorgy Bendeguz
* Copyright: 2023, Kisgyorgy Bendeguz
* Date: 2023-12-05
* Licenc: MIT
*
*/
package controllers;

import java.util.Random;
import views.MainWindow;

public class MainController {

    enum Round  {
        PREFLOP,
        FLOP,
        TURN,
        RIVER,
        SHOW
    }
    /**
     * Return a random number from 0 to 12
     * We have 13 card
     * @return  int  Random card selection
     * @see java.util.Random
     */
    private int getRandom() {
        Random random = new Random();
        return random.nextInt(13);
    }
    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.initEvent();
    }
    MainWindow mainWindow;
    String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "B", "D", "K", "A"};
    Round round = Round.PREFLOP;    

    public void initEvent() {
        this.mainWindow.startButton.addActionListener(
            event -> {
                Random random = new Random();

                int hcard1 = random.nextInt(13);
                int hcard2 = random.nextInt(13);

                random = null;

                String humanCard1Str = cards[hcard1];
                String humanCard2Str = cards[hcard2];


                this.mainWindow.humanCard1Button.setText(humanCard1Str);
                this.mainWindow.humanCard2Button.setText(humanCard2Str);

                System.out.printf(
                    "%d %d\n", hcard1, hcard2);

            });
        this.mainWindow.stopButton.addActionListener (
            event -> {                
                System.out.println("Állj");
            });

        this.mainWindow.nextButton.addActionListener(
            event -> {
                String flop1Str;
                String flop2Str;
                String flop3Str;

                if (this.round == Round.PREFLOP) {                   
                    int flop1=getRandom();
                    int flop2=getRandom();
                    int flop3=getRandom();

                    flop1Str=cards[flop1];
                    flop2Str=cards[flop2];
                    flop3Str=cards[flop3];
                    
                    this.mainWindow.flop1Button.setText(flop1Str);
                    this.mainWindow.flop2Button.setText(flop2Str);
                    this.mainWindow.flop3Button.setText(flop3Str);

                    this.mainWindow.flop1Button.setVisible(true);
                    this.mainWindow.flop2Button.setVisible(true);
                    this.mainWindow.flop3Button.setVisible(true);

                    this.round = Round.FLOP;
                    return;
                }

                if (this.round == Round.FLOP) {
                    
                    int turn = getRandom();

                    this.mainWindow.turnButton.setText(cards[turn]);
                    this.mainWindow.turnButton.setVisible(true);

                    this.round=Round.TURN;
                    return; 
                }

                if (this.round == Round.TURN) {

                    int river=getRandom();

                    this.mainWindow.riverButton.setText(cards[river]);
                    this.mainWindow.riverButton.setVisible(true);

                    this.round = Round.RIVER;

                }
            }
        );

    }

}
