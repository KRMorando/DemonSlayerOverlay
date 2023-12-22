package demon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SystemManager {
	//private static SystemManager instance = new SystemManager();
	
	public static int gamma = 200;
	public static int cooltime = 3;
	public static Color backColor = new Color(0, 0, 0, gamma); // 배경화면 색상 (RGBA)
	
	/*	컴포넌트 저장	*/
	public static JFrame activeContainer, sideContainer;
	public static JButton hideButton;
	
	//VYYMMDD
	static String Version = "1.0231106";
		
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 화면 크기 구하기

	/* 창 가로, 세로 크기 */
	static int window_width = 350;
	static int window_height = 600;
	static int sideWindow_width = 360;
	static int sideWindow_height = 180;

	static String ttf = "12롯데마트드림Medium";
	static Font smallTTF = new Font(ttf, Font.PLAIN, 18);
	static Font normalTTF = new Font(ttf, Font.PLAIN, 20);
	static Font titleTTF = new Font(ttf, Font.PLAIN, 30);
	
	static Color OneColor = Color.white;
	static Color TwoColor = new Color(255, 60, 220);
	static Color ThreeColor = Color.green;
	static Color FourColor = Color.cyan;
	static Color HColor = new Color(255, 40, 0);
	static Color EHColor = new Color(38, 105, 0);
	static Color XColor = new Color(50, 150, 255);
	static Color ZColor = Color.orange;
	static Color SZColor = Color.red;
		
	static String[] OneLocation = {	"1/cha1_Aoi.png",
									"1/cha1_Cube.png",
									"1/cha1_Nezuko.png",
									"1/cha1_Tanjiro.png",
									"1/cha1_Yusiro.png"},
			
					TwoLocation = {	"2/cha2_Genya.png",
									"2/cha2_Inosuke.png",
									"2/cha2_Kanao.png",
									"2/cha2_Murata.png",
									"2/cha2_Zenitsu.png"},
					
					ThreeLocation = {"3/cha3_Mitsuri.png",
									"3/cha3_Muichiro.png",
									"3/cha3_obanai.png",
									"3/cha3_Sanemi.png",
				 					"3/cha3_Tengen.png" },
					
					FourLocation = {"4/cha4_Giyu.png",
									"4/cha4_Gyomei.png",
									"4/cha4_Kagaya.png",
									"4/cha4_Kyojuro.png",
									"4/cha4_Shinobu.png" },
					
					HLocation = {	"H/chaH_Sakonji.png",
									"H/chaH_Jigoro.png",
									"H/chaH_Tamayo.png",
									"H/chaH_Kanae.png",
									"H/chaH_Makomo.png",
									"H/chaH_Sabito.png" },
				
					EHLocation = {	"EH/chaEH_Hotaru.png"},
				
					XLocation = {	"X/chaX_Tanjiro.png",
									"X/chaX_Inosuke.png",
									"X/chaX_Zenitsu.png",
									"X/chaX_Giyu.png",
									"X/chaX_Tengen.png",
									"X/chaX_Mitsuri.png",
									"X/chaX_Muichiro.png",
									"X/chaX_Genya.png"},
				
					ZLocation = {	"Z/chaZ_Kanao.png",
									"Z/chaZ_Nezuko.png",
									"Z/chaZ_Kyojuro.png" },
		
					SZLocation = {	"SZ/chaSZ_Tanjiro.png"};

	/*===== Singleton =====
	public static SystemManager getInstance() {
		return instance;
	}*/
	
	protected static void FrameSetting(JFrame frame) {
		/*	메인 프레임	*/
        frame.setUndecorated(true);								// 테두리 삭제
        frame.setResizable(false);								// 크기 조절 여부
        frame.setBackground(new Color(0, 0, 0, 0));				// 컨테이너 공백
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