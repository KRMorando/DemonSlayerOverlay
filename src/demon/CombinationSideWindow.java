package demon;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CombinationSideWindow extends JFrame implements Runnable {
	private JPanel mainPanel, levelPanel, explainPanel;
	private JPanel[] lvPanel = {new JPanel(), new JPanel(), new JPanel()};
//									3		/		2		/	1
	private JLabel titleLabel;
	private Border bf;
	
	protected static Thread runningThread;
	private static String name;
	private final int under_size = 250;
	//350, 180 + 250
	//350, 430
	
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

		runningThread = Thread.currentThread(); // 실행된 스레드 객체 얻기
		SystemManager.sideContainer = this;		// 현재 컨테이너 객체를 최근으로 등록
		
		mainPanel = new MainPanel();
		levelPanel = new JPanel();
		explainPanel = new JPanel();
		titleLabel = new JLabel();

		/* 메인 프레임 */
		SystemManager.FrameSetting(this);
		
		/* 메인 패널 	*/
		mainPanel.setBounds(0, 0, SystemManager.sideWindow_width, SystemManager.sideWindow_height + under_size);	//x, y, 가로, 세로
		
		/* 레벨 패널 */
		levelPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout(중앙 배치)
		levelPanel.setBackground(new Color(0, 0, 0, 0)); // 배경색
		levelPanel.setBounds(0, 10, SystemManager.sideWindow_width, SystemManager.sideWindow_height - 50); // 크기

		/* 설명 패널 */
		//350, 380
		explainPanel.setLayout(null);
		explainPanel.setBackground(new Color(0, 0, 0, 0));
		explainPanel.setBounds(0, 40, SystemManager.sideWindow_width, SystemManager.sideWindow_height + under_size - 50);
		
		/* 조합식 레벨 패널	*/
		//326, 120
		for(int i = 0; i < lvPanel.length; i++) {
			lvPanel[i].setLayout(null);
			lvPanel[i].setBackground(new Color(0, 0, 0, 0));
			lvPanel[i].setSize(SystemManager.sideWindow_width - 24, 120);
			if(name.equals("쿄쥬로")) {
				if(i == 0)
					bf = BorderFactory.createTitledBorder(new LineBorder(SystemManager.FourColor, 1), "Lv4", TitledBorder.LEFT, TitledBorder.TOP, SystemManager.smallTTF, SystemManager.FourColor);
				else if(i == 1)
					bf = BorderFactory.createTitledBorder(new LineBorder(SystemManager.ThreeColor, 1), "Lv3", TitledBorder.LEFT, TitledBorder.TOP, SystemManager.smallTTF, SystemManager.ThreeColor);
			} else if(name.equals("카마도 탄지로")) {
				if(i == 0)
					bf = BorderFactory.createTitledBorder(new LineBorder(SystemManager.XColor, 1), "LvX", TitledBorder.LEFT, TitledBorder.TOP, SystemManager.smallTTF, SystemManager.XColor);
				else if(i == 1)
					bf = BorderFactory.createTitledBorder(new LineBorder(SystemManager.ThreeColor, 1), "Lv3", TitledBorder.LEFT, TitledBorder.TOP, SystemManager.smallTTF, SystemManager.ThreeColor);
			} else {
				if(i == 0)
					bf = BorderFactory.createTitledBorder(new LineBorder(SystemManager.ThreeColor, 1), "Lv3", TitledBorder.LEFT, TitledBorder.TOP, SystemManager.smallTTF, SystemManager.ThreeColor);
				else if(i == 1)
					bf = BorderFactory.createTitledBorder(new LineBorder(SystemManager.TwoColor, 1), "Lv2", TitledBorder.LEFT, TitledBorder.TOP, SystemManager.smallTTF, SystemManager.TwoColor);
			}
			
			if(i == 2)
				bf = BorderFactory.createTitledBorder(new LineBorder(SystemManager.OneColor, 1), "Lv1", TitledBorder.LEFT, TitledBorder.TOP, SystemManager.smallTTF, SystemManager.OneColor);
			lvPanel[i].setBorder(bf);
			CustomLayout(explainPanel, lvPanel[i], 0, i);
		}
		
		/* 레벨 패널 추가 */
		levelPanel.add(SystemManager.lvL("1", "normal", "Lv1 "));
		levelPanel.add(SystemManager.lvL("2", "normal", "Lv2 "));
		levelPanel.add(SystemManager.lvL("3", "normal", "Lv3 "));
		levelPanel.add(SystemManager.lvL("4", "normal", "Lv4 "));
		levelPanel.add(SystemManager.lvL("H", "normal", "LvH "));
		levelPanel.add(SystemManager.lvL("X", "normal", "LvX "));
		levelPanel.add(SystemManager.lvL("Z", "normal", "LvZ"));
		
		/* makeCard(등급, 이름, 사진 경로) */
		/* CustomLayout(컴포넌트, n번째 (0~2), 층(1~)	*/
		
		/* 설명 패널 추가	*/
		switch(name) {
		/*======H=======*/
		case "사콘지":
			CustomLayout(lvPanel[1], makeCard("2", "무라타x2", SystemManager.TwoLocation[3]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "큐브선배x2", SystemManager.OneLocation[1]), 0, 0);
			CustomLayout(lvPanel[2], makeCard("1", "아오이x2", SystemManager.OneLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "탄지로x2", SystemManager.OneLocation[3]), 2, 0);
			break;
			
		case "지고로":
			CustomLayout(lvPanel[1], makeCard("2", "젠이츠x2", SystemManager.TwoLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "큐브선배x2", SystemManager.OneLocation[1]), 0, 0);
			CustomLayout(lvPanel[2], makeCard("1", "유시로x2", SystemManager.OneLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "네즈코x2", SystemManager.OneLocation[2]), 2, 0);
			break;
			
		case "타마요":
			CustomLayout(lvPanel[1], makeCard("2", "카나오x2", SystemManager.TwoLocation[2]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "아오이x2", SystemManager.OneLocation[0]), 0, 0);
			CustomLayout(lvPanel[2], makeCard("1", "유시로x2", SystemManager.OneLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "네즈코x2", SystemManager.OneLocation[2]), 2, 0);
			break;
			
		case "카나에":
			CustomLayout(lvPanel[0], makeCard("3", "무이치로x1", SystemManager.ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "카나오x1", SystemManager.TwoLocation[2]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "탄지로x2", SystemManager.OneLocation[3]), 1, 0);
			break;
			
		case "마코모":
			CustomLayout(lvPanel[0], makeCard("3", "미츠리x1", SystemManager.ThreeLocation[0]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "겐야x1", SystemManager.TwoLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "아오이x2", SystemManager.OneLocation[0]), 1, 0);
			break;
			
		case "사비토":
			CustomLayout(lvPanel[0], makeCard("3", "무이치로x1", SystemManager.ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "젠이츠x1", SystemManager.TwoLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "탄지로x2", SystemManager.OneLocation[3]), 1, 0);
			break;
			
		/*======EH======*/
		case "호타루":
			CustomLayout(lvPanel[0], makeCard("3", "무이치로x1", SystemManager.ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "젠이츠x1", SystemManager.TwoLocation[4]), 0, 0);
			CustomLayout(lvPanel[1], makeCard("2", "겐야x1", SystemManager.TwoLocation[0]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "이노스케x1", SystemManager.TwoLocation[1]), 2, 0);
			CustomLayout(lvPanel[2], makeCard("1", "탄지로x1", SystemManager.OneLocation[3]), 1, 0);
			break;
			
		/*======X=======*/
		case "탄지로":
			CustomLayout(lvPanel[0], makeCard("3", "무이치로x1", SystemManager.ThreeLocation[1]), 0, 0);
			CustomLayout(lvPanel[0], makeCard("3", "오바나이x1", SystemManager.ThreeLocation[2]), 1, 0);
			CustomLayout(lvPanel[0], makeCard("3", "텐겐x1", SystemManager.ThreeLocation[4]), 2, 0);
			CustomLayout(lvPanel[1], makeCard("2", "무라타x2", SystemManager.TwoLocation[3]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "탄지로x2", SystemManager.OneLocation[3]), 1, 0);
			break;
			
		case "이노스케":
			CustomLayout2(lvPanel[0], makeCard("3", "사네미x2", SystemManager.ThreeLocation[3]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "텐겐x1", SystemManager.ThreeLocation[4]), 1, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "겐야x2", SystemManager.TwoLocation[0]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "이노스케x1", SystemManager.TwoLocation[1]), 1, 0);
			break;
			
		case "젠이츠":
			CustomLayout2(lvPanel[0], makeCard("3", "미츠리x2", SystemManager.ThreeLocation[0]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "사네미x1", SystemManager.ThreeLocation[3]), 1, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "무라타x2", SystemManager.TwoLocation[3]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "젠이츠x1", SystemManager.TwoLocation[4]), 1, 0);
			break;
			
		case "기유":
			CustomLayout2(lvPanel[0], makeCard("3", "오바나이x2", SystemManager.ThreeLocation[2]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "사네미x1", SystemManager.ThreeLocation[3]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "이노스케x2", SystemManager.TwoLocation[1]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "큐브선배x2", SystemManager.OneLocation[1]), 1, 0);
			break;
			
		case "텐겐":
			CustomLayout2(lvPanel[0], makeCard("3", "텐겐x2", SystemManager.ThreeLocation[4]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "미츠리x1", SystemManager.ThreeLocation[0]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "카나오x2", SystemManager.TwoLocation[2]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "큐브선배x2", SystemManager.OneLocation[1]), 1, 0);
			break;
			
		case "미츠리":
			CustomLayout(lvPanel[0], makeCard("3", "미츠리x1", SystemManager.ThreeLocation[0]), 0, 0);
			CustomLayout(lvPanel[0], makeCard("3", "무이치로x1", SystemManager.ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[0], makeCard("3", "오바나이x1", SystemManager.ThreeLocation[2]), 2, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "이노스케x1", SystemManager.TwoLocation[1]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "젠이츠x1", SystemManager.TwoLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "네즈코x2", SystemManager.OneLocation[2]), 1, 0);
			break;
			
		case "무이치로":
			CustomLayout2(lvPanel[0], makeCard("3", "무이치로x2", SystemManager.ThreeLocation[1]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "미츠리x1", SystemManager.ThreeLocation[0]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "겐야x2", SystemManager.TwoLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "유시로x2", SystemManager.OneLocation[4]), 1, 0);
			break;
			
		case "겐야":
			CustomLayout2(lvPanel[0], makeCard("3", "사네미x2", SystemManager.ThreeLocation[3]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "오바나이x1", SystemManager.ThreeLocation[2]), 1, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "카나오x1", SystemManager.TwoLocation[2]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "겐야x1", SystemManager.TwoLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "유시로x2", SystemManager.OneLocation[4]), 1, 0);
			break;
			
		/*======Z=======*/
		case "카나오":
			CustomLayout(lvPanel[0], makeCard("3", "미츠리x2", SystemManager.ThreeLocation[0]), 0, 0);
			CustomLayout(lvPanel[0], makeCard("3", "무이치로x2", SystemManager.ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[0], makeCard("3", "오바나이x2", SystemManager.ThreeLocation[2]), 2, 0);
			CustomLayout(lvPanel[2], makeCard("1", "아오이x2", SystemManager.OneLocation[0]), 1, 0);
			break;
			
		case "네즈코":
			CustomLayout(lvPanel[0], makeCard("3", "텐겐x2", SystemManager.ThreeLocation[4]), 0, 0);
			CustomLayout(lvPanel[0], makeCard("3", "무이치로x2", SystemManager.ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[0], makeCard("3", "사네미x1", SystemManager.ThreeLocation[3]), 2, 0);
			CustomLayout(lvPanel[1], makeCard("2", "카나오x2", SystemManager.TwoLocation[2]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "네즈코x2", SystemManager.OneLocation[2]), 1, 0);
			break;
			
		case "쿄쥬로":
			CustomLayout(lvPanel[0], makeCard("4", "쿄쥬로x1", SystemManager.FourLocation[3]), 1, 0);
			CustomLayout2(lvPanel[1], makeCard("3", "오바나이x2", SystemManager.ThreeLocation[2]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("3", "미츠리x1", SystemManager.ThreeLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "탄지로x2", SystemManager.OneLocation[3]), 1, 0);
			break;
			
		/*=======SZ======*/
		case "카마도 탄지로":
			CustomLayout(lvPanel[0], makeCard("X", "탄지로x1", SystemManager.XLocation[0]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("3", "ALL Lv3x2", SystemManager.ThreeLocation[2]), 1, 0);
			break;
		}
		
		mainPanel.add(levelPanel);
		mainPanel.add(explainPanel);
		add(mainPanel);

		// 가로 세로 길이 지정 및 보이기
		setSize(SystemManager.sideWindow_width, SystemManager.sideWindow_height + under_size);
		setLocation(SystemManager.screenSize.width - SystemManager.window_width - SystemManager.sideWindow_width - 8, 50);
		setVisible(true);
		
		try {
			Thread.sleep(SystemManager.cooltime * 1000);
			runningThread = null;
			SystemManager.sideContainer = null;
			dispose();
		} catch (InterruptedException e) {
			dispose();
		}
	}
	
	protected Component makeCard(String rank, String name, String location) {
		int width = 92;
		int height = 120;
		
		URL url = this.getClass().getClassLoader().getResource(location);
		ImageIcon icon = new ImageIcon(url), updateIcon;
		Image img = icon.getImage();
		Image updateImg = img.getScaledInstance(width, height - 15, Image.SCALE_SMOOTH);
		updateIcon = new ImageIcon(updateImg);
		
		JPanel cardPanel = new JPanel();
		JLabel imgLabel = new JLabel(updateIcon);
		JLabel imgText = new JLabel();
		
		cardPanel.setLayout(null);
		cardPanel.setBackground(new Color(0, 0, 0, 0));	//배경 투명
		cardPanel.setSize(width, height);				//width, height

		imgLabel.setText("");
		imgLabel.setBackground(new Color(0, 0, 0, 0));	// 배경 투명
		imgLabel.setBounds(0, 0, width, height - 25); 	// x, y, width, height

		imgText.setText(name); 							// 버튼 이름
		imgText.setBackground(new Color(0, 0, 0, 0));	// 배경색
		imgText.setFont(SystemManager.smallTTF); 				// 폰트
		imgText.setHorizontalAlignment(JLabel.CENTER);
		imgText.setVerticalAlignment(JLabel.CENTER);
		imgText.setBounds(0, height - 40, width, 35);	// x, y, width, height
		if(rank.equals("1"))
			imgText.setForeground(SystemManager.OneColor);	//글씨 색상
		else if(rank.equals("2"))
			imgText.setForeground(SystemManager.TwoColor);	//글씨 색상
		else if(rank.equals("3"))
			imgText.setForeground(SystemManager.ThreeColor);//글씨 색상
		else if(rank.equals("4"))
			imgText.setForeground(SystemManager.FourColor);	//글씨 색상
		else if(rank.equals("H"))
			imgText.setForeground(SystemManager.HColor);	//글씨 색상
		else if(rank.equals("EH"))
			imgText.setForeground(SystemManager.EHColor);	//글씨 색상
		else if(rank.equals("X"))
			imgText.setForeground(SystemManager.XColor);	//글씨 색상
		else if(rank.equals("Z"))
			imgText.setForeground(SystemManager.ZColor);	//글씨 색상
		else
			imgText.setForeground(SystemManager.SZColor);	//글씨 색상
		
		cardPanel.add(imgLabel);
		cardPanel.add(imgText);
		
		return cardPanel;
	}
	
	protected void CustomLayout(JPanel panel, Component c, int sequence, int floor) {
		c.setLocation((10 * (1 + sequence)) + (100 * sequence), (5 * (1 + floor)) + (120 * floor));
		//				여백 계산					박스 계산		x / y
		panel.add(c);
	}
	
	protected void CustomLayout2(JPanel panel, Component c, int sequence, int floor) {
		c.setLocation((46 * (1 + sequence)) + (100 * sequence), (5 * (1 + floor)) + (120 * floor));
		//				여백 계산					박스 계산		x / y
		panel.add(c);
	}
}
