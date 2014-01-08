package com.skyworx.shop.service;

import java.util.List;

import com.skyworx.shop.dao.BlacklistDao;
import com.skyworx.shop.dao.IBlacklistDao;
import com.skyworx.shop.dao.WSBlacklistDao;

public class BICheckingService {
	
	private BlacklistDao blacklistDao;
	
	public void process(){
		List<String> allBlacklists = blacklistDao.getAllBlacklists();
		// process
	}
	
	public void setBlacklistDao(BlacklistDao blacklistDao) {
		this.blacklistDao = blacklistDao;
	}



	public static void main(String[] args) {
		BICheckingService service = new BICheckingService();
		service.setBlacklistDao(new BlacklistDao());
		
		// ganti ke ws
		service.setBlacklistDao(new WSBlacklistDao());
	}
	
}
