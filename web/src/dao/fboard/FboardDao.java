package dao.fboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Conn;
import service.fboard.FboardService;
import vo.fboard.FboardVo;

public class FboardDao implements FboardService{
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection conn;
	public static FboardDao dao = new FboardDao();
	
	public static FboardDao getInstance() {
		return dao;
	}
	
	public void write(FboardVo board) {
		
		String sql = "insert into fboard values (seq_fboard.nextval, ?, ?, ?, sysdate, 0,?)";
		
		conn = Conn.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			pstmt.setString(4, board.getPic());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {conn.close();}
				if (pstmt != null) {pstmt.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public FboardVo read(int no) {
		String sql = "select boardno, title, content, writer, to_char(regdate, 'yy/mm/dd hh24:MM:dd'), cnt, pic from fboard where boardno = ?";
		FboardVo board = null;
		conn = Conn.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board = new FboardVo();
				board.setBoardNo(no);
				board.setTitle(rs.getString(2));
				board.setContent(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setRegDate(rs.getString(5));
				board.setCnt(rs.getInt(6));
				board.setPic(rs.getString(7));
				
				sql = "update fboard set cnt = (select cnt+1 from fboard where boardno=?) where boardno = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				pstmt.setInt(2, no);
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {conn.close();}
				if (pstmt != null) {pstmt.close();}
				if (rs != null) {rs.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return board;
	}
	
	public List<FboardVo> readList(int page) {
		String sql = "select * from (select boardno, title, content, writer, to_char(regdate, 'yyyy-mm-dd'), cnt, rownum rn from fboard order by 1 desc) where rn BETWEEN ? and ?";
		FboardVo board = null;
		ArrayList<FboardVo> boards = new ArrayList<>();
		conn = Conn.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (page-1)*5+1);
			pstmt.setInt(2, page * 5);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				board = new FboardVo();
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setContent(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setRegDate(rs.getString(5));
				board.setCnt(rs.getInt(6));
				board.setRn(rs.getInt(7));
				boards.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {conn.close();}
				if (pstmt != null) {pstmt.close();}
				if (rs != null) {rs.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return boards;
	}
	
	public void mod(FboardVo board) {
		String sql = "update fboard set title = ?, content = ?, writer = ?, regdate = sysdate, pic = ? where boardno = ?";
		
		conn = Conn.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			pstmt.setString(4, board.getPic());
			pstmt.setInt(5, board.getBoardNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {conn.close();}
				if (pstmt != null) {pstmt.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void del(int no) {
		String sql = "delete fboard where boardno = ?";
		conn = Conn.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {conn.close();}
				if (pstmt != null) {pstmt.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public int maxPage() {
		String sql = "select FLOOR((count(*)-1)/5+1) lastpage from fboard";
		int result = 0;
		conn = Conn.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int idx = 0;
				result = rs.getInt(++idx);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {conn.close();}
				if (pstmt != null) {pstmt.close();}
				if (rs != null) {rs.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	@Override
	public int minPage() {
		String sql = "select count(*)-(count(*)-1) firstpage from fboard";
		int result = 0;
		conn = Conn.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int idx = 0;
				result = rs.getInt(++idx);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {conn.close();}
				if (pstmt != null) {pstmt.close();}
				if (rs != null) {rs.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
