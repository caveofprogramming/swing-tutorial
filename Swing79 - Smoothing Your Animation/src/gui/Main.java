package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.Timer;


public class Main extends JApplet implements ActionListener {
	
	private Timer timer;
	private Game game;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
		
		game = new Game();
		
		timer = new Timer(20, this);
		
		setSize(600, 500);
		setLayout(new BorderLayout());
		
		add(game, BorderLayout.CENTER);
		
		System.out.println("init");
	}

	@Override
	public void start() {
		timer.start();
	}

	@Override
	public void stop() {
		timer.stop();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		game.update();
	}

}
