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

public class ajout_med implements ActionListener {

	public JFrame frame;
	private JButton retour, ajout;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajout_med window = new ajout_med();
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
	public ajout_med() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1082, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblAjout = new JLabel("Ajouter un nouveau Medecin");
		lblAjout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAjout.setBounds(10, 11, 296, 64);
		layeredPane.add(lblAjout);
		
		JLabel lblNewLabel = new JLabel("Nom médecin :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(131, 86, 148, 14);
		layeredPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(131, 113, 148, 20);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 194, 148, 20);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		ajout = new JButton("Ajouter");
		ajout.setBounds(131, 502, 89, 23);
		ajout.addActionListener(this);
		layeredPane.add(ajout);
		
		retour = new JButton("Retour");
		retour.setBounds(562, 502, 89, 23);
		retour.addActionListener(this);
		layeredPane.add(retour);
		
		JLabel lblNewLabel_2 = new JLabel("Prénom médecin :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(131, 156, 148, 14);
		layeredPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 267, 148, 20);
		layeredPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSexeDuMdecin = new JLabel("Sexe du médecin :");
		lblSexeDuMdecin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSexeDuMdecin.setBounds(131, 235, 148, 14);
		layeredPane.add(lblSexeDuMdecin);
		
		JLabel lblSpcialitDuMdecin = new JLabel("Spécialité du médecin :");
		lblSpcialitDuMdecin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSpcialitDuMdecin.setBounds(131, 298, 148, 14);
		layeredPane.add(lblSpcialitDuMdecin);
		
		JLabel lblContactDuMdecin = new JLabel("Contact du médecin :");
		lblContactDuMdecin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContactDuMdecin.setBounds(131, 358, 148, 14);
		layeredPane.add(lblContactDuMdecin);
		
		JLabel lblSalaireDuMdecin = new JLabel("Salaire du médecin :");
		lblSalaireDuMdecin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSalaireDuMdecin.setBounds(131, 424, 148, 14);
		layeredPane.add(lblSalaireDuMdecin);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(131, 327, 148, 20);
		layeredPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(131, 393, 148, 20);
		layeredPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(131, 449, 148, 20);
		layeredPane.add(textField_5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==retour) {
			medecins g = new medecins();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if(e.getSource()==ajout) {
			String nom = textField.getText();
			String pre = textField_1.getText();
			String sex = textField_2.getText();
			String sp = textField_3.getText();
			String cont = textField_4.getText();
			int sal = Integer.parseInt(textField_5.getText());
			try {
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/USER", "root", "TPiAhUnKqtzCrMufPp0H");
				Statement stt = connect.createStatement();  
				String nouvmasque = 
					"INSERT INTO USER.Medecin (MedNom, MedPrenom, MedSexe, MedSpe, MedContact, MedSalary) VALUES ('"+nom+"', '"+pre+"', '"+sex+"', '"+sp+"', '"+cont+"', '"+sal+"');"; 
				try {
					stt.execute(nouvmasque);
					JOptionPane.showMessageDialog(frame, "Médecin ajouté");
					System.out.println("Medecin ajouté");
				}catch(SQLSyntaxErrorException t) {
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
