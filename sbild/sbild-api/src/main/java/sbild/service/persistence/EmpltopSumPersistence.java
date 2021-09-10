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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import sbild.exception.NoSuchEmpltopSumException;

import sbild.model.EmpltopSum;

/**
 * The persistence interface for the empltop sum service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @see EmpltopSumUtil
 * @generated
 */
@ProviderType
public interface EmpltopSumPersistence extends BasePersistence<EmpltopSum> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmpltopSumUtil} to access the empltop sum persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the empltop sum in the entity cache if it is enabled.
	 *
	 * @param empltopSum the empltop sum
	 */
	public void cacheResult(EmpltopSum empltopSum);

	/**
	 * Caches the empltop sums in the entity cache if it is enabled.
	 *
	 * @param empltopSums the empltop sums
	 */
	public void cacheResult(java.util.List<EmpltopSum> empltopSums);

	/**
	 * Creates a new empltop sum with the primary key. Does not add the empltop sum to the database.
	 *
	 * @param lastname the primary key for the new empltop sum
	 * @return the new empltop sum
	 */
	public EmpltopSum create(String lastname);

	/**
	 * Removes the empltop sum with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lastname the primary key of the empltop sum
	 * @return the empltop sum that was removed
	 * @throws NoSuchEmpltopSumException if a empltop sum with the primary key could not be found
	 */
	public EmpltopSum remove(String lastname) throws NoSuchEmpltopSumException;

	public EmpltopSum updateImpl(EmpltopSum empltopSum);

	/**
	 * Returns the empltop sum with the primary key or throws a <code>NoSuchEmpltopSumException</code> if it could not be found.
	 *
	 * @param lastname the primary key of the empltop sum
	 * @return the empltop sum
	 * @throws NoSuchEmpltopSumException if a empltop sum with the primary key could not be found
	 */
	public EmpltopSum findByPrimaryKey(String lastname)
		throws NoSuchEmpltopSumException;

	/**
	 * Returns the empltop sum with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lastname the primary key of the empltop sum
	 * @return the empltop sum, or <code>null</code> if a empltop sum with the primary key could not be found
	 */
	public EmpltopSum fetchByPrimaryKey(String lastname);

	/**
	 * Returns all the empltop sums.
	 *
	 * @return the empltop sums
	 */
	public java.util.List<EmpltopSum> findAll();

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
	public java.util.List<EmpltopSum> findAll(int start, int end);

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
	public java.util.List<EmpltopSum> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmpltopSum>
			orderByComparator);

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
	public java.util.List<EmpltopSum> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmpltopSum>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the empltop sums from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of empltop sums.
	 *
	 * @return the number of empltop sums
	 */
	public int countAll();

}