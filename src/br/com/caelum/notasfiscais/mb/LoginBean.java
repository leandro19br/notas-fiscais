package br.com.caelum.notasfiscais.mb;


import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;



@SuppressWarnings("serial")
@Named
@RequestScoped
public class LoginBean implements Serializable  {
	
	private Usuario usuario = new Usuario();
	@Inject
	private UsuarioDao dao;
	@Inject
	private UsuarioLogadoBean usuarioLogado;
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public String login(){
				
		if (dao.existe(usuario)) {
			usuarioLogado.logado(usuario);
			return "produto?faces-redirect=true";
		} else {
			usuario = new Usuario();
			return "login?faces-redirect=true";
		}
		
		
	}
		

}
