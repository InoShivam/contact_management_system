package com.cms.constant;

public interface RestMappingConstants {

	String APP_BASE = "/cms/v1";

	public interface ContactManagementSystemUri {

		String CONTACT = APP_BASE + "/contact";
		String DELETE_CONTACT = APP_BASE + "/deleteContact";
		String VIEW_CONTACT = APP_BASE + "/viewContact";

	}
}
