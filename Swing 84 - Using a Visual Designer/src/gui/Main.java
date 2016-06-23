package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.Timer;


public class Main extends JApplet implements ActionListener {
	
	private Timer timer;
	private Game game;
	private StartPanel startPanel;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
		
		startPanel = new StartPanel();
		game = new Game();
		
		startPanel.setListener(new StartPanelListener() {
			public void startGame() {
				System.out.println("Hello there");
			}
		});
		
		timer = new Timer(20, this);
		
		setSize(600, 500);
		setLayout(new BorderLayout());
		
		add(startPanel, BorderLayout.CENTER);
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
