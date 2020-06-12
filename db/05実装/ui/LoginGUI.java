package ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import management.AllSystem;

public class LoginGUI extends JFrame{
	private AllSystem allsystem;
	private GUI view;
	private JFrame loginpage;
	private Container contentPane;
	//SystemSelect select;

	private static LoginGUI loginGUI = new LoginGUI();
	private LoginGUI() {
		loginpage = new JFrame("ログイン");
		loginpage.setTitle("ログイン画面");
		loginpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginpage.setSize(300, 120);
		loginpage.setLocationRelativeTo(null);
		contentPane = loginpage.getContentPane();
		final JTextField textField = new JTextField();
		final JPasswordField passwordField = new JPasswordField();
		final JButton button = new JButton("送信");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String pass = new String(passwordField.getPassword());
				allsystem = AllSystem.getAllSystemInstance();
				allsystem.setID(id);
				allsystem.setPass(pass);
				boolean userCheck = allsystem.userLogin();
				if(userCheck == true) {
					JOptionPane.showMessageDialog(null, "認証が成功しました。","userpass",JOptionPane.PLAIN_MESSAGE);
					MenuGUI select = MenuGUI.getSystemSelectInstance();
					JFrame nextframe = select.getSystemSelectFrame();
					view = GUI.getViewInstance();
					view.changeGUI(loginpage,nextframe);
				} else {
					JOptionPane.showMessageDialog(null, "ユーザーIDかパスワードが間違っています。","usererr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3,2));
		panel1.add(new JLabel("ユーザーID:", SwingConstants.LEFT));
		panel1.add(textField);
		panel1.add(new JLabel("パスワード:", SwingConstants.LEFT));
		panel1.add(passwordField);
		panel1.add(button);
		contentPane.add(panel1, BorderLayout.NORTH);
	}
	
	public static LoginGUI getLoginInstance() {
		return loginGUI;
	}
	
	public JFrame getLoginFrame() {
		return loginpage;
	}
}
