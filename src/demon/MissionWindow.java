package demon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MissionWindow extends JFrame {
	ImportentValue impV = new ImportentValue();
	
	private JPanel mainPanel, buttonPanel;
	private JLabel titleLabel;
	private JButton btn[], backButton;
	
	private String buttonName[] = {"�븻", "�ϵ�"};
	
	public MissionWindow() {
		impV.activeContainer = this;	//���� Ȱ��ȭ�� �����̳� ����
		
		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		titleLabel = new JLabel();
		backButton = new JButton();
		btn = new JButton[2];
		
		setUndecorated(true); 	// �׵θ� ����
		setResizable(false); 	// ũ�� ���� ����
		
		setBackground(new Color(0, 0, 0, 0)); 											// �����̳� ����
		
		/*	���� �г�	*/
		mainPanel.setLayout(null);
		mainPanel.setBackground(impV.backColor); 										// ���� �г� ��
		mainPanel.setBorder(new LineBorder(Color.red, 2, true));
		mainPanel.setBounds(0, 0, impV.window_width, impV.window_height);				//350, 600 (width, heigth)
		
		/*	Ÿ��Ʋ ��	*/
		titleLabel.setText("���̵�");
		titleLabel.setFont(impV.titleKostar);
		titleLabel.setBackground(new Color(0, 0, 0, 0));								//�� ����
		titleLabel.setForeground(Color.GREEN);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBounds(0, 0, impV.window_width, 120);								//�� ��ġ �� ũ�� (x, y, width, height)
		
		/* ��ư �г� */
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
		buttonPanel.setBackground(new Color(0, 0, 0, 0)); // ��ư �г� ��
		buttonPanel.setBounds(0, 100, impV.window_width, impV.window_height - 40);
		
		/*	��ư	*/
		for(int i = 0; i < btn.length; i++) {
			btn[i] = new JButton();
			
			/* ��ü ���� */
			btn[i].setText(buttonName[i]);							//�ؽ�Ʈ ����
			btn[i].setFont(impV.normalKostar);		//��Ʈ ����
			btn[i].setBackground(new Color(0, 0, 0)); 			//����
			btn[i].setPreferredSize(new Dimension(200, 40)); 		//ũ�� ����
			btn[i].setBorder(new LineBorder(Color.red, 1, true));	//�׵θ�
			btn[i].setFocusPainted(false); 							//���� ���� �� ����� �׵θ� ���ֱ�
			
			/*	��ư ���콺 �ν�	*/
			btn[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
					repaint();
				}
			});
			
			/*	��ư ���	*/
			switch(i) {
			case 0:
				btn[i].setForeground(Color.white);		//�۾� ����
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new MissionSelectWindow(buttonName[0]);
						dispose();
					}
				});
				break;
				
			case 1:
				btn[i].setForeground(Color.red);		//�۾� ����
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new MissionSelectWindow(buttonName[1]);
						dispose();
					}
				});
				break;
			}
			
			buttonPanel.add(btn[i]);
		}
		
		/* �ڷΰ��� ��ư */
		backButton.setText("�ڷΰ���"); // �۾� ����
		backButton.setFont(new Font("Kostar", Font.PLAIN, 18)); // ��Ʈ ����
		backButton.setBackground(new Color(0, 0, 0, 0)); // ����
		backButton.setForeground(Color.GREEN); // �۾���
		backButton.setBorder(BorderFactory.createLineBorder(Color.RED, 1, true)); // �׵θ�
		backButton.setFocusPainted(false); // ���� ���� �� ����� �׵θ� ���ֱ�
		backButton.setBounds(80, impV.window_height - 55, 190, 30);

		/* �ڷΰ��� ��ư ��� ���� */
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainWindow();
				dispose();
			}
		});
		
		/*	��ư ���콺 �ν�	*/
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
				repaint();
			}
		});
		
		mainPanel.add(titleLabel);
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
}
