# GPT生成的习题

### **Questions**

#### **1. Add Two Numbers**
Use MSVC inline assembly to add two integers `a` and `b` and store the result in `sum`.

```c++
int a = 10, b = 20, sum;

__asm {
    mov ______, ______       // Load a into a register
    ______ eax, ______       // Perform addition
    mov ______, ______       // Store the result in sum
}
```

---

#### **2. Sum Elements of an Array**
Calculate the sum of all elements in `int array[4] = {1, 2, 3, 4};` and store the result in `sum`.

```c++
int array[4] = {1, 2, 3, 4};
int sum = 0;

__asm {
    lea esi, ______          // Load array address
    mov ______, ______       // Initialize the loop counter
    ______ eax, ______       // Clear the accumulator

loop_start:
    ______, [esi]            // Add current element to accumulator
    ______ esi, ______       // Move to the next element
    ______ ______            // Repeat until the counter reaches zero
    mov ______, ______       // Store the result in sum
}
```

---

#### **3. Swap Two Integers**
Swap the values of two integers `a` and `b`.

```c++
int a = 5, b = 10;

__asm {
    ______ eax, ______       // Load a into eax
    ______ ebx, ______       // Load b into ebx
    ______, ebx              // Swap ebx into a
    ______, eax              // Swap eax into b
}
```

---

#### **4. Find the Maximum Value in an Array**
Find the maximum value in the array `int array[5] = {1, 9, 3, 7, 5};` and store it in `max_val`.

```c++
int array[5] = {1, 9, 3, 7, 5};
int max_val = 0;

__asm {
    lea ______, ______       // Load array address
    mov ______, ______       // Initialize counter
    mov ______, ______       // Load the first element into the max value

find_max:
    ______ eax, [esi]        // Compare max value with current element
    ______ ______            // Jump if current element is smaller
    mov eax, ______          // Update max value
    ______ esi, ______       // Move to the next element
    ______ ______            // Continue loop
    mov ______, ______       // Store the maximum value in max_val
}
```

---

#### **5. Conditional Add or Subtract**
Perform `result = a + b` if `flag == 1`, otherwise perform `result = a - b`.

```c++
int a = 8, b = 3, flag = 1, result;

__asm {
    ______ eax, ______       // Load a into eax
    ______ ebx, ______       // Load b into ebx
    ______ flag, ______      // Compare flag with 1
    ______ do_add            // Jump to addition if flag == 1

do_sub:
    ______ eax, ______       // Perform subtraction
    ______ end_op            // Jump to the end

do_add:
    ______ eax, ______       // Perform addition

end_op:
    ______ result, ______     // Store the result in result
}
```

---

#### **6. Bubble Sort**
Sort `int array[4] = {4, 3, 2, 1};` in ascending order using bubble sort.

```c++
int array[4] = {4, 3, 2, 1};

__asm {
    lea ______, ______        // Load array address
    mov ______, ______        // Initialize the outer loop counter

outer_loop:
    mov ______, ______        // Initialize the inner loop counter

inner_loop:
    mov ______, [esi]         // Load the current element
    cmp ______, [esi + 4]     // Compare with the next element
    ______ no_swap            // Jump if no swap needed

    mov ______, [esi + 4]     // Load the next element
    mov [esi + 4], ______     // Swap elements
    mov [esi], ______

no_swap:
    ______ esi, ______        // Move to the next pair
    ______ ______             // Decrement inner loop counter
    ______ ______             // Repeat inner loop

    ______ esi, ______        // Reset pointer for outer loop
    ______ ______             // Decrement outer loop counter
    ______ ______             // Repeat outer loop
}
```

---

#### **7. Compute Factorial**
Compute the factorial of `n = 5` using MSVC inline assembly and store the result in `factorial`.

```c++
int n = 5, factorial;

__asm {
    ______ eax, ______        // Initialize result
    ______ ecx, ______        // Load n into counter

factorial_loop:
    ______ ecx                // Multiply result by counter
    ______ ecx                // Decrement counter
    ______ factorial_loop     // Repeat until counter is zero

    ______ factorial, ______   // Store the result in factorial
}
```

