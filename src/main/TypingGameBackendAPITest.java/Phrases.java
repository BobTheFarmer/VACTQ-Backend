package com.nighthawk.TypingGameBackendTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data  // Annotations to simplify writing code (ie constructors, setters)
@Entity
public class Phrases {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String phrase;

    public static String[] init() {
        final String phraseArray = {
            "Java is an object-oriented programming language that is concurrent, class-based, and specifically designed to have as few implementation dependencies as possible.",
            "In Java, every piece of data, whether it be a number, a character, or an object, is created in the memory.",
            "One of the key features of Java is garbage collection; it automatically deletes objects that are not being used.",
            "Java uses Just-In-Time compiler for high performance; JIT compiles parts of the bytecode that have similar functionality at the same time, and hence reduces the amount of time needed for compilation.",
            "In Java, classes and objects from its methods are the fundamental units of OOPs which make it a powerful language.",
            "Java provides a robust system with its strong exception handling and type checking mechanism which makes it a secure language.",
            "Multithreading in Java is a feature that allows concurrent execution of two or more parts of a program for maximum utilization of CPU.",
            "Java supports automatic garbage collection; it tracks each and every object available in the JVM heap space and removes unused ones.",
            "In Java, there is no need to remove unreferenced objects because there is an Automatic Garbage Collection in java.",
            "Java provides APIs for networking, database connection, utilities and almost everything; whatever left can be accomplished by third-party libraries.",
            "Java is platform-independent because when you compile a Java program, it gets converted to bytecode which can be interpreted on any system.",
            "The concept of exception handling in Java gives us a way to handle the runtime errors so that normal flow of the application can be maintained.",
            "Inheritance in Java is a mechanism where one object acquires all the properties and behaviors of the parent object.",
            "Java's 'write once, run anywhere' approach means it has significant advantages over other languages for certain types of applications.",
            "Java's standard data types are known as primitive types; they include `int`, `short`, `long`, `byte`, `float`, `double`, `char`, and `boolean`.",
            "A class in Java is a blueprint which includes all your data and methods to be worked upon.",
            "Java's encapsulation feature allows wrapping code and data together into a single unit, like a capsule which is mixed with several medicines.",
            "An interface in Java is a blueprint of a class or you can say it is a collection of abstract methods and static constants.",
            "In Java, method overloading is not considered as polymorphism because overload resolution takes place at compile time."
        };
        return phraseArray;
    }
}
