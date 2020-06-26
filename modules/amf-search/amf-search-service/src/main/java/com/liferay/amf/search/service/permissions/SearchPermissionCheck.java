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

package com.liferay.amf.search.service.permissions;

import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;

/**
 * @author liferay
 */
@Component(immediate = true, service = SearchPermissionCheck.class)
public class SearchPermissionCheck {

	public boolean contains(
		PermissionChecker permissionChecker, String actionId) {

		return permissionChecker.hasPermission(
			_groupId, _modelClassName, _groupId, actionId);
	}

	private long _groupId = 0;
	private String _modelClassName = "com.liferay.amf.search";

}