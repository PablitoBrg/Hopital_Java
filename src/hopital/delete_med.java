package hopital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class delete_med implements ActionListener{

	public JFrame frame;
	private JButton retour, delete;
	private JTextField IDmed;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete_med window = new delete_med();
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
	public delete_med() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1082, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		delete = new JButton("Supprimer");
		delete.setBounds(113, 411, 89, 23);
		layeredPane.add(delete);
		delete.addActionListener(this);
		
		retour = new JButton("Retour");
		retour.setBounds(317, 411, 89, 23);
		layeredPane.add(retour);
		retour.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("Retirer un medecin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 300, 44);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Entrez l'ID d'un médecin :");
		lblNewLabel_1.setBounds(113, 100, 130, 23);
		layeredPane.add(lblNewLabel_1);
		
		IDmed = new JTextField();
		IDmed.setBounds(113, 136, 96, 20);
		layeredPane.add(IDmed);
		IDmed.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==retour) {
			medecins g = new medecins();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if(e.getSource()==delete) {
			int smed = Integer.parseInt(IDmed.getText());
			try {
				Connection connex = DriverManager.getConnection("jdbc:mysql://localhost:3306/USER", "root", "TPiAhUnKqtzCrMufPp0H");
				Statement stat = connex.createStatement();  
				String requeteMed = "DELETE FROM `USER`.`Medecin` WHERE (`idMedecin` = '"+smed+"');"; 
				try {
					stat.execute(requeteMed);
					JOptionPane.showMessageDialog(frame, "Médecin supprimé");
				}catch(SQLSyntaxErrorException g) {
					System.out.println("Erreur 1");
				}catch(SQLIntegrityConstraintViolationException f) {
					System.out.println("Erreur 2");
				}
			}catch (SQLException r) {
				r.printStackTrace();
			}
		}
	}
}
