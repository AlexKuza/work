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

import sbild.model.EmpltopSum;
import sbild.service.base.EmpltopSumLocalServiceBaseImpl;

/**
 * The implementation of the empltop sum local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>sbild.service.EmpltopSumLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liferay
 * @see EmpltopSumLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=sbild.model.EmpltopSum",
	service = AopService.class
)
public class EmpltopSumLocalServiceImpl extends EmpltopSumLocalServiceBaseImpl {
	
	public EmpltopSum addEmpltopSum(String pos, String lastname, long sum)
			throws PortalException {

			long topsumId = counterLocalService.increment();
			
			EmpltopSum topsum = empltopSumPersistence.create(lastname);

			topsum.setPosition(pos);
			//topsum.setLastname(lastname);
			topsum.setSum(sum);

			
			empltopSumPersistence.update(topsum);

			// Calls to other Liferay frameworks go here

			return topsum;
		}
	
	public List<EmpltopSum> findTopBySum(int begin, int end) throws SystemException {

		    return empltopSumFinder.findTopBySum(
		    		begin, end);
		}
	
	public void deleteEmplTopSums() {
		
		empltopSumPersistence.removeAll();
	}

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>sbild.service.EmpltopSumLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>sbild.service.EmpltopSumLocalServiceUtil</code>.
	 */
}