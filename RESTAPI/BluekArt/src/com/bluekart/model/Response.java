package com.bluekart.model;

import java.util.ArrayList;

import com.bluekart.dao.DAO;

public class Response 
{

  private int result;
  
  public  ArrayList<ProductModel> productlist = new ArrayList<ProductModel>();
  

public int getResult() 
{
	return result;
}

public void setResult(int result) 
{
	this.result = result;
}
  
}
