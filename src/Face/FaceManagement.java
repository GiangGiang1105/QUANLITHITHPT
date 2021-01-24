package Face;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

import Dao.PeopleExamDao;
import Model.PeopleExam;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class FaceManagement extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTimkiem;
	private JTable table;
	private JScrollPane scrollableTextArea ;
	private JTextField txtID;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtTimKiem; 
	private JComboBox<Object> cbGT;
	private JComboBox<Object> cbDoituong;
	private JComboBox<Object> cbNgay; 
	private JButton btnTimkiem; 
	private JComboBox<Object> cbThang; 
	private JComboBox<Object> cbNam; 
	private JComboBox<Object> cbKV;  
	private JButton btnThem;
	private JButton btnSua; 
	private JButton btnXoa; 
	private JCheckBox mon1; 
	private JCheckBox mon2; 
	private JCheckBox mon3; 
	private JCheckBox mon4; 
	private JCheckBox mon5; 
	private JCheckBox mon6; 
	private JCheckBox mon7; 
	private JCheckBox mon8; 
	private JComboBox<Object> cbOptionSort; 
	private  DefaultTableModel model; 
	private String optionSort; 
	private String option[] = {
			"Mặc định", 
			"Sắp xếp theo giới tính", 
			"Sắp xếp theo khu vực", 
			"Sắp xếp theo đối tượng"
	}; 
	private String ngay[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", 
			"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
	}; 
	private String gioitinh[] = {"Nam", "Nu"}; 
	private String thang[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}; 
	private String nam[] = {"1980","1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990","1991",  "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002"};
	private JTextField txtDiachi;
	private JTextField txtTruong;
	private String khuvuc[] = {"1", "2", "3"}; 
	private String doituong[] = {"Bình thường", "Hộ nghèo", "Cận nghèo", "Thương binh, liệt sĩ", "Con cán bộ cấp cao"};
	private int mId; 
	private String mHo; 
	private String mTen; 
	private int mNgay;  
	private int mThang;   
	private int mNam;
	private String mDate;
	private String mDiachi; 
	private int mKhuvuc;
	private String mDoituong; 
	private String mTruong; 
	private String mGioitinh; 
	private boolean mToan; 
	private boolean mLy;
	private boolean mHoa;
	private boolean mSinh;
	private boolean mVan;
	private boolean mSu;
	private boolean mDia;
	private boolean mAnh;
	private PeopleExam peopleExam; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FaceManagement frame = new FaceManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FaceManagement() {
		setTitle("Qu\u1EA3n l\u00ED sinh vi\u00EAn thi t\u1ED1t nghi\u1EC7p THPT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Ph\u1EA7n m\u1EC1m qu\u1EA3n l\u00ED thi t\u1ED1t nghi\u1EC7p THPT  t\u1EA1i TP. \u0110\u00E0 N\u1EB5ng ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		txtTimkiem = new JTextField();
		txtTimkiem.setColumns(10);
		btnTimkiem = new JButton("T\u00ECm ki\u1EBFm ");
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String timkiem = txtTimkiem.getText(); 
				funTimKiem(timkiem); 
			}

			
		});
		String col[] = {"ID", "Họ", "Tên", "Giới Tính", "Ngày sinh ", "Địa chỉ", "Khu vực", "Đối tượng", "Trường", "Toán", "Lý", "Hóa", "Sinh", "Văn", "Sử", "Địa", "Anh"};
		String data[][] = {};
		model = new DefaultTableModel(data,col);
		table = new JTable(model);
		/*
		 * table.getSelectionModel().addListSelectionListener(new
		 * ListSelectionListener() {
		 * 
		 * @Override public void valueChanged(ListSelectionEvent e) {
		 * getDataFromTable(); setValue(); System.out.println("selected"); }
		 * 
		 * });
		 */
		table.addMouseListener((MouseListener) new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				getDataFromTable();
				setValue();
				System.out.println("selected"); 
				
				
			}
		});
		scrollableTextArea = new JScrollPane(table);
		scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
	    scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("H\u1ECD");
		
		JLabel lblNewLabel_4 = new JLabel("Ng\u00E0y sinh");
		
		cbNgay = new JComboBox<Object>(ngay);
		
		cbThang = new JComboBox<Object>(thang);
		 
		
		cbNam = new JComboBox<Object>(nam);
		
		JLabel lblNewLabel_5 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		
		JLabel lblNewLabel_6 = new JLabel("\u0110\u1ED1i t\u01B0\u1EE3ng ");
		
		cbDoituong = new JComboBox<Object>(doituong);
		
		JLabel lblNewLabel_7 = new JLabel("Khu v\u1EF1c ");
		
		cbKV = new JComboBox<Object>(khuvuc);
		
		JLabel lblNewLabel_9 = new JLabel("C\u00E1c m\u00F4n ch\u1ECDn thi");
		
		btnThem = new JButton("Th\u00EAm ");
		btnThem.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			   try {
				insertData();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}  
		});  
		btnSua = new JButton("S\u1EEDa ");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		
		txtHo = new JTextField();
		txtHo.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("T\u00EAn ");
		
		txtTen = new JTextField();
		txtTen.setText("");
		txtTen.setColumns(10);
		
		btnXoa = new JButton("X\u00F3a ");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete(); 
			}
		});
		
		mon1 = new JCheckBox("To\u00E1n ");
		
		mon2 = new JCheckBox("L\u00FD");
		
		mon3 = new JCheckBox("H\u00F3a");
		
		mon4 = new JCheckBox("Sinh ");
		
		mon5 = new JCheckBox("V\u0103n ");
		
		mon6 = new JCheckBox("S\u1EED ");
		
		mon7 = new JCheckBox("\u0110\u1ECBa ");
		
		mon8 = new JCheckBox("Anh ");
		
		JLabel lblNewLabel_11 = new JLabel("Tr\u01B0\u1EDDng ");
		
		JLabel lblNewLabel_12 = new JLabel("Gi\u1EDBi T\u00EDnh ");
		
		cbGT = new JComboBox<Object>(gioitinh);
		
		txtDiachi = new JTextField();
		txtDiachi.setColumns(10);
		
		txtTruong = new JTextField();
		txtTruong.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearData();
			}
		});
		
		cbOptionSort = new JComboBox<Object>(option);
		cbOptionSort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sort();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(380)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_12)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cbGT, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addGap(253)
									.addComponent(txtTimkiem, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(btnTimkiem)
									.addGap(18)
									.addComponent(cbOptionSort, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_3)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtHo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblNewLabel_8)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtTen, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(mon2)
												.addComponent(mon3)
												.addComponent(mon1)
												.addComponent(mon4)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(11)
													.addComponent(btnThem)))
											.addGap(40)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnSua)
												.addComponent(mon8)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(mon6)
													.addComponent(mon7)
													.addComponent(mon5)))
											.addGap(26)
											.addComponent(btnXoa)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnClear))
										.addComponent(lblNewLabel_9)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_5)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtDiachi))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_7)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cbKV, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblNewLabel_6)
											.addGap(18)
											.addComponent(cbDoituong, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_4)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cbNgay, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cbThang, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cbNam, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_11)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtTruong)))
									.addGap(15)
									.addComponent(scrollableTextArea, GroupLayout.PREFERRED_SIZE, 948, GroupLayout.PREFERRED_SIZE)))))
					.addGap(32))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTimkiem, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTimkiem, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_12)
						.addComponent(cbGT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbOptionSort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(txtHo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_8)
								.addComponent(txtTen, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(cbNgay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbThang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbNam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(txtDiachi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7)
								.addComponent(cbKV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6)
								.addComponent(cbDoituong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_11)
								.addComponent(txtTruong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addComponent(lblNewLabel_9)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(mon5)
								.addComponent(mon1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(mon6)
								.addComponent(mon2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(mon7)
								.addComponent(mon3))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(mon8)
								.addComponent(mon4))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnThem)
								.addComponent(btnSua)
								.addComponent(btnXoa)
								.addComponent(btnClear)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(scrollableTextArea, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		showData();
		}
	@SuppressWarnings("unused")
	private void showData() {
		optionSort = (String) cbOptionSort.getItemAt(cbOptionSort.getSelectedIndex()); 
		List<PeopleExam> listPeopleExamDaos = PeopleExamDao.getData(optionSort); 
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] rowObjects = new Object[17];
		for(int i = 0; i < listPeopleExamDaos.size(); i++) {
			rowObjects[0] = listPeopleExamDaos.get(i).getId(); 
			rowObjects[1] = listPeopleExamDaos.get(i).getmHo(); 
			rowObjects[2] = listPeopleExamDaos.get(i).getmTen();
			rowObjects[3] = listPeopleExamDaos.get(i).getmGioitinh();
			rowObjects[4] = listPeopleExamDaos.get(i).getmNgaysinh(); 
			rowObjects[5] = listPeopleExamDaos.get(i).getmDiachi(); 
			rowObjects[6] = listPeopleExamDaos.get(i).getmKhuvuc();
			rowObjects[7] = listPeopleExamDaos.get(i).getmDoituong();
			rowObjects[8] = listPeopleExamDaos.get(i).getmTruong();  
			rowObjects[9] = trangthai(listPeopleExamDaos.get(i).isToan()); 
			rowObjects[10] = trangthai(listPeopleExamDaos.get(i).isLy()); 
			rowObjects[11] = trangthai(listPeopleExamDaos.get(i).isHoa()); 
			rowObjects[12] = trangthai(listPeopleExamDaos.get(i).isSinh()); 
			rowObjects[13] = trangthai(listPeopleExamDaos.get(i).isVan()); 
			rowObjects[14] = trangthai(listPeopleExamDaos.get(i).isSu()); 
			rowObjects[15] = trangthai(listPeopleExamDaos.get(i).isDia());  
			rowObjects[16] = trangthai(listPeopleExamDaos.get(i).isAnh()); 
			model.addRow(rowObjects);
		}
	}
	private String trangthai(boolean mon) {
		String trangthai = "";
		if (mon) {
			trangthai = "X"; 
		}
		else {
			trangthai = "O"; 
		}
		return trangthai; 
	}
	private void insertData() throws ParseException {
		getValueTxt();
		if (!mHo.equals("") && !mTen.equals("")) {
			int isInsertData = PeopleExamDao.insertData(peopleExam);
			if(isInsertData >0) {
				 JOptionPane.showMessageDialog(null,"Thêm dữ liệu thành công!");  
			}
			else {
				 JOptionPane.showMessageDialog(null,"Lỗi!");  
				
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"Thêm các trường đầy đủ!");  
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		refeshTable(model);
		 
	}
	private void getValueTxt() {
		mHo = txtHo.getText(); 
		mTen = txtTen.getText(); 
		mDate = cbNgay.getItemAt(cbNgay.getSelectedIndex())+"-" +cbThang.getItemAt(cbThang.getSelectedIndex()) +"-" +cbNam.getItemAt(cbNam.getSelectedIndex());
		mDiachi = txtDiachi.getText(); 
		mKhuvuc = Integer.parseInt((String)cbKV.getItemAt(cbKV.getSelectedIndex()));
		mDoituong = (String) cbDoituong.getItemAt(cbDoituong.getSelectedIndex()); 
		mTruong = txtTruong.getText(); 
		mGioitinh = (String) cbGT.getItemAt(cbGT.getSelectedIndex()); 
		mToan = mon1.isSelected(); 
		mLy = mon2.isSelected();
		mHoa = mon3.isSelected();
		mSinh = mon4.isSelected();
		mVan = mon5.isSelected();
		mSu = mon6.isSelected();
		mDia = mon7.isSelected();
		mAnh = mon8.isSelected();
		peopleExam = new PeopleExam(mHo, mTen, mGioitinh, mDate, mDiachi, mKhuvuc, mDoituong, mTruong, mToan, mLy, mHoa, mSinh, mVan, mSu, mDia, mAnh);
	}

	
	private void getDataFromTable() {
		System.out.println("hello");
		int index = table.getSelectedRow(); 
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel(); 
		mId = Integer.parseInt(model.getValueAt(index, 0).toString()); 
		mHo = model.getValueAt(index, 1).toString(); 
		mTen = model.getValueAt(index, 2).toString();
		mGioitinh = model.getValueAt(index, 3).toString(); 
		mDate = model.getValueAt(index, 4).toString();
		String[] splits = mDate.split("-");
		mNgay = Integer.parseInt(splits[0].toString()); 
		mThang = Integer.parseInt(splits[1].toString()); 
		mNam = Integer.parseInt(splits[2]); 
		mDiachi = model.getValueAt(index, 5).toString();  
		mKhuvuc = Integer.parseInt(model.getValueAt(index, 6).toString());
		mDoituong = model.getValueAt(index, 7).toString(); 
		mTruong = model.getValueAt(index, 8).toString(); 
		mToan = checkData(model.getValueAt(index, 9).toString()); 
		mLy = checkData(model.getValueAt(index, 10).toString()); 
		mHoa = checkData(model.getValueAt(index, 11).toString()); 
		mSinh = checkData(model.getValueAt(index, 12).toString()); 
		mVan = checkData(model.getValueAt(index, 13).toString()); 
		mSu = checkData(model.getValueAt(index, 14).toString()); 
		mDia = checkData(model.getValueAt(index, 15).toString()); 
		mAnh = checkData(model.getValueAt(index, 16).toString()); 
		
	}
	private void setValue() {
		txtHo.setText(mHo);
		txtID.setText(String.valueOf(mId));
		txtTen.setText(mTen);
		txtTruong.setText(mTruong);
		txtDiachi.setText(mDiachi);
		cbGT.setSelectedItem(mGioitinh);
		cbDoituong.setSelectedItem(mDoituong);
		cbNgay.setSelectedItem(mNgay);
		cbThang.setSelectedItem(mThang);
		cbNam.setSelectedItem(mNam);
		cbKV.setSelectedItem(mKhuvuc);
		mon1.setSelected(mToan);
		mon2.setSelected(mLy);
		mon3.setSelected(mHoa);
		mon4.setSelected(mSinh);
		mon5.setSelected(mVan);
		mon6.setSelected(mSu);
		mon7.setSelected(mDia);
		mon8.setSelected(mAnh);
	}
	private void clearData() {
		txtHo.setText("");
		txtID.setText("");
		txtTen.setText("");
		txtTruong.setText("");
		txtDiachi.setText("");
		cbGT.setSelectedIndex(0);
		cbDoituong.setSelectedIndex(0);
		cbNgay.setSelectedIndex(0);
		cbThang.setSelectedIndex(0);
		cbNam.setSelectedIndex(0);
		cbKV.setSelectedIndex(0);
		mon1.setSelected(false);
		mon2.setSelected(false);
		mon3.setSelected(false);
		mon4.setSelected(false);
		mon5.setSelected(false);
		mon6.setSelected(false);
		mon7.setSelected(false);
		mon8.setSelected(false);
	}
	private boolean checkData(String data) {
		boolean bool = false; 
		if(data.equals("X")) {
			bool = true; 
		}
		return bool; 
	}
	private void delete() {
		int result = PeopleExamDao.delete(mId); 
		if (result > 0) {
			JOptionPane.showMessageDialog(null,"Xóa dữ liệu thành công!");  
		}
		else {
			JOptionPane.showMessageDialog(null,"Lỗi!");  
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		refeshTable(model);
		 
	}
	private void update() {
		getValueTxt();
		peopleExam = new PeopleExam(mId, mHo, mTen, mGioitinh, mDate, mDiachi, mKhuvuc, mDoituong, mTruong, mToan, mLy, mHoa, mSinh, mVan, mSu, mDia, mAnh); 
		int result = PeopleExamDao.update(peopleExam); 
		if (result > 0) {
			JOptionPane.showMessageDialog(null,"Sửa dữ liệu thành công!");  
		}
		else {
			JOptionPane.showMessageDialog(null,"Lỗi!");  
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		refeshTable(model);
	}
	private void refeshTable(DefaultTableModel model) {
		clearData();
		model.setRowCount(0);
		showData();
	}
	private void funTimKiem(String timkiem) {
		optionSort = (String) cbOptionSort.getItemAt(cbOptionSort.getSelectedIndex()); 
		List<PeopleExam> listPeopleExamDaos = PeopleExamDao.getData(optionSort); 
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object[] rowObjects = new Object[17];
		for(int i = 0; i < listPeopleExamDaos.size(); i++) {
			rowObjects[0] = listPeopleExamDaos.get(i).getId(); 
			rowObjects[1] = listPeopleExamDaos.get(i).getmHo(); 
			rowObjects[2] = listPeopleExamDaos.get(i).getmTen();
			rowObjects[3] = listPeopleExamDaos.get(i).getmGioitinh();
			rowObjects[4] = listPeopleExamDaos.get(i).getmNgaysinh(); 
			rowObjects[5] = listPeopleExamDaos.get(i).getmDiachi(); 
			rowObjects[6] = listPeopleExamDaos.get(i).getmKhuvuc();
			rowObjects[7] = listPeopleExamDaos.get(i).getmDoituong();
			rowObjects[8] = listPeopleExamDaos.get(i).getmTruong();  
			rowObjects[9] = trangthai(listPeopleExamDaos.get(i).isToan()); 
			rowObjects[10] = trangthai(listPeopleExamDaos.get(i).isLy()); 
			rowObjects[11] = trangthai(listPeopleExamDaos.get(i).isHoa()); 
			rowObjects[12] = trangthai(listPeopleExamDaos.get(i).isSinh()); 
			rowObjects[13] = trangthai(listPeopleExamDaos.get(i).isVan()); 
			rowObjects[14] = trangthai(listPeopleExamDaos.get(i).isSu()); 
			rowObjects[15] = trangthai(listPeopleExamDaos.get(i).isDia());  
			rowObjects[16] = trangthai(listPeopleExamDaos.get(i).isAnh()); 
			if (listPeopleExamDaos.get(i).getmHo().contains(timkiem) || listPeopleExamDaos.get(i).getmTen().contains(timkiem)
					|| listPeopleExamDaos.get(i).getmDiachi().contains(timkiem) || listPeopleExamDaos.get(i).getmTruong().contains(timkiem)
					|| listPeopleExamDaos.get(i).getmGioitinh().contains(timkiem)) {
				model.addRow(rowObjects);
			}
			
		}
		
	}
	private void sort() {
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		refeshTable(model);
	}
}
