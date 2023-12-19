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
		/*	�ڷΰ��� �� ����	*/
		setText("�ڷΰ���"); 												// �۾� ����
		setFont(new Font(impV.ttf, Font.PLAIN, 18)); 					// ��Ʈ ����
		setBackground(new Color(0, 0, 0, 0)); 							// ����
		setForeground(Color.GREEN); 									// �۾���
		setFocusPainted(false);											// ���� ���� �� ����� �׵θ� ���ֱ�
		setBorder(BorderFactory.createLineBorder(Color.RED, 1, true));	// �׵θ�
		setBounds((impV.window_width - width)/2, impV.window_height - height - 25, width, height);

		/* �ڷΰ��� ��ư ��� ���� */
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
					
				case "�븻":
					new MissionSelectWindow(window);
					break;
					
				case "�ϵ�":
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