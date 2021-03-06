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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the eventMonitor service. Represents a row in the &quot;AmfEventMonitor_eventMonitor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.amf.monitor.model.impl.eventMonitorModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.amf.monitor.model.impl.eventMonitorImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eventMonitor
 * @generated
 */
@ProviderType
public interface eventMonitorModel extends BaseModel<eventMonitor> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a event monitor model instance should use the {@link eventMonitor} interface instead.
	 */

	/**
	 * Returns the primary key of this event monitor.
	 *
	 * @return the primary key of this event monitor
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this event monitor.
	 *
	 * @param primaryKey the primary key of this event monitor
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the event monitor ID of this event monitor.
	 *
	 * @return the event monitor ID of this event monitor
	 */
	public long getEventMonitorId();

	/**
	 * Sets the event monitor ID of this event monitor.
	 *
	 * @param eventMonitorId the event monitor ID of this event monitor
	 */
	public void setEventMonitorId(long eventMonitorId);

	/**
	 * Returns the user ID of this event monitor.
	 *
	 * @return the user ID of this event monitor
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this event monitor.
	 *
	 * @param userId the user ID of this event monitor
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this event monitor.
	 *
	 * @return the user uuid of this event monitor
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this event monitor.
	 *
	 * @param userUuid the user uuid of this event monitor
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this event monitor.
	 *
	 * @return the user name of this event monitor
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this event monitor.
	 *
	 * @param userName the user name of this event monitor
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this event monitor.
	 *
	 * @return the create date of this event monitor
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this event monitor.
	 *
	 * @param createDate the create date of this event monitor
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the user ip of this event monitor.
	 *
	 * @return the user ip of this event monitor
	 */
	@AutoEscape
	public String getUserIP();

	/**
	 * Sets the user ip of this event monitor.
	 *
	 * @param userIP the user ip of this event monitor
	 */
	public void setUserIP(String userIP);

	/**
	 * Returns the event type of this event monitor.
	 *
	 * @return the event type of this event monitor
	 */
	@AutoEscape
	public String getEventType();

	/**
	 * Sets the event type of this event monitor.
	 *
	 * @param eventType the event type of this event monitor
	 */
	public void setEventType(String eventType);

}