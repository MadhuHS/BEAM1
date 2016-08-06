package com.jspiders.moblie.contentproviders;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvcontacts;
    ContentResolver cr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvcontacts =(ListView)findViewById(R.id.lvcontacts);

        cr = getContentResolver();

        //Addding data to contacts content provider starts
        addData();

        Cursor cursor = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);

        String[] columns = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                            ContactsContract.CommonDataKinds.Phone.NUMBER};

        int[] IDS = {R.id.tvname,R.id.tvnumber};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this,R.layout.row,cursor,columns,IDS,1);

        lvcontacts.setAdapter(adapter);

    }

    public void addData()
    {
        ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();

        ContentProviderOperation.Builder op =
                ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                        .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                        .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null);

        ops.add(op.build());

        op = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)

                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)

                // Sets the data row's MIME type to StructuredName
                .withValue(ContactsContract.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)

                // Sets the data row's display name to the name in the UI.
                .withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, "Name3");

        // Builds the operation and adds it to the array of operations
        ops.add(op.build());


        op =
                ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
            /*
             * Sets the value of the raw contact id column to the new raw contact ID returned
             * by the first operation in the batch.
             */
                        .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)

                        // Sets the data row's MIME type to Phone
                        .withValue(ContactsContract.Data.MIMETYPE,
                                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)

                        // Sets the phone number and type
                        .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER,1230025454)
                        .withValue(ContactsContract.CommonDataKinds.Phone.TYPE,"home");
        ops.add(op.build());


        op = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID,0)
                .withValue(ContactsContract.Data.MIMETYPE,ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Email.ADDRESS,"AAA@gmail.com")
                .withValue(ContactsContract.CommonDataKinds.Email.TYPE,"work");
        ops.add(op.build());

        try
        {
            cr.applyBatch(ContactsContract.AUTHORITY, ops);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        }
    }
}
