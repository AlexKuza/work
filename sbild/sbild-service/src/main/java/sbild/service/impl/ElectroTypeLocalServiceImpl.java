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

import org.osgi.service.component.annotations.Component;

import sbild.model.ElectroType;
import sbild.service.base.ElectroTypeLocalServiceBaseImpl;

/**
 * The implementation of the electro type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>sbild.service.ElectroTypeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liferay
 * @see ElectroTypeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=sbild.model.ElectroType",
	service = AopService.class
)
public class ElectroTypeLocalServiceImpl
	extends ElectroTypeLocalServiceBaseImpl {
	
	public ElectroType addElectroType(long etypeId, String name)
			throws PortalException {


			ElectroType etype = electroTypePersistence.create(etypeId);

			etype.setName(name);

			
			electroTypePersistence.update(etype);

			// Calls to other Liferay frameworks go here

			return etype;
		}
	
	public void deleteElectroTypes() {
		
		electroTypePersistence.removeAll();
	}

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>sbild.service.ElectroTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>sbild.service.ElectroTypeLocalServiceUtil</code>.
	 */
}