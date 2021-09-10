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
 * Provides a wrapper for {@link EmpltopCntLocalService}.
 *
 * @author liferay
 * @see EmpltopCntLocalService
 * @generated
 */
public class EmpltopCntLocalServiceWrapper
	implements EmpltopCntLocalService, ServiceWrapper<EmpltopCntLocalService> {

	public EmpltopCntLocalServiceWrapper(
		EmpltopCntLocalService empltopCntLocalService) {

		_empltopCntLocalService = empltopCntLocalService;
	}

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
	@Override
	public sbild.model.EmpltopCnt addEmpltopCnt(
		sbild.model.EmpltopCnt empltopCnt) {

		return _empltopCntLocalService.addEmpltopCnt(empltopCnt);
	}

	@Override
	public sbild.model.EmpltopCnt addEmpltopCnt(
			String pos, String lastname, int count)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empltopCntLocalService.addEmpltopCnt(pos, lastname, count);
	}

	/**
	 * Creates a new empltop cnt with the primary key. Does not add the empltop cnt to the database.
	 *
	 * @param lastname the primary key for the new empltop cnt
	 * @return the new empltop cnt
	 */
	@Override
	public sbild.model.EmpltopCnt createEmpltopCnt(String lastname) {
		return _empltopCntLocalService.createEmpltopCnt(lastname);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empltopCntLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public sbild.model.EmpltopCnt deleteEmpltopCnt(
		sbild.model.EmpltopCnt empltopCnt) {

		return _empltopCntLocalService.deleteEmpltopCnt(empltopCnt);
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
	@Override
	public sbild.model.EmpltopCnt deleteEmpltopCnt(String lastname)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empltopCntLocalService.deleteEmpltopCnt(lastname);
	}

	@Override
	public void deleteEmplTopCnts() {
		_empltopCntLocalService.deleteEmplTopCnts();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empltopCntLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _empltopCntLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _empltopCntLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empltopCntLocalService.dynamicQuery();
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

		return _empltopCntLocalService.dynamicQuery(dynamicQuery);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _empltopCntLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _empltopCntLocalService.dynamicQuery(
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

		return _empltopCntLocalService.dynamicQueryCount(dynamicQuery);
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

		return _empltopCntLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public sbild.model.EmpltopCnt fetchEmpltopCnt(String lastname) {
		return _empltopCntLocalService.fetchEmpltopCnt(lastname);
	}

	@Override
	public java.util.List<sbild.model.EmpltopCnt> findTopByCnt(
			int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _empltopCntLocalService.findTopByCnt(begin, end);
	}

	/**
	 * Returns the empltop cnt with the primary key.
	 *
	 * @param lastname the primary key of the empltop cnt
	 * @return the empltop cnt
	 * @throws PortalException if a empltop cnt with the primary key could not be found
	 */
	@Override
	public sbild.model.EmpltopCnt getEmpltopCnt(String lastname)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empltopCntLocalService.getEmpltopCnt(lastname);
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
	public java.util.List<sbild.model.EmpltopCnt> getEmpltopCnts(
		int start, int end) {

		return _empltopCntLocalService.getEmpltopCnts(start, end);
	}

	/**
	 * Returns the number of empltop cnts.
	 *
	 * @return the number of empltop cnts
	 */
	@Override
	public int getEmpltopCntsCount() {
		return _empltopCntLocalService.getEmpltopCntsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _empltopCntLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _empltopCntLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public sbild.model.EmpltopCnt updateEmpltopCnt(
		sbild.model.EmpltopCnt empltopCnt) {

		return _empltopCntLocalService.updateEmpltopCnt(empltopCnt);
	}

	@Override
	public EmpltopCntLocalService getWrappedService() {
		return _empltopCntLocalService;
	}

	@Override
	public void setWrappedService(
		EmpltopCntLocalService empltopCntLocalService) {

		_empltopCntLocalService = empltopCntLocalService;
	}

	private EmpltopCntLocalService _empltopCntLocalService;

}