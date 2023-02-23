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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Action;
import javax.swing.JFrame;
import java.awt.Font;

public class connexion implements ActionListener {

	JFrame frame;
	private JLayeredPane layeredPane = new JLayeredPane();
	private JPasswordField passwordField;
	static JTextField textField;
	private JButton ConectCo, retourCo; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connexion window = new connexion();
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
	public connexion() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1082, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Veuillez vous connectez");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(108, 22, 400, 55);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNumSecu = new JLabel("Numéro de sécurité social :");
		lblNumSecu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumSecu.setBounds(147, 128, 277, 31);
		layeredPane.add(lblNumSecu);
		
		textField = new JTextField();
		textField.setBounds(147, 186, 185, 20);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblmdp = new JLabel("Mot de passe :");
		lblmdp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblmdp.setBounds(147, 269, 185, 31);
		layeredPane.add(lblmdp);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(147, 331, 185, 20);
		layeredPane.add(passwordField);
		passwordField.setColumns(10);
		
		ConectCo = new JButton("Se connecter");
		ConectCo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ConectCo.setBounds(147, 418, 117, 20);
		layeredPane.add(ConectCo);
		ConectCo.addActionListener(this);
		
		retourCo = new JButton("Retour");
		retourCo.setBounds(796, 418, 89, 23);
		layeredPane.add(retourCo);
		retourCo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==retourCo)
		{
			Accueil g = new Accueil();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		
		
		if(e.getSource()==ConectCo) {
			String numSecu = textField.getText();
			String password = passwordField.getText();
			
			Connection con = null;
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/USER", "root", "TPiAhUnKqtzCrMufPp0H");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Statement ps = null;
			try {
				ps = con.createStatement();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			String connec = "SELECT * FROM USER.USE where NumSecu='"+numSecu+"' and MDP='"+password+"'";
			
			ResultSet rs = null;
			try {
				rs = ps.executeQuery(connec);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				if (rs.next()) {
					menu g = new menu();
           			g.frame.setVisible(true);
           			frame.dispose();
                   
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
