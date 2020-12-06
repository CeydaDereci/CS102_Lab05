package GUIHangman.src;
import cs102.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldControlPanel extends JPanel {
    Hangman hangman;
    JTextField textField;
    public TextFieldControlPanel(Hangman hangman){
        this.hangman = hangman;
        this.textField = new JTextField(30);
        textListener textListener = new textListener();
        textField.addActionListener(textListener);
        setBackground(Color.pink);
        add(textField);
    }


    private class textListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String word = textField.getText();
            for(int i = 0; i < word.length(); i++)
                hangman.tryThis(word.charAt(i));
            textField.setText("");
        }


    }
}
