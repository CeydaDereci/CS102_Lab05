package GUIHangman.src;
import ConsoleHangman.src.*;
import cs102.Hangman;

import java.awt.*;
import javax.swing.*;

public class GallowsHangmanView extends JPanel implements IHangmanView{

    HangmanModel hangman;
    public GallowsHangmanView(HangmanModel hangman){
        this.hangman = hangman;
        updateView(hangman);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(20,250,270,20);
        g.fillRect(50, 20,20,250);
        g.fillRect(50,20,200,20);
        g.fillRect(200,30,10,40);

        if(hangman.getNumOfIncorrectTries() >= 1)
            g.drawOval(180,70,50,50);
        if(hangman.getNumOfIncorrectTries() >= 2)
            g.drawLine(205,120,205,180);
        if(hangman.getNumOfIncorrectTries() >= 3)
            g.drawLine(205,130,250,160);
        if(hangman.getNumOfIncorrectTries() >= 4)
            g.drawLine(205,130,160,160);
        if(hangman.getNumOfIncorrectTries() >= 5)
            g.drawLine(205,180,250,220);
        if(hangman.getNumOfIncorrectTries() >= 6)
            g.drawLine(205,180,160,220);
        if(hangman.isGameOver()) {
            if(!hangman.hasLost())
                g.drawString("YOU WIN!", 300, 50);
            else
                g.drawString("YOU LOST!", 300, 50);
        }

    }

    @Override
    public void updateView(Hangman hangmanModel) {
        repaint();
    }
}
