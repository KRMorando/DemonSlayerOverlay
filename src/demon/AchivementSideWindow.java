package demon;

import java.awt.Color;
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

public class AchivementSideWindow extends JFrame implements Runnable {
	private JPanel mainPanel, levelPanel, explainPanel, rewardPanel;
	private URL url;
	private String imgUrl[] = {	"achive/under_lamp1.png",
								"achive/under_lamp2.png" };

	protected static Thread runningThread;
	private static int number;
	
	private final int under_size = 250;

	public AchivementSideWindow(int number) {
		this.number = number;
	}

	public void run() {
		if (runningThread != null) {
			try {
				runningThread.interrupt(); // �̹� ����� ������� �۵� ���
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		runningThread = Thread.currentThread(); 				// ����� ������ ��ü ���
		SystemManager.sideContainer = this;	// ���� �����̳� ��ü�� �ֱ����� ���

		mainPanel = new MainPanel();
		levelPanel = new JPanel();
		explainPanel = new JPanel();
		rewardPanel = new JPanel();

		/*	���� ������	*/
        SystemManager.FrameSetting(this);
		
		/* ���� �г� */
		levelPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout(�߾� ��ġ)
		levelPanel.setBackground(new Color(0, 0, 0, 0)); // ����
		levelPanel.setBounds(0, 10, SystemManager.sideWindow_width, SystemManager.sideWindow_height - 50); // ũ��

		/* ���� �г� */
		explainPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout(�߾� ��ġ)
		explainPanel.setBackground(new Color(0, 0, 0, 0)); // ����
		explainPanel.setBounds(0, 50, SystemManager.sideWindow_width, SystemManager.sideWindow_height - 50); // ũ��

		/* ���� �г� */
		Border bf = BorderFactory.createTitledBorder(new LineBorder(Color.red, 1), "����", TitledBorder.LEFT, TitledBorder.TOP, SystemManager.normalTTF, Color.white);
		rewardPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout(�߾� ��ġ)
		rewardPanel.setBorder(bf);
		rewardPanel.setBackground(new Color(0, 0, 0, 0)); // ����
		rewardPanel.setBounds(10, 100, SystemManager.sideWindow_width - 20, SystemManager.sideWindow_height - 105); // ũ��

		/* ���� �г� �߰� */
		levelPanel.add(SystemManager.lvL("1", "normal", "Lv1 "));
		levelPanel.add(SystemManager.lvL("2", "normal", "Lv2 "));
		levelPanel.add(SystemManager.lvL("3", "normal", "Lv3 "));
		levelPanel.add(SystemManager.lvL("4", "normal", "Lv4 "));
		levelPanel.add(SystemManager.lvL("H", "normal", "LvH "));
		levelPanel.add(SystemManager.lvL("EH", "normal", "LvEH "));
		levelPanel.add(SystemManager.lvL("X", "normal", "LvX "));
		levelPanel.add(SystemManager.lvL("Z", "normal", "LvZ"));

		switch (number) {
		case 0:
			// �ϱ�
			explainPanel.add(SystemManager.lvL("1", "normal", "ALL Lv1"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x1"));
			break;

		case 1:
			// �߱�
			explainPanel.add(SystemManager.lvL("2", "normal", "ALL Lv2"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x2"));
			break;

		case 2:
			// ���
			explainPanel.add(SystemManager.lvL("3", "normal", "ALL Lv3"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x3"));
			break;

		case 3:
			// ����
			explainPanel.add(SystemManager.lvL("1", "normal", "ź����x4 + ������x4"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x1"));
			break;

		case 4:
			// ����
			explainPanel.add(SystemManager.lvL("1", "normal", "���÷�x5 + ������x3"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x1"));
			break;

		case 5:
			// ����
			explainPanel.add(SystemManager.lvL("2", "normal", "ī����x3"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("1", "normal", "�ƿ���x3"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x1"));
			break;

		case 6:
			// ���
			explainPanel.add(SystemManager.lvL("2", "normal", "�վ�x4"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("2", "normal", "����Ÿx1"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x1"));
			break;

		case 7:
			// ����
			explainPanel.add(SystemManager.lvL("3", "normal", "��׹�x2"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("2", "normal", "�վ�x2"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x2"));
			break;

		case 8:
			// ���
			explainPanel.add(SystemManager.lvL("3", "normal", "������x2"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("3", "normal", "���ٳ���x1"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x2"));
			break;

		case 9:
			// ����
			explainPanel.add(SystemManager.lvL("4", "normal", "ī����x1"));
			explainPanel.add(SystemManager.lvL("1", "normal", " (ù Lv4 ���տ� �����)"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x2"));
			break;

		case 10:
			// ����1
			explainPanel.add(SystemManager.lvL("4", "normal", "�̳׶� \" 15 \" �̻� ����"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x1"));
			break;

		case 11:
			// ����2
			explainPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù� \" 5 \" �̻� ����"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x1"));
			break;

		case 12:
			// ���ι�
			explainPanel.add(SystemManager.lvL("2", "normal", "������x3"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("2", "normal", "�̳뽺��x3"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("1", "normal", "ź����x2"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x2"));
			break;

		case 13:
			// �л���
			explainPanel.add(SystemManager.lvL("1", "normal", "�Ϲ� ���� \" 60 \" ��� (�� ����)"));
			rewardPanel.add(SystemManager.lvL("4", "normal", "�̳׶�x15"));
			break;

		case 14:
			// �л���2
			explainPanel.add(SystemManager.lvL("1", "normal", "�Ź� ���� \" 45 \" ��� (�� ����)"));
			rewardPanel.add(SystemManager.lvL("4", "normal", "�̳׶�x20"));
			break;

		case 15:
			// �ͻ��
			explainPanel.add(SystemManager.lvL("2", "normal", "����Ÿx2"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("1", "normal", "����x4"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x1"));
			break;

		case 16:
			// ���ܹ� 300 x 294
			url = this.getClass().getClassLoader().getResource(imgUrl[0]);
			ImageIcon under1_icon = new ImageIcon(url), under1_updateIcon;
			Image under1_img = under1_icon.getImage();
			Image under1_updateImg = under1_img.getScaledInstance(300, 294, Image.SCALE_SMOOTH);
			under1_updateIcon = new ImageIcon(under1_updateImg);
			
			JLabel under1_imgLabel = new JLabel(under1_updateIcon);
			
			mainPanel.setBounds(0, 0, SystemManager.sideWindow_width, SystemManager.sideWindow_height + under_size); 					// ��ġ �� ũ��
			explainPanel.setBounds(0, 50, SystemManager.sideWindow_width, SystemManager.sideWindow_height - 50 + under_size); 		// ��ġ �� ũ��
			rewardPanel.setBounds(10, 100 + under_size, SystemManager.sideWindow_width - 20, SystemManager.sideWindow_height - 105); 	// ��ġ �� ũ��
			under1_imgLabel.setBorder(new LineBorder(Color.red, 1));
			
			explainPanel.add(under1_imgLabel);
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x1"));
			break;

		case 17:
			// ���ܹ�2 300 x 294
			url = this.getClass().getClassLoader().getResource(imgUrl[1]);
			ImageIcon under2_icon = new ImageIcon(url), under2_updateIcon;
			Image under2_img = under2_icon.getImage();
			Image under2_updateImg = under2_img.getScaledInstance(300, 294, Image.SCALE_SMOOTH);
			under2_updateIcon = new ImageIcon(under2_updateImg);
			
			JLabel under2_imgLabel = new JLabel(under2_updateIcon);
			
			mainPanel.setBounds(0, 0, SystemManager.sideWindow_width, SystemManager.sideWindow_height + under_size); // ��ġ �� ũ��
			explainPanel.setBounds(0, 50, SystemManager.sideWindow_width, SystemManager.sideWindow_height - 50 + under_size); // ũ��
			rewardPanel.setBounds(10, 100 + under_size, SystemManager.sideWindow_width - 20, SystemManager.sideWindow_height - 105); // ũ��
			under2_imgLabel.setBorder(new LineBorder(Color.red, 1));
			
			explainPanel.add(under2_imgLabel);
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x1"));
			break;

		case 18:
			// �̵���
			explainPanel.add(SystemManager.lvL("3", "normal", "�ٰ�x1"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("2", "normal", "�̳뽺��x2"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x2"));
			break;

		case 19:
			// ��û��
			explainPanel.add(SystemManager.lvL("1", "normal", "�ӹ� - [Q]�Ҵ���� 10�� (10���� ��) "));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x1"));
			break;

		case 20:
			// ��������
			explainPanel.add(SystemManager.lvL("2", "normal", "������x2"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("2", "normal", "�̳뽺��x2"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("2", "normal", "ī����x2"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("2", "normal", "�վ�x2"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("1", "normal", "ź����x2"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x4"));
			break;

		case 21:
			// ���ѻ�
			explainPanel.add(SystemManager.lvL("X", "normal", "ź����x1"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("X", "normal", "������x1"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("X", "normal", "�̳뽺��x1"));
			rewardPanel.add(SystemManager.lvL("2", "normal", "Lv2 �����ù�x1"));
			rewardPanel.add(SystemManager.lvL("H", "normal", "/"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x3"));
			break;

		case 22:
			// û����
			explainPanel.add(SystemManager.lvL("X", "normal", "����x1"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("X", "normal", "������x1"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("H", "normal", "������x1"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("H", "normal", "������x1"));
			rewardPanel.add(SystemManager.lvL("2", "normal", "Lv2 �����ù�x1"));
			rewardPanel.add(SystemManager.lvL("H", "normal", "/"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x3"));
			break;

		case 23:
			// ����ȸ��
			explainPanel.add(SystemManager.lvL("4", "normal", "All Lv4"));
			rewardPanel.add(SystemManager.lvL("3", "normal", "Lv3 �����ù�x1"));
			rewardPanel.add(SystemManager.lvL("H", "normal", "/"));
			rewardPanel.add(SystemManager.lvL("2", "normal", "Lv2 �����ù�x2"));
			break;

		case 24:
			// ����
			explainPanel.add(SystemManager.lvL("H", "normal", "All LvH "));
			rewardPanel.add(SystemManager.lvL("2", "normal", "Lv2 �����ù�x2"));
			rewardPanel.add(SystemManager.lvL("H", "normal", "/"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x3"));
			break;

		case 25:
			// ��������
			explainPanel.add(SystemManager.lvL("X", "normal", "����ġ��x1"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("X", "normal", "������x1"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("X", "normal", "�վ�x1"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("EH", "normal", "ȣŸ��x1"));
			rewardPanel.add(SystemManager.lvL("3", "normal", "Lv3 �����ù�x1"));
			rewardPanel.add(SystemManager.lvL("H", "normal", "/"));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv1 �����ù�x2"));
			break;

		case 26:
			// �Ǳ͸��
			explainPanel.add(SystemManager.lvL("X", "normal", "All LvX "));
			rewardPanel.add(SystemManager.lvL("1", "normal", "Lv3 �����ù�x2"));
			rewardPanel.add(SystemManager.lvL("H", "normal", "/"));
			rewardPanel.add(SystemManager.lvL("2", "normal", "Lv2 �����ù�x2"));
			rewardPanel.add(SystemManager.lvL("X", "normal", "�̳׶�x100 "));
			break;

		case 27:
			// ������
			explainPanel.add(SystemManager.lvL("Z", "normal", "All LvZ "));
			rewardPanel.add(SystemManager.lvL("3", "normal", "Lv3 �����ù�x2"));
			rewardPanel.add(SystemManager.lvL("H", "normal", "/"));
			rewardPanel.add(SystemManager.lvL("2", "normal", "Lv2 �����ù�x3"));
			break;

		case 28:
			// ����
			explainPanel.add(SystemManager.lvL("X", "normal", "�ٰ�x1"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("2", "normal", "������x2"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("2", "normal", "�̳뽺��x2"));
			explainPanel.add(SystemManager.Plus());
			explainPanel.add(SystemManager.lvL("1", "normal", "ź����x2 + ������x2"));
			rewardPanel.add(SystemManager.lvL("2", "normal", "Lv2 �����ù�x1"));
			break;
		}

		mainPanel.add(levelPanel);
		mainPanel.add(explainPanel);
		mainPanel.add(rewardPanel);
		add(mainPanel);

		// ���� ���� ���� ���� �� ���̱�
		if(number == 16 || number == 17)
			setSize(SystemManager.sideWindow_width, SystemManager.sideWindow_height + under_size);
		else
			setSize(SystemManager.sideWindow_width, SystemManager.sideWindow_height);
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
}
