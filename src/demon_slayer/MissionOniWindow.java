package demon_slayer;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.border.LineBorder;

public class MissionOniWindow extends JFrame {
	ImportentValue impV = new ImportentValue();
	
	private JPanel mainPanel;
	private JLabel titleLabel, oniLabel;
	private JButton backButton;
	
	public MissionOniWindow(String difficulty, String name, String location, Color color) {
		impV.activeContainer = getRootPane().getContentPane();	//현재 활성화된 컨테이너 저장
		
		mainPanel = new JPanel();
		titleLabel = new JLabel();
		backButton = new JButton();
		
		setUndecorated(true);	// 테두리 삭제
		setResizable(false);	// 크기 조절 여부
		
		setBackground(new Color(0, 0, 0, 0));

		/* 메인 패널 	*/
		mainPanel.setLayout(null); 											//레이아웃
		mainPanel.setBackground(impV.backColor);							//배경색
		mainPanel.setBorder(new LineBorder(Color.red, 2, true));			//테두리
		mainPanel.setBounds(0, 0, impV.window_width, impV.window_height);	//x, y, 가로, 세로
		
		/* 타이틀 라벨	*/
		titleLabel.setText(name);							// 글자
		titleLabel.setFont(impV.titleKostar);				// 폰트
		titleLabel.setForeground(color);					// 색상
		titleLabel.setBackground(new Color(0, 0, 0, 0));	// 배경색
		titleLabel.setHorizontalAlignment(JLabel.CENTER);	// 중앙 정렬
		titleLabel.setBounds(0, 0, impV.window_width, 100); // x, y, width, height
		
		/*	오니 사진	*/
		oniLabel = makeImg(name, location);
		oniLabel.setLocation((int)((350 - oniLabel.getWidth()) / 2), 100);
		
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
		
		mainPanel.add(titleLabel);
		mainPanel.add(oniLabel);
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
		
		ImageIcon icon = new ImageIcon(location), updateIcon;
		Image img = icon.getImage();
		Image updateImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		updateIcon = new ImageIcon(updateImg);
		
		JLabel imgLabel = new JLabel(updateIcon);

		imgLabel.setText("");
		imgLabel.setBackground(new Color(0, 0, 0, 0));	// 배경 투명
		imgLabel.setSize(width, height);				//width, height

		return imgLabel;
	}
}
