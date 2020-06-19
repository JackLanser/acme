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
 * Provides the remote service utility for eventMonitor. This utility wraps
 * <code>com.liferay.amf.monitor.service.impl.eventMonitorServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see eventMonitorService
 * @generated
 */
public class eventMonitorServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.amf.monitor.service.impl.eventMonitorServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.amf.monitor.model.eventMonitor addeventMonitor(
		long userId, String eventType) {

		return getService().addeventMonitor(userId, eventType);
	}

	public static java.util.List<com.liferay.amf.monitor.model.eventMonitor>
			findAll(int start, int end)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().findAll(start, end);
	}

	public static java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findByEventType(String eventType) {

		return getService().findByEventType(eventType);
	}

	public static java.util.List<com.liferay.amf.monitor.model.eventMonitor>
			findByEventType(String eventType, int start, int end)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

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

	public static long getEventMonitorsCountByEventType(String eventType) {
		return getService().getEventMonitorsCountByEventType(eventType);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static eventMonitorService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<eventMonitorService, eventMonitorService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(eventMonitorService.class);

		ServiceTracker<eventMonitorService, eventMonitorService>
			serviceTracker =
				new ServiceTracker<eventMonitorService, eventMonitorService>(
					bundle.getBundleContext(), eventMonitorService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}