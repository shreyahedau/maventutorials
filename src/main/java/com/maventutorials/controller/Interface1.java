package com.maventutorials.controller;

import java.lang.annotation.Documented;

@FunctionalInterface
public interface Interface1 {

    void method1(String str);

    default void log(String str)
    {
        System.out.println("logging" + str);
    }

    static void print(String str){
        System.out.println("printing" + str);
    }

    Runnable r = new Runnable(){
        @Override
        public void run() {
            System.out.println("My Runnable");
        }};
}
