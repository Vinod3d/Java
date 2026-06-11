# Operators in Java

Operators are special symbols that perform operations on variables and values.

## Types of Operators

1. Arithmetic Operators
2. Relational Operators
3. Logical Operators
4. Assignment Operators
5. Increment/Decrement Operators
6. Bitwise Operators
7. Conditional Operator
8. Instanceof Operator

## 1️⃣ Arithmetic Operators

| Operator | Description |
| :--- | :--- |
| `+` | Addition |
| `-` | Subtraction |
| `*` | Multiplication |
| `/` | Division |
| `%` | Modulus |

### Example
```java
int a = 10;
int b = 20;

System.out.println(a + b); // 30
System.out.println(a - b); // -10
System.out.println(a * b); // 200
System.out.println(a / b); // 0
System.out.println(a % b); // 10
```

## 2️⃣ Relational Operators

| Operator | Description |
| :--- | :--- |
| `==` | Equal to |
| `!=` | Not equal to |
| `>` | Greater than |
| `<` | Less than |
| `>=` | Greater than or equal to |
| `<=` | Less than or equal to |

### Example
```java
int a = 10;
int b = 20;

System.out.println(a == b); // false
System.out.println(a != b); // true
System.out.println(a > b);  // false
System.out.println(a < b);  // true
System.out.println(a >= b); // false
System.out.println(a <= b); // true
```

## 3️⃣ Logical Operators

| Operator | Description |
| :--- | :--- |
| `&&` | Logical AND |
| `||` | Logical OR |
| `!` | Logical NOT |

### Example
```java
boolean a = true;
boolean b = false;

System.out.println(a && b); // false
System.out.println(a || b); // true
System.out.println(!a);     // false
```

## 4️⃣ Assignment Operators

| Operator | Description |
| :--- | :--- |
| `=` | Assigns value |
| `+=` | Add and assign |
| `-=` | Subtract and assign |
| `*=` | Multiply and assign |
| `/=` | Divide and assign |
| `%=` | Modulus and assign |

### Example
```java
int a = 10;

a += 20; // a = a + 20 = 30
a -= 10; // a = a - 10 = 20
a *= 5;  // a = a * 5 = 100
a /= 2;  // a = a / 2 = 50
a %= 3;  // a = a % 3 = 2
```

## 5️⃣ Increment/Decrement Operators

| Operator | Description |
| :--- | :--- |
| `++a` | Pre-increment |
| `a++` | Post-increment |
| `--a` | Pre-decrement |
| `a--` | Post-decrement |

### Example
```java
int a = 10;

System.out.println(++a); // 11 (pre-increment)
System.out.println(a++); // 11 (post-increment)
System.out.println(--a); // 10 (pre-decrement)
System.out.println(a--); // 10 (post-decrement)
```

## 6️⃣ Bitwise Operators

| Operator | Description |
| :--- | :--- |
| `&` | Bitwise AND |
| `|` | Bitwise OR |
| `^` | Bitwise XOR |
| `~` | Bitwise NOT |
| `<<` | Left shift |
| `>>` | Right shift |

### Example
```java
int a = 10; // 1010
int b = 12; // 1100

System.out.println(a & b); // 8  (1000)
System.out.println(a | b); // 14 (1110)
System.out.println(a ^ b); // 6  (0110)
System.out.println(~a);    // -11
System.out.println(a << 1); // 20
System.out.println(a >> 1); // 5
```

## 7️⃣ Conditional Operator

Also known as ternary operator.

### Syntax
```java
condition ? expression1 : expression2;
```

### Example
```java
int a = 10;
int b = 20;

int result = (a > b) ? a : b;
System.out.println(result); // 20
```

## 8️⃣ Instanceof Operator

Checks if an object is an instance of a class.

### Syntax
```java
object instanceof ClassName
```

### Example
```java
String name = "Vinod";

System.out.println(name instanceof String); // true
```

## 9️⃣ Operator Precedence

| Operator | Precedence |
| :--- | :--- |
| `()` | Highest |
| `++`, `--`, `~`, `(type)` | High |
| `*`, `/`, `%` | Medium |
| `+`, `-` | Medium |
| `<<`, `>>` | Medium |
| `<`, `<=`, `>`, `>=` | Low |
| `==`, `!=` | Low |
| `&`, `^`, `|` | Low |
| `&&`, `||` | Low |
| `? :` | Low |
| `=`, `+=`, `-=` | Lowest |
