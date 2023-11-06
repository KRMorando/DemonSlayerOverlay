package demon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

public class MissionWindow extends JFrame {
	ImportentValue impV = new ImportentValue();
	
	private JPanel mainPanel, buttonPanel;
	private JLabel titleLabel;
	private JButton btn[], backButton;
	
	private String buttonName[] = {"노말", "하드"};
	
	public MissionWindow() {
		impV.activeContainer = this;	//현재 활성화된 컨테이너 저장
		
		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		titleLabel = new JLabel();
		backButton = new JButton();
		btn = new JButton[2];
		
		setUndecorated(true); 	// 테두리 삭제
		setResizable(false); 	// 크기 조절 여부
		
		setBackground(new Color(0, 0, 0, 0)); 											// 컨테이너 공백
		
		/*	메인 패널	*/
		mainPanel.setLayout(null);
		mainPanel.setBackground(impV.backColor); 										// 메인 패널 색
		mainPanel.setBorder(new LineBorder(Color.red, 2, true));
		mainPanel.setBounds(0, 0, impV.window_width, impV.window_height);				//350, 600 (width, heigth)
		
		/*	타이틀 라벨	*/
		titleLabel.setText("난이도");
		titleLabel.setFont(impV.titleKostar);
		titleLabel.setBackground(new Color(0, 0, 0, 0));								//라벨 배경색
		titleLabel.setForeground(Color.GREEN);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBounds(0, 0, impV.window_width, 120);								//라벨 위치 및 크기 (x, y, width, height)
		
		/* 버튼 패널 */
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
		buttonPanel.setBackground(new Color(0, 0, 0, 0)); // 버튼 패널 색
		buttonPanel.setBounds(0, 100, impV.window_width, impV.window_height - 40);
		
		/*	버튼	*/
		for(int i = 0; i < btn.length; i++) {
			btn[i] = new JButton();
			
			/* 전체 적용 */
			btn[i].setText(buttonName[i]);							//텍스트 설정
			btn[i].setFont(impV.normalKostar);		//폰트 적용
			btn[i].setBackground(new Color(0, 0, 0)); 			//배경색
			btn[i].setPreferredSize(new Dimension(200, 40)); 		//크기 설정
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
				btn[i].setForeground(Color.white);		//글씨 색상
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new MissionSelectWindow(buttonName[0]);
						dispose();
					}
				});
				break;
				
			case 1:
				btn[i].setForeground(Color.red);		//글씨 색상
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new MissionSelectWindow(buttonName[1]);
						dispose();
					}
				});
				break;
			}
			
			buttonPanel.add(btn[i]);
		}
		
		/* 뒤로가기 버튼 */
		backButton.setText("뒤로가기"); // 글씨 적용
		backButton.setFont(new Font("Kostar", Font.PLAIN, 18)); // 폰트 적용
		backButton.setBackground(new Color(0, 0, 0, 0)); // 배경색
		backButton.setForeground(Color.GREEN); // 글씨색
		backButton.setBorder(BorderFactory.createLineBorder(Color.RED, 1, true)); // 테두리
		backButton.setFocusPainted(false); // 선택 됐을 때 생기는 테두리 없애기
		backButton.setBounds(80, impV.window_height - 55, 190, 30);

		/* 뒤로가기 버튼 기능 구현 */
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainWindow();
				dispose();
			}
		});
		
		/*	버튼 마우스 인식	*/
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});
		
		mainPanel.add(titleLabel);
		mainPanel.add(buttonPanel);
		mainPanel.add(backButton);
		add(mainPanel);
		
		setAlwaysOnTop(true); // 항상 위에 보이기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우 종료시 javax도 종료

		// 가로 세로 길이 지정 및 보이기
		setSize(impV.window_width, impV.window_height);
		setLocation(impV.screenSize.width - impV.window_width - 10, 50);
		setVisible(true);
	}
}
