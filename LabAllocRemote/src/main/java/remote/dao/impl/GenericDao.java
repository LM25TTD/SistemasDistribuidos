package remote.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import remote.dao.IGenericDao;


@SuppressWarnings(value={"rawtypes"})
public class GenericDao implements IGenericDao{
	
	public GenericDao (SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

	
	/**
	 * Executa opera��o de inclus�o
	 * @throws Exception 
	 * @throws Exception 
	 */
	public void save(Object objeto) throws Exception{
		Transaction transaction=null;
		try{
			transaction = this.sessionFactory.getCurrentSession().beginTransaction();
			this.sessionFactory.getCurrentSession().save(objeto);
			this.sessionFactory.getCurrentSession().persist(objeto);
			//this.sessionFactory.getCurrentSession().flush();
			transaction.commit();
			
									
		}catch (Exception  ex) {
			if (transaction!=null)
				transaction.rollback();
			ex.printStackTrace();
			tratarErro(ex, "inclus�o");
		}
		
	}
	
	public void saveOrUpdate(Object objeto) throws Exception{
		Transaction transaction=null;
		try{
			transaction = this.sessionFactory.getCurrentSession().beginTransaction();
			this.sessionFactory.getCurrentSession().saveOrUpdate(objeto);
			this.sessionFactory.getCurrentSession().persist(objeto);
			//this.sessionFactory.getCurrentSession().flush();
			transaction.commit();
			
									
		}catch (Exception  ex) {
			if (transaction!=null)
				transaction.rollback();
			ex.printStackTrace();
			tratarErro(ex, "inclus�o");
		}
		
	}
	
	/**
	 * Executa opera��o de altera��o
	 * @throws Exception 
	 */
	public void update(Object objeto) throws Exception {
		Transaction transaction=null;
		try{
			transaction = this.sessionFactory.getCurrentSession().beginTransaction();

			this.sessionFactory.getCurrentSession().update(objeto);
			this.sessionFactory.getCurrentSession().persist(objeto);
			this.sessionFactory.getCurrentSession().flush();
			
			transaction.commit();
			
		}catch (Exception  ex) {
			if (transaction!=null)
				transaction.rollback();
			this.sessionFactory.getCurrentSession().cancelQuery();
			ex.printStackTrace();
			tratarErro(ex, "altera��o");
			
		}
	}
	
	/**
	 * Executa opera��o de exclus�o
	 * @throws Exception 
	 */
	public void delete(Object objeto) throws Exception {
		Transaction transaction=null;
		try{
			transaction = this.sessionFactory.getCurrentSession().beginTransaction();

			this.sessionFactory.getCurrentSession().delete(objeto);
			this.sessionFactory.getCurrentSession().flush();
			
			transaction.commit();
			
		}catch (Exception  ex) {
			if (transaction!=null)
				transaction.rollback();
			ex.printStackTrace();
			tratarErro(ex, "exclus�o");
		}
	}
	
	/**
	 * Executa opera��o de exclus�o
	 * @throws Exception 
	 */
	public void deleteAll(List listaObjetos) throws Exception {
		Transaction transaction=null;
		try{
			transaction = this.sessionFactory.getCurrentSession().beginTransaction();

			for (Object object : listaObjetos) {
				this.sessionFactory.getCurrentSession().delete(object);
			}
			this.sessionFactory.getCurrentSession().flush();
			transaction.commit();
			
		}catch (Exception  ex) {
			if (transaction!=null)
				transaction.rollback();
			ex.printStackTrace();
			tratarErro(ex, "exclus�o");
		}
	}
	 
	/**
	 * Recupera um objeto a partir de um identificador
	 */
	@SuppressWarnings("unchecked")
	public <T> T getObjeto( Class< T > classe, Serializable id ) {

		return (T) this.sessionFactory.getCurrentSession().get( classe, id );
	}
	
	/**
	 * Listagem dos objetos da classe informada
	 */
	public List getAll(Class classe) {
		this.sessionFactory.getCurrentSession().beginTransaction();
		return this.sessionFactory.getCurrentSession().createCriteria(classe).list();
	}
	
	
	private void tratarErro(Exception ex, String acao) throws Exception{
		String msgException = "";
		
		if (ex.getCause()!=null)
			msgException = ((SQLException)ex.getCause()).getNextException().getMessage().toUpperCase();
		else
			msgException = ex.getMessage().toUpperCase();
		
		// Erro Chave duplicada	
		if (msgException.contains("DUPLICAR CHAVE VIOLA") || msgException.contains("DUPLICATE KEY VIOLATES")){
			
			throw new Exception("Registro cadastrado anteriormente.");
		}
		// Erro Campos obrigatórios não informados
		else if (msgException.contains("NOT-NULL PROPERTY REFERENCES A NULL OR TRANSIENT VALUE")){

			throw new Exception("Campos obrigat�rios n�o foram informados.");
		}
		// Erro na exclusão dos dados, por estar referenciado por outras tabelas
		else if ((msgException.contains("EXCLUS") && msgException.contains("VIOLA") && msgException.contains("CHAVE ESTRANGEIRA"))
				|| (msgException.contains("DELETE ON TABLE") && msgException.contains("VIOLATES FOREIGN KEY CONSTRAINT"))){

			throw new Exception("O(s) item(ns) selecionado(s) est�(�o) associado(s) a outros cadastros.");
		}	
		// Erro de Foreign Key
		else if ((msgException.contains("INSER") && msgException.contains("ATUALIZA") && msgException.contains("VIOLA") && msgException.contains("CHAVE ESTRANGEIRA"))
				|| (msgException.contains("INSERT OR UPDATE ON TABLE") && msgException.contains("VIOLATES FOREIGN KEY CONSTRAINT"))){

			throw new Exception("O cadastro faz refer�ncia a um registro inexistente.");
		} 	
		// Demais erros
		else{
			throw new Exception("Erro na "+ acao + " dos dados.");
		}				
	}		

}
