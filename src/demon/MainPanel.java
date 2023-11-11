package demon;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainPanel extends JPanel {
	ImportentValue impV = new ImportentValue();
	
	public MainPanel() {
		setLayout(null);								// null 레이아웃
		setBackground(impV.backColor); 					// 메인 패널 색
		setBorder(new LineBorder(Color.red, 2, true));	// 메인 패널 테두리 색
	}
	
	public MainPanel(GridBagLayout gbl) {
		setLayout(gbl);									// GridBagLayout 레이아웃
		setBackground(impV.backColor); 					// 메인 패널 색
		setBorder(new LineBorder(Color.red, 2, true));	// 메인 패널 테두리 색
	}
}
