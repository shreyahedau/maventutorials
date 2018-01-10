package com.maventutorials.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

@Controller
public class programs{

    public static final Logger LOGGER = Logger.getLogger(programs.class);
    @RequestMapping(value = {"/arrayrotation"}, method = RequestMethod.GET)
    public void arrayRotation()
    {
        int[] arr = {1,2,3,4,5,6};
        int shift = 2;
        Integer[] arr1 = new Integer[arr.length];
        int length = arr.length;

        // logic : storing the (first)no of elements to the place where they will be shifted
        // eg : no. of elements to shift = 2 and the length of the array is 6,
        // so shift the first 2 elements at 4th and 5th place.
        // store the rest of the elements in the other array starting from 0 to 4.
        // left rotate
        for(int i = 0; i < arr.length; i++) {
        {
            if(shift != 0) {
                arr1[length - shift] = arr[i];
                shift--;

            }
            else
            {
                arr1[arr.length - length] = arr[i];
                length--;
            }
        }

        }
        List<Integer> myList = new ArrayList<Integer>();

        for(int j = 0; j < arr1.length; j++)
        {
            myList.add(arr1[j]);
            System.out.println(arr1[j]);
        }

        MyConsumer action = new MyConsumer();
        myList.forEach(action);
        // for right rotate
        // shift would be shift = length - rightRotate

    }

    @RequestMapping(value = {"/program1"}, method = RequestMethod.GET)
    public void program1()
    {
        LOGGER.debug("logger debug");
        LOGGER.info("logger info");
        LOGGER.error("logger error");

        //creating sample Collection
        List<Integer> myList = new ArrayList<Integer>();
        for(int i=0; i<10; i++) myList.add(i);

        //traversing using Iterator
        Iterator<Integer> it = myList.iterator();
        while(it.hasNext()){
          //  Integer i = it.next();
            System.out.println("Iterator Value::"+it.next());
        }

        //traversing through forEach method of Iterable with anonymous class
//        myList.forEach(new Consumer<Integer>() {
//
//            public void accept(Integer t) {
//                System.out.println("forEach anonymous class Value::"+t);
//            }
//
//        });

        //traversing with Consumer interface implementation
        // Java8 foreach loop

      /*  Consumer<Integer> cust = (Integer i) -> System.out.println("cust" + i);
        myList.forEach(cust);

        // remove from list
        Predicate<Integer> personPredicate = i-> i == 2 || i == 3;
        myList.removeIf(personPredicate);

        System.out.println("---After delete---");
        myList.forEach(cust);

        // replacing all
        UnaryOperator<Integer> unaryOpt = pn -> modifyName(pn);
        myList.replaceAll(unaryOpt);

        System.out.println("---After unary---");
        myList.forEach(cust);

        MyConsumer action = new MyConsumer();
        myList.forEach(action);

        Interface1 i1 = (s) -> System.out.println(s);
        i1.log("abc");*/



        Consumer<Map<Integer, Object>> mapConsumer = (Map<Integer, Object> obj) -> System.out.println("key" + obj.keySet() + "value" + obj.values());

        Map<Integer, Object> map = new HashMap<Integer, Object>();;
        map.put(2,"abcd");
        map.put(1,"defgha");
//        map.put(2,"java"); // here it will override the key as it contains only unique elements
//        map.put(null,"qwerty");
//        map.put(null,"qwerty2"); // here this will also override

        map.put(3,"bb");

        // Compute a new value for the existing key
        System.out.println(map.compute(3, (k, v) -> v == null? 42: k + 41));

        System.out.println(map.compute(4, (k, v) -> v == null? 42: k + 41));

       /* System.out.println(map);
        // This will add a new (key, value) pair
        System.out.println(map.compute("X",
                (k, v) -> v == null? 42: v + 41));
        System.out.println(map);*/

       map.put(6,"aa");

        // this map does not support null value
       System.out.println(map.merge(6, "aa",(v1, v2) -> null));

        map.put(7, null);
        System.out.println(map.getOrDefault(7, "hello"));


        map.forEach( (key, value) -> { System.out.println( "Key: " + key + "\t" + " Value: " + value ); });


    }


    class MyConsumer implements Consumer<Integer> {

        public void accept(Integer t) {
            System.out.println("Consumer impl Value::" + t);
        }
    }

    private static Integer modifyName(Integer p){
       p = p + 2;
        return p;
    }

//    public void demoBlob() {
//        try {
//            File image = new File("/home/shreya/shreya/songs/Bulleya(MyMp3Song).mp3");
//           // FileInputStream fis = new FileInputStream(image);
//            //Blob b1 = ;
//        } catch (FileNotFoundException e)
//        {
//
//        }
//
//    }

    @RequestMapping(value = {"/program2"}, method = RequestMethod.GET)
    public void streamExample()
    {
        System.out.println("inside program2");
        List<Integer> myList = new ArrayList<Integer>();


        for(int i=0; i<100 ; i++) myList.add(i);

        Stream<Integer> sequentialStream = myList.stream();

        //using lambda with Stream API, filter example
        Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);

        //using lambda in forEach
        highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));




        Stream<Integer> parallelStream = myList.parallelStream();

        //using lambda with Stream API, filter example
        Stream<Integer> highNums = parallelStream.filter(p -> p > 90);

        //using lambda in forEach
        highNums.forEach(p -> System.out.println("High Nums parallel="+p));


    }
}
