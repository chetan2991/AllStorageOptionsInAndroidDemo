package xerces.infotech.datastorageoptions;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UseExternalStorageOptions extends Activity implements View.OnClickListener
{
    EditText mGetFileDataEditText;
    Button mSaveFileData;
    Button mViewFileData;
    TextView mViewFileDataTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.use_internal_storage_activity_layout);
        mGetFileDataEditText = ( EditText ) findViewById( R.id.getfiledata_edittext );
        mSaveFileData = ( Button  ) findViewById( R.id.save_data_to_file_button );
        mViewFileData  = ( Button ) findViewById( R.id.view_data_from_file_button );
        mViewFileDataTextView = ( TextView ) findViewById( R.id.viewfile_data_textview );
        mSaveFileData.setOnClickListener( this );
        mViewFileData.setOnClickListener( this );

    }


    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view)
    {
        switch ( view.getId() )
        {
            case R.id.save_data_to_file_button:
                        break;
            case R.id.view_data_from_file_button:
                       break;
        }
    }
}
