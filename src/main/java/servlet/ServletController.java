
// package edu.ifpe.gus.progint.servlet;

// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import edu.ifpe.gus.progint.model.actions.CadastrarProdutoCommand;
// import edu.ifpe.gus.progint.model.actions.Command;
// import edu.ifpe.gus.progint.model.entity.Produto;

// /**
//  * Servlet implementation class ServletController
//  */
// @WebServlet("/app")
// public class ServletController extends HttpServlet {
// 	private static final long serialVersionUID = 1L;
// 	private List<Produto> produtos = new ArrayList<Produto>();
	
// 	private int id = 0;

// 	/**
// 	 * @see HttpServlet#HttpServlet()
// 	 */
// 	public ServletController() {
// 		super();
// 		// TODO Auto-generated constructor stub
// 	}

// 	/**
// 	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
// 	 *      response)
// 	 */
// 	protected void doGet(HttpServletRequest request, HttpServletResponse response)
// 			throws ServletException, IOException {
// 		if ("novo".equalsIgnoreCase(request.getParameter("acao".trim()))) {
// 			request.getRequestDispatcher("/WEB-INF/cadastrar-produto.jsp").forward(request, response);
// 		} else if ("listar".equalsIgnoreCase(request.getParameter("acao".trim()))) {
// 			listarProdutos(request, response);
// 		} else if ("remover".equalsIgnoreCase(request.getParameter("acao".trim()))) {
// 			var nomeProduto = request.getParameter("produto");
// 			System.out.println("Nome vindo do front: " + nomeProduto);
// 			for (Produto produto : produtos) {
// 				if (produto.getNome().equals(nomeProduto)) {
// 					System.out.println("Nome encontrado na lista: " + produto.getNome());
// 					produtos.remove(produto);
// 					this.listarProdutos(request, response);
// 				}
// 			}
// 		} else if ("editar".equalsIgnoreCase(request.getParameter("acao".trim()))) {
// 			var nomeProduto = request.getParameter("produto");
// 			for (Produto produto : produtos) {
// 				if (produto.getNome().equals(nomeProduto)) {
// 					request.setAttribute("produto", produto);
// 					request.getRequestDispatcher("/WEB-INF/cadastrar-produto.jsp").forward(request, response);
// 				}
// 			}

// 		}

// 	}



// 	/**
// 	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
// 	 *      response)
// 	 */
// 	protected void doPost(HttpServletRequest request, HttpServletResponse response)
// 			throws ServletException, IOException {

// 		if(request.getParameter("id")!=null && !request.getParameter("id").equals("".trim())){
// 			for (Produto produto : produtos) {
// 				if (produto.getId() == Integer.parseInt(request.getParameter("id"))) {

// 					var index = produtos.indexOf(produto);

// 					produto.setNome(request.getParameter("nome"));
// 					produto.setDescricao(request.getParameter("descricao"));
// 					produto.setPreco(Double.valueOf(request.getParameter("preco")));

// 					produtos.set(index, produto);

// 					listarProdutos(request, response);
// 					return;

// 				}
// 			}
// 		}
		
// 		Command comando = new CadastrarProdutoCommand(produtos);
// 		var pagina = comando.execute(request, response);
// 		request.getRequestDispatcher(pagina).forward(request, response);

// 	}
	
	
// 	private void listarProdutos(HttpServletRequest request, HttpServletResponse response)
// 			throws ServletException, IOException {
// 		request.setAttribute("produtos", this.produtos);

// 		request.getRequestDispatcher("/WEB-INF/lista-produtos.jsp").forward(request, response);

// 	}
	
	
// 	private int incrementaId() {
// 		return this.id++;
// 	}

// }
