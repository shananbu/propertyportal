package com.ats.property.service.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * The PropertyAdminWebService.
 *
 * @author anbarasan.s
 */
public class PropertyExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        e.printStackTrace();
        if (e instanceof WebApplicationException) {
            WebApplicationException webExcp=(WebApplicationException)e;
            return webExcp.getResponse();
        }
        return Response.ok("ERROR from PropertyExceptionMapper").build();
    }
}
