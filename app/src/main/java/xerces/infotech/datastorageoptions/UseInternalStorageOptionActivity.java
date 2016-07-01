package xerces.infotech.datastorageoptions;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class UseInternalStorageOptionActivity extends Activity implements View.OnClickListener
{
    Button mSaveDataToFileButton;
    Button mGetDataFromFileButton;
    EditText mGetDataToSaveEditText;
    TextView mViewGetDataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.use_internal_storage_activity_layout );
        mGetDataFromFileButton = ( Button )findViewById( R.id.view_data_from_file_button );
        mSaveDataToFileButton  = ( Button )findViewById( R.id.save_data_to_file_button );
        mGetDataToSaveEditText = ( EditText )findViewById( R.id.getfiledata_edittext );
        mViewGetDataTextView = ( TextView )findViewById( R.id.viewfile_data_textview );
        mGetDataFromFileButton.setOnClickListener( this );
        mSaveDataToFileButton.setOnClickListener( this );
    }

    @Override
    public void onClick(View view)
    {
        String FILENAME = "hello_file";
        String string = mGetDataToSaveEditText.getText().toString();
        switch (view.getId() )
        {
            case R.id.save_data_to_file_button:
                FileOutputStream fos = null;
                try {
                    fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    fos.write(string.getBytes());
                    fos.close();
                    clear();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.view_data_from_file_button:
                FileInputStream fis = null;
                try
                {
                    fis = openFileInput(FILENAME);
                    fis.read();
                    int n;
                    StringBuffer fileContent = new StringBuffer("");
                    byte[] buffer = new byte[1024];
                    while ((n = fis.read(buffer)) != -1)
                    {
                        fileContent.append(new String(buffer, 0, n));
                    }
                    mViewGetDataTextView.setText( "the content is:\n"+fileContent );
                    fis.close();

                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                break;
        }

    }
    public void clear()
    {
        mGetDataToSaveEditText.setText("");
    }

}
