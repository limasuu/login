package login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String USUARIO= "fulano", SENHA="123";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter saida= response.getWriter();

		String usuario= request.getParameter("usuario");
		String senha= request.getParameter("senha");

		if(autenticar(usuario, senha))
			apresentarTelaInicial(request, response, usuario);		
		else 
			apresentarTelaErro(saida);

		saida.close();
	}

	private boolean autenticar(String usuario, String senha) {

		if(usuario != null && senha != null &&
				!usuario.isBlank() && !senha.isBlank() &&
				USUARIO.equalsIgnoreCase(usuario) &&
				SENHA.equals(senha))
			return true;

		return false;
	}

	private void apresentarTelaInicial(HttpServletRequest request, HttpServletResponse response, String usuario) throws ServletException, IOException {

		HttpSession sessao= request.getSession();
		sessao.setAttribute("usuario", usuario);

		request.getRequestDispatcher("ServletRegistro1").forward(request, response);
	}

	private void apresentarTelaErro(PrintWriter saida) {
		
		saida.write("<!DOCTYPE html>");
		saida.write("<html lang=\"pt-br\">");	

		saida.write("<head>");
		saida.write("<meta charset=\"UTF-8\">");	
		saida.write("<title>Tela de erro</title>");	
		saida.write("</head>");			

		saida.write("<body>");

		saida.write("<h1>Tela de erro</h1>");

		saida.write("<p>Nao foi possivel efetuar o login.</p>");
		
		saida.write("</body>");
		saida.write("</html>");
	}
}
