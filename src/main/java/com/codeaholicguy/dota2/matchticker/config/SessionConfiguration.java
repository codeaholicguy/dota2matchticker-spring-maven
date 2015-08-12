/**
 * 
 */
package com.codeaholicguy.dota2.matchticker.config;

/**
 * @author HoangNN6
 * 
 */
public class SessionConfiguration {

	public static final String UNAUTHENTICATED = "Unauthenticated";
	public static final String NO_PERMISSION = "You dont have permission";

	/**
	 * @param key
	 */
	public static void checkAuthority(String key) throws Exception {
		if (!key.equals("test")) {
			throw new Exception(UNAUTHENTICATED);
		}
	}

}
