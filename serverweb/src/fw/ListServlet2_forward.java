package fw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listf", urlPatterns = { "/dept/listf.do" })
public class ListServlet2_forward extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		//1.요청정보추출
		//2.비즈니스메소드 추출
		
		DeptDAOImpl dao = new DeptDAOImpl();
		ArrayList<DeptDTO> deptlist = dao.DeptList();
		
		request.setAttribute("mydata", deptlist);		
		RequestDispatcher rd = request.getRequestDispatcher("/jspbasic/list.jsp");
		rd.forward(request, response);
		
		
		
	}

}
