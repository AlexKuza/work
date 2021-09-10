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
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
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

import sbild.model.PurchaseType;

import sbild.service.PurchaseTypeLocalService;
import sbild.service.PurchaseTypeLocalServiceUtil;
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
 * Provides the base implementation for the purchase type local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link sbild.service.impl.PurchaseTypeLocalServiceImpl}.
 * </p>
 *
 * @author liferay
 * @see sbild.service.impl.PurchaseTypeLocalServiceImpl
 * @generated
 */
public abstract class PurchaseTypeLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, PurchaseTypeLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>PurchaseTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>PurchaseTypeLocalServiceUtil</code>.
	 */

	/**
	 * Adds the purchase type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PurchaseTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purchaseType the purchase type
	 * @return the purchase type that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PurchaseType addPurchaseType(PurchaseType purchaseType) {
		purchaseType.setNew(true);

		return purchaseTypePersistence.update(purchaseType);
	}

	/**
	 * Creates a new purchase type with the primary key. Does not add the purchase type to the database.
	 *
	 * @param purchtypeId the primary key for the new purchase type
	 * @return the new purchase type
	 */
	@Override
	@Transactional(enabled = false)
	public PurchaseType createPurchaseType(long purchtypeId) {
		return purchaseTypePersistence.create(purchtypeId);
	}

	/**
	 * Deletes the purchase type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PurchaseTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purchtypeId the primary key of the purchase type
	 * @return the purchase type that was removed
	 * @throws PortalException if a purchase type with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public PurchaseType deletePurchaseType(long purchtypeId)
		throws PortalException {

		return purchaseTypePersistence.remove(purchtypeId);
	}

	/**
	 * Deletes the purchase type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PurchaseTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purchaseType the purchase type
	 * @return the purchase type that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public PurchaseType deletePurchaseType(PurchaseType purchaseType) {
		return purchaseTypePersistence.remove(purchaseType);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return purchaseTypePersistence.dslQuery(dslQuery);
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
			PurchaseType.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return purchaseTypePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sbild.model.impl.PurchaseTypeModelImpl</code>.
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

		return purchaseTypePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sbild.model.impl.PurchaseTypeModelImpl</code>.
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

		return purchaseTypePersistence.findWithDynamicQuery(
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
		return purchaseTypePersistence.countWithDynamicQuery(dynamicQuery);
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

		return purchaseTypePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public PurchaseType fetchPurchaseType(long purchtypeId) {
		return purchaseTypePersistence.fetchByPrimaryKey(purchtypeId);
	}

	/**
	 * Returns the purchase type with the primary key.
	 *
	 * @param purchtypeId the primary key of the purchase type
	 * @return the purchase type
	 * @throws PortalException if a purchase type with the primary key could not be found
	 */
	@Override
	public PurchaseType getPurchaseType(long purchtypeId)
		throws PortalException {

		return purchaseTypePersistence.findByPrimaryKey(purchtypeId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(purchaseTypeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(PurchaseType.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("purchtypeId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			purchaseTypeLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(PurchaseType.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"purchtypeId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(purchaseTypeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(PurchaseType.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("purchtypeId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return purchaseTypePersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return purchaseTypeLocalService.deletePurchaseType(
			(PurchaseType)persistedModel);
	}

	@Override
	public BasePersistence<PurchaseType> getBasePersistence() {
		return purchaseTypePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return purchaseTypePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the purchase types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sbild.model.impl.PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @return the range of purchase types
	 */
	@Override
	public List<PurchaseType> getPurchaseTypes(int start, int end) {
		return purchaseTypePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of purchase types.
	 *
	 * @return the number of purchase types
	 */
	@Override
	public int getPurchaseTypesCount() {
		return purchaseTypePersistence.countAll();
	}

	/**
	 * Updates the purchase type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PurchaseTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purchaseType the purchase type
	 * @return the purchase type that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PurchaseType updatePurchaseType(PurchaseType purchaseType) {
		return purchaseTypePersistence.update(purchaseType);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			PurchaseTypeLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		purchaseTypeLocalService = (PurchaseTypeLocalService)aopProxy;

		_setLocalServiceUtilService(purchaseTypeLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return PurchaseTypeLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return PurchaseType.class;
	}

	protected String getModelClassName() {
		return PurchaseType.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = purchaseTypePersistence.getDataSource();

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
		PurchaseTypeLocalService purchaseTypeLocalService) {

		try {
			Field field = PurchaseTypeLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, purchaseTypeLocalService);
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

	protected PurchaseTypeLocalService purchaseTypeLocalService;

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