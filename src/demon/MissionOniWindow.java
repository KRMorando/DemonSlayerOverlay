package demon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

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
	private JPanel mainPanel, difficultyPanel, namePanel, rankPanel, shieldPanel, minCutPanel, minFPanel, minSPanel, minTPanel;
	private JLabel oniLabel, roundLabel, leftLabel, rightLabel, difficultyLabel;
	private JButton backButton;
	
	private Border bf;
	private final Color lineColor = Color.red;
	
	public MissionOniWindow(String difficulty, String name, String location, Color color) {
		impV.activeContainer = this;	//현재 활성화된 컨테이너 저장
		
		mainPanel = new MainPanel();
		difficultyPanel = new JPanel();
		namePanel = new JPanel();
		rankPanel = new JPanel();
		shieldPanel = new JPanel();
		minCutPanel = new JPanel();
		minFPanel = new JPanel();
		minSPanel = new JPanel();
		minTPanel = new JPanel();
		
		roundLabel = new JLabel();
		leftLabel = new JLabel();
		rightLabel = new JLabel();
		difficultyLabel = new JLabel();
		backButton = new BackButton(this, difficulty);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});
		
		/*	350, 600	*/
		/*	메인 프레임	*/
		impV.FrameSetting(this);
		
		/*	난이도 패널	*/
		difficultyPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); //레이아웃
		difficultyPanel.setBackground(new Color(0, 0, 0, 0));		//배경색
		difficultyPanel.setBounds(5, 5, impV.window_width - 5, 40);					//x, y, 가로, 세로
		
		leftLabel.setText("[");
		leftLabel.setFont(impV.smallTTF);
		leftLabel.setForeground(Color.cyan);
		leftLabel.setSize(30, 40);
		
		if(difficulty.equals("하드")) {
			difficultyLabel.setText("Hard");
			difficultyLabel.setForeground(Color.red);
		} else {
			difficultyLabel.setText("Normal");
			difficultyLabel.setForeground(Color.white);
		}
		difficultyLabel.setFont(impV.smallTTF);
		difficultyLabel.setSize(60, 40);
		
		rightLabel.setText("]");
		rightLabel.setFont(impV.smallTTF);
		rightLabel.setForeground(Color.cyan);
		rightLabel.setSize(30, 40);
		
		/*	라운드 라벨	*/
		roundLabel.setBackground(new Color(0, 0, 0, 0));
		roundLabel.setForeground(Color.red);
		roundLabel.setFont(impV.smallTTF);
		
		difficultyPanel.add(leftLabel);
		difficultyPanel.add(difficultyLabel);
		difficultyPanel.add(rightLabel);
		difficultyPanel.add(roundLabel);
		
		/*	오니 사진	*/
		oniLabel = makeImg(name, location);
		if(name.equals("스사마루 [A]"))
			oniLabel.setLocation((int)((350 - oniLabel.getWidth()) / 2), 40);
		else
			oniLabel.setLocation((int)((350 - oniLabel.getWidth()) / 2), 20);
		
		/*	이름 패널	*/
		bf = BorderFactory.createTitledBorder(new LineBorder(lineColor, 1), "보스명", TitledBorder.LEFT, TitledBorder.TOP, impV.normalTTF, Color.white);
		namePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		namePanel.setBackground(new Color(0, 0, 0, 0));
		namePanel.setBorder(bf);
		namePanel.setBounds(10, 180, impV.window_width - 90, 70);
		
		/*	랭크 패널	*/
		bf = BorderFactory.createTitledBorder(new LineBorder(lineColor, 1), "랭크", TitledBorder.CENTER, TitledBorder.TOP, impV.normalTTF, Color.red);
		rankPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		rankPanel.setBackground(new Color(0, 0, 0, 0));
		rankPanel.setBorder(bf);
		rankPanel.setBounds(impV.window_width - 80, 180, 70, 70);
		
		/*	쉴드 패널	*/
		bf = BorderFactory.createTitledBorder(new LineBorder(lineColor, 1), "방어력 / 쉴드 / 체력", TitledBorder.LEFT, TitledBorder.TOP, impV.normalTTF, Color.white);
		shieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		shieldPanel.setBackground(new Color(0, 0, 0, 0));
		shieldPanel.setBorder(bf);
		shieldPanel.setBounds(10, 260, impV.window_width - 20, 70);
		
		/*	임무 조건 패널	*/
		bf = BorderFactory.createTitledBorder(new LineBorder(lineColor, 1), "임무 조건", TitledBorder.LEFT, TitledBorder.TOP, impV.normalTTF, Color.white);
		minCutPanel.setLayout(null);
		minCutPanel.setBackground(new Color(0, 0, 0, 0));
		minCutPanel.setBorder(bf);
		minCutPanel.setBounds(10, 340, impV.window_width - 20, 190);
		
		minFPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		minFPanel.setBackground(new Color(0, 0, 0, 0));
		minFPanel.setBounds(5, 30, impV.window_width - 25, 30);
		minFPanel.add(impV.lvL("1", "normal", "권장 유닛: "));
		minSPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		minSPanel.setBackground(new Color(0, 0, 0, 0));
		minSPanel.setBounds(5, 60, impV.window_width - 25, 30);
		minTPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		minTPanel.setBackground(new Color(0, 0, 0, 0));
		minTPanel.setBounds(5, 120, impV.window_width - 25, 70);
		if(!(name.equals("쿄우가이 [S]") && !(name.equals("루이 [D]"))))
			minSPanel.add(impV.lvL("1", "normal", "강화 수치: "));
		else {
			minSPanel.add(impV.customText("주의!", Color.red, 20));
			minSPanel.setBounds(5, 150, impV.window_width - 25, 30);
			minTPanel.setBounds(5, 90, impV.window_width - 25, 70);
		}
		minTPanel.add(impV.lvL("Z", "normal", "Tip: "));
		minCutPanel.add(minFPanel);
		minCutPanel.add(minSPanel);
		minCutPanel.add(minTPanel);
		
		
		//세부 내용
		/*	namePanel	/	rankPanel	/	shieldPanel	/	minCutPanel	*/
		/*	이름			/	랭크			/	방,쉴, 체		/	최소 컷		*/
		switch(name) {
		case "불당 오니 [Q]":
			roundLabel.setText("10라운드부터 가능합니다");
			namePanel.add(impV.customText("불당 오니", Color.white, 20));
			rankPanel.add(impV.customText("D", Color.red, 25));
			shieldPanel.add(impV.customText("5", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("11", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("2,700", Color.green, 20));
			minFPanel.add(impV.lvL("2", "normal", "2레벨 x 2"));
			minSPanel.add(impV.lvL("2", "normal", "2레벨"));
			minSPanel.add(impV.lvL("1", "normal", "2강화"));
			if(difficulty.equals("노말"))
				minTPanel.add(impV.lvL("Z", "normal", "2레벨 1개로도 가능하다."));
			else {
				minTPanel.add(impV.lvL("Z", "normal", "2레벨 1개로도 가능하지만"));
				minTPanel.add(impV.lvL("Z", "normal", "컨트롤에 적응한 후에 권장한다."));
			}
			break;
		case "손 오니 [W]":
			roundLabel.setText("15라운드부터 가능합니다");
			namePanel.add(impV.customText("손 오니", Color.white, 20));
			rankPanel.add(impV.customText("C", Color.red, 25));
			shieldPanel.add(impV.customText("30", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("36", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("9,000", Color.green, 20));
			if(difficulty.equals("노말")) {
				minFPanel.add(impV.lvL("2", "normal", "2레벨 x 5"));
				minSPanel.add(impV.lvL("2", "normal", "2레벨"));
				minSPanel.add(impV.lvL("1", "normal", "2강화"));
				minTPanel.add(impV.customText("(업적)", Color.red, 20));
				minTPanel.add(impV.lvL("Z", "normal", "유대나"));
				minTPanel.add(impV.customText("(업적)", Color.red, 20));
				minTPanel.add(impV.lvL("Z", "normal", "오니를 포기"));
				minTPanel.add(impV.lvL("Z", "normal", "하는 결단력이 길러지는 오니다"));
			} else {
				minFPanel.add(impV.lvL("2", "normal", "2레벨 x 6"));
				minSPanel.add(impV.lvL("2", "normal", "2레벨"));
				minSPanel.add(impV.lvL("1", "normal", "2강화"));
				minTPanel.add(impV.lvL("Z", "normal", "만약 카나오가 없다면 임무를"));
				minTPanel.add(impV.lvL("Z", "normal", "소환하고 한바퀴 돌린 후에 잡는다."));
			}
			break;
		case "늪 오니 [E]":
			roundLabel.setText("20라운드부터 가능합니다");
			JPanel minFfPanel = new JPanel();
			JPanel minSsPanel = new JPanel();
			
			minFfPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			minFfPanel.setBackground(new Color(0, 0, 0, 0));
			minFfPanel.setBounds(5, 60, impV.window_width - 25, 30);
			
			minSsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			minSsPanel.setBackground(new Color(0, 0, 0, 0));
			minSsPanel.setBounds(3, 120, impV.window_width - 25, 30);
			minCutPanel.add(minFfPanel);
			minCutPanel.add(minSsPanel);
			
			minSPanel.setBounds(5, 90, impV.window_width - 25, 30);
			minTPanel.setBounds(5, 150, impV.window_width - 25, 40);
			namePanel.add(impV.customText("늪 오니", Color.white, 20));
			rankPanel.add(impV.customText("B", Color.red, 25));
			shieldPanel.add(impV.customText("50", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("88", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("22,000", Color.green, 20));
			
			minFPanel.add(impV.lvL("H", "normal", "H사콘지"));
			minFPanel.add(impV.lvL("1", "normal", " 또는 "));
			minFPanel.add(impV.lvL("H", "normal", "H지고로"));
			minFfPanel.add(impV.lvL("1", "normal", "히든이 안나올시: "));
			minFfPanel.add(impV.lvL("3", "normal", "3레벨 x 1"));
			minSPanel.add(impV.lvL("H", "normal", "H"));
			minSPanel.add(impV.lvL("1", "normal", "일시 전집중호흡 강화"));
			minSsPanel.add(impV.lvL("3", "normal", "                3"));
			minSsPanel.add(impV.lvL("1", "normal", "레벨 일시 "));
			minSsPanel.add(impV.lvL("3", "normal", "3레벨"));
			minSsPanel.add(impV.lvL("1", "normal", "5강화"));
			minTPanel.add(impV.lvL("Z", "normal", "Q, W, E 임무는 꼭 먹어야한다."));
			break;
		case "스사마루 [A]":
			roundLabel.setText("25라운드부터 가능합니다");
			namePanel.add(impV.customText("스사마루", Color.white, 20));
			rankPanel.add(impV.customText("A", Color.red, 25));
			shieldPanel.add(impV.customText("100", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("340", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("85,000", Color.green, 20));

			minFPanel.add(impV.lvL("H", "normal", "H x 1"));
			minFPanel.add(impV.lvL("1", "normal", " + "));
			minFPanel.add(impV.lvL("3", "normal", "3레벨 x 1"));
			minSPanel.add(impV.lvL("3", "normal", "3레벨"));
			minSPanel.add(impV.lvL("1", "normal", "최소 3강화 이상"));
			minTPanel.add(impV.lvL("Z", "normal", "25라운드를 기점으로 강화는"));
			minTPanel.add(impV.lvL("Z", "normal", "전집중호흡에만 투자 한다."));
			break;
		case "쿄우가이 [S]":
			roundLabel.setText("30라운드부터 가능합니다");
			namePanel.add(impV.customText("쿄우가이", Color.white, 20));
			rankPanel.add(impV.customText("S", Color.red, 25));
			shieldPanel.add(impV.customText("150", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("840", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("210,000", Color.green, 20));
			
			minFPanel.add(impV.lvL("X", "normal", "X"));
			minFPanel.add(impV.lvL("1", "normal", "또는"));
			minFPanel.add(impV.lvL("4", "normal", "4레벨"));
			minFPanel.add(impV.lvL("1", "normal", " x 1"));
			minFPanel.add(impV.lvL("1", "normal", "+"));
			minFPanel.add(impV.lvL("H", "normal", "H x 1"));
			minTPanel.add(impV.lvL("Z", "normal", "X탄지로, X무이치로, X미츠리"));
			minTPanel.add(impV.lvL("Z", "normal", "X기유는 정중앙에서 홀드 추천"));
			minSPanel.add(impV.lvL("4", "normal", "4레벨 카가야"));
			minSPanel.add(impV.lvL("1", "normal", "는 불가능"));
			break;
		case "루이 [D]":
			roundLabel.setText("45라운드부터 가능합니다");
			namePanel.add(impV.customText("루이", Color.white, 20));
			rankPanel.add(impV.customText("X", Color.red, 25));
			shieldPanel.add(impV.customText("255", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("6,000", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("8,000,000", Color.green, 20));
			
			minFPanel.add(impV.lvL("X", "normal", "X"));
			minFPanel.add(impV.lvL("1", "normal", " 또는"));
			minFPanel.add(impV.lvL("4", "normal", "4레벨"));
			minFPanel.add(impV.lvL("1", "normal", "합해서 x 3"));
			minTPanel.add(impV.lvL("Z", "normal", "X탄지로, X무이치로, X미츠리"));
			minTPanel.add(impV.lvL("Z", "normal", "X기유는 정중앙에서 홀드 추천"));
			minSPanel.add(impV.lvL("4", "normal", "4레벨 카가야"));
			minSPanel.add(impV.lvL("1", "normal", "는 히든 취급"));
			break;
			
		case "엔무 [Z]":
			roundLabel.setText("56라운드부터 가능합니다");
			namePanel.add(impV.customText("엔무", Color.white, 20));
			rankPanel.add(impV.customText("Z", Color.red, 25));
			shieldPanel.add(impV.customText("255", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("6,000", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("8,000,000", Color.green, 20));
			
			minFPanel.add(impV.lvL("X", "normal", "X"));
			minFPanel.add(impV.lvL("1", "normal", " 또는"));
			minFPanel.add(impV.lvL("4", "normal", "4레벨"));
			minFPanel.add(impV.lvL("1", "normal", "합해서 x 3"));
			minTPanel.add(impV.lvL("Z", "normal", "X탄지로, X무이치로, X미츠리"));
			minTPanel.add(impV.lvL("Z", "normal", "X기유는 정중앙에서 홀드 추천"));
			minSPanel.add(impV.lvL("4", "normal", "4레벨 카가야"));
			minSPanel.add(impV.lvL("1", "normal", "는 히든 취급"));
			break;
		}
		
		mainPanel.add(difficultyPanel);
		mainPanel.add(oniLabel);
		mainPanel.add(namePanel);
		mainPanel.add(rankPanel);
		mainPanel.add(shieldPanel);
		mainPanel.add(minCutPanel);
		mainPanel.add(backButton);
		add(mainPanel);
		
		//350, 600
		// 가로 세로 길이 지정 및 보이기
		setSize(impV.window_width, impV.window_height);
		setLocation(impV.screenSize.width - impV.window_width - 10, 50);
		setVisible(true);
	}
	
	protected JLabel makeImg(String name, String location) {
		int width = 160;
		int height = 160;
		
		if(name.equals("스사마루 [A]")) {
			width = 130;
			height = 130;
		}
		
		URL url = this.getClass().getClassLoader().getResource(location);
		ImageIcon icon = new ImageIcon(url), updateIcon;
		Image img = icon.getImage();
		Image updateImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		updateIcon = new ImageIcon(updateImg);
		
		JLabel imgLabel = new JLabel(updateIcon);

		imgLabel.setBackground(new Color(0, 0, 0, 0));	// 배경 투명
		imgLabel.setSize(width, height);				//width, height

		return imgLabel;
	}
}
