package GUIHangman.src;

import ConsoleHangman.src.HangmanModel;
import ConsoleHangman.src.IHangmanView;
import cs102.Hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButtonControl extends JButton implements IHangmanView {
    HangmanModel model;

    public NewGameButtonControl( HangmanModel model)
    {
        setText("New Game");
        this.model = model;
        ButtonListener listener = new ButtonListener();
        addActionListener(listener);
        updateView(model);
    }

    @Override
    public void updateView(Hangman hangmanModel) {
        if(hangmanModel.isGameOver())
            setEnabled(true);
        else
            setEnabled(false);
    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            model.initNewGame();
        }
    }

}
