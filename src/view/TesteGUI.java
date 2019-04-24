package view;

import java.awt.EventQueue;

import javax.swing.JWindow;

public class TesteGUI {

	private JWindow window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteGUI tela = new TesteGUI();
					tela.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TesteGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JWindow();
		window.setBounds(100, 100, 450, 300);
	}

}
