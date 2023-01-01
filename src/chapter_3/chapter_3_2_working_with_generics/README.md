# 3.2 Working With Generics

Why do we need generics? We would need to expect the caller to not put something in the list we didn't expect.

![](2023-01-01-10-25-58.png)

Executing the above code throws a ClassCastException. We added a StringBuilder to the list which is legal as a List can contain anythiung. Then the StringBuilder is casted to a String which cannot happen.

Generics fix this issue by declaring the type of objects which can be put into the list.

    List<String> names = new ArrayList<String>();
    names.add(new StringBuilder("Webby")); // does not compile

# 1 Generic Classes

We can introduce generics into classes. We can declare a formal type paremeter using angled brackets (<>)

For example, we create a Crate class with a generic parameter:

    class Crate<T> {
        private T contents;
        public T emptyCrate() {
            return contents;
        }
        public void packCrate(T contents) {
            this.contents = contents;
        }
    }

The generic type T is available anywhere within the Crate class. When you instantiate the class, you tell the compiler what T should be.

## Naming Conventions for Generics

The following are common letters to use:

- E for element
- K for a map key
- V for a map value
- N for a number
- T for a generic data type
- S, U, V and so forth for multiple generic types.

## Example

Suppose an Elephant class exists:

![](2023-01-01-10-41-26.png)

We can see the Crate class is able to deal with the Elephant class without knowing its implementation.

Suppose we have another Zebra class:

    Crate<Zebra> crateForZebra = new Crate<>();

We could've create an Animal superclass or interface! But generics allow us to have a type parameter for classes with no relationships!

For example, we can have a Robot in our crate:

![](2023-01-01-10-47-13.png)

Before, we would've had to use an Object class. So the crate does not need to know about objects, the objects also don't need to know about crate! So we didn't need to create an interface like Crateable.

Generics may not cup up in code we write, but it certainly does come up in code we call, like the Collections framework

## Multiple Generic Types

Generic classes aren't limited to one generic type, here is a class with 2 generic parameters:

    class SizeLimitedCrate<T, U> {
        private T contents;
        private U sizeLimit;
        public SizeLimitedCrate(T contents, U sizeLimit) {
            this.contents = contents;
            this.sizeLimit = sizeLimit;
        }
    }

- T is used for the type of contents
- U is the units for the to measure the size

Suppose we create a crate for elephants:

![](2023-01-01-11-04-12.png)

## Type Erasure

When we use a generics, like when we replace T with Robot, the compiuler replaces all references to T in Crate with Object. Hence generics are actually just Object types. The Crate class which is created looks like the following:

    public class Crate {
        private Object contents;
        public Object emptyCrate(){
            return contents;
        }
        public void packCrate(Object contents){
            this.contents = contents;
        }
    }

This means there is only one class file! The process of removing generics is called **type erasure**

# 2 Generic Classes