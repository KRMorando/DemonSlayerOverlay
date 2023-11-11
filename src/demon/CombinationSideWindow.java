package demon;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CombinationSideWindow extends JFrame implements Runnable {
	ImportentValue impV = new ImportentValue();
	private JPanel mainPanel, levelPanel, explainPanel;
	private JPanel[] lvPanel = {new JPanel(), new JPanel(), new JPanel()};
//									3		/		2		/	1
	private JLabel titleLabel;
	private Border bf;
	
	protected static Thread runningThread;
	private static String name;
	private final int under_size = 250;
	//350, 180 + 250
	//350, 430
	
	private String[] OneLocation = {"1/cha1_Aoi.png",
									"1/cha1_Cube.png",
									"1/cha1_Nezuko.png",
									"1/cha1_Tanjiro.png",
									"1/cha1_Yusiro.png"},

					TwoLocation = {	"2/cha2_Genya.png",
									"2/cha2_Inosuke.png",
									"2/cha2_Kanao.png",
									"2/cha2_Murata.png",
									"2/cha2_Zenitsu.png"},

					ThreeLocation = {"3/cha3_Mitsuri.png",
									 "3/cha3_Muichiro.png",
									 "3/cha3_obanai.png",
									 "3/cha3_Sanemi.png",
									 "3/cha3_Tengen.png" },
					
					FourLocation = {"4/cha4_Giyu.png",
									"4/cha4_Gyomei.png",
									"4/cha4_Kagaya.png",
									"4/cha4_Kyojuro.png",
									"4/cha4_Shinobu.png" },
	
					HLocation = {	"H/chaH_Sakonji.png",
									"H/chaH_Jigoro.png",
									"H/chaH_Tamayo.png",
									"H/chaH_Kanae.png",
									"H/chaH_Makomo.png",
									"H/chaH_Sabito.png" },

					XLocation = {	"H/chaX_Tanjiro.png",
									"H/chaX_Inosuke.png",
									"H/chaX_Zenitsu.png",
									"H/chaX_Giyu.png",
									"H/chaX_Tengen.png",
									"H/chaX_Mitsuri.png",
									"H/chaX_Muichiro.png" },

					ZLocation = {	"Z/chaZ_Kanao.png",
									"Z/chaZ_Nezuko.png",
									"Z/chaZ_Kyojuro.png" };
	
	public CombinationSideWindow(String name) {
		this.name = name;
	}
	
	public void run() {
		if (runningThread != null) {
			try {
				runningThread.interrupt(); // �̹� ����� ������� �۵� ���
			} 	catch (Exception e) {
				e.printStackTrace();
			}
		}

		runningThread = Thread.currentThread(); 				// ����� ������ ��ü ���
		impV.sideContainer = this;	// ���� �����̳� ��ü�� �ֱ����� ���
		
		mainPanel = new MainPanel();
		levelPanel = new JPanel();
		explainPanel = new JPanel();
		titleLabel = new JLabel();

		/* ���� ������ */
		impV.FrameSetting(this);
		
		/* ���� �г� 	*/
		mainPanel.setBounds(0, 0, impV.sideWindow_width, impV.sideWindow_height + under_size);	//x, y, ����, ����
		
		/* ���� �г� */
		levelPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout(�߾� ��ġ)
		levelPanel.setBackground(new Color(0, 0, 0, 0)); // ����
		levelPanel.setBounds(0, 10, impV.sideWindow_width, impV.sideWindow_height - 50); // ũ��

		/* ���� �г� */
		//350, 380
		explainPanel.setLayout(null);
		explainPanel.setBackground(new Color(0, 0, 0, 0));
		explainPanel.setBounds(0, 40, impV.sideWindow_width, impV.sideWindow_height + under_size - 50);
		
		/* ���ս� ���� �г�	*/
		//326, 120
		for(int i = 0; i < lvPanel.length; i++) {
			lvPanel[i].setLayout(null);
			lvPanel[i].setBackground(new Color(0, 0, 0, 0));
			lvPanel[i].setSize(impV.sideWindow_width - 24, 120);
			if(name != "�����") {
				if(i == 0)
					bf = BorderFactory.createTitledBorder(new LineBorder(impV.ThreeColor, 1), "Lv3", TitledBorder.LEFT, TitledBorder.TOP, impV.smallTTF, impV.ThreeColor);
				else if(i == 1)
					bf = BorderFactory.createTitledBorder(new LineBorder(impV.TwoColor, 1), "Lv2", TitledBorder.LEFT, TitledBorder.TOP, impV.smallTTF, impV.TwoColor);
				else
					bf = BorderFactory.createTitledBorder(new LineBorder(impV.OneColor, 1), "Lv1", TitledBorder.LEFT, TitledBorder.TOP, impV.smallTTF, impV.OneColor);
			} else {
				if(i == 0)
					bf = BorderFactory.createTitledBorder(new LineBorder(impV.FourColor, 1), "Lv4", TitledBorder.LEFT, TitledBorder.TOP, impV.smallTTF, impV.FourColor);
				else if(i == 1)
					bf = BorderFactory.createTitledBorder(new LineBorder(impV.ThreeColor, 1), "Lv3", TitledBorder.LEFT, TitledBorder.TOP, impV.smallTTF, impV.ThreeColor);
				else
					bf = BorderFactory.createTitledBorder(new LineBorder(impV.OneColor, 1), "Lv1", TitledBorder.LEFT, TitledBorder.TOP, impV.smallTTF, impV.OneColor);
			}
			lvPanel[i].setBorder(bf);
			CustomLayout(explainPanel, lvPanel[i], 0, i);
		}
		
		/* ���� �г� �߰� */
		levelPanel.add(impV.lvL("1", "normal", "Lv1 "));
		levelPanel.add(impV.lvL("2", "normal", "Lv2 "));
		levelPanel.add(impV.lvL("3", "normal", "Lv3 "));
		levelPanel.add(impV.lvL("4", "normal", "Lv4 "));
		levelPanel.add(impV.lvL("H", "normal", "LvH "));
		levelPanel.add(impV.lvL("X", "normal", "LvX "));
		levelPanel.add(impV.lvL("Z", "normal", "LvZ"));
		
		/* makeCard(���, �̸�, ���� ���) */
		/* CustomLayout(������Ʈ, n��° (0~2), ��(1~)	*/
		
		/* ���� �г� �߰�	*/
		switch(name) {
		/*======H=======*/
		case "������":
			CustomLayout(lvPanel[1], makeCard("2", "����Ÿx2", TwoLocation[3]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ť�꼱��x2", OneLocation[1]), 0, 0);
			CustomLayout(lvPanel[2], makeCard("1", "�ƿ���x2", OneLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ź����x2", OneLocation[3]), 2, 0);
			break;
			
		case "�����":
			CustomLayout(lvPanel[1], makeCard("2", "������x2", TwoLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ť�꼱��x2", OneLocation[1]), 0, 0);
			CustomLayout(lvPanel[2], makeCard("1", "���÷�x2", OneLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "������x2", OneLocation[2]), 2, 0);
			break;
			
		case "Ÿ����":
			CustomLayout(lvPanel[1], makeCard("2", "ī����x2", TwoLocation[2]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "�ƿ���x2", OneLocation[0]), 0, 0);
			CustomLayout(lvPanel[2], makeCard("1", "���÷�x2", OneLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "������x2", OneLocation[2]), 2, 0);
			break;
			
		case "ī����":
			CustomLayout(lvPanel[0], makeCard("3", "����ġ��x1", ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "ī����x1", TwoLocation[2]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ź����x2", OneLocation[3]), 1, 0);
			break;
			
		case "���ڸ�":
			CustomLayout(lvPanel[0], makeCard("3", "������x1", ThreeLocation[0]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "�վ�x1", TwoLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "�ƿ���x2", OneLocation[0]), 1, 0);
			break;
			
		case "�����":
			CustomLayout(lvPanel[0], makeCard("3", "����ġ��x1", ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "������x1", TwoLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ź����x2", OneLocation[3]), 1, 0);
			break;
			
		/*======X=======*/
		case "ź����":
			CustomLayout(lvPanel[0], makeCard("3", "����ġ��x1", ThreeLocation[1]), 0, 0);
			CustomLayout(lvPanel[0], makeCard("3", "���ٳ���x1", ThreeLocation[2]), 1, 0);
			CustomLayout(lvPanel[0], makeCard("3", "�ٰ�x1", ThreeLocation[4]), 2, 0);
			CustomLayout(lvPanel[1], makeCard("2", "����Ÿx2", TwoLocation[3]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ź����x2", OneLocation[3]), 1, 0);
			break;
			
		case "�̳뽺��":
			CustomLayout2(lvPanel[0], makeCard("3", "��׹�x2", ThreeLocation[3]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "�ٰ�x1", ThreeLocation[4]), 1, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "�վ�x2", TwoLocation[0]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "�̳뽺��x1", TwoLocation[1]), 1, 0);
			break;
			
		case "������":
			CustomLayout2(lvPanel[0], makeCard("3", "������x2", ThreeLocation[0]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "��׹�x1", ThreeLocation[3]), 1, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "����Ÿx2", TwoLocation[3]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "������x1", TwoLocation[4]), 1, 0);
			break;
			
		case "����":
			CustomLayout2(lvPanel[0], makeCard("3", "���ٳ���x2", ThreeLocation[2]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "��׹�x1", ThreeLocation[3]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "�̳뽺��x2", TwoLocation[1]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ť�꼱��x2", OneLocation[1]), 1, 0);
			break;
			
		case "�ٰ�":
			CustomLayout2(lvPanel[0], makeCard("3", "�ٰ�x2", ThreeLocation[4]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "������x1", ThreeLocation[0]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "ī����x2", TwoLocation[2]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ť�꼱��x2", OneLocation[1]), 1, 0);
			break;
			
		case "������":
			CustomLayout2(lvPanel[0], makeCard("3", "������x1", ThreeLocation[0]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "����ġ��x1", ThreeLocation[1]), 1, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "�̳뽺��x2", TwoLocation[1]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "������x1", TwoLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "������x2", OneLocation[2]), 1, 0);
			break;
			
		case "����ġ��":
			CustomLayout2(lvPanel[0], makeCard("3", "����ġ��x2", ThreeLocation[1]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "������x1", ThreeLocation[0]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "�վ�x2", TwoLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "���÷�x2", OneLocation[4]), 1, 0);
			break;
			
		/*======Z=======*/
		case "ī����":
			CustomLayout(lvPanel[0], makeCard("3", "������x2", ThreeLocation[0]), 0, 0);
			CustomLayout(lvPanel[0], makeCard("3", "����ġ��x2", ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[0], makeCard("3", "���ٳ���x2", ThreeLocation[2]), 2, 0);
			CustomLayout(lvPanel[2], makeCard("1", "�ƿ���x2", OneLocation[0]), 1, 0);
			break;
			
		case "������":
			CustomLayout(lvPanel[0], makeCard("3", "�ٰ�x2", ThreeLocation[4]), 0, 0);
			CustomLayout(lvPanel[0], makeCard("3", "����ġ��x2", ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[0], makeCard("3", "��׹�x1", ThreeLocation[3]), 2, 0);
			CustomLayout(lvPanel[1], makeCard("2", "ī����x2", TwoLocation[2]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "������x2", OneLocation[2]), 1, 0);
			break;
			
		case "�����":
			CustomLayout(lvPanel[0], makeCard("4", "�����x1", FourLocation[3]), 1, 0);
			CustomLayout2(lvPanel[1], makeCard("3", "���ٳ���x2", ThreeLocation[2]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("3", "������x1", ThreeLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ź����x2", OneLocation[3]), 1, 0);
			break;
		}
		
		mainPanel.add(levelPanel);
		mainPanel.add(explainPanel);
		add(mainPanel);

		// ���� ���� ���� ���� �� ���̱�
		setSize(impV.sideWindow_width, impV.sideWindow_height + under_size);
		setLocation(impV.screenSize.width - impV.window_width - impV.sideWindow_width - 8, 50);
		setVisible(true);
		
		try {
			Thread.sleep(impV.cooltime * 1000);
			runningThread = null;
			impV.sideContainer = null;
			dispose();
		} catch (InterruptedException e) {
			dispose();
		}
	}
	
	protected Component makeCard(String rank, String name, String location) {
		int width = 92;
		int height = 120;
		
		URL url = this.getClass().getClassLoader().getResource(location);
		ImageIcon icon = new ImageIcon(url), updateIcon;
		Image img = icon.getImage();
		Image updateImg = img.getScaledInstance(width, height - 25, Image.SCALE_SMOOTH);
		updateIcon = new ImageIcon(updateImg);
		
		JPanel cardPanel = new JPanel();
		JLabel imgLabel = new JLabel(updateIcon);
		JLabel imgText = new JLabel();
		
		cardPanel.setLayout(null);
		cardPanel.setBackground(new Color(0, 0, 0, 0));	//��� ����
		cardPanel.setSize(width, height);				//width, height

		imgLabel.setText("");
		imgLabel.setBackground(new Color(0, 0, 0, 0));	// ��� ����
		imgLabel.setBounds(0, 0, width, height - 25); 	// x, y, width, height

		imgText.setText(name); 							// ��ư �̸�
		imgText.setBackground(new Color(0, 0, 0, 0));	// ����
		imgText.setFont(impV.smallTTF); 				// ��Ʈ
		imgText.setHorizontalAlignment(JLabel.CENTER);
		imgText.setVerticalAlignment(JLabel.CENTER);
		imgText.setBounds(0, height - 40, width, 35);	// x, y, width, height
		if(rank == "1")
			imgText.setForeground(impV.OneColor);	//�۾� ����
		else if(rank == "2")
			imgText.setForeground(impV.TwoColor);	//�۾� ����
		else if(rank == "3")
			imgText.setForeground(impV.ThreeColor);	//�۾� ����
		else if(rank == "4")
			imgText.setForeground(impV.FourColor);	//�۾� ����
		else if(rank == "H")
			imgText.setForeground(impV.HColor);		//�۾� ����
		else if(rank == "X")
			imgText.setForeground(impV.XColor);		//�۾� ����
		else
			imgText.setForeground(impV.ZColor);		//�۾� ����
		
		cardPanel.add(imgLabel);
		cardPanel.add(imgText);
		
		return cardPanel;
	}
	
	protected void CustomLayout(JPanel panel, Component c, int sequence, int floor) {
		c.setLocation((12 * (1 + sequence)) + (100 * sequence), (5 * (1 + floor)) + (120 * floor));
		//				���� ���					�ڽ� ���		x / y
		panel.add(c);
	}
	
	protected void CustomLayout2(JPanel panel, Component c, int sequence, int floor) {
		c.setLocation((46 * (1 + sequence)) + (100 * sequence), (5 * (1 + floor)) + (120 * floor));
		//				���� ���					�ڽ� ���		x / y
		panel.add(c);
	}
}
