package demon;

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
	
	private JPanel mainPanel, difficultyPanel, namePanel, rankPanel, shieldPanel, minCutPanel, minFPanel, minSPanel, minTPanel;
	private JLabel oniLabel, roundLabel, leftLabel, rightLabel, difficultyLabel;
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
		minCutPanel = new JPanel();
		minFPanel = new JPanel();
		minSPanel = new JPanel();
		minTPanel = new JPanel();
		
		roundLabel = new JLabel();
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
		difficultyPanel.setBounds(5, 5, impV.window_width - 5, 40);					//x, y, ����, ����
		
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
		
		/*	���� ��	*/
		roundLabel.setBackground(new Color(0, 0, 0, 0));
		roundLabel.setForeground(Color.red);
		roundLabel.setFont(impV.smallKostar);
		
		difficultyPanel.add(leftLabel);
		difficultyPanel.add(difficultyLabel);
		difficultyPanel.add(rightLabel);
		difficultyPanel.add(roundLabel);
		
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
		
		/*	�ӹ� ���� �г�	*/
		bf = BorderFactory.createTitledBorder(new LineBorder(lineColor, 1), "�ӹ� ����", TitledBorder.LEFT, TitledBorder.TOP, impV.normalKostar, Color.white);
		minCutPanel.setLayout(null);
		minCutPanel.setBackground(new Color(0, 0, 0, 0));
		minCutPanel.setBorder(bf);
		minCutPanel.setBounds(10, 340, impV.window_width - 20, 190);
		
		minFPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		minFPanel.setBackground(new Color(0, 0, 0, 0));
		minFPanel.setBounds(5, 30, impV.window_width - 25, 30);
		minFPanel.add(impV.lv1("���� ����: "));
		minSPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		minSPanel.setBackground(new Color(0, 0, 0, 0));
		minSPanel.setBounds(5, 60, impV.window_width - 25, 30);
		minTPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		minTPanel.setBackground(new Color(0, 0, 0, 0));
		minTPanel.setBounds(5, 120, impV.window_width - 25, 70);
		if(name != "��찡�� [S]" && name != "���� [D]")
			minSPanel.add(impV.lv1("��ȭ ��ġ: "));
		else {
			minSPanel.add(impV.customText("����!", Color.red, 20));
			minSPanel.setBounds(5, 150, impV.window_width - 25, 30);
			minTPanel.setBounds(5, 90, impV.window_width - 25, 70);
		}
		minTPanel.add(impV.lvZ("Tip: "));
		minCutPanel.add(minFPanel);
		minCutPanel.add(minSPanel);
		minCutPanel.add(minTPanel);
		
		
		//���� ����
		/*	namePanel	/	rankPanel	/	shieldPanel	/	minCutPanel	*/
		/*	�̸�			/	��ũ			/	��,��, ü		/	�ּ� ��		*/
		switch(name) {
		case "�Ҵ� ���� [Q]":
			roundLabel.setText("10������� �����մϴ�");
			namePanel.add(impV.customText("�Ҵ� ����", Color.white, 20));
			rankPanel.add(impV.customText("D", Color.red, 25));
			shieldPanel.add(impV.customText("5", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("11", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("2,700", Color.green, 20));
			minFPanel.add(impV.lv2("2���� x 2"));
			minSPanel.add(impV.lv2("2����"));
			minSPanel.add(impV.lv1("2��ȭ"));
			if(difficulty == "�븻")
				minTPanel.add(impV.lvZ("2���� 1���ε� �����ϴ�."));
			else {
				minTPanel.add(impV.lvZ("2���� 1���ε� ����������"));
				minTPanel.add(impV.lvZ("��Ʈ�ѿ� ������ �Ŀ� �����Ѵ�."));
			}
			break;
		case "�� ���� [W]":
			roundLabel.setText("15������� �����մϴ�");
			namePanel.add(impV.customText("�� ����", Color.white, 20));
			rankPanel.add(impV.customText("C", Color.red, 25));
			shieldPanel.add(impV.customText("30", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("36", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("9,000", Color.green, 20));
			if(difficulty == "�븻") {
				minFPanel.add(impV.lv2("2���� x 5"));
				minSPanel.add(impV.lv2("2����"));
				minSPanel.add(impV.lv1("2��ȭ"));
				minTPanel.add(impV.lvZ("("));
				minTPanel.add(impV.customText("����", Color.red, 20));
				minTPanel.add(impV.lvZ(")���볪 ("));
				minTPanel.add(impV.customText("����", Color.red, 20));
				minTPanel.add(impV.lvZ(")���ϸ� ����"));
				minTPanel.add(impV.lvZ("�ϴ� ��ܷ��� �淯���� ���ϴ�"));
			} else {
				minFPanel.add(impV.lv2("2���� x 6"));
				minSPanel.add(impV.lv2("2����"));
				minSPanel.add(impV.lv1("2��ȭ"));
				minTPanel.add(impV.lvZ("���� ī������ ���ٸ� �ӹ���"));
				minTPanel.add(impV.lvZ("��ȯ�ϰ� �ѹ��� ���� �Ŀ� ��´�."));
			}
			break;
		case "�� ���� [E]":
			roundLabel.setText("20������� �����մϴ�");
			JPanel minFfPanel = new JPanel();
			JPanel minSsPanel = new JPanel();
			
			minFfPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			minFfPanel.setBackground(new Color(0, 0, 0, 0));
			minFfPanel.setBounds(5, 60, impV.window_width - 25, 30);
			
			minSsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			minSsPanel.setBackground(new Color(0, 0, 0, 0));
			minSsPanel.setBounds(3, 120, impV.window_width - 25, 30);
			minCutPanel.add(minFfPanel);
			minCutPanel.add(minSsPanel);
			
			minSPanel.setBounds(5, 90, impV.window_width - 25, 30);
			minTPanel.setBounds(5, 150, impV.window_width - 25, 40);
			namePanel.add(impV.customText("�� ����", Color.white, 20));
			rankPanel.add(impV.customText("B", Color.red, 25));
			shieldPanel.add(impV.customText("50", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("88", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("22,000", Color.green, 20));
			
			minFPanel.add(impV.lvH("H������"));
			minFPanel.add(impV.lv1(" �Ǵ� "));
			minFPanel.add(impV.lvH("H������"));
			minFfPanel.add(impV.lv1("������ �ȳ��ý�: "));
			minFfPanel.add(impV.lv3("3���� x 1"));
			minSPanel.add(impV.lvH("H"));
			minSPanel.add(impV.lv1("�Ͻ� ������ȣ�� ��ȭ"));
			minSsPanel.add(impV.lv3("                3"));
			minSsPanel.add(impV.lv1("���� �Ͻ� "));
			minSsPanel.add(impV.lv3("3����"));
			minSsPanel.add(impV.lv1("5��ȭ"));
			minTPanel.add(impV.lvZ("Q, W, E �ӹ��� �� �Ծ���Ѵ�."));
			break;
		case "���縶�� [A]":
			roundLabel.setText("25������� �����մϴ�");
			namePanel.add(impV.customText("���縶��", Color.white, 20));
			rankPanel.add(impV.customText("A", Color.red, 25));
			shieldPanel.add(impV.customText("100", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("340", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("85,000", Color.green, 20));

			minFPanel.add(impV.lvH("H x 1"));
			minFPanel.add(impV.lv1(" + "));
			minFPanel.add(impV.lv3("3���� x 1"));
			minSPanel.add(impV.lv3("3����"));
			minSPanel.add(impV.lv1("�ּ� 3��ȭ �̻�"));
			minTPanel.add(impV.lvZ("25���带 �������� ��ȭ��"));
			minTPanel.add(impV.lvZ("������ȣ������ ���� �Ѵ�."));
			break;
		case "��찡�� [S]":
			roundLabel.setText("30������� �����մϴ�");
			namePanel.add(impV.customText("��찡��", Color.white, 20));
			rankPanel.add(impV.customText("S", Color.red, 25));
			shieldPanel.add(impV.customText("150", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("840", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("210,000", Color.green, 20));
			
			minFPanel.add(impV.lvX("X"));
			minFPanel.add(impV.lv1("�Ǵ�"));
			minFPanel.add(impV.lv4("4����"));
			minFPanel.add(impV.lv1(" x 1"));
			minFPanel.add(impV.lv1("+"));
			minFPanel.add(impV.lvH("H x 1"));
			minTPanel.add(impV.lvZ("Xź����, X����ġ��, X������"));
			minTPanel.add(impV.lvZ("X������ ���߾ӿ��� Ȧ�� ��õ"));
			minSPanel.add(impV.lv4("4���� ī����"));
			minSPanel.add(impV.lv1("�� �Ұ���"));
			break;
		case "���� [D]":
			roundLabel.setText("45������� �����մϴ�");
			namePanel.add(impV.customText("����", Color.white, 20));
			rankPanel.add(impV.customText("X", Color.red, 25));
			shieldPanel.add(impV.customText("255", new Color(151, 151, 219), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("6,000", new Color(245, 207, 186), 20));
			shieldPanel.add(impV.customText(" / ", Color.white, 20));
			shieldPanel.add(impV.customText("8,000,000", Color.green, 20));
			
			minFPanel.add(impV.lvX("X"));
			minFPanel.add(impV.lv1(" �Ǵ�"));
			minFPanel.add(impV.lv4("4����"));
			minFPanel.add(impV.lv1("���ؼ� x 3"));
			minTPanel.add(impV.lvZ("Xź����, X����ġ��, X������"));
			minTPanel.add(impV.lvZ("X������ ���߾ӿ��� Ȧ�� ��õ"));
			minSPanel.add(impV.lv4("4���� ī����"));
			minSPanel.add(impV.lv1("�� ���� ���"));
			break;
		}
		
		/* �ڷΰ��� ��ư */
		backButton.setText("�ڷΰ���");							// �۾� ����
		backButton.setFont(new Font("Kostar", Font.PLAIN, 18));	// ��Ʈ ����
		backButton.setBackground(new Color(0, 0, 0, 0));		// ����
		backButton.setForeground(Color.GREEN);					// �۾���
		backButton.setFocusPainted(false);						// ���� ���� �� ����� �׵θ� ���ֱ�
		backButton.setFocusable(false);
		backButton.setPreferredSize(new Dimension(200, 30));	// ũ�� ����
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