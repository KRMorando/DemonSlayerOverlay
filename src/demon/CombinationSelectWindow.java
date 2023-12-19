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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CombinationSelectWindow extends JFrame {
	private JPanel mainPanel, buttonPanel;
	private JLabel titleLabel, explainLabel;
	private JButton backButton;
	
	private int width = 100;
	private int height = 140;

	private String[] HLocation = {	"H/chaH_Sakonji.png",
									"H/chaH_Jigoro.png",
									"H/chaH_Tamayo.png",
									"H/chaH_Kanae.png",
									"H/chaH_Makomo.png",
									"H/chaH_Sabito.png" },
					
					EHLocation = {	"EH/chaEH_Hotaru.png"},

					XLocation = {	"X/chaX_Tanjiro.png",
									"X/chaX_Inosuke.png",
									"X/chaX_Zenitsu.png",
									"X/chaX_Giyu.png",
									"X/chaX_Tengen.png",
									"X/chaX_Mitsuri.png",
									"X/chaX_Muichiro.png" },

					ZLocation = {	"Z/chaZ_Kanao.png",
									"Z/chaZ_Nezuko.png",
									"Z/chaZ_Kyojuro.png" },
					
					SZLocation = {	"SZ/chaSZ_Tanjiro.png"};

	public CombinationSelectWindow(String id) {
		impV.activeContainer = this;	//���� Ȱ��ȭ�� �����̳� ����
		

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
		impV.FrameSetting(this);
		
		/* Ÿ��Ʋ ��	*/
		titleLabel.setFont(impV.titleTTF);				// ��Ʈ
		titleLabel.setBackground(new Color(0, 0, 0, 0));	// ����
		titleLabel.setHorizontalAlignment(JLabel.CENTER);	// �߾� ����
		titleLabel.setBounds(0, 0, impV.window_width, 100); // x, y, width, height
		
		/*	���� ��	*/
		explainLabel.setText("���ϴ� ĳ���͸� �����ּ���.");
		explainLabel.setFont(impV.smallTTF);				// ��Ʈ
		explainLabel.setForeground(Color.green);					// ����
		explainLabel.setBackground(new Color(0, 0, 0, 0));		// ����
		explainLabel.setHorizontalAlignment(JLabel.CENTER);		// �߾� ����
		explainLabel.setBounds(0, 80, impV.window_width, 30);	// x, y, width, height
		
		/* ��ư �г� 	*/
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(new Color(0, 0, 0, 0));
		buttonPanel.setBounds(0, 100, impV.window_width, impV.window_height - 140);
		
		/* 350, 600	*/

		/* makeCard(���, �̸�, ���� ���) */
		/* H / EH / X / Z / SZ ���� */
		
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
			
		case "EH":
			titleLabel.setText("EH");
			titleLabel.setForeground(impV.EHColor);
			
			CustomLayout(makeCard("EH", "ȣŸ��", EHLocation[0]), 1, 0);
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
			
		case "SZ": 
			titleLabel.setText("SZ"); 				// ����
			titleLabel.setForeground(impV.SZColor);	// �� ����
			
			Component card = makeCard("SZ", "ī���� ź����", SZLocation[0]);
			card.setLocation((impV.window_width - width) / 2, (impV.window_height - height) / 4);
			buttonPanel.add(card);
			break;
		}

		mainPanel.add(titleLabel);
		mainPanel.add(explainLabel);
		mainPanel.add(buttonPanel);
		mainPanel.add(backButton);
		add(mainPanel);

		// ���� ���� ���� ���� �� ���̱�
		setSize(impV.window_width, impV.window_height);
		setLocation(impV.screenSize.width - impV.window_width - 10, 50);
		setVisible(true);
	}

	protected Component makeCard(String rank, String name, String location) {
		if(name.equals("ī���� ź����")) {
			width = 150;
			height = 190;
		}
		
		URL url = this.getClass().getClassLoader().getResource(location);
		ImageIcon icon = new ImageIcon(url), updateIcon;
		Image img = icon.getImage();
		Image updateImg = img.getScaledInstance(width, height - 25, Image.SCALE_SMOOTH);
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
		imgText.setFont(impV.normalTTF); 					// ��Ʈ
		imgText.setHorizontalAlignment(JLabel.CENTER);
		imgText.setVerticalAlignment(JLabel.CENTER);
		imgText.setBounds(0, height - 25, width, 25);		// x, y, width, height
		if(rank.equals("H"))
			imgText.setForeground(impV.HColor);	// �۾� ����
		else if(rank.equals("EH"))
			imgText.setForeground(impV.EHColor); // �۾� ����
		else if(rank.equals("X"))
			imgText.setForeground(impV.XColor);	// �۾� ����
		else if(rank.equals("Z"))
			imgText.setForeground(impV.ZColor);	// �۾� ����
		else
			imgText.setForeground(impV.SZColor); // �۾� ����
		
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
