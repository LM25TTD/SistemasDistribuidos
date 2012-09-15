package remote.dao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SessionFactory;

@SuppressWarnings(value={"rawtypes"})
public interface IGenericDao {
	
	public SessionFactory getSessionFactory();
	public void setSessionFactory(SessionFactory sessionFactory);
	public void save(Object objeto) throws Exception;
	public void update(Object objeto) throws Exception;
	public void delete(Object objeto) throws Exception;
	public void deleteAll(List listaObjetos) throws Exception;
	public List getAll(Class classe);
	public List getAll(Class classe, String campoOrderBy, int order);
	public List getAll(Class classe, int firstResult, int maxResults);
	public List getAll(Class classe, int firstResult, int maxResults, String campoOrderBy, int order);
	public List getAll(Class classe, String [][]filtros);
	public List getAll(Class classe, String [][]filtros, String campoOrderBy, int order);
	/*public List getObjeto(String strQuery);*/
	public void getRefresh(Object objeto);
	
}
 