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

package com.liferay.amf.newsletter.service.persistence.impl;

import com.liferay.amf.newsletter.exception.NoSuchIssueException;
import com.liferay.amf.newsletter.model.Issue;
import com.liferay.amf.newsletter.model.impl.IssueImpl;
import com.liferay.amf.newsletter.model.impl.IssueModelImpl;
import com.liferay.amf.newsletter.service.persistence.IssuePersistence;
import com.liferay.amf.newsletter.service.persistence.impl.constants.NewsLetterPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the issue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = IssuePersistence.class)
public class IssuePersistenceImpl
	extends BasePersistenceImpl<Issue> implements IssuePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>IssueUtil</code> to access the issue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		IssueImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByIssueId;
	private FinderPath _finderPathWithoutPaginationFindByIssueId;
	private FinderPath _finderPathCountByIssueId;

	/**
	 * Returns all the issues where issueId = &#63;.
	 *
	 * @param issueId the issue ID
	 * @return the matching issues
	 */
	@Override
	public List<Issue> findByIssueId(long issueId) {
		return findByIssueId(
			issueId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the issues where issueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param issueId the issue ID
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @return the range of matching issues
	 */
	@Override
	public List<Issue> findByIssueId(long issueId, int start, int end) {
		return findByIssueId(issueId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the issues where issueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param issueId the issue ID
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching issues
	 */
	@Override
	public List<Issue> findByIssueId(
		long issueId, int start, int end,
		OrderByComparator<Issue> orderByComparator) {

		return findByIssueId(issueId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the issues where issueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param issueId the issue ID
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching issues
	 */
	@Override
	public List<Issue> findByIssueId(
		long issueId, int start, int end,
		OrderByComparator<Issue> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIssueId;
				finderArgs = new Object[] {issueId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIssueId;
			finderArgs = new Object[] {issueId, start, end, orderByComparator};
		}

		List<Issue> list = null;

		if (useFinderCache) {
			list = (List<Issue>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Issue issue : list) {
					if (issueId != issue.getIssueId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ISSUE_WHERE);

			sb.append(_FINDER_COLUMN_ISSUEID_ISSUEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IssueModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(issueId);

				list = (List<Issue>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first issue in the ordered set where issueId = &#63;.
	 *
	 * @param issueId the issue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issue
	 * @throws NoSuchIssueException if a matching issue could not be found
	 */
	@Override
	public Issue findByIssueId_First(
			long issueId, OrderByComparator<Issue> orderByComparator)
		throws NoSuchIssueException {

		Issue issue = fetchByIssueId_First(issueId, orderByComparator);

		if (issue != null) {
			return issue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("issueId=");
		sb.append(issueId);

		sb.append("}");

		throw new NoSuchIssueException(sb.toString());
	}

	/**
	 * Returns the first issue in the ordered set where issueId = &#63;.
	 *
	 * @param issueId the issue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issue, or <code>null</code> if a matching issue could not be found
	 */
	@Override
	public Issue fetchByIssueId_First(
		long issueId, OrderByComparator<Issue> orderByComparator) {

		List<Issue> list = findByIssueId(issueId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last issue in the ordered set where issueId = &#63;.
	 *
	 * @param issueId the issue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issue
	 * @throws NoSuchIssueException if a matching issue could not be found
	 */
	@Override
	public Issue findByIssueId_Last(
			long issueId, OrderByComparator<Issue> orderByComparator)
		throws NoSuchIssueException {

		Issue issue = fetchByIssueId_Last(issueId, orderByComparator);

		if (issue != null) {
			return issue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("issueId=");
		sb.append(issueId);

		sb.append("}");

		throw new NoSuchIssueException(sb.toString());
	}

	/**
	 * Returns the last issue in the ordered set where issueId = &#63;.
	 *
	 * @param issueId the issue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issue, or <code>null</code> if a matching issue could not be found
	 */
	@Override
	public Issue fetchByIssueId_Last(
		long issueId, OrderByComparator<Issue> orderByComparator) {

		int count = countByIssueId(issueId);

		if (count == 0) {
			return null;
		}

		List<Issue> list = findByIssueId(
			issueId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the issues where issueId = &#63; from the database.
	 *
	 * @param issueId the issue ID
	 */
	@Override
	public void removeByIssueId(long issueId) {
		for (Issue issue :
				findByIssueId(
					issueId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(issue);
		}
	}

	/**
	 * Returns the number of issues where issueId = &#63;.
	 *
	 * @param issueId the issue ID
	 * @return the number of matching issues
	 */
	@Override
	public int countByIssueId(long issueId) {
		FinderPath finderPath = _finderPathCountByIssueId;

		Object[] finderArgs = new Object[] {issueId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ISSUE_WHERE);

			sb.append(_FINDER_COLUMN_ISSUEID_ISSUEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(issueId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ISSUEID_ISSUEID_2 =
		"issue.issueId = ?";

	public IssuePersistenceImpl() {
		setModelClass(Issue.class);

		setModelImplClass(IssueImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the issue in the entity cache if it is enabled.
	 *
	 * @param issue the issue
	 */
	@Override
	public void cacheResult(Issue issue) {
		entityCache.putResult(
			entityCacheEnabled, IssueImpl.class, issue.getPrimaryKey(), issue);

		issue.resetOriginalValues();
	}

	/**
	 * Caches the issues in the entity cache if it is enabled.
	 *
	 * @param issues the issues
	 */
	@Override
	public void cacheResult(List<Issue> issues) {
		for (Issue issue : issues) {
			if (entityCache.getResult(
					entityCacheEnabled, IssueImpl.class,
					issue.getPrimaryKey()) == null) {

				cacheResult(issue);
			}
			else {
				issue.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all issues.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IssueImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the issue.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Issue issue) {
		entityCache.removeResult(
			entityCacheEnabled, IssueImpl.class, issue.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Issue> issues) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Issue issue : issues) {
			entityCache.removeResult(
				entityCacheEnabled, IssueImpl.class, issue.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, IssueImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new issue with the primary key. Does not add the issue to the database.
	 *
	 * @param issueId the primary key for the new issue
	 * @return the new issue
	 */
	@Override
	public Issue create(long issueId) {
		Issue issue = new IssueImpl();

		issue.setNew(true);
		issue.setPrimaryKey(issueId);

		return issue;
	}

	/**
	 * Removes the issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param issueId the primary key of the issue
	 * @return the issue that was removed
	 * @throws NoSuchIssueException if a issue with the primary key could not be found
	 */
	@Override
	public Issue remove(long issueId) throws NoSuchIssueException {
		return remove((Serializable)issueId);
	}

	/**
	 * Removes the issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the issue
	 * @return the issue that was removed
	 * @throws NoSuchIssueException if a issue with the primary key could not be found
	 */
	@Override
	public Issue remove(Serializable primaryKey) throws NoSuchIssueException {
		Session session = null;

		try {
			session = openSession();

			Issue issue = (Issue)session.get(IssueImpl.class, primaryKey);

			if (issue == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIssueException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(issue);
		}
		catch (NoSuchIssueException noSuchEntityException) {
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
	protected Issue removeImpl(Issue issue) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(issue)) {
				issue = (Issue)session.get(
					IssueImpl.class, issue.getPrimaryKeyObj());
			}

			if (issue != null) {
				session.delete(issue);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (issue != null) {
			clearCache(issue);
		}

		return issue;
	}

	@Override
	public Issue updateImpl(Issue issue) {
		boolean isNew = issue.isNew();

		if (!(issue instanceof IssueModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(issue.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(issue);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in issue proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Issue implementation " +
					issue.getClass());
		}

		IssueModelImpl issueModelImpl = (IssueModelImpl)issue;

		Session session = null;

		try {
			session = openSession();

			if (issue.isNew()) {
				session.save(issue);

				issue.setNew(false);
			}
			else {
				issue = (Issue)session.merge(issue);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {issueModelImpl.getIssueId()};

			finderCache.removeResult(_finderPathCountByIssueId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByIssueId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((issueModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByIssueId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					issueModelImpl.getOriginalIssueId()
				};

				finderCache.removeResult(_finderPathCountByIssueId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByIssueId, args);

				args = new Object[] {issueModelImpl.getIssueId()};

				finderCache.removeResult(_finderPathCountByIssueId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByIssueId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, IssueImpl.class, issue.getPrimaryKey(), issue,
			false);

		issue.resetOriginalValues();

		return issue;
	}

	/**
	 * Returns the issue with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the issue
	 * @return the issue
	 * @throws NoSuchIssueException if a issue with the primary key could not be found
	 */
	@Override
	public Issue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIssueException {

		Issue issue = fetchByPrimaryKey(primaryKey);

		if (issue == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIssueException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return issue;
	}

	/**
	 * Returns the issue with the primary key or throws a <code>NoSuchIssueException</code> if it could not be found.
	 *
	 * @param issueId the primary key of the issue
	 * @return the issue
	 * @throws NoSuchIssueException if a issue with the primary key could not be found
	 */
	@Override
	public Issue findByPrimaryKey(long issueId) throws NoSuchIssueException {
		return findByPrimaryKey((Serializable)issueId);
	}

	/**
	 * Returns the issue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param issueId the primary key of the issue
	 * @return the issue, or <code>null</code> if a issue with the primary key could not be found
	 */
	@Override
	public Issue fetchByPrimaryKey(long issueId) {
		return fetchByPrimaryKey((Serializable)issueId);
	}

	/**
	 * Returns all the issues.
	 *
	 * @return the issues
	 */
	@Override
	public List<Issue> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @return the range of issues
	 */
	@Override
	public List<Issue> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of issues
	 */
	@Override
	public List<Issue> findAll(
		int start, int end, OrderByComparator<Issue> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of issues
	 */
	@Override
	public List<Issue> findAll(
		int start, int end, OrderByComparator<Issue> orderByComparator,
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

		List<Issue> list = null;

		if (useFinderCache) {
			list = (List<Issue>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ISSUE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ISSUE;

				sql = sql.concat(IssueModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Issue>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the issues from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Issue issue : findAll()) {
			remove(issue);
		}
	}

	/**
	 * Returns the number of issues.
	 *
	 * @return the number of issues
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ISSUE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

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
		return "issueId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ISSUE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return IssueModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the issue persistence.
	 */
	@Activate
	public void activate() {
		IssueModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		IssueModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IssueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IssueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByIssueId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IssueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIssueId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByIssueId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IssueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIssueId",
			new String[] {Long.class.getName()},
			IssueModelImpl.ISSUEID_COLUMN_BITMASK);

		_finderPathCountByIssueId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIssueId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(IssueImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = NewsLetterPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.amf.newsletter.model.Issue"),
			true);
	}

	@Override
	@Reference(
		target = NewsLetterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = NewsLetterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ISSUE =
		"SELECT issue FROM Issue issue";

	private static final String _SQL_SELECT_ISSUE_WHERE =
		"SELECT issue FROM Issue issue WHERE ";

	private static final String _SQL_COUNT_ISSUE =
		"SELECT COUNT(issue) FROM Issue issue";

	private static final String _SQL_COUNT_ISSUE_WHERE =
		"SELECT COUNT(issue) FROM Issue issue WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "issue.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Issue exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Issue exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		IssuePersistenceImpl.class);

	static {
		try {
			Class.forName(NewsLetterPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}