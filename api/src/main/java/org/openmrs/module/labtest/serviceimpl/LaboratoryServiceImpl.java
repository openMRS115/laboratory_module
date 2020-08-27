package org.openmrs.module.labtest.serviceimpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.labtest.dao.LaboratoryDAO;
import org.openmrs.module.labtest.pojo.LaboratoryBean;
import org.openmrs.module.labtest.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("labtest.LaboratoryService")
public class LaboratoryServiceImpl extends BaseOpenmrsService implements LaboratoryService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private LaboratoryDAO laboratoryDAO;
	
	public void setLaboratoryDAO(LaboratoryDAO laboratoryDAO) {
		this.laboratoryDAO = laboratoryDAO;
	}
	
	public LaboratoryDAO getLaboratoryDAO() {
		return laboratoryDAO;
	}
	
	@Override
	public List<LaboratoryBean> getAllResults() {
		return laboratoryDAO.getAllResults();
	}
	
	@Override
	public LaboratoryBean getResultByConditions(int resultId) {
		return laboratoryDAO.getResultByConditions(resultId);
	}
	
	@Override
	public void saveResult(LaboratoryBean laboratoryBean) {
		this.laboratoryDAO.saveResult(laboratoryBean);
	}
	
	@Override
	public void updateResult(LaboratoryBean laboratoryBean) {
		this.laboratoryDAO.updateResult(laboratoryBean);
	}
	
	@Override
	public void deleteResult(LaboratoryBean laboratoryBean) {
		this.laboratoryDAO.deleteResult(laboratoryBean);
	}
	
	@Override
	public List<String> getPersonList() {
		return laboratoryDAO.getPersonList();
	}
	
}
