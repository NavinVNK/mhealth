package com.example.dell.mhealth;

import android.app.Application;

/**
 * Created by DELL on 17-02-2016.
 */
public class GlobalClass extends Application {
public String contact_name;
    public String name;
    private int count;
private int temp;
    private String day;
    public String contact_contact;
public String dot_name;
    String user_id;
    public String dot_phone;
    public String coursesummary;
    public String get_coursesummary()
    {
        return coursesummary;
    }
    public void set_coursesummary(String t)
    {

        coursesummary=t;
    }
    public String get_userid()
    {
return user_id;
    }
    public void set_userid(String user)
    {
        user_id=user;
    }
    public String get_dotname()
    {
        return dot_name;
    }
    public void set_dotname(String dot)
    {
        dot_name=dot;
    }
    public String get_dotphone()
    {
        return dot_phone;
    }
    public void set_dotphone(String dot)
    {
        dot_phone=dot;
    }

    public String get_day()
    {
        return day;
    }
    public void set_day(String t)
    {
        day=t;
    }
    public String getName() {

        return name;
    }

    public void setName(String aName) {

        name = aName;

    }
    public String getContactName() {

        return contact_name;
    }

    public void setContactName(String aName) {

        contact_name = aName;

    }
    public String getContact_contact(){

        return contact_contact;
    }

    public void setContact_contact(String aName) {

        contact_contact = aName;

    }

    public int getCount() {

        return count;
    }
public int getTempCount()
{
    return temp;
}
    public void setTempCount(int tempa)
    {
        temp=tempa;
    }
    public void setCount(int temp) {

        count = temp;
    }
}
