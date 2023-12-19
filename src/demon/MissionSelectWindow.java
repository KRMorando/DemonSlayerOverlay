package demon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MissionSelectWindow extends JFrame {
	ImportentValue impV = new ImportentValue();
	
	private JPanel mainPanel, buttonPanel;
	private JLabel titleLabel;
	private JButton backButton;
	private ArrayList<OniInfo> oniInfoArray = new ArrayList<>();
	
	private String difficulty;
	private String OLocation[] = {	"Oni/D.png",
									"Oni/C.png",
									"Oni/B.png",
									"Oni/A.png",
									"Oni/S.png",
									"Oni/X.png",
									"Oni/Z.png"};
	
	public MissionSelectWindow(String difficulty) {
		impV.activeContainer = this;	//���� Ȱ��ȭ�� �����̳� ����
		
		this.difficulty = difficulty;
		
		mainPanel = new MainPanel();
		titleLabel = new JLabel();
		buttonPanel = new JPanel();
		backButton = new BackButton(this, "Mission");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
				repaint();
			}
		});

		/*	���� ������	*/
		impV.FrameSetting(this);
		
		/* Ÿ��Ʋ ��	*/
		titleLabel.setText(difficulty);						// ����
		titleLabel.setFont(impV.titleTTF);				// ��Ʈ
		titleLabel.setBackground(new Color(0, 0, 0, 0));	// ����
		titleLabel.setHorizontalAlignment(JLabel.CENTER);	// �߾� ����
		titleLabel.setBounds(0, 0, impV.window_width, 100); // x, y, width, height
		
		/* ��ư �г� 	*/
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(new Color(0, 0, 0, 0));
		buttonPanel.setBounds(0, 100, impV.window_width, impV.window_height - 140);
		
		/* 350, 600	*/
		/* makeCard(���, �̸�, ���� ���) */
		
		if(difficulty.equals("�븻"))
			titleLabel.setForeground(Color.white);	// �븻 (�Ͼ��)
		else 
			titleLabel.setForeground(Color.red);	// �ϵ� (������)
		
		CustomLayout(makeCard("D", "�Ҵ� ���� [Q]", OLocation[0]), 0, 0);
		CustomLayout(makeCard("C", "�� ���� [W]", OLocation[1]), 1, 0);
		CustomLayout(makeCard("B", "�� ���� [E]", OLocation[2]), 2, 0);
		CustomLayout(makeCard("A", "���縶�� [A]", OLocation[3]), 0, 1);
		CustomLayout(makeCard("S", "��찡�� [S]", OLocation[4]), 1, 1);
		CustomLayout(makeCard("X", "���� [D]", OLocation[5]), 2, 1);
		CustomLayout(makeCard("Z", "���� [Z]", OLocation[6]), 0, 2);

		/*	===============================================
			============	��ư ��� �밡��	===============
			===============================================	*/
		
		/*======================0��°======================*/
		/* ��ư ��� �߰�	*/
		oniInfoArray.get(0).button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MissionOniWindow(difficulty, oniInfoArray.get(0).name, oniInfoArray.get(0).location, oniInfoArray.get(0).color);
				dispose();
			}
		});
		/*	��ư ���콺 �ν�	*/
		oniInfoArray.get(0).button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
				repaint();
			}
		});
		/*======================1��°======================*/
		/* ��ư ��� �߰�	*/
		oniInfoArray.get(1).button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MissionOniWindow(difficulty, oniInfoArray.get(1).name, oniInfoArray.get(1).location, oniInfoArray.get(1).color);
				dispose();
			}
		});
		/*	��ư ���콺 �ν�	*/
		oniInfoArray.get(1).button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
				repaint();
			}
		});
		/*======================2��°======================*/
		/* ��ư ��� �߰�	*/
		oniInfoArray.get(2).button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MissionOniWindow(difficulty, oniInfoArray.get(2).name, oniInfoArray.get(2).location, oniInfoArray.get(2).color);
				dispose();
			}
		});
		/*	��ư ���콺 �ν�	*/
		oniInfoArray.get(2).button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
				repaint();
			}
		});
		/*======================3��°======================*/
		/* ��ư ��� �߰�	*/
		oniInfoArray.get(3).button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MissionOniWindow(difficulty, oniInfoArray.get(3).name, oniInfoArray.get(3).location, oniInfoArray.get(3).color);
				dispose();
			}
		});
		/*	��ư ���콺 �ν�	*/
		oniInfoArray.get(3).button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
				repaint();
			}
		});
		/*======================4��°======================*/
		/* ��ư ��� �߰�	*/
		oniInfoArray.get(4).button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MissionOniWindow(difficulty, oniInfoArray.get(4).name, oniInfoArray.get(4).location, oniInfoArray.get(4).color);
				dispose();
			}
		});
		/*	��ư ���콺 �ν�	*/
		oniInfoArray.get(4).button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
				repaint();
			}
		});
		/*======================5��°======================*/
		/* ��ư ��� �߰�	*/
		oniInfoArray.get(5).button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MissionOniWindow(difficulty, oniInfoArray.get(5).name, oniInfoArray.get(5).location, oniInfoArray.get(5).color);
				dispose();
			}
		});
		/*	��ư ���콺 �ν�	*/
		oniInfoArray.get(5).button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
				repaint();
			}
		});
		/*======================6��°======================*/
		/* ��ư ��� �߰�	*/
		oniInfoArray.get(6).button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MissionOniWindow(difficulty, oniInfoArray.get(6).name, oniInfoArray.get(6).location, oniInfoArray.get(6).color);
				dispose();
			}
		});
		/*	��ư ���콺 �ν�	*/
		oniInfoArray.get(6).button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
				repaint();
			}
		});
		/*	===============================================
			============	��ư ��� �밡�� ��	===============
			===============================================	*/
		
		mainPanel.add(titleLabel);
		mainPanel.add(buttonPanel);
		mainPanel.add(backButton);
		add(mainPanel);

		// ���� ���� ���� ���� �� ���̱�
		setSize(impV.window_width, impV.window_height);
		setLocation(impV.screenSize.width - impV.window_width - 10, 50);
		setVisible(true);
	}
	
	protected Component makeCard(String rank, String name, String location) {
		int width = 100;
		int height = 140;
		
		URL url = this.getClass().getClassLoader().getResource(location);
		ImageIcon icon = new ImageIcon(url), updateIcon;
		Image img = icon.getImage(), updateImg;
		if(rank.equals("A"))
			updateImg = img.getScaledInstance(width - 20, height - 45, Image.SCALE_SMOOTH);
		else
			updateImg = img.getScaledInstance(width, height - 15, Image.SCALE_SMOOTH);
		
		updateIcon = new ImageIcon(updateImg);
		
		JPanel cardPanel = new JPanel();
		JLabel imgLabel = new JLabel(updateIcon);
		JLabel imgText = new JLabel();
		JButton mainButton = new JButton();
		
		cardPanel.setLayout(null);
		cardPanel.setBackground(new Color(0, 0, 0, 0));	//��� ����
		cardPanel.setSize(width, height);					//width, height

		imgLabel.setBackground(new Color(0, 0, 0, 0));		// ��� ����
		if(rank.equals("A"))
			imgLabel.setBounds(10, 15, width - 20, height - 45); 		// x, y, width, height
		else
			imgLabel.setBounds(0, 0, width, height - 15); 		// x, y, width, height

		imgText.setText(name); 								// ��ư �̸�
		imgText.setBackground(new Color(0, 0, 0, 0));		// ����
		imgText.setFont(new Font(impV.ttf, Font.PLAIN, 18));// ��Ʈ
		imgText.setHorizontalAlignment(JLabel.CENTER);
		imgText.setVerticalAlignment(JLabel.CENTER);
		imgText.setBounds(0, height - 25, width, 25);		// x, y, width, height
		if(rank.equals("D"))
			imgText.setForeground(Color.white);	// �۾� ����
		else if(rank.equals("C"))
			imgText.setForeground(new Color(50, 150, 255));	// �۾� ����
		else if(rank.equals("B"))
			imgText.setForeground(Color.green);	// �۾� ����
		else if(rank.equals("A"))
			imgText.setForeground(Color.orange);// �۾� ����
		else if(rank.equals("S"))
			imgText.setForeground(Color.cyan);// �۾� ����
		else
			imgText.setForeground(Color.red);	// �۾� ����
		
		mainButton.setText("");
		mainButton.setBackground(new Color(0, 0, 0, 0));	//��� ��
		mainButton.setBorderPainted(false); 				//�׵θ� ����
		mainButton.setFocusPainted(false); 					//���� ���� �� ����� �׵θ� ���ֱ�
		mainButton.setBounds(0, 0, width, height);
		oniInfoArray.add(new OniInfo(mainButton, rank, name, location, imgText.getForeground()));
		
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
		c.setLocation((12 * (1 + sequence)) + (100 * sequence), (5 * (1 + floor)) + (140 * floor));
		//				���� ���					�ڽ� ���		x / y
		buttonPanel.add(c);
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(new Color(0, 0, 0, 0));
	}
}
