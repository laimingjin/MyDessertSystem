package edu.nju.desserthouse.service;

import java.util.List;

import edu.nju.desserthouse.model.Shop;

public interface ShopService {
public List<Shop>getAllShops();
public boolean addShop(Shop shop);
public Shop findShopByName(String name);
public void deleteShop(Shop shop);
public void updateShop(Shop shop);
}
