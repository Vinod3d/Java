# Java Conditional Statements

Conditional statements control the execution flow of a program based on boolean conditions. In technical interviews, examiners frequently test edge cases, type compatibility, modern Java enhancements (such as Switch Expressions and Pattern Matching), and under-the-hood JVM performance.


## 1️⃣ Introduction to Decision Making

Java provides three primary control-flow branching mechanisms:
1. **`if` / `if-else` / `if-else-if` / `nested if`** – Best for range-based, boolean-based, or complex multi-variable conditions.
2. **`switch`** – Best for single-variable matching against distinct, constant values.
3. **Ternary Operator (`? :`)** – A compact operator used to assign values based on a single condition 


## 2️⃣ The `if` Statement Family

### Syntax and Basic Forms

#### Single `if`
Executes a block of code if the expression evaluates to `true`.
```java
if (condition) {
    // executed if condition is true
}
```

#### `if-else`
Provides an alternative execution path.
```java
if (condition) {
    // executed if true
} else {
    // executed if false
}
```

#### `if-else-if` Ladder
Checks multiple conditions sequentially. Execution stops at the first `true` condition.
```java
if (condition1) {
    // ...
} else if (condition2) {
    // ...
} else {
    // executed if all conditions are false
}
```


### ⚠️ Critical Interview Tricky Points & Gotchas (if-else)

#### 1. The Strict Boolean Requirement
Unlike languages like C or C++ where any non-zero value is treated as `true`, **Java requires a strictly boolean expression** inside the `if` condition.

```java
int x = 5;

// ❌ COMPILE ERROR: Type mismatch: cannot convert from int to boolean
if (x) { 
    System.out.println("Hello");
}

//  CORRECT
if (x > 0) {
    System.out.println("Hello");
}
```

#### 2. Assignment vs. Comparison inside `if`
A classic interview trap is placing an assignment operator (`=`) instead of a relational comparison operator (`==`) inside an `if` statement.

```java
boolean flag = false;

// What happens here?
if (flag = true) {
    System.out.println("Flag is true");
} else {
    System.out.println("Flag is false");
}
// Output: "Flag is true" because (flag = true) assigns true to flag 
// and the entire expression evaluates to true!
```

> [!WARNING]
> This trap compiles **only** when the variable is of type `boolean`. If it were an integer, it would cause a compile-time error:
> ```java
> int num = 10;
> if (num = 5) { // ❌ Compile error: Cannot convert from int to boolean
>     // ...
> }
> ```

#### 3. Short-Circuit Evaluation
Java's logical operators `&&` (AND) and `||` (OR) evaluate conditions lazily.
* In `A && B`, if `A` is `false`, `B` is not evaluated.
* In `A || B`, if `A` is `true`, `B` is not evaluated.

```java
String str = null;

// This compiles and runs safely without NullPointerException:
if (str != null && str.length() > 5) {
    System.out.println("Long string");
}

// This throws a NullPointerException because both sides are evaluated:
if (str != null & str.length() > 5) {
    System.out.println("Long string");
}
```

#### 4. The Dangling Else Problem
When nested `if` statements are written without curly braces `{}`, an `else` block always associates with the **nearest preceding unresolved `if`**.

```java
int x = 10;
int y = 20;

if (x > 15)
    if (y > 15)
        System.out.println("Both greater than 15");
else
    System.out.println("Which if does this belong to?");
    
// Output: Absolutely nothing!
// The 'else' belongs to the nested 'if (y > 15)', not the outer 'if (x > 15)'.
```

* **Best Practice:** Always use braces `{}` to avoid readability bugs and logical errors.

## 3️⃣ Switch Statements: Traditional vs. Modern

The `switch` statement has undergone significant evolution in modern Java (Java 12, 14, 17, and 21). Interviewers frequently test your knowledge of these modern enhancements.

### Traditional Switch (Java 1.0 - 11)

```java
int day = 2;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday"); // Executed
        break;
    default:
        System.out.println("Other day");
}
```

#### Supported Types in Switch
Traditional switch expressions only accept:
* Primitive types: `byte`, `short`, `char`, `int`.
* Wrapper classes: `Byte`, `Short`, `Character`, `Integer`.
* String objects (introduced in Java 7).
* `enum` constants (introduced in Java 5).

