import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI_QLSV extends JFrame {
    private JTextField txtS;
    private DefaultTableModel dtm;
    private JTable tbl;
	private JButton btnCP;
	private JButton btnL;
	private JButton btn_U;
	private JButton btn_A;
	private JButton btn_D;
	private JTextField txtTK;
	private JTextField txtMID;
	private JTextField txtMN;
	private JTextField txtG;
	private JTextField txtB;
	private JTextField txtMH_ID;
	private JTextField txtMH_N;
	private JTextField txtMH_C;
	private JTextField txtTK_ID;
	private JTextField txtTK_N;
	private JTextField txtTK_P;
	private JTextField txtMK_R;
	private JTextField txtMH_F;
	private DefaultTableModel dtmGiaoVien;
	private JTable tblGiaoVien;
	private JScrollPane scrollPane;
	private JTable tblMonHoc;
	private DefaultTableModel dtmMonHoc;
	private DefaultTableModel dtmTaiKhoan;
	private JTable tblTaiKhoan;
	private DefaultTableModel dtmLop;
	private JTable tblLop;
	private JTextField txtSV_ID;
	private JTextField txtSV_Name;
	private JTextField txtSV_DOB;
	private JTextField txtSV_Email;
	private JTextField txtSV_Gender;
	private JTextField txtSV_Phone;
	private JTextField txtSV_RegDate;
	private JTextField txtTS_ID;
	private JTextField txtTS_IDSV;
	private JTextField txtTS_S;
	private JTextField txtTS_ST;
	private JTextField txtKQ_IDSV;
	private JTextField txtKQ_MHP;
	private JTextField txtKQ_DGK;
	private JTextField txtKQ_DCK;
	private JTextField txtKQ_DTK;
	private JTextField txtKQ_XL;
	private JTextField txtHP_MHP;
	private JTextField txtHP_N;
	private JTextField txtHP_MMH;
	private JTextField txtHP_ML;
	private JTextField txtGV_ID;
	private JTextField txtGV_N;
	private JTextField txtGV_E;
	private JTextField txtGV_SDT;
	private JTextField txtGV_CN;
	private JTextField txtLH_ID;
	private JTextField txtLH_N;
	private JTextField txtLH_K;
	private JTextField txtLH_NH;
	private JTextField txtLH_MGV;

    public GUI_QLSV() {
        super("QLSV");
        setSize(1400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

//		================================================================================
//		Left
        JPanel pnlL = new JPanel();
        pnlL.setBorder(BorderFactory.createTitledBorder("Thông tin tài khoản"));

        Box left_info = Box.createVerticalBox();
        left_info.add(createInfoRow("Tài khoản:", txtTK = new JTextField(10)));
        left_info.add(Box.createVerticalStrut(10));
        left_info.add(createInfoRow("Mã giáo vụ:", txtMID = new JTextField(10)));
        left_info.add(Box.createVerticalStrut(10));
        left_info.add(createInfoRow("Tên giáo vụ:", txtMN = new JTextField(10)));
        left_info.add(Box.createVerticalStrut(10));
        left_info.add(createInfoRow("Giới tính:", txtG = new JTextField(10)));
        left_info.add(Box.createVerticalStrut(10));
        left_info.add(createInfoRow("Ngày sinh:", txtB = new JTextField(10)));

        JPanel pnl_btn_1 = new JPanel();
        JPanel pnl_btn_2 = new JPanel();
        btnCP = new JButton("Đổi mật khẩu");
        btnL = new JButton("Đăng xuất");
        pnl_btn_1.add(btnCP);
        pnl_btn_1.add(btnL);

        JButton btn_U = new JButton("Cập nhật thông tin");
        pnl_btn_2.add(btn_U);
        
        left_info.add(pnl_btn_1);
        left_info.add(pnl_btn_2);
        
        pnlL.add(left_info);

//		================================================================================
//		Right	
        JTabbedPane tbp = new JTabbedPane();
        tbp.addTab("Tài khoản", taiKhoan());
        tbp.addTab("Môn học", monHoc());
        tbp.addTab("Giáo viên", giaoVien());
        tbp.addTab("Lớp học", lopHoc());
        tbp.addTab("Học phần", hocPhan());
        tbp.addTab("Kết quả", ketQua());
        tbp.addTab("Sinh viên", sinhVien());
        tbp.addTab("Tuyển sinh", tuyenSinh());
        

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
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        textField.setPreferredSize(new Dimension(120, 20));
        textField.setEditable(false);
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(80, 30));
        panel.add(label);
        panel.add(textField);
        return panel;
    }
    private JPanel createInfoRowEdit(String labelText, JTextField textField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
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
        JPanel pnlN_S = new JPanel(); // thanh tìm kiếm
        txtS = new JTextField(30);
        pnlN_S.add(new JLabel("Tìm kiếm"));
        pnlN_S.add(txtS);
        pnlN.add(pnlN_S);
//      table
        String[] columnNames = {"Mã môn học", "Tên môn học", "Số tín chỉ","Chuyên ngành"};
        dtmMonHoc = new DefaultTableModel(columnNames, 0);
        tblMonHoc = new JTable(dtmMonHoc);
        JScrollPane scrollPane = new JScrollPane(tblMonHoc);
        pnlL.add(scrollPane, BorderLayout.CENTER);
        pnlL.add(pnlN,BorderLayout.NORTH);
//  =========================================================================
//      Right
        JPanel pnlR = new JPanel();
        Box pnlR_info = Box.createVerticalBox();
        pnlR_info.add(createInfoRowEdit("Mã môn học", txtMH_ID=new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Tên môn học", txtMH_N=new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Số tín chỉ", txtMH_C=new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Chuyên ngành", txtMH_F=new JTextField(10)));
        
        JPanel pnl_btn = new JPanel();
        btn_U = new JButton("Cập nhật");
        pnl_btn.add(btn_U);
        btn_A = new JButton("Thêm");
        pnl_btn.add(btn_A);
        btn_D = new JButton("Xóa");
        pnl_btn.add(btn_D);
        
        pnlR_info.add(pnl_btn);
        pnlR.add(pnlR_info);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnlL,pnlR);
        splitPane.setDividerLocation(800);
        splitPane.setResizeWeight(0.2);
        return splitPane;
    }
    private JSplitPane taiKhoan() {
//    	=========================================================================tab tài khoản
//    	Left
        JPanel pnlL = new JPanel(new BorderLayout());
        pnlL.setBorder(BorderFactory.createTitledBorder("Danh sách tài khoản"));
        
        JPanel pnlN = new JPanel();
        
        JPanel pnlN_S = new JPanel(); // thanh tìm kiếm
        txtS = new JTextField(30);
        pnlN_S.add(new JLabel("Tìm kiếm"));
        pnlN_S.add(txtS);
        pnlN.add(pnlN_S);
//      table
        String[] columnNames = {"Mã tài khoản","Tên tài khoản", "Mật khẩu", "Vai trò"};
        dtmTaiKhoan = new DefaultTableModel(columnNames, 0);
        tblTaiKhoan = new JTable(dtmTaiKhoan);
        JScrollPane scrollPane = new JScrollPane(tblTaiKhoan);
        pnlL.add(scrollPane, BorderLayout.CENTER);
        pnlL.add(pnlN,BorderLayout.NORTH);
//  =========================================================================
//      Right
        JPanel pnlR = new JPanel();
        Box pnlR_info = Box.createVerticalBox();
        pnlR_info.add(createInfoRowEdit("Mã tài khoản", txtTK_ID=new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Tên tài khoản", txtTK_N=new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Mật khẩu", txtTK_P=new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Vai trò", txtMK_R=new JTextField(10)));
        
        JPanel pnl_btn = new JPanel();
        btn_U = new JButton("Cập nhật");
        pnl_btn.add(btn_U);
        btn_A = new JButton("Thêm");
        pnl_btn.add(btn_A);
        btn_D = new JButton("Xóa");
        pnl_btn.add(btn_D);
        
        pnlR_info.add(pnl_btn);
        pnlR.add(pnlR_info);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnlL,pnlR);
        splitPane.setDividerLocation(800);
        splitPane.setResizeWeight(0.2);
        return splitPane;
    }
    // ============================================================================ Tab lớp học
    private JSplitPane lopHoc() {
        //Left
        JPanel pnlL = new JPanel(new BorderLayout());
        pnlL.setBorder(BorderFactory.createTitledBorder("Danh sách lớp học"));
    
        JPanel pnlN = new JPanel();
        JPanel pnlN_S = new JPanel(); // thanh tìm kiếm
        txtS = new JTextField(30);
        pnlN_S.add(new JLabel("Tìm kiếm"));
        pnlN_S.add(txtS);
        pnlN.add(pnlN_S);
        // table
        String[] columnNames = {"Mã lớp", "Tên lớp", "Khoa", "Năm học", "Mã giảng viên"};
        dtmLop = new DefaultTableModel(columnNames, 0);
        tblLop = new JTable(dtmLop);
        JScrollPane scrollPane = new JScrollPane(tblLop);
        pnlL.add(scrollPane, BorderLayout.CENTER);
        pnlL.add(pnlN, BorderLayout.NORTH);
        // Right
        JPanel pnlR = new JPanel();
        Box pnlR_info = Box.createVerticalBox();
        pnlR_info.add(createInfoRowEdit("Mã lớp",txtLH_ID = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Tên lớp",txtLH_N = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Khoa",txtLH_K = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Năm học",txtLH_NH = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Mã giảng viên",txtLH_MGV = new JTextField(10)));
    
        JPanel pnl_btn = new JPanel();
        btn_U = new JButton("Cập nhật");
        pnl_btn.add(btn_U);
        btn_A = new JButton("Thêm");
        pnl_btn.add(btn_A);
        btn_D = new JButton("Xóa");
        pnl_btn.add(btn_D);
        
        pnlR_info.add(pnl_btn);
        pnlR.add(pnlR_info);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnlL,pnlR);
        splitPane.setDividerLocation(800);
        splitPane.setResizeWeight(0.2);
        return splitPane;
    }
    //=========================================================================Tab Giáo viên
    private JSplitPane giaoVien() {
        // Left Panel
        JPanel pnlL = new JPanel(new BorderLayout());
        pnlL.setBorder(BorderFactory.createTitledBorder("Danh sách giáo viên"));
    
        JPanel pnlN = new JPanel();
        JPanel pnlN_S = new JPanel(); // thanh tìm kiếm
        txtS = new JTextField(30);
        pnlN_S.add(new JLabel("Tìm kiếm"));
        pnlN_S.add(txtS);
        pnlN.add(pnlN_S);
    
        String[] columnNames = {"Mã giáo viên", "Tên giáo viên","Email","Số điện thoại","Chuyên ngành"};
        dtmGiaoVien = new DefaultTableModel(columnNames, 0);
        tblGiaoVien = new JTable(dtmGiaoVien);
        scrollPane = new JScrollPane(tblGiaoVien);
        pnlL.add(scrollPane, BorderLayout.CENTER);
        pnlL.add(pnlN, BorderLayout.NORTH);
    
        // Right Panel
        JPanel pnlR = new JPanel();
        Box pnlR_info = Box.createVerticalBox();
        pnlR_info.add(createInfoRowEdit("Mã giáo viên",txtGV_ID = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Tên giáo viên",txtGV_N = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Email",txtGV_E = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Số điện thoại",txtGV_SDT = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Chuyên ngành",txtGV_CN = new JTextField(10)));
    
        JPanel pnl_btn = new JPanel();
        btn_U = new JButton("Cập nhật");
        pnl_btn.add(btn_U);
        btn_A = new JButton("Thêm");
        pnl_btn.add(btn_A);
        btn_D = new JButton("Xóa");
        pnl_btn.add(btn_D);
        
        pnlR_info.add(pnl_btn);
        pnlR.add(pnlR_info);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnlL,pnlR);
        splitPane.setDividerLocation(800);
        splitPane.setResizeWeight(0.2);
        return splitPane;
    }  
    
    //=========================================================================Tab HocPhan
    private JSplitPane hocPhan() {
        // Left Panel
        JPanel pnlL = new JPanel(new BorderLayout());
        pnlL.setBorder(BorderFactory.createTitledBorder("Danh sách học phần"));
    
        JPanel pnlN = new JPanel();
        JPanel pnlN_S = new JPanel(); // thanh tìm kiếm
        txtS = new JTextField(30);
        pnlN_S.add(new JLabel("Tìm kiếm"));
        pnlN_S.add(txtS);
        pnlN.add(pnlN_S);
        
        // table        
        String[] columnNames = {"Mã học phần", "Tên học phần", "Mã môn học", "Mã lớp"};
        DefaultTableModel dtmHocPhan = new DefaultTableModel(columnNames, 0);
        JTable tblHocPhan = new JTable(dtmHocPhan);
        JScrollPane scrollPane = new JScrollPane(tblHocPhan);
        pnlL.add(scrollPane, BorderLayout.CENTER);
        pnlL.add(pnlN, BorderLayout.NORTH);
    
        // Right Panel
        JPanel pnlR = new JPanel();
        Box pnlR_info = Box.createVerticalBox();
        pnlR_info.add(createInfoRowEdit("Mã học phần",txtHP_MHP = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Tên học phần",txtHP_N = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Mã môn học",txtHP_MMH = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Mã lớp",txtHP_ML = new JTextField(10)));
    
        JPanel pnl_btn = new JPanel();
        btn_U = new JButton("Cập nhật");
        pnl_btn.add(btn_U);
        btn_A = new JButton("Thêm");
        pnl_btn.add(btn_A);
        btn_D = new JButton("Xóa");
        pnl_btn.add(btn_D);
        
        pnlR_info.add(pnl_btn);
        pnlR.add(pnlR_info);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnlL,pnlR);
        splitPane.setDividerLocation(800);
        splitPane.setResizeWeight(0.2);
        return splitPane;
    }
    //Tab ket qua============================================================
    private JSplitPane ketQua() {
        // Left Panel
        JPanel pnlL = new JPanel(new BorderLayout());
        pnlL.setBorder(BorderFactory.createTitledBorder("Danh sách kết quả học tập"));
    
        JPanel pnlN = new JPanel();
        JPanel pnlN_S = new JPanel(); // thanh tìm kiếm
        txtS = new JTextField(30);
        pnlN_S.add(new JLabel("Tìm kiếm"));
        pnlN_S.add(txtS);
        pnlN.add(pnlN_S);
        
//      Table
        String[] columnNames = {"Mã sinh viên", "Mã học phần", "Điểm giữa kỳ", "Điểm cuối kỳ", "Điểm tổng kết", "Xếp loại"};
        DefaultTableModel dtmKetQua = new DefaultTableModel(columnNames, 0);
        JTable tblKetQua = new JTable(dtmKetQua);
        JScrollPane scrollPane = new JScrollPane(tblKetQua);
        pnlL.add(scrollPane, BorderLayout.CENTER);
        pnlL.add(pnlN, BorderLayout.NORTH);
    
        // Right Panel
        JPanel pnlR = new JPanel();
        Box pnlR_info = Box.createVerticalBox();
        pnlR_info.add(createInfoRowEdit("Mã sinh viên",txtKQ_IDSV = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Mã học phần",txtKQ_MHP = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Điểm giữa kỳ",txtKQ_DGK = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Điểm cuối kỳ",txtKQ_DCK = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Điểm tổng kết",txtKQ_DTK = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Xếp loại",txtKQ_XL = new JTextField(10)));
    
        JPanel pnl_btn = new JPanel();
        btn_U = new JButton("Cập nhật");
        pnl_btn.add(btn_U);
        btn_A = new JButton("Thêm");
        pnl_btn.add(btn_A);
        btn_D = new JButton("Xóa");
        pnl_btn.add(btn_D);
        
        pnlR_info.add(pnl_btn);
        pnlR.add(pnlR_info);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnlL,pnlR);
        splitPane.setDividerLocation(800);
        splitPane.setResizeWeight(0.2);
        return splitPane;
    }
  //============================================================Tab Sinh viên
    private JSplitPane sinhVien() {
        // Left Panel
        JPanel pnlL = new JPanel(new BorderLayout());
        pnlL.setBorder(BorderFactory.createTitledBorder("Danh sách sinh viên"));
    
        JPanel pnlN = new JPanel();
        JPanel pnlN_S = new JPanel(); // thanh tìm kiếm
        txtS = new JTextField(30);
        pnlN_S.add(new JLabel("Tìm kiếm"));
        pnlN_S.add(txtS);
        pnlN.add(pnlN_S);
        
//      Table
        String[] columnNames = {"Mã sinh viên", "Tên sinh viên", "Ngày sinh", "Giới tính", "Mã lớp học", "Email","Số điện thoại","địa chỉ","Ngày đăng kí"};
        DefaultTableModel dtmKetQua = new DefaultTableModel(columnNames, 0);
        JTable tblKetQua = new JTable(dtmKetQua);
        JScrollPane scrollPane = new JScrollPane(tblKetQua);
        pnlL.add(scrollPane, BorderLayout.CENTER);
        pnlL.add(pnlN, BorderLayout.NORTH);
    
        // Right Panel
        JPanel pnlR = new JPanel();
        Box pnlR_info = Box.createVerticalBox();

        pnlR_info.add(createInfoRowEdit("Mã sinh viên", txtSV_ID = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Tên sinh viên", txtSV_Name = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Ngày sinh", txtSV_DOB = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Giới tính", txtSV_Gender = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Email", txtSV_Email = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Số điện thoại", txtSV_Phone = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Ngày đăng ký", txtSV_RegDate = new JTextField(10)));
    
        JPanel pnl_btn = new JPanel();
        btn_U = new JButton("Cập nhật");
        pnl_btn.add(btn_U);
        btn_A = new JButton("Thêm");
        pnl_btn.add(btn_A);
        btn_D = new JButton("Xóa");
        pnl_btn.add(btn_D);
        
        pnlR_info.add(pnl_btn);
        pnlR.add(pnlR_info);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnlL,pnlR);
        splitPane.setDividerLocation(800);
        splitPane.setResizeWeight(0.2);
        return splitPane;
    }
    private JSplitPane tuyenSinh() {
        // Left Panel
        JPanel pnlL = new JPanel(new BorderLayout());
        pnlL.setBorder(BorderFactory.createTitledBorder("Danh sách tuyển sinh"));
    
        JPanel pnlN = new JPanel();
        JPanel pnlN_S = new JPanel(); // thanh tìm kiếm
        txtS = new JTextField(30);
        pnlN_S.add(new JLabel("Tìm kiếm"));
        pnlN_S.add(txtS);
        pnlN.add(pnlN_S);
        
        // table        
        String[] columnNames = {"Mã tuyển sinh", "Mã sinh viên", "Học kỳ", "Trạng thái"};
        DefaultTableModel dtmHocPhan = new DefaultTableModel(columnNames, 0);
        JTable tblHocPhan = new JTable(dtmHocPhan);
        JScrollPane scrollPane = new JScrollPane(tblHocPhan);
        pnlL.add(scrollPane, BorderLayout.CENTER);
        pnlL.add(pnlN, BorderLayout.NORTH);
    
        // Right Panel
        JPanel pnlR = new JPanel();
        Box pnlR_info = Box.createVerticalBox();
        pnlR_info.add(createInfoRowEdit("Mã tuyển sinh",txtTS_ID = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Mã sinh viên",txtTS_IDSV = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Mã Học kỳ",txtTS_S = new JTextField(10)));
        pnlR_info.add(createInfoRowEdit("Mã Trạng thái",txtTS_ST = new JTextField(10)));
    
        JPanel pnl_btn = new JPanel();
        btn_U = new JButton("Cập nhật");
        pnl_btn.add(btn_U);
        btn_A = new JButton("Thêm");
        pnl_btn.add(btn_A);
        btn_D = new JButton("Xóa");
        pnl_btn.add(btn_D);
        
        pnlR_info.add(pnl_btn);
        pnlR.add(pnlR_info);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnlL,pnlR);
        splitPane.setDividerLocation(800);
        splitPane.setResizeWeight(0.2);
        return splitPane;
    }
    

    public static void main(String[] args) {
        new GUI_QLSV();
    }
}
