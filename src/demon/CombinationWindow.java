package demon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CombinationWindow extends JFrame {
	private JPanel mainPanel, buttonPanel;
	private JLabel titleLabel;
	private JButton btn[], backButton;
	
	private String buttonName[] = {"H", "EH", "X", "Z", "SZ"};

	public CombinationWindow() {
		SystemManager.activeContainer = this;	//���� Ȱ��ȭ�� �����̳� ����
		
		mainPanel = new MainPanel();
		buttonPanel = new JPanel();
		titleLabel = new JLabel();
		btn = new JButton[buttonName.length];
		backButton = new BackButton(this, "Main");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
				repaint();
			}
		});
		
		/*	���� ������	*/
	SystemManager.FrameSetting(this);
		
		/*	Ÿ��Ʋ ��	*/
		titleLabel.setText("����");
		titleLabel.setFont(SystemManager.titleTTF);
		titleLabel.setBackground(new Color(0, 0, 0, 0));								//�� ����
		titleLabel.setForeground(Color.GREEN);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBounds(0, 0, SystemManager.window_width, 120);								//�� ��ġ �� ũ�� (x, y, width, height)
		
		/* ��ư �г� */
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBackground(new Color(0, 0, 0, 0)); // ��ư �г� ��
		buttonPanel.setBounds(0, 100, SystemManager.window_width, SystemManager.window_height - 40);
		
		for(int i = 0; i < btn.length; i++) {
			btn[i] = new JButton();
			
			/* ��ü ���� */
			btn[i].setText(buttonName[i]);							//�ؽ�Ʈ ����
			btn[i].setFont(new Font(SystemManager.ttf, Font.PLAIN, 35));		//��Ʈ ����
			btn[i].setBackground(new Color(0, 0, 0)); 			//����
			btn[i].setPreferredSize(new Dimension(100, 100)); 		//ũ�� ����
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
				btn[i].setForeground(SystemManager.HColor);		//�۾� ����
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new CombinationSelectWindow(buttonName[0]);
						dispose();
					}
				});
				break;
				
			case 1:
				btn[i].setForeground(SystemManager.EHColor);		//�۾� ����
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new CombinationSelectWindow(buttonName[1]);
						dispose();
					}
				});
				break;
				
			case 2:
				btn[i].setForeground(SystemManager.XColor);		//�۾� ����
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new CombinationSelectWindow(buttonName[2]);
						dispose();
					}
				});
				break;
				
			case 3:
				btn[i].setForeground(SystemManager.ZColor);		//�۾� ����
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new CombinationSelectWindow(buttonName[3]);
						dispose();
					}
				});
				break;
				
			case 4:
				btn[i].setForeground(SystemManager.SZColor);		//�۾� ����
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new CombinationSelectWindow(buttonName[4]);
						dispose();
					}
				});
				break;
			}
			
			buttonPanel.add(btn[i]);
		}
		
		mainPanel.add(titleLabel);
		mainPanel.add(buttonPanel);
		mainPanel.add(backButton);
		add(mainPanel);
		
		// ���� ���� ���� ���� �� ���̱�
		setSize(SystemManager.window_width, SystemManager.window_height);
		setLocation(SystemManager.screenSize.width - SystemManager.window_width - 10, 50);
		setVisible(true);
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(new Color(0, 0, 0, 0));
	}
}
