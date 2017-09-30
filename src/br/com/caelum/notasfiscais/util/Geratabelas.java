package br.com.caelum.notasfiscais.util;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Geratabelas {
	
public static void main(String[] args) throws ClassNotFoundException {
	
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("notas");
	emf.close();
	
}

}
