package com.mycompany.ourapp.service;

import com.mycompany.ourapp.dto.MenuList;

public class MenuListService {
	public MenuList resList(int mlresid){
		MenuList menulist = new MenuList();
	
		return menulist;
	}
	
	public int addMenu(int mlresid){
		return SUCCESS;
	}
	
	public int modify(MenuList menulist){
		return SUCCESS;
	}
	
	public int deleteMenu(String mlname){
		return SUCCESS;
	}
	
	public boolean resHotList(boolean mlishot){
		return true;
	}
	
	public int addHot(String mlname, boolean mlishot){
		return SUCCESS;
	}
	
	public int deleteHot(String mlname, boolean mlishot){
		return SUCCESS;
	}
}