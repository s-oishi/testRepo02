package ui;

import javax.swing.JFrame;

public class GUI {
	LoginGUI loginGUI;
	MenuGUI select;
	TicketShowGUI ticketframe;
	ReservationShowGUI reserveframe;
	DoneCancelGUI cancelend;
    DoneReservationGUI complete;
	JFrame loginpage;
	JFrame systemselectpage;
	JFrame ticketframepage;
	JFrame reserveframepage; 
	JFrame cancelendpage;
	JFrame completepage;
	
	private static GUI view = new GUI();
	private GUI() {
		loginGUI = LoginGUI.getLoginInstance();
		this.loginpage = loginGUI.getLoginFrame();
		loginpage.setVisible(true);
		select = MenuGUI.getSystemSelectInstance();
		this.systemselectpage = select.getSystemSelectFrame();
		systemselectpage.setVisible(false);
		//TODO
		ticketframe = new TicketShowGUI/*.getTicketFrameInstance*/();
		this.ticketframepage = ticketframe.getTicketFrame();
		ticketframepage.setVisible(false);
		
		//this.reserveframepage = reserveframe.getReserveFrame();
		ticketframepage.setVisible(false);
		cancelend = DoneCancelGUI.getCancelEndInstance();
		this.cancelendpage = cancelend.getCancelEndFrame();
		cancelendpage.setVisible(false);
		complete = DoneReservationGUI.getReserveCompleteInstance();
        this.completepage = complete.getReserveCompleteFrame();
        completepage.setVisible(false);
		
	}
	
	public void changeGUI(JFrame nowframe,JFrame nextframe) {
		nowframe.setVisible(false);
		nextframe.setVisible(true);
	}
	
	public static GUI getViewInstance() {
		return view;
	}
}
