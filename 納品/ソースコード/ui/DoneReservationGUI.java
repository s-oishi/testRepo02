package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DoneReservationGUI {
	private GUI gui;
	private JFrame reserveCompleteFrame;
	private Container contentPane;
	
	private static DoneReservationGUI doneReservationGUI = new DoneReservationGUI();
	
	
	private DoneReservationGUI() {
		reserveCompleteFrame = new JFrame("予約完了");
		reserveCompleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		reserveCompleteFrame.setSize(500, 500);
		reserveCompleteFrame.setLocationRelativeTo(null);
        contentPane = reserveCompleteFrame.getContentPane();
        final JButton MENUbutton = new JButton("メニューに戻る");
        MENUbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MenuGUI select = MenuGUI.getSystemSelectInstance();
				JFrame nextframe = select.getSystemSelectFrame();
				gui = GUI.getViewInstance();
				gui.changeGUI(reserveCompleteFrame, nextframe);
			}
        });
        JPanel panel1 = new JPanel();
		panel1.add(new JLabel("予約が完了しました。",SwingConstants.CENTER));
		panel1.add(MENUbutton);
		contentPane.add(panel1, BorderLayout.NORTH);
	}
	
	public JFrame getReserveCompleteFrame() {
		return this.reserveCompleteFrame;
	}
	
	public static DoneReservationGUI getReserveCompleteInstance() {
		return doneReservationGUI;
	}
}