---

### **Answers**

#### **1. Add Two Numbers**
```asm
mov eax, a
add eax, b
mov sum, eax
```

#### **2. Sum Elements of an Array**
```asm
lea esi, array
mov ecx, 4
xor eax, eax
add eax, [esi]
add esi, 4
loop loop_start
mov sum, eax
```

#### **3. Swap Two Integers**
```asm
mov eax, a
mov ebx, b
mov a, ebx
mov b, eax
```

#### **4. Find the Maximum Value in an Array**
```asm
lea esi, array
mov ecx, 5
mov eax, [esi]
cmp eax, [esi + 4]
jge skip
mov eax, [esi + 4]
add esi, 4
loop find_max
mov max_val, eax
```

#### **5. Conditional Add or Subtract**
```asm
mov eax, a
mov ebx, b
cmp flag, 1
je do_add
sub eax, ebx
jmp end_op
add eax, ebx
mov result, eax
```

#### **6. Bubble Sort**
```asm
lea esi, array
mov ecx, 4
mov ebx, ecx
mov eax, [esi]
cmp eax, [esi + 4]
jle no_swap
mov edx, [esi + 4]
mov [esi + 4], eax
mov [esi], edx
add esi, 4
dec ebx
jnz inner_loop
sub esi, 16
dec ecx
jnz outer_loop
```

#### **7. Compute Factorial**
```asm
mov eax, 1
mov ecx, n
mul ecx
dec ecx
jnz factorial_loop
mov factorial, eax
```



### **Advanced Questions**

#### **1. Add Elements at Even Indices**
Calculate the sum of elements at even indices in the array `int array[6] = {1, 2, 3, 4, 5, 6};` and store it in `sum`.

```c++
int array[6] = {1, 2, 3, 4, 5, 6};
int sum = 0;

__asm {
    lea ______, ______       // Load array address
    mov ______, ______       // Initialize counter for array size
    xor ______, ______       // Clear accumulator

loop_start:
    add ______, ______       // Add element at current index
    add ______, ______       // Move to the next even index
    sub ______, ______       // Decrease counter by 2
    jnz ______              // Loop until counter is zero
    mov ______, ______       // Store the result in sum
}
```

---

#### **2. Reverse an Array**
Reverse the array `int array[5] = {1, 2, 3, 4, 5};` in place using MSVC inline assembly.

```c++
int array[5] = {1, 2, 3, 4, 5};

__asm {
    lea esi, ______         // Point to the start of the array
    lea edi, ______         // Point to the end of the array
    mov ecx, ______         // Calculate the number of swaps

reverse_loop:
    mov eax, ______         // Load the element from the start
    mov edx, ______         // Load the element from the end
    mov ______, edx         // Swap the start element with the end
    mov ______, eax         // Swap the end element with the start
    add esi, ______         // Move the start pointer forward
    sub edi, ______         // Move the end pointer backward
    loop ______            // Continue until all swaps are done
}
```

---

#### **3. Multiply Array Elements**
Multiply all elements in `int array[4] = {2, 3, 4, 5};` together and store the result in `product`.

```c++
int array[4] = {2, 3, 4, 5};
int product = 1;

__asm {
    lea esi, ______         // Load array address
    mov ecx, ______         // Initialize counter for array size
    mov eax, ______         // Initialize accumulator with 1

multiply_loop:
    imul ______, ______     // Multiply the accumulator with the current element
    add esi, ______         // Move to the next element
    loop ______            // Continue until counter reaches zero
    mov ______, ______      // Store the result in product
}
```

---

#### **4. Count Positive Numbers**
Count the number of positive integers in the array `int array[6] = {-1, 2, -3, 4, 5, -6};` and store it in `count`.

