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

package com.liferay.amf.newsletter.model.impl;

import com.liferay.amf.newsletter.model.Article;
import com.liferay.amf.newsletter.model.ArticleModel;
import com.liferay.amf.newsletter.model.ArticleSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Article service. Represents a row in the &quot;NewsLetter_Article&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ArticleModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ArticleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticleImpl
 * @generated
 */
@JSON(strict = true)
public class ArticleModelImpl
	extends BaseModelImpl<Article> implements ArticleModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a article model instance should use the <code>Article</code> interface instead.
	 */
	public static final String TABLE_NAME = "NewsLetter_Article";

	public static final Object[][] TABLE_COLUMNS = {
		{"articleId", Types.BIGINT}, {"issueNumber", Types.INTEGER},
		{"title", Types.VARCHAR}, {"author", Types.VARCHAR},
		{"order_", Types.INTEGER}, {"content", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("articleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("issueNumber", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("author", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("order_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("content", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table NewsLetter_Article (articleId LONG not null primary key,issueNumber INTEGER,title VARCHAR(75) null,author VARCHAR(75) null,order_ INTEGER,content VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table NewsLetter_Article";

	public static final String ORDER_BY_JPQL =
		" ORDER BY article.articleId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY NewsLetter_Article.articleId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long ARTICLEID_COLUMN_BITMASK = 1L;

	public static final long ISSUENUMBER_COLUMN_BITMASK = 2L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Article toModel(ArticleSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Article model = new ArticleImpl();

		model.setArticleId(soapModel.getArticleId());
		model.setIssueNumber(soapModel.getIssueNumber());
		model.setTitle(soapModel.getTitle());
		model.setAuthor(soapModel.getAuthor());
		model.setOrder(soapModel.getOrder());
		model.setContent(soapModel.getContent());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Article> toModels(ArticleSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Article> models = new ArrayList<Article>(soapModels.length);

		for (ArticleSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ArticleModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _articleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setArticleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _articleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Article.class;
	}

	@Override
	public String getModelClassName() {
		return Article.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Article, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Article, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Article, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Article)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Article, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Article, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Article)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Article, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Article, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Article>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Article.class.getClassLoader(), Article.class, ModelWrapper.class);

		try {
			Constructor<Article> constructor =
				(Constructor<Article>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Article, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Article, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Article, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Article, Object>>();
		Map<String, BiConsumer<Article, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Article, ?>>();

		attributeGetterFunctions.put("articleId", Article::getArticleId);
		attributeSetterBiConsumers.put(
			"articleId", (BiConsumer<Article, Long>)Article::setArticleId);
		attributeGetterFunctions.put("issueNumber", Article::getIssueNumber);
		attributeSetterBiConsumers.put(
			"issueNumber",
			(BiConsumer<Article, Integer>)Article::setIssueNumber);
		attributeGetterFunctions.put("title", Article::getTitle);
		attributeSetterBiConsumers.put(
			"title", (BiConsumer<Article, String>)Article::setTitle);
		attributeGetterFunctions.put("author", Article::getAuthor);
		attributeSetterBiConsumers.put(
			"author", (BiConsumer<Article, String>)Article::setAuthor);
		attributeGetterFunctions.put("order", Article::getOrder);
		attributeSetterBiConsumers.put(
			"order", (BiConsumer<Article, Integer>)Article::setOrder);
		attributeGetterFunctions.put("content", Article::getContent);
		attributeSetterBiConsumers.put(
			"content", (BiConsumer<Article, String>)Article::setContent);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getArticleId() {
		return _articleId;
	}

	@Override
	public void setArticleId(long articleId) {
		_columnBitmask |= ARTICLEID_COLUMN_BITMASK;

		if (!_setOriginalArticleId) {
			_setOriginalArticleId = true;

			_originalArticleId = _articleId;
		}

		_articleId = articleId;
	}

	public long getOriginalArticleId() {
		return _originalArticleId;
	}

	@JSON
	@Override
	public int getIssueNumber() {
		return _issueNumber;
	}

	@Override
	public void setIssueNumber(int issueNumber) {
		_columnBitmask |= ISSUENUMBER_COLUMN_BITMASK;

		if (!_setOriginalIssueNumber) {
			_setOriginalIssueNumber = true;

			_originalIssueNumber = _issueNumber;
		}

		_issueNumber = issueNumber;
	}

	public int getOriginalIssueNumber() {
		return _originalIssueNumber;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@JSON
	@Override
	public String getAuthor() {
		if (_author == null) {
			return "";
		}
		else {
			return _author;
		}
	}

	@Override
	public void setAuthor(String author) {
		_author = author;
	}

	@JSON
	@Override
	public int getOrder() {
		return _order;
	}

	@Override
	public void setOrder(int order) {
		_order = order;
	}

	@JSON
	@Override
	public String getContent() {
		if (_content == null) {
			return "";
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Article.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Article toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Article>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ArticleImpl articleImpl = new ArticleImpl();

		articleImpl.setArticleId(getArticleId());
		articleImpl.setIssueNumber(getIssueNumber());
		articleImpl.setTitle(getTitle());
		articleImpl.setAuthor(getAuthor());
		articleImpl.setOrder(getOrder());
		articleImpl.setContent(getContent());

		articleImpl.resetOriginalValues();

		return articleImpl;
	}

	@Override
	public int compareTo(Article article) {
		long primaryKey = article.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Article)) {
			return false;
		}

		Article article = (Article)obj;

		long primaryKey = article.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		ArticleModelImpl articleModelImpl = this;

		articleModelImpl._originalArticleId = articleModelImpl._articleId;

		articleModelImpl._setOriginalArticleId = false;

		articleModelImpl._originalIssueNumber = articleModelImpl._issueNumber;

		articleModelImpl._setOriginalIssueNumber = false;

		articleModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Article> toCacheModel() {
		ArticleCacheModel articleCacheModel = new ArticleCacheModel();

		articleCacheModel.articleId = getArticleId();

		articleCacheModel.issueNumber = getIssueNumber();

		articleCacheModel.title = getTitle();

		String title = articleCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			articleCacheModel.title = null;
		}

		articleCacheModel.author = getAuthor();

		String author = articleCacheModel.author;

		if ((author != null) && (author.length() == 0)) {
			articleCacheModel.author = null;
		}

		articleCacheModel.order = getOrder();

		articleCacheModel.content = getContent();

		String content = articleCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			articleCacheModel.content = null;
		}

		return articleCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Article, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Article, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Article, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Article)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Article, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Article, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Article, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Article)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Article>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _articleId;
	private long _originalArticleId;
	private boolean _setOriginalArticleId;
	private int _issueNumber;
	private int _originalIssueNumber;
	private boolean _setOriginalIssueNumber;
	private String _title;
	private String _author;
	private int _order;
	private String _content;
	private long _columnBitmask;
	private Article _escapedModel;

}