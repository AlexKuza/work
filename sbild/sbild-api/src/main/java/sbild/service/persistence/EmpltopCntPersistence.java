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

import sbild.exception.NoSuchEmpltopCntException;

import sbild.model.EmpltopCnt;

/**
 * The persistence interface for the empltop cnt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @see EmpltopCntUtil
 * @generated
 */
@ProviderType
public interface EmpltopCntPersistence extends BasePersistence<EmpltopCnt> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmpltopCntUtil} to access the empltop cnt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the empltop cnt in the entity cache if it is enabled.
	 *
	 * @param empltopCnt the empltop cnt
	 */
	public void cacheResult(EmpltopCnt empltopCnt);

	/**
	 * Caches the empltop cnts in the entity cache if it is enabled.
	 *
	 * @param empltopCnts the empltop cnts
	 */
	public void cacheResult(java.util.List<EmpltopCnt> empltopCnts);

	/**
	 * Creates a new empltop cnt with the primary key. Does not add the empltop cnt to the database.
	 *
	 * @param lastname the primary key for the new empltop cnt
	 * @return the new empltop cnt
	 */
	public EmpltopCnt create(String lastname);

	/**
	 * Removes the empltop cnt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lastname the primary key of the empltop cnt
	 * @return the empltop cnt that was removed
	 * @throws NoSuchEmpltopCntException if a empltop cnt with the primary key could not be found
	 */
	public EmpltopCnt remove(String lastname) throws NoSuchEmpltopCntException;

	public EmpltopCnt updateImpl(EmpltopCnt empltopCnt);

	/**
	 * Returns the empltop cnt with the primary key or throws a <code>NoSuchEmpltopCntException</code> if it could not be found.
	 *
	 * @param lastname the primary key of the empltop cnt
	 * @return the empltop cnt
	 * @throws NoSuchEmpltopCntException if a empltop cnt with the primary key could not be found
	 */
	public EmpltopCnt findByPrimaryKey(String lastname)
		throws NoSuchEmpltopCntException;

	/**
	 * Returns the empltop cnt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lastname the primary key of the empltop cnt
	 * @return the empltop cnt, or <code>null</code> if a empltop cnt with the primary key could not be found
	 */
	public EmpltopCnt fetchByPrimaryKey(String lastname);

	/**
	 * Returns all the empltop cnts.
	 *
	 * @return the empltop cnts
	 */
	public java.util.List<EmpltopCnt> findAll();

	/**
	 * Returns a range of all the empltop cnts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpltopCntModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of empltop cnts
	 * @param end the upper bound of the range of empltop cnts (not inclusive)
	 * @return the range of empltop cnts
	 */
	public java.util.List<EmpltopCnt> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the empltop cnts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpltopCntModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of empltop cnts
	 * @param end the upper bound of the range of empltop cnts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of empltop cnts
	 */
	public java.util.List<EmpltopCnt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmpltopCnt>
			orderByComparator);

	/**
	 * Returns an ordered range of all the empltop cnts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpltopCntModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of empltop cnts
	 * @param end the upper bound of the range of empltop cnts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of empltop cnts
	 */
	public java.util.List<EmpltopCnt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmpltopCnt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the empltop cnts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of empltop cnts.
	 *
	 * @return the number of empltop cnts
	 */
	public int countAll();

}