# Type Conversion in Java

Type conversion is the process of converting a value of one data type into another data type. In Java, type conversion is categorized into two main groups:
1. **Primitive Type Conversion** (Widening, Narrowing, and Promotion)
2. **Reference Type Conversion** (Upcasting and Downcasting)


## 1️⃣ Widening Type Conversion (Implicit Casting)

Widening conversion occurs automatically when a value of a smaller primitive data type is assigned to a variable of a larger primitive data type. 

### Key Characteristics
* **Automatic:** Done by the Java compiler (no special syntax required).
* **Safe:** No loss of data or precision (except some loss of precision when converting `long` to `float` or `double`).
* **Direction:** Converting from a smaller memory footprint to a larger memory footprint.

### Widening Path
The automatic conversion path is as follows:
```text
byte ──> short ──┐
                 ├──> int ──> long ──> float ──> double
          char ──┘
```

> [!NOTE]
> Even though `char` and `short` both occupy 2 bytes of memory, automatic conversion is **not** possible between them. `char` is unsigned (0 to 65,535) while `short` is signed (-32,768 to 32,767). Thus, they cannot cover each other's ranges completely.

### Code Example
```java
public class WideningExample {
    public static void main(String[] args) {
        int intVal = 100;
        
        // Automatic conversion from int to long
        long longVal = intVal; 
        
        // Automatic conversion from long to double
        double doubleVal = longVal; 
        
        System.out.println("int value: " + intVal);         // Output: 100
        System.out.println("long value: " + longVal);       // Output: 100
        System.out.println("double value: " + doubleVal);   // Output: 100.0
    }
}
```

## 2️⃣. Narrowing Type Conversion (Explicit Casting)

Narrowing conversion occurs when a value of a larger primitive data type is assigned to a variable of a smaller primitive data type. 

### Key Characteristics
* **Manual:** Requires explicit type casting syntax: `(targetType) expression`.
* **Unsafe:** Can lead to data loss (truncation of decimal parts) or value wrap-around due to buffer overflow.

### Narrowing Path
The explicit conversion path is the reverse of widening:
```text
double ──> float ──> long ──> int ──> short / char ──> byte
```

### Code Example (Data Loss & Truncation)
```java
public class NarrowingExample {
    public static void main(String[] args) {
        double doubleVal = 99.99;
        
        // Explicit cast from double to int
        int intVal = (int) doubleVal; 
        
        System.out.println("Original double value: " + doubleVal); // Output: 99.99
        System.out.println("Truncated int value: " + intVal);      // Output: 99 (decimal part is lost)
    }
}
```

### Overflow and Wrap-around Calculation
When a value exceeds the maximum limit of the target type, it wraps around based on 2's complement representation.
```java
public class OverflowExample {
    public static void main(String[] args) {
        int val = 130;
        byte b = (byte) val;
        
        System.out.println("byte value: " + b); // Output: -126
    }
}
```

#### Why does `130` cast to `byte` become `-126`?
1. The integer `130` is represented in 32-bit binary as: 
   `00000000 00000000 00000000 10000010`
2. When cast to a `byte` (8-bit), the upper 24 bits are truncated, leaving:
   `10000010`
3. In Java, all numeric types are signed. The most significant bit of `10000010` is `1`, indicating a negative number.
4. Using 2's complement:
   * Invert the bits: `01111101`
   * Add 1: `01111110` (which is `126` in decimal)
   * Prepend the negative sign: `-126`


## 3️⃣ Numeric Promotion in Expressions

When performing arithmetic operations, Java automatically promotes the operands to a common compatible type before executing the operation.

### Promotion Rules
1. **Rule of `int`:** All `byte`, `short`, and `char` operands are promoted to `int` first.
2. **Rule of Dominance:** If any operand in the expression is `double`, the entire expression is promoted to `double`.
3. If not `double`, but one is `float`, the entire expression is promoted to `float`.
4. If not `float`, but one is `long`, the entire expression is promoted to `long`.

### Code Example (Common Compile Error)
```java
public class PromotionExample {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        
        // byte c = a + b; 
        // ❌ Compile-time error! 'a + b' is promoted to 'int'.
        
        // Correct way using explicit cast:
        byte c = (byte) (a + b); 
        System.out.println(c); // Output: 30
    }
}
```

## 4️⃣ Reference Type Casting (Object Casting)

Reference type casting happens between classes or interfaces that have an inheritance relationship (Parent-Child).

```text
       ┌──────────┐
       │  Animal  │  (Parent Class)
       └─────┬────┘
             │
       ┌─────▼────┐
       │   Dog    │  (Child Class)
       └──────────┘
```

