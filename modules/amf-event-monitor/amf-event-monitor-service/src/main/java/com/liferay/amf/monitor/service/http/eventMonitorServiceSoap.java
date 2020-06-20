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

package com.liferay.amf.monitor.service.http;

import com.liferay.amf.monitor.service.eventMonitorServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>eventMonitorServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.amf.monitor.model.eventMonitorSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.amf.monitor.model.eventMonitor</code>, that is translated to a
 * <code>com.liferay.amf.monitor.model.eventMonitorSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eventMonitorServiceHttp
 * @generated
 */
public class eventMonitorServiceSoap {

	public static com.liferay.amf.monitor.model.eventMonitorSoap
			addeventMonitor(long userId, String eventType)
		throws RemoteException {

		try {
			com.liferay.amf.monitor.model.eventMonitor returnValue =
				eventMonitorServiceUtil.addeventMonitor(userId, eventType);

			return com.liferay.amf.monitor.model.eventMonitorSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.amf.monitor.model.eventMonitorSoap[]
			findByEventType(String eventType)
		throws RemoteException {

		try {
			java.util.List<com.liferay.amf.monitor.model.eventMonitor>
				returnValue = eventMonitorServiceUtil.findByEventType(
					eventType);

			return com.liferay.amf.monitor.model.eventMonitorSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.amf.monitor.model.eventMonitorSoap[]
			findByEventType(String eventType, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.liferay.amf.monitor.model.eventMonitor>
				returnValue = eventMonitorServiceUtil.findByEventType(
					eventType, start, end);

			return com.liferay.amf.monitor.model.eventMonitorSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.amf.monitor.model.eventMonitorSoap[] findAll(
			int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.liferay.amf.monitor.model.eventMonitor>
				returnValue = eventMonitorServiceUtil.findAll(start, end);

			return com.liferay.amf.monitor.model.eventMonitorSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static long getEventMonitorsCountByEventType(String eventType)
		throws RemoteException {

		try {
			long returnValue =
				eventMonitorServiceUtil.getEventMonitorsCountByEventType(
					eventType);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		eventMonitorServiceSoap.class);

}