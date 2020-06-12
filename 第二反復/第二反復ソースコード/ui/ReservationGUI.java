package ui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Ticket;
import management.AllSystem;

public class ReservationGUI extends JFrame{
    AllSystem allsystem;
    MenuGUI select;
    Ticket t;
    JPanel jPanel;
    JPanel buttonPane;
    JLabel jLabel;
    JComboBox combo;
    JFrame reserveFrame;
    JFrame nextframe;
    GUI gui;
    DoneReservationGUI complete;
     private Container contentPane;
    
    public ReservationGUI(Ticket t) {
        this.t = t;
        reserveFrame = new JFrame("予約");
        reserveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reserveFrame.setSize(300, 120);
        reserveFrame.setLocationRelativeTo(null);
        contentPane = reserveFrame.getContentPane();
        String[] s = new String[t.getStock()];
        int i;
        for(i =0;i<t.getStock();i++) {
            s[i] = Integer.toString(i + 1);
        }
        combo = new JComboBox(s);
        if(i>10) {
            combo.setMaximumRowCount(10);
        }else {
            combo.setMaximumRowCount(t.getStock());
        }
        
        
        JButton button = new JButton("予約する");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int reserveNo= Integer.parseInt((String)combo.getItemAt(combo.getSelectedIndex()));
                System.out.println(reserveNo);
                //reserveNo = combo.getSelectedIndex() + 2;
                    allsystem = AllSystem.getAllSystemInstance();
                    allsystem.ticketReserve(reserveNo,t);
                    complete = DoneReservationGUI.getReserveCompleteInstance();
                    nextframe = complete.getReserveCompleteFrame();
                    gui = GUI.getViewInstance();
                    gui.changeGUI(reserveFrame,nextframe);
                }
            });
        jPanel = new JPanel();
        jPanel.add(new JLabel(t.getTicketName()));
        jPanel.add(combo);
        jPanel.add(button);
        
        buttonPane = new JPanel();
        JButton cancelButton = new JButton("メニュー画面へ戻る");
        buttonPane.add(cancelButton);
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                allsystem = AllSystem.getAllSystemInstance();
                    gui = GUI.getViewInstance();
                    select = MenuGUI.getSystemSelectInstance();
                    gui.changeGUI(reserveFrame,select.getSystemSelectFrame());
                    //オブジェクトごとの予約画面へ遷移するメソッド呼び出し
            }
        });
        contentPane.add(buttonPane, BorderLayout.SOUTH);
        
        contentPane.add(jPanel, BorderLayout.CENTER);
    }

 

    public JFrame getReserveFrame() {
        return reserveFrame;
    }
    

 

    
}