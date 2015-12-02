package com.jayway.klab.rxandroidlab;

import org.junit.Test;

import java.util.Arrays;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

import static org.junit.Assert.*;

public class DemoTests {
    @Test
    public void firstTest() throws Exception {
        Observable.from(Arrays.asList(1,2,23)).
                filter(i -> i % 2 == 1).
                map(i -> i * 3).
                subscribe(i -> System.out.println(i));

    }
}