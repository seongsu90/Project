package com.mycompany.ourapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dao.MenuListDao;
import com.mycompany.ourapp.dto.MenuList;

@Component
public class MenuListService {
	
	public static final int ADD_SUCCESS=0;
	public static final int ADD_FAIL=1;
	public static final int DELETE_SUCCESS=0;
	public static final int DELETE_FAIL=1;
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;
	
	@Autowired
	private MenuListDao menuListdao;
	
	public List<MenuList> list(int pageNo, int rowsPerPage){
		return menuListdao.selectByPage(pageNo, rowsPerPage); 
	}
	
	public int add(MenuList menuList){
		int row = menuListdao.insert(menuList);
		if(row==0){return ADD_FAIL;}
	
		return ADD_SUCCESS;
	}
	
	public int modify(MenuList menuList){
		int row = menuListdao.update(menuList);
		if(row==0){return MODIFY_FAIL;}
		return MODIFY_SUCCESS;
	}
	
	public int delete(int mlresid,String mlname){
		int row = menuListdao.delete(mlresid,mlname);
		if(row==0){return DELETE_FAIL;}
		return DELETE_SUCCESS;
	}
	
	public List<MenuList> resHotList(int mlresid, boolean mlishot){
		
		List<MenuList> list = menuListdao.resHotList(mlresid, mlishot);
		
		return list;
	}
	
	public int modifyHot(int mlresid,String mlname, boolean mlishot){
		int row = menuListdao.modifyHot(mlresid, mlname, mlishot);
		if(row==0){return MODIFY_FAIL;}
		return MODIFY_SUCCESS;
	}
	
	public MenuList info(int mlresid, String mlname){
		MenuList menuList = menuListdao.selectByMlresidAndMlname(mlresid, mlname);
		return menuList;
	}

	public int getCount() {
		return menuListdao.count();
	}
}