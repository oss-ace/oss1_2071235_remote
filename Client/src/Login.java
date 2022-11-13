import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame {
	private JLabel id;
	private JTextField txtUserName;
	
	
	public Login() {
		setTitle("로그인");
		setSize(300,300);
		setVisible(true);
		setLocationRelativeTo(null);
		
		Container c=getContentPane();
		c.setLayout(null);
		id = new JLabel("ID를 입력해주세요 !! ");
		id.setBounds(83, 10, 160, 33);
		c.add(id);
		
		txtUserName = new JTextField();
		txtUserName.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserName.setBounds(70, 39, 140, 33);
		txtUserName.setColumns(10);
		c.add(txtUserName);
		
		JButton btnConnect = new JButton("로그인");
		btnConnect.setBounds(70, 180, 140, 33);
		c.add(btnConnect);
		
		 btnConnect.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String username = txtUserName.getText().trim();
	        		MarbleFrame m =new MarbleFrame(username);
	    			setVisible(false);
	        	}
	       });
		
	}

	
	public static void main(String[] args) {
		Login login = new Login();
	}
}
