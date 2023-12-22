package demon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

public class HideWindow extends JFrame {
	private JButton hideButton;
	private final int btn_width = 60, btn_height = 60;
	private boolean isOn = true;
	
	public HideWindow() {
		
		hideButton = new JButton();
		//���� �����̳� ��ü�� ���̵� ��ư���� ���
		SystemManager.hideButton = hideButton;
		
		/*	���� ������	*/
		SystemManager.FrameSetting(this);
		
		hideButton.setText("�����");									//����
		hideButton.setFont(new Font(SystemManager.ttf, Font.PLAIN, 18));		//�۲�
		hideButton.setForeground(Color.green);						//���� ��
		hideButton.setBackground(SystemManager.backColor); 					//���� ��ư ��
		hideButton.setBorder(new LineBorder(Color.red, 2, true));	//�׵θ�
		hideButton.setSize(btn_width, btn_height);					//ũ��
		hideButton.setFocusPainted(false); 							// ���� ���� �� ����� �׵θ� ���ֱ�
		
		/*	��ư ��� ����	*/
		hideButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isOn) {
					if(SystemManager.sideContainer != null)
						SystemManager.sideContainer.setVisible(false);
					SystemManager.activeContainer.setVisible(false);
					isOn = false;
					hideButton.setText("���̱�");
				} else {
					if(SystemManager.sideContainer != null)
						SystemManager.sideContainer.setVisible(true);
					SystemManager.activeContainer.setVisible(true);
					isOn = true;
					hideButton.setText("�����");
				}
				repaint();
			}
		});
		
		/*	��ư ���콺 �ν�	*/
		hideButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	//���콺�� ������ ����
				repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
				repaint();
			}
		});
		
		hideButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		
		add(hideButton);

		setSize(btn_width, btn_height);
		setLocation(SystemManager.screenSize.width - SystemManager.window_width - 10, SystemManager.window_height + btn_height - 12);
		setVisible(true);
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(SystemManager.backColor);
	}
}
