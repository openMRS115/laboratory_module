package org.openmrs.module.labtest.daoimpl;

import javax.annotation.Resource;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.openmrs.module.labtest.dao.LaboratoryDAO;
import org.openmrs.module.labtest.pojo.LaboratoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("labtest.LaboratoryDAO")
public class LaboratoryDAOImpl implements LaboratoryDAO {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	@Resource
	SessionFactory sessionFactory;
	
	@Override
	public List<LaboratoryBean> getAllResults() {
		String hql = "from LaboratoryBean";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<LaboratoryBean> resultsList = query.list();
		sessionFactory.getCurrentSession().flush();
		return resultsList;
	}
	
	@Override
	public LaboratoryBean getResultByConditions(int resultId) {
		String hql = "select laboratoryBean from LaboratoryBean laboratoryBean where laboratoryBean.resultId = ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, resultId);
		LaboratoryBean laboratoryBean = (LaboratoryBean) query.uniqueResult();
		sessionFactory.getCurrentSession().flush();
		return laboratoryBean;
	}
	
	@Override
	public void saveResult(LaboratoryBean laboratoryBean) {
		sessionFactory.getCurrentSession().save(laboratoryBean);
		sessionFactory.getCurrentSession().flush();
		
	}
	
	@Override
	public void updateResult(LaboratoryBean laboratoryBean) {
		sessionFactory.getCurrentSession().update(laboratoryBean);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void deleteResult(LaboratoryBean laboratoryBean) {
		sessionFactory.getCurrentSession().delete(laboratoryBean);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public List<String> getPersonList() {
		String sql = "select given_name from person_name;";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		List<String> personList = query.list();
		return personList;
	}
	
}
