# JAVA 入门

[TOC]

## 简介

JVM(虚拟机,包含解释器)

源代码 编译器 字节码文件 解释器



JRE(运行环境)



JDK(开发工具包)



## 环境搭建

**bin**目录下包含一堆.exe可执行文件

**lib**类库文件

配置环境变量:

**JAVA_HOME**      配置JDK安装路径

**PATH**                  配置JDK命令文件的位置

**CLASSPATH **      配置类库文件的位置

示例如下(mac环境)

```powershell
JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/"
export JAVA_HOME
CLASS_PATH="$JAVA_HOME/lib"
PATH=".:$PATH:$JAVA_HOME/bin"
```



win下在

系统->高级系统设置->系统属性->高级->环境变量

(修改PATH,新增JAVA_HOME,CLASS_PATH)



验证安装是否成功

```powershell
java
javac
```



.java文件 使用javac命令 (编译器complier)



`helloWorld.java`内容如下

```java
public class helloWorld{
	public static void main(String[] args){
		System.out.println("Hello World!");
	}
}
```

类名要和.java的文件名一致



然后执行

```powershell
$ javac helloWorld.java
$ ll
-rw-r--r--  1 hanzhou  staff       426  5 28 13:52 helloWorld.class
-rw-r--r--  1 hanzhou  staff       109  5 28 13:51 helloWorld.java
$ java helloWorld.class
错误: 找不到或无法加载主类 helloWorld.class
$ java helloWorld
Hello World!
```



java执行字节码文件时不需要加后缀



## 变量 常量 运算符

java里面单引号双引号完全不同

- 单引号引的数据 是char类型的
- 双引号引的数据 是String类型的



`char`,`String`,`double`,`int`

`int` 可以自动转为`double`,反之不行,需要用`(int)`来强转类型

常数变量 用`final`修饰词来修饰,变量名一般用全大写

`a++` `++a`的差别

三元运算符

```java
double k = 2.3
int c = (int)k

int score = 58
String mark = score >= 60 ? "及格" : "不及格"
```

## 流程控制

**if**

- if后面的判断式要用括号括起来
- if后面括号里条件判断式的值必须为布尔型
- 要执行的代码块如果只有一行可以不用中括号括起来.
- 字符串变量的一个方法`equals`
- 可以配合`else`使用,可以嵌套使用



**switch**

```java
public class HelloWorld {
    public static void main(String[] args) {
		char today='日';
		switch(today){
		    case '日':
		        System.out.println("吃主席套餐");
		    case '八':
		        break;
		    default:
		        System.out.println("罗森");
		}
```

 case 匹配后，执行匹配块里的程序代码，如果没有遇见 **break **会继续执行下一个的 case 块的内容，直到遇到 break 语句或者 switch 语句块结束



**while**

pass

```java
public class HelloWorld {
    public static void main(String[] args) {
        
		int i = 1; // 代表 1 - 5 之间的数字
		// 当变量小于等于 5 时执行循环
		while (i<=5) {
			// 输出变量的值，并且对变量加 1，以便于进行下次循环条件判断
			System.out.println(i);
			i++;
		}
	}
}
```



**do…while**

```
public class HelloWorld {
    public static void main(String[] args) {
        
		int i = 1; // 代表 1 - 5 之间的数字
		// 当变量小于等于 5 时执行循环
		do{
			System.out.println(i);
			i++;
		}while (i<=5); 
	}
}
```

`while(判断条件);`分号不能漏了



**for**

`for(i=0;i<10;i++)`

`循环变量初始化;循环条件;循环变量变化`

**break continue**





## 数组

数组的使用

- 声明
- 分配空间(指定数组长度)
  - 声明和分配空间可以合并
- 赋值
  - 在声明数组的同时赋值时不能指定数组长度

声明方式:

