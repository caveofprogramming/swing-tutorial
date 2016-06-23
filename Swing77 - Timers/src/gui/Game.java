package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;


public class Game extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(Color.black);
		g2.fillRect(0, 0, getWidth(), getHeight());
		
		g2.setColor(Color.red);
		g2.fill(new Ellipse2D.Double(100, 100, 15, 15));
		
		g2.setColor(Color.blue);
		g2.fill(new RoundRectangle2D.Double(200, 200, 100, 10, 20, 20));
	}
	
}
