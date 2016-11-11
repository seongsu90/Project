package com.mycompany.ourapp.service;

import java.util.ArrayList;
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
	
	public int add(MenuList menuList){
		int row = menuListdao.insert(menuList);
		if(row==0){return DELETE_FAIL;}
	
		return ADD_SUCCESS;
	}
	
	public int modify(MenuList menuList){
		int row = menuListdao.modify(menuList);
		if(row==0){return MODIFY_FAIL;}
		return MODIFY_SUCCESS;
	}
	
	public int delete(int mlResid,String mlname){
		int row = menuListdao.delete(mlResid,mlname);
		if(row==0){return DELETE_FAIL;}
		return DELETE_SUCCESS;
	}
	
	public List<MenuList> resHotList(int mlResid, boolean mlishot){
		
		List<MenuList> menulist = new ArrayList<>();
		
		return menulist;
	}
	
	public int modifyHot(int mlResid,String mlname, boolean mlishot){
		int row = menuListdao.modifyHot(mlResid, mlname, mlishot);
		if(row==0){return MODIFY_FAIL;}
		return MODIFY_SUCCESS;
	}
}