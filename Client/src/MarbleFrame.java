import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class MarbleFrame extends JFrame {
	private String UserName;
	//private JPanel ;
	private GamePanel gamePanel =new GamePanel();
	private CharacterPanel characterPanel=new CharacterPanel(UserName);
	private ListPanel listPanel=new ListPanel();
	
	public MarbleFrame(String s) {
		UserName=s;
		characterPanel.setName(s);
		setTitle("�η縶��");
		Container c=getContentPane();
		//c.setLayout(null);
		
		JSplitPane hPane = new JSplitPane();
		//c.add(hPane,BorderLayout.CENTER);
		hPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT); 
		hPane.setDividerLocation(1050);   
		hPane.setEnabled(false); //���ø��� �������̰� ����
		hPane.setLeftComponent(gamePanel); 
		
		JSplitPane pPane = new JSplitPane();
		pPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		pPane.setDividerLocation(350); 
		pPane.setTopComponent(characterPanel);
		pPane.setBottomComponent(listPanel); 
		hPane.setRightComponent(pPane);  //pPane�� hPane�� �����ʿ� ���δ�.
		
		c.add(hPane,BorderLayout.CENTER);
		setSize(1300,800);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new MarbleFrame("af");

	}

}
