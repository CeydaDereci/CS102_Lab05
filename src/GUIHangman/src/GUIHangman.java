package GUIHangman.src;

import cs102.IHangmanSetup;
import ConsoleHangman.src.*;


/**
 * GUIHangman - GUI based MVC test for cs102 Hangman & IHangmanSetup
 *
 * @author David
 * @version 1.00 2013/4/7
 */

public class GUIHangman
{
	public GUIHangman()
	{
    	System.out.println( "Start of GUIHangman\n");

		HangmanModel		hangman;
		IHangmanSetup		basicSetup;
		ConsoleHangmanView	consoleView;
		TextFieldControlPanel tfcPanel;
		SimpleJFrame frame;
		NewGameButtonControl newGameButton;
		LabelsHangmanView labels;
		GallowsHangmanView gallow;
		HangmanLetterButtonsControls controls;


		basicSetup = new BasicSetup();
		hangman = new HangmanModel( basicSetup);

		consoleView = new ConsoleHangmanView();
		tfcPanel = new TextFieldControlPanel(hangman);
		newGameButton = new NewGameButtonControl(hangman);
		labels = new LabelsHangmanView(hangman);
		gallow = new GallowsHangmanView(hangman);
		controls = new HangmanLetterButtonsControls(hangman.getAllLetters(),13,2,hangman);
		controls.addActionListener(new HangmanLetterButtonsController(hangman));

		hangman.addView(consoleView);
		hangman.addView(newGameButton);
		hangman.addView(labels);
		hangman.addView(gallow);
		hangman.addView(controls);

		frame = new SimpleJFrame( "GUIHangman", 	// title
							gallow,			// center
							tfcPanel, newGameButton,		// north, south
							controls, labels );	// east, west

		// this is an infinite loop reading from the console... not clever!
		ConsoleControl.controlFor( hangman);
	}

	public static void main( String[] args)
	{
		new GUIHangman();

//		// This is the approved way to initialise GUIs
//		// but won't work with the ConsoleControl as is!
//		// --------------------------------------------
//		SwingUtilities.invokeLater(
//			new Runnable() {
//			    public void run() {
//	        		new GUIHangman();
//	        		new GUIHangman();
//	    		}
//			});
	}

} // end of class GUIHangman
