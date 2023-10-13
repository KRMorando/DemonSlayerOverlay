package demon_slayer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AchivementSideWindow extends JFrame implements Runnable {
	ImportentValue impV = new ImportentValue();

	private JPanel mainPanel, levelPanel, explainPanel, rewardPanel;
	private String imgUrl[] = {	"./images/Achive/under_lamp1.png",
								"./images/Achive/under_lamp2.png" };

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
		impV.sideContainer = getRootPane().getContentPane();	// ���� �����̳� ��ü�� �ֱ����� ���

		setUndecorated(true);	// �׵θ� ����
		setResizable(false);	// ũ�� ���� ����

		mainPanel = new JPanel();
		levelPanel = new JPanel();
		explainPanel = new JPanel();
		rewardPanel = new JPanel();

		/* ���̵� �г� */
		setBackground(new Color(0, 0, 0, 0));
		mainPanel.setLayout(null);
		mainPanel.setBackground(impV.backColor); // ���� �г� ��
		mainPanel.setBorder(new LineBorder(Color.red, 2, true)); // �׵θ�
		mainPanel.setBounds(0, 0, impV.sideWindow_width, impV.sideWindow_height); // ��ġ �� ũ��

		/* ���� �г� */
		levelPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout(�߾� ��ġ)
		levelPanel.setBackground(new Color(0, 0, 0, 0)); // ����
		levelPanel.setBounds(0, 10, impV.sideWindow_width, impV.sideWindow_height - 50); // ũ��

		/* ���� �г� */
		explainPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout(�߾� ��ġ)
		explainPanel.setBackground(new Color(0, 0, 0, 0)); // ����
		explainPanel.setBounds(0, 50, impV.sideWindow_width, impV.sideWindow_height - 50); // ũ��

		/* ���� �г� */
		Border bf = BorderFactory.createTitledBorder(new LineBorder(Color.red, 1), "����", TitledBorder.LEFT, TitledBorder.TOP, impV.normalKostar, Color.white);
		rewardPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout(�߾� ��ġ)
		rewardPanel.setBorder(bf);
		rewardPanel.setBackground(new Color(0, 0, 0, 0)); // ����
		rewardPanel.setBounds(10, 100, impV.sideWindow_width - 20, impV.sideWindow_height - 105); // ũ��

		/* ���� �г� �߰� */
		levelPanel.add(impV.lv1("Lv1 "));
		levelPanel.add(impV.lv2("Lv2 "));
		levelPanel.add(impV.lv3("Lv3 "));
		levelPanel.add(impV.lv4("Lv4 "));
		levelPanel.add(impV.lvH("LvH "));
		levelPanel.add(impV.lvX("LvX "));
		levelPanel.add(impV.lvZ("LvZ"));

		switch (number) {
		case 0:
			// �ϱ�
			explainPanel.add(impV.lv1("ALL Lv1"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x1"));
			break;

		case 1:
			// �߱�
			explainPanel.add(impV.lv2("ALL Lv2"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x2"));
			break;

		case 2:
			// ���
			explainPanel.add(impV.lv3("ALL Lv3"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x3"));
			break;

		case 3:
			// ����
			explainPanel.add(impV.lv1("ź����x4 + ������x4"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x1"));
			break;

		case 4:
			// ����
			explainPanel.add(impV.lv1("���÷�x5 + ������x3"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x1"));
			break;

		case 5:
			// ����
			explainPanel.add(impV.lv2("ī����x3"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv1("�ƿ���x3"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x1"));
			break;

		case 6:
			// ���
			explainPanel.add(impV.lv2("�վ�x4"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("����Ÿx1"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x1"));
			break;

		case 7:
			// ����
			explainPanel.add(impV.lv3("��׹�x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("�վ�x2"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x2"));
			break;

		case 8:
			// ���
			explainPanel.add(impV.lv3("������x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv3("���ٳ���x1"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x2"));
			break;

		case 9:
			// ����
			explainPanel.add(impV.lv4("ī����x1"));
			explainPanel.add(impV.lv1(" (ù Lv4 ���տ� �����)"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x2"));
			break;

		case 10:
			// ����1
			explainPanel.add(impV.lv4("�̳׶� \" 15 \" �̻� ����"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x1"));
			break;

		case 11:
			// ����2
			explainPanel.add(impV.lv1("Lv1 �����ù� \" 5 \" �̻� ����"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x1"));
			break;

		case 12:
			// ���ι�
			explainPanel.add(impV.lv2("������x3"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("�̳뽺��x3"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv1("ź����x2"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x2"));
			break;

		case 13:
			// �л���
			explainPanel.add(impV.lv1("�Ϲ� ���� \" 60 \" ��� (�� ����)"));
			rewardPanel.add(impV.lv4("�̳׶�x15"));
			break;

		case 14:
			// �л���2
			explainPanel.add(impV.lv1("�Ź� ���� \" 45 \" ��� (�� ����)"));
			rewardPanel.add(impV.lv4("�̳׶�x20"));
			break;

		case 15:
			// �ͻ��
			explainPanel.add(impV.lv2("����Ÿx2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv1("����x4"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x1"));
			break;

		case 16:
			// ���ܹ� 300 x 294
			ImageIcon under1_icon = new ImageIcon(imgUrl[0]), under1_updateIcon;
			Image under1_img = under1_icon.getImage();
			Image under1_updateImg = under1_img.getScaledInstance(300, 294, Image.SCALE_SMOOTH);
			under1_updateIcon = new ImageIcon(under1_updateImg);
			
			JLabel under1_imgLabel = new JLabel(under1_updateIcon);
			
			mainPanel.setBounds(0, 0, impV.sideWindow_width, impV.sideWindow_height + under_size); 					// ��ġ �� ũ��
			explainPanel.setBounds(0, 50, impV.sideWindow_width, impV.sideWindow_height - 50 + under_size); 		// ��ġ �� ũ��
			rewardPanel.setBounds(10, 100 + under_size, impV.sideWindow_width - 20, impV.sideWindow_height - 105); 	// ��ġ �� ũ��
			under1_imgLabel.setBorder(new LineBorder(Color.red, 1));
			
			explainPanel.add(under1_imgLabel);
			rewardPanel.add(impV.lv1("Lv1 �����ù�x1"));
			break;

		case 17:
			// ���ܹ�2 300 x 294
			ImageIcon under2_icon = new ImageIcon(imgUrl[1]), under2_updateIcon;
			Image under2_img = under2_icon.getImage();
			Image under2_updateImg = under2_img.getScaledInstance(300, 294, Image.SCALE_SMOOTH);
			under2_updateIcon = new ImageIcon(under2_updateImg);
			
			JLabel under2_imgLabel = new JLabel(under2_updateIcon);
			
			mainPanel.setBounds(0, 0, impV.sideWindow_width, impV.sideWindow_height + under_size); // ��ġ �� ũ��
			explainPanel.setBounds(0, 50, impV.sideWindow_width, impV.sideWindow_height - 50 + under_size); // ũ��
			rewardPanel.setBounds(10, 100 + under_size, impV.sideWindow_width - 20, impV.sideWindow_height - 105); // ũ��
			under2_imgLabel.setBorder(new LineBorder(Color.red, 1));
			
			explainPanel.add(under2_imgLabel);
			rewardPanel.add(impV.lv1("Lv1 �����ù�x1"));
			break;

		case 18:
			// �̵���
			explainPanel.add(impV.lv3("�ٰ�x1"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("�̳뽺��x2"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x2"));
			break;

		case 19:
			// ��û��
			explainPanel.add(impV.lv1("�ӹ� - [Q]�Ҵ���� 10�� (10���� ��)"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x1"));
			break;

		case 20:
			// ��������
			explainPanel.add(impV.lv2("������x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("�̳뽺��x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("ī����x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("�վ�x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv1("ź����x2"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x4"));
			break;

		case 21:
			// ���ѻ�
			explainPanel.add(impV.lvX("ź����x1"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lvX("������x1"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lvX("�̳뽺��x1"));
			rewardPanel.add(impV.lv1("Lv2 �����ù�x1"));
			rewardPanel.add(impV.lvH("/"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x3"));
			break;

		case 22:
			// û����
			explainPanel.add(impV.lvX("����x1"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lvX("������x1"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lvH("������x1"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lvH("�����x1"));
			rewardPanel.add(impV.lv1("Lv2 �����ù�x1"));
			rewardPanel.add(impV.lvH("/"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x3"));
			break;

		case 23:
			// ����ȸ��
			explainPanel.add(impV.lv4("All Lv4"));
			rewardPanel.add(impV.lv1("Lv3 �����ù�x1"));
			rewardPanel.add(impV.lvH("/"));
			rewardPanel.add(impV.lv1("Lv2 �����ù�x2"));
			break;

		case 24:
			// ����
			explainPanel.add(impV.lvH("All H"));
			rewardPanel.add(impV.lv1("Lv2 �����ù�x2"));
			rewardPanel.add(impV.lvH("/"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x3"));
			break;

		case 25:
			// ��������
			explainPanel.add(impV.lvX("����ġ��x1"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lvX("������x1"));
			rewardPanel.add(impV.lv1("Lv2 �����ù�x1"));
			rewardPanel.add(impV.lvH("/"));
			rewardPanel.add(impV.lv1("Lv1 �����ù�x2"));
			break;

		case 26:
			// �Ǳ͸��
			explainPanel.add(impV.lvX("All LvX"));
			rewardPanel.add(impV.lv1("Lv3 �����ù�x2"));
			rewardPanel.add(impV.lvH("/"));
			rewardPanel.add(impV.lv1("Lv2 �����ù�x2"));
			rewardPanel.add(impV.lvX("�̳׶�x100"));
			break;

		case 27:
			// ������
			explainPanel.add(impV.lvZ("All LvZ"));
			rewardPanel.add(impV.lv1("Lv3 �����ù�x2"));
			rewardPanel.add(impV.lvH("/"));
			rewardPanel.add(impV.lv1("Lv2 �����ù�x3"));
			break;

		case 28:
			// ����
			explainPanel.add(impV.lvX("�ٰ�x1"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("������x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv2("�̳뽺��x2"));
			explainPanel.add(impV.plus());
			explainPanel.add(impV.lv1("ź����x2 + ������x2"));
			rewardPanel.add(impV.lv1("Lv2 �����ù�x1"));
			break;
		}

		mainPanel.add(levelPanel);
		mainPanel.add(explainPanel);
		mainPanel.add(rewardPanel);
		add(mainPanel);

		setAlwaysOnTop(true); 							// �׻� ���� ���̱�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// ������ ����� javax�� ����

		// ���� ���� ���� ���� �� ���̱�
		if(number == 16 || number == 17)
			setSize(impV.sideWindow_width, impV.sideWindow_height + under_size);
		else
			setSize(impV.sideWindow_width, impV.sideWindow_height);
		setLocation(impV.screenSize.width - impV.window_width - impV.sideWindow_width - 8, 50);
		setVisible(true);

		try {
			Thread.sleep(impV.cooltime * 1000);
			runningThread = null;
			impV.sideContainer = null;
			setVisible(false);
		} catch (InterruptedException e) {
			setVisible(false);
		}
	}
}
