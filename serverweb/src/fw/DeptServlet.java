package fw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "deptinsert", urlPatterns = { "/deptinsert.do" })
public class DeptServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		req.setCharacterEncoding("euc-kr");
		String deptNo = req.getParameter("deptNo");
		String deptName = req.getParameter("deptName");
		String loc = req.getParameter("loc");
		String tel = req.getParameter("tel");
		String mgr = req.getParameter("mgr");				
		DeptDTO member = new DeptDTO(deptNo,deptName,loc,tel,mgr);
		
		DeptDAOImpl a= new DeptDAOImpl();
		int result = a.insert(member);
		
		//3.응답화면으로 요청재지정
		response.sendRedirect("/serverweb/dept/insertResult.html");
		
	}

}
