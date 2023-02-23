package hopital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
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
/**
 * Classe gestion des masques
 * @author Paul Froufrou
 *
 */
public class masque implements ActionListener {

	JFrame frame;
	private JButton deco, modif, accueil_bar, masque_bar, medoc_bar, modifM, ajout, medecin_bar;
	private JToolBar barMenu;

	/**
	 * Lance l'application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					masque window = new masque();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Créer la fen^tre d'application et tout les élément inclus.
	 */
	public masque() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1082, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		barMenu = new JToolBar();
		barMenu.setBounds(0, 0, 906, 22);
		layeredPane.add(barMenu);
	
		accueil_bar = new JButton("Accueil");
		accueil_bar.addActionListener(this);
		barMenu.add(accueil_bar);
		
		masque_bar = new JButton("Masques");
		barMenu.add(masque_bar);
		
		medoc_bar = new JButton("Médicaments");
		medoc_bar.addActionListener(this);
		barMenu.add(medoc_bar);
		
		medecin_bar = new JButton("Médecin");
		medecin_bar.addActionListener(this);
		barMenu.add(medecin_bar);
		
		deco = new JButton("Déconnexion");
		deco.addActionListener(this);
		deco.setBounds(850, 482, 130, 23);
		layeredPane.add(deco);
		
		modif = new JButton("FFP2");
		modif.setBounds(35, 482, 78, 23);
		modif.addActionListener(this);
		layeredPane.add(modif);
		
		JTextArea panel = new JTextArea();
		panel.setBounds(35, 60, 945, 372);
		layeredPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Modification des stocks :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(35, 443, 216, 28);
		layeredPane.add(lblNewLabel);
		
		modifM = new JButton("Masques");
		modifM.setBounds(139, 482, 89, 23);
		modifM.addActionListener(this);
		layeredPane.add(modifM);
		
		ajout = new JButton("Ajouter masque");
		ajout.setBounds(393, 482, 130, 23);
		ajout.addActionListener(this);
		layeredPane.add(ajout);
		
		String v = "Masques : \n";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/USER","root", "TPiAhUnKqtzCrMufPp0H");
		
		java.sql.Statement st = con.createStatement() ;
		String requete = "SELECT * FROM user.masque;";
		ResultSet rs = st.executeQuery(requete);
		while (rs.next()) {
			String s = ""; 
			for(int i = 1; i <= 3; i++) {
				s += rs.getString(i) + "      |      ";
			}
			v += s+"\n";
			
		}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		v += "FFP2 : \n";
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/USER","root", "TPiAhUnKqtzCrMufPp0H");
		
		java.sql.Statement sta = conn.createStatement() ;
		String req = "SELECT * FROM user.ffp2;";
		ResultSet rsm = sta.executeQuery(req);
		while (rsm.next()) {
			String s = ""; 
			for(int i = 1; i <= 2; i++) {
				s += rsm.getString(i) + "      |      ";
			}
			v += s+"\n";
			
		}
		
		panel.append(v);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/**
	@Override
	* Donne une action aux boutons.
	*/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==accueil_bar) {
			menu g = new menu();
			g.frame.setVisible(true);
			frame.dispose();
		}
		if(e.getSource()==medoc_bar) {
			medicament g = new medicament();
			g.frame.setVisible(true);
			frame.dispose();
		}
		if(e.getSource()==deco) {
			Accueil g = new Accueil();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if(e.getSource()==modif) {
			stockFFP g = new stockFFP();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if(e.getSource()==ajout) {
			stockMasque g = new stockMasque();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if(e.getSource()==modifM) {
			ajoutMasque g = new ajoutMasque();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if(e.getSource()==medecin_bar) {
			medecins g = new medecins();
			g.frame.setVisible(true);
			frame.dispose();
		}
	}
}
