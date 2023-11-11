package demon;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class DemonStarOverlay extends JFrame {
	VersionCheck vsC = new VersionCheck();
	ImportentValue impV = new ImportentValue();
	
	JPanel panel;
	JLabel label1, label2;
	JButton btn;
	
	DemonStarOverlay() {
		panel = new JPanel();
		label1 = new JLabel();
		label2 = new JLabel();
		btn = new JButton();
		
		/*	메인 프레임	*/
		impV.FrameSetting(this);
		
		panel.setLayout(null);
		panel.setBackground(impV.backColor); // 메인 패널 색
		panel.setBorder(new LineBorder(Color.red, 2, true));
		
		label1.setText("최신 버전을 확인하는 중 입니다...");
		label1.setFont(new Font(impV.ttf, Font.PLAIN, 20));
		label1.setForeground(Color.GREEN);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setSize(new Dimension(400, 60));
		label1.setLocation(0, 20);
		
		label2.setText("인터넷 환경에 따라 속도가 다를 수 있습니다.");
		label2.setFont(new Font(impV.ttf, Font.PLAIN, 20));
		label2.setForeground(Color.GREEN);
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setSize(new Dimension(400, 60));
		label2.setLocation(0, label1.getSize().height + 5);
		
		btn.setText("여기를 눌러 최신 버전을 다운로드해주세요.");
		btn.setFont(new Font(impV.ttf, Font.ITALIC, 20));
		btn.setForeground(Color.GREEN);
		btn.setBackground(new Color(0, 0, 0, 0));
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setHorizontalAlignment(JLabel.CENTER);
		btn.setSize(new Dimension(400, 60));
		btn.setLocation(0, label2.getLocation().y);
		btn.setVisible(false);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.getDesktop();
	            try {
	                URI uri = new URI("https://www.dropbox.com/scl/fi/y6qrmktt66wzgiit8mo6h/DemonSlayerOverlayVersion.txt?rlkey=8svv9qjngy4geqrn246d64cif&dl=1");
	                desktop.browse(uri);
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            } catch (URISyntaxException ex) {
	                ex.printStackTrace();
	            }
	            dispose();
			}
		});
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {		//마우스가 영역에 나간 순간
				repaint();
			}
		});
		
		panel.add(label1);
		panel.add(label2);
		panel.add(btn);
		add(panel);
		
		setSize(400, 150);
		setLocationRelativeTo(null);
		setVisible(true);
		
		vsC.downloadFile();
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		try {
			if(vsC.isUpdated()) {
				label1.setText("최신 버전이 존재합니다.");
				label1.setForeground(Color.red);
				label2.setVisible(false);
				btn.setVisible(true);
				repaint();
			} else {
				dispose();
			
				new MainWindow();
				new HideWindow();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new DemonStarOverlay();
	}
}
