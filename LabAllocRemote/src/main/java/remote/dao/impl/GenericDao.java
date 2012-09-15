package remote.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

import remote.dao.IGenericDao;


@SuppressWarnings(value={"deprecation","rawtypes"})
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
	
	public void clearSession(){
	     this.sessionFactory.getCurrentSession().flush();
	     this.sessionFactory.getCurrentSession().clear();
	   }

	
	/**
	 * Executa operação de inclusão
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
			tratarErro(ex, "inclusão");
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
			tratarErro(ex, "inclusão");
		}
		
	}
	
	/**
	 * Executa operação de alteração
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
			tratarErro(ex, "alteração");
			
		}
	}
	
	/**
	 * Executa operação de exclusão
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
			tratarErro(ex, "exclusão");
		}
	}
	
	/**
	 * Executa operação de exclusão
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
			tratarErro(ex, "exclusão");
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
	
	/**
	 * Listagem dos objetos da classe informada
	 * @param c Classe dos objetos
	 * @param campoOrderBy Nome do atributo que serï¿½ ordenado
	 * @param order Ordenação da lista. Informe 1 para ascendente e outro valor para descendente 
	 * @return listagem dos objetos da classe informada 
	 */
	public List getAll(Class classe, String campoOrderBy, int order) {
		this.sessionFactory.getCurrentSession().beginTransaction();
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(classe);
		if (campoOrderBy != null && campoOrderBy.trim().length() > 0){
			if (order == 1)
				cri.addOrder(Order.asc(campoOrderBy));
			else cri.addOrder(Order.desc(campoOrderBy));
		}
		return cri.list();

	}
	
	/**
	 * Listagem dos objetos da classe informada com paginaca
	 * @param c - Classe dos objetos
	 * @param firstResult - Inicio da listagem
	 * @param maxResults - quantidade maxima de objetos retornados
	 * @return listagem dos objetos da classe informada 
	 */
	public List getAll(Class classe, int firstResult, int maxResults) {
		this.sessionFactory.getCurrentSession().beginTransaction();
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(classe);
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(maxResults);
		return criteria.list();
	}
	
	/**
	 * Listagem dos objetos da classe informada com paginaca
	 * @param c - Classe dos objetos
	 * @param firstResult - Inicio da listagem
	 * @param maxResults - quantidade maxima de objetos retornados
	 * @param campoOrderBy Nome do atributo que serï¿½ ordenado
	 * @param order Ordenação da lista. Informe 1 para ascendente e outro valor para descendente 
	 * @return listagem dos objetos da classe informada 
	 */
    public List getAll(Class classe, int firstResult, int maxResults, String campoOrderBy, int order) {
    	this.sessionFactory.getCurrentSession().beginTransaction();
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(classe);
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(maxResults);
		if (campoOrderBy != null && campoOrderBy.trim().length() > 0){
			if (order == 1)
				criteria.addOrder(Order.asc(campoOrderBy));
			else criteria.addOrder(Order.desc(campoOrderBy));
		}
		return criteria.list();	
	}	
	
	/**
	 * Listagem por filtros
	 * @param c - Classe dos objetos
	 * @param filtros matriz que contem na primeira coluna o campo a ser filtrado e na segunda coluna o dado do filtro 
	 * @return listagem retornada da consulta com os filtros
	 */
	public List getAll(Class classe, String [][]filtros) {
		this.sessionFactory.getCurrentSession().beginTransaction();
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(classe);
		for (int i=0;i< filtros.length;i++){
			cri.add(Expression.like(filtros[i][0], filtros[i][1], MatchMode.ANYWHERE).ignoreCase());
		}
		return cri.list();		
	}
	
	/**
	 * Listagem por filtros
	 * @param c - Classe dos objetos
	 * @param filtros matriz que contem na primeira coluna o campo a ser filtrado e na segunda coluna o dado do filtro 
	 * @return listagem retornada da consulta com os filtros
	 */
	public List getAll(Class classe, String [][]filtros, String campoOrderBy, int order) {
		this.sessionFactory.getCurrentSession().beginTransaction();
		Criteria cri = this.sessionFactory.getCurrentSession().createCriteria(classe);
		for (int i=0;i< filtros.length;i++){
			cri.add(Expression.like(filtros[i][0],filtros[i][1],MatchMode.ANYWHERE).ignoreCase());
		}
		if (campoOrderBy != null && campoOrderBy.trim().length() > 0){
			if (order == 1)
				cri.addOrder(Order.asc(campoOrderBy));
			else cri.addOrder(Order.desc(campoOrderBy));
		}
		
		return cri.list();	
	}	
		
	/**
	 * Recupera o Objeto na base de dados
	 * @param objeto Objeto a ser recuperado 
	 * */
    public void getRefresh(Object objeto){
    	this.sessionFactory.getCurrentSession().beginTransaction();
		this.sessionFactory.getCurrentSession().refresh(objeto);
				
	}	
	
		
	/**
	 * ResponsÃ¡vel pelo tratamento de erros
	 * @param ex - ExceÃ§Ã£o levantada pelo sistema.
	 * @param acao - AÃ§Ã£o atual do sistema: inclusÃ£o, alteraÃ§Ã£o, exclusÃ£o, etc.
	 * @throws Exception
	 */
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
		// Erro Campos obrigatÃ³rios nÃ£o informados
		else if (msgException.contains("NOT-NULL PROPERTY REFERENCES A NULL OR TRANSIENT VALUE")){

			throw new Exception("Campos obrigatórios não foram informados.");
		}
		// Erro na exclusÃ£o dos dados, por estar referenciado por outras tabelas
		else if ((msgException.contains("EXCLUS") && msgException.contains("VIOLA") && msgException.contains("CHAVE ESTRANGEIRA"))
				|| (msgException.contains("DELETE ON TABLE") && msgException.contains("VIOLATES FOREIGN KEY CONSTRAINT"))){

			throw new Exception("O(s) item(ns) selecionado(s) está(ão) associado(s) a outros cadastros.");
		}	
		// Erro de Foreign Key
		else if ((msgException.contains("INSER") && msgException.contains("ATUALIZA") && msgException.contains("VIOLA") && msgException.contains("CHAVE ESTRANGEIRA"))
				|| (msgException.contains("INSERT OR UPDATE ON TABLE") && msgException.contains("VIOLATES FOREIGN KEY CONSTRAINT"))){

			throw new Exception("O cadastro faz referência a um registro inexistente.");
		} 	
		// Demais erros
		else{
			throw new Exception("Erro na "+ acao + " dos dados.");
		}				
	}		

}
