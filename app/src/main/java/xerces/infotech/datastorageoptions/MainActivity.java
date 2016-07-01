package xerces.infotech.datastorageoptions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    Button mUseSharedPreferencesButton;
    Button mUseSqliteDataBaseButton;
    Button mUserInternalStorageButton;
    Button mUseExternalStorageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUseSharedPreferencesButton = ( Button )findViewById( R.id.use_sharedPreferences_button );
        mUseSqliteDataBaseButton = ( Button )findViewById( R.id.use_sqlite_storage_options );
        mUserInternalStorageButton = ( Button )findViewById( R.id.use_Internal_storage_option );
        mUseExternalStorageButton  = ( Button ) findViewById( R.id.use_external_storage_option );
        mUseExternalStorageButton.setOnClickListener( this );
        mUseSharedPreferencesButton.setOnClickListener( this );
        mUseSqliteDataBaseButton.setOnClickListener( this );
        mUserInternalStorageButton.setOnClickListener( this );
    }


    @Override
    public void onClick(View view)
    {
        switch ( view.getId() )
        {
            case R.id.use_sharedPreferences_button:
                            Intent intent = new Intent( MainActivity.this, SharedPreferenceActivity.class );
                            startActivity( intent );
                            break;
            case R.id.use_sqlite_storage_options:

                                break;
            case R.id.use_Internal_storage_option:
                Intent internalstorageintent = new Intent( MainActivity.this, UseInternalStorageOptionActivity.class );
                startActivity( internalstorageintent );
                break;
            case R.id.use_external_storage_option:
                        Intent externalstorageintent  =   new Intent( MainActivity.this, UseExternalStorageOptions.class );
                        startActivity( externalstorageintent );
                break;


        }

    }
}
