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

package sbild.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import sbild.model.ElectroEmployee;

import sbild.service.ElectroEmployeeService;
import sbild.service.ElectroEmployeeServiceUtil;
import sbild.service.persistence.ElectroEmployeePersistence;
import sbild.service.persistence.ElectroTypePersistence;
import sbild.service.persistence.ElectronicsPersistence;
import sbild.service.persistence.EmployeePersistence;
import sbild.service.persistence.EmpltopCntFinder;
import sbild.service.persistence.EmpltopCntPersistence;
import sbild.service.persistence.EmpltopSumFinder;
import sbild.service.persistence.EmpltopSumPersistence;
import sbild.service.persistence.PositionTypePersistence;
import sbild.service.persistence.PurchasePersistence;
import sbild.service.persistence.PurchaseTypePersistence;

/**
 * Provides the base implementation for the electro employee remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link sbild.service.impl.ElectroEmployeeServiceImpl}.
 * </p>
 *
 * @author liferay
 * @see sbild.service.impl.ElectroEmployeeServiceImpl
 * @generated
 */
public abstract class ElectroEmployeeServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, ElectroEmployeeService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ElectroEmployeeService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ElectroEmployeeServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ElectroEmployeeService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		electroEmployeeService = (ElectroEmployeeService)aopProxy;

		_setServiceUtilService(electroEmployeeService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ElectroEmployeeService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ElectroEmployee.class;
	}

	protected String getModelClassName() {
		return ElectroEmployee.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = electroEmployeePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(
		ElectroEmployeeService electroEmployeeService) {

		try {
			Field field = ElectroEmployeeServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, electroEmployeeService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected sbild.service.ElectroEmployeeLocalService
		electroEmployeeLocalService;

	protected ElectroEmployeeService electroEmployeeService;

	@Reference
	protected ElectroEmployeePersistence electroEmployeePersistence;

	@Reference
	protected ElectronicsPersistence electronicsPersistence;

	@Reference
	protected ElectroTypePersistence electroTypePersistence;

	@Reference
	protected EmployeePersistence employeePersistence;

	@Reference
	protected EmpltopCntPersistence empltopCntPersistence;

	@Reference
	protected EmpltopCntFinder empltopCntFinder;

	@Reference
	protected EmpltopSumPersistence empltopSumPersistence;

	@Reference
	protected EmpltopSumFinder empltopSumFinder;

	@Reference
	protected PositionTypePersistence positionTypePersistence;

	@Reference
	protected PurchasePersistence purchasePersistence;

	@Reference
	protected PurchaseTypePersistence purchaseTypePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}