package A_utilities;

import API.BATSE;

public class Bodies {

	public static String UserName() {
		
		String UN = "8210157528" ;
		
 String BodyParam =	"{\r\n"
				+ "    \"phone\" : "+UN+" ,\r\n"
				+ "\"dialingCode\" : 91 ,\r\n"
				+ "\"appId\" : 2 ,\r\n"
				+ "\"os\" : \"android\",\r\n"
				+ "\"latitude\": 28.595367 ,\r\n"
				+ "\"longitude\": 77.310251 ,\r\n"
				+ "\"language\": \"en\" \r\n"
				+ "}" ;
		
		return BodyParam ;
		
	}
	
public static String Password()	{
	
	String UN = "8210157528";
	String PW = "123456";
	
	
	String BodyParam =	"{\r\n"
			+ "\"username\" : "+UN+" ,\r\n"
			+ "\"password\" : "+PW+" ,\r\n"
			+ "\"language\" : \"en\" ,\r\n"
			+ "\"appId\" : 2,\r\n"
			+ "\"typeId\": 1006\r\n"
			+ "\r\n"
			+ "}" ;
	
	return BodyParam ;
	
}

public static String Outlet_List()	{
	
	
	String latitude = "28.6181" ;
	String longitude = "77.3833" ;
	
	String BodyParam =	"{\"outletType\":117000 ,\r\n"
			+ "\"latitude\" : "+latitude+" , \r\n"
			+ "\"longitude\" : "+longitude+" ,\r\n"
			+ "\"appId\" : 2 ,\r\n"
			+ "\"language\" : \"Locale.current.languageCode!\" ,\r\n"
			+ "\"pageNumber\" : 1 }" ;
	
	return BodyParam ;
	
}


public static String CategoryID() {
	
	String OI = BATSE.Get_OutletID();
	
	String Params = "{\r\n"
			+ "    \"outletId\" : "+OI+" \r\n"
			+ "}" ;
	
	return Params;
}

public static String Add_Item()	{
	
	String	OI = BATSE.Get_OutletID();
    String	CI = BATSE.Get_Category();
	
	
	String BodyParam =	"{\r\n"
			+ "\"outletId\" : "+OI+",\r\n"
			+ "\"pageNumber\" : 1 ,\r\n"
			+ "\"status\" : 1126000,\r\n"
    		+ "\"categoryId\" : "+CI+" \r\n"
			+ "}" ;
	
	return BodyParam ;
	
}



	
}
