package demon_slayer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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

public class CombinationSideWindow extends JFrame implements Runnable {
	ImportentValue impV = new ImportentValue();
	JPanel mainPanel, levelPanel, explainPanel;
	JPanel[] lvPanel = {new JPanel(), new JPanel(), new JPanel()};
//							3		/		2		/	1
	JLabel titleLabel;
	Border bf;
	
	protected static Thread runningThread;
	private static String name;
	private final int under_size = 250;
	//350, 180 + 250
	//350, 430
	
	private String[] OneLocation = {"./images/Char/1/cha1_Aoi.png",
									"./images/Char/1/cha1_Cube.png",
									"./images/Char/1/cha1_Nezuko.png",
									"./images/Char/1/cha1_Tanjiro.png",
									"./images/Char/1/cha1_Yusiro.png"},

					TwoLocation = {	"./images/Char/2/cha2_Genya.png",
									"./images/Char/2/cha2_Inosuke.png",
									"./images/Char/2/cha2_Kanao.png",
									"./images/Char/2/cha2_Murata.png",
									"./images/Char/2/cha2_Zenitsu.png"},

					ThreeLocation = {"./images/Char/3/cha3_Mitsuri.png",
									 "./images/Char/3/cha3_Muichiro.png",
									 "./images/Char/3/cha3_obanai.png",
									 "./images/Char/3/cha3_Sanemi.png",
									 "./images/Char/3/cha3_Tengen.png" },
					
					FourLocation = {"./images/Char/4/cha4_Giyu.png",
									"./images/Char/4/cha4_Gyomei.png",
									"./images/Char/4/cha4_Kagaya.png",
									"./images/Char/4/cha4_Kyojuro.png",
									"./images/Char/4/cha4_Shinobu.png" },
	
					HLocation = {	"./images/Char/H/chaH_Sakonji.png",
									"./images/Char/H/chaH_Jigoro.png",
									"./images/Char/H/chaH_Tamayo.png",
									"./images/Char/H/chaH_Kanae.png",
									"./images/Char/H/chaH_Makomo.png",
									"./images/Char/H/chaH_Sabito.png" },

					XLocation = {	"./images/Char/H/chaX_Tanjiro.png",
									"./images/Char/H/chaX_Inosuke.png",
									"./images/Char/H/chaX_Zenitsu.png",
									"./images/Char/H/chaX_Giyu.png",
									"./images/Char/H/chaX_Tengen.png",
									"./images/Char/H/chaX_Mitsuri.png",
									"./images/Char/H/chaX_Muichiro.png" },

					ZLocation = {	"./images/Char/Z/chaZ_Kanao.png",
									"./images/Char/Z/chaZ_Nezuko.png",
									"./images/Char/Z/chaZ_Kyojuro.png" };
	
	public CombinationSideWindow(String name) {
		this.name = name;
	}
	
