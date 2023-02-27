package com.application.practices.databinding_Sqlite.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.application.practices.BR;

/**
 * Created by Charles Raj I on 25/07/22.
 *
 * @author Charles Raj I
 */

/*Why we are extending with baseobserver here is ... we are going to bind the variable diractly to the xml so .
* we need the live data binding.. for the we use baseobservable
* and we need to do some annotation and notifications.. lets do that
* */
public class AddUserDetailsModel extends BaseObservable {


    private String name;
    private String age;
    private String gender;
    private String dob;
    private String height;
    private String weight;

    /*Above the header we need to add @Bindiable*/
    @Bindable
    public String getName() {
        return name;
    }
    /*Inside the setter we need to notifity the property to BR*/
    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
    @Bindable
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
    @Bindable
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        notifyPropertyChanged(BR.gender);
    }
    @Bindable
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
        notifyPropertyChanged(BR.dob);
    }
    @Bindable
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
        notifyPropertyChanged(BR.height);
    }
    @Bindable
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
        notifyPropertyChanged(BR.weight);
    }
}
