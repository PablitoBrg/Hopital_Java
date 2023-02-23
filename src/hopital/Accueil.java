package hopital;

import java.awt.EventQueue;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JFrame;
import java.awt.Font;

public class Accueil implements ActionListener{

	JFrame frame;
	private static JLabel LabelBvn = new JLabel("Bienvenue sur Hopi !");
	private JButton ConectAcc, InscrAcc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil window = new Accueil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Accueil() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1082, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		LabelBvn.setFont(new Font("Tahoma", Font.PLAIN, 39));
		
		
		LabelBvn.setBounds(36, 43, 412, 54);
		layeredPane.add(LabelBvn);
		
		
		
		ConectAcc = new JButton("Connexion");
		ConectAcc.setFont(new Font("Tahoma", Font.PLAIN, 22));
		ConectAcc.setBounds(387, 189, 259, 90);
		layeredPane.add(ConectAcc);
		ConectAcc.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("Vous n'avez pas de compte ?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(36, 338, 282, 21);
		layeredPane.add(lblNewLabel);
		
		InscrAcc = new JButton("Inscription");
		InscrAcc.setBounds(80, 370, 102, 23);
		layeredPane.add(InscrAcc);
		InscrAcc.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ConectAcc) {
			connexion g = new connexion();
			g.frame.setVisible(true);
			frame.dispose();
			  
		}
		if(e.getSource() == InscrAcc) {
			inscr a = new inscr();
			a.frame.setVisible(true);
			frame.dispose();
	}

	}


}

