package com.example.guessinggame;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button btn_cq;
	private RadioGroup rdg_check;
	private TextView tv_result;
	private String result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_cq = (Button) findViewById(R.id.btn_cq);
		rdg_check = (RadioGroup) findViewById(R.id.rdg_check);
		tv_result = (TextView) findViewById(R.id.tv_result);
		btn_cq.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				switch (rdg_check.getCheckedRadioButtonId()) {
				case R.id.rdb_1:
					result="剪刀";
					break;
				case R.id.rdb_2:
					result="石头";

					break;
				case R.id.rdb_3:
					result="布";
					break;
				default:
					break;
				}
				Intent intent=new Intent(MainActivity.this, CalcActivity.class);
				startActivityForResult(intent, 1010);
			}
		});
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==1010&&resultCode==1019){
			String daResult=data.getStringExtra("result");
			String dy=null;
			if("剪刀".equals(result)&&"剪刀".equals(daResult)){
				dy="系统出："+daResult+"\t平局";
			}else if("剪刀".equals(result)&&"石头".equals(daResult)){
				dy="系统出："+daResult+"\t我们输";
			}else if("剪刀".equals(result)&&"布".equals(daResult)){
				dy="系统出："+daResult+"\t我们赢";
			}else if("石头".equals(result)&&"剪刀".equals(daResult)){
				dy="系统出："+daResult+"\t我们赢";
			}else if("石头".equals(result)&&"石头".equals(daResult)){
				dy="系统出："+daResult+"\t平局";
			}else if("石头".equals(result)&&"布".equals(daResult)){
				dy="系统出："+daResult+"\t我们输";
			}else if("布".equals(result)&&"剪刀".equals(daResult)){
				dy="系统出："+daResult+"\t我们输";
			}else if("布".equals(result)&&"石头".equals(daResult)){
				dy="系统出："+daResult+"\t我们赢";
			}else if("布".equals(result)&&"布".equals(daResult)){
				dy="系统出："+daResult+"\t平局";
			}
			tv_result.setText(dy);
		}
	}
}