	public void run() {
		if (runningThread != null) {
			try {
				runningThread.interrupt(); // 이미 실행된 스레드는 작동 취소
			} 	catch (Exception e) {
				e.printStackTrace();
			}
		}

		runningThread = Thread.currentThread(); 				// 실행된 스레드 객체 얻기
		impV.sideContainer = getRootPane().getContentPane();	// 현재 컨테이너 객체를 최근으로 등록
		
		setUndecorated(true);	// 테두리 삭제
		setResizable(false);	// 크기 조절 여부
		
		mainPanel = new JPanel();
		levelPanel = new JPanel();
		explainPanel = new JPanel();
		titleLabel = new JLabel();
		
		setBackground(new Color(0, 0, 0, 0));

		/* 메인 패널 	*/
		mainPanel.setLayout(null); 											//레이아웃
		mainPanel.setBackground(impV.backColor);							//배경색
		mainPanel.setBorder(new LineBorder(Color.red, 2, true));			//테두리
		mainPanel.setBounds(0, 0, impV.sideWindow_width, impV.sideWindow_height + under_size);	//x, y, 가로, 세로
		
		/* 레벨 패널 */
		levelPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout(중앙 배치)
		levelPanel.setBackground(new Color(0, 0, 0, 0)); // 배경색
		levelPanel.setBounds(0, 10, impV.sideWindow_width, impV.sideWindow_height - 50); // 크기

		/* 설명 패널 */
		//350, 380
		explainPanel.setLayout(null);
		explainPanel.setBackground(new Color(0, 0, 0, 0));
		explainPanel.setBounds(0, 40, impV.sideWindow_width, impV.sideWindow_height + under_size - 50);
		
		/* 조합식 레벨 패널	*/
		//326, 120
		for(int i = 0; i < lvPanel.length; i++) {
			lvPanel[i].setLayout(null);
			lvPanel[i].setBackground(new Color(0, 0, 0, 0));
			lvPanel[i].setSize(impV.sideWindow_width - 24, 120);
			if(name != "쿄쥬로") {
				if(i == 0)
					bf = BorderFactory.createTitledBorder(new LineBorder(impV.ThreeColor, 1), "Lv3", TitledBorder.LEFT, TitledBorder.TOP, impV.smallKostar, impV.ThreeColor);
				else if(i == 1)
					bf = BorderFactory.createTitledBorder(new LineBorder(impV.TwoColor, 1), "Lv2", TitledBorder.LEFT, TitledBorder.TOP, impV.smallKostar, impV.TwoColor);
				else
					bf = BorderFactory.createTitledBorder(new LineBorder(impV.OneColor, 1), "Lv1", TitledBorder.LEFT, TitledBorder.TOP, impV.smallKostar, impV.OneColor);
			} else {
				if(i == 0)
					bf = BorderFactory.createTitledBorder(new LineBorder(impV.FourColor, 1), "Lv4", TitledBorder.LEFT, TitledBorder.TOP, impV.smallKostar, impV.FourColor);
				else if(i == 1)
					bf = BorderFactory.createTitledBorder(new LineBorder(impV.ThreeColor, 1), "Lv3", TitledBorder.LEFT, TitledBorder.TOP, impV.smallKostar, impV.ThreeColor);
				else
					bf = BorderFactory.createTitledBorder(new LineBorder(impV.OneColor, 1), "Lv1", TitledBorder.LEFT, TitledBorder.TOP, impV.smallKostar, impV.OneColor);
			}
			lvPanel[i].setBorder(bf);
			CustomLayout(explainPanel, lvPanel[i], 0, i);
		}
		
		/* 레벨 패널 추가 */
		levelPanel.add(impV.lv1("Lv1 "));
		levelPanel.add(impV.lv2("Lv2 "));
		levelPanel.add(impV.lv3("Lv3 "));
		levelPanel.add(impV.lv4("Lv4 "));
		levelPanel.add(impV.lvH("LvH "));
		levelPanel.add(impV.lvX("LvX "));
		levelPanel.add(impV.lvZ("LvZ"));
		
		/* makeCard(등급, 이름, 사진 경로) */
		/* CustomLayout(컴포넌트, n번째 (0~2), 층(1~)	*/
		
		/* 설명 패널 추가	*/
		switch(name) {
		/*======H=======*/
		case "사콘지":
			CustomLayout(lvPanel[1], makeCard("2", "무라타x2", TwoLocation[3]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "큐브선배x2", OneLocation[1]), 0, 0);
			CustomLayout(lvPanel[2], makeCard("1", "아오이x2", OneLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "탄지로x2", OneLocation[3]), 2, 0);
			break;
			
		case "지고로":
			CustomLayout(lvPanel[1], makeCard("2", "젠이츠x2", TwoLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "큐브선배x2", OneLocation[1]), 0, 0);
			CustomLayout(lvPanel[2], makeCard("1", "유시로x2", OneLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "네즈코x2", OneLocation[2]), 2, 0);
			break;
			
		case "타마요":
			CustomLayout(lvPanel[1], makeCard("2", "카나오x2", TwoLocation[2]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "아오이x2", OneLocation[0]), 0, 0);
			CustomLayout(lvPanel[2], makeCard("1", "유시로x2", OneLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "네즈코x2", OneLocation[2]), 2, 0);
			break;
			
		case "카나에":
			CustomLayout(lvPanel[0], makeCard("3", "무이치로x1", ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "카나오x1", TwoLocation[2]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "탄지로x2", OneLocation[3]), 1, 0);
			break;
			
		case "마코모":
			CustomLayout(lvPanel[0], makeCard("3", "미츠리x1", ThreeLocation[0]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "겐야x1", TwoLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "아오이x2", OneLocation[0]), 1, 0);
			break;
			
		case "사비토":
			CustomLayout(lvPanel[0], makeCard("3", "무이치로x1", ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "젠이츠x1", TwoLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "탄지로x2", OneLocation[3]), 1, 0);
			break;
			
		/*======X=======*/
		case "탄지로":
			CustomLayout(lvPanel[0], makeCard("3", "무이치로x1", ThreeLocation[1]), 0, 0);
			CustomLayout(lvPanel[0], makeCard("3", "오바나이x1", ThreeLocation[2]), 1, 0);
			CustomLayout(lvPanel[0], makeCard("3", "텐겐x1", ThreeLocation[4]), 2, 0);
			CustomLayout(lvPanel[1], makeCard("2", "무라타x2", TwoLocation[3]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "탄지로x2", OneLocation[3]), 1, 0);
			break;
			
		case "이노스케":
			CustomLayout2(lvPanel[0], makeCard("3", "사네미x2", ThreeLocation[3]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "텐겐x1", ThreeLocation[4]), 1, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "겐야x2", TwoLocation[0]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "이노스케x1", TwoLocation[1]), 1, 0);
			break;
			
		case "젠이츠":
			CustomLayout2(lvPanel[0], makeCard("3", "미츠리x2", ThreeLocation[0]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "사네미x1", ThreeLocation[3]), 1, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "무라타x2", TwoLocation[3]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "젠이츠x1", TwoLocation[4]), 1, 0);
			break;
			
