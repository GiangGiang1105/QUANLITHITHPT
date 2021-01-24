package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;  

import Model.PeopleExam;

public class PeopleExamDao {
	private static String DB_NAME = "management_exam";
    private static String DB_URL = "jdbc:mysql://localhost:3306/";
    private static String USER_NAME = "root";
    private static String PASSWORD = "215487467hg";
	 
	public static Connection getConnection() throws Throwable {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection connection = (Connection) DriverManager.getConnection(DB_URL + DB_NAME, USER_NAME, PASSWORD);
	            return connection;
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            throw new Throwable("Can't create connection");
	        }
	}
	public static List<PeopleExam> getData(String optionSort) {
		List<PeopleExam> listPeopleExams = new ArrayList<PeopleExam>(); 
		PeopleExam peopleExam ;
		String query = " SELECT * FROM management_exam.people_exam ;";
		if(optionSort.equals("Sắp xếp theo giới tính")) {
			query = " SELECT * FROM management_exam.people_exam ORDER BY gioitinh ASC ;"; 
		}
		if (optionSort.equals("Sắp xếp theo khu vực")) {
			query = " SELECT * FROM management_exam.people_exam ORDER BY khuvuc ASC;"; 
		} 
		if(optionSort.equals("Sắp xếp theo đối tượng")){
			query = " SELECT * FROM management_exam.people_exam ORDER BY doituong ASC ;"; 
		}
		try {
			Connection connection = getConnection();
			Statement statement = ((java.sql.Connection) connection).createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
               int id = resultSet.getInt("id"); 
               System.out.println(id);
               String ho = resultSet.getString("ho"); 
               String ten = resultSet.getString("ten"); 
               String gioitinh = resultSet.getString("gioitinh"); 
               String ngaysinh = resultSet.getString("ngaysinh"); 
               String diachi = resultSet.getString("diachi"); 
               int khuvuc = resultSet.getInt("khuvuc"); 
               String doituong = resultSet.getString("doituong"); 
               String truong = resultSet.getString("truong"); 
               boolean toan = resultSet.getBoolean("toan"); 
               boolean van = resultSet.getBoolean("van");
               boolean ly = resultSet.getBoolean("ly"); 
               boolean hoa = resultSet.getBoolean("hoa"); 
               boolean sinh = resultSet.getBoolean("sinh"); 
               boolean anh = resultSet.getBoolean("anh"); 
               boolean su = resultSet.getBoolean("su"); 
               boolean dia = resultSet.getBoolean("dia"); 
               peopleExam = new PeopleExam(id, ho, ten, gioitinh, ngaysinh, diachi, khuvuc, doituong, truong, toan, ly, hoa, sinh, van, su, dia, anh); 
               listPeopleExams.add(peopleExam); 
            }
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return listPeopleExams; 
	}
	public static int insertData(PeopleExam peopleExam) {
		int result = 0; 
		 try {
	            Connection connection = getConnection();
	            String query = "insert into management_exam.people_exam(ho, ten, gioitinh, ngaysinh, diachi, khuvuc, doituong, truong,"
	            		+ "toan, ly, hoa, sinh, van, anh, su, dia) values( ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?);";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, peopleExam.getmHo());
	            preparedStatement.setString(2, peopleExam.getmTen());
	            preparedStatement.setString(3, peopleExam.getmGioitinh());
	            preparedStatement.setString(4,  peopleExam.getmNgaysinh());
	            preparedStatement.setString(5, peopleExam.getmDiachi());
	            preparedStatement.setInt(6, peopleExam.getmKhuvuc());
	            preparedStatement.setString(7, peopleExam.getmDoituong());
	            preparedStatement.setString(8, peopleExam.getmTruong());
	            preparedStatement.setBoolean(9, peopleExam.isToan());
	            preparedStatement.setBoolean(10, peopleExam.isLy());
	            preparedStatement.setBoolean(11, peopleExam.isHoa());
	            preparedStatement.setBoolean(12, peopleExam.isSinh());
	            preparedStatement.setBoolean(13, peopleExam.isVan());
	            preparedStatement.setBoolean(14, peopleExam.isAnh());
	            preparedStatement.setBoolean(15, peopleExam.isSu());
	            preparedStatement.setBoolean(16, peopleExam.isDia());
	            result = preparedStatement.executeUpdate();
	            System.out.println(result);
	        } catch (Throwable throwable) {
	            throwable.printStackTrace();
	        }
		 return result;
	}
	public static int delete(int id) {
		int result = 0; 
		 try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String query = "delete from management_exam.people_exam where id=" + id + ";";
            result = statement.executeUpdate(query);
            
        }catch (Throwable e){
            e.printStackTrace();
        }
        return result;
	}
	public static int update(PeopleExam peopleExam) {
		int result = 0; 
		 try {
	            Connection connection = getConnection();
	            String query = "update  management_exam.people_exam set ho = ?,  ten = ?, gioitinh =?, ngaysinh =?, diachi = ?, khuvuc= ?, doituong= ?, truong =?,"
	            		+ "toan =? , ly =?, hoa=?, sinh=?, van=?, anh=?, su=?, dia=? where id = ?;";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, peopleExam.getmHo());
	            preparedStatement.setString(2, peopleExam.getmTen());
	            preparedStatement.setString(3, peopleExam.getmGioitinh());
	            preparedStatement.setString(4,  peopleExam.getmNgaysinh());
	            preparedStatement.setString(5, peopleExam.getmDiachi());
	            preparedStatement.setInt(6, peopleExam.getmKhuvuc());
	            preparedStatement.setString(7, peopleExam.getmDoituong());
	            preparedStatement.setString(8, peopleExam.getmTruong());
	            preparedStatement.setBoolean(9, peopleExam.isToan());
	            preparedStatement.setBoolean(10, peopleExam.isLy());
	            preparedStatement.setBoolean(11, peopleExam.isHoa());
	            preparedStatement.setBoolean(12, peopleExam.isSinh());
	            preparedStatement.setBoolean(13, peopleExam.isVan());
	            preparedStatement.setBoolean(14, peopleExam.isAnh());
	            preparedStatement.setBoolean(15, peopleExam.isSu());
	            preparedStatement.setBoolean(16, peopleExam.isDia());
	            preparedStatement.setInt(17, peopleExam.getId());
	            result = preparedStatement.executeUpdate();
	            System.out.println(result);
	        } catch (Throwable throwable) {
	            throwable.printStackTrace();
	        }
		 return result;
	}
}
