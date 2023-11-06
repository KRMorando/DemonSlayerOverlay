package demon;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ImportentValue {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 화면 크기 구하기
	/* 창 가로, 세로 크기 */
	protected static final int window_width = 350;
	protected static final int window_height = 600;
	protected static final int sideWindow_width = 350;
	protected static final int sideWindow_height = 180;
	protected static int gamma = 200;
	protected static int cooltime = 3;
	protected static Color backColor; // 배경화면 색상 (RGBA)

	protected static final Font smallKostar = new Font("Kostar", Font.PLAIN, 18);
	protected static final Font normalKostar = new Font("Kostar", Font.PLAIN, 20);
	protected static final Font titleKostar = new Font("Kostar", Font.PLAIN, 30);
	
	protected static final Color OneColor = Color.white;
	protected static final Color TwoColor = new Color(255, 60, 220);
	protected static final Color ThreeColor = Color.green;
	protected static final Color FourColor = Color.cyan;
	protected static final Color HColor = new Color(255, 40, 0);
	protected static final Color XColor = new Color(50, 150, 255);
	protected static final Color ZColor = Color.orange;
	
	/*	컴포넌트 저장	*/
	protected static Container activeContainer, sideContainer;
	protected static JButton hideButton;

	protected ImportentValue() {
		backColor = new Color(0, 0, 0, gamma);
	}
	
	/*	커스텀	*/
	protected JLabel customText(String str, Color color, int size) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(color);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setVerticalAlignment(JLabel.CENTER);
		valueLabel.setFont(new Font("Kostar", Font.PLAIN, size));
		valueLabel.setSize(100, 80);
		
		return valueLabel;
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
	
	/*	1레벨	*/
	protected JLabel lv1(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(OneColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(normalKostar);
		
		return valueLabel;
	}
	
	/*	2레벨	*/
	protected JLabel lv2(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(TwoColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(normalKostar);
		
		return valueLabel;
	}
	
	/*	3레벨	*/
	protected JLabel lv3(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(ThreeColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(normalKostar);
		
		return valueLabel;
	}
	
	/*	4레벨	*/
	protected JLabel lv4(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(FourColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(normalKostar);
		
		return valueLabel;
	}
	
	/*	히든	*/
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
	
	/*===========================================================작은 버전================================================================*/
	/*	+	*/
	protected JLabel sPlus() {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText("+");
		valueLabel.setForeground(Color.white);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(smallKostar);
		
		return valueLabel;
	}
	
	/*	1레벨	*/
	protected JLabel slv1(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(OneColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(smallKostar);
		
		return valueLabel;
	}
	
	/*	2레벨	*/
	protected JLabel slv2(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(TwoColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(smallKostar);
		
		return valueLabel;
	}
	
	/*	3레벨	*/
	protected JLabel slv3(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(ThreeColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(smallKostar);
		
		return valueLabel;
	}
	
	/*	4레벨	*/
	protected JLabel slv4(String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(FourColor);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(smallKostar);
		
		return valueLabel;
	}
	
	/*	히든	*/
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