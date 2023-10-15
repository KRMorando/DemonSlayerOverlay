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
		impV.activeContainer = getRootPane().getContentPane();	//���� Ȱ��ȭ�� �����̳� ����
		
		mainPanel = new JPanel();
		titleLabel = new JLabel();
		backButton = new JButton();
		
		setUndecorated(true);	// �׵θ� ����
		setResizable(false);	// ũ�� ���� ����
		
		setBackground(new Color(0, 0, 0, 0));

		/* ���� �г� 	*/
		mainPanel.setLayout(null); 											//���̾ƿ�
		mainPanel.setBackground(impV.backColor);							//����
		mainPanel.setBorder(new LineBorder(Color.red, 2, true));			//�׵θ�
		mainPanel.setBounds(0, 0, impV.window_width, impV.window_height);	//x, y, ����, ����
		
		/* Ÿ��Ʋ ��	*/
		titleLabel.setText(name);							// ����
		titleLabel.setFont(impV.titleKostar);				// ��Ʈ
		titleLabel.setForeground(color);					// ����
		titleLabel.setBackground(new Color(0, 0, 0, 0));	// ����
		titleLabel.setHorizontalAlignment(JLabel.CENTER);	// �߾� ����
		titleLabel.setBounds(0, 0, impV.window_width, 100); // x, y, width, height
		
		/*	���� ����	*/
		oniLabel = makeImg(name, location);
		oniLabel.setLocation((int)((350 - oniLabel.getWidth()) / 2), 100);
		
		/* �ڷΰ��� ��ư */
		backButton.setText("�ڷΰ���");							// �۾� ����
		backButton.setFont(new Font("Kostar", Font.PLAIN, 18));	// ��Ʈ ����
		backButton.setBackground(new Color(0, 0, 0, 0));		// ����
		backButton.setForeground(Color.GREEN);					// �۾���
		backButton.setFocusPainted(false);						// ���� ���� �� ����� �׵θ� ���ֱ�
		backButton.setPreferredSize(new Dimension(200, 30));	//ũ�� ����
		backButton.setBorder(BorderFactory.createLineBorder(Color.RED, 1, true));	// �׵θ�
		backButton.setBounds(80, impV.window_height - 55, 200, 30);

		/* �ڷΰ��� ��ư ��� ���� */
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MissionSelectWindow(difficulty);
				setVisible(false);
			}
		});
		
		/*	��ư ���콺 �ν�	*/
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
				repaint();
			}
		});
		
		mainPanel.add(titleLabel);
		mainPanel.add(oniLabel);
		mainPanel.add(backButton);
		add(mainPanel);
		
		setAlwaysOnTop(true); // �׻� ���� ���̱�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ ����� javax�� ����

		//350, 600
		// ���� ���� ���� ���� �� ���̱�
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
		imgLabel.setBackground(new Color(0, 0, 0, 0));	// ��� ����
		imgLabel.setSize(width, height);				//width, height

		return imgLabel;
	}
}
