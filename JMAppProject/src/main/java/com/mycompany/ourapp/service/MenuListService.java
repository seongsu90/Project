package com.mycompany.ourapp.service;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.ourapp.dto.MenuList;

public class MenuListService {
	
	public List<MenuList> resMenuList(int mlResid){
		List<MenuList> menulist = new ArrayList<>();
	
		return menulist;
	}
	
	public int add(MenuList menuList){
		return SUCCESS;
	}
	
	public int modify(MenuList menuList){
		return SUCCESS;
	}
	
	public int delete(int mlResid,String mlname){
		return SUCCESS;
	}
	
	public List<MenuList> resHotList(int mlResid){
		List<MenuList> menulist = new ArrayList<>();
	
		return menulist;
	}
	
	public int modifyHot(int mlResid,String mlname, boolean mlishot){
		return SUCCESS;
	}
}