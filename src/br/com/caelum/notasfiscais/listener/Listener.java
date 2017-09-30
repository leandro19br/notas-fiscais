package br.com.caelum.notasfiscais.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

@SuppressWarnings("serial")
public class Listener implements PhaseListener {

	/*mostra o componete antes entrar*/
	public void afterPhase(PhaseEvent e) {
		System.out.println("Antes da Fase" + e.getPhaseId());
		
	}

	/*mostra o componete depois que sair*/
	public void beforePhase(PhaseEvent e) {
		System.out.println("Depois da Fase" + e.getPhaseId());
	}

	/*retorna o id dos componentes */
	public PhaseId getPhaseId() {
		
		return PhaseId.ANY_PHASE;
	}
	

}
