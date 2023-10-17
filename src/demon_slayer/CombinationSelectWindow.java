package demon_slayer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.border.LineBorder;

public class CombinationSelectWindow extends JFrame {
	ImportentValue impV = new ImportentValue();

	private JPanel mainPanel, buttonPanel;
	private JLabel titleLabel, explainLabel;
	private JButton backButton;

	private String[] HLocation = {	"./images/Char/H/chaH_Sakonji.png",
									"./images/Char/H/chaH_Jigoro.png",
									"./images/Char/H/chaH_Tamayo.png",
									"./images/Char/H/chaH_Kanae.png",
									"./images/Char/H/chaH_Makomo.png",
									"./images/Char/H/chaH_Sabito.png" },

					XLocation = {	"./images/Char/X/chaX_Tanjiro.png",
									"./images/Char/X/chaX_Inosuke.png",
									"./images/Char/X/chaX_Zenitsu.png",
									"./images/Char/X/chaX_Giyu.png",
									"./images/Char/X/chaX_Tengen.png",
									"./images/Char/X/chaX_Mitsuri.png",
									"./images/Char/X/chaX_Muichiro.png" },

					ZLocation = {	"./images/Char/Z/chaZ_Kanao.png",
									"./images/Char/Z/chaZ_Nezuko.png",
									"./images/Char/Z/chaZ_Kyojuro.png" };

	public CombinationSelectWindow(String id) {
		impV.activeContainer = getRootPane().getContentPane();	//현재 활성화된 컨테이너 저장
		
		setUndecorated(true);	// 테두리 삭제
		setResizable(false);	// 크기 조절 여부

		mainPanel = new JPanel();
		titleLabel = new JLabel();
		explainLabel = new JLabel();
		buttonPanel = new JPanel();
		backButton = new JButton();

		setBackground(new Color(0, 0, 0, 0));

		/* 메인 패널 	*/
		mainPanel.setLayout(null); 											//레이아웃
		mainPanel.setBackground(impV.backColor);							//배경색
		mainPanel.setBorder(new LineBorder(Color.red, 2, true));			//테두리
		mainPanel.setBounds(0, 0, impV.window_width, impV.window_height);	//x, y, 가로, 세로
		
		/* 타이틀 라벨	*/
		titleLabel.setFont(impV.titleKostar);				// 폰트
		titleLabel.setBackground(new Color(0, 0, 0, 0));	// 배경색
		titleLabel.setHorizontalAlignment(JLabel.CENTER);	// 중앙 정렬
		titleLabel.setBounds(0, 0, impV.window_width, 100); // x, y, width, height
		
		/*	설명 라벨	*/
		explainLabel.setText("원하는 캐릭터를 눌러주세요.");
		explainLabel.setFont(impV.smallKostar);				// 폰트
		explainLabel.setForeground(Color.green);					// 색상
		explainLabel.setBackground(new Color(0, 0, 0, 0));		// 배경색
		explainLabel.setHorizontalAlignment(JLabel.CENTER);		// 중앙 정렬
		explainLabel.setBounds(0, 80, impV.window_width, 30);	// x, y, width, height
		
		/* 버튼 패널 	*/
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(new Color(0, 0, 0, 0));
		buttonPanel.setBounds(0, 100, impV.window_width, impV.window_height - 140);
		
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
				if(impV.sideContainer != null) {
					impV.sideContainer.setVisible(false);
					impV.sideContainer = null;
				}
				new CombinationWindow();
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
		
		/* 350, 600	*/

		/* makeCard(등급, 이름, 사진 경로) */
		/* H / X / Z 순서 */
		
		switch (id) {
		case "H": 
			titleLabel.setText("H");				// 내용
			titleLabel.setForeground(impV.HColor);	// 글 색상
			
			CustomLayout(makeCard("H", "사콘지", HLocation[0]), 0, 0);
			CustomLayout(makeCard("H", "지고로", HLocation[1]), 1, 0);
			CustomLayout(makeCard("H", "타마요", HLocation[2]), 2, 0);
			CustomLayout(makeCard("H", "카나에", HLocation[3]), 0, 1);
			CustomLayout(makeCard("H", "마코모", HLocation[4]), 1, 1);
			CustomLayout(makeCard("H", "사비토", HLocation[5]), 2, 1);
			break;
			
		case "X":
			titleLabel.setText("X");				// 내용
			titleLabel.setForeground(impV.XColor);	// 글 색상
			
			CustomLayout(makeCard("X", "탄지로", XLocation[0]), 0, 0);
			CustomLayout(makeCard("X", "이노스케", XLocation[1]), 1, 0);
			CustomLayout(makeCard("X", "젠이츠", XLocation[2]), 2, 0);
			CustomLayout(makeCard("X", "기유", XLocation[3]), 0, 1);
			CustomLayout(makeCard("X", "텐겐", XLocation[4]), 1, 1);
			CustomLayout(makeCard("X", "미츠리", XLocation[5]), 2, 1);
			CustomLayout(makeCard("X", "무이치로", XLocation[6]), 0, 2);
			break;
		  
		case "Z": 
			titleLabel.setText("Z"); 				// 내용
			titleLabel.setForeground(impV.ZColor);	// 글 색상
		  
			CustomLayout(makeCard("Z", "카나오", ZLocation[0]), 0, 1);
			CustomLayout(makeCard("Z", "네즈코", ZLocation[1]), 1, 1);
			CustomLayout(makeCard("Z", "쿄쥬로", ZLocation[2]), 2, 1);
			break;
		}

		mainPanel.add(titleLabel);
		mainPanel.add(explainLabel);
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

	protected Component makeCard(String rank, String name, String location) {
		int width = 100;
		int height = 140;
		
		ImageIcon icon = new ImageIcon(location), updateIcon;
		Image img = icon.getImage();
		Image updateImg = img.getScaledInstance(width, height - 25, Image.SCALE_SMOOTH);
		updateIcon = new ImageIcon(updateImg);
		
		JPanel cardPanel = new JPanel();
		JLabel imgLabel = new JLabel(updateIcon);
		JLabel imgText = new JLabel();
		JButton mainButton = new JButton();
		
		cardPanel.setLayout(null);
		cardPanel.setBackground(new Color(0, 0, 0, 0));	//배경 투명
		cardPanel.setSize(width, height);					//width, height

		imgLabel.setText("");
		imgLabel.setBackground(new Color(0, 0, 0, 0));		// 배경 투명
		imgLabel.setBounds(0, 0, width, height - 25); 		// x, y, width, height

		imgText.setText(name); 								// 버튼 이름
		imgText.setBackground(new Color(0, 0, 0, 0));		// 배경색
		imgText.setFont(impV.normalKostar); 				// 폰트
		imgText.setHorizontalAlignment(JLabel.CENTER);
		imgText.setVerticalAlignment(JLabel.CENTER);
		imgText.setBounds(0, height - 25, width, 25);		// x, y, width, height
		if(rank == "H")
			imgText.setForeground(impV.HColor);	// 글씨 색상
		else if(rank == "X")
			imgText.setForeground(impV.XColor);	// 글씨 색상
		else
			imgText.setForeground(impV.ZColor);	// 글씨 색상
		
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
		c.setLocation((12 * (1 + sequence)) + (100 * sequence), (5 * (1 + floor)) + (140 * floor));
		//				여백 계산					박스 계산		x / y
		buttonPanel.add(c);
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(new Color(0, 0, 0, 0));
	}
}
