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


@WebServlet("/ServletExibir")
public class ServletExibir extends HttpServlet {
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
			
			Registro registro= (Registro) sessao.getAttribute("registro");
			
			if(registro==null) {
				saida.write("<h1>Tela de erro</h1>");

				saida.write("<p>Dados incompletos. Faça o login novamente.</p>");
				saida.write("<a href=\"index.jsp\">Clique aqui</a>");
			}else {
				
				String texto= request.getParameter("campo-texto");
				String meta= request.getParameter("campo-meta");
				
				saida.write("<h1>Registro do dia</h1>");
				
				saida.write("<p>" + registro.getDataHora() + " | " + registro.getEstacao() + "</p>");
				saida.write("<p>Onde estou no momento: " + registro.getCidade() + ", " + registro.getEstado() + "</p>");
				saida.write("<p>Km rodados: " + registro.getKm() + " | Combustivel gasto: " + registro.getCombustivel() + "</p>");
				
				saida.write("<p>Texto do dia: " +  texto + "</p>");
				saida.write("<p>Meta de amanha: " +  meta + "</p><br/>");
								
				saida.write("<p>Boa viagem, " + sessao.getAttribute("usuario") + "!</p>");
								
				saida.write("<a href=\"ServletSair\">Clique aqui para sair</a>");					
			}
		}
				
		saida.write("</body>");
		saida.write("</html>");

		saida.close();
	}
}