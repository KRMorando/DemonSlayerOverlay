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

	ImportentValue impV = new ImportentValue(); // 임폴 밸류 추가 객체

	private String[] buttonName = {	"하급", "중급", "상급",
									"유대", "오니", "나비",
									"사격", "형제", "사랑",
									"가문", "적금", "적금2",
									"삼인방", "학살자", "학살자2",
									"귀살대", "등잔밑", "등잔밑2",
									"이도류", "멍청이", "최종선별",
									"삼총사", "청출어람", "주합회의",
									"퍼즐", "대장장이", "악귀멸살",
									"레전드", "잠입" };

	private int gridX = 0; // 좌우
	private int gridY = 0; // 상하

	public AchivementWindow() {
		impV.activeContainer = getRootPane().getContentPane();	//현재 활성화된 컨테이너 저장
		
		setUndecorated(true); // 테두리 삭제
		setResizable(false); // 크기 조절 여부

		btn = new JButton[29];
		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		backButton = new JButton();

		/* 메인 패널 */
		setBackground(new Color(0, 0, 0, 0)); // 컨테이너 공백
		mainPanel.setLayout(null);
		mainPanel.setBackground(impV.backColor); // 메인 패널 색
		mainPanel.setBorder(new LineBorder(Color.red, 2, true));
		mainPanel.setBounds(0, 0, impV.window_width, impV.window_height);
		
		/* 제목 */
		titleLabel = new JLabel();
		titleLabel.setText("업적");
		titleLabel.setFont(impV.titleKostar);
		titleLabel.setBackground(new Color(0, 0, 0, 0));
		titleLabel.setForeground(Color.GREEN);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBounds(0, 0, impV.window_width, 120);
		
		/* 버튼 패널 */
		buttonPanel.setLayout(gbl);
		buttonPanel.setBackground(new Color(0, 0, 0, 0)); // 버튼 패널 색
		buttonPanel.setBounds(0, 30, impV.window_width, impV.window_height - 40);

		/* 버튼 추가 */
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton();

			/* 전체 적용 */
			btn[i].setText(buttonName[i]); // 글씨 적용
			btn[i].setFont(impV.normalKostar); // 폰트 적용
			btn[i].setBackground(new Color(0, 0, 0, 0)); // 배경색
			btn[i].setPreferredSize(new Dimension(115, 40)); // 크기 설정
			btn[i].setBorderPainted(false); // 테두리 없음
			btn[i].setFocusPainted(false); // 선택 됐을 때 생기는 테두리 없애기
			
			/* 글씨 색상 적용 */
			if (i < 21) {
				btn[i].setForeground(Color.white); // 하급 ~ 최종선별
			} else {
				btn[i].setForeground(Color.RED); // 삼총사 ~ 악귀멸살
			}

			if (i == 27) {
				btn[i].setForeground(Color.orange); // 레전드
			}
			if (i == 28) {
				btn[i].setForeground(new Color(0, 220, 220)); // 잠입
			}
			
			/*	버튼 마우스 인식	*/
			btn[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
					repaint();
				}
			});
			
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					repaint();
				}
			});
			
			/*	버튼 기능 구현	*/
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
			
			/* 버튼 추가 */
			GblInsert(gbl, buttonPanel, btn[i], gridX, gridY, 1, 1);
			if (((i + 1) % 3) == 0) {
				gridY++;
				gridX = 0;
			} else {
				gridX++;
			}
		}

		/* 뒤로가기 버튼 */
		backButton.setText("뒤로가기"); // 글씨 적용
		backButton.setFont(new Font("Kostar", Font.PLAIN, 18)); // 폰트 적용
		backButton.setBackground(new Color(0, 0, 0, 0)); // 배경색
		backButton.setForeground(Color.GREEN); // 글씨색
		backButton.setBorder(BorderFactory.createLineBorder(Color.RED, 1, true)); // 테두리
		backButton.setFocusPainted(false); // 선택 됐을 때 생기는 테두리 없애기
		backButton.setBounds(80, impV.window_height - 55, 190, 30);

		/* 뒤로가기 버튼 기능 구현 */
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
		
		/*	버튼 마우스 인식	*/
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});

		mainPanel.add(titleLabel);
		mainPanel.add(buttonPanel);
		mainPanel.add(backButton);
		add(mainPanel);

		setAlwaysOnTop(true); // 항상 위에 보이기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우 종료시 javax도 종료

		// 가로 세로 길이 지정 및 보이기
		setSize(impV.window_width, impV.window_height);
		setLocation(impV.screenSize.width - impV.window_width - 10, 50);
		setVisible(true);
	}

	// GbInsert (그리드백, 패널, 컴포넌트, x, y, 좌우, 높낮이);
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
