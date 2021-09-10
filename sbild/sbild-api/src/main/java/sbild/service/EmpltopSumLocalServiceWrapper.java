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

package sbild.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmpltopSumLocalService}.
 *
 * @author liferay
 * @see EmpltopSumLocalService
 * @generated
 */
public class EmpltopSumLocalServiceWrapper
	implements EmpltopSumLocalService, ServiceWrapper<EmpltopSumLocalService> {

	public EmpltopSumLocalServiceWrapper(
		EmpltopSumLocalService empltopSumLocalService) {

		_empltopSumLocalService = empltopSumLocalService;
	}

	/**
	 * Adds the empltop sum to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmpltopSumLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param empltopSum the empltop sum
	 * @return the empltop sum that was added
	 */
	@Override
	public sbild.model.EmpltopSum addEmpltopSum(
		sbild.model.EmpltopSum empltopSum) {

		return _empltopSumLocalService.addEmpltopSum(empltopSum);
	}

	@Override
	public sbild.model.EmpltopSum addEmpltopSum(
			String pos, String lastname, long sum)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empltopSumLocalService.addEmpltopSum(pos, lastname, sum);
	}

	/**
	 * Creates a new empltop sum with the primary key. Does not add the empltop sum to the database.
	 *
	 * @param lastname the primary key for the new empltop sum
	 * @return the new empltop sum
	 */
	@Override
	public sbild.model.EmpltopSum createEmpltopSum(String lastname) {
		return _empltopSumLocalService.createEmpltopSum(lastname);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empltopSumLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the empltop sum from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmpltopSumLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param empltopSum the empltop sum
	 * @return the empltop sum that was removed
	 */
	@Override
	public sbild.model.EmpltopSum deleteEmpltopSum(
		sbild.model.EmpltopSum empltopSum) {

		return _empltopSumLocalService.deleteEmpltopSum(empltopSum);
	}

	/**
	 * Deletes the empltop sum with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmpltopSumLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lastname the primary key of the empltop sum
	 * @return the empltop sum that was removed
	 * @throws PortalException if a empltop sum with the primary key could not be found
	 */
	@Override
	public sbild.model.EmpltopSum deleteEmpltopSum(String lastname)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empltopSumLocalService.deleteEmpltopSum(lastname);
	}

	@Override
	public void deleteEmplTopSums() {
		_empltopSumLocalService.deleteEmplTopSums();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empltopSumLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _empltopSumLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _empltopSumLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empltopSumLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _empltopSumLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sbild.model.impl.EmpltopSumModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _empltopSumLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sbild.model.impl.EmpltopSumModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _empltopSumLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _empltopSumLocalService.dynamicQueryCount(dynamicQuery);
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _empltopSumLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public sbild.model.EmpltopSum fetchEmpltopSum(String lastname) {
		return _empltopSumLocalService.fetchEmpltopSum(lastname);
	}

	@Override
	public java.util.List<sbild.model.EmpltopSum> findTopBySum(
			int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _empltopSumLocalService.findTopBySum(begin, end);
	}

	/**
	 * Returns the empltop sum with the primary key.
	 *
	 * @param lastname the primary key of the empltop sum
	 * @return the empltop sum
	 * @throws PortalException if a empltop sum with the primary key could not be found
	 */
	@Override
	public sbild.model.EmpltopSum getEmpltopSum(String lastname)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empltopSumLocalService.getEmpltopSum(lastname);
	}

	/**
	 * Returns a range of all the empltop sums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sbild.model.impl.EmpltopSumModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of empltop sums
	 * @param end the upper bound of the range of empltop sums (not inclusive)
	 * @return the range of empltop sums
	 */
	@Override
	public java.util.List<sbild.model.EmpltopSum> getEmpltopSums(
		int start, int end) {

		return _empltopSumLocalService.getEmpltopSums(start, end);
	}

	/**
	 * Returns the number of empltop sums.
	 *
	 * @return the number of empltop sums
	 */
	@Override
	public int getEmpltopSumsCount() {
		return _empltopSumLocalService.getEmpltopSumsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _empltopSumLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empltopSumLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the empltop sum in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmpltopSumLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param empltopSum the empltop sum
	 * @return the empltop sum that was updated
	 */
	@Override
	public sbild.model.EmpltopSum updateEmpltopSum(
		sbild.model.EmpltopSum empltopSum) {

		return _empltopSumLocalService.updateEmpltopSum(empltopSum);
	}

	@Override
	public EmpltopSumLocalService getWrappedService() {
		return _empltopSumLocalService;
	}

	@Override
	public void setWrappedService(
		EmpltopSumLocalService empltopSumLocalService) {

		_empltopSumLocalService = empltopSumLocalService;
	}

	private EmpltopSumLocalService _empltopSumLocalService;

}