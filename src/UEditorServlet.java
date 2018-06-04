import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UEditorServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        
        //拿到编辑器的内容
        String content = request.getParameter("editorValue");
        //如果不为空
        if(content != null){
            //将内容设置进属性
        	System.out.println("content====="+content);
            request.setAttribute("content",content);
            //转发到content.jsp
            request.getRequestDispatcher("content.jsp").forward(request, response);
        }else{
            response.getWriter().append("内容为空!");
        }
	}
}
