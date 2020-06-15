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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.amf.monitor.service.http.eventMonitorServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class eventMonitorSoap implements Serializable {

	public static eventMonitorSoap toSoapModel(eventMonitor model) {
		eventMonitorSoap soapModel = new eventMonitorSoap();

		soapModel.setEventMonitorId(model.getEventMonitorId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setUserIP(model.getUserIP());
		soapModel.setEventType(model.getEventType());

		return soapModel;
	}

	public static eventMonitorSoap[] toSoapModels(eventMonitor[] models) {
		eventMonitorSoap[] soapModels = new eventMonitorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static eventMonitorSoap[][] toSoapModels(eventMonitor[][] models) {
		eventMonitorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new eventMonitorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new eventMonitorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static eventMonitorSoap[] toSoapModels(List<eventMonitor> models) {
		List<eventMonitorSoap> soapModels = new ArrayList<eventMonitorSoap>(
			models.size());

		for (eventMonitor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new eventMonitorSoap[soapModels.size()]);
	}

	public eventMonitorSoap() {
	}

	public long getPrimaryKey() {
		return _eventMonitorId;
	}

	public void setPrimaryKey(long pk) {
		setEventMonitorId(pk);
	}

	public long getEventMonitorId() {
		return _eventMonitorId;
	}

	public void setEventMonitorId(long eventMonitorId) {
		_eventMonitorId = eventMonitorId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getUserIP() {
		return _userIP;
	}

	public void setUserIP(String userIP) {
		_userIP = userIP;
	}

	public String getEventType() {
		return _eventType;
	}

	public void setEventType(String eventType) {
		_eventType = eventType;
	}

	private long _eventMonitorId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private String _userIP;
	private String _eventType;

}