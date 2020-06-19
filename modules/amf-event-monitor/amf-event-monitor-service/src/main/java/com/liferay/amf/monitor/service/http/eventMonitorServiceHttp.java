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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>eventMonitorServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eventMonitorServiceSoap
 * @generated
 */
public class eventMonitorServiceHttp {

	public static com.liferay.amf.monitor.model.eventMonitor addeventMonitor(
		HttpPrincipal httpPrincipal, long userId, String eventType) {

		try {
			MethodKey methodKey = new MethodKey(
				eventMonitorServiceUtil.class, "addeventMonitor",
				_addeventMonitorParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, eventType);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.amf.monitor.model.eventMonitor)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findByEventType(HttpPrincipal httpPrincipal, String eventType) {

		try {
			MethodKey methodKey = new MethodKey(
				eventMonitorServiceUtil.class, "findByEventType",
				_findByEventTypeParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, eventType);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.amf.monitor.model.eventMonitor>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.amf.monitor.model.eventMonitor>
			findByEventType(
				HttpPrincipal httpPrincipal, String eventType, int start,
				int end)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		try {
			MethodKey methodKey = new MethodKey(
				eventMonitorServiceUtil.class, "findByEventType",
				_findByEventTypeParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, eventType, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.security.auth.
							PrincipalException) {

					throw (com.liferay.portal.kernel.security.auth.
						PrincipalException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.amf.monitor.model.eventMonitor>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findByEventType(
			HttpPrincipal httpPrincipal, String eventType, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.amf.monitor.model.eventMonitor>
					orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				eventMonitorServiceUtil.class, "findByEventType",
				_findByEventTypeParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, eventType, start, end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.amf.monitor.model.eventMonitor>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.amf.monitor.model.eventMonitor>
			findAll(HttpPrincipal httpPrincipal, int start, int end)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		try {
			MethodKey methodKey = new MethodKey(
				eventMonitorServiceUtil.class, "findAll",
				_findAllParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.security.auth.
							PrincipalException) {

					throw (com.liferay.portal.kernel.security.auth.
						PrincipalException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.amf.monitor.model.eventMonitor>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long getEventMonitorsCountByEventType(
		HttpPrincipal httpPrincipal, String eventType) {

		try {
			MethodKey methodKey = new MethodKey(
				eventMonitorServiceUtil.class,
				"getEventMonitorsCountByEventType",
				_getEventMonitorsCountByEventTypeParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, eventType);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		eventMonitorServiceHttp.class);

	private static final Class<?>[] _addeventMonitorParameterTypes0 =
		new Class[] {long.class, String.class};
	private static final Class<?>[] _findByEventTypeParameterTypes1 =
		new Class[] {String.class};
	private static final Class<?>[] _findByEventTypeParameterTypes2 =
		new Class[] {String.class, int.class, int.class};
	private static final Class<?>[] _findByEventTypeParameterTypes3 =
		new Class[] {
			String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _findAllParameterTypes4 = new Class[] {
		int.class, int.class
	};
	private static final Class<?>[]
		_getEventMonitorsCountByEventTypeParameterTypes5 = new Class[] {
			String.class
		};

}