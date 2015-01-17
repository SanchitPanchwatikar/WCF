package com.fivefish.wcf.view;

import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.fivefish.wcf.async.LoginAsync;

public class MainActivity extends Activity implements OnClickListener {

	private EditText edttxt_pswd;
	private EditText edttxt_usrname;
	private Button btn_signin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initLayout();
		initControls();

	}

	private void initControls() {
		// TODO Auto-generated method stub
		edttxt_pswd = (EditText) findViewById(R.id.editText2);
		edttxt_usrname = (EditText) findViewById(R.id.editText1);
		btn_signin = (Button) findViewById(R.id.button1);

		initListene();
	}

	private void initListene() {
		// TODO Auto-generated method stub
		btn_signin.setOnClickListener(this);
	}

	private void initLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			signIn();
			break;

		default:
			break;
		}
	}

	private void signIn() {
		// TODO Auto-generated method stub
		if (validateInfo()) {
			try {
				Boolean isLoginSucessfull = new LoginAsync().executeOnExecutor(
						AsyncTask.THREAD_POOL_EXECUTOR,
						new String[] { edttxt_usrname.getText().toString(),
								edttxt_pswd.getText().toString() }).get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private boolean validateInfo() {
		if (!edttxt_usrname.getText().toString().isEmpty()
				&& !edttxt_pswd.getText().toString().isEmpty())
			return true;
		else
			return false;
	}

}
