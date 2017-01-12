package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.Component;
import simonHunter.ProgressInterfaceHunter;

public class Progress extends Component implements ProgressInterfaceHunter {
	
	private String roundString;
	private String sequenceString;
	private boolean gameOver;

	public Progress() {
		super(50, 50, 120, 50);
	}

	@Override
	public void gameOver() {
		gameOver = true;
		update();

	}

	@Override
	public void setRound(int roundNumber) {
		roundString = "Round: " + roundNumber;
		update();

	}

	@Override
	public void setSequenceSize(int size) {
		sequenceString = "Sequence Size: " + size;
		update();

	}

	@Override
	public void update(Graphics2D arg0) {
		String gameOverString = "You lost!";
		
		arg0.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = arg0.getFontMetrics();
		
		arg0.setColor(new Color(220, 220, 220));
		arg0.fillRect(0, 0, 120, 50);
		arg0.setColor(Color.black);
		
		if(gameOver){
			arg0.setColor(Color.red);
			
			arg0.drawString(gameOverString, (120 - fm.stringWidth(gameOverString)) / 2, 20);

		}else{
			
			if(roundString != null && sequenceString != null){

				arg0.drawString(roundString, (120 - fm.stringWidth(roundString)) / 2, 20);
			}
		}
		
		arg0.drawString(sequenceString, (120 - fm.stringWidth(sequenceString)) / 2, 40);

	}

}
