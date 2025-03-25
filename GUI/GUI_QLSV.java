import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI_QLSV extends JFrame {
    private JTextField txtTK, txtMID, txtMN, txtG, txtB,txtS,txtSID,txtSN,txtC;
    private DefaultTableModel dtm;
    private JTable tbl;

    public GUI_QLSV() {
        super("QLSV");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

//		================================================================================
//		Left
        JPanel pnlL = new JPanel();
        pnlL.setBorder(BorderFactory.createTitledBorder("Thông tin tài khoản"));
        pnlL.setPreferredSize(new Dimension(250, 600));
        pnlL.setLayout(new BoxLayout(pnlL, BoxLayout.Y_AXIS));

        JPanel left_info = new JPanel(new GridLayout(5, 1, 0, 0));
        left_info.add(createInfoRow("Tài khoản:", txtTK = new JTextField(10)));
        left_info.add(createInfoRow("Mã giáo vụ:", txtMID = new JTextField(10)));
        left_info.add(createInfoRow("Tên giáo vụ:", txtMN = new JTextField(10)));
        left_info.add(createInfoRow("Giới tính:", txtG = new JTextField(10)));
        left_info.add(createInfoRow("Ngày sinh:", txtB = new JTextField(10)));

        JPanel pnl_btn = new JPanel();
        JPanel pnl_btn_1 = new JPanel();
        JPanel pnl_btn_2 = new JPanel();
        JButton btnCP = new JButton("Đổi mật khẩu");
        JButton btnL = new JButton("Đăng xuất");
        pnl_btn_1.add(btnCP);
        pnl_btn_1.add(btnL);

        JButton btn_U = new JButton("Cập nhật thông tin");
        pnl_btn_2.add(btn_U);

        pnl_btn.add(pnl_btn_1);
        pnl_btn.add(pnl_btn_2);

        pnlL.add(Box.createVerticalGlue());
        pnlL.add(left_info);
        pnlL.add(pnl_btn);
        pnlL.add(Box.createVerticalGlue());

//		================================================================================
//		Right	
        JTabbedPane tbp = new JTabbedPane();
        tbp.addTab("Tài khoản", taiKhoan());
        tbp.addTab("Môn học", monHocPanel());
//        tbp.addTab("Học kì", );
//        tbp.addTab("Lớp học", );
//        tbp.addTab("Kỳ đăng ký học phần", );
//        tbp.addTab("Học phần", );

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(tbp, BorderLayout.CENTER);

//		================================================================================
// 		SplitPane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlL,rightPanel);
        splitPane.setDividerLocation(250);
        splitPane.setResizeWeight(0.2);

        // setVisible
        add(splitPane);
        setVisible(true);
    }

//	=======================================================================================================================
//  methods
    private JPanel createInfoRow(String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        textField.setPreferredSize(new Dimension(120, 20));
        textField.setEditable(false);
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(80, 30));
        panel.add(label);
        panel.add(textField);
        return panel;
    }
    private JPanel createInfoRowEdit(String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        textField.setPreferredSize(new Dimension(120, 20));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(80, 30));
        panel.add(label);
        panel.add(textField);
        return panel;
    }

    private JSplitPane monHocPanel() {
//	=========================================================================tab môn học
//    	Left
        JPanel pnlL = new JPanel(new BorderLayout());
        pnlL.setBorder(BorderFactory.createTitledBorder("Danh sách môn học"));
        
        JPanel pnlN = new JPanel();
        txtS = new JTextField(35);
        pnlN.add(new JLabel("Tìm kiếm"));
        pnlN.add(txtS);
//      table
        String[] columnNames = {"Mã môn học", "Tên môn học", "Số tín chỉ"};
        dtm = new DefaultTableModel(columnNames, 0);
        tbl = new JTable(dtm);
        JScrollPane scrollPane = new JScrollPane(tbl);
        pnlL.add(scrollPane, BorderLayout.CENTER);
        pnlL.add(pnlN,BorderLayout.NORTH);
//  =========================================================================
//      Right
        JPanel pnlR = new JPanel();
        pnlR.setLayout(new BoxLayout(pnlR, BoxLayout.Y_AXIS));
        JPanel pnlR_info = new JPanel(new GridLayout(3,1,0,0));
        pnlR_info.add(createInfoRowEdit("Mã môn học", txtSID=new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Tên môn học", txtSN=new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Số tín chỉ", txtC=new JTextField(10)));
        
        JPanel pnl_btn = new JPanel();
        JPanel pnl_btn_1 = new JPanel();
        JPanel pnl_btn_2 = new JPanel();
        JPanel pnl_btn_3 = new JPanel();
        JButton btnCP = new JButton("Cập nhật thông tin");
        pnl_btn_1.add(btnCP);
        JButton btn_A = new JButton("Thêm môn học");
        pnl_btn_2.add(btn_A);
        JButton btn_D = new JButton("Xóa môn học");
        pnl_btn_3.add(btn_D);

        pnl_btn.add(pnl_btn_1);
        pnl_btn.add(pnl_btn_2);
        pnl_btn.add(pnl_btn_3);
    
        pnlR.add(Box.createVerticalGlue());
        pnlR.add(pnlR_info);
        pnlR.add(pnl_btn);
        pnlR.add(Box.createVerticalGlue());
        
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnlL,pnlR);
        splitPane.setDividerLocation(500);
        splitPane.setResizeWeight(0.2);
        return splitPane;
    }
    private JSplitPane taiKhoan() {
//    	=========================================================================tab tài khoản
//    	Left
        JPanel pnlL = new JPanel(new BorderLayout());
        pnlL.setBorder(BorderFactory.createTitledBorder("Danh sách tài khoản"));
        
        JPanel pnlN = new JPanel();
        txtS = new JTextField(35);
        pnlN.add(new JLabel("Tìm kiếm"));
        pnlN.add(txtS);
//      table
        String[] columnNames = {"Tên tài khoản", "Mật khẩu", "Vai trò"};
        dtm = new DefaultTableModel(columnNames, 0);
        tbl = new JTable(dtm);
        JScrollPane scrollPane = new JScrollPane(tbl);
        pnlL.add(scrollPane, BorderLayout.CENTER);
        pnlL.add(pnlN,BorderLayout.NORTH);
//  =========================================================================
//      Right
        JPanel pnlR = new JPanel();
        pnlR.setLayout(new BoxLayout(pnlR, BoxLayout.Y_AXIS));
        JPanel pnlR_info = new JPanel(new GridLayout(3,1,0,0));
        pnlR_info.add(createInfoRowEdit("Tên tài khoản", txtSID=new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Mật khẩu", txtSN=new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Vai trò", txtC=new JTextField(10)));
        
        JPanel pnl_btn = new JPanel();
        JPanel pnl_btn_1 = new JPanel();
        JPanel pnl_btn_2 = new JPanel();
        JPanel pnl_btn_3 = new JPanel();
        JButton btnCP = new JButton("Cập nhật thông tin");
        pnl_btn_1.add(btnCP);
        JButton btn_A = new JButton("Thêm môn học");
        pnl_btn_2.add(btn_A);
        JButton btn_D = new JButton("Xóa môn học");
        pnl_btn_3.add(btn_D);

        pnl_btn.add(pnl_btn_1);
        pnl_btn.add(pnl_btn_2);
        pnl_btn.add(pnl_btn_3);
    
        pnlR.add(Box.createVerticalGlue());
        pnlR.add(pnlR_info);
        pnlR.add(pnl_btn);
        pnlR.add(Box.createVerticalGlue());
        
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnlL,pnlR);
        splitPane.setDividerLocation(500);
        splitPane.setResizeWeight(0.2);
        return splitPane;
    }

    public static void main(String[] args) {
        new GUI_QLSV();
    }
}
