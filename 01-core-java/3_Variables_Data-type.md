# Java Variables and Data Types


## 1. Introduction

Variables and data types are fundamental concepts in Java. A variable is used to store data, while a data type defines what kind of data can be stored and how much memory it occupies.

## 2. What is a Variable?

A variable is a named memory location used to store data that can change during program execution.

### Syntax

```java
dataType variableName = value;
```

### Example

```java
int age = 25;
String name = "Vinod";
double salary = 50000.50;
```


## 3. Rules for Declaring Variables

### Valid Variable Names

```java
int age;
String firstName;
double accountBalance;
```

### Invalid Variable Names

```java
int 1age;       // Cannot start with a number
int first-name; // Hyphen not allowed
int class;      // Reserved keyword
```

### Naming Conventions

Use camelCase:

```java
int studentAge;
String employeeName;
double totalAmount;
```

## 4. Types of Variables

### Local Variable

Declared inside a method and accessible only within that method.

```java
public class Main {
    public static void main(String[] args) {

        int age = 25;

        System.out.println(age);
    }
}
```


### Instance Variable

Declared inside a class but outside methods.

```java
class Student {

    String name = "Vinod";

}
```

Each object gets its own copy.


### Static Variable

Declared using the `static` keyword.

```java
class Student {

    static String college = "ABC College";

}
```

Shared among all objects of the class.

## 5. What is a Data Type?

A data type specifies:

* Type of data stored
* Memory size required
* Allowed operations

### Example

```java
int age = 25;
double price = 99.99;
char grade = 'A';
```

## 6. Primitive Data Types

Java provides 8 primitive data types.

| Data Type | Size    | Default Value | Example |
| --------- | ------- | ------------- | ------- |
| byte      | 1 byte  | 0             | 100     |
| short     | 2 bytes | 0             | 1000    |
| int       | 4 bytes | 0             | 50000   |
| long      | 8 bytes | 0L            | 100000L |
| float     | 4 bytes | 0.0f          | 10.5f   |
| double    | 8 bytes | 0.0d          | 20.75   |
| char      | 2 bytes | '\u0000'      | 'A'     |
| boolean   | 1 bit*  | false         | true    |

*Actual storage may vary depending on JVM implementation.

### Integer Types

### byte

```java
byte age = 25;
```

Range:

```text
-128 to 127
```

---

### short

```java
short population = 25000;
```

---

### int

Most commonly used integer type.

```java
int salary = 50000;
```

---

### long

Used for very large numbers.

```java
long distance = 9876543210L;
```

---

### Floating-Point Types

### float

```java
float price = 99.99f;
```

Must end with `f`.

---

### double

Default choice for decimal numbers.

```java
double amount = 9999.75;
```

---

## Character Type

Stores a single character.

```java
char grade = 'A';
```

```java
char symbol = '$';
```

---

## Boolean Type

Stores true or false.

```java
boolean isLoggedIn = true;
```

```java
boolean isAdmin = false;
```


## 7. Non-Primitive Data Types

Also called Reference Data Types.

Examples:

* String
* Array
* Class
* Interface
* Object


### String

Stores a sequence of characters.

```java
String name = "Vinod";
```


### Array

Stores multiple values of the same type.

```java
int[] numbers = {10, 20, 30, 40};
```


### Class Object

```java
Student student = new Student();
```


## 8. Type Casting

Type casting means converting one data type into another.



### Implicit Casting (Widening)

Smaller type → Larger type

```java
int num = 100;

double value = num;

System.out.println(value);
```

Output:

```text
100.0
```


### Explicit Casting (Narrowing)

Larger type → Smaller type

```java
double value = 99.99;

int num = (int) value;

System.out.println(num);
```

Output:

```text
99
```

Data loss may occur during narrowing.


## 9. Type Inference with var

Introduced in Java 10.

The compiler automatically determines the data type.

```java
var age = 25;
var name = "Vinod";
var salary = 50000.50;
```

Equivalent to:

```java
int age = 25;
String name = "Vinod";
double salary = 50000.50;
```

### Limitation

```java
var age;
```

Not allowed because a value must be assigned during declaration.


# 10. Interview Questions

### What is a variable?

A variable is a named memory location used to store data.

---

### How many primitive data types are available in Java?

Java provides 8 primitive data types.

---

### What is the difference between `float` and `double`?

`double` provides higher precision and uses 8 bytes, while `float` uses 4 bytes and requires the `f` suffix.

---

### What is type casting?

Type casting is the process of converting one data type into another.

---

### What is widening type casting?

Automatic conversion from a smaller data type to a larger data type.

Example:

```java
int num = 10;
double value = num;
```

---

### What is narrowing type casting?

Manual conversion from a larger data type to a smaller data type.

Example:

```java
double value = 99.99;
int num = (int) value;
```

---

### What is the difference between primitive and non-primitive data types?

Primitive data types store actual values, while non-primitive data types store references to objects.

---

### What is `var` in Java?

`var` allows the compiler to automatically infer the data type during variable declaration.