import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.ShopDao;
import edu.nju.desserthouse.dao.WaiterDao;
import edu.nju.desserthouse.dao.impl.ShopDaoImpl;
import edu.nju.desserthouse.dao.impl.WaiterDaoImpl;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.model.Waiter;
import edu.nju.desserthouse.service.ShopService;
import edu.nju.desserthouse.service.WaiterService;
import edu.nju.desserthouse.service.impl.ShopServiceImpl;

public class test {
	
public static void main(String[]args) throws ParseException{
	test test=new test();
	Date tem=new Date();
	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
	String da=simpleDateFormat.format(tem);
	System.out.println(da);
	Date date=simpleDateFormat.parse(da);
	System.out.println(date);

}


}
