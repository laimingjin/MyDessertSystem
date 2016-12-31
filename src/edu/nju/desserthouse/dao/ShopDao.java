package edu.nju.desserthouse.dao;

import java.util.List;

import edu.nju.desserthouse.model.Shop;


public interface ShopDao {
public List<Shop> getAllShops();
public void save(Shop shop);
public Shop findByName(String name); 
public void delete(Shop shop);
public void update(Shop shop);
}
