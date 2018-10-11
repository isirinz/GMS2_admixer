package ${YYAndroidPackageName};

import com.admixer.AdInfo;
import com.admixer.AdView;
import com.admixer.InterstitialAd;
import com.admixer.AdViewListener;

import com.yoyogames.runner.RunnerJNILib;
import ${YYAndroidPackageName}.RunnerActivity;

import android.util.Log;
import android.view.Gravity;
import android.widget.FrameLayout;

public class Admixer
{
	public String admixer_banner(String key, double direction) {
		final String finalKey = key;
		final double finalDirection = direction;
		Log.d("Admixer", "admixer_banner key="+key);

		RunnerActivity.CurrentActivity.runOnUiThread(new Runnable() {
			public void run() {
				AdInfo adInfo = new AdInfo(finalKey);
				adInfo.setTestMode(true);
				AdView adView = new AdView(RunnerActivity.CurrentActivity);
				adView.setAdInfo(adInfo, RunnerActivity.CurrentActivity);
				adView.setAlwaysShowAdView(true);
				adView.setAdViewListener(new AdViewListener() {
					@Override
					public void onReceivedAd(String s, AdView adView) {
						Log.d("Admixer", "onReceivedAd " + s);
					}

					@Override
					public void onFailedToReceiveAd(int i, String s, AdView adView) {
						Log.d("Admixer", "onFailedToReceiveAd errorCode="+i+", errorMsg="+s);
					}

					@Override
					public void onClickedAd(String s, AdView adView) {
						Log.d("Admixer", "onClickedAd "+s);
					}
				});

				if (finalDirection == 2) {
					FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.TOP | Gravity.CENTER);
					RunnerActivity.CurrentActivity.addContentView(adView, params);
				} else {
					FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM | Gravity.CENTER);
					RunnerActivity.CurrentActivity.addContentView(adView, params);
				}
			}
		});

		return "";
	}

	public String admixer_interstitial(String key) {
		final String finalKey = key;
		Log.d("Admixer", "admixer_interstitial key="+key);
		RunnerActivity.CurrentActivity.runOnUiThread(new Runnable() {
			public void run() {
				AdInfo adInfo = new AdInfo(finalKey);
				adInfo.setTestMode(true);
				InterstitialAd interstitialAd = new InterstitialAd(RunnerActivity.CurrentActivity);
				interstitialAd.setAdInfo(adInfo, RunnerActivity.CurrentActivity);
				interstitialAd.startInterstitial();
			}
		});
		return "";
	}
}