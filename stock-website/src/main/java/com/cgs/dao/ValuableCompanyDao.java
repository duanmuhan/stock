package com.cgs.dao;

import org.springframework.stereotype.Repository;

import java.util.function.Predicate;

/**
 * Created by Administrator on 2017/6/26.
 */
@Repository
public class ValuableCompanyDao {

    public static void main(String[] args) {
        function((Integer)-> true) ;
    }

    public static void function(Predicate<Integer> predicate){
        Integer integer = 0;
        if (!predicate.test(integer)){
            System.out.println("fuck your asshole");
        }
    }
}
