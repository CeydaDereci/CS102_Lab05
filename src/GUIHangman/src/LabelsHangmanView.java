package GUIHangman.src;

import ConsoleHangman.src.*;
import cs102.Hangman;

import javax.swing.*;
import java.awt.*;

public class LabelsHangmanView extends JPanel implements IHangmanView {

    JLabel numOfIncorrectTries;
    JLabel knownSoFar;
    JLabel usedLetters;
    JLabel hasLost;
    HangmanModel hangman;

    public LabelsHangmanView(HangmanModel hangman){
        this.hangman = hangman;
        numOfIncorrectTries = new JLabel(String.valueOf(hangman.getNumOfIncorrectTries()));
        knownSoFar = new JLabel(String.valueOf(hangman.getKnownSoFar()));
        usedLetters = new JLabel(hangman.getUsedLetters());
        hasLost = new JLabel();
        add(numOfIncorrectTries);
        add(knownSoFar);
        add(usedLetters);
        add(hasLost);
        setBackground(Color.DARK_GRAY);
        updateView(hangman);
        setPreferredSize(new Dimension(300,300) );
    }

    @Override
    public void updateView(Hangman hangman) {
        numOfIncorrectTries.setText(String.valueOf(hangman.getNumOfIncorrectTries()));
        knownSoFar.setText(String.valueOf(hangman.getKnownSoFar()));
        usedLetters.setText(String.valueOf(hangman.getUsedLetters()));
        if(hangman.hasLost())
            hasLost.setText("Game Over!");
        else
            hasLost.setText("");
    }
}
