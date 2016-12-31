package edu.nju.desserthouse.service.impl;

import edu.nju.desserthouse.dao.SaleDao;
import edu.nju.desserthouse.model.Sale;
import edu.nju.desserthouse.service.SaleService;

public class SaleServiceImpl implements SaleService{
private SaleDao saleDao;
public void setSaleDao(SaleDao saleDao){
	this.saleDao=saleDao;
}
public SaleDao getSaleDao(){
	return saleDao;
}
	@Override
	public boolean addSale(Sale sale) {
		// TODO Auto-generated method stub
		saleDao.save(sale);
			return true;
		
	}

}
