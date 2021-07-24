
package com.praxware.registrationprefrence;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Resultlogin {

    @SerializedName("registration")
    @Expose
    private List<Registration> registration = null;

    public List<Registration> getRegistration() {
        return registration;
    }

    public void setRegistration(List<Registration> registration) {
        this.registration = registration;
    }

}
