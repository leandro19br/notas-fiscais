package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;



@SuppressWarnings("serial")
@Named("produto")
@RequestScoped
public class ProdutoBean implements Serializable {
	
	private Produto produto = new Produto();//para inicializar produto
	/*criando atributo para listar os produtos*/
	private List<Produto> produtos = new ArrayList<Produto>();//para que a lista não fique nula
	private double total;
	@Inject
	private ProdutoDao dao;
	
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
	
	public double getTotal() {
		for (Produto produto : produtos) {

			total += produto.getPreco();
		}
		
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}


	public void salvar() {
		
		
		if (produto.getId() == null) {
			dao.adiciona(produto);
			 FacesContext.getCurrentInstance().addMessage("mensagens", new FacesMessage("Cadastrado com Sucesso!"));
		}else{
			dao.atualiza(produto);
		}
		
		produto= new Produto();
		produtos = dao.listaTodos();
		
		
	}
	
	public void editar(Produto prod) {
		
		this.produto = prod;
	}
	
	
	public List<Produto> getProdutos(){
		//ProdutoDao dao = new ProdutoDao();
		
		if (produtos.isEmpty()) {
			this.produtos = dao.listaTodos();
		}
		
		
		return produtos;
		
	}
	
	public void remover(Produto prod) {
		
	dao.remove(prod);
	
	this.produtos = dao.listaTodos();
		
		
	}

	public double calcula() {
		total = 0;
		
		for (Produto produto : produtos) {

			total += produto.getPreco();
		}
		
		return total;
		
	}
		

}
