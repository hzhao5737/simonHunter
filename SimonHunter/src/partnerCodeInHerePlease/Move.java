package partnerCodeInHerePlease;

import simonHunter.ButtonInterfaceHunter;
import simonHunter.MoveInterfaceHunter;

public class Move implements MoveInterfaceHunter {
	
	private ButtonInterfaceHunter b;

	public Move(ButtonInterfaceHunter b) {
		this.b = b;
	}

	@Override
	public ButtonInterfaceHunter getButton() {
		return b;
	}
}