### Upcasting (Implicit)
Casting a subclass reference to a superclass reference. It is always safe and happens automatically.
```java
Animal animal = new Dog(); // Upcasting (implicitly done)
```

### Downcasting (Explicit)
Casting a superclass reference back to a subclass reference. It must be done explicitly and carries runtime risks.
```java
Animal animal = new Dog();
Dog dog = (Dog) animal; // Downcasting (Explicit)
```

#### Risk: `ClassCastException`
If the actual object at runtime does not match the target subclass type, JVM throws a `ClassCastException`.
```java
Animal animal = new Animal();
Dog dog = (Dog) animal; // ❌ Throws ClassCastException at runtime
```

### Safe Downcasting Pattern
To avoid `ClassCastException`, use `instanceof` to verify the type before casting.

#### Classic Approach:
```java
if (animal instanceof Dog) {
    Dog dog = (Dog) animal;
    dog.bark();
}
```

#### Modern Approach (Java 16+ Pattern Matching for `instanceof`):
```java
if (animal instanceof Dog dog) {
    // Variable 'dog' is already cast and available inside this scope
    dog.bark();
}
```

## 5️⃣ String and Primitive Conversions

Unlike other languages, primitive types in Java cannot be cast directly to `String` using standard casting syntax. They require parsing or formatting helper methods.

### Converting Primitive to String
* **Using `String.valueOf()` (Recommended):**
  ```java
  int number = 42;
  String str = String.valueOf(number); // "42"
  ```
* **Using Wrapper Classes:**
  ```java
  String str2 = Integer.toString(number); // "42"
  ```
* **Using Concatenation:**
  ```java
  String str3 = number + ""; // "42" (Concatenation triggers conversion)
  ```

### Converting String to Primitive
* **Using `parseXxx()` methods (Returns primitive):**
  ```java
  String input = "123";
  int primitiveInt = Integer.parseInt(input); // 123
  ```
* **Using `valueOf()` methods (Returns wrapper object):**
  ```java
  Integer wrapperInt = Integer.valueOf(input); // Integer object containing 123
  ```

> [!WARNING]
> If the string format is invalid (e.g. `Integer.parseInt("abc")`), Java will throw a `NumberFormatException` at runtime.


## 6️⃣ Type Casting vs. Type Conversion vs. Parsing

| Feature | Widening (Implicit Conversion) | Narrowing (Explicit Casting) | Parsing / Wrapper Conversions |
| :--- | :--- | :--- | :--- |
| **How it's done** | Automatically by Compiler | Manually by Programmer | Manually via Helper Methods |
| **Compatible Types** | Yes (Compatible Primitives) | Yes (Compatible Primitives) | No (Incompatible types e.g. String to int) |
| **Data Safety** | 100% Safe | Danger of Data Loss / Wrap-around | Throws Exception on invalid input format |
| **Example** | `double d = 10;` | `int i = (int) 10.5;` | `int i = Integer.parseInt("10");` |

---

## 7. Frequently Asked Interview Questions

### Q1: Why does `float f = 3.14;` result in a compilation error?
**Answer:** By default, any fractional literal in Java is treated as a `double` (8 bytes). Assigning a `double` to a `float` (4 bytes) is a narrowing conversion and requires an explicit cast or suffix:
```java
float f1 = (float) 3.14; 
float f2 = 3.14f; // Recommended using the 'f' suffix
```

---

### Q2: What is the output of `System.out.println('A' + 1);`?
**Answer:** The output is `66`. 
The `+` operator triggers **numeric promotion**. The `char` literal `'A'` is promoted to `int` (its ASCII/Unicode value `65`) before being added to `1`.

---

### Q3: Explain why `b = b + 1;` fails but `b += 1;` compiles when `b` is a `byte`.
**Answer:** 
1. In `b = b + 1;`, the literal `1` is an `int`. The addition `b + 1` promotes `b` to `int`, resulting in an `int` sum. Assigning this back to `byte b` requires explicit casting: `b = (byte) (b + 1);`.
2. The compound assignment operator `+=` has an **implicit cast** built in. `b += 1` is evaluated by the compiler as `b = (byte) (b + 1)`.

---

### Q4: Does Java support downcasting of objects automatically?
**Answer:** No. Downcasting is unsafe because a parent reference might not point to the expected child type at runtime. Therefore, downcasting must always be explicitly performed by the programmer. 

---

### Q5: What is the result of casting a negative float value to a char?
```java
float f = -5.5f;
char c = (char) f;
```
**Answer:** `char` is an unsigned 16-bit type (range `0` to `65535`). Casting `-5.5f` to `char` first truncates it to `int` `-5`. The bit representation of `-5` is then interpreted as a 16-bit unsigned value, resulting in `65531` (`'\uFFFb'`).