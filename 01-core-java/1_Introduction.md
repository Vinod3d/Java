You can directly save this as `notes/01-core-java/01-introduction.md`.

# Java Introduction and History


## 1. Introduction to Java

Java is a high-level, object-oriented, and platform-independent programming language developed by Sun Microsystems. It is widely used for building desktop applications, web applications, enterprise systems, mobile applications, cloud services, and microservices.

Java follows the principle:

**"Write Once, Run Anywhere (WORA)"**

This means Java code can run on any device that has a Java Virtual Machine (JVM).


## 2. Why Java Was Created

Before Java, programs were generally platform-dependent. Software written for one operating system often could not run on another without modification.

The main goals behind Java were:

* Platform independence
* Simplicity
* Security
* Reliability
* Portability
* Object-oriented programming support


## 3. History of Java

| Year    | Event                                                     |
| ------- | --------------------------------------------------------- |
| 1991    | Project Green started by James Gosling and his team       |
| 1991    | Language initially named Oak                              |
| 1995    | Renamed to Java and officially released                   |
| 2006    | Java became open source                                   |
| 2010    | Oracle acquired Sun Microsystems                          |
| Present | Java is one of the most widely used programming languages |

### Important Contributors

* James Gosling (Father of Java)
* Mike Sheridan
* Patrick Naughton


## 4. Features of Java

#### 1. **Simple**:  Java syntax is easy to learn and use.
#### 2. **Object-Oriented**: Everything revolves around classes and objects.
#### 3. **Platform Independent**: Java programs can run on any operating system.
#### 4. **Secure**: Provides secure execution through JVM.
#### 5. **Robust**: Strong memory management and exception handling.
#### 6. **Multithreaded**: Supports executing multiple tasks simultaneously.
#### 7. **Portable**: Programs can be moved across different systems.
#### 8. **High Performance**: Uses Just-In-Time (JIT) compilation for faster execution.
#### 9. **Distributed**: Supports network-based applications.
#### 10. **Dynamic**: Can load classes dynamically at runtime.


## 5. Java Editions

### 1. Java SE (Standard Edition)

Used for:

* Desktop applications
* Core Java development

Examples:

* Banking software
* Management systems

### 2. Java EE / Jakarta EE

Used for:

* Enterprise applications
* Web applications
* Distributed systems

Examples:

* ERP systems
* E-commerce platforms

### 3. Java ME (Micro Edition)

Used for:

* Embedded systems
* IoT devices

Examples:

* Smart devices
* Embedded controllers

## 6. Java Architecture

Java Architecture consists of:

```text
Java Source Code (.java)
        ↓
Java Compiler (javac)
        ↓
Bytecode (.class)
        ↓
JVM
        ↓
Machine Code
        ↓
Output
```

The compiler converts source code into bytecode.

The JVM converts bytecode into machine code for execution.

## 7. JDK, JRE, and JVM

### 1. JVM (Java Virtual Machine)

The Java Virtual Machine (JVM) is the engine that drives Java applications by executing Java bytecode line by line. It is an abstract, platform-dependent engine that acts as a bridge, translating platform-independent bytecode into the native machine code of the host operating system. The JVM is also responsible for critical runtime services such as memory management, automated garbage collection, and system security checks. Because JVMs are custom-built for Windows, macOS, Linux, and other OS platforms, the same compiled Java class can run seamlessly anywhere.

### 2. JRE (Java Runtime Environment)

The Java Runtime Environment (JRE) is a software package that provides the minimum execution environment required to run Java applications on a machine. It physically bundles the Java Virtual Machine (JVM) with the core Java class libraries (like `java.lang`, `java.util`) and supporting runtime files. While JRE contains everything needed to launch and run already-compiled Java programs, it does not include any tools like compilers, debuggers, or profilers. If a user only wants to run a Java app without writing any code, they only need to install the JRE.

### 3. JDK (Java Development Kit)

The Java Development Kit (JDK) is a comprehensive software development package used by developers to create, compile, document, and debug Java programs. It is a superset that includes the JRE (which houses the JVM and runtime libraries) along with a suite of development tools such as the compiler (`javac`), debugger (`jdb`), and archiver (`jar`). If you are a developer looking to write code and compile `.java` files into `.class` files, you must install the JDK. In modern Java versions, the standalone JRE is no longer distributed separately, making the JDK the standard package for both development and execution.

### Relationship

```text
JDK
 └── JRE
      └── JVM
```

## 8. Java Program Execution Flow

### Step 1

Write source code:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Java");
    }
}
```

### Step 2

Compile program:

```bash
javac Main.java
```

Generates:

```text
Main.class
```

### Step 3

Run program:

```bash
java Main
```

### Step 4

JVM executes bytecode and displays output.


## 9. Applications of Java

Java is used in:

### 1. Web Development

* Spring Boot
* Hibernate

### 2. Enterprise Applications

* Banking systems
* ERP software

### 3. Mobile Applications

* Android development

### 4. Cloud Applications

* Cloud-native services

### 5. Microservices

* Distributed architectures

### 6. Big Data

* Hadoop ecosystem

### 7. Desktop Applications

* JavaFX
* Swing