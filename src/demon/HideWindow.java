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
		impV.hideButton = hideButton;
		
		/*	���� ������	*/
		impV.FrameSetting(this);
		
		hideButton.setText("�����");									//����
		hideButton.setFont(new Font(impV.ttf, Font.PLAIN, 18));		//�۲�
		hideButton.setForeground(Color.green);						//���� ��
		hideButton.setBackground(impV.backColor); 					//���� ��ư ��
		hideButton.setBorder(new LineBorder(Color.red, 2, true));	//�׵θ�
		hideButton.setSize(btn_width, btn_height);					//ũ��
		hideButton.setFocusPainted(false); 							// ���� ���� �� ����� �׵θ� ���ֱ�
		
		/*	��ư ��� ����	*/
		hideButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isOn) {
					if(impV.sideContainer != null)
						impV.sideContainer.setVisible(false);
					impV.activeContainer.setVisible(false);
					isOn = false;
					hideButton.setText("���̱�");
				} else {
					if(impV.sideContainer != null)
						impV.sideContainer.setVisible(true);
					impV.activeContainer.setVisible(true);
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
		setLocation(impV.screenSize.width - impV.window_width - 10, impV.window_height + btn_height - 12);
		setVisible(true);
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(impV.backColor);
	}
}
