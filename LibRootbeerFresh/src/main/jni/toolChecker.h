/****************************************************************************
 * File:   toolChecker.h
 * Author: Matthew Rollings
 * Date:   19/06/2015
 *
 * Description : Root checking JNI NDK code
 *
 ****************************************************************************/

extern "C" {

#include <jni.h>

jint Java_com_kimchangyoun_rootbeerFresh_RootBeerNative_setLogDebugMessages( JNIEnv* env, jobject thiz, jboolean debug);

int Java_com_kimchangyoun_rootbeerFresh_RootBeerNative_checkForMagiskUDS( JNIEnv* env, jobject thiz );

int Java_com_kimchangyoun_rootbeerFresh_RootBeerNative_checkForRoot( JNIEnv* env, jobject thiz , jobjectArray pathsArray );

}
