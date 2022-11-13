import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class BuruMarble extends JFrame {

	private JPanel contentPane;
	//private String user;
	private JTextArea chatting, clientList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuruMarble frame = new BuruMarble();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuruMarble() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1300, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		chatting = new JTextArea();
		clientList = new JTextArea();
		
		chatting.setBounds(4, 4, 1000, 800);
		clientList.setBounds(1100, 4, 200, 800);
		contentPane.add(chatting);
		contentPane.add(clientList);
		
		setVisible(true);
	}

}
