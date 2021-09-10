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

import sbild.exception.NoSuchEmpltopSumException;

import sbild.model.EmpltopSum;

import sbild.service.persistence.EmpltopSumPersistence;
import sbild.service.persistence.EmpltopSumUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class EmpltopSumPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED, "sbild.service"));

	@Before
	public void setUp() {
		_persistence = EmpltopSumUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EmpltopSum> iterator = _empltopSums.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		String pk = RandomTestUtil.randomString();

		EmpltopSum empltopSum = _persistence.create(pk);

		Assert.assertNotNull(empltopSum);

		Assert.assertEquals(empltopSum.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EmpltopSum newEmpltopSum = addEmpltopSum();

		_persistence.remove(newEmpltopSum);

		EmpltopSum existingEmpltopSum = _persistence.fetchByPrimaryKey(
			newEmpltopSum.getPrimaryKey());

		Assert.assertNull(existingEmpltopSum);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEmpltopSum();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		String pk = RandomTestUtil.randomString();

		EmpltopSum newEmpltopSum = _persistence.create(pk);

		newEmpltopSum.setPosition(RandomTestUtil.randomString());

		newEmpltopSum.setSum(RandomTestUtil.nextLong());

		_empltopSums.add(_persistence.update(newEmpltopSum));

		EmpltopSum existingEmpltopSum = _persistence.findByPrimaryKey(
			newEmpltopSum.getPrimaryKey());

		Assert.assertEquals(
			existingEmpltopSum.getPosition(), newEmpltopSum.getPosition());
		Assert.assertEquals(
			existingEmpltopSum.getLastname(), newEmpltopSum.getLastname());
		Assert.assertEquals(
			existingEmpltopSum.getSum(), newEmpltopSum.getSum());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EmpltopSum newEmpltopSum = addEmpltopSum();

		EmpltopSum existingEmpltopSum = _persistence.findByPrimaryKey(
			newEmpltopSum.getPrimaryKey());

		Assert.assertEquals(existingEmpltopSum, newEmpltopSum);
	}

	@Test(expected = NoSuchEmpltopSumException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<EmpltopSum> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"GB_EmpltopSum", "position", true, "lastname", true, "sum", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EmpltopSum newEmpltopSum = addEmpltopSum();

		EmpltopSum existingEmpltopSum = _persistence.fetchByPrimaryKey(
			newEmpltopSum.getPrimaryKey());

		Assert.assertEquals(existingEmpltopSum, newEmpltopSum);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		String pk = RandomTestUtil.randomString();

		EmpltopSum missingEmpltopSum = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEmpltopSum);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EmpltopSum newEmpltopSum1 = addEmpltopSum();
		EmpltopSum newEmpltopSum2 = addEmpltopSum();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmpltopSum1.getPrimaryKey());
		primaryKeys.add(newEmpltopSum2.getPrimaryKey());

		Map<Serializable, EmpltopSum> empltopSums =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, empltopSums.size());
		Assert.assertEquals(
			newEmpltopSum1, empltopSums.get(newEmpltopSum1.getPrimaryKey()));
		Assert.assertEquals(
			newEmpltopSum2, empltopSums.get(newEmpltopSum2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		String pk1 = RandomTestUtil.randomString();

		String pk2 = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EmpltopSum> empltopSums =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(empltopSums.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EmpltopSum newEmpltopSum = addEmpltopSum();

		String pk = RandomTestUtil.randomString();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmpltopSum.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EmpltopSum> empltopSums =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, empltopSums.size());
		Assert.assertEquals(
			newEmpltopSum, empltopSums.get(newEmpltopSum.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EmpltopSum> empltopSums =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(empltopSums.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EmpltopSum newEmpltopSum = addEmpltopSum();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmpltopSum.getPrimaryKey());

		Map<Serializable, EmpltopSum> empltopSums =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, empltopSums.size());
		Assert.assertEquals(
			newEmpltopSum, empltopSums.get(newEmpltopSum.getPrimaryKey()));
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EmpltopSum newEmpltopSum = addEmpltopSum();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmpltopSum.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"lastname", newEmpltopSum.getLastname()));

		List<EmpltopSum> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		EmpltopSum existingEmpltopSum = result.get(0);

		Assert.assertEquals(existingEmpltopSum, newEmpltopSum);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmpltopSum.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"lastname", RandomTestUtil.randomString()));

		List<EmpltopSum> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EmpltopSum newEmpltopSum = addEmpltopSum();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmpltopSum.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("lastname"));

		Object newLastname = newEmpltopSum.getLastname();

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
			EmpltopSum.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("lastname"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"lastname", new Object[] {RandomTestUtil.randomString()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected EmpltopSum addEmpltopSum() throws Exception {
		String pk = RandomTestUtil.randomString();

		EmpltopSum empltopSum = _persistence.create(pk);

		empltopSum.setPosition(RandomTestUtil.randomString());

		empltopSum.setSum(RandomTestUtil.nextLong());

		_empltopSums.add(_persistence.update(empltopSum));

		return empltopSum;
	}

	private List<EmpltopSum> _empltopSums = new ArrayList<EmpltopSum>();
	private EmpltopSumPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}