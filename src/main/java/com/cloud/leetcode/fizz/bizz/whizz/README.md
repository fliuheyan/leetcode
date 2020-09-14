### Fizz Buzz Whizz

1. 3 -> fizz , 5 -> buzz, 7 -> whizz
2. 3*5 -> fizzbuzz, 3*7 -> fizzwhizz, 5 * 7 -> buzzwhizz , 3*5*7 -> fizzbuzzwhizz
3. replace 3 -> fizz
4. if contains 3 ignore 1 & 2 

### TDD

#### What is TDD

#### Why

#### How


### Refactor
Refactoring is used to improve code design to make it easier to understand and easy to 
maintain and extend.

### Bad Smells

* Duplicated Code

* Long method & Large Class

* Complex Conditional Statements

* Indecent Exposure


### Talking
Today let's use test driven development to solve the `Fizz Buzz Whizz` question.

Firstly, let's have a look at this question:

Assume you're a teacher, and you want to play a game with your 200 students, 
by the following rules:

1. All the students queue up in a line, from 1 to 200.
2. If the student num can modulo 3 , then they should report `fizz` instead of their num. 
Similarly , 5 should report `buzz` and 7 should report `whizz`.
3. If the student's number is multiple of the special number (3, 5, 7). For an instance:
the student number is 15, it's the multiple of 3 and 5, so he should report `fizzbuzz` instead.
4. If the number contains 3, then student should report `fizz` instead of number.
eg: `13` should report `fizz`
5. If the number contains 3, then ignore 2th and 3th rule.

Before we tackle this question, ``

  