> [!IMPORTANT]
> **Unsupported Types:** `long`, `float`, `double`, and `boolean` are **not** allowed.
> * `float`/`double` suffer from precision limitations making exact comparisons unreliable.
> * `long` is 64-bit; compiling switch statement labels into efficient bytecodes becomes complex with such a large range.
> * `boolean` is best handled by simple `if-else` blocks.

#### Switch Case Constants
Case labels must be **constant expressions** resolved at compile-time. They can be literals or variables marked `final`.

```java
int x = 10;
final int y = 20;
int key = 15;

switch (key) {
    case x: // ❌ Compile Error: Constant expression required
        break;
    case y: //  Allowed: y is a compile-time final constant
        break;
}
```

#### Fall-Through Behavior
If a `case` block does not end with `break`, the execution "falls through" and executes subsequent `case` blocks unconditionally until a `break` or the end of the switch is reached.



### Switch Expressions (Java 14+)

Java 14 standardizes switch expressions, allowing switch blocks to return values and eliminate verbosity.

#### Key Enhancements:
1. **Arrow Syntax (`->`):** Eliminates the need for a `break` statement. Only the expression or block to the right of the arrow is executed. No fall-through!
2. **Multiple Case Labels:** Combine cases using commas.
3. **Value Return:** A switch can be assigned directly to a variable.

```java
String day = "SATURDAY";
boolean isWeekend = switch (day) {
    case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> false;
    case "SATURDAY", "SUNDAY" -> true;
    default -> throw new IllegalArgumentException("Invalid day: " + day);
};
```

#### The `yield` Keyword
For multi-line statements in a switch expression, use a block `{}` and return the value using the `yield` keyword:

```java
int value = switch (key) {
    case 1 -> {
        System.out.println("Starting process...");
        yield 100; // Yield returns the value for case 1
    }
    case 2 -> 200;
    default -> 0;
};
```

#### Exhaustiveness Rule
Unlike switch *statements*, a switch *expression* **must be exhaustive**. The compiler must guarantee that a value is always returned. Typically, this requires a `default` case unless matching over an `enum` where all branches are explicitly defined.


### Pattern Matching for Switch (Java 21+)

Introduced as standard in Java 21, pattern matching allows `switch` to test objects against types, inspect nulls, and use guard conditions.

#### 1. Type Patterns
We can now switch on any Object and bind its type inline.

```java
public static String formatter(Object obj) {
    return switch (obj) {
        case Integer i -> String.format("Integer: %d", i);
        case String s  -> String.format("String: %s", s);
        case Double d  -> String.format("Double: %f", d);
        default        -> obj.toString();
    };
}
```

#### 2. Guard Clauses (`when`)
We can add additional boolean checks to our cases using the `when` clause.

```java
Object obj = 45;
switch (obj) {
    case Integer i when i > 0 -> System.out.println("Positive Integer");
    case Integer i -> System.out.println("Zero or Negative Integer");
    default -> System.out.println("Not an Integer");
}
```

#### 3. Safe Null Handling
Historically, passing `null` to a switch statement instantly threw a `NullPointerException`. In Java 21+, we can handle null directly within a case label.

```java
String s = null;
switch (s) {
    case null -> System.out.println("Safe! Handled a null reference.");
    case "Admin" -> System.out.println("Logged in as Admin");
    default -> System.out.println("User log");
}
```


## 4️⃣ Performance & Compilation: Under the Hood

### `switch` vs. `if-else-if`
In a long `if-else-if` ladder, the JVM must evaluate each expression sequentially ($O(N)$ time complexity).
In contrast, the compiler optimizes `switch` statements into JVM bytecodes using two special instructions, leading to $O(1)$ or $O(\log N)$ performance:

1. **`tableswitch`:** Used when case constants are dense/contiguous (e.g., `1, 2, 3, 4`). It indexes into a direct jump table. Complexity: $O(1)$.
2. **`lookupswitch`:** Used when case constants are sparse/non-contiguous (e.g., `10, 500, 10000`). It uses a binary search pattern over sorted keys. Complexity: $O(\log N)$.


