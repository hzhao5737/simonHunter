package partnerCodeInHerePlease;

import simonHunter.ButtonInterfaceHunter;
import simonHunter.MoveInterfaceHunter;

public class Move implements MoveInterfaceHunter {
	
	private ButtonInterfaceHunter button; 

	@Override
	public ButtonInterfaceHunter getButton() {
		return button;
	}
	
	public Move(ButtonInterfaceHunter button) {
		this.button = button;
	}

}
