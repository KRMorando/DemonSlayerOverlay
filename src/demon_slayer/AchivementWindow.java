package demon_slayer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

public class AchivementWindow extends JFrame {
	private GridBagLayout gbl = new GridBagLayout();
	private JPanel mainPanel, buttonPanel;
	private JLabel titleLabel;
	private JButton[] btn;
	private JButton backButton;

	ImportentValue impV = new ImportentValue(); // ���� ��� �߰� ��ü

	private String[] buttonName = {	"�ϱ�", "�߱�", "���",
									"����", "����", "����",
									"���", "����", "���",
									"����", "����", "����2",
									"���ι�", "�л���", "�л���2",
									"�ͻ��", "���ܹ�", "���ܹ�2",
									"�̵���", "��û��", "��������",
									"���ѻ�", "û����", "����ȸ��",
									"����", "��������", "�Ǳ͸��",
									"������", "����" };

	private int gridX = 0; // �¿�
	private int gridY = 0; // ����

	public AchivementWindow() {
		impV.activeContainer = getRootPane().getContentPane();	//���� Ȱ��ȭ�� �����̳� ����
		
		setUndecorated(true); // �׵θ� ����
		setResizable(false); // ũ�� ���� ����

		btn = new JButton[29];
		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		backButton = new JButton();

		/* ���� �г� */
		setBackground(new Color(0, 0, 0, 0)); // �����̳� ����
		mainPanel.setLayout(null);
		mainPanel.setBackground(impV.backColor); // ���� �г� ��
		mainPanel.setBorder(new LineBorder(Color.red, 2, true));
		mainPanel.setBounds(0, 0, impV.window_width, impV.window_height);
		
		/* ���� */
		titleLabel = new JLabel();
		titleLabel.setText("����");
		titleLabel.setFont(impV.titleKostar);
		titleLabel.setBackground(new Color(0, 0, 0, 0));
		titleLabel.setForeground(Color.GREEN);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBounds(0, 0, impV.window_width, 120);
		
		/* ��ư �г� */
		buttonPanel.setLayout(gbl);
		buttonPanel.setBackground(new Color(0, 0, 0, 0)); // ��ư �г� ��
		buttonPanel.setBounds(0, 30, impV.window_width, impV.window_height - 40);

		/* ��ư �߰� */
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton();

			/* ��ü ���� */
			btn[i].setText(buttonName[i]); // �۾� ����
			btn[i].setFont(impV.normalKostar); // ��Ʈ ����
			btn[i].setBackground(new Color(0, 0, 0, 0)); // ����
			btn[i].setPreferredSize(new Dimension(115, 40)); // ũ�� ����
			btn[i].setBorderPainted(false); // �׵θ� ����
			btn[i].setFocusPainted(false); // ���� ���� �� ����� �׵θ� ���ֱ�
			
			/* �۾� ���� ���� */
			if (i < 21) {
				btn[i].setForeground(Color.white); // �ϱ� ~ ��������
			} else {
				btn[i].setForeground(Color.RED); // ���ѻ� ~ �Ǳ͸��
			}

			if (i == 27) {
				btn[i].setForeground(Color.orange); // ������
			}
			if (i == 28) {
				btn[i].setForeground(new Color(0, 220, 220)); // ����
			}
			
			/*	��ư ���콺 �ν�	*/
			btn[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
					repaint();
				}
			});
			
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					repaint();
				}
			});
			
			/*	��ư ��� ����	*/
			switch(i) {
			case 0:
				btn[i].addActionListener(new ActionListener() {
					@Override
	                public void actionPerformed(ActionEvent e) {
						Thread sideWindow = new Thread(new AchivementSideWindow(0));
						sideWindow.start();
	                }
	            });
				break;
				
			case 1:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(1));
						sideWindow.start();
	                }
	            });
				break;
				
			case 2:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(2));
						sideWindow.start();
	                }
	            });
				break;
				
			case 3:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(3));
						sideWindow.start();
	                }
	            });
				break;
				
			case 4:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(4));
						sideWindow.start();
	                }
	            });
				break;
				
			case 5:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(5));
						sideWindow.start();
	                }
	            });
				break;
				
			case 6:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(6));
						sideWindow.start();
	                }
	            });
				break;
				
			case 7:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(7));
						sideWindow.start();
	                }
	            });
				break;
				
			case 8:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(8));
						sideWindow.start();
	                }
	            });
				break;
				
			case 9:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(9));
						sideWindow.start();
	                }
	            });
				break;
				
			case 10:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(10));
						sideWindow.start();
	                }
	            });
				break;
				
			case 11:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(11));
						sideWindow.start();
	                }
	            });
				break;
				
			case 12:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(12));
						sideWindow.start();
	                }
	            });
				break;
				
			case 13:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(13));
						sideWindow.start();
	                }
	            });
				break;
				
			case 14:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(14));
						sideWindow.start();
	                }
	            });
				break;
				
			case 15:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(15));
						sideWindow.start();
	                }
	            });
				break;
				
			case 16:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(16));
						sideWindow.start();
	                }
	            });
				break;
				
			case 17:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(17));
						sideWindow.start();
	                }
	            });
				break;
				
			case 18:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(18));
						sideWindow.start();
	                }
	            });
				break;
				
			case 19:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(19));
						sideWindow.start();
	                }
	            });
				break;
				
			case 20:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(20));
						sideWindow.start();
	                }
	            });
				break;
				
			case 21:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(21));
						sideWindow.start();
	                }
	            });
				break;
				
			case 22:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(22));
						sideWindow.start();
	                }
	            });
				break;
				
			case 23:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(23));
						sideWindow.start();
	                }
	            });
				break;
				
			case 24:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(24));
						sideWindow.start();
	                }
	            });
				break;
				
			case 25:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(25));
						sideWindow.start();
	                }
	            });
				break;
				
			case 26:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(26));
						sideWindow.start();
	                }
	            });
				break;
				
			case 27:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(27));
						sideWindow.start();
	                }
	            });
				break;
				
			case 28:
				btn[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	Thread sideWindow = new Thread(new AchivementSideWindow(28));
						sideWindow.start();
	                }
	            });
				break;
			}
			
			/* ��ư �߰� */
			GblInsert(gbl, buttonPanel, btn[i], gridX, gridY, 1, 1);
			if (((i + 1) % 3) == 0) {
				gridY++;
				gridX = 0;
			} else {
				gridX++;
			}
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
				if(impV.sideContainer != null) {
					impV.sideContainer.setVisible(false);
					impV.sideContainer = null;
				}
				new MainWindow();
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

	// GbInsert (�׸����, �г�, ������Ʈ, x, y, �¿�, ������);
	protected void GblInsert(GridBagLayout gbl, JPanel panel, Component c, int x, int y, int w, int h) {
		GridBagConstraints gblc = new GridBagConstraints();

		gblc.fill = GridBagConstraints.NONE;
		gblc.gridx = x;
		gblc.gridy = y;
		gblc.gridwidth = w;
		gblc.gridheight = h;
		gblc.anchor = GridBagConstraints.CENTER;
		gblc.insets = new Insets(0, 0, 0, 0);
		gbl.setConstraints(c, gblc);
		panel.add(c);
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(new Color(0, 0, 0, 0));
	}
}
