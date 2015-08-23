package com.ats.property.service.servlet;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.annotation.WebServlet;

/**
 * The PropertyPortalCXFServlet.
 *
 * @author anbarasan.s
 */
public class PropertyPortalCXFServlet extends CXFServlet {

    private static final long serialVersionUID = -940426493552315026L;

    public PropertyPortalCXFServlet() {
        super();
    }
}
