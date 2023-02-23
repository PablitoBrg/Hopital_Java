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


public class stockMasque implements ActionListener {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton retour, ajout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stockMasque window = new stockMasque();
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
	public stockMasque() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1082, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Nouveaux masques");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 155, 22);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Couleur des nouveaux masques :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(63, 71, 193, 22);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantités des nouveaux masques :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(63, 179, 226, 22);
		layeredPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(63, 119, 176, 20);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(63, 231, 176, 20);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		ajout = new JButton("Ajouter");
		ajout.setBounds(63, 292, 89, 23);
		layeredPane.add(ajout);
		ajout.addActionListener(this);
		
		retour = new JButton("Retour");
		retour.setBounds(568, 292, 89, 23);
		layeredPane.add(retour);
		retour.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==retour) {
			masque g = new masque();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if(e.getSource()==ajout) {
			String coul = textField.getText();
			int quant = Integer.parseInt(textField_1.getText());
			try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/USER", "root", "TPiAhUnKqtzCrMufPp0H");
			Statement stt = connect.createStatement();  
			String nouvmasque = "INSERT INTO USER.MASQUE (`MNombre`, `MCouleur`) VALUES ('"+quant+"', '"+coul+"');"; 
			try {
				stt.execute(nouvmasque);
				System.out.println("Stock mis a jour");
				JOptionPane.showMessageDialog(frame, "Masque ajouté");
			}catch(SQLSyntaxErrorException g) {
				System.out.println("Erreur 1");
			}catch(SQLIntegrityConstraintViolationException f) {
				System.out.println("Erreur 2");
			}
			} catch (SQLException r) {
				r.printStackTrace();
			}
		}
	}
}
