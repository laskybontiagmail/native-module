package com.lasky;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NativeModuleWrapper {
	private static NativeModuleWrapper onlyInstance = null;
	private static String OS = null;
	
	private static Logger logger = LogManager.getLogger(NativeModuleWrapper.class);
	
	private NativeModule nativeModule = null;
	
	static {
		logger = LogManager.getLogger(NativeModuleWrapper.class);
		OS = System.getProperty("os.name").toLowerCase();
	}
	
	private NativeModuleWrapper() {
		logger.info("NativeModuleWrapper() constructor");
		
		if (isCurrentOsSupported()) {
			nativeModule = new NativeModule();
		}
	}
	
	public static NativeModuleWrapper getOnlyInstance() {
		logger.info("NativeModuleWrapper getOnlyInstance()");
		if (onlyInstance == null) {
			onlyInstance = new NativeModuleWrapper();
		}
		
		return onlyInstance;
	}
	
	public void testCall() {
		if (isCurrentOsSupported()) {
			nativeModule.hello();
		} else {
			logger.warn("Calling testCall() but current OS is not supported!");
		}
	}
	
	public int getLightWeightProcessId() {
		int lightWeightProcessId = -1;
		
		if (isCurrentOsSupported()) {
			lightWeightProcessId = nativeModule.get_tid();
		} else {
			logger.warn("Calling getLightWeightProcessId() but current OS is not supported!");
			logger.warn("lightWeightProcessId == " + lightWeightProcessId);
		}
		
		return lightWeightProcessId;
	}
	
	public boolean isCurrentOsSupported() {
		boolean isSupported = false;
		
		isSupported = (isUnix());
		
		logger.warn("isCurrentOsSupported: " + isSupported);
		
		return isSupported;
	}
	
	public String getCurrentOs() {
		return OS;
	}
	
	public boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	public boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
		
	}

	public boolean isSolaris() {

		return (OS.indexOf("sunos") >= 0);

	}
}
