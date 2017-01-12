package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.image.BufferedImage;

import gui.components.Action;
import simonHunter.ButtonInterfaceHunter;

public class Button implements ButtonInterfaceHunter {

	private Color color;
	private Action action;
	private int y;
	private int x;
	
	public Button() {
		super();
	}

	@Override
	public void act() {
		action.act();

	}

	@Override
	public boolean isHovered(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public boolean isAnimated() {
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setName(String string) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAction(Action action) {
		// TODO Auto-generated method stub

	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setX(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setY(int i) {
		// TODO Auto-generated method stub

	}

}