## 5️⃣ High-Yield Interview Questions & Solutions

### Q1: What is the output of the following code?
```java
int a = 10;
if (a++ == 10 || ++a == 12) {
    a += 5;
}
System.out.println(a);
```
**Answer:** `16`
**Explanation:** 
1. `a++ == 10` is evaluated. Post-increment evaluates `a` at `10`, matching the condition (`10 == 10` is `true`). After this comparison, `a` becomes `11`.
2. Due to short-circuit evaluation (`||`), the second operand (`++a == 12`) is skipped entirely.
3. The block executes: `a += 5` -> `11 + 5 = 16`.
4. If short-circuiting were ignored, the output would incorrectly be calculated as `17`.

---

### Q2: Will this code compile successfully? If yes, what is the output?
```java
int x = 2;
switch (x) {
    case 1 -> System.out.println("One");
    case 2 -> {
        System.out.println("Two");
        yield 22; // ❌ Compile Error
    }
}
```
**Answer:** No, it results in a compile-time error.
**Explanation:** The keyword `yield` is only used inside **Switch Expressions** returning a value. Here, `switch` is used as a standard statement (not assigning its result to a variable), making `yield` invalid.

---

### Q3: What happens when the expression inside a traditional switch evaluates to `null`?
```java
String value = null;
switch (value) {
    case "test":
        System.out.println("Matched test");
        break;
    default:
        System.out.println("Default");
}
```
**Answer:** A `NullPointerException` is thrown at runtime on the line containing `switch (value)`.
**Explanation:** Prior to Java 21, the JVM automatically calls `.hashCode()` or evaluates the variable, throwing an exception if it's null. To fix this, write an explicit null check before the switch, or use Java 21's `case null`.

---

### Q4: Why can't float, double, or long be used as case constants in traditional switch?
**Answer:**
* **`float` and `double`:** Floating point values are represented using IEEE 754 binary fractions, making exact comparisons (`==`) unsafe due to rounding and precision limits (e.g. `0.1 + 0.2` might equal `0.30000000000000004`).
* **`long`:** A jump table (`tableswitch`) expects 32-bit values. Constructing a 64-bit jump table would require double the memory and degrade performance, neutralizing the core speed advantages of `switch`.

---

### Q5: Will the following code compile?
```java
if (false) {
    System.out.println("Unreachable code!");
}
```
**Answer:** Yes, it compiles without errors.
**Explanation:** While standard java compilers flag certain statements as unreachable (e.g., `while(false) {}` or post-return statement code), the `if (false)` condition is explicitly exempted to support compile-time conditional flag checking (often used by compilers for feature toggles or conditional debugging).

---

### Q6: What is the output of the following ternary expression?
```java
Object result = true ? 1 : 2.0;
System.out.println(result.getClass() + " : " + result);
```
**Answer:** `class java.lang.Double : 1.0`
**Explanation:** The ternary operator applies type numeric promotion. Because one potential result is `double` (`2.0`), the compiler promotes the int value (`1`) to double (`1.0`) so both expressions match a common type before auto-boxing the value into a `Double` object.

---

### Q7: Analyze this snippet. What does it print?
```java
int status = 1;
switch (status) {
    default:
        System.out.print("Default ");
    case 1:
        System.out.print("Active ");
    case 2:
        System.out.print("Suspended ");
}
```
**Answer:** `Active Suspended `
**Explanation:** Even though `default` is placed first, the program matches `case 1` first. Because there is no `break` statement at the end of `case 1`, execution falls through to execute `case 2` as well.

---

### Summary Checklist for Interviews
* [ ] Understand the strict boolean constraint of `if` blocks.
* [ ] Avoid using assignment `=` instead of comparison `==` inside conditions.
* [ ] Remember that logical `&&` and `||` leverage short-circuiting.
* [ ] Know the types supported by traditional switch vs. modern switch.
* [ ] Describe Switch Expressions (`->` arrow syntax, no fall-through, exhaustiveness, `yield`).
* [ ] Discuss Java 21 Pattern Matching features (`case null`, `when` guards).
* [ ] Explain the performance optimizations of `tableswitch` and `lookupswitch`.