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

import org.osgi.service.component.annotations.Component;

import sbild.model.PositionType;
import sbild.service.base.PositionTypeLocalServiceBaseImpl;

/**
 * The implementation of the position type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>sbild.service.PositionTypeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liferay
 * @see PositionTypeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=sbild.model.PositionType",
	service = AopService.class
)
public class PositionTypeLocalServiceImpl
	extends PositionTypeLocalServiceBaseImpl {
	
	public PositionType addPositionType(long posId, String name)
		throws PortalException {


		PositionType postype = positionTypePersistence.create(posId);

		postype.setName(name);

		
		positionTypePersistence.update(postype);

		// Calls to other Liferay frameworks go here

		return postype;
	}
	
	public void deletePositionTypes() {
		
		positionTypePersistence.removeAll();
	}

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>sbild.service.PositionTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>sbild.service.PositionTypeLocalServiceUtil</code>.
	 */
}