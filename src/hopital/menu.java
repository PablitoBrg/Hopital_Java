package hopital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Classe menu de l'hopital
 * @author Paul Froufrou
 *
 */
public class menu implements ActionListener {

	JFrame frame;
	private JToolBar barMenu;
	private JButton accueil_bar, masque_bar, medoc_bar, masque, medoc, deco, medecin_bar;
	private JButton Accmedecin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu window = new menu();
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
	public menu() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1082, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel labelAccueil = new JLabel("Accueil");
		labelAccueil.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelAccueil.setHorizontalAlignment(SwingConstants.CENTER);
		labelAccueil.setBounds(44, 42, 94, 22);
		layeredPane.add(labelAccueil);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		layeredPane.add(scrollPane);
		
		barMenu = new JToolBar();
		barMenu.setBounds(0, 0, 906, 22);
		layeredPane.add(barMenu);
	
		accueil_bar = new JButton("Accueil");
		barMenu.add(accueil_bar);
		
		masque_bar = new JButton("Masques");
		masque_bar.addActionListener(this);
		barMenu.add(masque_bar);
		
		medoc_bar = new JButton("Médicaments");
		medoc_bar.addActionListener(this);
		barMenu.add(medoc_bar);
		
		medecin_bar = new JButton("Médecin");
		medecin_bar.addActionListener(this);
		barMenu.add(medecin_bar);
		
		masque = new JButton("Masques");
		masque.addActionListener(this);
		masque.setFont(new Font("Tahoma", Font.PLAIN, 22));
		masque.setBounds(106, 131, 408, 58);
		layeredPane.add(masque);
		
		medoc = new JButton("Medicaments");
		medoc.addActionListener(this);
		medoc.setFont(new Font("Tahoma", Font.PLAIN, 22));
		medoc.setBounds(338, 242, 408, 58);
		layeredPane.add(medoc);
		
		deco = new JButton("Déconnexion");
		deco.addActionListener(this);
		deco.setBounds(832, 582, 130, 23);
		layeredPane.add(deco);
		
		Accmedecin = new JButton("Médecin");
		Accmedecin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Accmedecin.setBounds(568, 131, 408, 58);
		layeredPane.add(Accmedecin);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == deco) {
			Accueil g = new Accueil();
			g.frame.setVisible(true);
			frame.dispose();
		}
		if (e.getSource() == masque_bar) {
			masque g = new masque();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if (e.getSource() == medoc_bar) {
			medicament g = new medicament();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if(e.getSource()==medecin_bar) {
			medecins g = new medecins();
			g.frame.setVisible(true);
			frame.dispose();
		}
		
		if (e.getSource() == masque) {
			masque g = new masque();
			g.frame.setVisible(true);
			frame.dispose();
		}
		if (e.getSource() == medoc) {
			medicament g = new medicament();
			g.frame.setVisible(true);
			frame.dispose();
		}
	}
}
