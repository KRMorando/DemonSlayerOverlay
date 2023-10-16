package demon_slayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MissionOniWindow extends JFrame {
	ImportentValue impV = new ImportentValue();
	
	private JPanel mainPanel, difficultyPanel, namePanel, rankPanel, shieldPanel, roundPanel, minCutPanel;
	private JLabel oniLabel, leftLabel, rightLabel, difficultyLabel;
	private JButton backButton;
	
	private Border bf;
	private final Color lineColor = Color.red;
	
	public MissionOniWindow(String difficulty, String name, String location, Color color) {
		impV.activeContainer = getRootPane().getContentPane();	//현재 활성화된 컨테이너 저장
		
		mainPanel = new JPanel();
		difficultyPanel = new JPanel();
		namePanel = new JPanel();
		rankPanel = new JPanel();
		shieldPanel = new JPanel();
		roundPanel = new JPanel();
		minCutPanel = new JPanel();
		leftLabel = new JLabel();
		rightLabel = new JLabel();
		difficultyLabel = new JLabel();
		backButton = new JButton();
		
		setUndecorated(true);	// 테두리 삭제
		setResizable(false);	// 크기 조절 여부
		
		setBackground(new Color(0, 0, 0, 0));

		/*	350, 600	*/
		/* 메인 패널 	*/
		mainPanel.setLayout(null); 											//레이아웃
		mainPanel.setBackground(impV.backColor);							//배경색
		mainPanel.setBorder(new LineBorder(Color.red, 2, true));			//테두리
		mainPanel.setBounds(0, 0, impV.window_width, impV.window_height);	//x, y, 가로, 세로
		
		/*	난이도 패널	*/
		difficultyPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); //레이아웃
		difficultyPanel.setBackground(new Color(0, 0, 0, 0));		//배경색
		difficultyPanel.setBounds(5, 5, 120, 40);					//x, y, 가로, 세로
		
		leftLabel.setText("[");
		leftLabel.setFont(impV.smallKostar);
		leftLabel.setForeground(Color.cyan);
		leftLabel.setSize(30, 40);
		
		if(difficulty == "하드") {
			difficultyLabel.setText("Hard");
			difficultyLabel.setForeground(Color.red);
		} else {
			difficultyLabel.setText("Normal");
			difficultyLabel.setForeground(Color.white);
		}
		difficultyLabel.setFont(impV.smallKostar);
		difficultyLabel.setSize(60, 40);
		
		rightLabel.setText("]");
		rightLabel.setFont(impV.smallKostar);
		rightLabel.setForeground(Color.cyan);
		rightLabel.setSize(30, 40);
		
		difficultyPanel.add(leftLabel);
		difficultyPanel.add(difficultyLabel);
		difficultyPanel.add(rightLabel);
		
		/*	오니 사진	*/
		oniLabel = makeImg(name, location);
		if(name == "스사마루 [A]")
			oniLabel.setLocation((int)((350 - oniLabel.getWidth()) / 2), 40);
		else
			oniLabel.setLocation((int)((350 - oniLabel.getWidth()) / 2), 20);
		
		/*	이름 패널	*/
		bf = BorderFactory.createTitledBorder(new LineBorder(lineColor, 1), "보스명", TitledBorder.LEFT, TitledBorder.TOP, impV.normalKostar, Color.white);
		namePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		namePanel.setBackground(new Color(0, 0, 0, 0));
		namePanel.setBorder(bf);
		namePanel.setBounds(10, 180, impV.window_width - 90, 70);
		
		/*	랭크 패널	*/
		bf = BorderFactory.createTitledBorder(new LineBorder(lineColor, 1), "랭크", TitledBorder.CENTER, TitledBorder.TOP, impV.normalKostar, Color.red);
		rankPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		rankPanel.setBackground(new Color(0, 0, 0, 0));
		rankPanel.setBorder(bf);
		rankPanel.setBounds(impV.window_width - 80, 180, 70, 70);
		
		/*	쉴드 패널	*/
		bf = BorderFactory.createTitledBorder(new LineBorder(lineColor, 1), "방어력 / 쉴드 / 체력", TitledBorder.LEFT, TitledBorder.TOP, impV.normalKostar, Color.white);
		shieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		shieldPanel.setBackground(new Color(0, 0, 0, 0));
		shieldPanel.setBorder(bf);
		shieldPanel.setBounds(10, 260, impV.window_width - 20, 70);
		
		/*	최소 컷 패널	*/
		bf = BorderFactory.createTitledBorder(new LineBorder(lineColor, 1), "최소 컷", TitledBorder.LEFT, TitledBorder.TOP, impV.normalKostar, Color.white);
		minCutPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		minCutPanel.setBackground(new Color(0, 0, 0, 0));
		minCutPanel.setBorder(bf);
		minCutPanel.setBounds(10, 340, impV.window_width - 20, 190);
		
		//세부 내용
		/*	namePanel	/	rankPanel	/	shieldPanel	/	minCutPanel	*/
		/*	이름			/	랭크			/	방,쉴, 체		/	최소 컷		*/
		switch(name) {
		case "불당 오니 [Q]":
			namePanel.add(impV.customText("불당 오니", Color.white, 20));
			rankPanel.add(impV.customText("D", Color.red, 25));
			shieldPanel.add(impV.customText("5", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("35", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("30,000", Color.green, 20));
			if(difficulty == "노말") {
				
			} else {
				
			}
			break;
		case "손 오니 [W]":
			namePanel.add(impV.customText("손 오니", Color.white, 20));
			rankPanel.add(impV.customText("C", Color.red, 25));
			shieldPanel.add(impV.customText("30", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("300", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("87,000", Color.green, 20));
			if(difficulty == "노말") {
				
			} else {
				
			}
			break;
		case "늪 오니 [E]":
			namePanel.add(impV.customText("늪 오니", Color.white, 20));
			rankPanel.add(impV.customText("B", Color.red, 25));
			shieldPanel.add(impV.customText("50", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("600", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("220,000", Color.green, 20));
			if(difficulty == "노말") {
				
			} else {
				
			}
			break;
		case "스사마루 [A]":
			namePanel.add(impV.customText("스사마루", Color.white, 20));
			rankPanel.add(impV.customText("A", Color.red, 25));
			shieldPanel.add(impV.customText("100", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("2,500", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("900,000", Color.green, 20));
			if(difficulty == "노말") {
				
			} else {
				
			}
			break;
		case "쿄우가이 [S]":
			namePanel.add(impV.customText("쿄우가이", Color.white, 20));
			rankPanel.add(impV.customText("S", Color.red, 25));
			shieldPanel.add(impV.customText("150", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("6,000", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("2,100,000", Color.green, 20));
			if(difficulty == "노말") {
				
			} else {
				
			}
			break;
		case "루이 [D]":
			namePanel.add(impV.customText("루이", Color.white, 20));
			rankPanel.add(impV.customText("X", Color.red, 25));
			shieldPanel.add(impV.customText("255", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("55,000", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("8,000,000", Color.green, 20));
			if(difficulty == "노말") {
				
			} else {
				
			}
			break;
		}
		
		/* 뒤로가기 버튼 */
		backButton.setText("뒤로가기");							// 글씨 적용
		backButton.setFont(new Font("Kostar", Font.PLAIN, 18));	// 폰트 적용
		backButton.setBackground(new Color(0, 0, 0, 0));		// 배경색
		backButton.setForeground(Color.GREEN);					// 글씨색
		backButton.setFocusPainted(false);						// 선택 됐을 때 생기는 테두리 없애기
		backButton.setPreferredSize(new Dimension(200, 30));	//크기 설정
		backButton.setBorder(BorderFactory.createLineBorder(Color.RED, 1, true));	// 테두리
		backButton.setBounds(80, impV.window_height - 55, 200, 30);

		/* 뒤로가기 버튼 기능 구현 */
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MissionSelectWindow(difficulty);
				setVisible(false);
			}
		});
		
		/*	버튼 마우스 인식	*/
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});
		
		mainPanel.add(difficultyPanel);
		mainPanel.add(oniLabel);
		mainPanel.add(namePanel);
		mainPanel.add(rankPanel);
		mainPanel.add(shieldPanel);
		mainPanel.add(minCutPanel);
		mainPanel.add(backButton);
		add(mainPanel);
		
		setAlwaysOnTop(true); // 항상 위에 보이기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우 종료시 javax도 종료

		//350, 600
		// 가로 세로 길이 지정 및 보이기
		setSize(impV.window_width, impV.window_height);
		setLocation(impV.screenSize.width - impV.window_width - 10, 50);
		setVisible(true);
	}
	
	protected JLabel makeImg(String name, String location) {
		int width = 160;
		int height = 160;
		
		if(name == "스사마루 [A]" ) {
			width = 130;
			height = 130;
		}
		
		ImageIcon icon = new ImageIcon(location), updateIcon;
		Image img = icon.getImage();
		Image updateImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		updateIcon = new ImageIcon(updateImg);
		
		JLabel imgLabel = new JLabel(updateIcon);

		imgLabel.setBackground(new Color(0, 0, 0, 0));	// 배경 투명
		imgLabel.setSize(width, height);				//width, height

		return imgLabel;
	}
}
