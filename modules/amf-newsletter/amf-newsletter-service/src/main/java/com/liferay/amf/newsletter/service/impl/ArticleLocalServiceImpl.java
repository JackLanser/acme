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

package com.liferay.amf.newsletter.service.impl;

import com.liferay.amf.newsletter.model.Article;
import com.liferay.amf.newsletter.service.base.ArticleLocalServiceBaseImpl;
import com.liferay.amf.newsletter.service.persistence.ArticlePersistence;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the article local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.newsletter.service.ArticleLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticleLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.amf.newsletter.model.Article",
	service = AopService.class
)
public class ArticleLocalServiceImpl extends ArticleLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.amf.newsletter.service.ArticleLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.amf.newsletter.service.ArticleLocalServiceUtil</code>.
	 */
	
	public void handleArticleEvents(String xmlString, long primaryKey) {
		Article article = findByArticleId(primaryKey);
		if(article == null) {
			addArticle(xmlString, primaryKey);
		}
		else {
			updateArticle(xmlString, primaryKey);
		}
	}
	
	public void addArticle(String xmlString, long primaryKey) {
		try {
			Article article = generateArticle(xmlString, primaryKey);
			super.addArticle(article);
		}
		catch(DocumentException e) {
			System.out.println("Error in the add article");
			e.printStackTrace();
		}
	}
	
	public void updateArticle(String xmlString, long primaryKey) {
		try {
			Article article = findByArticleId(primaryKey);
			
			updateArticleValues(article, xmlString);
			
			super.updateArticle(article);
		}
		catch(DocumentException e) {
			System.out.println("Error in the update article");
			e.printStackTrace();
		}
	}
	
	public void updateArticleValues(Article article, String xmlString) throws DocumentException{
		Document content = loadXMLFromTitle(xmlString);
		
		Node issueNumber = content.selectSingleNode("/root/dynamic-element[@name='IssueNumber']/dynamic-content");
		Node issueTitle = content.selectSingleNode("/root/dynamic-element[@name='Title']/dynamic-content");
		Node order = content.selectSingleNode("/root/dynamic-element[@name='Order']/dynamic-content");
		Node textContent = content.selectSingleNode("/root/dynamic-element[@name='Content']/dynamic-content");
		Node author = content.selectSingleNode("/root/dynamic-element[@name='Author']/dynamic-content");
		
		article.setAuthor(author.getText());
		article.setContent(textContent.getText());
		article.setIssueNumber(Integer.valueOf(issueNumber.getText()));
		article.setTitle(issueTitle.getText());
		article.setOrder(Integer.valueOf(order.getText()));
	}
	
	public Article generateArticle(String xmlString, long primaryKey) throws DocumentException {
		Document content = loadXMLFromTitle(xmlString);
		
		Node issueNumber = content.selectSingleNode("/root/dynamic-element[@name='IssueNumber']/dynamic-content");
		Node issueTitle = content.selectSingleNode("/root/dynamic-element[@name='Title']/dynamic-content");
		Node order = content.selectSingleNode("/root/dynamic-element[@name='Order']/dynamic-content");
		Node textContent = content.selectSingleNode("/root/dynamic-element[@name='Content']/dynamic-content");
		Node author = content.selectSingleNode("/root/dynamic-element[@name='Author']/dynamic-content");
		
		Article article = createArticle(primaryKey);
		
		article.setAuthor(author.getText());
		article.setContent(textContent.getText());
		article.setIssueNumber(Integer.valueOf(issueNumber.getText()));
		article.setTitle(issueTitle.getText());
		article.setOrder(Integer.valueOf(order.getText()));
		
		return article;
	}
	
	public Article deleteArticle(long primaryKey) throws PortalException {
		return super.deleteArticle(primaryKey);
	}
	
	public Document loadXMLFromTitle(String title) throws DocumentException
	{
	    Document doc = SAXReaderUtil.read(title);
		return doc;
	}
	
	public Article findByArticleId(long primaryKey) {
		return _articlePersistence.fetchByPrimaryKey(primaryKey);
	}
	@Reference
	private ArticlePersistence _articlePersistence;
}