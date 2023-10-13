package demon_slayer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AchivementSideWindow extends JFrame implements Runnable {
	ImportentValue impV = new ImportentValue();

	private JPanel mainPanel, levelPanel, explainPanel, rewardPanel;
	private String imgUrl[] = {	"./images/Achive/under_lamp1.png",
								"./images/Achive/under_lamp2.png" };

	protected static Thread runningThread;
	private static int number;
	
	private final int under_size = 250;

	public AchivementSideWindow(int number) {
		this.number = number;
	}

	public void run() {
		if (runningThread != null) {
			try {
				runningThread.interrupt(); // 이미 실행된 스레드는 작동 취소
			} catch (Exception e) {
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
		rewardPanel = new JPanel();

		/* 사이드 패널 */
		setBackground(new Color(0, 0, 0, 0));
		mainPanel.setLayout(null);
		mainPanel.setBackground(impV.backColor); // 메인 패널 색
		mainPanel.setBorder(new LineBorder(Color.red, 2, true)); // 테두리
		mainPanel.setBounds(0, 0, impV.sideWindow_width, impV.sideWindow_height); // 위치 및 크기

		/* 레벨 패널 */
		levelPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout(중앙 배치)
		levelPanel.setBackground(new Color(0, 0, 0, 0)); // 배경색
		levelPanel.setBounds(0, 10, impV.sideWindow_width, impV.sideWindow_height - 50); // 크기

		/* 설명 패널 */
		explainPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout(중앙 배치)
		explainPanel.setBackground(new Color(0, 0, 0, 0)); // 배경색
		explainPanel.setBounds(0, 50, impV.sideWindow_width, impV.sideWindow_height - 50); // 크기

		/* 보상 패널 */
		Border bf = BorderFactory.createTitledBorder(new LineBorder(Color.red, 1), "보상", TitledBorder.LEFT, TitledBorder.TOP, impV.normalKostar, Color.white);
		rewardPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout(중앙 배치)
		rewardPanel.setBorder(bf);
		rewardPanel.setBackground(new Color(0, 0, 0, 0)); // 배경색
		rewardPanel.setBounds(10, 100, impV.sideWindow_width - 20, impV.sideWindow_height - 105); // 크기

		/* 레벨 패널 추가 */
		levelPanel.add(impV.lv1("Lv1 "));
		levelPanel.add(impV.lv2("Lv2 "));
		levelPanel.add(impV.lv3("Lv3 "));
		levelPanel.add(impV.lv4("Lv4 "));
		levelPanel.add(impV.lvH("LvH "));
		levelPanel.add(impV.lvX("LvX "));
		levelPanel.add(impV.lvZ("LvZ"));

		switch (number) {
		case 0:
			// 하급
			explainPanel.add(impV.lv1("ALL Lv1"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x1"));
			break;

		case 1:
			// 중급
			explainPanel.add(impV.lv2("ALL Lv2"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x2"));
			break;

		case 2:
			// 상급
			explainPanel.add(impV.lv3("ALL Lv3"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x3"));
			break;

		case 3:
			// 유대
			explainPanel.add(impV.lv1("탄지로x4 + 네즈코x4"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x1"));
			break;

		case 4:
			// 오니
			explainPanel.add(impV.lv1("유시로x5 + 네즈코x3"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x1"));
			break;

		case 5:
			// 나비
			explainPanel.add(impV.lv2("카나오x3"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv1("아오이x3"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x1"));
			break;

		case 6:
			// 사격
			explainPanel.add(impV.lv2("겐야x4"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("무라타x1"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x1"));
			break;

		case 7:
			// 형제
			explainPanel.add(impV.lv3("사네미x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("겐야x2"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x2"));
			break;

		case 8:
			// 사랑
			explainPanel.add(impV.lv3("미츠리x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv3("오바나이x1"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x2"));
			break;

		case 9:
			// 가문
			explainPanel.add(impV.lv4("카가야x1"));
			explainPanel.add(impV.lv1(" (첫 Lv4 조합에 등장시)"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x2"));
			break;

		case 10:
			// 적금1
			explainPanel.add(impV.lv4("미네랄 \" 15 \" 이상 수집"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x1"));
			break;

		case 11:
			// 적금2
			explainPanel.add(impV.lv1("Lv1 랜덤시민 \" 5 \" 이상 수집"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x1"));
			break;

		case 12:
			// 삼인방
			explainPanel.add(impV.lv2("젠이츠x3"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("이노스케x3"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv1("탄지로x2"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x2"));
			break;

		case 13:
			// 학살자
			explainPanel.add(impV.lv1("일반 오니 \" 60 \" 토벌 (팀 공유)"));
			rewardPanel.add(impV.lv4("미네랄x15"));
			break;

		case 14:
			// 학살자2
			explainPanel.add(impV.lv1("거미 오니 \" 45 \" 토벌 (팀 공유)"));
			rewardPanel.add(impV.lv4("미네랄x20"));
			break;

		case 15:
			// 귀살대
			explainPanel.add(impV.lv2("무라타x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv1("선배x4"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x1"));
			break;

		case 16:
			// 등잔밑 300 x 294
			ImageIcon under1_icon = new ImageIcon(imgUrl[0]), under1_updateIcon;
			Image under1_img = under1_icon.getImage();
			Image under1_updateImg = under1_img.getScaledInstance(300, 294, Image.SCALE_SMOOTH);
			under1_updateIcon = new ImageIcon(under1_updateImg);
			
			JLabel under1_imgLabel = new JLabel(under1_updateIcon);
			
			mainPanel.setBounds(0, 0, impV.sideWindow_width, impV.sideWindow_height + under_size); 					// 위치 및 크기
			explainPanel.setBounds(0, 50, impV.sideWindow_width, impV.sideWindow_height - 50 + under_size); 		// 위치 및 크기
			rewardPanel.setBounds(10, 100 + under_size, impV.sideWindow_width - 20, impV.sideWindow_height - 105); 	// 위치 및 크기
			under1_imgLabel.setBorder(new LineBorder(Color.red, 1));
			
			explainPanel.add(under1_imgLabel);
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x1"));
			break;

		case 17:
			// 등잔밑2 300 x 294
			ImageIcon under2_icon = new ImageIcon(imgUrl[1]), under2_updateIcon;
			Image under2_img = under2_icon.getImage();
			Image under2_updateImg = under2_img.getScaledInstance(300, 294, Image.SCALE_SMOOTH);
			under2_updateIcon = new ImageIcon(under2_updateImg);
			
			JLabel under2_imgLabel = new JLabel(under2_updateIcon);
			
			mainPanel.setBounds(0, 0, impV.sideWindow_width, impV.sideWindow_height + under_size); // 위치 및 크기
			explainPanel.setBounds(0, 50, impV.sideWindow_width, impV.sideWindow_height - 50 + under_size); // 크기
			rewardPanel.setBounds(10, 100 + under_size, impV.sideWindow_width - 20, impV.sideWindow_height - 105); // 크기
			under2_imgLabel.setBorder(new LineBorder(Color.red, 1));
			
			explainPanel.add(under2_imgLabel);
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x1"));
			break;

		case 18:
			// 이도류
			explainPanel.add(impV.lv3("텐겐x1"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("이노스케x2"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x2"));
			break;

		case 19:
			// 멍청이
			explainPanel.add(impV.lv1("임무 - [Q]불당오니 10번 (10라운드 전)"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x1"));
			break;

		case 20:
			// 최종선별
			explainPanel.add(impV.lv2("젠이츠x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("이노스케x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("카나오x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("겐야x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv1("탄지로x2"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x4"));
			break;

		case 21:
			// 삼총사
			explainPanel.add(impV.lvX("탄지로x1"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lvX("젠이츠x1"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lvX("이노스케x1"));
			rewardPanel.add(impV.lv1("Lv2 랜덤시민x1"));
			rewardPanel.add(impV.lvH("/"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x3"));
			break;

		case 22:
			// 청출어람
			explainPanel.add(impV.lvX("기유x1"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lvX("젠이츠x1"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lvH("사콘지x1"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lvH("지고로x1"));
			rewardPanel.add(impV.lv1("Lv2 랜덤시민x1"));
			rewardPanel.add(impV.lvH("/"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x3"));
			break;

		case 23:
			// 주합회의
			explainPanel.add(impV.lv4("All Lv4"));
			rewardPanel.add(impV.lv1("Lv3 랜덤시민x1"));
			rewardPanel.add(impV.lvH("/"));
			rewardPanel.add(impV.lv1("Lv2 랜덤시민x2"));
			break;

		case 24:
			// 퍼즐
			explainPanel.add(impV.lvH("All H"));
			rewardPanel.add(impV.lv1("Lv2 랜덤시민x2"));
			rewardPanel.add(impV.lvH("/"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x3"));
			break;

		case 25:
			// 대장장이
			explainPanel.add(impV.lvX("무이치로x1"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lvX("미츠리x1"));
			rewardPanel.add(impV.lv1("Lv2 랜덤시민x1"));
			rewardPanel.add(impV.lvH("/"));
			rewardPanel.add(impV.lv1("Lv1 랜덤시민x2"));
			break;

		case 26:
			// 악귀멸살
			explainPanel.add(impV.lvX("All LvX"));
			rewardPanel.add(impV.lv1("Lv3 랜덤시민x2"));
			rewardPanel.add(impV.lvH("/"));
			rewardPanel.add(impV.lv1("Lv2 랜덤시민x2"));
			rewardPanel.add(impV.lvX("미네랄x100"));
			break;

		case 27:
			// 레전드
			explainPanel.add(impV.lvZ("All LvZ"));
			rewardPanel.add(impV.lv1("Lv3 랜덤시민x2"));
			rewardPanel.add(impV.lvH("/"));
			rewardPanel.add(impV.lv1("Lv2 랜덤시민x3"));
			break;

		case 28:
			// 잠입
			explainPanel.add(impV.lvX("텐겐x1"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("젠이츠x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("이노스케x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv1("탄지로x2 + 네즈코x2"));
			rewardPanel.add(impV.lv1("Lv2 랜덤시민x1"));
			break;
		}

		mainPanel.add(levelPanel);
		mainPanel.add(explainPanel);
		mainPanel.add(rewardPanel);
		add(mainPanel);

		setAlwaysOnTop(true); 							// 항상 위에 보이기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 윈도우 종료시 javax도 종료

		// 가로 세로 길이 지정 및 보이기
		if(number == 16 || number == 17)
			setSize(impV.sideWindow_width, impV.sideWindow_height + under_size);
		else
			setSize(impV.sideWindow_width, impV.sideWindow_height);
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
}
