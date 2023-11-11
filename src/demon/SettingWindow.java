package demon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingWindow extends JFrame {
	ImportentValue impV = new ImportentValue();	//임폴 밸류 추가 객체
	
	private GridBagLayout gbl;
	private JPanel mainPanel, durationPanel, gammaPanel;
	private JLabel titleLabel, durationText;
	private JSlider gammaSlider;
	private JButton btn[], decBtn, incBtn;
	
	private int gamma = impV.gamma;
	
	public SettingWindow() {
		impV.activeContainer = this;	//현재 활성화된 컨테이너 저장
		
        btn = new JButton[2];
        String[] buttonName = {"적용", "뒤로가기"};
        
        gbl = new GridBagLayout();
        mainPanel = new MainPanel(gbl);
        durationPanel = new JPanel();
        gammaPanel = new JPanel();
        durationText = new JLabel();
        decBtn = new JButton();
        incBtn = new JButton();
        
        /*	메인 프레임	*/
        impV.FrameSetting(this);
        
        /*	제목	*/
        titleLabel = new JLabel();
        titleLabel.setText("설정");
        titleLabel.setFont(impV.titleTTF);
        titleLabel.setForeground(Color.GREEN);
        
        /*	창 지속 시간	*/
        Border bf = BorderFactory.createTitledBorder(new LineBorder(Color.white, 1), "창 지속 시간", TitledBorder.CENTER, TitledBorder.TOP, impV.normalTTF, Color.white);
        durationPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        durationPanel.setBorder(bf);
		durationPanel.setBackground(new Color(0, 0, 0, 0)); // 배경색
		durationPanel.setSize(240, 60);
        
        /*	창 지속 시간 (감소)		*/
        decBtn.setText("-");
        decBtn.setForeground(Color.red);
        decBtn.setFont(new Font(impV.ttf, Font.PLAIN, 35));
        decBtn.setBackground(new Color(0, 0, 0, 0));
        decBtn.setPreferredSize(new Dimension(60, 60));
        decBtn.setFocusPainted(false);
        decBtn.setBorderPainted(false); // 테두리 없음
        decBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(impV.cooltime > 1)
            		impV.cooltime--;
            	durationText.setText(impV.cooltime + "초");
            	repaint();
            }
        });
		decBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	//마우스가 누르는 순간
				repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});
        
        /*	창 지속 시간 (텍스트)	*/
        durationText = new JLabel();
        durationText.setText(impV.cooltime + "초");
        durationText.setFont(impV.normalTTF);
        durationText.setForeground(Color.GREEN);
        durationText.setSize(120, 60);
        
        /*	창 지속 시간 (증가)		*/
        incBtn.setText("+");
        incBtn.setForeground(Color.CYAN);
        incBtn.setFont(new Font(impV.ttf, Font.PLAIN, 25));
        incBtn.setBackground(new Color(0, 0, 0, 0));
        incBtn.setPreferredSize(new Dimension(60, 60));
        incBtn.setFocusPainted(false);
        incBtn.setBorderPainted(false); // 테두리 없음
        incBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	impV.cooltime++;
            	durationText.setText(impV.cooltime + "초");
            	repaint();
            }
        });
        incBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	//마우스가 누르는 순간
				repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});
        
        durationPanel.add(decBtn);
        durationPanel.add(durationText);
        durationPanel.add(incBtn);
        
        /*	투명도	*/
        Border bl = BorderFactory.createTitledBorder(new LineBorder(Color.white, 1), "배경 투명도", TitledBorder.CENTER, TitledBorder.TOP, impV.normalTTF, Color.white);
        gammaPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        gammaPanel.setBorder(bl);
        gammaPanel.setBackground(new Color(0, 0, 0, 0)); // 배경색
        gammaPanel.setSize(220, 40);
		
        /*	슬라이더바		*/
        gammaSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, impV.gamma);
        gammaSlider.setMinorTickSpacing(25);
        gammaSlider.setMajorTickSpacing(50);
        gammaSlider.setPaintTicks(true);
        gammaSlider.setPaintLabels(true);
        gammaSlider.setBackground(new Color(0, 0, 0, 0));
        gammaSlider.setForeground(Color.GREEN);
        gammaSlider.setSize(new Dimension(200, 40));
        
        /*	슬라이더 기능 구현	*/
        gammaSlider.addChangeListener(new ChangeListener() {
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		if(!gammaSlider.getValueIsAdjusting()) {
        			//슬라이더 값에 따라 감마 조절
        			gamma = (int) gammaSlider.getValue();
        			mainPanel.setBackground(new Color(0, 0, 0, gamma));
        			repaint();
        		}
        	}
        });
        
        gammaPanel.add(gammaSlider);
        
        /*	버튼 추가	*/
        for(int i = 0; i < btn.length; i++) {
        	btn[i] = new JButton();
        	
        	/*	전체 적용	*/
        	btn[i].setText(buttonName[i]);			//글씨 적용
            btn[i].setFont(impV.normalTTF);		//폰트 적용
            btn[i].setForeground(Color.GREEN);		//글씨 색상 적용
            btn[i].setBackground(new Color(0, 0, 0));
            btn[i].setBorder(BorderFactory.createLineBorder(Color.RED, 1, true));	//테두리 설정
            btn[i].setPreferredSize(new Dimension(200, 40));			//크기 설정
            btn[i].setFocusPainted(false);
            
        	/*	적용 버튼(0)	*/
        	if(i == 0) {
        		btn[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	impV.gamma = gamma;
                    	new MainWindow();
                    	dispose();
                    }
                });
        	}
            
            /*	뒤로가기 버튼(1)	*/
        	if(i == 1) {
        		btn[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	new MainWindow();
                    	dispose();
                    }
                });
        	}
        	
        	/*	버튼 마우스 인식	*/
    		btn[i].addMouseListener(new MouseAdapter() {
    			@Override
    			public void mousePressed(MouseEvent e) {	//마우스가 누르는 순간
    				repaint();
    			}
    			
    			@Override
    			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
    				repaint();
    			}
    		});
    		Insert(gbl, mainPanel, btn[i], 0, (i+3), 2, 1);
        }
        
        Insert(gbl, mainPanel, titleLabel, 0, 0, 2, 1);
        Insert(gbl, mainPanel, durationPanel, 0, 1, 2, 1);
        Insert(gbl, mainPanel, gammaPanel, 0, 2, 2, 1);
        add(mainPanel);
        
     	//가로 세로 길이 지정 및 보이기
        setSize(impV.window_width, impV.window_height);
        setLocation(impV.screenSize.width - impV.window_width - 10, 50);
        setVisible(true);
        
        repaint();
        
        //openProgram();
	}
	
//	//프로그램 열기
//	private void openProgram() {
//		try {
//            // 실행할 외부 프로그램의 경로와 인자를 설정합니다.
//            String programPath = "./Gamma.exe";
//
//            // 프로세스 빌더를 생성하고 외부 프로그램을 실행합니다.
//            ProcessBuilder processBuilder = new ProcessBuilder(programPath);
//
//            // 프로세스를 시작합니다.
//            Process process = processBuilder.start();
//
//            // 프로세스의 종료를 대기합니다.
//            int exitCode = process.waitFor();
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//	}
	
	//Insert (그리드백, 패널, 컴포넌트, x, y, 좌우, 높낮이);
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
	
	protected void paintComponent(Graphics g) {
		g.setColor(impV.backColor);
	}
}