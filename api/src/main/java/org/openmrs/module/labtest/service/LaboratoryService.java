package org.openmrs.module.labtest.service;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.labtest.pojo.LaboratoryBean;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LaboratoryService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	List<LaboratoryBean> getAllResults();
	
	@Transactional(readOnly = true)
	LaboratoryBean getResultByConditions(int resultId);
	
	void saveResult(LaboratoryBean laboratoryBean);
	
	void updateResult(LaboratoryBean laboratoryBean);
	
	void deleteResult(LaboratoryBean laboratoryBean);
	
	List<String> getPersonList();
}
