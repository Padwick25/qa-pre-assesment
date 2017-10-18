# qa-pre-assesment
Pre Assessment pack for QA Consulting
Encapsulation: Making all variables in a class private, so that they can only be from outside the class with methods. An example would be all classes I made for exercise 2, but in particular the Basket class.


Inheritance: A class that inherits from another class gains all of the superclasses (the class inherited from) methods and fields. In java, this can be done with the “extends” keyword (subclass extends superclass). For example, you could have a class of animals with fields named size and weight. A class Dog could have a method called bark. Then objects in the dog class have the size and weight fields, but objects in the animal class wouldn’t have the bark method.


Polymorphism: This allows objects to take on many forms. In java, an object that passes IS-A test is polymorphic. Hence all java objects are polymorphic, since and object is itself, and IS-A member of it’s class. For example a dog object is also an animal object.  So we could initialise a dog with “Animal dog = new Dog;”. Now, if both classes had a method “public void alive();”, the dog classes alive method would override the  alive method in the animal class. If you then redefined it as an animal (“dog = new Animal;”) it would use the animal alive method.


Abstraction:  An abstract class is a class that can’t have objects, but can be inherited from. A class can be declared as abstract by using the “abstract” keyword. Abstract classes can have regular methods and abstract methods. An abstract method is a method without a body. A subclass will inherit all methods of the abstract class as normal, including the abstract methods. If the child class doesn’t implement (override) the abstract method, it would also need to be declared as abstract. For an example, let’s say we call a class animal abstract, and give it the abstract method sound. We could then have a (non-abstract) class dog which implements a “woof” sound, or a (non-abstract) class cat with a “meow” sound.
