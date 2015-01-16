import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/*
 *filename: Test.java
 *Author:SuizhuShengqi
 *Date 2014Äê12ÔÂ1ÈÕ
 *Class:CSC172
 *Lab Session:MW	18:15-19:30
 */

public class SHA256Test extends JPanel
{	
	public static void main(String[] args)
	{
		int x = 600;
		int y = 600;
		JFrame frame = new JFrame("SHA256 Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new SHA256Panel( ));
		frame.setSize(y,x);
		frame.setLocationRelativeTo(null); 
		frame.setResizable(false);
		frame.setVisible(true);
	}
}

class SHA256Panel extends JPanel {
	private JButton calcButton = new JButton("Calculate");
	private JButton clearButton = new JButton("Clear");
	private JTextArea input = new JTextArea("");
	private JTextField output = new JTextField("");
	private SHA256 SHA;
	ButtonListener listener = new ButtonListener();
	ButtonListener2 listener2 = new ButtonListener2();;
	
	public SHA256Panel() {
		input.setLineWrap(true);
		calcButton.setFont( new Font( "Arial",1, 15 ) );
		calcButton.setBounds( 400, 500, 100, 40 );
		calcButton.addActionListener(listener);
		input.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791")));
		clearButton.setFont( new Font( "Arial",1, 15 ) );
		clearButton.setBounds( 100, 500, 100, 40 );
		clearButton.addActionListener(listener2);

		setLayout(null);//clear layout
		add(calcButton);
		add(clearButton);
		add(input);
		add(output);
		input.setBounds(30,50, 540, 380);
		input.setText("Input message here");
		output.setBounds(30,450,540, 30);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			SHA = new SHA256(input.getText());
			output.setText(SHA.getHash());
		}
	}
	
	private class ButtonListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			input.setText("");
		}
	}
}