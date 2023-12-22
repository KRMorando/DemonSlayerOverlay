package demon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CombinationSelectWindow extends JFrame {
	private JPanel mainPanel, buttonPanel;
	private JLabel titleLabel, explainLabel;
	private JButton backButton;
	
	private int width = 100;
	private int height = 140;

	public CombinationSelectWindow(String id) {
		SystemManager.activeContainer = this;	//���� Ȱ��ȭ�� �����̳� ����

		mainPanel = new MainPanel();
		titleLabel = new JLabel();
		explainLabel = new JLabel();
		buttonPanel = new JPanel();
		backButton = new BackButton(this, "Combination");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
				repaint();
			}
		});

		/*	���� ������	*/
		SystemManager.FrameSetting(this);
		
		/* Ÿ��Ʋ ��	*/
		titleLabel.setFont(SystemManager.titleTTF);				// ��Ʈ
		titleLabel.setBackground(new Color(0, 0, 0, 0));	// ����
		titleLabel.setHorizontalAlignment(JLabel.CENTER);	// �߾� ����
		titleLabel.setBounds(0, 0, SystemManager.window_width, 100); // x, y, width, height
		
		/*	���� ��	*/
		explainLabel.setText("���ϴ� ĳ���͸� �����ּ���.");
		explainLabel.setFont(SystemManager.smallTTF);				// ��Ʈ
		explainLabel.setForeground(Color.green);					// ����
		explainLabel.setBackground(new Color(0, 0, 0, 0));		// ����
		explainLabel.setHorizontalAlignment(JLabel.CENTER);		// �߾� ����
		explainLabel.setBounds(0, 80, SystemManager.window_width, 30);	// x, y, width, height
		
		/* ��ư �г� 	*/
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(new Color(0, 0, 0, 0));
		buttonPanel.setBounds(0, 100, SystemManager.window_width, SystemManager.window_height - 140);
		
		/* 350, 600	*/

		/* makeCard(���, �̸�, ���� ���) */
		/* H / EH / X / Z / SZ ���� */
		
		switch (id) {
		case "H": 
			titleLabel.setText("H");
			titleLabel.setForeground(SystemManager.HColor);
			
			CustomLayout(makeCard("H", "������", SystemManager.HLocation[0]), 0, 0);
			CustomLayout(makeCard("H", "�����", SystemManager.HLocation[1]), 1, 0);
			CustomLayout(makeCard("H", "Ÿ����", SystemManager.HLocation[2]), 2, 0);
			CustomLayout(makeCard("H", "ī����", SystemManager.HLocation[3]), 0, 1);
			CustomLayout(makeCard("H", "���ڸ�", SystemManager.HLocation[4]), 1, 1);
			CustomLayout(makeCard("H", "�����", SystemManager.HLocation[5]), 2, 1);
			break;
			
		case "EH":
			titleLabel.setText("EH");
			titleLabel.setForeground(SystemManager.EHColor);
			
			CustomLayout(makeCard("EH", "ȣŸ��", SystemManager.EHLocation[0]), 1, 0);
			break;
			
		case "X":
			titleLabel.setText("X");
			titleLabel.setForeground(SystemManager.XColor);
			
			CustomLayout(makeCard("X", "ź����", SystemManager.XLocation[0]), 0, 0);
			CustomLayout(makeCard("X", "�̳뽺��", SystemManager.XLocation[1]), 1, 0);
			CustomLayout(makeCard("X", "������", SystemManager.XLocation[2]), 2, 0);
			CustomLayout(makeCard("X", "����", SystemManager.XLocation[3]), 0, 1);
			CustomLayout(makeCard("X", "�ٰ�", SystemManager.XLocation[4]), 1, 1);
			CustomLayout(makeCard("X", "������", SystemManager.XLocation[5]), 2, 1);
			CustomLayout(makeCard("X", "����ġ��", SystemManager.XLocation[6]), 0, 2);
			CustomLayout(makeCard("X", "�վ�", SystemManager.XLocation[7]), 1, 2);
			break;
		  
		case "Z": 
			titleLabel.setText("Z");
			titleLabel.setForeground(SystemManager.ZColor);
			Component Zcard = makeCard("Z", "ī����", SystemManager.ZLocation[0]);
			Zcard.setLocation((SystemManager.window_width - width) / 2, 5);
			buttonPanel.add(Zcard);
			CustomLayout(makeCard("Z", "������", SystemManager.ZLocation[1]), 0, 1);
			CustomLayout(makeCard("Z", "�����", SystemManager.ZLocation[2]), 1, 1);
			break;
			
		case "SZ": 
			titleLabel.setText("SZ");
			titleLabel.setForeground(SystemManager.SZColor);
			
			Component SZcard = makeCard("SZ", "ī���� ź����", SystemManager.SZLocation[0]);
			SZcard.setLocation((SystemManager.window_width - width) / 2, (SystemManager.window_height - height) / 4);
			buttonPanel.add(SZcard);
			break;
		}

		mainPanel.add(titleLabel);
		mainPanel.add(explainLabel);
		mainPanel.add(buttonPanel);
		mainPanel.add(backButton);
		add(mainPanel);

		// ���� ���� ���� ���� �� ���̱�
		setSize(SystemManager.window_width, SystemManager.window_height);
		setLocation(SystemManager.screenSize.width - SystemManager.window_width - 10, 50);
		setVisible(true);
	}

	protected Component makeCard(String rank, String name, String location) {
		boolean isLegend = false;
		
		if(name.equals("ī���� ź����") || name.equals("ī����") || name.equals("�����") || name.equals("������")) {
			width = 150;
			height = 190;
			isLegend = true;
		}
		
		URL url = this.getClass().getClassLoader().getResource(location);
		ImageIcon icon = new ImageIcon(url), updateIcon;
		Image img = icon.getImage(), updateImg;
		if(isLegend)
			updateImg = img.getScaledInstance(width, height - 25, Image.SCALE_SMOOTH);
		else
			updateImg = img.getScaledInstance(width, height - 20, Image.SCALE_SMOOTH);
		updateIcon = new ImageIcon(updateImg);
		
		JPanel cardPanel = new JPanel();
		JLabel imgLabel = new JLabel(updateIcon);
		JLabel imgText = new JLabel();
		JButton mainButton = new JButton();
		
		cardPanel.setLayout(null);
		cardPanel.setBackground(new Color(0, 0, 0, 0));		//��� ����
		cardPanel.setSize(width, height);					//width, height

		imgLabel.setText("");
		imgLabel.setBackground(new Color(0, 0, 0, 0));		// ��� ����
		imgLabel.setBounds(0, 0, width, height - 25); 		// x, y, width, height

		imgText.setText(name); 								// ��ư �̸�
		imgText.setBackground(new Color(0, 0, 0, 0));		// ����
		imgText.setFont(SystemManager.normalTTF); 			// ��Ʈ
		imgText.setHorizontalAlignment(JLabel.CENTER);
		imgText.setVerticalAlignment(JLabel.CENTER);
		imgText.setBounds(0, height - 25, width, 25);		// x, y, width, height
		if(rank.equals("H"))
			imgText.setForeground(SystemManager.HColor);	// �۾� ����
		else if(rank.equals("EH"))
			imgText.setForeground(SystemManager.EHColor); 	// �۾� ����
		else if(rank.equals("X"))
			imgText.setForeground(SystemManager.XColor);	// �۾� ����
		else if(rank.equals("Z"))
			imgText.setForeground(SystemManager.ZColor);	// �۾� ����
		else
			imgText.setForeground(SystemManager.SZColor); 	// �۾� ����
		
		mainButton.setText("");
		mainButton.setBackground(new Color(0, 0, 0, 0));	//��� ��
		mainButton.setBorderPainted(false); 				//�׵θ� ����
		mainButton.setFocusPainted(false); 					//���� ���� �� ����� �׵θ� ���ֱ�
		mainButton.setBounds(0, 0, width, height);
		mainButton.addActionListener(new ActionListener() { //��ư ���
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread sideWindow = new Thread(new CombinationSideWindow(name));
				repaint();
				sideWindow.start();
			}
		});
		
		/*	��ư ���콺 �ν�	*/
		mainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
				repaint();
			}
		});
		
		cardPanel.add(imgLabel);
		cardPanel.add(imgText);
		cardPanel.add(mainButton);
		
		return cardPanel;
	}
	
	protected void CustomLayout(Component c, int sequence, int floor) {
		c.setLocation((12 * (1 + sequence)) + (width * sequence), (5 * (1 + floor)) + (height * floor));
		//				���� ���					�ڽ� ���		x / y
		buttonPanel.add(c);
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(new Color(0, 0, 0, 0));
	}
}
