/**
 * @author Robert Fewins-Kalb
 * 
 *  This program allows the user to manage a number of vehicles and set
 * the properties associated with each vehicle through the use of an array.
 *  The number of elements in the array is set by the user at the beginning 
 * of the program run. Once the number of vehicles is set, it cannot be changed.
 *  Users can select and remove vehicles from the list once they have created it.
 *  
 */



import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class EntityProgram extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int numberVeh = 0;
			try {
				String numVehicles = JOptionPane.showInputDialog("Enter the number of vehicles...");
				numberVeh = (int)Double.parseDouble(numVehicles);
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Invalid value entered. Aborting program.");
				System.exit(-1);
			} catch (Exception cancelBtn) {
				JOptionPane.showMessageDialog(null, "Operation Cancelled.");
				System.exit(0);
			}
			JFrame entityObject = new JFrame();
			entityObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			entityObject.getContentPane().add(new UserInterface(numberVeh));
			entityObject.pack();
			entityObject.setVisible(true);
	
	}
}
