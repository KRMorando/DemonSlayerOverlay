package demon;

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
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MissionSelectWindow extends JFrame {
	ImportentValue impV = new ImportentValue();
	
	private JPanel mainPanel, buttonPanel;
	private JLabel titleLabel;
	private JButton backButton;
	private ArrayList<OniInfo> oniInfoArray = new ArrayList<>();
	
	private String difficulty;
	private String OLocation[] = {	"Oni/D.png",
									"Oni/C.png",
									"Oni/B.png",
									"Oni/A.png",
									"Oni/S.png",
									"Oni/X.png",
									"Oni/Z.png"};
	
	public MissionSelectWindow(String difficulty) {
		impV.activeContainer = this;	//현재 활성화된 컨테이너 저장
		
		this.difficulty = difficulty;
		
		mainPanel = new MainPanel();
		titleLabel = new JLabel();
		buttonPanel = new JPanel();
		backButton = new BackButton(this, "Mission");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});

		/*	메인 프레임	*/
		impV.FrameSetting(this);
		
		/* 타이틀 라벨	*/
		titleLabel.setText(difficulty);						// 글자
		titleLabel.setFont(impV.titleTTF);				// 폰트
		titleLabel.setBackground(new Color(0, 0, 0, 0));	// 배경색
		titleLabel.setHorizontalAlignment(JLabel.CENTER);	// 중앙 정렬
		titleLabel.setBounds(0, 0, impV.window_width, 100); // x, y, width, height
		
		/* 버튼 패널 	*/
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(new Color(0, 0, 0, 0));
		buttonPanel.setBounds(0, 100, impV.window_width, impV.window_height - 140);
		
		/* 350, 600	*/
		/* makeCard(등급, 이름, 사진 경로) */
		
		if(difficulty.equals("노말"))
			titleLabel.setForeground(Color.white);	// 노말 (하얀색)
		else 
			titleLabel.setForeground(Color.red);	// 하드 (빨간색)
		
		CustomLayout(makeCard("D", "불당 오니 [Q]", OLocation[0]), 0, 0);
		CustomLayout(makeCard("C", "손 오니 [W]", OLocation[1]), 1, 0);
		CustomLayout(makeCard("B", "늪 오니 [E]", OLocation[2]), 2, 0);
		CustomLayout(makeCard("A", "스사마루 [A]", OLocation[3]), 0, 1);
		CustomLayout(makeCard("S", "쿄우가이 [S]", OLocation[4]), 1, 1);
		CustomLayout(makeCard("X", "루이 [D]", OLocation[5]), 2, 1);
		CustomLayout(makeCard("Z", "엔무 [Z]", OLocation[6]), 0, 2);

		/*	===============================================
			============	버튼 기능 노가다	===============
			===============================================	*/
		
		/*======================0번째======================*/
		/* 버튼 기능 추가	*/
		oniInfoArray.get(0).button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MissionOniWindow(difficulty, oniInfoArray.get(0).name, oniInfoArray.get(0).location, oniInfoArray.get(0).color);
				dispose();
			}
		});
		/*	버튼 마우스 인식	*/
		oniInfoArray.get(0).button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});
		/*======================1번째======================*/
		/* 버튼 기능 추가	*/
		oniInfoArray.get(1).button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MissionOniWindow(difficulty, oniInfoArray.get(1).name, oniInfoArray.get(1).location, oniInfoArray.get(1).color);
				dispose();
			}
		});
		/*	버튼 마우스 인식	*/
		oniInfoArray.get(1).button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});
		/*======================2번째======================*/
		/* 버튼 기능 추가	*/
		oniInfoArray.get(2).button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MissionOniWindow(difficulty, oniInfoArray.get(2).name, oniInfoArray.get(2).location, oniInfoArray.get(2).color);
				dispose();
			}
		});
		/*	버튼 마우스 인식	*/
		oniInfoArray.get(2).button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});
		/*======================3번째======================*/
		/* 버튼 기능 추가	*/
		oniInfoArray.get(3).button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MissionOniWindow(difficulty, oniInfoArray.get(3).name, oniInfoArray.get(3).location, oniInfoArray.get(3).color);
				dispose();
			}
		});
		/*	버튼 마우스 인식	*/
		oniInfoArray.get(3).button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});
		/*======================4번째======================*/
		/* 버튼 기능 추가	*/
		oniInfoArray.get(4).button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MissionOniWindow(difficulty, oniInfoArray.get(4).name, oniInfoArray.get(4).location, oniInfoArray.get(4).color);
				dispose();
			}
		});
		/*	버튼 마우스 인식	*/
		oniInfoArray.get(4).button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});
		/*======================5번째======================*/
		/* 버튼 기능 추가	*/
		oniInfoArray.get(5).button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MissionOniWindow(difficulty, oniInfoArray.get(5).name, oniInfoArray.get(5).location, oniInfoArray.get(5).color);
				dispose();
			}
		});
		/*	버튼 마우스 인식	*/
		oniInfoArray.get(5).button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});
		/*======================6번째======================*/
		/* 버튼 기능 추가	*/
		oniInfoArray.get(6).button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MissionOniWindow(difficulty, oniInfoArray.get(6).name, oniInfoArray.get(6).location, oniInfoArray.get(6).color);
				dispose();
			}
		});
		/*	버튼 마우스 인식	*/
		oniInfoArray.get(6).button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});
		/*	===============================================
			============	버튼 기능 노가다 끝	===============
			===============================================	*/
		
		mainPanel.add(titleLabel);
		mainPanel.add(buttonPanel);
		mainPanel.add(backButton);
		add(mainPanel);

		// 가로 세로 길이 지정 및 보이기
		setSize(impV.window_width, impV.window_height);
		setLocation(impV.screenSize.width - impV.window_width - 10, 50);
		setVisible(true);
	}
	
	protected Component makeCard(String rank, String name, String location) {
		int width = 100;
		int height = 140;
		
		URL url = this.getClass().getClassLoader().getResource(location);
		ImageIcon icon = new ImageIcon(url), updateIcon;
		Image img = icon.getImage(), updateImg;
		if(rank.equals("A"))
			updateImg = img.getScaledInstance(width - 20, height - 45, Image.SCALE_SMOOTH);
		else
			updateImg = img.getScaledInstance(width, height - 15, Image.SCALE_SMOOTH);
		
		updateIcon = new ImageIcon(updateImg);
		
		JPanel cardPanel = new JPanel();
		JLabel imgLabel = new JLabel(updateIcon);
		JLabel imgText = new JLabel();
		JButton mainButton = new JButton();
		
		cardPanel.setLayout(null);
		cardPanel.setBackground(new Color(0, 0, 0, 0));	//배경 투명
		cardPanel.setSize(width, height);					//width, height

		imgLabel.setBackground(new Color(0, 0, 0, 0));		// 배경 투명
		if(rank.equals("A"))
			imgLabel.setBounds(10, 15, width - 20, height - 45); 		// x, y, width, height
		else
			imgLabel.setBounds(0, 0, width, height - 15); 		// x, y, width, height

		imgText.setText(name); 								// 버튼 이름
		imgText.setBackground(new Color(0, 0, 0, 0));		// 배경색
		imgText.setFont(new Font(impV.ttf, Font.PLAIN, 18));// 폰트
		imgText.setHorizontalAlignment(JLabel.CENTER);
		imgText.setVerticalAlignment(JLabel.CENTER);
		imgText.setBounds(0, height - 25, width, 25);		// x, y, width, height
		if(rank.equals("D"))
			imgText.setForeground(Color.white);	// 글씨 색상
		else if(rank.equals("C"))
			imgText.setForeground(new Color(50, 150, 255));	// 글씨 색상
		else if(rank.equals("B"))
			imgText.setForeground(Color.green);	// 글씨 색상
		else if(rank.equals("A"))
			imgText.setForeground(Color.orange);// 글씨 색상
		else if(rank.equals("S"))
			imgText.setForeground(Color.cyan);// 글씨 색상
		else
			imgText.setForeground(Color.red);	// 글씨 색상
		
		mainButton.setText("");
		mainButton.setBackground(new Color(0, 0, 0, 0));	//배경 색
		mainButton.setBorderPainted(false); 				//테두리 없음
		mainButton.setFocusPainted(false); 					//선택 됐을 때 생기는 테두리 없애기
		mainButton.setBounds(0, 0, width, height);
		oniInfoArray.add(new OniInfo(mainButton, rank, name, location, imgText.getForeground()));
		
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
