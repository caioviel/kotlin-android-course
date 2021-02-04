package com.example.eat_and_fit;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private double weight;
    private double height;
    private int age;

    Person(double w, double h, int a) {
        this.weight = w;
        this.height = h;
        this.age = a;
    }

    protected Person(Parcel in) {
        weight = in.readDouble();
        height = in.readDouble();
        age = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(weight);
        dest.writeDouble(height);
        dest.writeInt(age);
    }
}
