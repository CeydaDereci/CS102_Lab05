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
        setPreferredSize(new Dimension(400,400));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(20,250,270,20);
        g.fillRect(50, 20,20,250);
        g.fillRect(50,20,200,20);
        g.fillRect(200,30,10,40);

        g.drawString("Known so far: " + hangman.getKnownSoFar(), 100,300);
        g.drawString("Used Letters: "+ hangman.getUsedLetters(),100,320);
        g.drawString(String.valueOf("Incorrect tries: " +  hangman.getNumOfIncorrectTries()),100,340);

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
                g.drawString("YOU WIN!", 100, 360);
            else
                g.drawString("YOU LOST!", 100, 360);
        }


    }

    @Override
    public void updateView(Hangman hangmanModel) {
        repaint();
    }
}
