package edu.nju.desserthouse.service.impl;

import java.util.List;

import edu.nju.desserthouse.dao.ShopDao;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.service.ShopService;

public class ShopServiceImpl implements ShopService{
private ShopDao shopDao;
public void setShopDao(ShopDao shopDao){
	this.shopDao=shopDao;
}
public ShopDao getShopDao(){
	return shopDao;
}
	@Override
	public List<Shop> getAllShops() {
		// TODO Auto-generated method stub
		return shopDao.getAllShops();
	}
	@Override
	public boolean addShop(Shop shop) {
		// TODO Auto-generated method stub
		Shop result=shopDao.findByName(shop.getName());
		if(result!=null){
		return false;
		}else{
			shopDao.save(shop);
			return true;
		}
	}
	@Override
	public Shop findShopByName(String name) {
		// TODO Auto-generated method stub
		return shopDao.findByName(name);
	}
	@Override
	public void deleteShop(Shop shop) {
		// TODO Auto-generated method stub
		shopDao.delete(shop);
	}
	@Override
	public void updateShop(Shop shop) {
		// TODO Auto-generated method stub
		shopDao.update(shop);
	}

}
