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
import com.mysql.cj.xdevapi.Statement;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.Action;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.time.ZonedDateTime;
import java.awt.event.ActionEvent;
/**
 * Classe inscription
 * @author Paul Froufrou
 *
 */
public class inscr implements ActionListener{

	public JFrame frame;
	private JTextField textNumSecu;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textMail;
	private JTextField textMdp;
	private JButton retourIns, Inscr;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inscr window = new inscr();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 */
	public inscr() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1082, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblInscr = new JLabel("Veuillez vous inscrire !");
		lblInscr.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInscr.setBounds(110, 59, 265, 60);
		layeredPane.add(lblInscr);
		
		JLabel lblNumSecu = new JLabel("Numéro de sécurité social :");
		lblNumSecu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumSecu.setBounds(129, 140, 200, 25);
		layeredPane.add(lblNumSecu);
		
		textNumSecu = new JTextField();
		textNumSecu.setBounds(129, 171, 200, 20);
		layeredPane.add(textNumSecu);
		textNumSecu.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNom.setBounds(129, 210, 200, 25);
		layeredPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prénom :");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrenom.setBounds(129, 304, 200, 25);
		layeredPane.add(lblPrenom);
		
		JLabel lblMail = new JLabel("Adresse e-mail :");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMail.setBounds(129, 394, 200, 25);
		layeredPane.add(lblMail);
		
		textNom = new JTextField();
		textNom.setColumns(10);
		textNom.setBounds(129, 246, 200, 20);
		layeredPane.add(textNom);
		
		textPrenom = new JTextField();
		textPrenom.setColumns(10);
		textPrenom.setBounds(129, 340, 200, 20);
		layeredPane.add(textPrenom);
		
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(129, 430, 200, 20);
		layeredPane.add(textMail);
		
		JLabel lblMdp = new JLabel("Mot de passe :");
		lblMdp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMdp.setBounds(129, 482, 200, 25);
		layeredPane.add(lblMdp);
		
		textMdp = new JTextField();
		textMdp.setColumns(10);
		textMdp.setBounds(129, 518, 200, 20);
		layeredPane.add(textMdp);
		
		Inscr = new JButton("S'inscrire");
		Inscr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Inscr.setBounds(110, 582, 116, 23);
		layeredPane.add(Inscr);
		Inscr.addActionListener(this);
		
		retourIns = new JButton("Retour");
		retourIns.setFont(new Font("Tahoma", Font.PLAIN, 12));
		retourIns.setBounds(754, 583, 89, 23);
		layeredPane.add(retourIns);
		retourIns.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==retourIns) {
			
			Accueil g = new Accueil();
			g.frame.setVisible(true);
			frame.dispose();
		}
		if(e.getSource()== Inscr) {
			
			String NumSecu = textNumSecu.getText();
			String Nom = textNom.getText();
			String Prenom = textPrenom.getText();
			String Mail = textMail.getText();
			String Password = textMdp.getText();
			Connection con = null;
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/USER", "root", "TPiAhUnKqtzCrMufPp0H");
				java.sql.Statement statement = con.createStatement();
				String inscr = "INSERT INTO USER.USE (NumSecu,MDP,NOM,PRENOM,Mail) values ('"+ NumSecu +"','"+ Password +"','"+ Nom +"','"+ Prenom +"','"+ Mail +"');";
				statement.execute(inscr);
                
    			Accueil g = new Accueil();
    			g.frame.setVisible(true);
    			frame.dispose();
			
		
			} catch (SQLException e1) {
                e1.printStackTrace();
            }
		}
	}
}
