package com.shop.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shop.entity.Brand;
import com.shop.entity.Product;
import com.shop.service.BrandService;
import com.shop.service.ProductSerivce;
import com.shop.tools.PageTool;

@RequestMapping("/product")
@Controller
public class ProductController { 
	
	  @Autowired
	  private ProductSerivce productSerivce;
	  
	  @Autowired
	  private BrandService brandService;
	  
	  
	  @RequestMapping("/getProductList")
	  public String productList(Integer currentPageNo,Model model) {
		  if(null == currentPageNo) {
			  currentPageNo = 1;
		  }
		  int toballist = productSerivce.getToballist();
		  PageTool pagetool = new PageTool();
		  pagetool.setTotalCount(toballist);
		  pagetool.setCurrentPageNo(currentPageNo);
		  
		  List<Product> productList = productSerivce.productList(currentPageNo, pagetool.getPageSize());
		  model.addAttribute("productList", productList);
		  model.addAttribute("pageTool", pagetool);
		   return "product/getlist";
	  }
	  
	 /* @RequestMapping("/getProdctList")
	  public String getProductList(Model model) {
		  List<Product> productList = productSerivce.getProductList();
		  model.addAttribute("productList", productList);
		  return "product/getlist";
	  }*/
	  
	  //添加商品
	  @RequestMapping("/allBrand")
      public String allBrand(Model model) {
		  List<Brand> allBand = brandService.getAllBand();
		  model.addAttribute("all", allBand);
		  return "brand/allbrand";
	  }
	  
