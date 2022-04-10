/*
package edu.ifpe.gus.progint.model.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifpe.gus.progint.model.entity.Produto;

public class CadastrarProdutoCommand implements Command{

	private final String pagina = "/WEB-INF/lista-produtos.jsp";
	
	private List<Produto> produtos;
	
	
	
	public CadastrarProdutoCommand(List<Produto> produtos) {
		super();
		this.produtos = produtos;
	}



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var nome = request.getParameter("nome");
		var descricao = request.getParameter("descricao");
		var preco = Double.valueOf(request.getParameter("preco"));
		
		var produto = new Produto(nome, preco);
		    produto.setDescricao(descricao);
		
		   var indice= produtos.size()+1;
		   produto.setId(indice);
		   
		produtos.add(produto);
		request.setAttribute("produtos", produtos);
		
		System.out.println("Registrando o produto: "+produto);
		
		return pagina;
	}

}

*/