```c++
int array[6] = {-1, 2, -3, 4, 5, -6};
int count = 0;

__asm {
    lea esi, ______         // Load array address
    mov ecx, ______         // Initialize counter for array size
    xor ebx, ______         // Clear count register

count_loop:
    mov eax, ______         // Load the current element
    test ______, ______     // Check if the number is positive
    jle skip_increment      // Skip if not positive
    inc ______              // Increment the count

skip_increment:
    add esi, ______         // Move to the next element
    loop ______            // Continue until counter reaches zero
    mov ______, ______      // Store the count in count
}
```

---

#### **5. Find the Index of the First Negative Number**
Find the index of the first negative number in the array `int array[6] = {1, 2, -3, 4, 5, 6};` and store it in `index`.

```c++
int array[6] = {1, 2, -3, 4, 5, 6};
int index = -1;

__asm {
    lea esi, ______         // Load array address
    mov ecx, ______         // Initialize counter for array size
    xor edx, edx            // Clear index accumulator

find_negative:
    mov eax, ______         // Load the current element
    test ______, ______     // Check if the number is negative
    jns skip_update         // Skip if not negative
    mov edx, ______         // Update index
    mov ecx, ______         // Stop the loop
    jmp loop_end            // Exit loop

skip_update:
    add esi, ______         // Move to the next element
    dec edx                 // Increment index accumulator

loop_end:
    loop ______            // Continue until counter reaches zero
    mov ______, ______      // Store the index in index
}
```

---

#### **6. Compute Power**
Compute `base^exponent` where `base = 2` and `exponent = 3`, and store the result in `power`.

```c++
int base = 2, exponent = 3, power = 1;

__asm {
    mov eax, ______         // Initialize result to 1
    mov ebx, ______         // Load base
    mov ecx, ______         // Load exponent

power_loop:
    imul ______, ______     // Multiply result by base
    loop ______            // Decrement exponent and repeat
    mov ______, ______      // Store the result in power
}
```

---

### **Answers**

#### **1. Add Elements at Even Indices**
```asm
lea esi, array
mov ecx, 3
xor eax, eax
add eax, [esi]
add esi, 8
sub ecx, 1
jnz loop_start
mov sum, eax
```

#### **2. Reverse an Array**
```asm
lea esi, array
lea edi, array + 16
mov ecx, 2
reverse_loop:
mov eax, [esi]
mov edx, [edi]
mov [edi], eax
mov [esi], edx
add esi, 4
sub edi, 4
loop reverse_loop
```

#### **3. Multiply Array Elements**
```asm
lea esi, array
mov ecx, 4
mov eax, 1
multiply_loop:
imul eax, [esi]
add esi, 4
loop multiply_loop
mov product, eax
```

#### **4. Count Positive Numbers**
```asm
lea esi, array
mov ecx, 6
xor ebx, ebx
count_loop:
mov eax, [esi]
test eax, eax
jle skip_increment
inc ebx
skip_increment:
add esi, 4
loop count_loop
mov count, ebx
```

#### **5. Find the Index of the First Negative Number**
```asm
lea esi, array
mov ecx, 6
xor edx, -1
find_negative:
mov eax, [esi]
test eax, eax
jns skip_update
mov edx, 5
mov ecx, 1
jmp loop_end
skip_update:
add esi, 4
inc edx
loop_end:
loop find_negative
mov index, edx
```

#### **6. Compute Power**
```asm
mov eax, 1
mov ebx, base
mov ecx, exponent
power_loop:
imul eax, ebx
loop power_loop
mov power, eax
```

### **Questions with Functions**

#### **1. Calculate Factorial Using a Function**
Write a function `int factorial(int n)` that calculates the factorial of a number `n` using inline assembly.

```c++
int factorial(int n) {
    int result = 1;

    __asm {
        mov eax, ______         // Initialize result to 1
        mov ecx, ______         // Load n into the counter
    factorial_loop:
        ______ ______, ______   // Multiply result by the counter
        ______ ______           // Decrement the counter
        ______ ______           // Repeat until the counter is zero
        mov ______, ______      // Store the result in result
    }

    return result;
}
```

---