```java
//法1:
数据类型[] 数组名
数组名 = new 数据类型[数组长度]

// 法2:
数据类型[] 数组名 = new 数据类型[数组长度]
//后面再另外赋值
  
// 定义一个长度为5的字符串数组，保存考试科目信息
String[] subjects = new String[5];

// 分别为数组中的元素赋值
subjects[0] = "Oracle";
subjects[1] = "PHP";
subjects[2] = "Linux";
subjects[3] = "Java";
subjects[4] = "HTML";
  
// 法3
数据类型[] 数组名 = new 数据类型[] 数组
//e.g.
int[] scores = new int[]{90,68,89,99};
//可以简写为
int[] scores = {90,68,89,99};
```



```java
import java.util.Arrays;

public class HelloWorld {

    public static void main(String[] args) {

        // 定义一个整型数组，保存成绩信息
        int[] scores = { 89, 72, 64, 58, 93 };

        // 对Arrays类对数组进行排序
        Arrays.sort(scores);

        //用下标遍历数组
        int i;
        for(i=0;i<scores.length;i++)
            System.out.println(scores[i]);

        System.out.println("#####");

        // 使用foreach遍历输出数组中的元素
        for (int score : scores) {
            System.out.println(score);
        }

        System.out.println(scores);
        System.out.println(Arrays.toString(scores));

    }
}
```

- 要打印数组的内容时,要使用`Arrays.toString(数组变量名)`方法.直接打印数组,结果是数组地址:类似这样`[I@60e53b93`
- `foreach`的正确使用方式:`for(int age:ages)`,中间是冒号



### 二维数组



**声明**

```java
// 声明并分配空间
数据类型[][] 数组名 = new 数据类型[行的个数][列的个数];
// or
数据类型[][] 数组名;
数组名= new 数据类型[行的个数][列的个数];

//赋值
数组名[行的索引][列的索引] = 值;

```





**需要了解的：**在定义二维数组时也可以只指定行的个数，然后再为每一行分别指定列的个数。如果每行的列数不同，则创建的是不规则的二维数组

```java
int[][] num=new int;
num[0]=new int[2];
num[1]=new int[3];
num[2]=new int[4];
```



## 方法



### 如何定义Java中的方法

```
访问修饰符 返回值类型 方法名(参数列表){
  方法体
}
```

- 访问修饰符:方法被访问的权限范围,可以是`public` `preotected` `private`甚至可以忽略,其中`public`表示该方法可以被其他任何代码调用.
- 返回值类型:不返回任何值,则返回值类型指定为void
- 方法名:
- 参数列表:多个参数以逗号隔开,每个参数由参数类型和参数名组成,以空格隔开.



**无参,无返回值**

```java
public class HelloWorld {

    public static void main(String[] args) {
        // 创建对象，对象名为hello
        // 声明,赋值(实例化).类的实例化用new关键词
        HelloWorld hello = new HelloWorld();

        // 调用方法
        hello.showMyLove();
    }

    /*
     * 定义无参无返回值的方法
     */
    public void showMyLove() {
        System.out.println("Hello World!");
    }
}

```



**无参,有返回值**

```java
public class HelloWorld {

    public static void main(String[] args) {

        // 创建名为hello的对象
        HelloWorld hello = new HelloWorld();

        // 调用hello对象的calcAvg()方法，并将返回值保存在变量avg中
        double avg = hello.calcAvg();

                System.out.println("平均成绩为：" + avg);
    }

    // 定义一个返回值为double类型的方法
    public double calcAvg() {

        double java = 92.5;
        double php = 83.0;
        double avg = (java + php) / 2; // 计算平均值

        // 使用return返回值
        return avg;

    }
}
```



**带参,无返回值**

```java
public class HelloWorld {
    public static void main(String[] args) {

        // 创建对象，对象名为hello
        HelloWorld hello = new HelloWorld();

        // 调用方法，传入两门课程的成绩
        hello.calcAvg(94, 81);
    }

	/*
	 * 功能：计算两门课程考试成绩的平均分并输出平均分
	 * 定义一个包含两个参数的方法，用来传入两门课程的成绩
	 */
	public void calcAvg(int score1, int score2){
	    double avg;
	    avg = (score1+score2)/2.0;
	    System.out.format("平均分:%3.1f\n", avg);
	    System.out.println(avg);
    }
}
```





