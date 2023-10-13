package demon_slayer;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ImportentValue {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // ȭ�� ũ�� ���ϱ�
	/* â ����, ���� ũ�� */
	protected static final int window_width = 350;
	protected static final int window_height = 600;
	protected static final int sideWindow_width = 350;
	protected static final int sideWindow_height = 180;
	protected static int gamma = 200;
	protected static int cooltime = 3;
	protected static Color backColor; // ���ȭ�� ���� (RGBA)

	protected static final Font smallKostar = new Font("Kostar", Font.PLAIN, 18);
	protected static final Font normalKostar = new Font("Kostar", Font.PLAIN, 20);
	protected static final Font titleKostar = new Font("Kostar", Font.PLAIN, 30);
	
	protected static final Color OneColor = Color.white;
	protected static final Color TwoColor = new Color(50, 150, 255);
	protected static final Color ThreeColor = Color.green;
	protected static final Color FourColor = Color.cyan;
	protected static final Color HColor = new Color(255, 40, 0);
	protected static final Color XColor = Color.magenta; //new Color(124, 165, 133);
	protected static final Color ZColor = Color.orange;
	
	/*	������Ʈ ����	*/
	protected static Container activeContainer, sideContainer;
	protected static JButton hideButton;

	protected ImportentValue() {
		backColor = new Color(0, 0, 0, gamma);
	}
	
	/*	+	*/
	protected JLabel plus() {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText("+");
		valueLabel.setForeground(Color.white);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(normalKostar);
		
		return valueLabel;
	}
	
	/*	1����	*/
	protected JLabel lv1(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(OneColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(normalKostar);
		
		return valueLabel;
	}
	
	/*	2����	*/
	protected JLabel lv2(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(TwoColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(normalKostar);
		
		return valueLabel;
	}
	
	/*	3����	*/
	protected JLabel lv3(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(ThreeColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(normalKostar);
		
		return valueLabel;
	}
	
	/*	4����	*/
	protected JLabel lv4(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(FourColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(normalKostar);
		
		return valueLabel;
	}
	
	/*	����	*/
	protected JLabel lvH(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(HColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(normalKostar);
		
		return valueLabel;
	}
	
	/*	X	*/
	protected JLabel lvX(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(XColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(normalKostar);
		
		return valueLabel;
	}
	
	/*	Z	*/
	protected JLabel lvZ(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(ZColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(normalKostar);
		
		return valueLabel;
	}
	
	/*===========================================================���� ����================================================================*/
	/*	+	*/
	protected JLabel sPlus() {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText("+");
		valueLabel.setForeground(Color.white);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(smallKostar);
		
		return valueLabel;
	}
	
	/*	1����	*/
	protected JLabel slv1(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(OneColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(smallKostar);
		
		return valueLabel;
	}
	
	/*	2����	*/
	protected JLabel slv2(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(TwoColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(smallKostar);
		
		return valueLabel;
	}
	
	/*	3����	*/
	protected JLabel slv3(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(ThreeColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(smallKostar);
		
		return valueLabel;
	}
	
	/*	4����	*/
	protected JLabel slv4(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(FourColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(smallKostar);
		
		return valueLabel;
	}
	
	/*	����	*/
	protected JLabel slvH(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(HColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(smallKostar);
		
		return valueLabel;
	}
	
	/*	X	*/
	protected JLabel slvX(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(XColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(smallKostar);
		
		return valueLabel;
	}
	
	/*	Z	*/
	protected JLabel slvZ(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(ZColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(smallKostar);
		
		return valueLabel;
	}
}