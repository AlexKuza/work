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

import java.util.Date;

import org.osgi.service.component.annotations.Component;

import sbild.model.Purchase;
import sbild.service.base.PurchaseLocalServiceBaseImpl;

/**
 * The implementation of the purchase local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>sbild.service.PurchaseLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liferay
 * @see PurchaseLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=sbild.model.Purchase",
	service = AopService.class
)
public class PurchaseLocalServiceImpl extends PurchaseLocalServiceBaseImpl {
	
	public Purchase addPurchase(long purchId, long electrId, long emplId,
			Date purchDate, long purchtypeId)
		throws PortalException {

		Purchase purch = purchasePersistence.create(purchId);

		purch.setElectrId(electrId);
		purch.setEmplId(emplId);
		purch.setPurchDate(purchDate);
		purch.setPurchtypeId(purchtypeId);

		
		purchasePersistence.update(purch);

		// Calls to other Liferay frameworks go here

		return purch;
	}
	
	public void deletePurchases() {
		
		purchasePersistence.removeAll();
	}

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>sbild.service.PurchaseLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>sbild.service.PurchaseLocalServiceUtil</code>.
	 */
}