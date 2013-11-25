package com.gdays.admob;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RelativeLayout;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.InterstitialAd;

public class MainActivity extends Activity {
	/*
	 * This is your AdMob Ad Unit ID - you get this after signing up for AdMob
	 */
	private final String AD_UNIT_ID = "xxxxxxxxxxxxxxx";
	InterstitialAd interstitialAd = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		RelativeLayout layout = (RelativeLayout)findViewById(R.id.layout);
		
		interstitialAd = new InterstitialAd(this, AD_UNIT_ID);
		AdListener listerner = new AdListener() {
			
			@Override
			public void onReceiveAd(Ad arg0) {
				Log("Add Receieved");
				if(interstitialAd.isReady()){
					interstitialAd.show();
				}
			}
			
			@Override
			public void onPresentScreen(Ad arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLeaveApplication(Ad arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFailedToReceiveAd(Ad arg0, ErrorCode arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onDismissScreen(Ad arg0) {
				// TODO Auto-generated method stub
				
			}
		};
		interstitialAd.setAdListener(listerner);
		
		/* Uncomment these to load normal Ads*/
		
		//AdView adView = new AdView(this, AdSize.SMART_BANNER, AD_UNIT_ID);
		//layout.addView(adView);
		AdRequest adRequest = new AdRequest();
		adRequest.addTestDevice(AdRequest.TEST_EMULATOR);
		/* This is your Android device ID to only show test Ads  */
		adRequest.addTestDevice("E1232FDA4386D9527B7A553AC25CF360");
		//adView.loadAd(adRequest);
		interstitialAd.loadAd(adRequest);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private static void Log(String msg){
		android.util.Log.d("ADMOBGDAYS", msg);
	}

}
