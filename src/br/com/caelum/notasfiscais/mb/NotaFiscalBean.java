package br.com.caelum.notasfiscais.mb;





import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;



@Named
//@RequestScoped
@ViewScoped
public class NotaFiscalBean {

	private NotaFiscal nf = new NotaFiscal();

	@Inject
	private NotaFiscalDao dao;
	
	private Item item = new Item();
	private Long idProduto;
	@Inject
	private ProdutoDao produtoDAO;
	
	

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public ProdutoDao getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDao produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

	public NotaFiscal getNf() {
		return nf;
	}

	public void setNf(NotaFiscal nf) {
		this.nf = nf;
	}

	public NotaFiscalDao getDao() {
		return dao;
	}

	public void setDao(NotaFiscalDao dao) {
		this.dao = dao;
	}

	public void gravar() {

		dao.adiciona(nf);
		this.nf = new NotaFiscal();

	}
	
	public void guardarItem(){
		
		Produto produto = produtoDAO.buscaPorId(idProduto);
		item.setProduto(produto);
		item.setValorUnitario(produto.getPreco());
		item.setNotaFiscal(nf);
		
		nf.getItens().add(item);
		
	
		item = new Item();
		idProduto = null;
	}

}
