package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

public class ServerTreeCellRenderer implements TreeCellRenderer {

	private JCheckBox leafRenderer;
	private DefaultTreeCellRenderer nonLeafRenderer;
	
	private Color textForeground;
	private Color textBackground;
	private Color selectionForeground;
	private Color selectionBackground;
	

	public ServerTreeCellRenderer() {
		leafRenderer = new JCheckBox();
		nonLeafRenderer = new DefaultTreeCellRenderer();

		nonLeafRenderer.setLeafIcon(Utils.createIcon("/images/Server16.gif"));
		nonLeafRenderer.setOpenIcon(Utils
				.createIcon("/images/WebComponent16.gif"));
		nonLeafRenderer.setClosedIcon(Utils
				.createIcon("/images/WebComponentAdd16.gif"));
		
		textForeground = UIManager.getColor("Tree.textForeground");
		textBackground = UIManager.getColor("Tree.textBackground");
		selectionForeground = UIManager.getColor("Tree.selectionForeground");
		selectionBackground = UIManager.getColor("Tree.selectionBackground");

	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {

		if(leaf) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
			ServerInfo nodeInfo = (ServerInfo)node.getUserObject();
			
			if(selected) {
				leafRenderer.setForeground(selectionForeground);
				leafRenderer.setBackground(selectionBackground);
			}
			else {
				leafRenderer.setForeground(textForeground);
				leafRenderer.setBackground(textBackground);
			}
			
			leafRenderer.setText(nodeInfo.toString());
			leafRenderer.setSelected(nodeInfo.isChecked());
			return leafRenderer;
		}
		else {
			return nonLeafRenderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		}
	}

}
