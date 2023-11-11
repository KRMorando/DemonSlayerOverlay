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
		
		/*	���� ������	*/
		impV.FrameSetting(this);
		
		panel.setLayout(null);
		panel.setBackground(impV.backColor); // ���� �г� ��
		panel.setBorder(new LineBorder(Color.red, 2, true));
		
		label1.setText("�ֽ� ������ Ȯ���ϴ� �� �Դϴ�...");
		label1.setFont(new Font(impV.ttf, Font.PLAIN, 20));
		label1.setForeground(Color.GREEN);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setSize(new Dimension(400, 60));
		label1.setLocation(0, 20);
		
		label2.setText("���ͳ� ȯ�濡 ���� �ӵ��� �ٸ� �� �ֽ��ϴ�.");
		label2.setFont(new Font(impV.ttf, Font.PLAIN, 20));
		label2.setForeground(Color.GREEN);
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setSize(new Dimension(400, 60));
		label2.setLocation(0, label1.getSize().height + 5);
		
		btn.setText("���⸦ ���� �ֽ� ������ �ٿ�ε����ּ���.");
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
			public void mouseExited(MouseEvent e) {		//���콺�� ������ ���� ����
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
				label1.setText("�ֽ� ������ �����մϴ�.");
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
