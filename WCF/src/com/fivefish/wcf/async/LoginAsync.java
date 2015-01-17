/**
 * 
 */
package com.fivefish.wcf.async;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.os.AsyncTask;

import com.fivefish.wcf.request.BaseObject;
import com.fivefish.wcf.request.LoginRequest;

/**
 * @author Pramod
 * 
 */
public class LoginAsync extends AsyncTask<String, String, Boolean> {

	private String NAMESPACE = "http://<YOURNAMESPACE>";
	private LoginRequest request = null;
	private SoapSerializationEnvelope envelope = null;
	private String URL = "http://<YOUR WEB SERVICE URL PATH .SVC>";
	private HttpTransportSE htse = null;
	private int timeout =900000;
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub

		super.onPreExecute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.AsyncTask#doInBackground(Params[])
	 */
	@Override
	protected Boolean doInBackground(String... params) {
		// TODO Auto-generated method stub
		init();
		setLoginRequestParameter(params[0], params[1]);
		setSoapSerializationEnvelope();
		webServiceCall();
		return null;
	}

	private void init() {
		// TODO Auto-generated method stub
		request = new LoginRequest();
		envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		htse = new HttpTransportSE(URL, timeout);
	}

	@Override
	protected void onProgressUpdate(String... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}

	@Override
	protected void onPostExecute(Boolean result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
	}

	@Override
	protected void onCancelled(Boolean result) {
		// TODO Auto-generated method stub
		super.onCancelled(result);
	}/*
	 * Login
	 * 
	 * Passing parameter User name,Password and Context
	 */

	

	private void webServiceCall() {
		try {
			String SOAP_ACTION = "http://<YOUR SOAP NAME >";
			htse.debug = true;
			List<HeaderProperty> headerList1 = new ArrayList<HeaderProperty>();
			headerList1.add(new HeaderProperty("Connection", "keep-alive"));
			@SuppressWarnings("rawtypes")
			List headerList = htse.call(SOAP_ACTION, envelope, headerList1);

			validateResponse(headerList);
			htse.getConnection().disconnect();
			
		} catch (UnknownHostException un) {
			un.printStackTrace();
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	private void validateResponse(List headerList) {
		// TODO Auto-generated method stub
		
	}

	private void setSoapSerializationEnvelope() {
		//
		PropertyInfo pi = new PropertyInfo();
		pi.setName("request");
		pi.setType(new LoginRequest().getClass());
		pi.setValue(request);
		//
		String Login_METHOD = "LogIn";
		SoapObject soapRequest = new SoapObject(NAMESPACE, Login_METHOD);
		soapRequest.addProperty(pi);
		//
		envelope.dotNet = true;
		envelope.setOutputSoapObject(soapRequest);
		envelope.implicitTypes = true;
		envelope.addMapping(BaseObject.NAMESPACE, "request",new LoginRequest().getClass());

	}

	private void setLoginRequestParameter(String username,String password) {
	
		request.setProperty(0, password);
		request.setProperty(1, username);

	}
}
