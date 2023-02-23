package hopital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import com.mysql.cj.xdevapi.Statement;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
/**
 * Classe modification du stock
 * @author Paul Froufrou
 *
 */
public class stockFFP implements ActionListener {

	public JFrame frame;
	private JButton retour, modif;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stockFFP window = new stockFFP();
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
	public stockFFP() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1082, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		retour = new JButton("Retour");
		retour.setBounds(548, 330, 89, 23);
		layeredPane.add(retour);
		retour.addActionListener(this);
		
		modif = new JButton("Modifier");
		modif.setBounds(121, 330, 89, 23);
		layeredPane.add(modif);
		modif.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("Modification du stock FFP2");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 207, 32);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Entrez le nouveau stock :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(121, 96, 175, 32);
		layeredPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(121, 194, 142, 20);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==modif) {
			int x = Integer.parseInt(textField.getText());
			Connection connection;
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/USER","root", "TPiAhUnKqtzCrMufPp0H");
			
	            java.sql.Statement statement= connection.createStatement();
	            String req =("UPDATE USER.ffp2  set FFP2Stock = '"+ x +"';");
	            statement.execute(req);
	            JOptionPane.showMessageDialog(frame, "Nombre modifié");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==retour) {
			masque g = new 	masque();
			g.frame.setVisible(true);
			frame.dispose();
		}
	}
}
