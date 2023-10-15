package demon_slayer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainWindow extends JFrame {
	ImportentValue impV = new ImportentValue();

	private GridBagLayout gbl;
	private JPanel mainPanel;
	private JLabel madeLabel;

	public MainWindow() {
		impV.activeContainer = getRootPane().getContentPane();	//���� Ȱ��ȭ�� �����̳� ����
		
		setUndecorated(true); // �׵θ� ����
		setResizable(false); // ũ�� ���� ����

		JButton[] btn = new JButton[6];
		String[] buttonName = { "����", "����", "�ӹ�", "ī��", "����", "����" };

		gbl = new GridBagLayout();
		mainPanel = new JPanel();

		setBackground(new Color(0, 0, 0, 0)); // �����̳� ����
		mainPanel.setLayout(gbl);
		mainPanel.setBackground(impV.backColor); // ���� �г� ��
		mainPanel.setBorder(new LineBorder(Color.red, 2, true));

		// ��ư ���� �� �߰�
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton();

			/* ��ü ���� */
			btn[i].setText(buttonName[i]); // �۾� ����
			btn[i].setFont(impV.normalKostar); // ��Ʈ ����
			btn[i].setForeground(Color.GREEN); // �۾� ���� ����
			btn[i].setBackground(new Color(0, 0, 0));
			btn[i].setBorder(BorderFactory.createLineBorder(Color.RED, 1, true)); // �׵θ� ����
			btn[i].setPreferredSize(new Dimension(200, 40)); // ũ�� ����
			btn[i].setFocusPainted(false); // ���� ���� �� ����� �׵θ� ���ֱ�

			/* ��ư ���� */
			Insert(gbl, mainPanel, btn[i], 1, i, 2, 1);

			/* ���� ��ư(0) */
			switch (i) {
			case 0:
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new AchivementWindow();
						setVisible(false);
					}
				});
				break;

			/* ���� ��ư(1) */
			case 1:
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new CombinationWindow();
						setVisible(false);
					}
				});
				break;

			/* �ӹ� ��ư(2) */
			case 2:
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new MissionWindow();
						setVisible(false);
					}
				});
				break;

			/* ī�� ��ư(3) */
			case 3:
				// ���α׷� ���� ��ư
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Desktop desktop = Desktop.getDesktop();
						try {
							URI uri = new URI("https://cafe.naver.com/feer95");
							desktop.browse(uri);
						} catch (IOException ex) {
							ex.printStackTrace();
						} catch (URISyntaxException ex) {
							ex.printStackTrace();
						}
					}
				});
				break;

			/* ���� ��ư(4) */
			case 4:
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new SettingWindow();
						setVisible(false);
					}
				});
				break;

			/* ���� ��ư(5) */
			case 5:
				// ���α׷� ���� ��ư
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				break;
			}
		}

		madeLabel = new JLabel();
		madeLabel.setText("Made by Morando");
		madeLabel.setFont(new Font("Kostar", Font.ITALIC, 15));
		madeLabel.setForeground(Color.GREEN);
		Insert(gbl, mainPanel, madeLabel, 1, 6, 2, 1);

		add(mainPanel);

		setAlwaysOnTop(true); // �׻� ���� ���̱�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ ����� javax�� ����

		setSize(impV.window_width, impV.window_height);
		setLocation(impV.screenSize.width - impV.window_width - 10, 50);
		setVisible(true);
	}
	
	//Insert (�׸����, �г�, ������Ʈ, x, y, �¿�, ������);
	public void Insert(GridBagLayout gbl, JPanel panel, Component c, int x, int y, int w, int h) {
		GridBagConstraints gblc = new GridBagConstraints();
		
		gblc.fill = GridBagConstraints.VERTICAL;
		gblc.gridx = x;
		gblc.gridy = y;
		gblc.gridwidth = w;
		gblc.gridheight = h;
		gblc.insets = new Insets(40, 0, 0, 0);
		gbl.setConstraints(c, gblc);
		panel.add(c);
	}
}