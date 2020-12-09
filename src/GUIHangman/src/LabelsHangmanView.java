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
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(knownSoFar);
        add(usedLetters);
        add(numOfIncorrectTries);
        add(hasLost);
        setBackground(Color.DARK_GRAY);
        updateView(hangman);
        setPreferredSize(new Dimension(350,300) );
        usedLetters.setFont(new Font("Times New Roman", Font.BOLD, 20));
        knownSoFar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        numOfIncorrectTries.setFont(new Font("Times New Roman", Font.BOLD, 20));
        hasLost.setFont(new Font("Times New Roman", Font.BOLD, 20));
    }

    @Override
    public void updateView(Hangman hangman) {
        numOfIncorrectTries.setText("     Incorrect Tries: " + String.valueOf(hangman.getNumOfIncorrectTries()));
        knownSoFar.setText("     Known So Far: " + String.valueOf(hangman.getKnownSoFar()));
        usedLetters.setText("     Used letters: " + String.valueOf(hangman.getUsedLetters()));
        if(hangman.hasLost())
            hasLost.setText("     Game Over!");
        else
            hasLost.setText("");
    }
}
