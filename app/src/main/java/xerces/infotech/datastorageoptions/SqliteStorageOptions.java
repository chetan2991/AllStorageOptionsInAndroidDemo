package xerces.infotech.datastorageoptions;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by chetan on 1/7/16.
 */
public class SqliteStorageOptions extends Activity implements View.OnClickListener
{
    EditText mUsernameEditText, mPasswordEditText, mContactEditText;
    Button mSaveValuesButton, mViewValuesButton;
    TextView mViewSavedValueTextView;
    DatabaseHandler mDatabaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.sqlite_option_activity );
        mUsernameEditText = ( EditText ) findViewById( R.id.username_edittext );
        mPasswordEditText = ( EditText ) findViewById( R.id.password_edittext );
        mContactEditText = ( EditText ) findViewById( R.id.contact_number_edittext );
        mSaveValuesButton = ( Button ) findViewById( R.id.save_values_button );
        mViewValuesButton = ( Button ) findViewById( R.id.view_values_button );
        mViewSavedValueTextView = ( TextView ) findViewById( R.id.view_values_textview );
        mDatabaseHandler = new DatabaseHandler( getApplicationContext() );
        mSaveValuesButton.setOnClickListener( this );
        mViewValuesButton.setOnClickListener( this );
    }

    @Override
    public void onClick(View view) {
        switch ( view.getId() )
        {
            case R.id.save_values_button:
                                        UserDataModelClass userDataModelClass = new UserDataModelClass(mUsernameEditText.getText().toString(), mPasswordEditText.getText().toString(), mPasswordEditText.getText().toString());
                                        mDatabaseHandler.addUserDetails( userDataModelClass );
                                        clear();
                                    break;
            case R.id.view_values_button:
                                        UserDataModelClass userDataModelClass1;
                                        userDataModelClass1 = mDatabaseHandler.getContact( mUsernameEditText.getText().toString() );
                                        mViewSavedValueTextView.setText( "UserName is:"+userDataModelClass1.getUserName()+"\n Password is:"+userDataModelClass1.getPassword()+"\n Contact is :"+userDataModelClass1.getContact() );
                                    break;
        }
    }
    public void clear()
    {
        mUsernameEditText.setText("");
        mPasswordEditText.setText("");
        mContactEditText.setText("");
    }
}
