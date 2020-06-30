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

package com.liferay.amf.newsletter.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the content column in Article.
 *
 * @author Brian Wing Shun Chan
 * @see Article
 * @generated
 */
public class ArticleContentBlobModel {

	public ArticleContentBlobModel() {
	}

	public ArticleContentBlobModel(int articleId) {
		_articleId = articleId;
	}

	public ArticleContentBlobModel(int articleId, Blob contentBlob) {
		_articleId = articleId;
		_contentBlob = contentBlob;
	}

	public int getArticleId() {
		return _articleId;
	}

	public void setArticleId(int articleId) {
		_articleId = articleId;
	}

	public Blob getContentBlob() {
		return _contentBlob;
	}

	public void setContentBlob(Blob contentBlob) {
		_contentBlob = contentBlob;
	}

	private int _articleId;
	private Blob _contentBlob;

}