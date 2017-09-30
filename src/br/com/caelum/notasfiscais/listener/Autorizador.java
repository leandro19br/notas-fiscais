package br.com.caelum.notasfiscais.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.mb.UsuarioLogadoBean;

@SuppressWarnings("serial")
public class Autorizador implements PhaseListener {
	
	@Inject
	private UsuarioLogadoBean usuarioLogado;
	
	@Inject
	private FacesContext context;
	
	@Inject
	private NavigationHandler handler;
	
	/*Será utilizado para verificar se o usuário está logado*/
	public void afterPhase(PhaseEvent e) {
		
		
		if ("/login.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}
		
		/*não tem usuarioLogado*/
		if (!usuarioLogado.isLogado()) {
	
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			context.renderResponse();
		}
		
	}

	
	public void beforePhase(PhaseEvent e) {
		
	}

	/*retorna o id dos componentes */
	public PhaseId getPhaseId() {
		
		return PhaseId.RESTORE_VIEW;
	}
	

}
