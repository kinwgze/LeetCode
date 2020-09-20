# 多态

### 成员变量，静态方法看左边；

### 非静态方法：编译看左边，运行看右边。

当父类变量引用子类对象时`（Fu f = new Zi();）`，在这个引用变量 f 指向的变量/方法中，他对成员变量和静态方法的调用与父类是一致的。

他调用非静态方法时，在编译时是与父类一致的（查看父类有没有该函数，没有就会发生编译错误，提示fu 中找不到要调用函数），运行时如果子类中发生了复写就与子类一致。（如果右边没有再看左边。若都没有才会报错）。

##### 父类

```java
class Teacher {
    int num = 5;

    static void show(){
        System.out.println("teacher");
    }

    void work(){
        System.out.println("布置作业");
    }

    void teach(){
        System.out.println("上课");
    }

}
```

##### 子类

```java
package test;

public class Student extends Teacher {
    int num = 8;

    static void show(){
        System.out.println("student");
    }

    @Override
    void work(){
        System.out.println("做作业");
    }

    void play(){
        System.out.println("玩游戏");
    }

}
```

##### Test

```java
public class Test {
    public static void main(String[] args) {
        Teacher p = new Teacher();
        Student s = new Student();
        System.out.println("--------父类----------");
        p.show();
        System.out.println(p.num);
        p.work();
        p.teach();

        System.out.println("--------子类-----------");
        s.show();
        System.out.println(s.num);
        s.work();
        s.play();

        System.out.println("--------多态----------");
        Teacher pp = new Student();
        pp.show();  //静态方法看左边
        System.out.println(pp.num);  //成员变量看左边
        pp.work();  //非静态方法看右边
        pp.teach(); //非静态方法，右边没有看左边

        // pp.play();  //Cannot resolve method 'play' in 'Teacher'  不能使用子类独有的方法，编译报错
    }
}
```



##### 运行结果：

```java
--------父类----------
teacher
5
布置作业
上课
--------子类-----------
student
8
做作业
玩游戏
--------多态----------
teacher
5
做作业
上课
```