**带参,有返回值**

```java
import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {
        HelloWorld hello = new HelloWorld();
        int[] scores={79,52,98,81};

        //调用方法，传入成绩数组，并获取成绩的个数
        int count= hello.sort(scores);

        System.out.println("共有"+count+"个成绩信息！");
    }

    /*
     * 功能：将考试成绩排序并输出，返回成绩的个数
     * 定义一个包含整型数组参数的方法，传入成绩数组
     * 使用Arrays类对成绩数组进行排序并输出
     * 方法执行后返回数组中元素的个数
     */
    public int sort(int[] scores){
        Arrays.sort(scores);
        System.out.println(Arrays.toString(scores));

        //返回数组中元素的个数
        return scores.length;

    }
}
```



### Java中方法的重载

含义:如果同一个类中包含了两个或两个以上方法名相同,方法的参数的个数,顺序或类型不同的方法,则称为方法的重载,也可称该方法被重载了.

当调用被重载的方法时,Java会根据参数的个数和类型来判断应该调用哪个重载方法,参数完全匹配的方法将被执行.



**判断方法重载的依据：**

1、 必须是在同一个类中

2、 方法名相同

3、 参数的个数、顺序或类型不同

4、 与方法的修饰符或返回值没有关系



```java
public class HelloWorld {
    public static void main(String[] args) {

        // 创建对象
        HelloWorld hello = new HelloWorld();

        // 调用无参的方法
        hello.print();
        
        // 调用带有一个字符串参数的方法
        hello.print("aaa");

        // 调用带有一个整型参数的方法
        hello.print(26);
    }

    public void print() {
        System.out.println("无参的print方法");
    }

    public void print(String name) {
        System.out.println("带有一个字符串参数的print方法，参数值为：" + name);
    }

    public void print(int age) {
        System.out.println("带有一个整型参数的print方法，参数值为：" + age);
    }
}
```



```
public class HelloWorld {
    public static void main(String[] args) {

        // 创建对象
        HelloWorld hello = new HelloWorld();

        // 调用无参的方法
        hello.print();
        
        // 调用带有一个字符串参数的方法
        hello.print("aaa");

        // 调用带有一个整型参数的方法
        hello.print(26);
    }

    public void print() {
        System.out.println("无参的print方法");
    }

    public void print(String name) {
        System.out.println("带有一个字符串参数的print方法，参数值为：" + name);
    }

    public void print(int age) {
        System.out.println("带有一个整型参数的print方法，参数值为：" + age);
    }
}
```





___



## 类和对象

### 什么是类和对象

类是模子,确定对象将会拥有的特征(属性)和行为(方法)



**类的特点**

类是对象的类型

具有相同属性和方法的一组对象的集合



- 属性:对象具有的各种特征;每个对象的每个属性都拥有特定值.
- 方法:对象执行的操作.



### 如何使用Java中的对象

```java
public class Telphone {
    //属性
    float screen;
    float cpu;
    float mem;
    //方法
    void call(){
        System.out.println("calling");
    }

    void sendMessage(){
        System.out.format("screen:%f cpu:%f mem:%f is sending\n", screen,cpu,mem);
    }
}
```



```java
public class InitailTelphone {
    public static void main(String[] args){
        Telphone phone = new Telphone();
        phone.sendMessage();
        //给实例变量赋值
        phone.screen = 5.0f;
        phone.cpu = 1.4f;
        phone.mem = 2.0f;
        phone.sendMessage();
    }
}
```

执行结果如下:

```java
screen:0.000000 cpu:0.000000 mem:0.000000 is sending
screen:5.000000 cpu:1.400000 mem:2.000000 is sending

Process finished with exit code 0
```

成员变量未赋值情况下,数值类型的初始值为0.



### 成员变量和局部变量

