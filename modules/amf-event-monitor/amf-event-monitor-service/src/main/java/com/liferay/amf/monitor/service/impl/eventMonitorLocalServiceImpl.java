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

package com.liferay.amf.monitor.service.impl;

import com.liferay.amf.monitor.model.eventMonitor;
import com.liferay.amf.monitor.service.base.eventMonitorLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.model.User;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the event monitor local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.monitor.service.eventMonitorLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eventMonitorLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.amf.monitor.model.eventMonitor",
	service = AopService.class
)
public class eventMonitorLocalServiceImpl
	extends eventMonitorLocalServiceBaseImpl {

	public eventMonitor addeventMonitor(long userId, String eventType) {
		User user = userLocalService.fetchUserById(userId);
		long monitorId = counterLocalService.increment();
		eventMonitor event = createeventMonitor(monitorId);
		event.setUserId(userId);
		event.setUserName(user.getScreenName());

		if (eventType.equals("Registration")) {
			event.setCreateDate(user.getCreateDate());
		}
		else {
			event.setCreateDate(user.getLastLoginDate());
		}

		event.setEventType(eventType);

		if (eventType.equals("Registration")) {
			event.setUserIP(registrationIp);
		}
		else {
			event.setUserIP(user.getLastLoginIP());
		}

		event = super.addeventMonitor(event);

		return event;
	}

	public int countByEventType(String eventType) {
		return eventMonitorPersistence.countByEventType(eventType);
	}

	public int countByUserId(long userId, String eventType) {
		return eventMonitorPersistence.countByUserId(eventType, userId);
	}

	public List<eventMonitor> findAll(int start, int end) {
		return eventMonitorPersistence.findAll(start, end);
	}

	public List<eventMonitor> findByAllUserId(long userId) {
		return eventMonitorPersistence.findByAllUserId(userId);
	}

	public List<eventMonitor> findByEventType(String eventType) {
		return eventMonitorPersistence.findByEventType(eventType);
	}

	public List<eventMonitor> findByEventType(
		String eventType, int start, int end) {

		return eventMonitorPersistence.findByEventType(eventType, start, end);
	}

	public List<eventMonitor> findByUserId(long userId, String eventType) {
		return eventMonitorPersistence.findByUserId(eventType, userId);
	}

	public List<eventMonitor> findByUserId(
		long userId, String eventType, int start, int end) {

		return eventMonitorPersistence.findByUserId(
			eventType, userId, start, end);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.amf.monitor.service.eventMonitorLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.amf.monitor.service.eventMonitorLocalServiceUtil</code>.
	 */
	private String registrationIp = "0.0.0.0";

}