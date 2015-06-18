package com.niuqh.broadcastbestpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.WindowManager;

public class ForceOfflineReceiver extends BroadcastReceiver {


	@Override
	public void onReceive(final Context context, Intent intent) {
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		dialogBuilder.setTitle("warning");
		dialogBuilder.setMessage("You are forced to be offline . plass try to login again");
		dialogBuilder.setCancelable(false);
		dialogBuilder.setPositiveButton("OK", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				ActivityCollector.finishAll();
				Intent intent = new Intent(context, LoginActivity.class);
				intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent);
			}
		});
		AlertDialog alertDialog = dialogBuilder.create();
		alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		alertDialog.show();
	}

}
