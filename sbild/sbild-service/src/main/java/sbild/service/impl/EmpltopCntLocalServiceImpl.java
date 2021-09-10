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
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import sbild.model.EmpltopCnt;
import sbild.service.base.EmpltopCntLocalServiceBaseImpl;

/**
 * The implementation of the empltop cnt local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>sbild.service.EmpltopCntLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liferay
 * @see EmpltopCntLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=sbild.model.EmpltopCnt",
	service = AopService.class
)
public class EmpltopCntLocalServiceImpl extends EmpltopCntLocalServiceBaseImpl {
	
	public EmpltopCnt addEmpltopCnt(String pos, String lastname, int count)
			throws PortalException {

			long topcntId = counterLocalService.increment();

			EmpltopCnt topcnt = empltopCntPersistence.create(lastname);

			topcnt.setPosition(pos);
			//topcnt.setLastname(lastname);
			topcnt.setCount(count);

			
			empltopCntPersistence.update(topcnt);

			// Calls to other Liferay frameworks go here

			return topcnt;
		}
	
	public List<EmpltopCnt> findTopByCnt(int begin, int end) throws SystemException {

	    return empltopCntFinder.findTopByCnt(
	    		begin, end);
	}

	public void deleteEmplTopCnts() {
		
		empltopCntPersistence.removeAll();
	}

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>sbild.service.EmpltopCntLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>sbild.service.EmpltopCntLocalServiceUtil</code>.
	 */
}