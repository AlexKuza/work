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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import sbild.model.Electronics;
import sbild.service.base.ElectronicsLocalServiceBaseImpl;

/**
 * The implementation of the electronics local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>sbild.service.ElectronicsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liferay
 * @see ElectronicsLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=sbild.model.Electronics",
	service = AopService.class
)
public class ElectronicsLocalServiceImpl
	extends ElectronicsLocalServiceBaseImpl {
	
	public Electronics addElectronics(long electrId, String name, long etypeId, long price, int count,
			Boolean inStock, Boolean archive, String description, ServiceContext serviceContext)
		throws PortalException {


		validate(name, etypeId, price, count, inStock, archive, description);


		Electronics electric = electronicsPersistence.create(electrId);

		electric.setName(name);
		electric.setEtypeId(etypeId);
		electric.setPrice(price);
		electric.setCount(count);
		electric.setInStock(inStock);
		electric.setArchive(archive);
		electric.setDescription(description);
		//electric.setExpandoBridgeAttributes(serviceContext);
		
		electronicsPersistence.update(electric);

		// Calls to other Liferay frameworks go here

		return electric;
	}
	
	public Electronics updateElectronics(long electrId, String name, long etypeId, long price, int count,
			Boolean inStock, Boolean archive, String description, ServiceContext serviceContext)
		throws PortalException, SystemException {

		
		validate(name, etypeId, price, count, inStock, archive, description);

		Electronics electric =
				electronicsPersistence.findByPrimaryKey(electrId);


		electric.setName(name);
		electric.setEtypeId(etypeId);
		electric.setPrice(price);
		electric.setCount(count);
		electric.setInStock(inStock);
		electric.setArchive(archive);
		electric.setDescription(description);
		//electric.setExpandoBridgeAttributes(serviceContext);

		electronicsPersistence.update(electric);

		// Integrate with Liferay frameworks here.

		return electric;
	}
	
	public Electronics deleteElectronics(Electronics electric)
		{

		electronicsPersistence.remove(electric);

			return electric;
		}

		public Electronics deleteElectronics(long electrId) throws PortalException {

			Electronics electric =
					electronicsPersistence.findByPrimaryKey(electrId);

			return deleteElectronics(electric);
		}
		


		public Electronics getElectronics(long electrId) throws PortalException {
			return electronicsPersistence.findByPrimaryKey(electrId);
		}



		protected void validate(String name, long etypeId, long price, int count,
				Boolean inStock, Boolean archive, String description)
				throws PortalException {
			if (Validator.isNull(name)) {
				throw new PortalException();
			}
			
/*
				if (Validator.isNull(name)) {
					throw new GuestbookEntryNameException();
				}

				if (!Validator.isEmailAddress(email)) {
					throw new GuestbookEntryEmailException();
				}

				if (Validator.isNull(entry)) {
					throw new GuestbookEntryMessageException();
				}
				*/
			}
		
		public void deleteElectronics() {
			
			electronicsPersistence.removeAll();
		}

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>sbild.service.ElectronicsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>sbild.service.ElectronicsLocalServiceUtil</code>.
	 */
}