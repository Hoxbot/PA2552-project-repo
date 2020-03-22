package pa2552_maven_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BasicWindow implements ActionListener {
	//Create encryption class object
	SimpleCryption crpt = new SimpleCryption();
	
	//Create a window
	JFrame win = new JFrame("Simple Encryption Program");
	
	//Create the two buttons
	JButton encrypt_btn = new JButton("Encrypt Text");
	JButton decrypt_btn = new JButton("Decrypt Text");
	
	//Create two text areas
	JTextArea input_box = new JTextArea(5, 20);
	JTextArea output_box = new JTextArea(5, 20);
	
	public void PaintWindow() {
		//Set window data
		win.setSize(400, 400);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		//Create a panel and add the two buttons
		JPanel button_pnl = new JPanel();
		button_pnl.add(encrypt_btn);
		button_pnl.add(decrypt_btn);
				
		//Link buttons to action listeners
		encrypt_btn.addActionListener(this);
		decrypt_btn.addActionListener(this);
				
		//Set stuff for input
		JLabel input_lbl = new JLabel();
		input_lbl.setText("Input");
		//input_box.setBounds(50, 100, 300, 50);
		JPanel input_pnl = new JPanel();
		input_pnl.add(input_lbl);
		input_pnl.add(input_box);
				
		//Set stuff for output
		JLabel output_lbl = new JLabel();
		output_lbl.setText("Output");
		//output_box.setBounds(50, 200, 300, 50);
		JPanel output_pnl = new JPanel();
		output_pnl.add(output_lbl);
		output_pnl.add(output_box);
		output_box.setEditable(false);
				
		//Add stuff to window
		JPanel main_pnl = new JPanel();
		main_pnl.setLayout(new BoxLayout(main_pnl, BoxLayout.Y_AXIS));
				
		main_pnl.add(input_pnl);
		main_pnl.add(output_pnl);
		main_pnl.add(button_pnl);
				
		win.getContentPane().add(main_pnl);
				
		//Update window
		win.setVisible(true);
		win.repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		//Get the text from input field
		String input_txt = input_box.getText();
		
		//Encrypt/Decrypt
		String altered_txt = "";
		if(e.getSource() == encrypt_btn) {altered_txt = crpt.EncryptString(input_txt);}
		else {altered_txt = crpt.DecryptString(input_txt);}
		
		//Write to output field
		output_box.setText(altered_txt);
	}
}
