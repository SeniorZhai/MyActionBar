package com.example.myactionbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.myactionbar.widget.CircleFlowIndicator;
import com.example.myactionbar.widget.ViewFlow;

public class MainActivity extends Activity {
	private ViewFlow viewFlow;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		View actionbarLayout = LayoutInflater.from(this).inflate(
				R.layout.action_bar, null);
		CircleFlowIndicator indic = (CircleFlowIndicator) actionbarLayout
				.findViewById(R.id.viewflowindic);
		getActionBar().setDisplayShowCustomEnabled(true);
		getActionBar().setCustomView(actionbarLayout);
		viewFlow = (ViewFlow) findViewById(R.id.viewflow);
		viewFlow.setAdapter(new ImageAdapter(this), 5);
		viewFlow.setFlowIndicator(indic);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		viewFlow.onConfigurationChanged(newConfig);
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
		return super.onOptionsItemSelected(item);
	}
}
