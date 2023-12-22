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
	private GridBagLayout gbl;
	private JPanel mainPanel, durationPanel, gammaPanel;
	private JLabel titleLabel, durationText;
	private JSlider gammaSlider;
	private JButton btn[], decBtn, incBtn;
	private int gamma = SystemManager.gamma;
	
	public SettingWindow() {
		SystemManager.activeContainer = this;	//���� Ȱ��ȭ�� �����̳� ����
		
        btn = new JButton[2];
        String[] buttonName = {"����", "�ڷΰ���"};
        
        gbl = new GridBagLayout();
        mainPanel = new MainPanel(gbl);
        durationPanel = new JPanel();
        gammaPanel = new JPanel();
        durationText = new JLabel();
        decBtn = new JButton();
        incBtn = new JButton();
        
        /*	���� ������	*/
        SystemManager.FrameSetting(this);
        
        /*	����	*/
        titleLabel = new JLabel();
        titleLabel.setText("����");
        titleLabel.setFont(SystemManager.titleTTF);
        titleLabel.setForeground(Color.GREEN);
        
        /*	â ���� �ð�	*/
        Border bf = BorderFactory.createTitledBorder(new LineBorder(Color.white, 1), "â ���� �ð�", TitledBorder.CENTER, TitledBorder.TOP, SystemManager.normalTTF, Color.white);
        durationPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        durationPanel.setBorder(bf);
		durationPanel.setBackground(new Color(0, 0, 0, 0)); // ����
		durationPanel.setSize(240, 60);
        
        /*	â ���� �ð� (����)		*/
        decBtn.setText("-");
        decBtn.setForeground(Color.red);
        decBtn.setFont(new Font(SystemManager.ttf, Font.PLAIN, 35));
        decBtn.setBackground(new Color(0, 0, 0, 0));
        decBtn.setPreferredSize(new Dimension(60, 60));
        decBtn.setFocusPainted(false);
        decBtn.setBorderPainted(false); // �׵θ� ����
        decBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(SystemManager.cooltime > 1)
            		SystemManager.cooltime--;
            	durationText.setText(SystemManager.cooltime + "��");
            	repaint();
            }
        });
		decBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	//���콺�� ������ ����
				repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
				repaint();
			}
		});
        
        /*	â ���� �ð� (�ؽ�Ʈ)	*/
        durationText = new JLabel();
        durationText.setText(SystemManager.cooltime + "��");
        durationText.setFont(SystemManager.normalTTF);
        durationText.setForeground(Color.GREEN);
        durationText.setSize(120, 60);
        
        /*	â ���� �ð� (����)		*/
        incBtn.setText("+");
        incBtn.setForeground(Color.CYAN);
        incBtn.setFont(new Font(SystemManager.ttf, Font.PLAIN, 25));
        incBtn.setBackground(new Color(0, 0, 0, 0));
        incBtn.setPreferredSize(new Dimension(60, 60));
        incBtn.setFocusPainted(false);
        incBtn.setBorderPainted(false); // �׵θ� ����
        incBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	SystemManager.cooltime++;
            	durationText.setText(SystemManager.cooltime + "��");
            	repaint();
            }
        });
        incBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	//���콺�� ������ ����
				repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
				repaint();
			}
		});
        
        durationPanel.add(decBtn);
        durationPanel.add(durationText);
        durationPanel.add(incBtn);
        
        /*	����	*/
        Border bl = BorderFactory.createTitledBorder(new LineBorder(Color.white, 1), "��� ����", TitledBorder.CENTER, TitledBorder.TOP, SystemManager.normalTTF, Color.white);
        gammaPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        gammaPanel.setBorder(bl);
        gammaPanel.setBackground(new Color(0, 0, 0, 0)); // ����
        gammaPanel.setSize(220, 40);
		
        /*	�����̴���		*/
        gammaSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, gamma);
        gammaSlider.setMinorTickSpacing(25);
        gammaSlider.setMajorTickSpacing(50);
        gammaSlider.setPaintTicks(true);
        gammaSlider.setPaintLabels(true);
        gammaSlider.setBackground(new Color(0, 0, 0, 0));
        gammaSlider.setForeground(Color.GREEN);
        gammaSlider.setSize(new Dimension(200, 40));
        
        /*	�����̴� ��� ����	*/
        gammaSlider.addChangeListener(new ChangeListener() {
        	@Override
        	public void stateChanged(ChangeEvent e) {
        		if(!gammaSlider.getValueIsAdjusting()) {
        			//�����̴� ���� ���� ���� ����
        			gamma = (int) gammaSlider.getValue();
        			mainPanel.setBackground(new Color(0, 0, 0, gamma));
        			repaint();
        		}
        	}
        });
        
        gammaPanel.add(gammaSlider);
        
        /*	��ư �߰�	*/
        for(int i = 0; i < btn.length; i++) {
        	btn[i] = new JButton();
        	
        	/*	��ü ����	*/
        	btn[i].setText(buttonName[i]);			//�۾� ����
            btn[i].setFont(SystemManager.normalTTF);		//��Ʈ ����
            btn[i].setForeground(Color.GREEN);		//�۾� ���� ����
            btn[i].setBackground(new Color(0, 0, 0));
            btn[i].setBorder(BorderFactory.createLineBorder(Color.RED, 1, true));	//�׵θ� ����
            btn[i].setPreferredSize(new Dimension(200, 40));			//ũ�� ����
            btn[i].setFocusPainted(false);
            
        	/*	���� ��ư(0)	*/
        	if(i == 0) {
        		btn[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	SystemManager.gamma = gamma;
                    	SystemManager.backColor = new Color(0, 0, 0, gamma);
                    	new MainWindow();
                    	dispose();
                    }
                });
        	}
            
            /*	�ڷΰ��� ��ư(1)	*/
        	if(i == 1) {
        		btn[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	new MainWindow();
                    	dispose();
                    }
                });
        	}
        	
        	/*	��ư ���콺 �ν�	*/
    		btn[i].addMouseListener(new MouseAdapter() {
    			@Override
    			public void mousePressed(MouseEvent e) {	//���콺�� ������ ����
    				repaint();
    			}
    			
    			@Override
    			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
    				repaint();
    			}
    		});
    		Insert(gbl, mainPanel, btn[i], 0, (i+3), 2, 1);
        }
        
        Insert(gbl, mainPanel, titleLabel, 0, 0, 2, 1);
        Insert(gbl, mainPanel, durationPanel, 0, 1, 2, 1);
        Insert(gbl, mainPanel, gammaPanel, 0, 2, 2, 1);
        add(mainPanel);
        
     	//���� ���� ���� ���� �� ���̱�
        setSize(SystemManager.window_width, SystemManager.window_height);
        setLocation(SystemManager.screenSize.width - SystemManager.window_width - 10, 50);
        setVisible(true);
        
        repaint();
        //openProgram();
	}
	
//	//���α׷� ����
//	private void openProgram() {
//		try {
//            // ������ �ܺ� ���α׷��� ��ο� ���ڸ� �����մϴ�.
//            String programPath = "./Gamma.exe";
//
//            // ���μ��� ������ �����ϰ� �ܺ� ���α׷��� �����մϴ�.
//            ProcessBuilder processBuilder = new ProcessBuilder(programPath);
//
//            // ���μ����� �����մϴ�.
//            Process process = processBuilder.start();
//
//            // ���μ����� ���Ḧ ����մϴ�.
//            int exitCode = process.waitFor();
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//	}
	
	// Insert (�׸����, �г�, ������Ʈ, x, y, �¿�, ������);
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
		g.setColor(SystemManager.backColor);
	}
}