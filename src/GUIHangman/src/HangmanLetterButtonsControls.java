package GUIHangman.src;

import ConsoleHangman.src.HangmanModel;
import ConsoleHangman.src.IHangmanView;
import cs102.Hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanLetterButtonsControls extends LetterButtonControls implements ActionListener, IHangmanView {

    HangmanModel hangmanModel;

    public HangmanLetterButtonsControls(String letters, int row, int column, HangmanModel hangmanModel) {
        super(letters,row,column);
        hangmanModel = hangmanModel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        char c = b.getText().charAt(0);
        hangmanModel.tryThis(c);
    }

    @Override
    public void updateView(Hangman hangmanModel) {
        if (!hangmanModel.getUsedLetters().equals(""))
            this.setDisabled(hangmanModel.getUsedLetters());

        if (hangmanModel.isGameOver())
            setEnabledAll(true);
    }
}
