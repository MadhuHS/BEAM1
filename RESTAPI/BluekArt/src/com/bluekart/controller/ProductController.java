package com.bluekart.controller;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.bluekart.dao.DAO;
import com.bluekart.model.ProductModel;
import com.bluekart.model.Response;
import com.google.gson.Gson;

@Path("/controller")
public class ProductController 
{
  
   @GET
   @Path("/getproducts")
   @Produces(MediaType.APPLICATION_JSON)
   public String getallproducts()
   {
	   Response response = new Response();
       
	   ProductModel product = new ProductModel(101, "Keyboard", "Dell", 123.22, "E");
	   
	   for(int i=0;i<10;i++)
	   {
	   response.productlist.add(product);
	   response.setResult(response.productlist.size());
	   }
	   
	   
	   Gson gson = new Gson();
	   String jsonresponse = gson.toJson(response);
	   
	   return jsonresponse;
   }
}
