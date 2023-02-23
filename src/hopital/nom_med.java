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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;

public class nom_med implements ActionListener {

	public JFrame frame;
	private JButton retour, modif;
	private JTextField textField, textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nom_med window = new nom_med();
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
	public nom_med() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1082, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Modifier le nom d'un médecin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(25, 11, 203, 23);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID du médecin :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(73, 68, 138, 28);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nouveau nom :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(73, 173, 138, 28);
		layeredPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(73, 116, 86, 20);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(73, 234, 86, 20);
		layeredPane.add(textField_1);
		
		modif = new JButton("Modifier");
		modif.setBounds(73, 320, 89, 23);
		layeredPane.add(modif);
		modif.addActionListener(this);
		
		retour = new JButton("Retour");
		retour.setBounds(519, 320, 89, 23);
		layeredPane.add(retour);
		retour.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==retour) {
			modif_med g = new modif_med();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if(e.getSource()==modif) {
			int s = Integer.parseInt(textField.getText());
			String nvaleur = textField_1.getText();
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/USER", "root", "TPiAhUnKqtzCrMufPp0H");
				Statement st = con.createStatement();  
				String requete = "UPDATE `USER`.`Medecin` SET `MedNom` = '"+nvaleur+"' WHERE (`idMedecin` = '"+s+"');";
				try {
					st.execute(requete);
					
				}catch(SQLSyntaxErrorException t) {
					System.out.println("Erreur 1");
				}catch(SQLIntegrityConstraintViolationException f) {
					System.out.println("Erreur 2");
				}
				System.out.println("Stock mis a jour");
				JOptionPane.showMessageDialog(frame, "Information mise à jour");
			} catch (SQLException r) {
				r.printStackTrace();
			}
		}
	}

}
