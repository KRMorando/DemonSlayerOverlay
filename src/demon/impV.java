package demon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public final class impV {
	// V.VYYMMDD
	protected static final String Version = "1.0231106";
	
	static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 화면 크기 구하기
	
	/* 창 가로, 세로 크기 */
	protected static final int window_width = 350;
	protected static final int window_height = 600;
	protected static final int sideWindow_width = 360;
	protected static final int sideWindow_height = 180;
	protected static int gamma = 200;
	protected static int cooltime = 3;
	protected static Color backColor; // 배경화면 색상 (RGBA)

	protected static final String ttf = "12롯데마트드림Medium";
	protected static final Font smallTTF = new Font(ttf, Font.PLAIN, 18);
	protected static final Font normalTTF = new Font(ttf, Font.PLAIN, 20);
	protected static final Font titleTTF = new Font(ttf, Font.PLAIN, 30);
	
	protected static final Color OneColor = Color.white;
	protected static final Color TwoColor = new Color(255, 60, 220);
	protected static final Color ThreeColor = Color.green;
	protected static final Color FourColor = Color.cyan;
	protected static final Color HColor = new Color(255, 40, 0);
	protected static final Color EHColor = new Color(38, 105, 0);
	protected static final Color XColor = new Color(50, 150, 255);
	protected static final Color ZColor = Color.orange;
	protected static final Color SZColor = Color.red;
	
	/*	컴포넌트 저장	*/
	protected static JFrame activeContainer, sideContainer;
	protected static JButton hideButton;

	protected impV() {
		backColor = new Color(0, 0, 0, gamma);
	}
	
	protected static void FrameSetting(JFrame frame) {
		/*	메인 프레임	*/
        frame.setUndecorated(true);								//테두리 삭제
        frame.setResizable(false);								//크기 조절 여부
        frame.setBackground(new Color(0, 0, 0, 0));				//컨테이너 공백
        frame.setAlwaysOnTop(true); 							// 항상 위에 보이기
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 윈도우 종료시 javax도 종료
	}
	
	/*	커스텀	*/
	protected static JLabel customText(String str, Color color, int size) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setForeground(color);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setVerticalAlignment(JLabel.CENTER);
		valueLabel.setFont(new Font(ttf, Font.PLAIN, size));
		valueLabel.setSize(100, 80);
		
		return valueLabel;
	}
	
	/*	+	*/
	protected static JLabel Plus() {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText("+");
		valueLabel.setForeground(Color.white);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(normalTTF);
		valueLabel.setHorizontalAlignment(JLabel.RIGHT);
		
		return valueLabel;
	}
	
	/*	+	*/
	protected static JLabel sPlus() {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText("+");
		valueLabel.setForeground(Color.white);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setFont(smallTTF);
		
		return valueLabel;
	}
	
	/*	lvL	*/
	protected static JLabel lvL(String level, String size, String str) {
		JLabel valueLabel = new JLabel();
		
		valueLabel.setText(str);
		valueLabel.setBackground(new Color(0, 0, 0, 0));
		valueLabel.setHorizontalAlignment(JLabel.RIGHT);

		if(size.equals("normal"))
			valueLabel.setFont(normalTTF);
		else
			valueLabel.setFont(smallTTF);

		switch(level) {
		case "1":
			valueLabel.setForeground(OneColor);
			break;
			
		case "2":
			valueLabel.setForeground(TwoColor);
			break;
			
		case "3":
			valueLabel.setForeground(ThreeColor);
			break;
			
		case "4":
			valueLabel.setForeground(FourColor);
			break;
			
		case "H":
			valueLabel.setForeground(HColor);
			break;
			
		case "EH":
			valueLabel.setForeground(EHColor);
			break;
			
		case "X":
			valueLabel.setForeground(XColor);
			break;
			
		case "Z":
			valueLabel.setForeground(ZColor);
			break;
			
			default:
				valueLabel.setForeground(OneColor);
				break;
		}
		
		return valueLabel;
	}
}