package edu.nju.desserthouse.service;

import java.util.List;

import edu.nju.desserthouse.model.Allsale;

public interface AllsaleService {
boolean addAllsale(Allsale allsale);
List<Allsale>getAllsales();
public void deleteAllsale(Allsale allsale);
Allsale findAllsaleByAid(int aid);
}
