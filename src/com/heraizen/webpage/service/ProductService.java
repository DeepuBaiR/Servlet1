package com.heraizen.webpage.service;

import java.util.Arrays;
import java.util.List;

public class ProductService 
{
	public static List<String> getProductNames()
	{
		String names="Lenovo k 20,MI 3,onePlus 7,OPPo 2 Remo";
		return Arrays.asList(names.split(","));
	}
}
