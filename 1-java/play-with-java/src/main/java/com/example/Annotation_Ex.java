package com.example;


class Super{
    public void print(){
        System.out.println("Super");
    }
}

class Sub extends Super{
    @Override
    public void print(){
        System.out.println("Sub");
    }
}

@FunctionalInterface
interface Predicate{
    boolean test();
}


class  Lib{
    @Deprecated
    public void v1(){
    }
}

public class Annotation_Ex {
    public static void main(String[] args) {

        Sub sub=new Sub();
        sub.print();

        Lib lib=new Lib();
        lib.v1();
    }
}
