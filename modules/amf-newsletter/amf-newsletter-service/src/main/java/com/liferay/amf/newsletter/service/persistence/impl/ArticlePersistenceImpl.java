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

import com.liferay.amf.newsletter.exception.NoSuchArticleException;
import com.liferay.amf.newsletter.model.Article;
import com.liferay.amf.newsletter.model.impl.ArticleImpl;
import com.liferay.amf.newsletter.model.impl.ArticleModelImpl;
import com.liferay.amf.newsletter.service.persistence.ArticlePersistence;
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
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ArticlePersistence.class)
public class ArticlePersistenceImpl
	extends BasePersistenceImpl<Article> implements ArticlePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ArticleUtil</code> to access the article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ArticleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByArticleId;
	private FinderPath _finderPathWithoutPaginationFindByArticleId;
	private FinderPath _finderPathCountByArticleId;

	/**
	 * Returns all the articles where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching articles
	 */
	@Override
	public List<Article> findByArticleId(long articleId) {
		return findByArticleId(
			articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the articles where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of matching articles
	 */
	@Override
	public List<Article> findByArticleId(long articleId, int start, int end) {
		return findByArticleId(articleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the articles where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articles
	 */
	@Override
	public List<Article> findByArticleId(
		long articleId, int start, int end,
		OrderByComparator<Article> orderByComparator) {

		return findByArticleId(articleId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the articles where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching articles
	 */
	@Override
	public List<Article> findByArticleId(
		long articleId, int start, int end,
		OrderByComparator<Article> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByArticleId;
				finderArgs = new Object[] {articleId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByArticleId;
			finderArgs = new Object[] {
				articleId, start, end, orderByComparator
			};
		}

		List<Article> list = null;

		if (useFinderCache) {
			list = (List<Article>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Article article : list) {
					if (articleId != article.getArticleId()) {
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

			sb.append(_SQL_SELECT_ARTICLE_WHERE);

			sb.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(articleId);

				list = (List<Article>)QueryUtil.list(
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
	 * Returns the first article in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByArticleId_First(
			long articleId, OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		Article article = fetchByArticleId_First(articleId, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("articleId=");
		sb.append(articleId);

		sb.append("}");

		throw new NoSuchArticleException(sb.toString());
	}

	/**
	 * Returns the first article in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByArticleId_First(
		long articleId, OrderByComparator<Article> orderByComparator) {

		List<Article> list = findByArticleId(
			articleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last article in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByArticleId_Last(
			long articleId, OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		Article article = fetchByArticleId_Last(articleId, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("articleId=");
		sb.append(articleId);

		sb.append("}");

		throw new NoSuchArticleException(sb.toString());
	}

	/**
	 * Returns the last article in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByArticleId_Last(
		long articleId, OrderByComparator<Article> orderByComparator) {

		int count = countByArticleId(articleId);

		if (count == 0) {
			return null;
		}

		List<Article> list = findByArticleId(
			articleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the articles where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 */
	@Override
	public void removeByArticleId(long articleId) {
		for (Article article :
				findByArticleId(
					articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(article);
		}
	}

	/**
	 * Returns the number of articles where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching articles
	 */
	@Override
	public int countByArticleId(long articleId) {
		FinderPath finderPath = _finderPathCountByArticleId;

		Object[] finderArgs = new Object[] {articleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ARTICLE_WHERE);

			sb.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(articleId);

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

	private static final String _FINDER_COLUMN_ARTICLEID_ARTICLEID_2 =
		"article.articleId = ?";

	private FinderPath _finderPathWithPaginationFindByAbyI;
	private FinderPath _finderPathWithoutPaginationFindByAbyI;
	private FinderPath _finderPathCountByAbyI;

	/**
	 * Returns all the articles where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @return the matching articles
	 */
	@Override
	public List<Article> findByAbyI(int issueNumber) {
		return findByAbyI(
			issueNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the articles where issueNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param issueNumber the issue number
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of matching articles
	 */
	@Override
	public List<Article> findByAbyI(int issueNumber, int start, int end) {
		return findByAbyI(issueNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the articles where issueNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param issueNumber the issue number
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articles
	 */
	@Override
	public List<Article> findByAbyI(
		int issueNumber, int start, int end,
		OrderByComparator<Article> orderByComparator) {

		return findByAbyI(issueNumber, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the articles where issueNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param issueNumber the issue number
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching articles
	 */
	@Override
	public List<Article> findByAbyI(
		int issueNumber, int start, int end,
		OrderByComparator<Article> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAbyI;
				finderArgs = new Object[] {issueNumber};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAbyI;
			finderArgs = new Object[] {
				issueNumber, start, end, orderByComparator
			};
		}

		List<Article> list = null;

		if (useFinderCache) {
			list = (List<Article>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Article article : list) {
					if (issueNumber != article.getIssueNumber()) {
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

			sb.append(_SQL_SELECT_ARTICLE_WHERE);

			sb.append(_FINDER_COLUMN_ABYI_ISSUENUMBER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(issueNumber);

				list = (List<Article>)QueryUtil.list(
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
	 * Returns the first article in the ordered set where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByAbyI_First(
			int issueNumber, OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		Article article = fetchByAbyI_First(issueNumber, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("issueNumber=");
		sb.append(issueNumber);

		sb.append("}");

		throw new NoSuchArticleException(sb.toString());
	}

	/**
	 * Returns the first article in the ordered set where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByAbyI_First(
		int issueNumber, OrderByComparator<Article> orderByComparator) {

		List<Article> list = findByAbyI(issueNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last article in the ordered set where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByAbyI_Last(
			int issueNumber, OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		Article article = fetchByAbyI_Last(issueNumber, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("issueNumber=");
		sb.append(issueNumber);

		sb.append("}");

		throw new NoSuchArticleException(sb.toString());
	}

	/**
	 * Returns the last article in the ordered set where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByAbyI_Last(
		int issueNumber, OrderByComparator<Article> orderByComparator) {

		int count = countByAbyI(issueNumber);

		if (count == 0) {
			return null;
		}

		List<Article> list = findByAbyI(
			issueNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the articles before and after the current article in the ordered set where issueNumber = &#63;.
	 *
	 * @param articleId the primary key of the current article
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article[] findByAbyI_PrevAndNext(
			long articleId, int issueNumber,
			OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		Article article = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			Article[] array = new ArticleImpl[3];

			array[0] = getByAbyI_PrevAndNext(
				session, article, issueNumber, orderByComparator, true);

			array[1] = article;

			array[2] = getByAbyI_PrevAndNext(
				session, article, issueNumber, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Article getByAbyI_PrevAndNext(
		Session session, Article article, int issueNumber,
		OrderByComparator<Article> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ARTICLE_WHERE);

		sb.append(_FINDER_COLUMN_ABYI_ISSUENUMBER_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(issueNumber);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(article)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Article> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the articles where issueNumber = &#63; from the database.
	 *
	 * @param issueNumber the issue number
	 */
	@Override
	public void removeByAbyI(int issueNumber) {
		for (Article article :
				findByAbyI(
					issueNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(article);
		}
	}

	/**
	 * Returns the number of articles where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @return the number of matching articles
	 */
	@Override
	public int countByAbyI(int issueNumber) {
		FinderPath finderPath = _finderPathCountByAbyI;

		Object[] finderArgs = new Object[] {issueNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ARTICLE_WHERE);

			sb.append(_FINDER_COLUMN_ABYI_ISSUENUMBER_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(issueNumber);

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

	private static final String _FINDER_COLUMN_ABYI_ISSUENUMBER_2 =
		"article.issueNumber = ?";

	public ArticlePersistenceImpl() {
		setModelClass(Article.class);

		setModelImplClass(ArticleImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("order", "order_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the article in the entity cache if it is enabled.
	 *
	 * @param article the article
	 */
	@Override
	public void cacheResult(Article article) {
		entityCache.putResult(
			entityCacheEnabled, ArticleImpl.class, article.getPrimaryKey(),
			article);

		article.resetOriginalValues();
	}

	/**
	 * Caches the articles in the entity cache if it is enabled.
	 *
	 * @param articles the articles
	 */
	@Override
	public void cacheResult(List<Article> articles) {
		for (Article article : articles) {
			if (entityCache.getResult(
					entityCacheEnabled, ArticleImpl.class,
					article.getPrimaryKey()) == null) {

				cacheResult(article);
			}
			else {
				article.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all articles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ArticleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the article.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Article article) {
		entityCache.removeResult(
			entityCacheEnabled, ArticleImpl.class, article.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Article> articles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Article article : articles) {
			entityCache.removeResult(
				entityCacheEnabled, ArticleImpl.class, article.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ArticleImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new article with the primary key. Does not add the article to the database.
	 *
	 * @param articleId the primary key for the new article
	 * @return the new article
	 */
	@Override
	public Article create(long articleId) {
		Article article = new ArticleImpl();

		article.setNew(true);
		article.setPrimaryKey(articleId);

		return article;
	}

	/**
	 * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleId the primary key of the article
	 * @return the article that was removed
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article remove(long articleId) throws NoSuchArticleException {
		return remove((Serializable)articleId);
	}

	/**
	 * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the article
	 * @return the article that was removed
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article remove(Serializable primaryKey)
		throws NoSuchArticleException {

		Session session = null;

		try {
			session = openSession();

			Article article = (Article)session.get(
				ArticleImpl.class, primaryKey);

			if (article == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(article);
		}
		catch (NoSuchArticleException noSuchEntityException) {
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
	protected Article removeImpl(Article article) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(article)) {
				article = (Article)session.get(
					ArticleImpl.class, article.getPrimaryKeyObj());
			}

			if (article != null) {
				session.delete(article);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (article != null) {
			clearCache(article);
		}

		return article;
	}

	@Override
	public Article updateImpl(Article article) {
		boolean isNew = article.isNew();

		if (!(article instanceof ArticleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(article.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(article);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in article proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Article implementation " +
					article.getClass());
		}

		ArticleModelImpl articleModelImpl = (ArticleModelImpl)article;

		Session session = null;

		try {
			session = openSession();

			if (article.isNew()) {
				session.save(article);

				article.setNew(false);
			}
			else {
				article = (Article)session.merge(article);
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
			Object[] args = new Object[] {articleModelImpl.getArticleId()};

			finderCache.removeResult(_finderPathCountByArticleId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByArticleId, args);

			args = new Object[] {articleModelImpl.getIssueNumber()};

			finderCache.removeResult(_finderPathCountByAbyI, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAbyI, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((articleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByArticleId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					articleModelImpl.getOriginalArticleId()
				};

				finderCache.removeResult(_finderPathCountByArticleId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByArticleId, args);

				args = new Object[] {articleModelImpl.getArticleId()};

				finderCache.removeResult(_finderPathCountByArticleId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByArticleId, args);
			}

			if ((articleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAbyI.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					articleModelImpl.getOriginalIssueNumber()
				};

				finderCache.removeResult(_finderPathCountByAbyI, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAbyI, args);

				args = new Object[] {articleModelImpl.getIssueNumber()};

				finderCache.removeResult(_finderPathCountByAbyI, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAbyI, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ArticleImpl.class, article.getPrimaryKey(),
			article, false);

		article.resetOriginalValues();

		return article;
	}

	/**
	 * Returns the article with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the article
	 * @return the article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArticleException {

		Article article = fetchByPrimaryKey(primaryKey);

		if (article == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArticleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return article;
	}

	/**
	 * Returns the article with the primary key or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param articleId the primary key of the article
	 * @return the article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article findByPrimaryKey(long articleId)
		throws NoSuchArticleException {

		return findByPrimaryKey((Serializable)articleId);
	}

	/**
	 * Returns the article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articleId the primary key of the article
	 * @return the article, or <code>null</code> if a article with the primary key could not be found
	 */
	@Override
	public Article fetchByPrimaryKey(long articleId) {
		return fetchByPrimaryKey((Serializable)articleId);
	}

	/**
	 * Returns all the articles.
	 *
	 * @return the articles
	 */
	@Override
	public List<Article> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of articles
	 */
	@Override
	public List<Article> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of articles
	 */
	@Override
	public List<Article> findAll(
		int start, int end, OrderByComparator<Article> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of articles
	 */
	@Override
	public List<Article> findAll(
		int start, int end, OrderByComparator<Article> orderByComparator,
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

		List<Article> list = null;

		if (useFinderCache) {
			list = (List<Article>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ARTICLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ARTICLE;

				sql = sql.concat(ArticleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Article>)QueryUtil.list(
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
	 * Removes all the articles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Article article : findAll()) {
			remove(article);
		}
	}

	/**
	 * Returns the number of articles.
	 *
	 * @return the number of articles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ARTICLE);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "articleId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ARTICLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ArticleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the article persistence.
	 */
	@Activate
	public void activate() {
		ArticleModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ArticleModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByArticleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArticleId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByArticleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticleId",
			new String[] {Long.class.getName()},
			ArticleModelImpl.ARTICLEID_COLUMN_BITMASK);

		_finderPathCountByArticleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticleId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByAbyI = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAbyI",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAbyI = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAbyI",
			new String[] {Integer.class.getName()},
			ArticleModelImpl.ISSUENUMBER_COLUMN_BITMASK);

		_finderPathCountByAbyI = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAbyI",
			new String[] {Integer.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ArticleImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.amf.newsletter.model.Article"),
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

	private static final String _SQL_SELECT_ARTICLE =
		"SELECT article FROM Article article";

	private static final String _SQL_SELECT_ARTICLE_WHERE =
		"SELECT article FROM Article article WHERE ";

	private static final String _SQL_COUNT_ARTICLE =
		"SELECT COUNT(article) FROM Article article";

	private static final String _SQL_COUNT_ARTICLE_WHERE =
		"SELECT COUNT(article) FROM Article article WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "article.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Article exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Article exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ArticlePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"order"});

	static {
		try {
			Class.forName(NewsLetterPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}