#### **2. Reverse an Array Using a Function**
Write a function `void reverse(int *array, int size)` that reverses the elements of an array in place using inline assembly.

```c++
void reverse(int *array, int size) {
    __asm {
        lea esi, ______         // Point to the start of the array
        lea edi, ______         // Point to the end of the array
        mov ecx, ______         // Calculate the number of swaps
    reverse_loop:
        mov eax, ______         // Load the element from the start
        mov edx, ______         // Load the element from the end
        mov ______, edx         // Swap the start element with the end
        mov ______, eax         // Swap the end element with the start
        add esi, ______         // Move the start pointer forward
        sub edi, ______         // Move the end pointer backward
        ______ ______           // Continue until all swaps are done
    }
}
```

---

#### **3. Find Maximum Using a Function**
Write a function `int find_max(int *array, int size)` that finds the maximum value in an array using inline assembly.

```c++
int find_max(int *array, int size) {
    int max_val;

    __asm {
        lea esi, ______         // Load array address
        mov ecx, ______         // Load size into the counter
        mov eax, ______         // Initialize max_val to the first element
    find_max_loop:
        cmp eax, ______         // Compare max_val with the current element
        jge ______              // Skip if max_val >= current element
        mov eax, ______         // Update max_val
        add esi, ______         // Move to the next element
        ______ ______           // Continue until all elements are processed
        mov ______, eax         // Store the result in max_val
    }

    return max_val;
}
```

---

#### **4. Count Positive Numbers Using a Function**
Write a function `int count_positive(int *array, int size)` that counts the number of positive numbers in an array using inline assembly.

```c++
int count_positive(int *array, int size) {
    int count = 0;

    __asm {
        lea esi, ______         // Load array address
        mov ecx, ______         // Load size into the counter
        xor ebx, ______         // Clear the count
    count_positive_loop:
        mov eax, ______         // Load the current element
        test ______, ______     // Check if the number is positive
        jle skip_increment      // Skip if the number is not positive
        inc ______              // Increment the count
    skip_increment:
        add esi, ______         // Move to the next element
        ______ ______           // Continue until all elements are processed
        mov ______, ebx         // Store the count in count
    }

    return count;
}
```

---

#### **5. Compute Power Using a Function**
Write a function `int power(int base, int exponent)` that calculates `base^exponent` using inline assembly.

```c++
int power(int base, int exponent) {
    int result = 1;

    __asm {
        mov eax, ______         // Initialize result to 1
        mov ebx, ______         // Load base
        mov ecx, ______         // Load exponent
    power_loop:
        ______ eax, ebx         // Multiply result by base
        ______ ______           // Decrement exponent
        ______ ______           // Repeat until exponent is zero
        mov ______, eax         // Store the result in result
    }

    return result;
}
```

---

### **Answers**

#### **1. Calculate Factorial Using a Function**
```asm
mov eax, 1
mov ecx, n
mul eax, ecx
dec ecx
jnz factorial_loop
mov result, eax
```

---

#### **2. Reverse an Array Using a Function**
```asm
lea esi, array
lea edi, array + size * 4 - 4
mov ecx, size / 2
mov eax, [esi]
mov edx, [edi]
mov [edi], eax
mov [esi], edx
add esi, 4
sub edi, 4
loop reverse_loop
```

---

#### **3. Find Maximum Using a Function**
```asm
lea esi, array
mov ecx, size
mov eax, [esi]
cmp eax, [esi + 4]
jge skip
mov eax, [esi + 4]
add esi, 4
loop find_max_loop
mov max_val, eax
```

---

#### **4. Count Positive Numbers Using a Function**
```asm
lea esi, array
mov ecx, size
xor ebx, ebx
mov eax, [esi]
test eax, eax
jle skip_increment
inc ebx
skip_increment:
add esi, 4
loop count_positive_loop
mov count, ebx
```

---

#### **5. Compute Power Using a Function**
```asm
mov eax, 1
mov ebx, base
mov ecx, exponent
imul eax, ebx
dec ecx
jnz power_loop
mov result, eax
```

