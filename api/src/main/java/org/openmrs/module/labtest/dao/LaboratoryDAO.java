package org.openmrs.module.labtest.dao;

import java.util.List;

import org.openmrs.module.labtest.pojo.LaboratoryBean;

/**
 * @author yilunjiang
 */
public interface LaboratoryDAO {
	
	List<LaboratoryBean> getAllResults();
	
	LaboratoryBean getResultByConditions(int resultId);
	
	void saveResult(LaboratoryBean laboratoryBean);
	
	void updateResult(LaboratoryBean laboratoryBean);
	
	void deleteResult(LaboratoryBean laboratoryBean);
	
	List<String> getPersonList();
	
}
