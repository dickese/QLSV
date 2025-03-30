
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_DN extends JFrame implements ActionListener{
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnExit;

    public GUI_DN() {
        setTitle("Login");
        setSize(320, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel pnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Box pnlA = Box.createVerticalBox();
        
        JPanel pnl1 = new JPanel();
        JLabel lblUsername = new JLabel("Username:");
        txtUsername = new JTextField(15);
        lblUsername.setPreferredSize(new Dimension(100,30));
        pnl1.add(lblUsername);
        pnl1.add(txtUsername);
        
        JPanel pnl2 = new JPanel();
        JLabel lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField(15);
        lblPassword.setPreferredSize(new Dimension(100,30));
        pnl2.add(lblPassword);
        pnl2.add(txtPassword);
        
        JPanel pnl3 = new JPanel();
        btnLogin = new JButton("Login");
        btnExit = new JButton("Exit");
        pnl3.add(btnLogin);
        pnl3.add(btnExit);
        
        pnl.add(pnl1);
        pnl.add(pnl2);
        pnl.add(pnl3);
        
        add(pnl);
        
        //add action
        btnExit.addActionListener(this);
        btnLogin.addActionListener(this);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI_DN();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnLogin)) {
			String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            if (username.equals("admin") && password.equals("1234")) {
                JOptionPane.showMessageDialog(null, "Login Successful");
                dispose();
                new GUI_QLSV();
            } else {
                JOptionPane.showMessageDialog(this, "sai tài khoản");
            }
//        String username = txtUsername.getText();
//        String password = new String(txtPassword.getPassword());
//        if(username.equals("")||password.equals("")) {
//        	
//        }
		}else if(o.equals(btnExit)) {
			System.exit(0);
		}

	}
}

