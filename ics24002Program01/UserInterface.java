import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class UserInterface extends JPanel implements ActionListener {

	private int specificIndex;
	private String compareCar;
	private EntityClass [] allVehicles;
	private JTextArea textArea;
	private JPanel uiPanel, btnPanel, statusPanel;
	private JLabel vehMakeLbl, vehModelLbl, vehDoorsLbl, vehCylLbl, vehDspLtrLbl, searchCrtrLbl;
	private JLabel panelStatus;
	private JLabel [] arrayStatus;
	private JButton submitBtn, searchBtn, delBtn, quitBtn;
	private JTextField vehMakeTxt, vehModelTxt, vehDoorsTxt, vehCylTxt, vehDspLtrTxt, searchCrtrTxt;
	
	/**
	 * Constructor that initializes the allVehicles and arrayStatus arrays
	 * and sets the length of those arrays. The method then builds and implements
	 * the JPanels for the JFrame. 
	 *
	 * @param  numberVehicles the number of objects required in the allVehicles array
	 */
	public UserInterface (int numberVehicles) {
		/*
		 * initializing the allVehicles and arrayStatus arrays
		 * the value of numberVehicles in this program is set to int by
		 * 	the logic in the main method...any values other than numeric
		 *  throw an exception and abort the program
		 * precondition: the value of numberVehicles is numeric
		 */
		allVehicles = new EntityClass[numberVehicles];
		arrayStatus = new JLabel[numberVehicles];
		for (int i = 0; i < numberVehicles; i++) {
			allVehicles[i] = new EntityClass();
			arrayStatus[i] = new JLabel();
		}
		
		/*
		 * setting the value for specificIndex
		 */
		specificIndex = 0;

		/*
		 * precondition: the programmer has created a JFrame and is implementing a new user interface
		 * postcondition: you totally have a user interface...it's not pretty but it'll do...
		 */
		setPreferredSize(new Dimension(1500, 300));

		textArea = new JTextArea(4, 20);
		textArea.setBorder(new TitledBorder("Vehicle Information"));
		
		uiPanel = new JPanel(new GridLayout(6, 2));
		vehMakeLbl = new JLabel("Make: ");
		vehMakeTxt = new JTextField(20);
		vehModelLbl = new JLabel("Model: ");
		vehModelTxt = new JTextField(20);
		vehCylLbl = new JLabel("Number of Cylinders: ");
		vehCylTxt = new JTextField(2);
		vehDspLtrLbl = new JLabel("Engine Displacement (L): ");
		vehDspLtrTxt = new JTextField(5);
		vehDoorsLbl = new JLabel("Number of Doors: ");
		vehDoorsTxt = new JTextField(1);
		submitBtn = new JButton("SUBMIT");
		uiPanel.add(vehMakeLbl);
		uiPanel.add(vehMakeTxt);
		uiPanel.add(vehModelLbl);
		uiPanel.add(vehModelTxt);
		uiPanel.add(vehCylLbl);
		uiPanel.add(vehCylTxt);
		uiPanel.add(vehDspLtrLbl);
		uiPanel.add(vehDspLtrTxt);
		uiPanel.add(vehDoorsLbl);
		uiPanel.add(vehDoorsTxt);
		uiPanel.add(submitBtn);
		
		statusPanel = new JPanel(new GridLayout(arrayStatus.length, 1));		
		panelStatus = new JLabel("Number of Vehicles: " + allVehicles.length);
		Border panelStatusBorder = BorderFactory.createLineBorder(Color.RED, 2);
		panelStatus.setBorder(panelStatusBorder);
		statusPanel.add(panelStatus);
		for (int i = 0; i < arrayStatus.length; i++) {
			Border eachVehicleBorder = BorderFactory.createLineBorder(Color.ORANGE, 2);
			arrayStatus[i].setBorder(eachVehicleBorder);
			statusPanel.add(arrayStatus[i]);
		}
		displayArrayStatus();
		
		
		btnPanel = new JPanel(new GridLayout(5, 0));
		Border btnPnlBorder = BorderFactory.createLineBorder(Color.BLUE);
		btnPanel.setBorder(btnPnlBorder);
		delBtn = new JButton("DELETE");
		searchBtn = new JButton("SEARCH");
		quitBtn = new JButton("QUIT");
		searchCrtrLbl = new JLabel("Search Makes: ");
		searchCrtrTxt = new JTextField(20);
		btnPanel.add(searchCrtrLbl);
		btnPanel.add(searchCrtrTxt);
		btnPanel.add(searchBtn);
		btnPanel.add(delBtn);
		btnPanel.add(quitBtn);
		
		submitBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		delBtn.addActionListener(this);
		quitBtn.addActionListener(this);
		
		setLayout(new BorderLayout());
		add(uiPanel, BorderLayout.WEST);
		add(textArea, BorderLayout.SOUTH);
		add(btnPanel, BorderLayout.EAST);
		add(statusPanel, BorderLayout.CENTER);
	}

	/**
	 * This method handles actions associated with the buttons in the
	 * user interface JFrame.
	 * 
	 */
	public void actionPerformed(ActionEvent event) {
		Object thisEvent = event.getSource();
		
		if (thisEvent == submitBtn) {
			for (int index = 0; index <= allVehicles.length; index++) {
				if (index == allVehicles.length) {
					textArea.setText("NO ADDITIONAL SUBMISSIONS ALLOWED. LIMIT REACHED.");
					break;
				} else {
					if (allVehicles[index].getMake() == null) {
						try { 
							allVehicles[index].setMake(vehMakeTxt.getText());
							allVehicles[index].setModel(vehModelTxt.getText());
							allVehicles[index].setCylinders((int)Double.parseDouble(this.vehCylTxt.getText()));
							allVehicles[index].setDspLtr(Double.parseDouble(this.vehDspLtrTxt.getText()));
							allVehicles[index].setDoors((int)Double.parseDouble(this.vehDoorsTxt.getText()));
							textArea.setText("VEHICLE REGISTERED (" + (index + 1) + "): " + allVehicles[index].getMake() + " " + allVehicles[index].getModel());
							resetTextFields();
							displayArrayStatus(); 
						} catch (IllegalArgumentException e) {
							textArea.setText("Invalid vehicle characteristic entered. Operation aborted.");
							resetTextFields();
						}
						
						break;
					}
				}
			}
		} else if (thisEvent == searchBtn) {
			compareCar = searchCrtrTxt.getText().toUpperCase();
			String arrayCar;
			for (int i = 0; i < allVehicles.length; i++) {
				if (allVehicles[i].getMake() != null) {
					arrayCar = allVehicles[i].getMake();
					arrayCar = arrayCar.toUpperCase();
					if (compareCar.equals(arrayCar)) {
						textArea.setText("VEHICLE FOUND. " + compareCar + " SELECTED BY THE SYSTEM.");
						resetTextFields();
						specificIndex = i;
						break;
					}
				} else { 
					textArea.setText("VEHICLE " + compareCar + " NOT FOUND!!");
					resetTextFields();
				}
			}
		} else if (thisEvent == delBtn) {
			try {
				for (int i = 0; i < allVehicles.length; i++) {
					if (allVehicles[i].equals(compareCar)) {
						JOptionPane.showMessageDialog(null, "Vehicle: " + allVehicles[specificIndex].getMake().toUpperCase() + 
															" " + allVehicles[specificIndex].getModel().toUpperCase() + " deleted.");
						allVehicles[specificIndex] = new EntityClass();
						displayArrayStatus();
						textArea.setText("");
						break;
					}
				} 
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Invalid operation: No vehicle searched. Operation aborted.");
			}
			 /* if (!(compareCar.equals(""))) {
				JOptionPane.showMessageDialog(null, "Vehicle: " + allVehicles[specificIndex].getMake().toUpperCase() + 
													" " + allVehicles[specificIndex].getModel().toUpperCase() + " deleted.");
				allVehicles[specificIndex] = new EntityClass();
				displayArrayStatus();
				textArea.setText("");
			} */
		} else if (thisEvent == quitBtn) {
			JOptionPane.showMessageDialog(null, "Closing program.");
			System.exit(0);
		}
	}
	
	public void displayArrayStatus() {
		for (int i = 0; i < allVehicles.length; i++) {
			arrayStatus[i].setText(allVehicles[i].toString());
		}
	}
	
	/**
	 * Resets the values of the fields on the UserInterface JFrame. 
	 * <p> 
	 *
	 * @return      The text in all JTextFields in UserInterface are set to nothing.
	 * @throw       NullPointerException - when the JLabels specified
	 * 				not been created.
	 */
	public void resetTextFields() {
		try {
			searchCrtrTxt.setText("");		
			vehMakeTxt.setText("");
			vehModelTxt.setText("");
			vehCylTxt.setText("");
			vehDspLtrTxt.setText("");
			vehDoorsTxt.setText("");
		} catch (NullPointerException nullPtr) {
			JOptionPane.showMessageDialog(null, "The specified JLabels have not been initialized. The operation cannot be completed.");
		}
	}
	
}
