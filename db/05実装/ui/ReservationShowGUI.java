package ui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Reservation;
import management.AllSystem;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ReservationShowGUI extends JFrame implements ActionListener {
	private JFrame mainFrame;
	private Container contentPane;
	private JPanel labelPane;
	private JPanel buttonPane;
	private JPanel buttonPane1;
	private JButton[] addButtonList;
	private AllSystem allsystem;
	private GUI view;
	private List<Reservation> reserveList;
	private MenuGUI select;
	private Reservation r;

	private int cancelGUI_count = 0;

	// private static ReserveFrame reserveFrame = new ReserveFrame();
	// コンストラクタ
	public ReservationShowGUI(List<Reservation> reserveList) {
		// 引数
		this.reserveList = reserveList;
		allsystem = AllSystem.getAllSystemInstance();
		this.reserveList = allsystem.ReservationTicket();		
		mainFrame = new JFrame("予約チケット情報閲覧画面");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(500, 500);
		mainFrame.setLocationRelativeTo(null);
		contentPane = mainFrame.getContentPane();
		buttonPane = new JPanel();
		labelPane = new JPanel();
		if (this.reserveList.size() == 0 || this.reserveList == null) {
			buttonPane.setLayout(new BoxLayout(labelPane, BoxLayout.Y_AXIS));
			labelPane.add(new JLabel("予約していません"));
			contentPane.add(labelPane, BorderLayout.CENTER);
		} else {
			addButtonList = new JButton[this.reserveList.size()];

			JFrame[] cancelpage_set = new JFrame[reserveList.size()];

			for (int i = 0; i < this.reserveList.size(); i++) {
				r = reserveList.get(i);
				JButton addButton = new JButton(r.getReserveNumber() + ":" + r.searchMember().getMemberName() + "様"
						+ r.searchTicket().getTicketName() + "," + r.getReserveDay() + "," + r.getSheetsNo() + "枚");
				addButtonList[i] = addButton;
				// キャンセル画面への遷移
				
				addButtonList[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						allsystem = AllSystem.getAllSystemInstance();
						view = GUI.getViewInstance();
						r = reserveList.get(cancelGUI_count);
						System.out.println(r.searchTicket().getTicketName());
						
						CancelGUI cancelGUI = new CancelGUI(r);
						//cancelGUI_set[cancelGUI_count] = cancelGUI;
						System.out.println(cancelGUI_count);
						
						JFrame cancelpage = cancelGUI.getCancelFrame();
						cancelpage_set[cancelGUI_count] = cancelpage;
						
						view.changeGUI(mainFrame, cancelpage_set[cancelGUI_count]);
						cancelGUI_count++;
						view.changeGUI(mainFrame, cancelpage);
						// オブジェクトごとの予約画面へ遷移するメソッド呼び出し
					}
				});
			}
			buttonPane = new JPanel();
			buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
			int i = 0;
			while (i < addButtonList.length) {
				buttonPane.add(addButtonList[i]);
				i++;
			}
			contentPane.add(buttonPane, BorderLayout.CENTER);
		}
		buttonPane1 = new JPanel();
		JButton cancelButton = new JButton("メニュー画面へ戻る");
		buttonPane1.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allsystem = AllSystem.getAllSystemInstance();
				view = GUI.getViewInstance();
				select = MenuGUI.getSystemSelectInstance();
				view.changeGUI(mainFrame, select.getSystemSelectFrame());
				// オブジェクトごとの予約画面へ遷移するメソッド呼び出し
			}
		});
		contentPane.add(buttonPane1, BorderLayout.SOUTH);
	}

	public JFrame getReserveFrame() {
		return mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		// label.setText("Push");
	}
}