package edu.nju.desserthouse.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.oracle.jrockit.jfr.Producer;

import edu.nju.desserthouse.model.Allsale;
import edu.nju.desserthouse.model.Product;
import edu.nju.desserthouse.service.AllsaleService;
import edu.nju.desserthouse.service.PlanService;
import edu.nju.desserthouse.service.ProductService;

public class HostSaleAction extends BaseAction{
	@Autowired
	private AllsaleService allsaleService;
	private ProductService productService;
	public AllsaleService getAllsaleService() {
		return allsaleService;
	}

	public void setAllsaleService(AllsaleService allsaleService) {
		this.allsaleService = allsaleService;
	}
	public ProductService getProductService(){
		return productService;
	}
	 public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	@Override
	public String execute() throws Exception {
		ServletContext sc = request.getServletContext();
		
		List<Allsale>AllsaleList=allsaleService.getAllsales();
		List<Product>productList=productService.getAllProduct();
		 String[] productName=new String[productList.size()];
		  int[] productID=new int [productList.size()];
		  int[] quantity=new int[productList.size()];
		for(int i=0;i<productList.size();i++){
			Product product=productList.get(i);
			productID[i]=product.getPid();
			productName[i]=product.getName();
			
			for(int k=0;k<AllsaleList.size();k++){
				Allsale allsale=AllsaleList.get(k);
				String []con=allsale.getProductIDs().split(";");
				System.out.println("sas"+con[0]);
				for(int m=0;m<con.length;m++){
					if(con[m].equals(product.getPid()+"")){
						quantity[i]++;
						//System.out.println(quantity[i][j]);
					}
				}
			}
		}
		
		sort(quantity, productID, productName);
		sc.setAttribute("productID",productID );
		sc.setAttribute("productName",productName );
	    sc.setAttribute("quantity",quantity );
		sc.setAttribute("num", productList.size());
		return "success";
	}
	
	private void sort(int[]quantity,int []productID,String[]productName){
		ArrayList<Integer> result=new ArrayList<Integer>();
		for(int i=0;i<quantity.length-1;i++){
			int index=i;
			for(int j=i+1;j<quantity.length;j++){
				if(quantity[j]>quantity[index]){
					int tem=quantity[index];
					quantity[index]=quantity[j];
					quantity[j]=tem;
					
					int id=productID[index];
					productID[index]=productID[j];
					productID[j]=id;
					
					
					String name=productName[index];
					productName[index]=productName[j];
					productName[j]=name;
				}
			}
			
		}
	}
}
