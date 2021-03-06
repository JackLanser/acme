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

package com.liferay.amf.search.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ZipcodeSearchLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ZipcodeSearchLocalService
 * @generated
 */
public class ZipcodeSearchLocalServiceWrapper
	implements ServiceWrapper<ZipcodeSearchLocalService>,
			   ZipcodeSearchLocalService {

	public ZipcodeSearchLocalServiceWrapper(
		ZipcodeSearchLocalService zipcodeSearchLocalService) {

		_zipcodeSearchLocalService = zipcodeSearchLocalService;
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.User> findUserByZip(
		String zip) {

		return _zipcodeSearchLocalService.findUserByZip(zip);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.User> findUserByZip(
		String zip, int start, int end) {

		return _zipcodeSearchLocalService.findUserByZip(zip, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _zipcodeSearchLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public long getUserCount(String zip) {
		return _zipcodeSearchLocalService.getUserCount(zip);
	}

	@Override
	public ZipcodeSearchLocalService getWrappedService() {
		return _zipcodeSearchLocalService;
	}

	@Override
	public void setWrappedService(
		ZipcodeSearchLocalService zipcodeSearchLocalService) {

		_zipcodeSearchLocalService = zipcodeSearchLocalService;
	}

	private ZipcodeSearchLocalService _zipcodeSearchLocalService;

}