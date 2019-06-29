package com.zy.snippets.wildcards;

import org.junit.Test;

/**
 * @Author: zy
 * @Date: 2018/12/23 14:58
 */
public class WildcardsTest {

    private Food food = new Food();
    private Fruit fruit = new Fruit();
    private Apple apple = new Apple();

    Plate<Fruit> plate = new Plate<>();
    Plate<? extends Fruit> platewse = new Plate<>();
    Plate<? super Fruit> platewss = new Plate<>();

    @Test
    public void t() {
//        plate.set(food);  //error
        plate.set(fruit);
        plate.set(apple);

        Food fo = plate.get();
        Fruit fr = plate.get();
//        Apple a = plate.get();  //error

//        plate = new Plate<Food>();  //error
        plate = new Plate<Fruit>();
//        plate = new Plate<Apple>(); //error
    }

    @Test
    public void extendsT() {
//        platewse.set(food);    //error
//        platewse.set(fruit);   //error
//        platewse.set(apple);   //error

        Food fo = platewse.get();
        Fruit fr = platewse.get();
//        Apple a = platewse.get();   //error

//        platewse = new Plate<Food>(); //error
        plate = new Plate<Fruit>();
        platewse = new Plate<Apple>();
    }

    @Test
    public void superT() {
//        platewss.set(food); //error
        platewss.set(fruit);
        platewss.set(apple);

//        Food fo = platewss.get(); //error
//        Fruit fr = platewss.get();    //error
//        Apple a = platewss.get(); //error

        platewss = new Plate<Food>();
        plate = new Plate<Fruit>();
//        platewss = new Plate<Apple>();//error
    }

    @Test
    public void test() {

    }

}
