package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartPanel extends JPanel {
	
	private StartPanelListener listener;

	/**
	 * Create the panel.
	 */
	public StartPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblSwingAppletDemo = new JLabel("Swing Applet Demo");
		lblSwingAppletDemo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblSwingAppletDemo = new GridBagConstraints();
		gbc_lblSwingAppletDemo.anchor = GridBagConstraints.SOUTH;
		gbc_lblSwingAppletDemo.weighty = 0.5;
		gbc_lblSwingAppletDemo.insets = new Insets(0, 0, 5, 0);
		gbc_lblSwingAppletDemo.gridx = 0;
		gbc_lblSwingAppletDemo.gridy = 0;
		add(lblSwingAppletDemo, gbc_lblSwingAppletDemo);
		
		JButton btnNewSimulation = new JButton("New Simulation");
		btnNewSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fireStartGame();
			}
		});
		GridBagConstraints gbc_btnNewSimulation = new GridBagConstraints();
		gbc_btnNewSimulation.insets = new Insets(20, 0, 0, 0);
		gbc_btnNewSimulation.anchor = GridBagConstraints.NORTH;
		gbc_btnNewSimulation.weighty = 0.5;
		gbc_btnNewSimulation.gridx = 0;
		gbc_btnNewSimulation.gridy = 1;
		add(btnNewSimulation, gbc_btnNewSimulation);

	}
	
	public void setListener(StartPanelListener listener) {
		this.listener = listener;
	}
	
	private void fireStartGame() {
		if(listener != null) listener.startGame();
	}

}
