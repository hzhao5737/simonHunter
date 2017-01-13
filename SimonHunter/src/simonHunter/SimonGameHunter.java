package simonHunter;

public class SimonGameHunter extends gui6.GUIApplication {

	public SimonGameHunter(int width, int height) {
		super(width, height);
	}

	@Override
	public void initScreen() {
		SimonScreenHunter ssh = new SimonScreenHunter(getWidth(), getHeight());
		setScreen(ssh);
	}

	public static void main(String[] args) {
		SimonGameHunter sgh = new SimonGameHunter(800, 500);
		Thread game = new Thread(sgh);
		game.start();
	}
}
