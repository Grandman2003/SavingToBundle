package com.example.newredfit;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

class Z implements Parcelable{
    private int a;

    protected Z(Parcel in) {
        a = in.readInt();
    }

    public static final Creator<Z> CREATOR = new Creator<Z>() {
        @Override
        public Z createFromParcel(Parcel in) {
            return new Z(in);
        }

        @Override
        public Z[] newArray(int size) {
            return new Z[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(a);
    }
}

public class Parsic implements Parcelable {
    int age;
    String name;
    ArrayList<String> katzen;
    TreeMap<Z,Z> tree;
    ArrayList<Z> z;
    transient int year;//no serizable
    static int age2;//no serizable
//memento, state pattern
    transient final int year1=2020;


    protected Parsic(Parcel in) {
         Bundle bundle=in.readBundle();
        age=bundle.getInt("age");
        name=bundle.getString("age");
        katzen=bundle.getStringArrayList("katzen");
        z=bundle.getParcelableArrayList("z");

    }

    public static final Creator<Parsic> CREATOR = new Creator<Parsic>() {
        @Override
        public Parsic createFromParcel(Parcel in) {
            return new Parsic(in);
        }

        @Override
        public Parsic[] newArray(int size) {
            return new Parsic[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        Bundle bundle=new Bundle();
        bundle.putInt("age",age);
        bundle.putString("name",name);
        bundle.putStringArrayList("katzen",katzen);
        bundle.putParcelableArrayList("z",z);
        parcel.writeBundle(bundle);
    }
    // private final static long serialVersionUID=13L;

    public Parsic(int age, String name, ArrayList<String> katzen, ArrayList<Z> z) {
        this.age = age;
        this.name = name;
        this.katzen = katzen;
        this.z = z;
        this.year = year;
    }
}
