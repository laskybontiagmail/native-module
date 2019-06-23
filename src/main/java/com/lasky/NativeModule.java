package com.lasky;

public class NativeModule {

	public native void hello();
	public native int get_tid();

	static {
		try {
			LibraryLoader.loadLibrary("lasky");
		} catch (Exception e) {
			System.err.println(e);
			//System.exit(1);
		}
	}
}