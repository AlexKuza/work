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

package sbild.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import sbild.exception.NoSuchElectronicsException;

import sbild.model.Electronics;
import sbild.model.ElectronicsTable;
import sbild.model.impl.ElectronicsImpl;
import sbild.model.impl.ElectronicsModelImpl;

import sbild.service.persistence.ElectronicsPersistence;
import sbild.service.persistence.impl.constants.GBPersistenceConstants;

/**
 * The persistence implementation for the electronics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @generated
 */
@Component(service = {ElectronicsPersistence.class, BasePersistence.class})
public class ElectronicsPersistenceImpl
	extends BasePersistenceImpl<Electronics> implements ElectronicsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ElectronicsUtil</code> to access the electronics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ElectronicsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ElectronicsPersistenceImpl() {
		setModelClass(Electronics.class);

		setModelImplClass(ElectronicsImpl.class);
		setModelPKClass(long.class);

		setTable(ElectronicsTable.INSTANCE);
	}

	/**
	 * Caches the electronics in the entity cache if it is enabled.
	 *
	 * @param electronics the electronics
	 */
	@Override
	public void cacheResult(Electronics electronics) {
		entityCache.putResult(
			ElectronicsImpl.class, electronics.getPrimaryKey(), electronics);
	}

	/**
	 * Caches the electronicses in the entity cache if it is enabled.
	 *
	 * @param electronicses the electronicses
	 */
	@Override
	public void cacheResult(List<Electronics> electronicses) {
		for (Electronics electronics : electronicses) {
			if (entityCache.getResult(
					ElectronicsImpl.class, electronics.getPrimaryKey()) ==
						null) {

				cacheResult(electronics);
			}
		}
	}

	/**
	 * Clears the cache for all electronicses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ElectronicsImpl.class);

		finderCache.clearCache(ElectronicsImpl.class);
	}

	/**
	 * Clears the cache for the electronics.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Electronics electronics) {
		entityCache.removeResult(ElectronicsImpl.class, electronics);
	}

	@Override
	public void clearCache(List<Electronics> electronicses) {
		for (Electronics electronics : electronicses) {
			entityCache.removeResult(ElectronicsImpl.class, electronics);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ElectronicsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ElectronicsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new electronics with the primary key. Does not add the electronics to the database.
	 *
	 * @param electrId the primary key for the new electronics
	 * @return the new electronics
	 */
	@Override
	public Electronics create(long electrId) {
		Electronics electronics = new ElectronicsImpl();

		electronics.setNew(true);
		electronics.setPrimaryKey(electrId);

		return electronics;
	}

	/**
	 * Removes the electronics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param electrId the primary key of the electronics
	 * @return the electronics that was removed
	 * @throws NoSuchElectronicsException if a electronics with the primary key could not be found
	 */
	@Override
	public Electronics remove(long electrId) throws NoSuchElectronicsException {
		return remove((Serializable)electrId);
	}

	/**
	 * Removes the electronics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the electronics
	 * @return the electronics that was removed
	 * @throws NoSuchElectronicsException if a electronics with the primary key could not be found
	 */
	@Override
	public Electronics remove(Serializable primaryKey)
		throws NoSuchElectronicsException {

		Session session = null;

		try {
			session = openSession();

			Electronics electronics = (Electronics)session.get(
				ElectronicsImpl.class, primaryKey);

			if (electronics == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchElectronicsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(electronics);
		}
		catch (NoSuchElectronicsException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Electronics removeImpl(Electronics electronics) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(electronics)) {
				electronics = (Electronics)session.get(
					ElectronicsImpl.class, electronics.getPrimaryKeyObj());
			}

			if (electronics != null) {
				session.delete(electronics);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (electronics != null) {
			clearCache(electronics);
		}

		return electronics;
	}

	@Override
	public Electronics updateImpl(Electronics electronics) {
		boolean isNew = electronics.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(electronics);
			}
			else {
				electronics = (Electronics)session.merge(electronics);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ElectronicsImpl.class, electronics, false, true);

		if (isNew) {
			electronics.setNew(false);
		}

		electronics.resetOriginalValues();

		return electronics;
	}

	/**
	 * Returns the electronics with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the electronics
	 * @return the electronics
	 * @throws NoSuchElectronicsException if a electronics with the primary key could not be found
	 */
	@Override
	public Electronics findByPrimaryKey(Serializable primaryKey)
		throws NoSuchElectronicsException {

		Electronics electronics = fetchByPrimaryKey(primaryKey);

		if (electronics == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchElectronicsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return electronics;
	}

	/**
	 * Returns the electronics with the primary key or throws a <code>NoSuchElectronicsException</code> if it could not be found.
	 *
	 * @param electrId the primary key of the electronics
	 * @return the electronics
	 * @throws NoSuchElectronicsException if a electronics with the primary key could not be found
	 */
	@Override
	public Electronics findByPrimaryKey(long electrId)
		throws NoSuchElectronicsException {

		return findByPrimaryKey((Serializable)electrId);
	}

	/**
	 * Returns the electronics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param electrId the primary key of the electronics
	 * @return the electronics, or <code>null</code> if a electronics with the primary key could not be found
	 */
	@Override
	public Electronics fetchByPrimaryKey(long electrId) {
		return fetchByPrimaryKey((Serializable)electrId);
	}

	/**
	 * Returns all the electronicses.
	 *
	 * @return the electronicses
	 */
	@Override
	public List<Electronics> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the electronicses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @return the range of electronicses
	 */
	@Override
	public List<Electronics> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the electronicses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of electronicses
	 */
	@Override
	public List<Electronics> findAll(
		int start, int end, OrderByComparator<Electronics> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the electronicses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of electronicses
	 */
	@Override
	public List<Electronics> findAll(
		int start, int end, OrderByComparator<Electronics> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Electronics> list = null;

		if (useFinderCache) {
			list = (List<Electronics>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ELECTRONICS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ELECTRONICS;

				sql = sql.concat(ElectronicsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Electronics>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the electronicses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Electronics electronics : findAll()) {
			remove(electronics);
		}
	}

	/**
	 * Returns the number of electronicses.
	 *
	 * @return the number of electronicses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ELECTRONICS);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "electrId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ELECTRONICS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ElectronicsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the electronics persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ElectronicsModelArgumentsResolver(),
			new HashMapDictionary<>());

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ElectronicsImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();
	}

	@Override
	@Reference(
		target = GBPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = GBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = GBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ELECTRONICS =
		"SELECT electronics FROM Electronics electronics";

	private static final String _SQL_COUNT_ELECTRONICS =
		"SELECT COUNT(electronics) FROM Electronics electronics";

	private static final String _ORDER_BY_ENTITY_ALIAS = "electronics.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Electronics exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ElectronicsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class ElectronicsModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			ElectronicsModelImpl electronicsModelImpl =
				(ElectronicsModelImpl)baseModel;

			long columnBitmask = electronicsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(electronicsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						electronicsModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(electronicsModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return ElectronicsImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return ElectronicsTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			ElectronicsModelImpl electronicsModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = electronicsModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = electronicsModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}