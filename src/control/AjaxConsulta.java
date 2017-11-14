package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Cliente;
import persistence.ClienteDao;


@WebServlet("/AjaxConsulta")
public class AjaxConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  try{
		  
		          List <Cliente> lst =  new ClienteDao().findAll();
		           SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		         
		          response.getWriter().print("<table border=1>");
		          response.getWriter().print("<thead>");
		          response.getWriter().print("<tr>");
		             response.getWriter().print("<th>idCliente</th>");
		             response.getWriter().print("<th>Nome</th>");
		             response.getWriter().print("<th>Email</th>");
		             response.getWriter().print("<th>Data</th>");
		             response.getWriter().print("<th>Excluir</th>");
		             response.getWriter().print("<th>Alterar</th>");
		          response.getWriter().print("</tr>");
		          response.getWriter().print("</thead>");
		          for(Cliente x : lst){
		        	  response.getWriter().print("<tr>");
			            response.getWriter().print("<td>"+x.getIdCliente()+"</td>");
			            response.getWriter().print("<td>"+x.getNome()+"</td>");
			            response.getWriter().print("<td>"+x.getEmail()+"</td>");
			           response.getWriter().print("<td>"+sdf.format(x.getDataNascimento())+"</td>");
                     response.getWriter().print("<th><button class='btn3' type='button'"
                     		                                + "  data-id="+ x.getIdCliente()+">Excluir</button></th>");
               response.getWriter().print("<th><button class='btn4' type='button'"
               		                            + "    data-id="+ x.getIdCliente()+">Alterar</button></th>");

			          response.getWriter().print("</tr>");
		          }
		          response.getWriter().print("</table>"); 
		          
		          
		          
		          
		          
		          
		          
		          
		          
		          
	  }catch(Exception ex){
	       response.getWriter().print("Error ..."+ ex.getMessage());
		  
	  }
		
		
		
		
		
		
		
		
		
		
	}

}
