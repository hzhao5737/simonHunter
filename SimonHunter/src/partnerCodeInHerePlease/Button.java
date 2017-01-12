package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import gui.components.Action;
import gui.components.Component;
import simonHunter.ButtonInterfaceHunter;

public class Button extends Component implements ButtonInterfaceHunter {

	private Color color;
	private Action action;
	
	public Button() {
		super(50, 50, 120, 50);
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
	public void setName(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor(Color c) {
		color = c;
		update();
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

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(color);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 35, 25);
		g.setColor(Color.black);
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 35, 25);
//		g.setFont(new Font(getFont(),Font.PLAIN,getSize()));
//		FontMetrics fm = g.getFontMetrics();
//		
//		if(getText()!= null){
//			g.setColor(Color.white);
//			String t = getText();
//			//just in case text is too wide, cut off
//			int cutoff = t.length();
//			while(cutoff > 0 && fm.stringWidth(t) > getWidth()){
//				cutoff --;
//				t = t.substring(0,cutoff); 
//			}
//			g.drawString(t, (getWidth()-fm.stringWidth(t))/2, 
//					(getHeight()+fm.getHeight()-fm.getDescent())/2);
//		}
		
	}

	

}
