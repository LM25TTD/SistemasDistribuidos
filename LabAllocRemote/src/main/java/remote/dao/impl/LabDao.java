package remote.dao.impl;

import remote.dao.ILabDao;
import remote.util.HibernateUtil;

public class LabDao extends GenericDao implements ILabDao {

	public LabDao() {
		super(HibernateUtil.getSessionFactory());
	}

}
