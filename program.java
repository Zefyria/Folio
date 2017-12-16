/*	Results.java
	
	User enters three SAC scores %.
	User enters exam score %.
	Program calculates estimated score (average of SACs).
	Program displays all results, and whether actual exam score was higher or lower than estimated.
	
	Programmer: Emily Mueller
	Date created: 20 June 2017
*/

import javax.swing.*; // J-collection
import java.awt.*; // UI
import java.awt.event.*; // Listeners

public class Results extends JFrame implements ActionListener {
	// instantiate objects
	JLabel lblHeader = new JLabel("Year 11 Computing");
	JLabel lblSAC1 = new JLabel("SAC 1 result (%)");
	JTextField txtSAC1 = new JTextField(5);
	JLabel lblSAC2 = new JLabel("SAC 2 result (%)");
	JTextField txtSAC2 = new JTextField(5);
	JLabel lblSAC3 = new JLabel("SAC 3 result (%)");
	JTextField txtSAC3 = new JTextField(5);
	JLabel lblExam = new JLabel("Actual exam (%)");
	JTextField txtExam = new JTextField(5);
	JButton btnCalculate = new JButton("Calculate");
	JButton btnClear = new JButton("Clear");
	JLabel lblEstimated = new JLabel("Estimated exam (%)");
	JTextField txtEstimated = new JTextField(5);
	JTextField txtHighLow = new JTextField(5);
	
	// constructor
	public Results() {
		setTitle("Results");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pane = new JPanel();
        setContentPane(pane);
        pane.add(lblHeader);
		lblHeader.setFont(new Font("Sans Serif", Font.BOLD, 20));
		pane.add(lblSAC1);
		pane.add(txtSAC1);
		pane.add(lblSAC2);
		pane.add(txtSAC2);
		pane.add(lblSAC3);
		pane.add(txtSAC3);
		pane.add(lblExam);
		pane.add(txtExam);
		pane.add(btnCalculate);
		pane.add(btnClear);
		pane.add(lblEstimated);
		pane.add(txtEstimated);
		pane.add(txtHighLow);
		// add ActionListener
		btnCalculate.addActionListener(this);
		btnClear.addActionListener(this);
		// look like labels
		txtEstimated.setOpaque(false);
		txtHighLow.setOpaque(false);
		// user cannot be interact
		txtEstimated.setEditable(false);
		txtEstimated.setFocusable(false);
		txtHighLow.setEditable(false);
		txtHighLow.setFocusable(false);
	}
	
	// ActionListener
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCalculate) {
			double estimate = (Double.parseDouble(txtSAC1.getText()) + Double.parseDouble(txtSAC2.getText()) + Double.parseDouble(txtSAC3.getText())) / 3;
			txtEstimated.setText(String.format("%.2f", estimate));
			
			double highLow = Double.parseDouble(txtExam.getText()) - estimate;
			if (highLow >= 0)
				txtHighLow.setText("+");
			txtHighLow.setText(txtHighLow.getText() + String.format("%.2f", highLow));
			
			btnClear.requestFocus(true);
			btnCalculate.setEnabled(false);
		} else {
			btnCalculate.setEnabled(true);
			txtSAC1.requestFocus(true);
			txtSAC1.setText("");
			txtSAC2.setText("");
			txtSAC3.setText("");
			txtExam.setText("");
			txtEstimated.setText("");
			txtHighLow.setText("");
		}
	}
		
	// main method
	public static void main(String[] args) {
		Results results = new Results();
		results.setSize(220, 280);
		results.setVisible(true);
		results.setLocationRelativeTo(null); // centre of main monitor
	}
}
