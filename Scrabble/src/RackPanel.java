import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

/**
 * Object to display the players rack on the GUI
 * 
 * Using gridLayout
 * @author Jacob
 *
 */
public class RackPanel extends JPanel {
	

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that sets the layout and other settings for the JPanel object
	 */
	public RackPanel() {

		setBorder(BorderFactory.createTitledBorder("Player's Rack"));
		setLayout(new GridLayout());
		Dimension PANEL_SIZE = getPreferredSize();
		PANEL_SIZE.width = 150;
		setPreferredSize(PANEL_SIZE);
		//c = new GridBagConstraints();

	}
	
	/**
	 * Method that updates the rack panel based on the current players rack
	 * @param rackIn - Players rack
	 * @param name - Players name
	 */
	public void setDisplay(Rack rackIn, String name) {
		
		setVisible(false);
		removeAll();
		setBorder(BorderFactory.createTitledBorder(name + "'s Rack"));
		setLayout(new GridLayout(7, 1, 1, 1));
		
		//Add JLabel which is created using tile image for as many tiles as are on the rack
		for(int i = 0; i < rackIn.getRackArray().size() ; i++) {
	
			JLabel tempLabel = new JLabel(rackIn.getRackArray().get(i).getImageIcon());
			
			add(tempLabel);
		}
		
		revalidate();
		repaint();
		setVisible(true);
		
	}
	

}
