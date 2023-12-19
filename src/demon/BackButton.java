package demon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BackButton extends JButton {
	int width = 190;
	int height = 30;
	
	public BackButton(JFrame frame, String window) {
		/*	뒤로가기 상세 설정	*/
		setText("뒤로가기"); 												// 글씨 적용
		setFont(new Font(impV.ttf, Font.PLAIN, 18)); 					// 폰트 적용
		setBackground(new Color(0, 0, 0, 0)); 							// 배경색
		setForeground(Color.GREEN); 									// 글씨색
		setFocusPainted(false);											// 선택 됐을 때 생기는 테두리 없애기
		setBorder(BorderFactory.createLineBorder(Color.RED, 1, true));	// 테두리
		setBounds((impV.window_width - width)/2, impV.window_height - height - 25, width, height);

		/* 뒤로가기 버튼 기능 구현 */
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(impV.sideContainer != null) {
					impV.sideContainer.dispose();
					impV.sideContainer = null;
				}
				switch(window) {
				case "Main":
					new MainWindow();
					break;
					
				case "Combination":
					new CombinationWindow();
					break;
					
				case "Mission":
					new MissionWindow();
					break;
					
				case "노말":
					new MissionSelectWindow(window);
					break;
					
				case "하드":
					new MissionSelectWindow(window);
					break;
					
				default:
					new MainWindow();
					break;
				}
				frame.dispose();
			}
		});
	}
}