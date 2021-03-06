package fw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exam.DBUtil;
import exam.MemberDTO;



public class DeptDAOImpl implements DeptDAO {
	public int delete(String deptNo) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		String sql = "delete from mydept where deptNo = ?";
		int	result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, deptNo);
			result = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	
	
	public ArrayList<DeptDTO> DeptList(){
		System.out.println("DeptList호출 => 서블릿이 넘겨준 파라미터 출력");
		ArrayList<DeptDTO> DeptList = new ArrayList<DeptDTO>();
		DeptDTO Dept =null;
		String sql = "select * from mydept";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.println("while");
				Dept = new DeptDTO(rs.getString(1),rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5));
				DeptList.add(Dept);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		DBUtil.close(rs, stmt, con);
	}
	return DeptList;
	}
	
	public int insert(DeptDTO member) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "insert into mydept values(?,?,?,?,?)";
		
		int result = 0;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, member.getDeptNo());
			stmt.setString(2, member.getDeptName());
			stmt.setString(3, member.getLoc());
			stmt.setString(4, member.getTel());
			stmt.setString(5, member.getMgr());
			result = stmt.executeUpdate();
			System.out.println(result+"개 행 삽입 성공");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, con);
		}return result;
	}
	public DeptDTO read(String deptNo) {
		DeptDTO read = new DeptDTO();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from mydept where deptNo = ?";
		
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, deptNo);
			rs = stmt.executeQuery(); //select실행
			//실행결과를 자바객체로 변환
			//- 레코드가 여러 개 : DTO로 레코드를 변환하고 ArrayList에 add
			//- 레코드가 한 개  : DTO로 레코드 변환
			while(rs.next()) {
				read = new DeptDTO(rs.getString(1),rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5));
				
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, con);
		}
		return read;
	}


	
}	
	
	
	
	
	
	









