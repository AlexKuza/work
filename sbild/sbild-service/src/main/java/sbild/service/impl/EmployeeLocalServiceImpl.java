/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package sbild.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

import sbild.model.Employee;
import sbild.service.base.EmployeeLocalServiceBaseImpl;

/**
 * The implementation of the employee local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>sbild.service.EmployeeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liferay
 * @see EmployeeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=sbild.model.Employee",
	service = AopService.class
)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
	
	public Employee addEmployee(long emplId, String lastname, String firstname, String patronymic,
			Date birthdate, long posId, boolean gender)
		throws PortalException {

		Employee empl = employeePersistence.create(emplId);

		empl.setLastname(lastname);
		empl.setFirstname(firstname);
		empl.setPatronymic(patronymic);
		empl.setBirthdate(birthdate);
		empl.setPosId(posId);
		empl.setGender(gender);

		
		employeePersistence.update(empl);

		// Calls to other Liferay frameworks go here

		return empl;
	}
	
	public void deleteEmployees() {
		
		employeePersistence.removeAll();
	}

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>sbild.service.EmployeeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>sbild.service.EmployeeLocalServiceUtil</code>.
	 */
}