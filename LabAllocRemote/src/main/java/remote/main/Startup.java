package remote.main;

import java.util.List;

import org.hibernate.Session;

import remote.dao.impl.GenericDao;
import remote.dao.impl.LabDao;
import remote.model.impl.Lab;
import remote.util.HibernateUtil;

public class Startup {
	
	public static void main(String[] args) {
		 //Session session = HibernateUtil.getSessionFactory().openSession();
		 LabDao labDao = new LabDao();
		 
		 @SuppressWarnings("unchecked")
		List<Lab> laboratories = labDao.getAll(Lab.class);
		 
		 for (Lab lab : laboratories) {
			System.out.println(lab.getNameLab());
		}
		 		 
	}

}
