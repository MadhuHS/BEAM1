package realmdb;

import android.content.Context;
import android.support.design.widget.Snackbar;

import com.jspiders.moblie.studentinfo.HomeActivity;
import com.jspiders.moblie.studentinfo.Student;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by user on 16/07/2016.
 */
public class RealmDbClass {

    static int ID;
    static RealmResults<Student> results;
    static  Realm realm;

  public static RealmResults<Student> loaddata(Context ctx)
   {
       RealmConfiguration configuration =
               new RealmConfiguration.Builder(ctx).build();

       Realm.setDefaultConfiguration(configuration);
       Realm realm = Realm.getDefaultInstance();
       long count = realm.where(Student.class).count();
       results = realm.where(Student.class).findAll();

       return results;

   }

    public static long addData(int ID,String name,int phone,String email)
    {
        realm.beginTransaction();
        Student s1 = realm.createObject(Student.class);
        s1.setID(ID);
        s1.setName(name);
        s1.setPhone(phone);
        s1.setEmail(email);
        realm.commitTransaction();

        return realm.where(Student.class).count();
    }


}
