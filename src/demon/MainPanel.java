package demon;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainPanel extends JPanel {
	ImportentValue impV = new ImportentValue();
	
	public MainPanel() {
		setLayout(null);								// null ���̾ƿ�
		setBackground(impV.backColor); 					// ���� �г� ��
		setBorder(new LineBorder(Color.red, 2, true));	// ���� �г� �׵θ� ��
	}
	
	public MainPanel(GridBagLayout gbl) {
		setLayout(gbl);									// GridBagLayout ���̾ƿ�
		setBackground(impV.backColor); 					// ���� �г� ��
		setBorder(new LineBorder(Color.red, 2, true));	// ���� �г� �׵θ� ��
	}
}
