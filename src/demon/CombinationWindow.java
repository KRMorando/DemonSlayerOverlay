package demon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CombinationWindow extends JFrame {
	impV impV = new impV();

	private JPanel mainPanel, buttonPanel;
	private JLabel titleLabel;
	private JButton btn[], backButton;
	
	private String buttonName[] = {"H", "EH", "X", "Z", "SZ"};

	public CombinationWindow() {
		impV.activeContainer = this;	//현재 활성화된 컨테이너 저장
		
		mainPanel = new MainPanel();
		buttonPanel = new JPanel();
		titleLabel = new JLabel();
		btn = new JButton[buttonName.length];
		backButton = new BackButton(this, "Main");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});
		
		/*	메인 프레임	*/
		impV.FrameSetting(this);
		
		/*	타이틀 라벨	*/
		titleLabel.setText("조합");
		titleLabel.setFont(impV.titleTTF);
		titleLabel.setBackground(new Color(0, 0, 0, 0));								//라벨 배경색
		titleLabel.setForeground(Color.GREEN);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBounds(0, 0, impV.window_width, 120);								//라벨 위치 및 크기 (x, y, width, height)
		
		/* 버튼 패널 */
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBackground(new Color(0, 0, 0, 0)); // 버튼 패널 색
		buttonPanel.setBounds(0, 100, impV.window_width, impV.window_height - 40);
		
		for(int i = 0; i < btn.length; i++) {
			btn[i] = new JButton();
			
			/* 전체 적용 */
			btn[i].setText(buttonName[i]);							//텍스트 설정
			btn[i].setFont(new Font(impV.ttf, Font.PLAIN, 35));		//폰트 적용
			btn[i].setBackground(new Color(0, 0, 0)); 			//배경색
			btn[i].setPreferredSize(new Dimension(100, 100)); 		//크기 설정
			btn[i].setBorder(new LineBorder(Color.red, 1, true));	//테두리
			btn[i].setFocusPainted(false); 							//선택 됐을 때 생기는 테두리 없애기
			
			/*	버튼 마우스 인식	*/
			btn[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
					repaint();
				}
			});
			
			/*	버튼 기능	*/
			switch(i) {
			case 0:
				btn[i].setForeground(impV.HColor);		//글씨 색상
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new CombinationSelectWindow(buttonName[0]);
						dispose();
					}
				});
				break;
				
			case 1:
				btn[i].setForeground(impV.EHColor);		//글씨 색상
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new CombinationSelectWindow(buttonName[1]);
						dispose();
					}
				});
				break;
				
			case 2:
				btn[i].setForeground(impV.XColor);		//글씨 색상
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new CombinationSelectWindow(buttonName[2]);
						dispose();
					}
				});
				break;
				
			case 3:
				btn[i].setForeground(impV.ZColor);		//글씨 색상
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new CombinationSelectWindow(buttonName[3]);
						dispose();
					}
				});
				break;
				
			case 4:
				btn[i].setForeground(impV.SZColor);		//글씨 색상
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new CombinationSelectWindow(buttonName[4]);
						dispose();
					}
				});
				break;
			}
			
			buttonPanel.add(btn[i]);
		}
		
		mainPanel.add(titleLabel);
		mainPanel.add(buttonPanel);
		mainPanel.add(backButton);
		add(mainPanel);
		
		// 가로 세로 길이 지정 및 보이기
		setSize(impV.window_width, impV.window_height);
		setLocation(impV.screenSize.width - impV.window_width - 10, 50);
		setVisible(true);
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(new Color(0, 0, 0, 0));
	}
}
