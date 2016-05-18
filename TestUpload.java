package com.user.rest;

import java.io.File;

import java.io.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

@Path("up")
public class TestUpload {
	
	@SuppressWarnings("unused")
	@GET
	@Path("/pdf")
	public Response uploadPdfFile( ) throws Exception
	{
	    final Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
	 
	    final FileDataBodyPart filePart = new FileDataBodyPart("file", new File("D:\\a.txt"));
	    
	    filePart.setContentDisposition(FormDataContentDisposition.name("file").fileName("file").build());
	    
	    
	    FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
	    formDataMultiPart.bodyPart(filePart);
	  
	  	FormDataBodyPart formDataBodyPart=new FormDataBodyPart("profile","My Profile",MediaType.TEXT_PLAIN_TYPE);
	   formDataBodyPart.setContentDisposition(FormDataContentDisposition.name("profile").fileName("profile").build()); 
	   
	   FormDataBodyPart formDataBodyPart1=new FormDataBodyPart("width","100",MediaType.TEXT_PLAIN_TYPE);
	   formDataBodyPart1.setContentDisposition(FormDataContentDisposition.name("width").fileName("width").build());
	   
	   FormDataBodyPart formDataBodyPart2=new FormDataBodyPart("height","500",MediaType.TEXT_PLAIN_TYPE);
	   formDataBodyPart2.setContentDisposition(FormDataContentDisposition.name("height").fileName("height").build());
	   
	   FormDataBodyPart formDataBodyPart3=new FormDataBodyPart("met","Met",MediaType.TEXT_PLAIN_TYPE);
	   formDataBodyPart3.setContentDisposition(FormDataContentDisposition.name("met").fileName("met").build());
	   
	   FormDataBodyPart formDataBodyPart4=new FormDataBodyPart("identifier","Var",MediaType.TEXT_PLAIN_TYPE);
	   formDataBodyPart4.setContentDisposition(FormDataContentDisposition.name("identifier").fileName("identifier").build());
	   
	   formDataMultiPart.bodyPart(formDataBodyPart);
	   formDataMultiPart.bodyPart(formDataBodyPart1);
	   formDataMultiPart.bodyPart(formDataBodyPart2);
	   formDataMultiPart.bodyPart(formDataBodyPart3);
	   formDataMultiPart.bodyPart(formDataBodyPart4);
	   
	  
	      
	    final WebTarget target = client.target("http://localhost:8080/FileUpload/rest/hello/pdf2");
	    final Response response = target.request().post(Entity.entity(formDataMultiPart, formDataMultiPart.getMediaType()));
	     
	    System.out.println("Success");
	    formDataMultiPart.close();
	    
	    return Response.ok("Done").build();
	}


public static void main(String[] args)
{
System.out.println("Hello Example Pull    ");
}
}
