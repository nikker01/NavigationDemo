package com.example.navigationdemo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BaseActivity extends Activity {

	private DrawerLayout mDrawerLayout = null;
	private ListView mDrawerList = null;
	private String[] mDrawerItems = new String[] { "one", "two", "three" };
	private ActionBarDrawerToggle mDrawerToggle = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawer_layout);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		// mDrawerItems =
		// getResources().getStringArray(R.array.left_drawer_array);

		// mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
		// GravityCompat.START);

		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, mDrawerItems));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_launcher, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerOpened(View view) {
				invalidateOptionsMenu();
			}

			public void onDrawerClosed(View view) {
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);

		for (int index = 0; index < menu.size(); index++) {
			MenuItem menuItem = menu.getItem(index);
			if (menuItem != null) {
				// hide the menu items if the drawer is open
				menuItem.setVisible(!drawerOpen);
			}
		}

		return super.onPrepareOptionsMenu(menu);
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> adapterView, View view,
				int position, long id) {
			switch (position) {
			case 0: {
				Log.i("DrawerItemClickListener", "onItemClick BEGIN");
				// Intent intent = new Intent(BaseActivity.this,
				// SettingsActivity.class);
				// startActivity(intent);
				break;
			}
			case 1: {
				// Intent intent = new Intent(BaseActivity.this,
				// SampleActivity.class);
				// startActivity(intent);
				break;
			}
			default:
				break;
			}
			mDrawerLayout.closeDrawer(mDrawerList);
		}
	}
}
