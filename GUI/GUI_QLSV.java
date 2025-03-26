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
        tbp.addTab("Môn học", monHoc());
        tbp.addTab("Học kỳ", hocKy());
        tbp.addTab("Lớp học", lopHoc());
        tbp.addTab("Học phần", hocPhan());
        tbp.addTab("Kết quả", ketQua());
        

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

    private JSplitPane monHoc() {
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
    // Tab lop hoc============================================================================
    private JSplitPane lopHoc() {
        //Left
        JPanel pnlL = new JPanel(new BorderLayout());
        pnlL.setBorder(BorderFactory.createTitledBorder("Danh sách lớp học"));
    
        JPanel pnlN = new JPanel();
        JTextField txtSearchLop = new JTextField(35);
        pnlN.add(new JLabel("Tìm kiếm"));
        pnlN.add(txtSearchLop);
        // table
        String[] columnNames = {"Mã lớp", "Tên lớp", "Khoa", "Năm học", "Mã giảng viên"};
        DefaultTableModel dtmLop = new DefaultTableModel(columnNames, 0);
        JTable tblLop = new JTable(dtmLop);
        JScrollPane scrollPane = new JScrollPane(tblLop);
        pnlL.add(scrollPane, BorderLayout.CENTER);
        pnlL.add(pnlN, BorderLayout.NORTH);
        // Right
        JPanel pnlR = new JPanel();
        pnlR.setLayout(new BoxLayout(pnlR, BoxLayout.Y_AXIS));
        JPanel pnlR_info = new JPanel(new GridLayout(5, 1, 0, 0));
        pnlR_info.add(createInfoRowEdit("Mã lớp", new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Tên lớp", new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Khoa", new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Năm học", new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Mã giảng viên", new JTextField(10)));
    
        JPanel pnl_btn = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btn_UD = new JButton("Cập nhật lớp học");
        pnl_btn.add(btn_UD);
        JButton btn_A = new JButton("Thêm lớp học");
        pnl_btn.add(btn_A); 
        JButton btn_D = new JButton("Xóa lớp học");
        pnl_btn.add(btn_D); 
    
        pnlR.add(Box.createVerticalGlue());
        pnlR.add(pnlR_info);
        pnlR.add(pnl_btn);
        pnlR.add(Box.createVerticalGlue());
    
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlL, pnlR);
        splitPane.setDividerLocation(500);
        splitPane.setResizeWeight(0.2);
        return splitPane;
    }
    //Tab hoc ky=====================================================
    private JSplitPane hocKy() {
        // Left Panel
        JPanel pnlL = new JPanel(new BorderLayout());
        pnlL.setBorder(BorderFactory.createTitledBorder("Danh sách học kỳ"));
    
        JPanel pnlN = new JPanel();
        JTextField txtSearchHocKy = new JTextField(35);
        pnlN.add(new JLabel("Tìm kiếm"));
        pnlN.add(txtSearchHocKy);
    
        String[] columnNames = {"Mã học kỳ", "Tên học kỳ", "Năm học"};
        DefaultTableModel dtmHocKy = new DefaultTableModel(columnNames, 0);
        JTable tblHocKy = new JTable(dtmHocKy);
        JScrollPane scrollPane = new JScrollPane(tblHocKy);
        pnlL.add(scrollPane, BorderLayout.CENTER);
        pnlL.add(pnlN, BorderLayout.NORTH);
    
        // Right Panel
        JPanel pnlR = new JPanel();
        pnlR.setLayout(new BoxLayout(pnlR, BoxLayout.Y_AXIS));
        JPanel pnlR_info = new JPanel(new GridLayout(3, 1, 0, 0));
        pnlR_info.add(createInfoRowEdit("Mã học kỳ", new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Tên học kỳ", new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Năm học", new JTextField(10)));
    
        JPanel pnl_btn = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btn_UD = new JButton("Cập nhật học kỳ");
        pnl_btn.add(btn_UD);
        JButton btn_A = new JButton("Thêm học kỳ");
        pnl_btn.add(btn_A); 
        JButton btn_D = new JButton("Xóa học kỳ");
        pnl_btn.add(btn_D); 
    
        pnlR.add(Box.createVerticalGlue());
        pnlR.add(pnlR_info);
        pnlR.add(pnl_btn);
        pnlR.add(Box.createVerticalGlue());
    
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlL, pnlR);
        splitPane.setDividerLocation(500);
        splitPane.setResizeWeight(0.2);
        return splitPane;
    }  
    
    //Tab hoc phan=============================================================
    private JSplitPane hocPhan() {
        // Left Panel
        JPanel pnlL = new JPanel(new BorderLayout());
        pnlL.setBorder(BorderFactory.createTitledBorder("Danh sách học phần"));
    
        JPanel pnlN = new JPanel();
        JTextField txtSearchHocPhan = new JTextField(35);
        pnlN.add(new JLabel("Tìm kiếm"));
        pnlN.add(txtSearchHocPhan);
    
        String[] columnNames = {"Mã học phần", "Tên học phần", "Mã môn học", "Mã lớp"};
        DefaultTableModel dtmHocPhan = new DefaultTableModel(columnNames, 0);
        JTable tblHocPhan = new JTable(dtmHocPhan);
        JScrollPane scrollPane = new JScrollPane(tblHocPhan);
        pnlL.add(scrollPane, BorderLayout.CENTER);
        pnlL.add(pnlN, BorderLayout.NORTH);
    
        // Right Panel
        JPanel pnlR = new JPanel();
        pnlR.setLayout(new BoxLayout(pnlR, BoxLayout.Y_AXIS));
        JPanel pnlR_info = new JPanel(new GridLayout(4, 1, 0, 0));
        pnlR_info.add(createInfoRowEdit("Mã học phần", new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Tên học phần", new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Mã môn học", new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Mã lớp", new JTextField(10)));
    
        JPanel pnl_btn = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btn_UD = new JButton("Cập nhật học phần");
        pnl_btn.add(btn_UD);
        JButton btn_A = new JButton("Thêm học phần");
        pnl_btn.add(btn_A);
        JButton btn_D = new JButton("Xóa học phần");
        pnl_btn.add(btn_D);
    
        pnlR.add(Box.createVerticalGlue());
        pnlR.add(pnlR_info);
        pnlR.add(pnl_btn);
        pnlR.add(Box.createVerticalGlue());
    
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlL, pnlR);
        splitPane.setDividerLocation(500);
        splitPane.setResizeWeight(0.2);
        return splitPane;
    }
    //Tab ket qua============================================================
    private JSplitPane ketQua() {
        // Left Panel
        JPanel pnlL = new JPanel(new BorderLayout());
        pnlL.setBorder(BorderFactory.createTitledBorder("Danh sách kết quả học tập"));
    
        JPanel pnlN = new JPanel();
        JTextField txtSearchKetQua = new JTextField(35);
        pnlN.add(new JLabel("Tìm kiếm"));
        pnlN.add(txtSearchKetQua);
    
        String[] columnNames = {"Mã sinh viên", "Mã học phần", "Điểm giữa kỳ", "Điểm cuối kỳ", "Điểm tổng kết", "Xếp loại"};
        DefaultTableModel dtmKetQua = new DefaultTableModel(columnNames, 0);
        JTable tblKetQua = new JTable(dtmKetQua);
        JScrollPane scrollPane = new JScrollPane(tblKetQua);
        pnlL.add(scrollPane, BorderLayout.CENTER);
        pnlL.add(pnlN, BorderLayout.NORTH);
    
        // Right Panel
        JPanel pnlR = new JPanel();
        pnlR.setLayout(new BoxLayout(pnlR, BoxLayout.Y_AXIS));
        JPanel pnlR_info = new JPanel(new GridLayout(6, 1, 0, 0));
        pnlR_info.add(createInfoRowEdit("Mã sinh viên", new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Mã học phần", new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Điểm giữa kỳ", new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Điểm cuối kỳ", new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Điểm tổng kết", new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Xếp loại", new JTextField(10)));
    
        JPanel pnl_btn = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btn_UD = new JButton("Cập nhật kết quả");
        pnl_btn.add(btn_UD);
        JButton btn_A = new JButton("Thêm kết quả");
        pnl_btn.add(btn_A);
        JButton btn_D = new JButton("Xóa kết quả");
        pnl_btn.add(btn_D);
    
        pnlR.add(Box.createVerticalGlue());
        pnlR.add(pnlR_info);
        pnlR.add(pnl_btn);
        pnlR.add(Box.createVerticalGlue());
    
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlL, pnlR);
        splitPane.setDividerLocation(500);
        splitPane.setResizeWeight(0.2);
        return splitPane;
    }
    

    public static void main(String[] args) {
        new GUI_QLSV();
    }
}
