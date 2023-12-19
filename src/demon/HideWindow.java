package demon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

public class HideWindow extends JFrame {
	private JButton hideButton;
	private final int btn_width = 60, btn_height = 60;
	private boolean isOn = true;
	
	public HideWindow() {
		
		hideButton = new JButton();
		//현재 컨테이너 객체를 하이드 버튼으로 등록
		impV.hideButton = hideButton;
		
		/*	메인 프레임	*/
		impV.FrameSetting(this);
		
		hideButton.setText("숨기기");									//글자
		hideButton.setFont(new Font(impV.ttf, Font.PLAIN, 18));		//글꼴
		hideButton.setForeground(Color.green);						//글자 색
		hideButton.setBackground(impV.backColor); 					//메인 버튼 색
		hideButton.setBorder(new LineBorder(Color.red, 2, true));	//테두리
		hideButton.setSize(btn_width, btn_height);					//크기
		hideButton.setFocusPainted(false); 							// 선택 됐을 때 생기는 테두리 없애기
		
		/*	버튼 기능 구현	*/
		hideButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isOn) {
					if(impV.sideContainer != null)
						impV.sideContainer.setVisible(false);
					impV.activeContainer.setVisible(false);
					isOn = false;
					hideButton.setText("보이기");
				} else {
					if(impV.sideContainer != null)
						impV.sideContainer.setVisible(true);
					impV.activeContainer.setVisible(true);
					isOn = true;
					hideButton.setText("숨기기");
				}
				repaint();
			}
		});
		
		/*	버튼 마우스 인식	*/
		hideButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	//마우스가 누르는 순간
				repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});
		
		hideButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		
		add(hideButton);

		setSize(btn_width, btn_height);
		setLocation(impV.screenSize.width - impV.window_width - 10, impV.window_height + btn_height - 12);
		setVisible(true);
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(impV.backColor);
	}
}
