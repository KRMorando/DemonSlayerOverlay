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

		runningThread = Thread.currentThread(); // ����� ������ ��ü ���
		SystemManager.sideContainer = this;		// ���� �����̳� ��ü�� �ֱ����� ���
		
		mainPanel = new MainPanel();
		levelPanel = new JPanel();
		explainPanel = new JPanel();
		titleLabel = new JLabel();

		/* ���� ������ */
		SystemManager.FrameSetting(this);
		
		/* ���� �г� 	*/
		mainPanel.setBounds(0, 0, SystemManager.sideWindow_width, SystemManager.sideWindow_height + under_size);	//x, y, ����, ����
		
		/* ���� �г� */
		levelPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout(�߾� ��ġ)
		levelPanel.setBackground(new Color(0, 0, 0, 0)); // ����
		levelPanel.setBounds(0, 10, SystemManager.sideWindow_width, SystemManager.sideWindow_height - 50); // ũ��

		/* ���� �г� */
		//350, 380
		explainPanel.setLayout(null);
		explainPanel.setBackground(new Color(0, 0, 0, 0));
		explainPanel.setBounds(0, 40, SystemManager.sideWindow_width, SystemManager.sideWindow_height + under_size - 50);
		
		/* ���ս� ���� �г�	*/
		//326, 120
		for(int i = 0; i < lvPanel.length; i++) {
			lvPanel[i].setLayout(null);
			lvPanel[i].setBackground(new Color(0, 0, 0, 0));
			lvPanel[i].setSize(SystemManager.sideWindow_width - 24, 120);
			if(name.equals("�����")) {
				if(i == 0)
					bf = BorderFactory.createTitledBorder(new LineBorder(SystemManager.FourColor, 1), "Lv4", TitledBorder.LEFT, TitledBorder.TOP, SystemManager.smallTTF, SystemManager.FourColor);
				else if(i == 1)
					bf = BorderFactory.createTitledBorder(new LineBorder(SystemManager.ThreeColor, 1), "Lv3", TitledBorder.LEFT, TitledBorder.TOP, SystemManager.smallTTF, SystemManager.ThreeColor);
			} else if(name.equals("ī���� ź����")) {
				if(i == 0)
					bf = BorderFactory.createTitledBorder(new LineBorder(SystemManager.XColor, 1), "LvX", TitledBorder.LEFT, TitledBorder.TOP, SystemManager.smallTTF, SystemManager.XColor);
				else if(i == 1)
					bf = BorderFactory.createTitledBorder(new LineBorder(SystemManager.ThreeColor, 1), "Lv3", TitledBorder.LEFT, TitledBorder.TOP, SystemManager.smallTTF, SystemManager.ThreeColor);
			} else {
				if(i == 0)
					bf = BorderFactory.createTitledBorder(new LineBorder(SystemManager.ThreeColor, 1), "Lv3", TitledBorder.LEFT, TitledBorder.TOP, SystemManager.smallTTF, SystemManager.ThreeColor);
				else if(i == 1)
					bf = BorderFactory.createTitledBorder(new LineBorder(SystemManager.TwoColor, 1), "Lv2", TitledBorder.LEFT, TitledBorder.TOP, SystemManager.smallTTF, SystemManager.TwoColor);
			}
			
			if(i == 2)
				bf = BorderFactory.createTitledBorder(new LineBorder(SystemManager.OneColor, 1), "Lv1", TitledBorder.LEFT, TitledBorder.TOP, SystemManager.smallTTF, SystemManager.OneColor);
			lvPanel[i].setBorder(bf);
			CustomLayout(explainPanel, lvPanel[i], 0, i);
		}
		
		/* ���� �г� �߰� */
		levelPanel.add(SystemManager.lvL("1", "normal", "Lv1 "));
		levelPanel.add(SystemManager.lvL("2", "normal", "Lv2 "));
		levelPanel.add(SystemManager.lvL("3", "normal", "Lv3 "));
		levelPanel.add(SystemManager.lvL("4", "normal", "Lv4 "));
		levelPanel.add(SystemManager.lvL("H", "normal", "LvH "));
		levelPanel.add(SystemManager.lvL("X", "normal", "LvX "));
		levelPanel.add(SystemManager.lvL("Z", "normal", "LvZ"));
		
		/* makeCard(���, �̸�, ���� ���) */
		/* CustomLayout(������Ʈ, n��° (0~2), ��(1~)	*/
		
		/* ���� �г� �߰�	*/
		switch(name) {
		/*======H=======*/
		case "������":
			CustomLayout(lvPanel[1], makeCard("2", "����Ÿx2", SystemManager.TwoLocation[3]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ť�꼱��x2", SystemManager.OneLocation[1]), 0, 0);
			CustomLayout(lvPanel[2], makeCard("1", "�ƿ���x2", SystemManager.OneLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ź����x2", SystemManager.OneLocation[3]), 2, 0);
			break;
			
		case "�����":
			CustomLayout(lvPanel[1], makeCard("2", "������x2", SystemManager.TwoLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ť�꼱��x2", SystemManager.OneLocation[1]), 0, 0);
			CustomLayout(lvPanel[2], makeCard("1", "���÷�x2", SystemManager.OneLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "������x2", SystemManager.OneLocation[2]), 2, 0);
			break;
			
		case "Ÿ����":
			CustomLayout(lvPanel[1], makeCard("2", "ī����x2", SystemManager.TwoLocation[2]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "�ƿ���x2", SystemManager.OneLocation[0]), 0, 0);
			CustomLayout(lvPanel[2], makeCard("1", "���÷�x2", SystemManager.OneLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "������x2", SystemManager.OneLocation[2]), 2, 0);
			break;
			
		case "ī����":
			CustomLayout(lvPanel[0], makeCard("3", "����ġ��x1", SystemManager.ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "ī����x1", SystemManager.TwoLocation[2]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ź����x2", SystemManager.OneLocation[3]), 1, 0);
			break;
			
		case "���ڸ�":
			CustomLayout(lvPanel[0], makeCard("3", "������x1", SystemManager.ThreeLocation[0]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "�վ�x1", SystemManager.TwoLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "�ƿ���x2", SystemManager.OneLocation[0]), 1, 0);
			break;
			
		case "�����":
			CustomLayout(lvPanel[0], makeCard("3", "����ġ��x1", SystemManager.ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "������x1", SystemManager.TwoLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ź����x2", SystemManager.OneLocation[3]), 1, 0);
			break;
			
		/*======EH======*/
		case "ȣŸ��":
			CustomLayout(lvPanel[0], makeCard("3", "����ġ��x1", SystemManager.ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "������x1", SystemManager.TwoLocation[4]), 0, 0);
			CustomLayout(lvPanel[1], makeCard("2", "�վ�x1", SystemManager.TwoLocation[0]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "�̳뽺��x1", SystemManager.TwoLocation[1]), 2, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ź����x1", SystemManager.OneLocation[3]), 1, 0);
			break;
			
		/*======X=======*/
		case "ź����":
			CustomLayout(lvPanel[0], makeCard("3", "����ġ��x1", SystemManager.ThreeLocation[1]), 0, 0);
			CustomLayout(lvPanel[0], makeCard("3", "���ٳ���x1", SystemManager.ThreeLocation[2]), 1, 0);
			CustomLayout(lvPanel[0], makeCard("3", "�ٰ�x1", SystemManager.ThreeLocation[4]), 2, 0);
			CustomLayout(lvPanel[1], makeCard("2", "����Ÿx2", SystemManager.TwoLocation[3]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ź����x2", SystemManager.OneLocation[3]), 1, 0);
			break;
			
		case "�̳뽺��":
			CustomLayout2(lvPanel[0], makeCard("3", "��׹�x2", SystemManager.ThreeLocation[3]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "�ٰ�x1", SystemManager.ThreeLocation[4]), 1, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "�վ�x2", SystemManager.TwoLocation[0]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "�̳뽺��x1", SystemManager.TwoLocation[1]), 1, 0);
			break;
			
		case "������":
			CustomLayout2(lvPanel[0], makeCard("3", "������x2", SystemManager.ThreeLocation[0]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "��׹�x1", SystemManager.ThreeLocation[3]), 1, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "����Ÿx2", SystemManager.TwoLocation[3]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "������x1", SystemManager.TwoLocation[4]), 1, 0);
			break;
			
		case "����":
			CustomLayout2(lvPanel[0], makeCard("3", "���ٳ���x2", SystemManager.ThreeLocation[2]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "��׹�x1", SystemManager.ThreeLocation[3]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "�̳뽺��x2", SystemManager.TwoLocation[1]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ť�꼱��x2", SystemManager.OneLocation[1]), 1, 0);
			break;
			
		case "�ٰ�":
			CustomLayout2(lvPanel[0], makeCard("3", "�ٰ�x2", SystemManager.ThreeLocation[4]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "������x1", SystemManager.ThreeLocation[0]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "ī����x2", SystemManager.TwoLocation[2]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ť�꼱��x2", SystemManager.OneLocation[1]), 1, 0);
			break;
			
		case "������":
			CustomLayout(lvPanel[0], makeCard("3", "������x1", SystemManager.ThreeLocation[0]), 0, 0);
			CustomLayout(lvPanel[0], makeCard("3", "����ġ��x1", SystemManager.ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[0], makeCard("3", "���ٳ���x1", SystemManager.ThreeLocation[2]), 2, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "�̳뽺��x1", SystemManager.TwoLocation[1]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "������x1", SystemManager.TwoLocation[4]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "������x2", SystemManager.OneLocation[2]), 1, 0);
			break;
			
		case "����ġ��":
			CustomLayout2(lvPanel[0], makeCard("3", "����ġ��x2", SystemManager.ThreeLocation[1]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "������x1", SystemManager.ThreeLocation[0]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("2", "�վ�x2", SystemManager.TwoLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "���÷�x2", SystemManager.OneLocation[4]), 1, 0);
			break;
			
		case "�վ�":
			CustomLayout2(lvPanel[0], makeCard("3", "��׹�x2", SystemManager.ThreeLocation[3]), 0, 0);
			CustomLayout2(lvPanel[0], makeCard("3", "���ٳ���x1", SystemManager.ThreeLocation[2]), 1, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "ī����x1", SystemManager.TwoLocation[2]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("2", "�վ�x1", SystemManager.TwoLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "���÷�x2", SystemManager.OneLocation[4]), 1, 0);
			break;
			
		/*======Z=======*/
		case "ī����":
			CustomLayout(lvPanel[0], makeCard("3", "������x2", SystemManager.ThreeLocation[0]), 0, 0);
			CustomLayout(lvPanel[0], makeCard("3", "����ġ��x2", SystemManager.ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[0], makeCard("3", "���ٳ���x2", SystemManager.ThreeLocation[2]), 2, 0);
			CustomLayout(lvPanel[2], makeCard("1", "�ƿ���x2", SystemManager.OneLocation[0]), 1, 0);
			break;
			
		case "������":
			CustomLayout(lvPanel[0], makeCard("3", "�ٰ�x2", SystemManager.ThreeLocation[4]), 0, 0);
			CustomLayout(lvPanel[0], makeCard("3", "����ġ��x2", SystemManager.ThreeLocation[1]), 1, 0);
			CustomLayout(lvPanel[0], makeCard("3", "��׹�x1", SystemManager.ThreeLocation[3]), 2, 0);
			CustomLayout(lvPanel[1], makeCard("2", "ī����x2", SystemManager.TwoLocation[2]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "������x2", SystemManager.OneLocation[2]), 1, 0);
			break;
			
		case "�����":
			CustomLayout(lvPanel[0], makeCard("4", "�����x1", SystemManager.FourLocation[3]), 1, 0);
			CustomLayout2(lvPanel[1], makeCard("3", "���ٳ���x2", SystemManager.ThreeLocation[2]), 0, 0);
			CustomLayout2(lvPanel[1], makeCard("3", "������x1", SystemManager.ThreeLocation[0]), 1, 0);
			CustomLayout(lvPanel[2], makeCard("1", "ź����x2", SystemManager.OneLocation[3]), 1, 0);
			break;
			
		/*=======SZ======*/
		case "ī���� ź����":
			CustomLayout(lvPanel[0], makeCard("X", "ź����x1", SystemManager.XLocation[0]), 1, 0);
			CustomLayout(lvPanel[1], makeCard("3", "ALL Lv3x2", SystemManager.ThreeLocation[2]), 1, 0);
			break;
		}
		
		mainPanel.add(levelPanel);
		mainPanel.add(explainPanel);
		add(mainPanel);

		// ���� ���� ���� ���� �� ���̱�
		setSize(SystemManager.sideWindow_width, SystemManager.sideWindow_height + under_size);
		setLocation(SystemManager.screenSize.width - SystemManager.window_width - SystemManager.sideWindow_width - 8, 50);
		setVisible(true);
		
		try {
			Thread.sleep(SystemManager.cooltime * 1000);
			runningThread = null;
			SystemManager.sideContainer = null;
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
		Image updateImg = img.getScaledInstance(width, height - 15, Image.SCALE_SMOOTH);
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
		imgText.setFont(SystemManager.smallTTF); 				// ��Ʈ
		imgText.setHorizontalAlignment(JLabel.CENTER);
		imgText.setVerticalAlignment(JLabel.CENTER);
		imgText.setBounds(0, height - 40, width, 35);	// x, y, width, height
		if(rank.equals("1"))
			imgText.setForeground(SystemManager.OneColor);	//�۾� ����
		else if(rank.equals("2"))
			imgText.setForeground(SystemManager.TwoColor);	//�۾� ����
		else if(rank.equals("3"))
			imgText.setForeground(SystemManager.ThreeColor);//�۾� ����
		else if(rank.equals("4"))
			imgText.setForeground(SystemManager.FourColor);	//�۾� ����
		else if(rank.equals("H"))
			imgText.setForeground(SystemManager.HColor);	//�۾� ����
		else if(rank.equals("EH"))
			imgText.setForeground(SystemManager.EHColor);	//�۾� ����
		else if(rank.equals("X"))
			imgText.setForeground(SystemManager.XColor);	//�۾� ����
		else if(rank.equals("Z"))
			imgText.setForeground(SystemManager.ZColor);	//�۾� ����
		else
			imgText.setForeground(SystemManager.SZColor);	//�۾� ����
		
		cardPanel.add(imgLabel);
		cardPanel.add(imgText);
		
		return cardPanel;
	}
	
	protected void CustomLayout(JPanel panel, Component c, int sequence, int floor) {
		c.setLocation((10 * (1 + sequence)) + (100 * sequence), (5 * (1 + floor)) + (120 * floor));
		//				���� ���					�ڽ� ���		x / y
		panel.add(c);
	}
	
	protected void CustomLayout2(JPanel panel, Component c, int sequence, int floor) {
		c.setLocation((46 * (1 + sequence)) + (100 * sequence), (5 * (1 + floor)) + (120 * floor));
		//				���� ���					�ڽ� ���		x / y
		panel.add(c);
	}
}
