package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import connectdb.ConnectionDB;

public class BoardService {
	
	ConnectionDB dbConnect = new ConnectionDB();
	Connection con = dbConnect.getCon();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private DataSource ds;
	
	public static BoardService getInstance() {
		return getInstance();//getter메서드
	}

	public void regist(String writer, String title, String content) {
		String sql = "insert into board(bno,writer,title,content) values(bno,?,?,?)";
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, writer);
					pstmt.setString(2, title);
					pstmt.setString(3, content);
					
					pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					dbConnect.closeAll(rs, pstmt, con);
				}
	}

	public List<Board> getlist() {
		List<Board> list = new ArrayList<>();
		
		try {
			Connection con = dbConnect.getCon();
			String sql = "SELECT * FROM board order by bno desc";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBno(rs.getInt("bno"));
				board.setWriter(rs.getString("writer"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setHit(rs.getInt("hit"));
				
				list.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbConnect.closeAll(rs, pstmt, con);
		}
		return list;
	}

	// 글 상세정보 메서드
			public Board getContent(String bno) {
				Board board = null;
				
				String sql = "select * from board where bno = ?";
				
				try {
					Connection con = dbConnect.getCon();
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, bno);
					
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						
						String writer = rs.getString("writer");
						String title = rs.getString("title");
						String content = rs.getString("content");
						Timestamp regdate = rs.getTimestamp("regdate");
						int hit = rs.getInt("hit");
						board = new Board();
					}
					dbConnect.closeAll(rs, pstmt, con);
					
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				
				return board;
			}

			// 글 수정하는 메서드
			public void update(String bno, String title, String content) {
				
				String sql ="update board set title = ?, content = ?, regdate = sysdate where bno = ?";
				
				try {
					Connection con = dbConnect.getCon();
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, title);
					pstmt.setString(2, content);
					pstmt.setString(3, bno);
					
					pstmt.executeUpdate();
					dbConnect.closeAll(rs, pstmt, con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			
			// 글 삭제하는 메서드
			public void delete(String bno) {
				
				String sql="delete from board where bno = ?";
				
				try {
					con = ds.getConnection();
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, bno);
					
					pstmt.executeUpdate(); // sql문 실행
					dbConnect.closeAll(rs, pstmt, con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}

			// 조회수 증가 메서드
			public void upHit(String bno) {
				
				String sql ="update board set hit = hit + 1 where bno = ?";
				
				try {
					con = ds.getConnection();
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, bno);
					
					pstmt.executeUpdate();
					dbConnect.closeAll(rs, pstmt, con);
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
}
