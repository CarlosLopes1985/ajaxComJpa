package control;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Cliente;
import persistence.ClienteDao;

 
@WebServlet("/AjaxAltera")
public class AjaxAltera extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		 Integer codigo = new Integer(request.getParameter("codigo"));
		 try{
			 Cliente cliente = new ClienteDao().findByCode(codigo);
			 SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
			 
           response.getWriter().print("codigo<br/>");
           response.getWriter().print("<input type='text' name='idCliente' readonly='true' class='aidCliente'  value="+codigo+">");
           response.getWriter().print("<br/>Nome<br/>");
  response.getWriter().print("<input type='text' name='nome'  class='anome'  value="+cliente.getNome()+">");
  response.getWriter().print("<br/>Email<br/>");
  response.getWriter().print("<input type='email' name='email'  class='aemail'  value="+cliente.getEmail()+">");
  response.getWriter().print("<br/>Email<br/>");
  response.getWriter().print("<input type='date' name='data'  class='adata' "
  		+ "     value="+sdf.format(cliente.getDataNascimento())+">");
			 
			 
			 
			 
		 }catch(Exception ex){
			 
		 }
		
		
	
	}

}
