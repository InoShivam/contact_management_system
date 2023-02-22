package com.cms.response;


import com.cms.exception.AppException;


public class ResponseBuilder {
public static BaseApiResponse getSuccessResponse(Object responseData) throws AppException {
		
		BaseApiResponse baseApiResponse = new BaseApiResponse();
		//baseApiResponse.setResponseStatus(new ResponseStatus(AppConstants.StatusCodes.SUCCESS));
		baseApiResponse.setStatusCode(1);
		baseApiResponse.setResponseData(responseData);
		baseApiResponse.setResponseStatus(new ResponseStatus(1));
		baseApiResponse.setMessage("Success");
		return baseApiResponse;
	}
	
	public static BaseApiResponse getSuccessResponse() throws AppException {
		
		BaseApiResponse baseApiResponse = new BaseApiResponse();
		baseApiResponse.setStatusCode(1);
		//baseApiResponse.setResponseStatus(new ResponseStatus(AppConstants.StatusCodes.SUCCESS));
	
		baseApiResponse.setResponseData(null);
		baseApiResponse.setMessage("Success");
		return baseApiResponse;
	}
}