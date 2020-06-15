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

package com.liferay.amf.monitor.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link eventMonitor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eventMonitor
 * @generated
 */
public class eventMonitorWrapper
	extends BaseModelWrapper<eventMonitor>
	implements eventMonitor, ModelWrapper<eventMonitor> {

	public eventMonitorWrapper(eventMonitor eventMonitor) {
		super(eventMonitor);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventMonitorId", getEventMonitorId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("userIP", getUserIP());
		attributes.put("eventType", getEventType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventMonitorId = (Long)attributes.get("eventMonitorId");

		if (eventMonitorId != null) {
			setEventMonitorId(eventMonitorId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String userIP = (String)attributes.get("userIP");

		if (userIP != null) {
			setUserIP(userIP);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}
	}

	/**
	 * Returns the create date of this event monitor.
	 *
	 * @return the create date of this event monitor
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the event monitor ID of this event monitor.
	 *
	 * @return the event monitor ID of this event monitor
	 */
	@Override
	public long getEventMonitorId() {
		return model.getEventMonitorId();
	}

	/**
	 * Returns the event type of this event monitor.
	 *
	 * @return the event type of this event monitor
	 */
	@Override
	public String getEventType() {
		return model.getEventType();
	}

	/**
	 * Returns the primary key of this event monitor.
	 *
	 * @return the primary key of this event monitor
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this event monitor.
	 *
	 * @return the user ID of this event monitor
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user ip of this event monitor.
	 *
	 * @return the user ip of this event monitor
	 */
	@Override
	public String getUserIP() {
		return model.getUserIP();
	}

	/**
	 * Returns the user name of this event monitor.
	 *
	 * @return the user name of this event monitor
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this event monitor.
	 *
	 * @return the user uuid of this event monitor
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this event monitor.
	 *
	 * @param createDate the create date of this event monitor
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the event monitor ID of this event monitor.
	 *
	 * @param eventMonitorId the event monitor ID of this event monitor
	 */
	@Override
	public void setEventMonitorId(long eventMonitorId) {
		model.setEventMonitorId(eventMonitorId);
	}

	/**
	 * Sets the event type of this event monitor.
	 *
	 * @param eventType the event type of this event monitor
	 */
	@Override
	public void setEventType(String eventType) {
		model.setEventType(eventType);
	}

	/**
	 * Sets the primary key of this event monitor.
	 *
	 * @param primaryKey the primary key of this event monitor
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this event monitor.
	 *
	 * @param userId the user ID of this event monitor
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user ip of this event monitor.
	 *
	 * @param userIP the user ip of this event monitor
	 */
	@Override
	public void setUserIP(String userIP) {
		model.setUserIP(userIP);
	}

	/**
	 * Sets the user name of this event monitor.
	 *
	 * @param userName the user name of this event monitor
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this event monitor.
	 *
	 * @param userUuid the user uuid of this event monitor
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected eventMonitorWrapper wrap(eventMonitor eventMonitor) {
		return new eventMonitorWrapper(eventMonitor);
	}

}