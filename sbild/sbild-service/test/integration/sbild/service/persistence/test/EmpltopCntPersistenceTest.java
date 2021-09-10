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

package sbild.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import sbild.exception.NoSuchEmpltopCntException;

import sbild.model.EmpltopCnt;

import sbild.service.persistence.EmpltopCntPersistence;
import sbild.service.persistence.EmpltopCntUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class EmpltopCntPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED, "sbild.service"));

	@Before
	public void setUp() {
		_persistence = EmpltopCntUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EmpltopCnt> iterator = _empltopCnts.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		EmpltopCnt empltopCnt = _persistence.create(pk);

		Assert.assertNotNull(empltopCnt);

		Assert.assertEquals(empltopCnt.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EmpltopCnt newEmpltopCnt = addEmpltopCnt();

		_persistence.remove(newEmpltopCnt);

		EmpltopCnt existingEmpltopCnt = _persistence.fetchByPrimaryKey(
			newEmpltopCnt.getPrimaryKey());

		Assert.assertNull(existingEmpltopCnt);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEmpltopCnt();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		EmpltopCnt newEmpltopCnt = _persistence.create(pk);

		newEmpltopCnt.setPosition(RandomTestUtil.randomString());

		newEmpltopCnt.setCount(RandomTestUtil.nextInt());

		_empltopCnts.add(_persistence.update(newEmpltopCnt));

		EmpltopCnt existingEmpltopCnt = _persistence.findByPrimaryKey(
			newEmpltopCnt.getPrimaryKey());

		Assert.assertEquals(
			existingEmpltopCnt.getPosition(), newEmpltopCnt.getPosition());
		Assert.assertEquals(
			existingEmpltopCnt.getLastname(), newEmpltopCnt.getLastname());
		Assert.assertEquals(
			existingEmpltopCnt.getCount(), newEmpltopCnt.getCount());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EmpltopCnt newEmpltopCnt = addEmpltopCnt();

		EmpltopCnt existingEmpltopCnt = _persistence.findByPrimaryKey(
			newEmpltopCnt.getPrimaryKey());

		Assert.assertEquals(existingEmpltopCnt, newEmpltopCnt);
	}

	@Test(expected = NoSuchEmpltopCntException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<EmpltopCnt> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"GB_EmpltopCnt", "position", true, "lastname", true, "count", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EmpltopCnt newEmpltopCnt = addEmpltopCnt();

		EmpltopCnt existingEmpltopCnt = _persistence.fetchByPrimaryKey(
			newEmpltopCnt.getPrimaryKey());

		Assert.assertEquals(existingEmpltopCnt, newEmpltopCnt);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		EmpltopCnt missingEmpltopCnt = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEmpltopCnt);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EmpltopCnt newEmpltopCnt1 = addEmpltopCnt();
		EmpltopCnt newEmpltopCnt2 = addEmpltopCnt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmpltopCnt1.getPrimaryKey());
		primaryKeys.add(newEmpltopCnt2.getPrimaryKey());

		Map<Serializable, EmpltopCnt> empltopCnts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, empltopCnts.size());
		Assert.assertEquals(
			newEmpltopCnt1, empltopCnts.get(newEmpltopCnt1.getPrimaryKey()));
		Assert.assertEquals(
			newEmpltopCnt2, empltopCnts.get(newEmpltopCnt2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EmpltopCnt> empltopCnts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(empltopCnts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EmpltopCnt newEmpltopCnt = addEmpltopCnt();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmpltopCnt.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EmpltopCnt> empltopCnts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, empltopCnts.size());
		Assert.assertEquals(
			newEmpltopCnt, empltopCnts.get(newEmpltopCnt.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EmpltopCnt> empltopCnts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(empltopCnts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EmpltopCnt newEmpltopCnt = addEmpltopCnt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmpltopCnt.getPrimaryKey());

		Map<Serializable, EmpltopCnt> empltopCnts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, empltopCnts.size());
		Assert.assertEquals(
			newEmpltopCnt, empltopCnts.get(newEmpltopCnt.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EmpltopCnt newEmpltopCnt = addEmpltopCnt();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmpltopCnt.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"lastname", newEmpltopCnt.getLastname()));

		List<EmpltopCnt> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		EmpltopCnt existingEmpltopCnt = result.get(0);

		Assert.assertEquals(existingEmpltopCnt, newEmpltopCnt);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmpltopCnt.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"lastname", RandomTestUtil.randomString()));

		List<EmpltopCnt> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EmpltopCnt newEmpltopCnt = addEmpltopCnt();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmpltopCnt.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("lastname"));

		Object newLastname = newEmpltopCnt.getLastname();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("lastname", new Object[] {newLastname}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingLastname = result.get(0);

		Assert.assertEquals(existingLastname, newLastname);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmpltopCnt.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("lastname"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"lastname", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected EmpltopCnt addEmpltopCnt() throws Exception {
		String pk = RandomTestUtil.randomString();

		EmpltopCnt empltopCnt = _persistence.create(pk);

		empltopCnt.setPosition(RandomTestUtil.randomString());

		empltopCnt.setCount(RandomTestUtil.nextInt());

		_empltopCnts.add(_persistence.update(empltopCnt));

		return empltopCnt;
	}

	private List<EmpltopCnt> _empltopCnts = new ArrayList<EmpltopCnt>();
	private EmpltopCntPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}