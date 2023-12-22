package demon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CombinationSelectWindow extends JFrame {
	private JPanel mainPanel, buttonPanel;
	private JLabel titleLabel, explainLabel;
	private JButton backButton;
	
	private int width = 100;
	private int height = 140;

	public CombinationSelectWindow(String id) {
		SystemManager.activeContainer = this;	//현재 활성화된 컨테이너 저장

		mainPanel = new MainPanel();
		titleLabel = new JLabel();
		explainLabel = new JLabel();
		buttonPanel = new JPanel();
		backButton = new BackButton(this, "Combination");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});

		/*	메인 프레임	*/
		SystemManager.FrameSetting(this);
		
		/* 타이틀 라벨	*/
		titleLabel.setFont(SystemManager.titleTTF);				// 폰트
		titleLabel.setBackground(new Color(0, 0, 0, 0));	// 배경색
		titleLabel.setHorizontalAlignment(JLabel.CENTER);	// 중앙 정렬
		titleLabel.setBounds(0, 0, SystemManager.window_width, 100); // x, y, width, height
		
		/*	설명 라벨	*/
		explainLabel.setText("원하는 캐릭터를 눌러주세요.");
		explainLabel.setFont(SystemManager.smallTTF);				// 폰트
		explainLabel.setForeground(Color.green);					// 색상
		explainLabel.setBackground(new Color(0, 0, 0, 0));		// 배경색
		explainLabel.setHorizontalAlignment(JLabel.CENTER);		// 중앙 정렬
		explainLabel.setBounds(0, 80, SystemManager.window_width, 30);	// x, y, width, height
		
		/* 버튼 패널 	*/
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(new Color(0, 0, 0, 0));
		buttonPanel.setBounds(0, 100, SystemManager.window_width, SystemManager.window_height - 140);
		
		/* 350, 600	*/

		/* makeCard(등급, 이름, 사진 경로) */
		/* H / EH / X / Z / SZ 순서 */
		
		switch (id) {
		case "H": 
			titleLabel.setText("H");
			titleLabel.setForeground(SystemManager.HColor);
			
			CustomLayout(makeCard("H", "사콘지", SystemManager.HLocation[0]), 0, 0);
			CustomLayout(makeCard("H", "지고로", SystemManager.HLocation[1]), 1, 0);
			CustomLayout(makeCard("H", "타마요", SystemManager.HLocation[2]), 2, 0);
			CustomLayout(makeCard("H", "카나에", SystemManager.HLocation[3]), 0, 1);
			CustomLayout(makeCard("H", "마코모", SystemManager.HLocation[4]), 1, 1);
			CustomLayout(makeCard("H", "사비토", SystemManager.HLocation[5]), 2, 1);
			break;
			
		case "EH":
			titleLabel.setText("EH");
			titleLabel.setForeground(SystemManager.EHColor);
			
			CustomLayout(makeCard("EH", "호타루", SystemManager.EHLocation[0]), 1, 0);
			break;
			
		case "X":
			titleLabel.setText("X");
			titleLabel.setForeground(SystemManager.XColor);
			
			CustomLayout(makeCard("X", "탄지로", SystemManager.XLocation[0]), 0, 0);
			CustomLayout(makeCard("X", "이노스케", SystemManager.XLocation[1]), 1, 0);
			CustomLayout(makeCard("X", "젠이츠", SystemManager.XLocation[2]), 2, 0);
			CustomLayout(makeCard("X", "기유", SystemManager.XLocation[3]), 0, 1);
			CustomLayout(makeCard("X", "텐겐", SystemManager.XLocation[4]), 1, 1);
			CustomLayout(makeCard("X", "미츠리", SystemManager.XLocation[5]), 2, 1);
			CustomLayout(makeCard("X", "무이치로", SystemManager.XLocation[6]), 0, 2);
			CustomLayout(makeCard("X", "겐야", SystemManager.XLocation[7]), 1, 2);
			break;
		  
		case "Z": 
			titleLabel.setText("Z");
			titleLabel.setForeground(SystemManager.ZColor);
			Component Zcard = makeCard("Z", "카나오", SystemManager.ZLocation[0]);
			Zcard.setLocation((SystemManager.window_width - width) / 2, 5);
			buttonPanel.add(Zcard);
			CustomLayout(makeCard("Z", "네즈코", SystemManager.ZLocation[1]), 0, 1);
			CustomLayout(makeCard("Z", "쿄쥬로", SystemManager.ZLocation[2]), 1, 1);
			break;
			
		case "SZ": 
			titleLabel.setText("SZ");
			titleLabel.setForeground(SystemManager.SZColor);
			
			Component SZcard = makeCard("SZ", "카마도 탄지로", SystemManager.SZLocation[0]);
			SZcard.setLocation((SystemManager.window_width - width) / 2, (SystemManager.window_height - height) / 4);
			buttonPanel.add(SZcard);
			break;
		}

		mainPanel.add(titleLabel);
		mainPanel.add(explainLabel);
		mainPanel.add(buttonPanel);
		mainPanel.add(backButton);
		add(mainPanel);

		// 가로 세로 길이 지정 및 보이기
		setSize(SystemManager.window_width, SystemManager.window_height);
		setLocation(SystemManager.screenSize.width - SystemManager.window_width - 10, 50);
		setVisible(true);
	}

	protected Component makeCard(String rank, String name, String location) {
		boolean isLegend = false;
		
		if(name.equals("카마도 탄지로") || name.equals("카나오") || name.equals("쿄쥬로") || name.equals("네즈코")) {
			width = 150;
			height = 190;
			isLegend = true;
		}
		
		URL url = this.getClass().getClassLoader().getResource(location);
		ImageIcon icon = new ImageIcon(url), updateIcon;
		Image img = icon.getImage(), updateImg;
		if(isLegend)
			updateImg = img.getScaledInstance(width, height - 25, Image.SCALE_SMOOTH);
		else
			updateImg = img.getScaledInstance(width, height - 20, Image.SCALE_SMOOTH);
		updateIcon = new ImageIcon(updateImg);
		
		JPanel cardPanel = new JPanel();
		JLabel imgLabel = new JLabel(updateIcon);
		JLabel imgText = new JLabel();
		JButton mainButton = new JButton();
		
		cardPanel.setLayout(null);
		cardPanel.setBackground(new Color(0, 0, 0, 0));		//배경 투명
		cardPanel.setSize(width, height);					//width, height

		imgLabel.setText("");
		imgLabel.setBackground(new Color(0, 0, 0, 0));		// 배경 투명
		imgLabel.setBounds(0, 0, width, height - 25); 		// x, y, width, height

		imgText.setText(name); 								// 버튼 이름
		imgText.setBackground(new Color(0, 0, 0, 0));		// 배경색
		imgText.setFont(SystemManager.normalTTF); 			// 폰트
		imgText.setHorizontalAlignment(JLabel.CENTER);
		imgText.setVerticalAlignment(JLabel.CENTER);
		imgText.setBounds(0, height - 25, width, 25);		// x, y, width, height
		if(rank.equals("H"))
			imgText.setForeground(SystemManager.HColor);	// 글씨 색상
		else if(rank.equals("EH"))
			imgText.setForeground(SystemManager.EHColor); 	// 글씨 색상
		else if(rank.equals("X"))
			imgText.setForeground(SystemManager.XColor);	// 글씨 색상
		else if(rank.equals("Z"))
			imgText.setForeground(SystemManager.ZColor);	// 글씨 색상
		else
			imgText.setForeground(SystemManager.SZColor); 	// 글씨 색상
		
		mainButton.setText("");
		mainButton.setBackground(new Color(0, 0, 0, 0));	//배경 색
		mainButton.setBorderPainted(false); 				//테두리 없음
		mainButton.setFocusPainted(false); 					//선택 됐을 때 생기는 테두리 없애기
		mainButton.setBounds(0, 0, width, height);
		mainButton.addActionListener(new ActionListener() { //버튼 기능
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread sideWindow = new Thread(new CombinationSideWindow(name));
				repaint();
				sideWindow.start();
			}
		});
		
		/*	버튼 마우스 인식	*/
		mainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});
		
		cardPanel.add(imgLabel);
		cardPanel.add(imgText);
		cardPanel.add(mainButton);
		
		return cardPanel;
	}
	
	protected void CustomLayout(Component c, int sequence, int floor) {
		c.setLocation((12 * (1 + sequence)) + (width * sequence), (5 * (1 + floor)) + (height * floor));
		//				여백 계산					박스 계산		x / y
		buttonPanel.add(c);
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(new Color(0, 0, 0, 0));
	}
}
