package domain;

public class Ticket {
	private int ticketNumber;
	private String ticketName;
	private int price;
	private String day;
	private int stock;
	
	//ticketコンストラクタ
	public Ticket(int number, String name, int price, String date, int stock){
		this.ticketNumber = number;
		ticketName = name;
		this.price = price;
		day = date;
		this.stock = stock;
	}
	
	//在庫を返す
	public int check() {
		return stock;
	}
	
	//在庫の書き換え
	public void stock(int sheetsNo) {
		stock -= sheetsNo;
	}
	
	//ticket名の取得
	public String getTicketName() {
		return ticketName;
	}
	
	//ticket番号の取得
	public int getTicketNumber() {
		return ticketNumber;
	}
	
	//価格の取得
	public int getPrice(){
		return price;
	}
	
	//日付の取得
	public String getDay(){
		return day;
	}
	
	//在庫の取得
	public int getStock(){
		return stock;
	}
	
}
