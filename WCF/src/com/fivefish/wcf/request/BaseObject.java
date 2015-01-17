package com.fivefish.wcf.request;

import org.ksoap2.serialization.KvmSerializable;

public abstract class BaseObject implements KvmSerializable {
	public static final String NAMESPACE = "http://<YOURNAMESPACE>";

	public BaseObject() {
		super();
	}
}