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

package sbild.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import sbild.model.EmpltopSum;

/**
 * The persistence utility for the empltop sum service. This utility wraps <code>sbild.service.persistence.impl.EmpltopSumPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @see EmpltopSumPersistence
 * @generated
 */
public class EmpltopSumUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(EmpltopSum empltopSum) {
		getPersistence().clearCache(empltopSum);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, EmpltopSum> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmpltopSum> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmpltopSum> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmpltopSum> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmpltopSum> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmpltopSum update(EmpltopSum empltopSum) {
		return getPersistence().update(empltopSum);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmpltopSum update(
		EmpltopSum empltopSum, ServiceContext serviceContext) {

		return getPersistence().update(empltopSum, serviceContext);
	}

	/**
	 * Caches the empltop sum in the entity cache if it is enabled.
	 *
	 * @param empltopSum the empltop sum
	 */
	public static void cacheResult(EmpltopSum empltopSum) {
		getPersistence().cacheResult(empltopSum);
	}

	/**
	 * Caches the empltop sums in the entity cache if it is enabled.
	 *
	 * @param empltopSums the empltop sums
	 */
	public static void cacheResult(List<EmpltopSum> empltopSums) {
		getPersistence().cacheResult(empltopSums);
	}

	/**
	 * Creates a new empltop sum with the primary key. Does not add the empltop sum to the database.
	 *
	 * @param lastname the primary key for the new empltop sum
	 * @return the new empltop sum
	 */
	public static EmpltopSum create(String lastname) {
		return getPersistence().create(lastname);
	}

	/**
	 * Removes the empltop sum with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lastname the primary key of the empltop sum
	 * @return the empltop sum that was removed
	 * @throws NoSuchEmpltopSumException if a empltop sum with the primary key could not be found
	 */
	public static EmpltopSum remove(String lastname)
		throws sbild.exception.NoSuchEmpltopSumException {

		return getPersistence().remove(lastname);
	}

	public static EmpltopSum updateImpl(EmpltopSum empltopSum) {
		return getPersistence().updateImpl(empltopSum);
	}

	/**
	 * Returns the empltop sum with the primary key or throws a <code>NoSuchEmpltopSumException</code> if it could not be found.
	 *
	 * @param lastname the primary key of the empltop sum
	 * @return the empltop sum
	 * @throws NoSuchEmpltopSumException if a empltop sum with the primary key could not be found
	 */
	public static EmpltopSum findByPrimaryKey(String lastname)
		throws sbild.exception.NoSuchEmpltopSumException {

		return getPersistence().findByPrimaryKey(lastname);
	}

	/**
	 * Returns the empltop sum with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lastname the primary key of the empltop sum
	 * @return the empltop sum, or <code>null</code> if a empltop sum with the primary key could not be found
	 */
	public static EmpltopSum fetchByPrimaryKey(String lastname) {
		return getPersistence().fetchByPrimaryKey(lastname);
	}

	/**
	 * Returns all the empltop sums.
	 *
	 * @return the empltop sums
	 */
	public static List<EmpltopSum> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the empltop sums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpltopSumModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of empltop sums
	 * @param end the upper bound of the range of empltop sums (not inclusive)
	 * @return the range of empltop sums
	 */
	public static List<EmpltopSum> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the empltop sums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpltopSumModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of empltop sums
	 * @param end the upper bound of the range of empltop sums (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of empltop sums
	 */
	public static List<EmpltopSum> findAll(
		int start, int end, OrderByComparator<EmpltopSum> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the empltop sums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpltopSumModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of empltop sums
	 * @param end the upper bound of the range of empltop sums (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of empltop sums
	 */
	public static List<EmpltopSum> findAll(
		int start, int end, OrderByComparator<EmpltopSum> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the empltop sums from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of empltop sums.
	 *
	 * @return the number of empltop sums
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmpltopSumPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmpltopSumPersistence, EmpltopSumPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmpltopSumPersistence.class);

		ServiceTracker<EmpltopSumPersistence, EmpltopSumPersistence>
			serviceTracker =
				new ServiceTracker
					<EmpltopSumPersistence, EmpltopSumPersistence>(
						bundle.getBundleContext(), EmpltopSumPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}