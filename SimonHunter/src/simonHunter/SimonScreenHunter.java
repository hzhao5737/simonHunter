package simonHunter;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import gui6.components.Action;
import gui6.components.TextLabel;
import gui6.components.Visible;
import partnerCodeInHerePlease.Button;
import partnerCodeInHerePlease.Move;
import partnerCodeInHerePlease.Progress;

public class SimonScreenHunter extends gui6.ClickableScreen implements Runnable {

	private ProgressInterfaceHunter progress;
	private ButtonInterfaceHunter[] button;
	private ArrayList<MoveInterfaceHunter> moves;
	private TextLabel label;
	private int roundNumber;
	private boolean isUserTurn;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreenHunter(int width, int height) {
		super(width, height);
		Thread play = new Thread(this);
		play.start();
	}

	@Override
	public void run() {
		label.setText("");
	    nextRound();
	}

	private void nextRound() {
		isUserTurn = false;
		roundNumber ++;
		progress.setRound(roundNumber);
		moves.add(randomMove());
		progress.setSequenceSize(moves.size());
		changeText("Simon's turn.");
		label.setText("");
		playSequence();
		changeText("Your turn.");
		label.setText("");
		isUserTurn = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceHunter b = null;
		for(MoveInterfaceHunter m: moves){
			if(b!=null){
				b.dim();
			}
			b = m.getButton();
			b.highlight();
			int sleepTime = (int)(1000*(2.0/(+2)));
			try {
				Thread.sleep((long)sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Color[] colors = {Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.white};
		String[] names = {"RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "WHITE"};
		int buttonCount = 6;
		button = new ButtonInterfaceHunter[buttonCount];
		for(int i = 0; i < buttonCount; i++ ){
			button[i] = getAButton();
			button[i].setName(names[i]);
			button[i].setColor(colors[i]);
			button[i].setX(50 + (i *75));
			button[i].setY(200);
			final ButtonInterfaceHunter b = button[i];
			b.dim();
			button[i].setAction(new Action() {
				public void act() {
					if(isUserTurn){
						Thread blink = new Thread(new Runnable() {
							public void run() {
								b.highlight();
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
							}
						});
						blink.start();
						if(moves.get(sequenceIndex).getButton() == b){
							sequenceIndex++;
						}else if(isUserTurn){
							gameOver();
							return;
						}
						if(sequenceIndex == moves.size()){
							Thread nextRound = new Thread(SimonScreenHunter.this);
							nextRound.start();
						}
					}
				}
			});
			viewObjects.add(button[i]);
		}
		progress = getProgress();
		label = new TextLabel(180,30,300,40,"Let's play Simon!");
		moves = new ArrayList<MoveInterfaceHunter>();
		//add 2 moves to start
		lastSelectedButton = -1;
		moves.add(randomMove());
		moves.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceHunter randomMove() {
		int select = (int) (Math.random()*button.length);
		while(select == lastSelectedButton){
			select = (int) (Math.random()*button.length);
		}
		lastSelectedButton = select;
		return new Move(button[select]);
	}

	private ProgressInterfaceHunter getProgress() {
		return new Progress();
	}
	
	private void gameOver() {
		progress.gameOver();
	}

	private ButtonInterfaceHunter getAButton() {
		return new Button();
	}

	private void changeText(String string) {
		label.setText(string);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
