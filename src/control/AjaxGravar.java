package control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Cliente;
import persistence.ClienteDao;

 
@WebServlet("/AjaxGravar")
public class AjaxGravar extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  try{
		         String nome = request.getParameter("nome");
		         String email =  request.getParameter("email");
		         String data[]  = request.getParameter("data").split("-");
		         //pos[0]= ano, pos[1]= mes, pos[2]= dia
		         
		         Cliente c = new Cliente
		        		 (null, nome, email, new Date(data[1]+ "/" + data[2] + "/" + data[0]));
		         
		          new ClienteDao().create(c);
		           
		          response.getWriter().print("Servlet ...Dados Gravados ..."+ c);
		           
	  }catch(Exception ex){
	       response.getWriter().print("Error ..."+ ex.getMessage());
		  
	  }
  		


	}

}
