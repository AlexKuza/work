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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import sbild.model.EmpltopCnt;

import sbild.service.EmpltopCntLocalService;
import sbild.service.EmpltopCntLocalServiceUtil;
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
 * Provides the base implementation for the empltop cnt local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link sbild.service.impl.EmpltopCntLocalServiceImpl}.
 * </p>
 *
 * @author liferay
 * @see sbild.service.impl.EmpltopCntLocalServiceImpl
 * @generated
 */
public abstract class EmpltopCntLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, EmpltopCntLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>EmpltopCntLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>EmpltopCntLocalServiceUtil</code>.
	 */

	/**
	 * Adds the empltop cnt to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmpltopCntLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param empltopCnt the empltop cnt
	 * @return the empltop cnt that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EmpltopCnt addEmpltopCnt(EmpltopCnt empltopCnt) {
		empltopCnt.setNew(true);

		return empltopCntPersistence.update(empltopCnt);
	}

	/**
	 * Creates a new empltop cnt with the primary key. Does not add the empltop cnt to the database.
	 *
	 * @param lastname the primary key for the new empltop cnt
	 * @return the new empltop cnt
	 */
	@Override
	@Transactional(enabled = false)
	public EmpltopCnt createEmpltopCnt(String lastname) {
		return empltopCntPersistence.create(lastname);
	}

	/**
	 * Deletes the empltop cnt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmpltopCntLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lastname the primary key of the empltop cnt
	 * @return the empltop cnt that was removed
	 * @throws PortalException if a empltop cnt with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EmpltopCnt deleteEmpltopCnt(String lastname) throws PortalException {
		return empltopCntPersistence.remove(lastname);
	}

	/**
	 * Deletes the empltop cnt from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmpltopCntLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param empltopCnt the empltop cnt
	 * @return the empltop cnt that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EmpltopCnt deleteEmpltopCnt(EmpltopCnt empltopCnt) {
		return empltopCntPersistence.remove(empltopCnt);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return empltopCntPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			EmpltopCnt.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return empltopCntPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sbild.model.impl.EmpltopCntModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return empltopCntPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sbild.model.impl.EmpltopCntModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return empltopCntPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return empltopCntPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return empltopCntPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public EmpltopCnt fetchEmpltopCnt(String lastname) {
		return empltopCntPersistence.fetchByPrimaryKey(lastname);
	}

	/**
	 * Returns the empltop cnt with the primary key.
	 *
	 * @param lastname the primary key of the empltop cnt
	 * @return the empltop cnt
	 * @throws PortalException if a empltop cnt with the primary key could not be found
	 */
	@Override
	public EmpltopCnt getEmpltopCnt(String lastname) throws PortalException {
		return empltopCntPersistence.findByPrimaryKey(lastname);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return empltopCntPersistence.create((String)primaryKeyObj);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return empltopCntLocalService.deleteEmpltopCnt(
			(EmpltopCnt)persistedModel);
	}

	@Override
	public BasePersistence<EmpltopCnt> getBasePersistence() {
		return empltopCntPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return empltopCntPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the empltop cnts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sbild.model.impl.EmpltopCntModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of empltop cnts
	 * @param end the upper bound of the range of empltop cnts (not inclusive)
	 * @return the range of empltop cnts
	 */
	@Override
	public List<EmpltopCnt> getEmpltopCnts(int start, int end) {
		return empltopCntPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of empltop cnts.
	 *
	 * @return the number of empltop cnts
	 */
	@Override
	public int getEmpltopCntsCount() {
		return empltopCntPersistence.countAll();
	}

	/**
	 * Updates the empltop cnt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmpltopCntLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param empltopCnt the empltop cnt
	 * @return the empltop cnt that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EmpltopCnt updateEmpltopCnt(EmpltopCnt empltopCnt) {
		return empltopCntPersistence.update(empltopCnt);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			EmpltopCntLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		empltopCntLocalService = (EmpltopCntLocalService)aopProxy;

		_setLocalServiceUtilService(empltopCntLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EmpltopCntLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return EmpltopCnt.class;
	}

	protected String getModelClassName() {
		return EmpltopCnt.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = empltopCntPersistence.getDataSource();

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

	private void _setLocalServiceUtilService(
		EmpltopCntLocalService empltopCntLocalService) {

		try {
			Field field = EmpltopCntLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, empltopCntLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ElectroEmployeePersistence electroEmployeePersistence;

	@Reference
	protected ElectronicsPersistence electronicsPersistence;

	@Reference
	protected ElectroTypePersistence electroTypePersistence;

	@Reference
	protected EmployeePersistence employeePersistence;

	protected EmpltopCntLocalService empltopCntLocalService;

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
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}