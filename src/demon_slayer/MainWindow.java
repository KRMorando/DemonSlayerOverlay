package demon_slayer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainWindow extends JFrame {
	ImportentValue impV = new ImportentValue();

	private GridBagLayout gbl;
	private JPanel mainPanel;
	private JLabel madeLabel;

	public MainWindow() {
		impV.activeContainer = getRootPane().getContentPane();	//현재 활성화된 컨테이너 저장
		
		setUndecorated(true); // 테두리 삭제
		setResizable(false); // 크기 조절 여부

		JButton[] btn = new JButton[6];
		String[] buttonName = { "업적", "조합", "임무", "카페", "설정", "종료" };

		gbl = new GridBagLayout();
		mainPanel = new JPanel();

		setBackground(new Color(0, 0, 0, 0)); // 컨테이너 공백
		mainPanel.setLayout(gbl);
		mainPanel.setBackground(impV.backColor); // 메인 패널 색
		mainPanel.setBorder(new LineBorder(Color.red, 2, true));

		// 버튼 생성 및 추가
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton();

			/* 전체 적용 */
			btn[i].setText(buttonName[i]); // 글씨 적용
			btn[i].setFont(impV.normalKostar); // 폰트 적용
			btn[i].setForeground(Color.GREEN); // 글씨 색상 적용
			btn[i].setBackground(new Color(0, 0, 0));
			btn[i].setBorder(BorderFactory.createLineBorder(Color.RED, 1, true)); // 테두리 설정
			btn[i].setPreferredSize(new Dimension(200, 40)); // 크기 설정
			btn[i].setFocusPainted(false); // 선택 됐을 때 생기는 테두리 없애기

			/* 버튼 삽입 */
			Insert(gbl, mainPanel, btn[i], 1, i, 2, 1);

			/* 업적 버튼(0) */
			switch (i) {
			case 0:
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new AchivementWindow();
						setVisible(false);
					}
				});
				break;

			/* 조합 버튼(1) */
			case 1:
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new CombinationWindow();
						setVisible(false);
					}
				});
				break;

			/* 임무 버튼(2) */
			case 2:
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new MissionWindow();
						setVisible(false);
					}
				});
				break;

			/* 카페 버튼(3) */
			case 3:
				// 프로그램 종료 버튼
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Desktop desktop = Desktop.getDesktop();
						try {
							URI uri = new URI("https://cafe.naver.com/feer95");
							desktop.browse(uri);
						} catch (IOException ex) {
							ex.printStackTrace();
						} catch (URISyntaxException ex) {
							ex.printStackTrace();
						}
					}
				});
				break;

			/* 설정 버튼(4) */
			case 4:
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new SettingWindow();
						setVisible(false);
					}
				});
				break;

			/* 종료 버튼(5) */
			case 5:
				// 프로그램 종료 버튼
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				break;
			}
		}

		madeLabel = new JLabel();
		madeLabel.setText("Made by Morando");
		madeLabel.setFont(new Font("Kostar", Font.ITALIC, 15));
		madeLabel.setForeground(Color.GREEN);
		Insert(gbl, mainPanel, madeLabel, 1, 6, 2, 1);

		add(mainPanel);

		setAlwaysOnTop(true); // 항상 위에 보이기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우 종료시 javax도 종료

		setSize(impV.window_width, impV.window_height);
		setLocation(impV.screenSize.width - impV.window_width - 10, 50);
		setVisible(true);
	}
	
	//Insert (그리드백, 패널, 컴포넌트, x, y, 좌우, 높낮이);
	public void Insert(GridBagLayout gbl, JPanel panel, Component c, int x, int y, int w, int h) {
		GridBagConstraints gblc = new GridBagConstraints();
		
		gblc.fill = GridBagConstraints.VERTICAL;
		gblc.gridx = x;
		gblc.gridy = y;
		gblc.gridwidth = w;
		gblc.gridheight = h;
		gblc.insets = new Insets(40, 0, 0, 0);
		gbl.setConstraints(c, gblc);
		panel.add(c);
	}
}