package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectdb.ConnectionDB;
import hall.Hall;

public class LibraryService {
	ConnectionDB dbConnect = new ConnectionDB();

    public List<Library> getLibrarys() {
        List<Library> librarys = new ArrayList<>();

        try {
            Connection con = dbConnect.getCon();
            String sql = "SELECT * FROM library";
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()){
            	Integer id = rs.getInt("id");
            	String name = rs.getString("name");
            	String type = rs.getString("type");
            	Integer count = rs.getInt("count");
            	String address = rs.getString("address");
            	String phoneNum = rs.getString("phoneNum");
            	String homePage = rs.getString("homePage");
            	Library library = new Library(id,name,type, count,address,phoneNum,homePage);
            	librarys.add(library);
            }
            dbConnect.closeAll(rs, pstmt, con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return librarys;
    }

}
