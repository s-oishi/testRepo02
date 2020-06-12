package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.Reservation;
import domain.Ticket;
import management.AllSystem;

public class CancelGUI extends JFrame{
	AllSystem allsystem;
	GUI gui;
	MenuGUI select;
	DoneCancelGUI doneCancelGUI;
	Reservation r;
	JPanel jPanel;
	JLabel jLabel;
	JFrame cancelFrame;
	JComboBox combo ;
	String[] s;
 	private Container contentPane;
	//private static Reserve reserve = new Reserve();
	/*
	private Reserve() {
		setSize(300, 120);
	}
	*/
 	public CancelGUI(Reservation r) {
 		allsystem = AllSystem.getAllSystemInstance();
 		this.r = r;
		cancelFrame = new JFrame("キャンセル");
		cancelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cancelFrame.setSize(500, 500);
        cancelFrame.setLocationRelativeTo(null);
        contentPane = cancelFrame.getContentPane();
        Ticket ticketName = r.searchTicket();
        final JButton YESbutton = new JButton("はい");
        YESbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int cancelTicketNo = r.getReserveNumber();
				boolean end = allsystem.ticketCancel(cancelTicketNo);
				if(end == true) {
					doneCancelGUI = DoneCancelGUI.getCancelEndInstance();
					JFrame nextframe = doneCancelGUI.getCancelEndFrame();
					gui = GUI.getViewInstance();
					gui.changeGUI(cancelFrame, nextframe);
				}
			}
        });
        final JButton NObutton = new JButton("メニュー画面へ戻る");
        NObutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				gui = GUI.getViewInstance();
				select = MenuGUI.getSystemSelectInstance();
				gui.changeGUI(cancelFrame,select.getSystemSelectFrame());
			}
        });

		jPanel = new JPanel();
		jPanel.add(new JLabel(r.searchMember().getMemberName() +"様" +
		r.searchTicket().getTicketName() +","+ r.getReserveDay() + "," + r.getSheetsNo() + "枚"));
		jPanel.add(new JLabel("キャンセルを実行しますか？",SwingConstants.CENTER));
		jPanel.add(YESbutton);
		jPanel.add(NObutton);
		contentPane.add(jPanel, BorderLayout.CENTER);
 	}

	public JFrame getCancelFrame() {
		return cancelFrame;
	}
}
