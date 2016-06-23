package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class ProgressDialog extends JDialog {
	
	private JButton cancelButton;
	private JProgressBar progressBar;
	
	public ProgressDialog(Window parent) {
		super(parent, "Messages Downloading...", ModalityType.APPLICATION_MODAL);
		
		cancelButton = new JButton("Cancel");
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		
		progressBar.setMaximum(10);
		
		progressBar.setString("Retrieving messages...");
		
		//progressBar.setIndeterminate(true);
		
		setLayout(new FlowLayout());
		
		Dimension size = cancelButton.getPreferredSize();
		size.width = 400;
		progressBar.setPreferredSize(size);
		
		add(progressBar);
		add(cancelButton);
		
		pack();
		
		setLocationRelativeTo(parent);
	}
	
	public void setMaximum(int value) {
		progressBar.setMaximum(value);
	}
	
	public void setValue(int value) {
		
		int progress = 100*value/progressBar.getMaximum();
		
		progressBar.setString(String.format("%d%% complete", progress));
		
		progressBar.setValue(value);
	}

	@Override
	public void setVisible(final boolean visible) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				if(visible == false) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else {
					progressBar.setValue(0);
				}
				
				ProgressDialog.super.setVisible(visible);
			}
		});
	}

	
	
}
