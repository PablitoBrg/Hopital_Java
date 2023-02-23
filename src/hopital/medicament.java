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

public class medicament implements ActionListener {
	
	public JFrame frame;
	private JButton deco, accueil_bar, masque_bar, medoc_bar;
	private JToolBar barMenu;
	private JButton modif;
	private JButton ajout;
	private JButton delete;
	private JButton medecin_bar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					medicament window = new medicament();
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
	public medicament() {
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
		masque_bar.addActionListener(this);
		barMenu.add(masque_bar);
		
		medoc_bar = new JButton("Medicaments");
		barMenu.add(medoc_bar);
		
		medecin_bar = new JButton("Médecin");
		medecin_bar.addActionListener(this);
		barMenu.add(medecin_bar);
		
		deco = new JButton("Déconnexion");
		deco.addActionListener(this);
		deco.setBounds(850, 482, 130, 23);
		layeredPane.add(deco);
	
		JTextArea panel = new JTextArea();
		panel.setBounds(35, 60, 836, 329);
		layeredPane.add(panel);
		
		modif = new JButton("Modifier le stock");
		modif.setBounds(35, 482, 155, 23);
		modif.addActionListener(this);
		layeredPane.add(modif);
		
		ajout = new JButton("Ajouter un médicament");
		ajout.setBounds(200, 482, 175, 23);
		ajout.addActionListener(this);
		layeredPane.add(ajout);
		
		delete = new JButton("Retirer un médicament");
		delete.addActionListener(this);
		delete.setBounds(385, 482, 180, 23);
		layeredPane.add(delete);
		String v = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/USER","root", "TPiAhUnKqtzCrMufPp0H");
		
		Statement st = con.createStatement() ;
		String requete = "SELECT * FROM user.medicament;";
		ResultSet rs = st.executeQuery(requete);
		while (rs.next()) {
			String s = ""; 
			for(int i = 1; i <= 3; i++) {
				s += rs.getString(i) + "      |      ";
			}
			v += s+"\n";
			
		}
		panel.append(v);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==accueil_bar) {
			menu g = new menu();
			g.frame.setVisible(true);
			frame.dispose();
		}
		if(e.getSource()==masque_bar) {
			masque g = new masque();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if(e.getSource()==medecin_bar) {
			medecins g = new medecins();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if(e.getSource()==deco) {
			Accueil g = new Accueil();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if(e.getSource()==modif) {
			modif_medoc g = new modif_medoc();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if(e.getSource()==ajout) {
			ajout_medoc g = new ajout_medoc();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if(e.getSource()==delete) {
			delete_medoc g = new delete_medoc();
			g.frame.setVisible(true);
			frame.dispose();
		}
	}


}
