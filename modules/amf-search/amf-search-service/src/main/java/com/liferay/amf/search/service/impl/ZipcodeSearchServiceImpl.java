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

package com.liferay.amf.search.service.impl;

import com.liferay.amf.search.service.base.ZipcodeSearchServiceBaseImpl;
import com.liferay.amf.search.service.permissions.SearchPermissionCheck;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalException;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the zipcode search remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.search.service.ZipcodeSearchService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ZipcodeSearchServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=search",
		"json.web.service.context.path=ZipcodeSearch"
	},
	service = AopService.class
)
public class ZipcodeSearchServiceImpl extends ZipcodeSearchServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.amf.search.service.ZipcodeSearchServiceUtil</code> to access the zipcode search remote service.
	 */
	private String _actionId = "VIEW";
	
	public List<User> findUserByZip(String zip, int start, int end) throws PrincipalException {
		if(_searchPermissionCheck.contains(getPermissionChecker(), _actionId)) {
			return zipcodeSearchLocalService.findUserByZip(zip, start, end);
		}
		else return new ArrayList<User>();
	}
	
	public long getUserCount(String zip) throws PrincipalException {
		if(_searchPermissionCheck.contains(getPermissionChecker(), _actionId)) {
			return zipcodeSearchLocalService.getUserCount(zip);
		}
		else return 0;
	}
	
	@Reference
	private SearchPermissionCheck _searchPermissionCheck;
}