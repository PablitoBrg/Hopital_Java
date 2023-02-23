package hopital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;

public class modif_med implements ActionListener {

	public JFrame frame;
	private JButton retour, nom, prenom, sexe, spe, cont, sal;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modif_med window = new modif_med();
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
	public modif_med() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1082, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		retour = new JButton("Retour");
		retour.setBounds(116, 419, 89, 23);
		layeredPane.add(retour);
		
		nom = new JButton("Nom");
		nom.setBounds(116, 112, 111, 35);
		layeredPane.add(nom);
		nom.addActionListener(this);
		
		prenom = new JButton("Prénom");
		prenom.setBounds(116, 200, 111, 35);
		layeredPane.add(prenom);
		prenom.addActionListener(this);
		
		sexe = new JButton("Sexe");
		sexe.setBounds(116, 296, 111, 35);
		layeredPane.add(sexe);
		sexe.addActionListener(this);
		
		spe = new JButton("Spécialité");
		spe.setBounds(333, 112, 111, 35);
		layeredPane.add(spe);
		spe.addActionListener(this);
		
		cont = new JButton("Contact");
		cont.setBounds(333, 200, 111, 35);
		layeredPane.add(cont);
		cont.addActionListener(this);
		
		sal = new JButton("Salaire");
		sal.setBounds(333, 296, 111, 35);
		layeredPane.add(sal);
		sal.addActionListener(this);
		
		lblNewLabel = new JLabel("Quelle information souhaitez-vous modifié ?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(21, 11, 356, 46);
		layeredPane.add(lblNewLabel);
		retour.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==retour) {
			medecins g = new medecins();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if(e.getSource()==nom) {
			nom_med g = new nom_med();
			g.frame.setVisible(true);
			frame.dispose();
		}
		if(e.getSource()==prenom) {
			pre_med g = new pre_med();
			g.frame.setVisible(true);
			frame.dispose();
		}
		if(e.getSource()==sexe) {
			sexe_med g = new sexe_med();
			g.frame.setVisible(true);
			frame.dispose();
		}
		if(e.getSource()==spe) {
			spe_med g = new spe_med();
			g.frame.setVisible(true);
			frame.dispose();
		}
		if(e.getSource()==cont) {
			cont_med g = new cont_med();
			g.frame.setVisible(true);
			frame.dispose();
		}
		if(e.getSource()==sal) {
			sal_med g = new sal_med();
			g.frame.setVisible(true);
			frame.dispose();
		}
	}

}
