package gui;
import java.awt.BorderLayout;

import javax.swing.JApplet;


public class Main extends JApplet {

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public void init() {
		
		setSize(600, 500);
		setLayout(new BorderLayout());
		
		add(new Game(), BorderLayout.CENTER);
		
		System.out.println("init");
	}

	@Override
	public void start() {
		System.out.println("start");
	}

	@Override
	public void stop() {
		System.out.println("stop");
	}

}