		case "기유":
			CustomLayout2(lvPanel[0], makeCard("3", "오바나이x2", ThreeLocation[2]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "사네미x1", ThreeLocation[3]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "이노스케x2", TwoLocation[1]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "큐브선배x2", OneLocation[1]), 1, 0);
			break;
			
		case "텐겐":
			CustomLayout2(lvPanel[0], makeCard("3", "텐겐x2", ThreeLocation[4]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "미츠리x1", ThreeLocation[0]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "카나오x2", TwoLocation[2]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "큐브선배x2", OneLocation[1]), 1, 0);
			break;
			
		case "미츠리":
			CustomLayout2(lvPanel[0], makeCard("3", "미츠리x1", ThreeLocation[0]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "무이치로x1", ThreeLocation[1]), 1, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "이노스케x2", TwoLocation[1]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "젠이츠x1", TwoLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "네즈코x2", OneLocation[2]), 1, 0);
			break;
			
		case "무이치로":
			CustomLayout2(lvPanel[0], makeCard("3", "무이치로x2", ThreeLocation[1]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "미츠리x1", ThreeLocation[0]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "겐야x2", TwoLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "유시로x2", OneLocation[4]), 1, 0);
			break;
			
		/*======Z=======*/
		case "카나오":
			CustomLayout(lvPanel[0], makeCard("3", "미츠리x2", ThreeLocation[0]), 0, 0);
			CustomLayout(lvPanel[0], makeCard("3", "무이치로x2", ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[0], makeCard("3", "오바나이x2", ThreeLocation[2]), 2, 0);
			CustomLayout(lvPanel[2], makeCard("1", "아오이x2", OneLocation[0]), 1, 0);
			break;
			
		case "네즈코":
			CustomLayout(lvPanel[0], makeCard("3", "텐겐x2", ThreeLocation[4]), 0, 0);
			CustomLayout(lvPanel[0], makeCard("3", "무이치로x2", ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[0], makeCard("3", "사네미x1", ThreeLocation[3]), 2, 0);
			CustomLayout(lvPanel[1], makeCard("2", "카나오x2", TwoLocation[2]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "네즈코x2", OneLocation[2]), 1, 0);
			break;
			
		case "쿄쥬로":
			CustomLayout(lvPanel[0], makeCard("4", "쿄쥬로x1", FourLocation[3]), 1, 0);
			CustomLayout2(lvPanel[1], makeCard("3", "오바나이x2", ThreeLocation[2]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("3", "미츠리x1", ThreeLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "탄지로x2", OneLocation[3]), 1, 0);
			break;
		}
		
		mainPanel.add(levelPanel);
		mainPanel.add(explainPanel);
		add(mainPanel);
		
		setAlwaysOnTop(true); // 항상 위에 보이기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우 종료시 javax도 종료

		// 가로 세로 길이 지정 및 보이기
		setSize(impV.sideWindow_width, impV.sideWindow_height + under_size);
		setLocation(impV.screenSize.width - impV.window_width - impV.sideWindow_width - 8, 50);
		setVisible(true);
		
		try {
			Thread.sleep(impV.cooltime * 1000);
			runningThread = null;
			impV.sideContainer = null;
			setVisible(false);
		} catch (InterruptedException e) {
			setVisible(false);
		}
	}
	
	protected Component makeCard(String rank, String name, String location) {
		int width = 92;
		int height = 120;
		
		ImageIcon icon = new ImageIcon(location), updateIcon;
		Image img = icon.getImage();
		Image updateImg = img.getScaledInstance(width, height - 25, Image.SCALE_SMOOTH);
		updateIcon = new ImageIcon(updateImg);
		
		JPanel cardPanel = new JPanel();
		JLabel imgLabel = new JLabel(updateIcon);
		JLabel imgText = new JLabel();
		
		cardPanel.setLayout(null);
		cardPanel.setBackground(new Color(0, 0, 0, 0));	//배경 투명
		cardPanel.setSize(width, height);					//width, height

		imgLabel.setText("");
		imgLabel.setBackground(new Color(0, 0, 0, 0));		// 배경 투명
		imgLabel.setBounds(0, 0, width, height - 25); 		// x, y, width, height

		imgText.setText(name); 								// 버튼 이름
		imgText.setBackground(new Color(0, 0, 0, 0));		// 배경색
		imgText.setFont(impV.smallKostar); 				// 폰트
		imgText.setHorizontalAlignment(JLabel.CENTER);
		imgText.setVerticalAlignment(JLabel.CENTER);
		imgText.setBounds(0, height - 40, width, 35);		// x, y, width, height
		if(rank == "1")
			imgText.setForeground(impV.OneColor);				//글씨 색상
		else if(rank == "2")
			imgText.setForeground(impV.TwoColor);	//글씨 색상
		else if(rank == "3")
			imgText.setForeground(impV.ThreeColor);				//글씨 색상
		else if(rank == "4")
			imgText.setForeground(impV.FourColor);			//글씨 색상
		else if(rank == "H")
			imgText.setForeground(impV.HColor);				//글씨 색상
		else if(rank == "X")
			imgText.setForeground(impV.XColor);				//글씨 색상
		else
			imgText.setForeground(impV.ZColor);				//글씨 색상
		
		cardPanel.add(imgLabel);
		cardPanel.add(imgText);
		
		return cardPanel;
	}
	
	protected void CustomLayout(JPanel panel, Component c, int sequence, int floor) {
		c.setLocation((12 * (1 + sequence)) + (100 * sequence), (5 * (1 + floor)) + (120 * floor));
		//				여백 계산					박스 계산		x / y
		panel.add(c);
	}
	
	protected void CustomLayout2(JPanel panel, Component c, int sequence, int floor) {
		c.setLocation((46 * (1 + sequence)) + (100 * sequence), (5 * (1 + floor)) + (120 * floor));
		//				여백 계산					박스 계산		x / y
		panel.add(c);
	}
}
