package com.example.connectstate;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button btnCheckNet;
	Context mContext;
	Boolean isInternetPresent = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnCheckNet = (Button)findViewById(R.id.button1);
		mContext = MainActivity.this;
		
		
		btnCheckNet.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*ConnectivityManager cm =
				        (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
				 
				NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
				boolean isConnected = activeNetwork != null;/* &&
				                      activeNetwork.isConnectedOrConnecting();

				if(isConnected == true)
					Toast.makeText(mContext, "Hien Ket Noi", 1).show();
				else
					Toast.makeText(mContext, "Hien Khong Ket Noi", 1).show();*/
				isInternetPresent = isConnectingToInternet();
				if(isInternetPresent)
					Toast.makeText(mContext, "Hien Ket Noi", 1).show();
				else
					Toast.makeText(mContext, "Hien Khong Ket Noi", 1).show();
			}
		});
		
		
	}

	


	public boolean isConnectingToInternet(){
		ConnectivityManager connectivity = (ConnectivityManager) MainActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
		if(connectivity != null){
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if (info[i].getState() == NetworkInfo.State.CONNECTED){
						return true;
					}
				}
			}
			
		}
		return false;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
