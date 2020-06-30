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

package com.liferay.amf.newsletter.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Issue. This utility wraps
 * <code>com.liferay.amf.newsletter.service.impl.IssueLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see IssueLocalService
 * @generated
 */
public class IssueLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.amf.newsletter.service.impl.IssueLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addIssue(
		int issueNumber, String issueTitle, String description,
		String issueDate) {

		getService().addIssue(issueNumber, issueTitle, description, issueDate);
	}

	/**
	 * Adds the issue to the database. Also notifies the appropriate model listeners.
	 *
	 * @param issue the issue
	 * @return the issue that was added
	 */
	public static com.liferay.amf.newsletter.model.Issue addIssue(
		com.liferay.amf.newsletter.model.Issue issue) {

		return getService().addIssue(issue);
	}

	/**
	 * Creates a new issue with the primary key. Does not add the issue to the database.
	 *
	 * @param issueNumber the primary key for the new issue
	 * @return the new issue
	 */
	public static com.liferay.amf.newsletter.model.Issue createIssue(
		int issueNumber) {

		return getService().createIssue(issueNumber);
	}

	/**
	 * Deletes the issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param issueNumber the primary key of the issue
	 * @return the issue that was removed
	 * @throws PortalException if a issue with the primary key could not be found
	 */
	public static com.liferay.amf.newsletter.model.Issue deleteIssue(
			int issueNumber)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteIssue(issueNumber);
	}

	/**
	 * Deletes the issue from the database. Also notifies the appropriate model listeners.
	 *
	 * @param issue the issue
	 * @return the issue that was removed
	 */
	public static com.liferay.amf.newsletter.model.Issue deleteIssue(
		com.liferay.amf.newsletter.model.Issue issue) {

		return getService().deleteIssue(issue);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.newsletter.model.impl.IssueModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.newsletter.model.impl.IssueModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.amf.newsletter.model.Issue fetchIssue(
		int issueNumber) {

		return getService().fetchIssue(issueNumber);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the issue with the primary key.
	 *
	 * @param issueNumber the primary key of the issue
	 * @return the issue
	 * @throws PortalException if a issue with the primary key could not be found
	 */
	public static com.liferay.amf.newsletter.model.Issue getIssue(
			int issueNumber)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getIssue(issueNumber);
	}

	/**
	 * Returns a range of all the issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.newsletter.model.impl.IssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @return the range of issues
	 */
	public static java.util.List<com.liferay.amf.newsletter.model.Issue>
		getIssues(int start, int end) {

		return getService().getIssues(start, end);
	}

	/**
	 * Returns the number of issues.
	 *
	 * @return the number of issues
	 */
	public static int getIssuesCount() {
		return getService().getIssuesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the issue in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param issue the issue
	 * @return the issue that was updated
	 */
	public static com.liferay.amf.newsletter.model.Issue updateIssue(
		com.liferay.amf.newsletter.model.Issue issue) {

		return getService().updateIssue(issue);
	}

	public static IssueLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<IssueLocalService, IssueLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(IssueLocalService.class);

		ServiceTracker<IssueLocalService, IssueLocalService> serviceTracker =
			new ServiceTracker<IssueLocalService, IssueLocalService>(
				bundle.getBundleContext(), IssueLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}