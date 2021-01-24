package Model;

import java.sql.Date;

public class PeopleExam {
	int id; 
	String mHo; 
	String mTen; 
	String mGioitinh; 
	String mNgaysinh; 
	String mDiachi; 
	int mKhuvuc; 
	String mDoituong; 
	String mTruong; 
	boolean toan; 
	boolean ly; 
	boolean hoa; 
	boolean sinh; 
	boolean van; 
	boolean su; 
	boolean dia; 
	boolean anh;
	public PeopleExam(String mHo, String mTen, String mGioitinh, String ngaysinh, String mDiachi, int mKhuvuc,
			String mDoituong, String mTruong, boolean toan, boolean ly, boolean hoa, boolean sinh, boolean van,
			boolean su, boolean dia, boolean anh) {
		super();
		this.mHo = mHo;
		this.mTen = mTen;
		this.mGioitinh = mGioitinh;
		this.mNgaysinh = ngaysinh;
		this.mDiachi = mDiachi;
		this.mKhuvuc = mKhuvuc;
		this.mDoituong = mDoituong;
		this.mTruong = mTruong;
		this.toan = toan;
		this.ly = ly;
		this.hoa = hoa;
		this.sinh = sinh;
		this.van = van;
		this.su = su;
		this.dia = dia;
		this.anh = anh;
	}
	public PeopleExam(int id, String mHo, String mTen, String mGioitinh, String mNgaysinh, String mDiachi, int mKhuvuc,
			String mDoituong, String mTruong, boolean toan, boolean ly, boolean hoa, boolean sinh, boolean van,
			boolean su, boolean dia, boolean anh) {
		super();
		this.id = id;
		this.mHo = mHo;
		this.mTen = mTen;
		this.mGioitinh = mGioitinh;
		this.mNgaysinh = mNgaysinh;
		this.mDiachi = mDiachi;
		this.mKhuvuc = mKhuvuc;
		this.mDoituong = mDoituong;
		this.mTruong = mTruong;
		this.toan = toan;
		this.ly = ly;
		this.hoa = hoa;
		this.sinh = sinh;
		this.van = van;
		this.su = su;
		this.dia = dia;
		this.anh = anh;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getmHo() {
		return mHo;
	}
	public void setmHo(String mHo) {
		this.mHo = mHo;
	}
	public String getmTen() {
		return mTen;
	}
	public void setmTen(String mTen) {
		this.mTen = mTen;
	}
	public String getmGioitinh() {
		return mGioitinh;
	}
	public void setmGioitinh(String mGioitinh) {
		this.mGioitinh = mGioitinh;
	}
	public String getmNgaysinh() {
		return mNgaysinh;
	}
	public void setmNgaysinh(String mNgaysinh) {
		this.mNgaysinh = mNgaysinh;
	}
	public String getmDiachi() {
		return mDiachi;
	}
	public void setmDiachi(String mDiachi) {
		this.mDiachi = mDiachi;
	}
	public int getmKhuvuc() {
		return mKhuvuc;
	}
	public void setmKhuvuc(int mKhuvuc) {
		this.mKhuvuc = mKhuvuc;
	}
	public String getmDoituong() {
		return mDoituong;
	}
	public void setmDoituong(String mDoituong) {
		this.mDoituong = mDoituong;
	}
	public String getmTruong() {
		return mTruong;
	}
	public void setmTruong(String mTruong) {
		this.mTruong = mTruong;
	}
	public boolean isToan() {
		return toan;
	}
	public void setToan(boolean toan) {
		this.toan = toan;
	}
	public boolean isLy() {
		return ly;
	}
	public void setLy(boolean ly) {
		this.ly = ly;
	}
	public boolean isHoa() {
		return hoa;
	}
	public void setHoa(boolean hoa) {
		this.hoa = hoa;
	}
	public boolean isSinh() {
		return sinh;
	}
	public void setSinh(boolean sinh) {
		this.sinh = sinh;
	}
	public boolean isVan() {
		return van;
	}
	public void setVan(boolean van) {
		this.van = van;
	}
	public boolean isSu() {
		return su;
	}
	public void setSu(boolean su) {
		this.su = su;
	}
	public boolean isDia() {
		return dia;
	}
	public void setDia(boolean dia) {
		this.dia = dia;
	}
	public boolean isAnh() {
		return anh;
	}
	public void setAnh(boolean anh) {
		this.anh = anh;
	} 
	
	
	

}
