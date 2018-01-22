package atmPack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyATMPanel extends JFrame implements ActionListener {
	
	JLabel hundredsLabel, fiftiesLabel, twentiesLabel;
	JButton withdrawButton, depositButton, suspendButton;
	JTextField hundredsBox, fiftiesBox, twentiesBox;
	
	ATM atm = new ATM();
	
	public static void main(String[] args) {
		
		// Creates an ATM GUI
		MyATMPanel atm1 = new MyATMPanel();
		atm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        atm1.setTitle("ATM #1");
        atm1.pack();
        atm1.setVisible(true);
        
        // Creates an ATM GUI
        MyATMPanel atm2 = new MyATMPanel();
        atm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        atm2.setTitle("ATM #2");
        atm2.pack();
        atm2.setVisible(true);
        
        // Creates an ATM GUI
        MyATMPanel atm3 = new MyATMPanel();
        atm3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        atm3.setTitle("ATM #3");
        atm3.pack();
        atm3.setVisible(true);
	}
	
	// Constructor for each GUI
	public MyATMPanel() {
		setLayout(new GridBagLayout());
		GridBagConstraints position = new GridBagConstraints();
		position.insets = new Insets(10,5,10,5);
		
		// Label for hundreds
		hundredsLabel = new JLabel();
		position.gridy = 2;
		position.gridx = 4;
		hundredsLabel.setText(atm.getHundreds() + " Hundreds");
		add(hundredsLabel, position);
		
		// Label for fifties
		fiftiesLabel = new JLabel(atm.getFifties() + " Fifties");
		position.gridy = 2;
		position.gridx = 6;
		add(fiftiesLabel, position);
		
		// Label for twenties
		twentiesLabel = new JLabel(atm.getFifties() + " Twenties");
		position.gridy = 2;
		position.gridx = 8;
		add(twentiesLabel, position);
		
		// Withdrawal button
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setToolTipText("Withdraws money from this ATM");
		position.gridy = 6;
		position.gridx = 5;
		add(withdrawButton, position);
		withdrawButton.addActionListener(this);
		
		// Deposit button
		depositButton = new JButton("Deposit");
		depositButton.setToolTipText("Deposits money into this ATM");
		position.gridy = 6;
		position.gridx = 7;
		add(depositButton, position);
		depositButton.addActionListener(this);
		
		// Suspend button
		suspendButton = new JButton("SUSPEND");
		suspendButton.setToolTipText("Suspends all operations on ALL ATM's");
		position.gridy = 10;
		position.gridx = 6;
		add(suspendButton, position);
		suspendButton.addActionListener(this);
		
		// Text field for hundreds
		hundredsBox = new JTextField(10);
		hundredsBox.setToolTipText("Enter number of hundreds");
		position.gridy = 4;
		position.gridx = 4;
		hundredsBox.addActionListener(this);
		add(hundredsBox, position);
		
		// Text field for fifties
		fiftiesBox = new JTextField(10);
		fiftiesBox.setToolTipText("Enter number of fifties");
		position.gridy = 4;
		position.gridx = 6;
		fiftiesBox.addActionListener(this);
		add(fiftiesBox, position);
			
		// Text field for twenties
		twentiesBox = new JTextField(10);
		fiftiesBox.setToolTipText("Enter number of twenties");
		position.gridy = 4;
		position.gridx = 8;
		twentiesBox.addActionListener(this);
		add(twentiesBox, position);
		
	}

	// Handles button presses
	public void actionPerformed(ActionEvent e) {
		
		// Press Withdraw button
		if (e.getSource() == withdrawButton) {
			int h = Integer.parseInt(hundredsBox.getText());
			int f = Integer.parseInt(fiftiesBox.getText());
			int t = Integer.parseInt(twentiesBox.getText());
			
			atm.takeOut(h,t,f);
			
			hundredsBox.setText(atm.getHundreds() + " hundreds");
			fiftiesBox.setText(atm.getFifties() + " fifties");
			twentiesBox.setText(atm.getTwenties() + " twenties");
		}
		
		// Press Deposit button
		if (e.getSource() == depositButton) {
			int h = Integer.parseInt(hundredsBox.getText());
			int f = Integer.parseInt(fiftiesBox.getText());
			int t = Integer.parseInt(twentiesBox.getText());
			
			atm.putIn(h,t,f);
			
			hundredsBox.setText(atm.getHundreds() + " hundreds");
			fiftiesBox.setText(atm.getFifties() + " fifties");
			twentiesBox.setText(atm.getTwenties() + " twenties");
		}
		
		// Suspend button
		if (e.getSource() == suspendButton) {
			ATM.suspend(true);
		}
		
	}
	
}
