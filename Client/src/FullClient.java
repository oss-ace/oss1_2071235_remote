import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FullClient extends JFrame {
	private JLabel text;
	private JTextField txtUserName;

	public FullClient() {
		setTitle("게임정원초과");
		setSize(300,300);
		setVisible(true);
		setLocationRelativeTo(null);
		
		Container c=getContentPane();
		c.setLayout(null);
		text = new JLabel("게임정원초과-입장불가");
		text.setBounds(83, 10, 160, 33);
		c.add(text);
		
		/* txtUserName = new JTextField();
		txtUserName.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserName.setBounds(70, 39, 140, 33);
		txtUserName.setColumns(10);
		c.add(txtUserName);
		
		JButton btnConnect = new JButton("로그인");
		btnConnect.setBounds(70, 180, 140, 33);
		c.add(btnConnect); */
	}

}
