package com.fivefish.wcf.request;

import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;

public class LoginRequest extends BaseObject {

	String UserName, Password;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ksoap2.serialization.KvmSerializable#getProperty(int)
	 */
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0:
			return UserName;
		case 1:
			return Password;

		default:
			return null;

		}

	}

	@Override
	public int getPropertyCount() {

		return 2;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo arg2) {
		switch (arg0) {
		case 0:
			arg2.name = "UserName";
			arg2.namespace = "http://<YOURNAMESPACE>";
			arg2.type = PropertyInfo.STRING_CLASS;
			break;
		case 1:
			arg2.name = "Password";
			arg2.namespace = "http://<YOURNAMESPACE>";
			arg2.type = PropertyInfo.STRING_CLASS;
			break;

		default:
			break;
		}

	}

	@Override
	public void setProperty(int arg0, Object arg1) {
		switch (arg0) {
		case 0:
			UserName = (String) arg1;
			break;
		case 1:
			Password = (String) arg1;
			break;

		default:
			break;
		}

	};

}
