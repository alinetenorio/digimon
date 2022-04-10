// package ifpe;

// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// /**
//  * Servlet implementation class AppServlet
//  */
// @WebServlet("/appServlet")
// public class AppServlet extends HttpServlet {
// 	private static final long serialVersionUID = 1L;
// 	private List<Produto> produtos = new ArrayList<>();
       
//     /**
//      * @see HttpServlet#HttpServlet()
//      */
//     public AppServlet() {
//         super();
//         // TODO Auto-generated constructor stub
//     }

// 	/**
// 	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
// 	 */
// 	protected void doGet(HttpServletRequest request, HttpServletResponse response)
// 			throws ServletException, IOException {
// 		if ("novo".equalsIgnoreCase(request.getParameter("acao"))) {
// 			request.setAttribute("atributo", "turma de ads");
// 			request.getRequestDispatcher("/WEB-INF/cadastrar-produto.jsp").forward(request, response);
			

// 		}
// 		else if("listar".equalsIgnoreCase(request.getParameter("acao"))) {			
// 			request.getRequestDispatcher("/WEB-INF/listar-produto.jsp").forward(request, response);
// 		}
// 		}

// 	/**
// 	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
// 	 */
// 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
// 		var nome = request.getParameter("nome");
// 		var preco = request.getParameter("preco");
// 		var descricao = request.getParameter("descricao");
		
// 		var produto = new Produto(nome, Double.valueOf(preco));
// 			produto.setDescricao(descricao);
			
// 			this.produtos.add(produto);
			
// 			System.out.println("Produtos "+this.produtos);
		
// 	}

// }
