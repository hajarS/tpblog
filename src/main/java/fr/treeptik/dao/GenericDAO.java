package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;

public interface GenericDAO <T, Pk>{
	
	T save (T entite) throws DAOException;
	
	//doit supprimer un objet detaché
	void removeById(Pk id);
	
	T findBy(Pk id);
	
	List<T> findAll();
	
	T updateById(Pk id);


}
