package ui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.Ticket;
import management.AllSystem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicketShowGUI extends JFrame implements ActionListener {
    private JFrame mainFrame;
    private Container contentPane;
    private JPanel buttonPane;
    private JButton[] addButtonList;
    private AllSystem allsystem;
    private GUI gui;
    private Ticket[] ticketList; 
    private MenuGUI select;
    //private static TicketShowGUI ticketShowGUI = new TicketShowGUI();
    // コンストラクタ
    //TODO
    public /*private*/ TicketShowGUI(){
    	allsystem = AllSystem.getAllSystemInstance();
    	ticketList = allsystem.indicateAllTicketInfo();
            mainFrame = new JFrame("全チケット情報閲覧画面");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(500, 500);
            mainFrame.setLocationRelativeTo(null);
            contentPane = mainFrame.getContentPane();
            addButtonList = new JButton[ticketList.length];
            for(int i = 0; i<ticketList.length;i++) {
            	Ticket t = ticketList[i];
            	//TODO
            	System.out.println("ボタン生成時のチケット番号：" + t.getTicketNumber());
            	JButton addButton = new JButton(t.getTicketNumber() + ":" + t.getTicketName() + "," + t.getPrice() + "円" + "," + t.getDay() + "," +t.getStock() + "枚" );
            	
            	addButtonList[i] = addButton;
            	addButtonList[i].addActionListener(new ActionListener(){
        			public void actionPerformed(ActionEvent e) {
        				allsystem = AllSystem.getAllSystemInstance();
        					gui = GUI.getViewInstance();
        					ReservationGUI reservationGUI = new ReservationGUI(t);
        					System.out.println("移動する予約画面生成時の引数チケット番号：" + t.getTicketNumber());
        					gui.changeGUI(mainFrame,reservationGUI.getReserveFrame());
        					//オブジェクトごとの予約画面へ遷移するメソッド呼び出し
        			}
        		});
            }
            
            buttonPane = new JPanel();
            buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
            int i =0;
            while(i<addButtonList.length) {
            	buttonPane.add(addButtonList[i]);
            	i++;
            }
            JButton cancelButton = new JButton("メニュー画面へ戻る");
            buttonPane.add(cancelButton);
            cancelButton.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e) {
    				allsystem = AllSystem.getAllSystemInstance();
    					gui = GUI.getViewInstance();
    					select = MenuGUI.getSystemSelectInstance();
    					gui.changeGUI(mainFrame,select.getSystemSelectFrame());
    					//オブジェクトごとの予約画面へ遷移するメソッド呼び出し
    			}
    		});
            contentPane.add(buttonPane, BorderLayout.CENTER);
            
            mainFrame.setVisible(false);
    }

    public static TicketShowGUI getTicketFrameInstance() {
    	//TODO
    	TicketShowGUI ticketShowGUI;
		ticketShowGUI = new TicketShowGUI();
		return ticketShowGUI ;
    }
    
    public JFrame getTicketFrame() {
    	return mainFrame;
    }
    

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//label.setText("Push");
	}
    
    // 利用者の操作に応じた処理を実装

}