package remote.dao.impl;

import remote.dao.IAllocationDao;
import remote.util.HibernateUtil;

public class AllocationDao extends GenericDao implements IAllocationDao{

	public AllocationDao() {
		super(HibernateUtil.getSessionFactory());
	}

}
