package demon_slayer;

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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CombinationSelectWindow extends JFrame {
	ImportentValue impV = new ImportentValue();

	private JPanel mainPanel, buttonPanel;
	private JLabel titleLabel, explainLabel;
	private JButton backButton;

	private String[] HLocation = {	"./images/Char/H/chaH_Sakonji.png",
									"./images/Char/H/chaH_Jigoro.png",
									"./images/Char/H/chaH_Tamayo.png",
									"./images/Char/H/chaH_Kanae.png",
									"./images/Char/H/chaH_Makomo.png",
									"./images/Char/H/chaH_Sabito.png" },

					XLocation = {	"./images/Char/X/chaX_Tanjiro.png",
									"./images/Char/X/chaX_Inosuke.png",
									"./images/Char/X/chaX_Zenitsu.png",
									"./images/Char/X/chaX_Giyu.png",
									"./images/Char/X/chaX_Tengen.png",
									"./images/Char/X/chaX_Mitsuri.png",
									"./images/Char/X/chaX_Muichiro.png" },

					ZLocation = {	"./images/Char/Z/chaZ_Kanao.png",
									"./images/Char/Z/chaZ_Nezuko.png",
									"./images/Char/Z/chaZ_Kyojuro.png" };

	public CombinationSelectWindow(String id) {
		impV.activeContainer = getRootPane().getContentPane();	//���� Ȱ��ȭ�� �����̳� ����
		
		setUndecorated(true);	// �׵θ� ����
		setResizable(false);	// ũ�� ���� ����

		mainPanel = new JPanel();
		titleLabel = new JLabel();
		explainLabel = new JLabel();
		buttonPanel = new JPanel();
		backButton = new JButton();

		setBackground(new Color(0, 0, 0, 0));

		/* ���� �г� 	*/
		mainPanel.setLayout(null); 											//���̾ƿ�
		mainPanel.setBackground(impV.backColor);							//����
		mainPanel.setBorder(new LineBorder(Color.red, 2, true));			//�׵θ�
		mainPanel.setBounds(0, 0, impV.window_width, impV.window_height);	//x, y, ����, ����
		
		/* Ÿ��Ʋ ��	*/
		titleLabel.setFont(impV.titleKostar);				// ��Ʈ
		titleLabel.setBackground(new Color(0, 0, 0, 0));	// ����
		titleLabel.setHorizontalAlignment(JLabel.CENTER);	// �߾� ����
		titleLabel.setBounds(0, 0, impV.window_width, 100); // x, y, width, height
		
		/*	���� ��	*/
		explainLabel.setText("���ϴ� ĳ���͸� �����ּ���.");
		explainLabel.setFont(impV.smallKostar);				// ��Ʈ
		explainLabel.setForeground(Color.green);					// ����
		explainLabel.setBackground(new Color(0, 0, 0, 0));		// ����
		explainLabel.setHorizontalAlignment(JLabel.CENTER);		// �߾� ����
		explainLabel.setBounds(0, 80, impV.window_width, 30);	// x, y, width, height
		
		/* ��ư �г� 	*/
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(new Color(0, 0, 0, 0));
		buttonPanel.setBounds(0, 100, impV.window_width, impV.window_height - 140);
		
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
				if(impV.sideContainer != null) {
					impV.sideContainer.setVisible(false);
					impV.sideContainer = null;
				}
				new CombinationWindow();
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
		
		/* 350, 600	*/

		/* makeCard(���, �̸�, ���� ���) */
		/* H / X / Z ���� */
		
		switch (id) {
		case "H": 
			titleLabel.setText("H");				// ����
			titleLabel.setForeground(impV.HColor);	// �� ����
			
			CustomLayout(makeCard("H", "������", HLocation[0]), 0, 0);
			CustomLayout(makeCard("H", "�����", HLocation[1]), 1, 0);
			CustomLayout(makeCard("H", "Ÿ����", HLocation[2]), 2, 0);
			CustomLayout(makeCard("H", "ī����", HLocation[3]), 0, 1);
			CustomLayout(makeCard("H", "���ڸ�", HLocation[4]), 1, 1);
			CustomLayout(makeCard("H", "�����", HLocation[5]), 2, 1);
			break;
			
		case "X":
			titleLabel.setText("X");				// ����
			titleLabel.setForeground(impV.XColor);	// �� ����
			
			CustomLayout(makeCard("X", "ź����", XLocation[0]), 0, 0);
			CustomLayout(makeCard("X", "�̳뽺��", XLocation[1]), 1, 0);
			CustomLayout(makeCard("X", "������", XLocation[2]), 2, 0);
			CustomLayout(makeCard("X", "����", XLocation[3]), 0, 1);
			CustomLayout(makeCard("X", "�ٰ�", XLocation[4]), 1, 1);
			CustomLayout(makeCard("X", "������", XLocation[5]), 2, 1);
			CustomLayout(makeCard("X", "����ġ��", XLocation[6]), 0, 2);
			break;
		  
		case "Z": 
			titleLabel.setText("Z"); 				// ����
			titleLabel.setForeground(impV.ZColor);	// �� ����
		  
			CustomLayout(makeCard("Z", "ī����", ZLocation[0]), 0, 1);
			CustomLayout(makeCard("Z", "������", ZLocation[1]), 1, 1);
			CustomLayout(makeCard("Z", "�����", ZLocation[2]), 2, 1);
			break;
		}

		mainPanel.add(titleLabel);
		mainPanel.add(explainLabel);
		mainPanel.add(buttonPanel);
		mainPanel.add(backButton);
		add(mainPanel);

		setAlwaysOnTop(true); // �׻� ���� ���̱�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ ����� javax�� ����

		// ���� ���� ���� ���� �� ���̱�
		setSize(impV.window_width, impV.window_height);
		setLocation(impV.screenSize.width - impV.window_width - 10, 50);
		setVisible(true);
	}

	protected Component makeCard(String rank, String name, String location) {
		int width = 100;
		int height = 140;
		
		ImageIcon icon = new ImageIcon(location), updateIcon;
		Image img = icon.getImage();
		Image updateImg = img.getScaledInstance(width, height - 25, Image.SCALE_SMOOTH);
		updateIcon = new ImageIcon(updateImg);
		
		JPanel cardPanel = new JPanel();
		JLabel imgLabel = new JLabel(updateIcon);
		JLabel imgText = new JLabel();
		JButton mainButton = new JButton();
		
		cardPanel.setLayout(null);
		cardPanel.setBackground(new Color(0, 0, 0, 0));	//��� ����
		cardPanel.setSize(width, height);					//width, height

		imgLabel.setText("");
		imgLabel.setBackground(new Color(0, 0, 0, 0));		// ��� ����
		imgLabel.setBounds(0, 0, width, height - 25); 		// x, y, width, height

		imgText.setText(name); 								// ��ư �̸�
		imgText.setBackground(new Color(0, 0, 0, 0));		// ����
		imgText.setFont(impV.normalKostar); 				// ��Ʈ
		imgText.setHorizontalAlignment(JLabel.CENTER);
		imgText.setVerticalAlignment(JLabel.CENTER);
		imgText.setBounds(0, height - 25, width, 25);		// x, y, width, height
		if(rank == "H")
			imgText.setForeground(impV.HColor);	// �۾� ����
		else if(rank == "X")
			imgText.setForeground(impV.XColor);	// �۾� ����
		else
			imgText.setForeground(impV.ZColor);	// �۾� ����
		
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
		c.setLocation((12 * (1 + sequence)) + (100 * sequence), (5 * (1 + floor)) + (140 * floor));
		//				���� ���					�ڽ� ���		x / y
		buttonPanel.add(c);
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(new Color(0, 0, 0, 0));
	}
}
