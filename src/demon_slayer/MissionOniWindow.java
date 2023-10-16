package demon_slayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MissionOniWindow extends JFrame {
	ImportentValue impV = new ImportentValue();
	
	private JPanel mainPanel, difficultyPanel, namePanel, rankPanel, shieldPanel, roundPanel, minCutPanel;
	private JLabel oniLabel, leftLabel, rightLabel, difficultyLabel;
	private JButton backButton;
	
	private Border bf;
	private final Color lineColor = Color.red;
	
	public MissionOniWindow(String difficulty, String name, String location, Color color) {
		impV.activeContainer = getRootPane().getContentPane();	//���� Ȱ��ȭ�� �����̳� ����
		
		mainPanel = new JPanel();
		difficultyPanel = new JPanel();
		namePanel = new JPanel();
		rankPanel = new JPanel();
		shieldPanel = new JPanel();
		roundPanel = new JPanel();
		minCutPanel = new JPanel();
		leftLabel = new JLabel();
		rightLabel = new JLabel();
		difficultyLabel = new JLabel();
		backButton = new JButton();
		
		setUndecorated(true);	// �׵θ� ����
		setResizable(false);	// ũ�� ���� ����
		
		setBackground(new Color(0, 0, 0, 0));

		/*	350, 600	*/
		/* ���� �г� 	*/
		mainPanel.setLayout(null); 											//���̾ƿ�
		mainPanel.setBackground(impV.backColor);							//����
		mainPanel.setBorder(new LineBorder(Color.red, 2, true));			//�׵θ�
		mainPanel.setBounds(0, 0, impV.window_width, impV.window_height);	//x, y, ����, ����
		
		/*	���̵� �г�	*/
		difficultyPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); //���̾ƿ�
		difficultyPanel.setBackground(new Color(0, 0, 0, 0));		//����
		difficultyPanel.setBounds(5, 5, 120, 40);					//x, y, ����, ����
		
		leftLabel.setText("[");
		leftLabel.setFont(impV.smallKostar);
		leftLabel.setForeground(Color.cyan);
		leftLabel.setSize(30, 40);
		
		if(difficulty == "�ϵ�") {
			difficultyLabel.setText("Hard");
			difficultyLabel.setForeground(Color.red);
		} else {
			difficultyLabel.setText("Normal");
			difficultyLabel.setForeground(Color.white);
		}
		difficultyLabel.setFont(impV.smallKostar);
		difficultyLabel.setSize(60, 40);
		
		rightLabel.setText("]");
		rightLabel.setFont(impV.smallKostar);
		rightLabel.setForeground(Color.cyan);
		rightLabel.setSize(30, 40);
		
		difficultyPanel.add(leftLabel);
		difficultyPanel.add(difficultyLabel);
		difficultyPanel.add(rightLabel);
		
		/*	���� ����	*/
		oniLabel = makeImg(name, location);
		if(name == "���縶�� [A]")
			oniLabel.setLocation((int)((350 - oniLabel.getWidth()) / 2), 40);
		else
			oniLabel.setLocation((int)((350 - oniLabel.getWidth()) / 2), 20);
		
		/*	�̸� �г�	*/
		bf = BorderFactory.createTitledBorder(new LineBorder(lineColor, 1), "������", TitledBorder.LEFT, TitledBorder.TOP, impV.normalKostar, Color.white);
		namePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		namePanel.setBackground(new Color(0, 0, 0, 0));
		namePanel.setBorder(bf);
		namePanel.setBounds(10, 180, impV.window_width - 90, 70);
		
		/*	��ũ �г�	*/
		bf = BorderFactory.createTitledBorder(new LineBorder(lineColor, 1), "��ũ", TitledBorder.CENTER, TitledBorder.TOP, impV.normalKostar, Color.red);
		rankPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		rankPanel.setBackground(new Color(0, 0, 0, 0));
		rankPanel.setBorder(bf);
		rankPanel.setBounds(impV.window_width - 80, 180, 70, 70);
		
		/*	���� �г�	*/
		bf = BorderFactory.createTitledBorder(new LineBorder(lineColor, 1), "���� / ���� / ü��", TitledBorder.LEFT, TitledBorder.TOP, impV.normalKostar, Color.white);
		shieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		shieldPanel.setBackground(new Color(0, 0, 0, 0));
		shieldPanel.setBorder(bf);
		shieldPanel.setBounds(10, 260, impV.window_width - 20, 70);
		
		/*	�ּ� �� �г�	*/
		bf = BorderFactory.createTitledBorder(new LineBorder(lineColor, 1), "�ּ� ��", TitledBorder.LEFT, TitledBorder.TOP, impV.normalKostar, Color.white);
		minCutPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		minCutPanel.setBackground(new Color(0, 0, 0, 0));
		minCutPanel.setBorder(bf);
		minCutPanel.setBounds(10, 340, impV.window_width - 20, 190);
		
		//���� ����
		/*	namePanel	/	rankPanel	/	shieldPanel	/	minCutPanel	*/
		/*	�̸�			/	��ũ			/	��,��, ü		/	�ּ� ��		*/
		switch(name) {
		case "�Ҵ� ���� [Q]":
			namePanel.add(impV.customText("�Ҵ� ����", Color.white, 20));
			rankPanel.add(impV.customText("D", Color.red, 25));
			shieldPanel.add(impV.customText("5", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("35", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("30,000", Color.green, 20));
			if(difficulty == "�븻") {
				
			} else {
				
			}
			break;
		case "�� ���� [W]":
			namePanel.add(impV.customText("�� ����", Color.white, 20));
			rankPanel.add(impV.customText("C", Color.red, 25));
			shieldPanel.add(impV.customText("30", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("300", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("87,000", Color.green, 20));
			if(difficulty == "�븻") {
				
			} else {
				
			}
			break;
		case "�� ���� [E]":
			namePanel.add(impV.customText("�� ����", Color.white, 20));
			rankPanel.add(impV.customText("B", Color.red, 25));
			shieldPanel.add(impV.customText("50", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("600", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("220,000", Color.green, 20));
			if(difficulty == "�븻") {
				
			} else {
				
			}
			break;
		case "���縶�� [A]":
			namePanel.add(impV.customText("���縶��", Color.white, 20));
			rankPanel.add(impV.customText("A", Color.red, 25));
			shieldPanel.add(impV.customText("100", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("2,500", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("900,000", Color.green, 20));
			if(difficulty == "�븻") {
				
			} else {
				
			}
			break;
		case "��찡�� [S]":
			namePanel.add(impV.customText("��찡��", Color.white, 20));
			rankPanel.add(impV.customText("S", Color.red, 25));
			shieldPanel.add(impV.customText("150", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("6,000", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("2,100,000", Color.green, 20));
			if(difficulty == "�븻") {
				
			} else {
				
			}
			break;
		case "���� [D]":
			namePanel.add(impV.customText("����", Color.white, 20));
			rankPanel.add(impV.customText("X", Color.red, 25));
			shieldPanel.add(impV.customText("255", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("55,000", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("8,000,000", Color.green, 20));
			if(difficulty == "�븻") {
				
			} else {
				
			}
			break;
		}
		
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
		
		mainPanel.add(difficultyPanel);
		mainPanel.add(oniLabel);
		mainPanel.add(namePanel);
		mainPanel.add(rankPanel);
		mainPanel.add(shieldPanel);
		mainPanel.add(minCutPanel);
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
		
		if(name == "���縶�� [A]" ) {
			width = 130;
			height = 130;
		}
		
		ImageIcon icon = new ImageIcon(location), updateIcon;
		Image img = icon.getImage();
		Image updateImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		updateIcon = new ImageIcon(updateImg);
		
		JLabel imgLabel = new JLabel(updateIcon);

		imgLabel.setBackground(new Color(0, 0, 0, 0));	// ��� ����
		imgLabel.setSize(width, height);				//width, height

		return imgLabel;
	}
}
