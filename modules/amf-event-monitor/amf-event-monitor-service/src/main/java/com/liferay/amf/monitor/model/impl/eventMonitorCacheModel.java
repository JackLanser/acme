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

package com.liferay.amf.monitor.model.impl;

import com.liferay.amf.monitor.model.eventMonitor;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing eventMonitor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class eventMonitorCacheModel
	implements CacheModel<eventMonitor>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof eventMonitorCacheModel)) {
			return false;
		}

		eventMonitorCacheModel eventMonitorCacheModel =
			(eventMonitorCacheModel)obj;

		if (eventMonitorId == eventMonitorCacheModel.eventMonitorId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eventMonitorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{eventMonitorId=");
		sb.append(eventMonitorId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", userIP=");
		sb.append(userIP);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public eventMonitor toEntityModel() {
		eventMonitorImpl eventMonitorImpl = new eventMonitorImpl();

		eventMonitorImpl.setEventMonitorId(eventMonitorId);
		eventMonitorImpl.setUserId(userId);

		if (userName == null) {
			eventMonitorImpl.setUserName("");
		}
		else {
			eventMonitorImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			eventMonitorImpl.setCreateDate(null);
		}
		else {
			eventMonitorImpl.setCreateDate(new Date(createDate));
		}

		if (userIP == null) {
			eventMonitorImpl.setUserIP("");
		}
		else {
			eventMonitorImpl.setUserIP(userIP);
		}

		if (eventType == null) {
			eventMonitorImpl.setEventType("");
		}
		else {
			eventMonitorImpl.setEventType(eventType);
		}

		eventMonitorImpl.resetOriginalValues();

		return eventMonitorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eventMonitorId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		userIP = objectInput.readUTF();
		eventType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(eventMonitorId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);

		if (userIP == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userIP);
		}

		if (eventType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventType);
		}
	}

	public long eventMonitorId;
	public long userId;
	public String userName;
	public long createDate;
	public String userIP;
	public String eventType;

}