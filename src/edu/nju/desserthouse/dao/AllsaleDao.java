package edu.nju.desserthouse.dao;

import java.util.List;

import edu.nju.desserthouse.model.Allsale;

public interface AllsaleDao {
 boolean save(Allsale allsale);
 List<Allsale> getAllsales();
 public void delete(Allsale allsale);
 Allsale findAllsaleByAid(int aid);
}
