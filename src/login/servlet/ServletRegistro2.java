package login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.modelo.Registro;

@WebServlet("/ServletRegistro2")
public class ServletRegistro2 extends HttpServlet {
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
			
			String cidade= request.getParameter("campo-cidade");
			String estado= request.getParameter("campo-estado");
			double km= Double.parseDouble(request.getParameter("campo-km"));
			double combustivel= Double.parseDouble(request.getParameter("campo-combustivel"));
			
			Registro registro= new Registro(cidade, estado, km, combustivel);
			sessao.setAttribute("registro", registro);
			
			saida.write("<h1>Tela de registro</h1>");
			
			saida.write("<p>Seja bem-vindo(a), " + sessao.getAttribute("usuario") + "!</p>");

			saida.write("<h3>Vamos fazer o registro do dia?</h3>");
			saida.write("<form action=\"ServletExibir\">");

			saida.write("<label for=\"campo-texto\">Texto do dia</label>");
			saida.write("<textarea rows=\"3\" cols=\"50\" name=\"campo-texto\"></textarea><br/><br/>");

			saida.write("<label for=\"campo-meta\">Cidade meta de amanha</label>");
			saida.write("<input type=\"text\" name=\"campo-meta\"/><br/><br/>");

			saida.write("<button type=\"submit\">Exibir registro</button>");

			saida.write("</form>");
		}

		saida.write("</body>");
		saida.write("</html>");

		saida.close();
	}	
}
