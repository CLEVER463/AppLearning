package com.three.learning;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Three on 2016/7/1.
 */
public class Person implements Parcelable {
    private String name = "Default";
    private String number = "null";
    private String major;
    private String grade;

    public Person() {
        super();
    }

    @Override
    public String toString() {
        return name + '\n' + number + '\n' + major + '\n' + grade + '\n';
    }

    public Person(String name, String number, String major, String grade) {
        this.name = name;
        this.number = number;
        this.major = major;
        this.grade = grade;
    }

    public Person(Parcel source) {
        this.name = source.readString();
        this.number = source.readString();
        this.major = source.readString();
        this.grade = source.readString();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.number);
        dest.writeString(this.major);
        dest.writeString(this.grade);
    }


    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {

        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[0];
        }
    };
}
