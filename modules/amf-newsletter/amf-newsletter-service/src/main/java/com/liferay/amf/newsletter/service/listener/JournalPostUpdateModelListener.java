package com.liferay.amf.newsletter.service.listener;

import com.liferay.amf.newsletter.service.ArticleLocalService;
import com.liferay.amf.newsletter.service.IssueLocalService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(immediate = true, property = {}, service = ModelListener.class)
public class JournalPostUpdateModelListener extends BaseModelListener<JournalArticle>{
	
	public static final String ARTICLE_DDMS = "49942";
	
	@Override
	public void onAfterUpdate(JournalArticle model) {
		String ddmsKey = model.getDDMStructureKey();
		if(ddmsKey.equals(ARTICLE_DDMS)) {
			_articleLocalService.addArticle(model.getContent(), model.getResourcePrimKey());
		}
		else {
			_issueLocalService.addIssue(model.getContent(), model.getResourcePrimKey();
		}
	}
	
	
	@Reference
	protected IssueLocalService _issueLocalService;
	
	@Reference
	protected ArticleLocalService _articleLocalService;

}
