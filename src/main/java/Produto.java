// package ifpe;

// import java.util.Objects;

// public class Produto {
// 	private String nome;
// 	private double preco;
// 	private String descricao;
	

// 	public Produto(String nome, double preco) {
// 		super();
// 		this.nome = nome;
// 		this.preco = preco;
// 	}
	
// 	public String getNome() {
// 		return nome;
// 	}
	
// 	public double getPreco() {
// 		return preco;
// 	}
	
	
// 	public String getDescricao() {
// 		return descricao;
// 	}

// 	@Override
// 	public int hashCode() {
// 		return Objects.hash(descricao, nome, preco);
// 	}

// 	@Override
// 	public boolean equals(Object obj) {
// 		if (this == obj)
// 			return true;
// 		if (obj == null)
// 			return false;
// 		if (getClass() != obj.getClass())
// 			return false;
// 		Produto other = (Produto) obj;
// 		return Objects.equals(descricao, other.descricao) && Objects.equals(nome, other.nome)
// 				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
// 	}
	
// 	public void setDescricao(String descricao) {
// 		this.descricao = descricao;
// 	}

// 	@Override
// 	public String toString() {
// 		return "Produto [nome=" + nome + ", preco=" + preco + ", descricao=" + descricao + "]";
// 	}
	
	
	
	
// }
