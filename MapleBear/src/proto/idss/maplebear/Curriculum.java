package proto.idss.maplebear;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Curriculum extends Activity{

	private TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.curriculum);
		tv= (TextView) findViewById(R.id.curtv);
		tv.setText(Html.fromHtml(getString(R.string.Curriculum)));
	}

}
