# 02. Java Program Structure

## 1. Introduction of structure
Every Java program follows a specific structure. Understanding this structure is important because all Java applications, from simple programs to large enterprise systems, are built using the same basic components.

A Java program is mainly composed of:

* Package (optional)
* Import statements (optional)
* Class
* Methods
* Statements
* Comments

## 2. Basic Java Program

```java
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello Java");

    }

}
```

Output:

```text
Hello Java
```


## 3. Understanding Program Structure

```java
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello Java");

    }

}
```

### Breakdown

| Part                      | Purpose                 |
| ------------------------- | ----------------------- |
| public                    | Access modifier         |
| class                     | Defines a class         |
| Main                      | Class name              |
| public static void main() | Program entry point     |
| System.out.println()      | Prints output           |
| {}                        | Defines a block of code |
| ;                         | Ends a statement        |

---

## 4. Class Declaration

A Java program must contain at least one class.

Syntax:

```java
class ClassName {

}
```

Example:

```java
class Student {

}
```

### Why Classes?

Java is an Object-Oriented Programming (OOP) language.

Everything in Java is organized inside classes.

Examples:

```java
class Student { }

class Employee { }

class Product { }
```

## 5. Main Method

The JVM starts program execution from the main method.

Syntax:

```java
public static void main(String[] args) {

}
```

### Meaning of Each Keyword

#### public

Allows JVM to access the method from outside the class.

#### static

Allows the method to run without creating an object.

#### void

Indicates the method does not return any value.

#### main

Special method name recognized by JVM.

#### String[] args

Stores command-line arguments.

---

### Example

```java
public static void main(String[] args) {

    System.out.println("Program Started");

}
```


## 6. Statements and Blocks

### Statement

A statement is a single instruction.

Example:

```java
int age = 25;
```

```java
System.out.println(age);
```

Every statement ends with a semicolon (;).

### Block

A block is a group of statements enclosed within braces.

Example:

```java
{
    int a = 10;
    int b = 20;

    System.out.println(a + b);
}
```

Braces `{}` define the beginning and end of a block.

## 7. Comments in Java

Comments are used to explain code.

They are ignored by the compiler.


### Single-Line Comment

```java
// This is a comment
System.out.println("Java");
```

### Multi-Line Comment

```java
/*
This is
a multi-line comment
*/
```

### Documentation Comment

```java
/**
 * Author: Vinod
 * Description: First Java Program
 */
```

Used for generating project documentation.


## 8. Naming Conventions

Following naming conventions makes code easy to read and maintain.


### Class Names

Use PascalCase.

```java
class StudentManagement
```

```java
class EmployeeDetails
```

### Variable Names

Use camelCase.

```java
int studentAge;
```

```java
String firstName;
```

### Method Names

Use camelCase.

```java
calculateSalary();
```

```java
printDetails();
```

### Constants

Use UPPER_CASE.

```java
final double PI = 3.14;
```

```java
final int MAX_USERS = 100;
```


## 9. Program Execution Flow

### Step 1

Write source code.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Java");
    }
}
```

### Step 2

Compile source code.

```bash
javac Main.java
```

Compiler generates:

```text
Main.class
```

### Step 3

Run the program.

```bash
java Main
```

---

### Step 4

JVM loads bytecode.

---

### Step 5

JVM converts bytecode into machine code.

### Step 6

Output is displayed.

```text
Hello Java
```