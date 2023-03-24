package hall;

import connectdb.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HallService {

	ConnectionDB dbConnect = new ConnectionDB();

	public List<Hall> getHalls() {
		List<Hall> halls = new ArrayList<>();

		try {
			Connection con = dbConnect.getCon();
			String sql = "SELECT * FROM HALL";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			dbConnect.closeAll(rs, pstmt, con);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return halls;
	}
		
	public List<Hall> getList(int pageNum, int amount){
		
		Connection con = dbConnect.getCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Hall> halls = new ArrayList<>();
		//pageNum부터 amount까 2,20
		String sql = "select * from hall limit ?,?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, (pageNum-1)*10);
			pstmt.setInt(2, amount);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Hall hall = new Hall();
				hall.setHallID(rs.getInt("hallID"));
				hall.setCity(rs.getString("city"));
				hall.setCountry(rs.getString("country"));
				hall.setAddress(rs.getString("address"));
				hall.setHallName(rs.getString("hallName"));
				hall.setOpenDate(rs.getString("openDate"));
				hall.setNum(rs.getString("num"));
				
				halls.add(hall);
			}
			dbConnect.closeAll(rs, pstmt, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return halls;
	}
	
	public int getTotal() {
		int result = 0;
		String sql = "select count(*) as total from hall";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Connection con = dbConnect.getCon();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("total");
			}
			dbConnect.closeAll(rs, pstmt, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	
}
