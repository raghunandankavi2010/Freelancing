package proto.idss.maplebear;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;

public class UtilListPreference extends ListPreference {

	public UtilListPreference(Context context, AttributeSet attrs) {
		super(context, attrs); 
	}

	public UtilListPreference(Context context) {
		super(context); 
	}

	@Override
	protected boolean persistString(String value) {
		return persistInt(Integer.valueOf(value));
	}
	
	@Override
	protected String getPersistedString(String defaultReturnValue) {
		return String.valueOf(getPersistedInt(-1));
	}
}
