package edu.nju.desserthouse.service.impl;

import java.util.List;

import edu.nju.desserthouse.dao.AllsaleDao;
import edu.nju.desserthouse.model.Allsale;
import edu.nju.desserthouse.service.AllsaleService;

public class AllsaleServiceImpl implements AllsaleService{

	private AllsaleDao allsaleDao;
	public void setAllsaleDao(AllsaleDao allsaleDao){
		this.allsaleDao=allsaleDao;
	}
	public AllsaleDao getAllsaleDao(){
		return allsaleDao;
	}
	@Override
	public boolean addAllsale(Allsale allsale) {
		// TODO Auto-generated method stub
		return allsaleDao.save(allsale);
	}
	@Override
	public List<Allsale> getAllsales() {
		// TODO Auto-generated method stub
		return allsaleDao.getAllsales();
	}
	@Override
	public void deleteAllsale(Allsale allsale) {
		// TODO Auto-generated method stub
		allsaleDao.delete(allsale);
	}
	@Override
	public Allsale findAllsaleByAid(int aid) {
		// TODO Auto-generated method stub
		return allsaleDao.findAllsaleByAid(aid);
	}

}
