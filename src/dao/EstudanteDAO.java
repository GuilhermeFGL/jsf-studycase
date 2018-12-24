package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import modelo.Estudante;

public class EstudanteDAO {

	private EntityManager entityManager = Persistence.createEntityManagerFactory("estudantes").createEntityManager();

	@SuppressWarnings("unchecked")
	public List<Estudante> listEstudante() {
		try {
			return entityManager.createQuery("SELECT e from Estudante e").getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public boolean saveEstudante(Estudante estudante) {
		try {
			entityManager.persist(estudante);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteEstudante(Estudante estudante) {
		try {
			entityManager.remove(estudante);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
