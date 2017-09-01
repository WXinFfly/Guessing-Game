package com.example.guessinggame;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class CalcActivity extends Activity {

	String[] conts={"¼ôµ¶","Ê¯Í·","²¼"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calc);
		Random rd=new Random();
		String result=conts[rd.nextInt(3)];
		Intent data=new Intent();
		data.putExtra("result", result);
		setResult(1019, data);
		finish();
	}

}
