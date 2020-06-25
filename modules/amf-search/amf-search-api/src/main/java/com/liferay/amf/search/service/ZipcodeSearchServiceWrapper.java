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
 * Provides a wrapper for {@link ZipcodeSearchService}.
 *
 * @author Brian Wing Shun Chan
 * @see ZipcodeSearchService
 * @generated
 */
public class ZipcodeSearchServiceWrapper
	implements ServiceWrapper<ZipcodeSearchService>, ZipcodeSearchService {

	public ZipcodeSearchServiceWrapper(
		ZipcodeSearchService zipcodeSearchService) {

		_zipcodeSearchService = zipcodeSearchService;
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.User> findUserByZip(
			String zip, int start, int end)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _zipcodeSearchService.findUserByZip(zip, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _zipcodeSearchService.getOSGiServiceIdentifier();
	}

	@Override
	public long getUserCount(String zip)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _zipcodeSearchService.getUserCount(zip);
	}

	@Override
	public ZipcodeSearchService getWrappedService() {
		return _zipcodeSearchService;
	}

	@Override
	public void setWrappedService(ZipcodeSearchService zipcodeSearchService) {
		_zipcodeSearchService = zipcodeSearchService;
	}

	private ZipcodeSearchService _zipcodeSearchService;

}