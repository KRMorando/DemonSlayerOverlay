package demon;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AchivementSideWindow extends JFrame implements Runnable {
	ImportentValue impV = new ImportentValue();

	private JPanel mainPanel, levelPanel, explainPanel, rewardPanel;
	private URL url;
	private String imgUrl[] = {	"achive/under_lamp1.png",
								"achive/under_lamp2.png" };

	protected static Thread runningThread;
	private static int number;
	
	private final int under_size = 250;

	public AchivementSideWindow(int number) {
		this.number = number;
	}

	public void run() {
		if (runningThread != null) {
			try {
				runningThread.interrupt(); // ÀÌ¹Ì ½ÇÇàµÈ ½º·¹µå´Â ÀÛµ¿ Ãë¼Ò
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		runningThread = Thread.currentThread(); 				// ½ÇÇàµÈ ½º·¹µå °´Ã¼ ¾ò±â
		impV.sideContainer = this;	// ÇöÀç ÄÁÅ×ÀÌ³Ê °´Ã¼¸¦ ÃÖ±ÙÀ¸·Î µî·Ï

		mainPanel = new MainPanel();
		levelPanel = new JPanel();
		explainPanel = new JPanel();
		rewardPanel = new JPanel();

		/*	¸ÞÀÎ ÇÁ·¹ÀÓ	*/
        impV.FrameSetting(this);
		
		/* ·¹º§ ÆÐ³Î */
		levelPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout(Áß¾Ó ¹èÄ¡)
		levelPanel.setBackground(new Color(0, 0, 0, 0)); // ¹è°æ»ö
		levelPanel.setBounds(0, 10, impV.sideWindow_width, impV.sideWindow_height - 50); // Å©±â

		/* ¼³¸í ÆÐ³Î */
		explainPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout(Áß¾Ó ¹èÄ¡)
		explainPanel.setBackground(new Color(0, 0, 0, 0)); // ¹è°æ»ö
		explainPanel.setBounds(0, 50, impV.sideWindow_width, impV.sideWindow_height - 50); // Å©±â

		/* º¸»ó ÆÐ³Î */
		Border bf = BorderFactory.createTitledBorder(new LineBorder(Color.red, 1), "º¸»ó", TitledBorder.LEFT, TitledBorder.TOP, impV.normalTTF, Color.white);
		rewardPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout(Áß¾Ó ¹èÄ¡)
		rewardPanel.setBorder(bf);
		rewardPanel.setBackground(new Color(0, 0, 0, 0)); // ¹è°æ»ö
		rewardPanel.setBounds(10, 100, impV.sideWindow_width - 20, impV.sideWindow_height - 105); // Å©±â

		/* ·¹º§ ÆÐ³Î Ãß°¡ */
		levelPanel.add(impV.lvL("1", "normal", "Lv1 "));
		levelPanel.add(impV.lvL("2", "normal", "Lv2 "));
		levelPanel.add(impV.lvL("3", "normal", "Lv3 "));
		levelPanel.add(impV.lvL("4", "normal", "Lv4 "));
		levelPanel.add(impV.lvL("H", "normal", "LvH "));
		levelPanel.add(impV.lvL("EH", "normal", "LvEH "));
		levelPanel.add(impV.lvL("X", "normal", "LvX "));
		levelPanel.add(impV.lvL("Z", "normal", "LvZ"));

		switch (number) {
		case 0:
			// ÇÏ±Þ
			explainPanel.add(impV.lvL("1", "normal", "ALL Lv1"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx1"));
			break;

		case 1:
			// Áß±Þ
			explainPanel.add(impV.lvL("2", "normal", "ALL Lv2"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx2"));
			break;

		case 2:
			// »ó±Þ
			explainPanel.add(impV.lvL("3", "normal", "ALL Lv3"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx3"));
			break;

		case 3:
			// À¯´ë
			explainPanel.add(impV.lvL("1", "normal", "ÅºÁö·Îx4 + ³×ÁîÄÚx4"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx1"));
			break;

		case 4:
			// ¿À´Ï
			explainPanel.add(impV.lvL("1", "normal", "À¯½Ã·Îx5 + ³×ÁîÄÚx3"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx1"));
			break;

		case 5:
			// ³ªºñ
			explainPanel.add(impV.lvL("2", "normal", "Ä«³ª¿Àx3"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("1", "normal", "¾Æ¿ÀÀÌx3"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx1"));
			break;

		case 6:
			// »ç°Ý
			explainPanel.add(impV.lvL("2", "normal", "°Õ¾ßx4"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("2", "normal", "¹«¶óÅ¸x1"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx1"));
			break;

		case 7:
			// ÇüÁ¦
			explainPanel.add(impV.lvL("3", "normal", "»ç³×¹Ìx2"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("2", "normal", "°Õ¾ßx2"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx2"));
			break;

		case 8:
			// »ç¶û
			explainPanel.add(impV.lvL("3", "normal", "¹ÌÃ÷¸®x2"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("3", "normal", "¿À¹Ù³ªÀÌx1"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx2"));
			break;

		case 9:
			// °¡¹®
			explainPanel.add(impV.lvL("4", "normal", "Ä«°¡¾ßx1"));
			explainPanel.add(impV.lvL("1", "normal", " (Ã¹ Lv4 Á¶ÇÕ¿¡ µîÀå½Ã)"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx2"));
			break;

		case 10:
			// Àû±Ý1
			explainPanel.add(impV.lvL("4", "normal", "¹Ì³×¶ö \" 15 \" ÀÌ»ó ¼öÁý"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx1"));
			break;

		case 11:
			// Àû±Ý2
			explainPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Î \" 5 \" ÀÌ»ó ¼öÁý"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx1"));
			break;

		case 12:
			// »ïÀÎ¹æ
			explainPanel.add(impV.lvL("2", "normal", "Á¨ÀÌÃ÷x3"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("2", "normal", "ÀÌ³ë½ºÄÉx3"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("1", "normal", "ÅºÁö·Îx2"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx2"));
			break;

		case 13:
			// ÇÐ»ìÀÚ
			explainPanel.add(impV.lvL("1", "normal", "ÀÏ¹Ý ¿À´Ï \" 60 \" Åä¹ú (ÆÀ °øÀ¯)"));
			rewardPanel.add(impV.lvL("4", "normal", "¹Ì³×¶öx15"));
			break;

		case 14:
			// ÇÐ»ìÀÚ2
			explainPanel.add(impV.lvL("1", "normal", "°Å¹Ì ¿À´Ï \" 45 \" Åä¹ú (ÆÀ °øÀ¯)"));
			rewardPanel.add(impV.lvL("4", "normal", "¹Ì³×¶öx20"));
			break;

		case 15:
			// ±Í»ì´ë
			explainPanel.add(impV.lvL("2", "normal", "¹«¶óÅ¸x2"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("1", "normal", "¼±¹èx4"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx1"));
			break;

		case 16:
			// µîÀÜ¹Ø 300 x 294
			url = this.getClass().getClassLoader().getResource(imgUrl[0]);
			ImageIcon under1_icon = new ImageIcon(url), under1_updateIcon;
			Image under1_img = under1_icon.getImage();
			Image under1_updateImg = under1_img.getScaledInstance(300, 294, Image.SCALE_SMOOTH);
			under1_updateIcon = new ImageIcon(under1_updateImg);
			
			JLabel under1_imgLabel = new JLabel(under1_updateIcon);
			
			mainPanel.setBounds(0, 0, impV.sideWindow_width, impV.sideWindow_height + under_size); 					// À§Ä¡ ¹× Å©±â
			explainPanel.setBounds(0, 50, impV.sideWindow_width, impV.sideWindow_height - 50 + under_size); 		// À§Ä¡ ¹× Å©±â
			rewardPanel.setBounds(10, 100 + under_size, impV.sideWindow_width - 20, impV.sideWindow_height - 105); 	// À§Ä¡ ¹× Å©±â
			under1_imgLabel.setBorder(new LineBorder(Color.red, 1));
			
			explainPanel.add(under1_imgLabel);
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx1"));
			break;

		case 17:
			// µîÀÜ¹Ø2 300 x 294
			url = this.getClass().getClassLoader().getResource(imgUrl[1]);
			ImageIcon under2_icon = new ImageIcon(url), under2_updateIcon;
			Image under2_img = under2_icon.getImage();
			Image under2_updateImg = under2_img.getScaledInstance(300, 294, Image.SCALE_SMOOTH);
			under2_updateIcon = new ImageIcon(under2_updateImg);
			
			JLabel under2_imgLabel = new JLabel(under2_updateIcon);
			
			mainPanel.setBounds(0, 0, impV.sideWindow_width, impV.sideWindow_height + under_size); // À§Ä¡ ¹× Å©±â
			explainPanel.setBounds(0, 50, impV.sideWindow_width, impV.sideWindow_height - 50 + under_size); // Å©±â
			rewardPanel.setBounds(10, 100 + under_size, impV.sideWindow_width - 20, impV.sideWindow_height - 105); // Å©±â
			under2_imgLabel.setBorder(new LineBorder(Color.red, 1));
			
			explainPanel.add(under2_imgLabel);
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx1"));
			break;

		case 18:
			// ÀÌµµ·ù
			explainPanel.add(impV.lvL("3", "normal", "ÅÙ°Õx1"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("2", "normal", "ÀÌ³ë½ºÄÉx2"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx2"));
			break;

		case 19:
			// ¸ÛÃ»ÀÌ
			explainPanel.add(impV.lvL("1", "normal", "ÀÓ¹« - [Q]ºÒ´ç¿À´Ï 10¹ø (10¶ó¿îµå Àü) "));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx1"));
			break;

		case 20:
			// ÃÖÁ¾¼±º°
			explainPanel.add(impV.lvL("2", "normal", "Á¨ÀÌÃ÷x2"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("2", "normal", "ÀÌ³ë½ºÄÉx2"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("2", "normal", "Ä«³ª¿Àx2"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("2", "normal", "°Õ¾ßx2"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("1", "normal", "ÅºÁö·Îx2"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx4"));
			break;

		case 21:
			// »ïÃÑ»ç
			explainPanel.add(impV.lvL("X", "normal", "ÅºÁö·Îx1"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("X", "normal", "Á¨ÀÌÃ÷x1"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("X", "normal", "ÀÌ³ë½ºÄÉx1"));
			rewardPanel.add(impV.lvL("2", "normal", "Lv2 ·£´ý½Ã¹Îx1"));
			rewardPanel.add(impV.lvL("H", "normal", "/"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx3"));
			break;

		case 22:
			// Ã»Ãâ¾î¶÷
			explainPanel.add(impV.lvL("X", "normal", "±âÀ¯x1"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("X", "normal", "Á¨ÀÌÃ÷x1"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("H", "normal", "»çÄÜÁöx1"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("H", "normal", "Áö°í·Îx1"));
			rewardPanel.add(impV.lvL("2", "normal", "Lv2 ·£´ý½Ã¹Îx1"));
			rewardPanel.add(impV.lvL("H", "normal", "/"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx3"));
			break;

		case 23:
			// ÁÖÇÕÈ¸ÀÇ
			explainPanel.add(impV.lvL("4", "normal", "All Lv4"));
			rewardPanel.add(impV.lvL("3", "normal", "Lv3 ·£´ý½Ã¹Îx1"));
			rewardPanel.add(impV.lvL("H", "normal", "/"));
			rewardPanel.add(impV.lvL("2", "normal", "Lv2 ·£´ý½Ã¹Îx2"));
			break;

		case 24:
			// ÆÛÁñ
			explainPanel.add(impV.lvL("H", "normal", "All LvH "));
			rewardPanel.add(impV.lvL("2", "normal", "Lv2 ·£´ý½Ã¹Îx2"));
			rewardPanel.add(impV.lvL("H", "normal", "/"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx3"));
			break;

		case 25:
			// µµ°ø¸¶À»
			explainPanel.add(impV.lvL("X", "normal", "¹«ÀÌÄ¡·Îx1"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("X", "normal", "¹ÌÃ÷¸®x1"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("X", "normal", "°Õ¾ßx1"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("EH", "normal", "È£Å¸·çx1"));
			rewardPanel.add(impV.lvL("3", "normal", "Lv3 ·£´ý½Ã¹Îx1"));
			rewardPanel.add(impV.lvL("H", "normal", "/"));
			rewardPanel.add(impV.lvL("1", "normal", "Lv1 ·£´ý½Ã¹Îx2"));
			break;

		case 26:
			// ¾Ç±Í¸ê»ì
			explainPanel.add(impV.lvL("X", "normal", "All LvX "));
			rewardPanel.add(impV.lvL("1", "normal", "Lv3 ·£´ý½Ã¹Îx2"));
			rewardPanel.add(impV.lvL("H", "normal", "/"));
			rewardPanel.add(impV.lvL("2", "normal", "Lv2 ·£´ý½Ã¹Îx2"));
			rewardPanel.add(impV.lvL("X", "normal", "¹Ì³×¶öx100 "));
			break;

		case 27:
			// ·¹Àüµå
			explainPanel.add(impV.lvL("Z", "normal", "All LvZ "));
			rewardPanel.add(impV.lvL("3", "normal", "Lv3 ·£´ý½Ã¹Îx2"));
			rewardPanel.add(impV.lvL("H", "normal", "/"));
			rewardPanel.add(impV.lvL("2", "normal", "Lv2 ·£´ý½Ã¹Îx3"));
			break;

		case 28:
			// ÀáÀÔ
			explainPanel.add(impV.lvL("X", "normal", "ÅÙ°Õx1"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("2", "normal", "Á¨ÀÌÃ÷x2"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("2", "normal", "ÀÌ³ë½ºÄÉx2"));
			explainPanel.add(impV.Plus());
			explainPanel.add(impV.lvL("1", "normal", "ÅºÁö·Îx2 + ³×ÁîÄÚx2"));
			rewardPanel.add(impV.lvL("2", "normal", "Lv2 ·£´ý½Ã¹Îx1"));
			break;
		}

		mainPanel.add(levelPanel);
		mainPanel.add(explainPanel);
		mainPanel.add(rewardPanel);
		add(mainPanel);

		// °¡·Î ¼¼·Î ±æÀÌ ÁöÁ¤ ¹× º¸ÀÌ±â
		if(number == 16 || number == 17)
			setSize(impV.sideWindow_width, impV.sideWindow_height + under_size);
		else
			setSize(impV.sideWindow_width, impV.sideWindow_height);
		setLocation(impV.screenSize.width - impV.window_width - impV.sideWindow_width - 8, 50);
		setVisible(true);

		try {
			Thread.sleep(impV.cooltime * 1000);
			runningThread = null;
			impV.sideContainer = null;
			dispose();
		} catch (InterruptedException e) {
			dispose();
		}
	}
}
