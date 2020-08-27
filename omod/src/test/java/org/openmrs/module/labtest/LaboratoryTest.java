package org.openmrs.module.labtest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.module.labtest.dao.LaboratoryDAO;
import org.openmrs.module.labtest.pojo.LaboratoryBean;
import org.openmrs.module.labtest.serviceimpl.LaboratoryServiceImpl;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class LaboratoryTest {
	
	@InjectMocks
	LaboratoryServiceImpl laboratoryServiceTest;
	
	@Mock
	LaboratoryDAO laboratoryDAO;
	
	@Before
	public void setupMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testDao() {
		LaboratoryBean laboratoryBean = new LaboratoryBean();
		laboratoryBean.setName("Test");
		laboratoryServiceTest.saveResult(laboratoryBean);
		assertThat(laboratoryBean, hasProperty("name", is("Test")));
		
	}
}
