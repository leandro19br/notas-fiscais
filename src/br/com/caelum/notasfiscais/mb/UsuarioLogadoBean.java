package br.com.caelum.notasfiscais.mb;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.caelum.notasfiscais.modelo.Usuario;



@SuppressWarnings("serial")
@Named
@SessionScoped
public class UsuarioLogadoBean implements Serializable  {
	
	
	private Usuario usuario;
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public void logado(Usuario usuario){
				
		this.usuario = usuario;
		
		
	}
	
	public String logOff() {
		
		this.usuario = null;
		

		return "login?faces-redirect=true";
		
	}
	/*método verifica se o usuário está logado*/
	
	public boolean isLogado(){
		
		return usuario!=null;
	}

}
