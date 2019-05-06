package dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Conn;
import service.member.MemberService;
import vo.member.MemberVo;

public class MemberDao implements MemberService {
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection conn;
	
	public static MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		return dao; 
	}
	
	// 회원가입
	public int signup(MemberVo vo) {
		int result = 0;
		String sql = "insert into member(id, pw, name, nik, email, tel, admin) values (?, ?, ?, ?, ?, ?, ?)";
		
		conn = Conn.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNik());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getTel());
			pstmt.setInt(7, vo.getAdmin());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException ignore) {}
		}
		return result;
	}
	
	// 로그인
	public int login(String id, String pw) {
		int result = 0; // 1 성공 / 0 미가입 / 2 비밀번호 오류
		String sql = "select pw from member where id = ?";
		conn = Conn.getConnection();
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append(sql);
			pstmt = conn.prepareStatement(buffer.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 행이 있을때
				String dbpw = rs.getString("pw");
				if (dbpw.equals(pw)) {
					result = 1;
				}else {
					result = 2;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException ignore) {}
		}
		return result;
	}
	
	public void deleteMember(String id) {
		String sql1 = "delete from member where id = ?";
		conn = Conn.getConnection();
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()==true) {
				conn.commit();
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
	}
	
	
	public boolean isMember(String id) {
		String sql = "select id, name, pw from member where id = ?";
		conn = Conn.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			return rs.next();
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
		return false;
		
	}
	
	public int checkID(String id) {
		int result = 0;
		String sql = "select id, pw from member where id = ?";
		conn = Conn.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException ignore) {}
		}
		return result;
	}
	
	public MemberVo getMember(String id) {
		MemberVo vo = null;
		String sql = "select id, pw, name, nik, email, tel, admin from member where id= ?";
		conn = Conn.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVo();
				int idx = 0;
				vo.setId(rs.getString(++idx));
				vo.setPw(rs.getString(++idx));
				vo.setName(rs.getString(++idx));
				vo.setNik(rs.getString(++idx));
				vo.setEmail(rs.getString(++idx));
				vo.setTel(rs.getString(++idx));
				vo.setAdmin(rs.getInt(++idx));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException ignore) {}
		}
		return vo;
	}
	
	public void editMember(MemberVo vo) {
		String sql = "update member set pw = ?, name = ?, nik = ?, email = ?, tel = ?, admin = ? where id = ?";
		conn = Conn.getConnection();
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getNik());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getTel());
			pstmt.setInt(6, vo.getAdmin());
			pstmt.setString(7, vo.getId());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {}
		}
	}
}
