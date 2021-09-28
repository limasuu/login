package login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletRegistro1")
public class ServletRegistro1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter saida= response.getWriter();
		
		HttpSession sessao= request.getSession(false);
		
		saida.write("<!DOCTYPE html>");
		saida.write("<html lang=\"pt-br\">");	

		saida.write("<head>");
		saida.write("<meta charset=\"UTF-8\">");	
		saida.write("<title>Tela inicial</title>");	
		saida.write("</head>");			

		saida.write("<body>");
		
		if(sessao == null || sessao.getAttribute("usuario") == null) {
			saida.write("<h1>Tela de erro</h1>");
			
			saida.write("<p>É necessário efetuar o login.</p>");
			saida.write("<a href=\"index.jsp\">Clique aqui</a>");			
		}else {
			
			saida.write("<h1>Tela de registro</h1>");
						
			saida.write("<p>Seja bem-vindo(a), " + sessao.getAttribute("usuario") + "!</p>");
			
			saida.write("<h3>Vamos fazer o registro do dia?</h3>");			
			saida.write("<form action=\"ServletRegistro2\">");
			
			saida.write("<p>Lugar em que esta no momento</p>");
			saida.write("<label for=\"campo-cidade\">Cidade</label>");
			saida.write("<input type=\"text\" name=\"campo-cidade\"/>");
			saida.write("<label for=\"campo-estado\">Estado</label>");
			saida.write("<input type=\"text\" name=\"campo-estado\"/><br/><br/>");
			
			saida.write("<label for=\"campo-km\">Km rodados</label>");
			saida.write("<input type=\"text\" name=\"campo-km\"/>");
			saida.write("<label for=\"campo-combustivel\">Combustivel gasto</label>");
			saida.write("<input type=\"text\" name=\"campo-combustivel\"/><br/><br/>");
						
			saida.write("<button type=\"submit\">Proximo</button>");
			
			saida.write("</form>");
		}
		
		saida.write("</body>");
		saida.write("</html>");
				
		saida.close();
	}
}
