package com.sun.corba.se.PortableActivationIDL;


/**
* com/sun/corba/se/PortableActivationIDL/ServerManager.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u211/12973/corba/src/share/classes/com/sun/corba/se/PortableActivationIDL/activation.idl
* Monday, April 1, 2019 8:55:03 PM PDT
*/


/** Interface used to combine the Activator and Locator when both are
    * implemented together in the same process, as is currently the case
    * for our implementation.
    */
public interface ServerManager extends ServerManagerOperations, com.sun.corba.se.PortableActivationIDL.Activator, com.sun.corba.se.PortableActivationIDL.Locator
{
} // interface ServerManager