	  //保存添加商品
	  @RequestMapping("/getaddBrandAndproduct")
	  public String getaddBrandAndproduct(Product product,@RequestParam(value ="picFiles", required = false) 	MultipartFile picFiles,@RequestParam(value ="picFileso", required = false) 	MultipartFile picFileso,Model model,
		 HttpServletResponse response,HttpServletRequest request)  {
		  model.addAttribute("product", product);
		  List<Brand> allBand = brandService.getAllBand();
		  model.addAttribute("all", allBand);
		    String viewName="brand/allbrand";
		    String fileName = null;		
			if (!picFiles.isEmpty()) {
				String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"upload"); 			
				String oldFileName = picFiles.getOriginalFilename();//获取文件的原名字			
				String prefix=FilenameUtils.getExtension(oldFileName);//原文件后缀     
				int filesize = 5000000;
		        if(picFiles.getSize() >  filesize){//上传大小不得超过 500k
	            	request.setAttribute("uploadPicError", " * 上传大小不得超过 500k");
	            	//超过大小不允许跳转，直接返回以前的视图页面
		        	return viewName;
	            }else if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") 
	            		|| prefix.equalsIgnoreCase("gif")||prefix.equalsIgnoreCase("jpeg")){//上传图片格式不正确
	            	fileName="head_"+System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"."+prefix;
	                File targetFile = new File(path, fileName);  
	                if(!targetFile.exists()){  
	                    targetFile.mkdirs();  
	                }  
	                //保存  
	                try {  
	                	picFiles.transferTo(targetFile);  
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                    request.setAttribute("uploadPicError", " * 上传失败！");
	                    return viewName;
	                }  
	            }else{
	            	request.setAttribute("uploadPicError", " * 上传图片格式不正确");
	            	return viewName;
	            }
		    product.setProductImg(fileName);
			}
			String fileNames = null;	
		    if (!picFileso.isEmpty()) {
				String paths = request.getSession().getServletContext().getRealPath("statics"+File.separator+"upload"); 			
				String oldFileNames = picFiles.getOriginalFilename();//获取文件的原名字			
				String prefixs=FilenameUtils.getExtension(oldFileNames);//原文件后缀     
				int filesizes = 5000000;
		        if(picFiles.getSize() >  filesizes){//上传大小不得超过 500k
	            	request.setAttribute("uploadPicError", " * 上传大小不得超过 500k");
	            	//超过大小不允许跳转，直接返回以前的视图页面
		        	return viewName;
	            }else if(prefixs.equalsIgnoreCase("jpg") || prefixs.equalsIgnoreCase("png") 
	            		|| prefixs.equalsIgnoreCase("gif")||prefixs.equalsIgnoreCase("jpeg")){//上传图片格式不正确
	            	fileNames="head_"+System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"."+prefixs;
	                File targetFiles = new File(paths, fileNames);  
	                if(!targetFiles.exists()){  
	                    targetFiles.mkdirs();  
	                }  
	                //保存  
	                try {  
	                	picFileso.transferTo(targetFiles);  
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                    request.setAttribute("uploadPicError", " * 上传失败！");
	                    return viewName;
	                }  
	            }else{
	            	request.setAttribute("uploadPicError", " * 上传图片格式不正确");
	            	return viewName;
	            }
		        product.setNatural(fileNames);
		    } 
		  productSerivce.insertSelective(product); 
		  return "redirect:getProdctList";
	  } 
	  
	  
	  //修改商品信息
	  @RequestMapping("/reviewProduct")
	  public String reviewProduct(Integer id,Model model) {
		  Product reviewList = productSerivce.reviewList(id);
		  List<Brand> BrandList = brandService.getAllBand();
		  model.addAttribute("reviewList", reviewList);
		  model.addAttribute("BrandList", BrandList);
		  return "product/molity";
	  }
	  
	  //保存修改商品信息
	  @RequestMapping("/molityproduct")
	  public String molityproduct(Product product,@RequestParam(value ="picFiles", required = false) 	MultipartFile picFiles,Model model,
				 HttpServletResponse response,HttpServletRequest request,Integer currentPageNo,RedirectAttributes urbutes) {  
		         urbutes.addAttribute("currentPageNo",currentPageNo);
		     
		     String viewName="forward:reviewProduct"; //转发
		     String fileName = null;		
			if (!picFiles.isEmpty()) {
				String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"upload"); 			
				String oldFileName = picFiles.getOriginalFilename();//获取文件的原名字			
				String prefix=FilenameUtils.getExtension(oldFileName);//原文件后缀     
				int filesize = 5000000;
		        if(picFiles.getSize() >  filesize){//上传大小不得超过 500k
	            	request.setAttribute("uploadPicError", " * 上传大小不得超过 500k");
	            	//超过大小不允许跳转，直接返回以前的视图页面
		        	return viewName;
	            }else if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") 
	            		|| prefix.equalsIgnoreCase("gif")||prefix.equalsIgnoreCase("jpeg")){//上传图片格式不正确
	            	fileName="head_"+System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"."+prefix;
	                File targetFile = new File(path, fileName);  
	                if(!targetFile.exists()){  
	                    targetFile.mkdirs();  
	                }  
	                //保存  
	                try {  
	                	picFiles.transferTo(targetFile);  
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                    request.setAttribute("uploadPicError", " * 上传失败！");
	                    return viewName;
	                }  
	            }else{
	            	request.setAttribute("uploadPicError", " * 上传图片格式不正确");
	            	return viewName;
	            }
		    product.setProductImg(fileName);
		}
		  productSerivce.updateProduct(product);
		  return "redirect:getProductList";
	  }
	  
	  
	  
	  
	  @RequestMapping("/imgsd")
	   public String imgsd(Product product,@RequestParam(value ="imgs", required = false) 	MultipartFile imgs,Model model,
			  HttpServletResponse response,HttpServletRequest request,Integer currentPageNo,RedirectAttributes urbutes) {
		  String viewName="forward:reviewProduct"; //转发 
		  String fileName = null;
		  if (!imgs.isEmpty()) {
				String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"upload"); 			
				String oldFileName = imgs.getOriginalFilename();//获取文件的原名字			
				String prefix=FilenameUtils.getExtension(oldFileName);//原文件后缀     
				int filesize = 5000000;
		        if(imgs.getSize() >  filesize){//上传大小不得超过 500k
	            	request.setAttribute("uploadPicError", " * 上传大小不得超过 500k");
	            	//超过大小不允许跳转，直接返回以前的视图页面
		        	return viewName;
	            }else if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") 
	            		|| prefix.equalsIgnoreCase("gif")||prefix.equalsIgnoreCase("jpeg")){//上传图片格式不正确
	            	fileName="head_"+System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"."+prefix;
	                File targetFile = new File(path, fileName);  
	                if(!targetFile.exists()){  
	                    targetFile.mkdirs();  
	                }  
	                //保存  
	                try {  
	                	imgs.transferTo(targetFile);  
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                    request.setAttribute("uploadPicError", " * 上传失败！");
	                    return viewName;
	                }  
	            }else{
	            	request.setAttribute("uploadPicError", " * 上传图片格式不正确");
	            	return viewName;
	            }
		        System.out.println(fileName);
		        model.addAttribute("imgs", fileName);
		  }
		  return "msg";
	  }
		  
}
