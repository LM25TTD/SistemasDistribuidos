package remote.dao;

import java.io.Serializable;
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
	public <T> T getObjeto( Class< T > classe, Serializable id );
}
 