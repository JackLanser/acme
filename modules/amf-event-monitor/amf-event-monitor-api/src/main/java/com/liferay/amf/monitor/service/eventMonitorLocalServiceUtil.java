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

package com.liferay.amf.monitor.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for eventMonitor. This utility wraps
 * <code>com.liferay.amf.monitor.service.impl.eventMonitorLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see eventMonitorLocalService
 * @generated
 */
public class eventMonitorLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.amf.monitor.service.impl.eventMonitorLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the event monitor to the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventMonitor the event monitor
	 * @return the event monitor that was added
	 */
	public static com.liferay.amf.monitor.model.eventMonitor addeventMonitor(
		com.liferay.amf.monitor.model.eventMonitor eventMonitor) {

		return getService().addeventMonitor(eventMonitor);
	}

	public static com.liferay.amf.monitor.model.eventMonitor addeventMonitor(
		long userId, String eventType) {

		return getService().addeventMonitor(userId, eventType);
	}

	public static int countByEventType(String eventType) {
		return getService().countByEventType(eventType);
	}

	public static int countByUserId(long userId, String eventType) {
		return getService().countByUserId(userId, eventType);
	}

	/**
	 * Creates a new event monitor with the primary key. Does not add the event monitor to the database.
	 *
	 * @param eventMonitorId the primary key for the new event monitor
	 * @return the new event monitor
	 */
	public static com.liferay.amf.monitor.model.eventMonitor createeventMonitor(
		long eventMonitorId) {

		return getService().createeventMonitor(eventMonitorId);
	}

	/**
	 * Deletes the event monitor from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventMonitor the event monitor
	 * @return the event monitor that was removed
	 */
	public static com.liferay.amf.monitor.model.eventMonitor deleteeventMonitor(
		com.liferay.amf.monitor.model.eventMonitor eventMonitor) {

		return getService().deleteeventMonitor(eventMonitor);
	}

	/**
	 * Deletes the event monitor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventMonitorId the primary key of the event monitor
	 * @return the event monitor that was removed
	 * @throws PortalException if a event monitor with the primary key could not be found
	 */
	public static com.liferay.amf.monitor.model.eventMonitor deleteeventMonitor(
			long eventMonitorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteeventMonitor(eventMonitorId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.monitor.model.impl.eventMonitorModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.monitor.model.impl.eventMonitorModelImpl</code>.
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

	public static com.liferay.amf.monitor.model.eventMonitor fetcheventMonitor(
		long eventMonitorId) {

		return getService().fetcheventMonitor(eventMonitorId);
	}

	public static java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findAll(int start, int end) {

		return getService().findAll(start, end);
	}

	public static java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findByAllUserId(long userId) {

		return getService().findByAllUserId(userId);
	}

	public static java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findByEventType(String eventType) {

		return getService().findByEventType(eventType);
	}

	public static java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findByEventType(String eventType, int start, int end) {

		return getService().findByEventType(eventType, start, end);
	}

	public static java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findByEventType(
			String eventType, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.amf.monitor.model.eventMonitor>
					orderByComparator) {

		return getService().findByEventType(
			eventType, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findByUserId(long userId, String eventType) {

		return getService().findByUserId(userId, eventType);
	}

	public static java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findByUserId(long userId, String eventType, int start, int end) {

		return getService().findByUserId(userId, eventType, start, end);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the event monitor with the primary key.
	 *
	 * @param eventMonitorId the primary key of the event monitor
	 * @return the event monitor
	 * @throws PortalException if a event monitor with the primary key could not be found
	 */
	public static com.liferay.amf.monitor.model.eventMonitor geteventMonitor(
			long eventMonitorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().geteventMonitor(eventMonitorId);
	}

	/**
	 * Returns a range of all the event monitors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.monitor.model.impl.eventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @return the range of event monitors
	 */
	public static java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		geteventMonitors(int start, int end) {

		return getService().geteventMonitors(start, end);
	}

	/**
	 * Returns the number of event monitors.
	 *
	 * @return the number of event monitors
	 */
	public static int geteventMonitorsCount() {
		return getService().geteventMonitorsCount();
	}

	public static long getEventMonitorsCountByEventType(String eventType) {
		return getService().getEventMonitorsCountByEventType(eventType);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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
	 * Updates the event monitor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param eventMonitor the event monitor
	 * @return the event monitor that was updated
	 */
	public static com.liferay.amf.monitor.model.eventMonitor updateeventMonitor(
		com.liferay.amf.monitor.model.eventMonitor eventMonitor) {

		return getService().updateeventMonitor(eventMonitor);
	}

	public static eventMonitorLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<eventMonitorLocalService, eventMonitorLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(eventMonitorLocalService.class);

		ServiceTracker<eventMonitorLocalService, eventMonitorLocalService>
			serviceTracker =
				new ServiceTracker
					<eventMonitorLocalService, eventMonitorLocalService>(
						bundle.getBundleContext(),
						eventMonitorLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}