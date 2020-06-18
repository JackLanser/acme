package com.liferay.amf.eventmonitor.web.portlet.action;

import com.liferay.amf.eventmonitor.web.constants.EventMonitorPortletKeys;
import com.liferay.amf.eventmonitor.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC command for showing the assignments list.
 * 
 * @author liferay
 */


@Component(
    immediate = true, 
    property = {
        "javax.portlet.name=" + EventMonitorPortletKeys.EVENTMONITOR, 
        "mvc.command.name=" + MVCCommandNames.ALL_VIEW
    }, 
    service = MVCRenderCommand.class
)
public class AllViewMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(
        RenderRequest renderRequest, RenderResponse renderResponse)
        throws PortletException {
    	System.out.println("test");
    	
    	return "jspf/viewAll.jspf";
    }


    @Reference
    private Portal _portal;
}