- 局部变量只能在方法内部使用
- 局部变量不会有初始值
- 局部变量会覆盖成员变量(就近原则)





### 构造方法

1.使用new+构造方法 创建一个新的对象

2.构造方法是用来初始化对象的方法

3.分为有参和无参

4.当没有构造方法时,系统会自动添加一个无参的构造方法.

### static

static(静态)修饰的成员称为静态成员或类成员.它属于整个类所有而不是某个对象所有,即被类的所有对象所共享.静态成员可以使用类名直接访问,也可以使用对象进行访问.鉴于他作用的特殊性更推荐用类名访问.



static 可以修饰变量、方法和代码块



**注意**:静态成员属于整个类,当系统第一次使用该类是,就会为其分配内存空间直到该类被卸载才会进行资源回收.

#### 静态变量

```java
public class HelloWorld {

    // 定义静态变量，保存班级名称
    static String className = "JAVA开发一班";

    public static void main(String[] args) {

        // 访问静态变量，输出班级名称
        System.out.println(className);
    }
}
```



#### 静态方法

- 静态方法可以直接调用同类中的静态成员,但不能直接调用非静态成员,需要通过创建对象来访问非静态变量.
- 在普通成员方法中,则可以直接访问同类的非静态变量和静态变量
- 静态方法中可以调用静态方法,但不能直接调用非静态方法,需要通过对象来访问非静态方法.



```java
public class HelloWorld {

    // 定义静态变量score1
    static int score1 = 86;
    // 定义静态变量score2
    int score2 = 92;

    // 定义静态方法sum，计算成绩总分，并返回总分
    public   static int sum() {
        HelloWorld hello = new HelloWorld();
        return score1+ hello.score2 ;
    }
	//main也是静态方法.
    public static void main(String[] args) {

        // 调用静态方法sum并接收返回值
        int allScore = HelloWorld.sum();

        System.out.println("总分：" + allScore);
    }
}
```





#### 静态初始化块

在类的声明中,可以包含多个初始化块,当创建类的实例是,就会一次执行这些代码块.如果用`static`修饰就是静态初始化块.



需要特别注意：**静态初始化块只在类加载时执行，且只会执行一次，同时静态初始化块只能给静态变量赋值，不能初始化普通的成员变量**。



```java
public class HelloWorld {

    String name; // 声明变量name
    String sex; // 声明变量sex
    static int age;// 声明静态变量age

    // 构造方法
    public HelloWorld() {
        System.out.println("通过构造方法初始化name");
        name = "tom";
    }

    // 初始化块
    {
        System.out.println("通过初始化块初始化sex");
        sex = "男";
    }

    static {
        System.out.println("通过静态初始化块初始化age");
        age = 20;
    }

    public void show() {
        System.out.println("姓名：" + name + "，性别：" + sex + "，年龄：" + age);
    }

    public static void main(String[] args) {

        // 创建对象
        HelloWorld hello = new HelloWorld();
        // 调用对象的show方法
        hello.show();
      
      	HelloWorld hello2 = new HelloWorld();

    }
}
```

执行结果如下

```shell
通过静态初始化块初始化age
通过初始化块初始化sex
通过构造方法初始化name
姓名：tom，性别：男，年龄：20
通过初始化块初始化sex
通过构造方法初始化name
```



执行顺序如下

1. 静态初始化块
2. 初始化块
3. 构造方法

由于静态初始化块只会执行一次,再次创建hello2时并未执行静态初始化块.





## 封装

- **概念**:将类的某些信息隐藏在类内部,不允许外部程序直接访问,而是通过该类提供的方法来实现对隐藏信息的操作和访问.


- **好处**:

  - 只能通过规定大方法访问数据
  - 隐藏类的实例细节,方便修改和实现

- 实现步骤

  - 修改属性的可见性(private)
  - 创建getter/setter方法,用于属性的读写
  - 在getter/setter方法中加入属性控制语句,对属性的合法值进行判断

  ​

### 使用包管理Java中的类

1. 包的作用:

- 管理Java文件
- 解决同名文件冲突



2. 定义包:package包名,点号隔开,必须在文件的第一行.



3. 系统中的包:

   java.(功能).(类)      

   java.lang.(类)         包含java语言基础的类

   java.util.(类)           包含java语言中各种工具类

   java.io.(类)              包含输入、输出相关功能的类



4. 包的使用
   - import
   - 包的命名规范是全小写字母拼写
   - `import com.imooc,music.*`

### 访问修饰符



![111.png](https://ooo.0o0.ooo/2017/06/01/592f473dea657.png)



### this关键词



### 内部类

什么是内部类?

定义在另外一个类里面的类.与之对应,包含内部类的类被称为外部类.



内部类的作用:

- 提供了更好的封装,可以把内部类隐藏在外部类之内,不允许同一个包中的其他类访问该类.
- 内部类的方法可以直接访问外部类的所有数据,包括私有的数据.
- 外部类所实现的功能使用外部类同样可以实现,只是有时使用内部类更方便
- 内部类有以下几种:
  - 成员内部类
  - 静态内部类
  - 方法内部类
  - 匿名内部类



```java
//外部类HelloWorld
public class HelloWorld {

    // 内部类Inner，类Inner在类HelloWorld的内部
    public class Inner {

        // 内部类的方法
        public void show() {
            System.out.println("welcome to imooc!");
        }
    }

    public static void main(String[] args) {

        // 创建外部类对象
        HelloWorld hello = new HelloWorld();
        // 创建内部类对象
        Inner i = hello.new Inner();
        // 调用内部类对象的方法
        i.show();
    }
}
```



#### 成员内部类

- 相当于外部类的一个成员变量的位置,可以使用任意访问控制符
- 可以直接访问外部类中的数据,而不受控制符的影响
- 定义了成员内部类后,必须使用外部类对象来创建内部类对象,而不能直接去new一个外部类对象.即:`内部类 对象名 = 外部类对象.new 内部类()`
- 编译会多个.class文件
- 外部类不能直接使用内部类的成员和方法,可以用听过内部类的对象来访问其成员变量和方法.
- 重名时,内部类默认访问自己的成员变量和方法,可以使用`外部类名.this.变量名`来访问外部类的成员变量



```java
public class HelloWorld{

    //外部类的私有属性name
    private String name = "imooc";

    //外部类的成员属性
    int age = 20;

    //成员内部类Inner
    public class Inner {
        String name = "爱慕课";
        //内部类中的方法
        public void show() {
            System.out.println("外部类中的name：" + HelloWorld.this.name);
            System.out.println("内部类中的name：" + name);
            System.out.println("外部类中的age：" + age);
        }
    }

    //测试成员内部类
    public static void main(String[] args) {

        //创建外部类的对象
        HelloWorld o = new HelloWorld ();

        //创建内部类的对象
        Inner inn = o.new Inner();

        //调用内部类对象的show方法
        inn.show();
    }
}

```





#### 静态内部类

静态内部类是static修饰的内部类

- 不能直接访问外部类的非静态成员,但是可以通过`new 外部类().成员`的方式访问
- 如果外部类的静态成员和内部类的成员名称相同,通过`类名.静态成员`访问外部类的静态成员;如果不同,则可以通过`成员名`直接调用外部类的静态成员
- 创建静态内部类的 对象是,不需要外部类的对象,可以直接创建 `内部类 对象名=new 内部类()`;

```java
//外部类
public class HelloWorld {

    // 外部类中的静态变量score
    private static int score = 84;

    // 创建静态内部类
    public static  class SInner {
        // 内部类中的变量score
        int score = 91;

        public void show() {
            System.out.println("访问外部类中的score：" + HelloWorld.score);
            System.out.println("访问内部类中的score：" + score);
        }
    }

    // 测试静态内部类
    public static void main(String[] args) {
        // 直接创建内部类的对象
        SInner si = new SInner();
        // 调用show方法
        si.show();
    }
}
```



**区别**

- 访问外部类变量的权限不同


- 重名时,访问外部变量的方式
- 实例化的方式



#### 方法内部类

方法内部类就是内部类定义在外部类的方法中,方法内部类只在该方法的内部可见.

方法内部类不能使用访问控制符和static修饰符

```java
//外部类
public class HelloWorld {

    private String name = "爱慕课";

    // 外部类中的show方法
    public void show() {
        // 定义方法内部类
        class MInner {
            int score = 83;
            public int getScore() {
                return score + 10;
            }
        }

        // 创建方法内部类的对象
        MInner mo = new MInner();

        // 调用内部类的方法
        int newScore = mo.getScore();
        System.out.println("姓名：" + name + "\n加分后的成绩：" + newScore);
    }

    // 测试方法内部类
    public static void main(String[] args) {

        // 创建外部类的对象
        HelloWorld mo = new HelloWorld();

        // 调用外部类的方法
        mo.show();
    }
}
```





#### 匿名内部类

pass





## 继承

`is a`

Java是单继承,一个人只有一个亲爹.

`extends`关键词



**方法重写**

子类重写父类的方法,方法名,参数,返回值必须完全一样.



初始化相当于执行类的构造方法.

继承的 初始化顺序:

1. 初始化父类再初始化子类
2. 先执行初始化对象中属性,再执行构造方法中的初始化.



**final**

final关键字可以修饰类、方法、属性和变量

- 修饰类,则该类不允许被继承
- 修饰方法,则该方法不允许被覆盖(重写)
- 修饰属性,则该类的属性不会进行隐式的初始化(不是默认值而是一定要有值)或在构造方法中赋值(但只能选其一)
- 修饰变量,则为常量



**super**

子类通过super关键词可以调用父类对象的属性和方法

```java
super.age
super.eat()
```



子类的构造过程中必须调用其父类的构造方法.

在子类的构造方法的第一行会隐式地包含一个`super();`

若没有显示地调用父类的构造方法,系统默认调用父类的无参的构造方法.此时父类没有无参的构造方法,就会报错.



### object类

老祖宗

object的重要方法:

- `toString()`方法:返回对象的哈希code码(对象地址字符串)
- `equals()`方法,两个对象是否指向同一块内存地址

```java
public class Animal {
    int age = 20;
    public static void eat(){
        System.out.println("animal eats");
    }
}
```

重写`toString()`和`equals()`方法

```java
public class Dog extends Animal {
    public static void eat(){
        System.out.println("dog eats");
    }

    @Override
    public String toString() {
        return "Dog{age:" +age+ "}";
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(obj==null)
            return false;
        if ((getClass()!=obj.getClass()))
            return false;
        Dog other = (Dog) obj;
        if(age!=other.age)
            return false;
        return true;
    }
}

```



## 多态

对象的多种形态

1. 引用多态
   - 父类的引用可以指向本类的对象
   - 父类的引用可以指向子类的对象
   - 子类的引用不能指向父类的对象



![222.png](https://ooo.0o0.ooo/2017/06/01/592fb5d665e94.png)

2. 方法多态
   - 父类的引用如果指向子类的对象,那重名方法会被子类方法覆盖
   - but不能使用,子类独有的方法.

![333.png](https://ooo.0o0.ooo/2017/06/01/592fb7beeeaec.png)





### 引用类型转换

1. 向上类型转换(隐式/自动类型转换),小类型到大类型,子类到父类
2. 向下类型转换(强制类型转换),大类型到小类型,父类到子类
3. instance运算符





### 抽象类

约束子类必须有哪些方法,不关注实现.





### 接口

规范,约束类

`interface` 关键字

只有常量和抽象方法

一个类可以实现一个或多个接口,`implements`关键词







## UML



常用UML图

- 用例图,角色和功能
- 序列图,角色和系统中对象的交互
- 类图,结构性信息,业务逻辑



UML 建模工具

- Visio(MS)
- Rational Rose(IBM)
- PowerDesigoner