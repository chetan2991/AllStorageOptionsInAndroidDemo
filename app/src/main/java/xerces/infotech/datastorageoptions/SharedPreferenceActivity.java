package xerces.infotech.datastorageoptions;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SharedPreferenceActivity extends Activity implements View.OnClickListener
{
    EditText mUsernameEditText,mPasswordEditText;
    Button mSavePreferencesButton, mViewPreferencesButton;
    TextView mUsernameTextView, mPasswordTextView;
    SharedPreferences mSharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.sharepreference_activity_layout );
        mUsernameEditText = ( EditText )findViewById( R.id.username_edittext );
        mPasswordEditText = ( EditText )findViewById( R.id.password_edittext );
        mSavePreferencesButton  = ( Button )findViewById( R.id.SavePreferencesButton );
        mViewPreferencesButton = ( Button ) findViewById( R.id.ViewPreferencesButton );
        mUsernameTextView = ( TextView )findViewById( R.id.username_textview );
        mPasswordTextView = ( TextView )findViewById( R.id.password_textview );
        mSharedPreferences  = getSharedPreferences( MyApplication.MY_APP_PREFERENCES ,0);
        mUsernameTextView.setText(mSharedPreferences.getString( MyApplication.USERNAME_PREFERENCE_KEY , ""));
        mPasswordTextView.setText(mSharedPreferences.getString( MyApplication.PASSWORD_PREFERENCE_KEY, ""));
        mSavePreferencesButton.setOnClickListener( this );
        mViewPreferencesButton.setOnClickListener( this );
    }

    @Override
    public void onClick(View view)
    {
        switch ( view.getId() )
        {
            case R.id.SavePreferencesButton:
                            SharedPreferences.Editor editor = mSharedPreferences.edit();
                            editor.putString( MyApplication.USERNAME_PREFERENCE_KEY, mUsernameEditText.getText().toString() );
                            editor.putString( MyApplication.PASSWORD_PREFERENCE_KEY, mPasswordEditText.getText().toString() );
                            editor.commit();
                            clear();
                            break;
            case R.id.ViewPreferencesButton:
                            mUsernameTextView.setText(mSharedPreferences.getString( MyApplication.USERNAME_PREFERENCE_KEY , ""));
                            mPasswordTextView.setText(mSharedPreferences.getString( MyApplication.PASSWORD_PREFERENCE_KEY, ""));
                            break;


        }
    }
    private void clear()
    {
        mUsernameEditText.setText("");
        mPasswordEditText.setText("");
    }
}
