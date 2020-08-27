/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.labtest.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.labtest.pojo.LaboratoryBean;
import org.openmrs.module.labtest.service.LaboratoryService;
import org.openmrs.module.labtest.util.DateUtil;
import org.openmrs.module.labtest.util.HttpUtil;
import org.openmrs.module.labtest.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This class configured as controller using annotation and mapped with the URL of
 * 'module/${rootArtifactid}/${rootArtifactid}Link.form'.
 */
@Controller("labtest.LabTestController")
//@RequestMapping(value = "module/labtest/labtest.form")
@RequestMapping(value = "module/labtest")
public class LabtestController {
	
	/** Logger for this class and subclasses */
	protected final Log log = LogFactory.getLog(getClass());
	
	//UserService userService;
	
	private LaboratoryBean laboratoryBean = new LaboratoryBean();
	
	HttpUtil httpUtil = new HttpUtil();
	
	JsonUtil jsonUtil = new JsonUtil();
	
	@Autowired
	private LaboratoryService laboratoryService;
	
	public LaboratoryService getLaboratoryService() {
		return laboratoryService;
	}
	
	public LaboratoryBean getLaboratoryBean() {
		return laboratoryBean;
	}
	
	public void setLaboratoryBean(LaboratoryBean laboratoryBean) {
		this.laboratoryBean = laboratoryBean;
	}
	
	@Resource
	public void setLaboratoryService(LaboratoryService laboratoryService) {
		this.laboratoryService = laboratoryService;
	}
	
	/** Success form view name */
	//private final String VIEW = "/module/labtest/labtest";
	private final String VIEW = "/module/labtest/labtest";
	
	/**
	 * Initially called after the getUsers method to get the landing form name
	 * 
	 * @return String form view name
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String onGet() {
		return VIEW;
	}
	
	/**
	 * All the parameters are optional based on the necessity
	 * 
	 * @param httpSession
	 * @param anyRequestObject
	 * @param errors
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String onPost(HttpSession httpSession, @ModelAttribute("anyRequestObject") Object anyRequestObject,
	        BindingResult errors) {
		
		if (errors.hasErrors()) {
			// return error view
		}
		
		return VIEW;
	}
	
	/**
	 * This class returns the form backing object. This can be a string, a boolean, or a normal java
	 * pojo. The bean name defined in the ModelAttribute annotation and the type can be just defined
	 * by the return type of this method
	 */
	
	/*@ModelAttribute("users")
	protected List<User> getUsers() throws Exception {
		List<User> users = userService.getAllUsers();

		// this object will be made available to the jsp page under the variable name
		// that is defined in the @ModuleAttribute tag
		return users;
	}*/
	
	@RequestMapping(value = "/labtest.form")
	@ModelAttribute("resultList")
	public List<LaboratoryBean> getAllResults(Model model) throws Exception {
		List<LaboratoryBean> resultList = laboratoryService.getAllResults();
		List<String> personList = laboratoryService.getPersonList();
		model.addAttribute("personList", personList);
		return resultList;
	}
	
	@RequestMapping(value = "/addtest.form", method = RequestMethod.POST)
	public String saveResult(@ModelAttribute("laboratoryBean") LaboratoryBean laboratoryBean,
	        @RequestParam("name") String name) throws Exception {
		laboratoryBean.setCreateTime(DateUtil.getCurrentTime());
		String personUrl = "http://localhost:8080/openmrs/ws/rest/v1/person?q=" + name
		        + "&v=custom:age,gender,identifiers,addresses,dead,deathDate";
		String personJson = httpUtil.getJson(personUrl);
		int age = jsonUtil.getAge(personJson);
		String gender = jsonUtil.getGender(personJson);
		String identifier = jsonUtil.getIdentifier(personJson);
		String province = jsonUtil.getProvince(personJson);
		String city = jsonUtil.getCity(personJson);
		String latitude = jsonUtil.getlatitude(personJson);
		String longitude = jsonUtil.getlongitude(personJson);
		boolean dead = jsonUtil.getDead(personJson);
		String deathDate = jsonUtil.getDeathDate(personJson);
		laboratoryBean.setAge(age);
		laboratoryBean.setGender(gender);
		laboratoryBean.setIdentifier(identifier);
		laboratoryBean.setProvince(province);
		laboratoryBean.setCity(city);
		laboratoryBean.setLatitude(latitude);
		laboratoryBean.setLongitude(longitude);
		laboratoryBean.setDead(dead);
		laboratoryBean.setDeathDate(deathDate);
		laboratoryService.saveResult(laboratoryBean);
		return "redirect: labtest.form";
	}
	
	@RequestMapping(value = "/managetest.form", method = RequestMethod.POST)
	@ModelAttribute("resultBean")
	public LaboratoryBean getResultByConditions(@RequestParam("id") int id) throws Exception {
		LaboratoryBean resultBean = laboratoryService.getResultByConditions(id);
		return resultBean;
	}
	
	@RequestMapping(value = "/updatetest.form", method = RequestMethod.POST)
	public String updateResult(@ModelAttribute("laboratoryBean") LaboratoryBean laboratoryBean) throws Exception {
		laboratoryBean.setCreateTime(DateUtil.getCurrentTime());
		laboratoryService.updateResult(laboratoryBean);
		return "redirect: labtest.form";
	}
	
	@RequestMapping(value = "/deletetest.form", method = RequestMethod.POST)
	public String deleteResult(@ModelAttribute("laboratoryBean") LaboratoryBean laboratoryBean) throws Exception {
		laboratoryService.deleteResult(laboratoryBean);
		return "redirect: labtest.form";
	}
}
