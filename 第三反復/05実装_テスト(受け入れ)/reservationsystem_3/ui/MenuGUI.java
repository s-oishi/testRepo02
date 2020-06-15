package ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import domain.Reservation;
import management.AllSystem;


import java.util.List;

public class MenuGUI extends JFrame {
	private GUI view;
	private JFrame systemselect;
	private Container contentPane;
	private AllSystem allsystem;
	private List<Reservation> reservelist;
	
	private static MenuGUI select = new MenuGUI();
	private MenuGUI() {
		systemselect = new JFrame("システム選択");
		systemselect.setTitle("システム選択画面");
		systemselect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		systemselect.setSize(300, 120);
		systemselect.setLocationRelativeTo(null);
		contentPane = systemselect.getContentPane();
		final JButton allTickets = new JButton("全チケット閲覧・予約");
		final JButton reserveTickets = new JButton("予約チケット閲覧・キャンセル");
		allTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view = GUI.getViewInstance();//画面遷移
				JOptionPane.showMessageDialog(null, "全チケットを表示します。","allTickets",JOptionPane.PLAIN_MESSAGE);
				TicketShowGUI ticketframe = TicketShowGUI.getTicketFrameInstance();
				JFrame nextframe = ticketframe.getTicketFrame();
				view.changeGUI(systemselect,nextframe);
			}
		});
		reserveTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view = GUI.getViewInstance();//画面遷移
				JOptionPane.showMessageDialog(null, "予約一覧を表示します。","reserveTickets",JOptionPane.PLAIN_MESSAGE);
				//予約チケット閲覧・キャンセルを押下したときに実行される。
				allsystem = AllSystem.getAllSystemInstance();
				reservelist = allsystem.showReserveInfo();
				ReservationShowGUI reserveframe = new ReservationShowGUI(reservelist);
				JFrame nextframe = reserveframe.getReserveFrame();
				view.changeGUI(systemselect,nextframe);
			}
		});
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,2));
		panel2.add(new JLabel("利用システムを選択してください。", SwingConstants.CENTER));
		panel2.add(allTickets);
		panel2.add(reserveTickets);
		contentPane.add(panel2, BorderLayout.NORTH);
	}

	
	public static MenuGUI getSystemSelectInstance() {
		return select;
	}
	
	public JFrame getSystemSelectFrame() {
		return systemselect;
	}
}
