#include <jni.h>
#include <stdio.h>

#include <unistd.h>
#include <sys/syscall.h>
#include <sys/types.h>

#include "com_lasky_NativeModule.h"

JNIEXPORT void JNICALL Java_com_lasky_NativeModule_hello(JNIEnv *, jobject) {
	printf("Hello World of Lasky Bontia going nuts over JNI wwaaahhhhh!!!\n");
#ifdef __cplusplus
	printf("__cplusplus is defined\n");
#else
	printf("__cplusplus is NOT defined\n");
#endif
	return;
}

JNIEXPORT jint JNICALL Java_com_lasky_NativeModule_get_1tid(JNIEnv *env, jobject obj) {
    //jint tid = syscall(__NR_gettid);
    jint tid = -1;
    
    tid = syscall(SYS_gettid);
    
    #ifdef __cplusplus
	printf("__cplusplus is defined\n");
#else
	printf("__cplusplus is NOT defined\n");
#endif

    return tid;
}
