package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DoneCancelGUI extends JFrame{
	private GUI gui;
	private JFrame cancelEndFrame;
	private Container contentPane;
	
	private static DoneCancelGUI doneCancelGUI = new DoneCancelGUI();
	private DoneCancelGUI() {
		cancelEndFrame = new JFrame("キャンセル完了");
		cancelEndFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cancelEndFrame.setSize(500, 500);
        cancelEndFrame.setLocationRelativeTo(null);
        contentPane = cancelEndFrame.getContentPane();
        final JButton MENUbutton = new JButton("メニューに戻る");
        MENUbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MenuGUI select = MenuGUI.getSystemSelectInstance();
				JFrame nextframe = select.getSystemSelectFrame();
				gui = GUI.getViewInstance();
				gui.changeGUI(cancelEndFrame, nextframe);
			}
        });
        JPanel panel1 = new JPanel();
		panel1.add(new JLabel("キャンセルが完了しました。",SwingConstants.CENTER));
		panel1.add(MENUbutton);
		contentPane.add(panel1, BorderLayout.NORTH);
	}
	
	public JFrame getCancelEndFrame() {
		return this.cancelEndFrame;
	}
	
	public static DoneCancelGUI getCancelEndInstance() {
		return doneCancelGUI;
	}
}
