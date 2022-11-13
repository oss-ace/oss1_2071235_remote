import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListPanel extends JPanel{
	
	private JTextArea textArea = new JTextArea();
	private JButton end=new JButton("턴 종료");
	private JButton start=new JButton("시작");
	
	//타이머 쓰레드로 구현
	private int timeCnt=120; //2분
	private JLabel timeLabel =new JLabel("타이머  : ");
	private JLabel timeCount =new JLabel(Integer.toString(timeCnt));
	private TimerThread th;
	
	Font font=new Font("SansSerif",Font.BOLD,15);
	
	//state가 1이 넘어오면 시작버튼 활성화 (즉 첫번째 들어온 클라이언트만 시작 버튼 누를 수 있음)
	private int state=0;
	
	public ListPanel() {
		this.setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		add(scrollPane,BorderLayout.CENTER);
		
		
		JPanel north=new JPanel(new FlowLayout(FlowLayout.LEFT));
		north.add(timeLabel);
		north.add(timeCount);
		add(north,BorderLayout.NORTH);
		
		
		JPanel south=new JPanel(new GridLayout(1,2));
		end.setFont(font);
		start.setFont(font);
		south.add(end);
		south.add(start);
	    add(south,BorderLayout.SOUTH);
	    
	   
		
	    start.addActionListener(new ActionListener() {  //시작 버튼 누르면 타이머 시작
			public void actionPerformed(ActionEvent e) {
				if(state==1) //첫번째 클라이언트만 시작 버튼 누르고 타이머 시작
				startThread();
			}
		});
	    
	}
	
	public void setButton() {
		if(state!=1) { //첫번째 클라이언트 외에 다른 클라이언트들은 시작 버튼 비활성화
	    	start.setEnabled(false);
	    }
	}
	
	public void setState(int n) {
		this.state=n;
	}
	
	
	public void startThread() { // start버튼 누르면 타이머 스레드도 같이 시작
		th=new TimerThread(timeCount);
		th.start(); 
	}
	public void stopThread() { //타이머 스레드 종료
		th.interrupt();
	}
	public void setCount() { //타이머 시간 셋팅
		timeCnt=60;
		timeCount.setText(Integer.toString(timeCnt));
	}
	public int getCount() { //타이머 시간 리턴
		return timeCnt;
	}
	
	class TimerThread extends Thread{
		private JLabel timeCount;
		public TimerThread(JLabel timeCount) {
			this.timeCount=timeCount;
		}
		
		public void run() {
			while(true) { //타이머 1초씩 감소
				timeCount.setText(Integer.toString(timeCnt));
				timeCnt--;
				if(timeCnt==-1) {	//1초 오차때문에(화면에 보여지는)
					break;
					}
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					return;
				}
			}
		}
	}

}
