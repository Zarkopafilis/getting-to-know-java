print('Hello from nashorn.js!');

var func1 = function(name) {
    return "greetings " + name;
};

var MyJavaClass = Java.type('eight.NasHornExample');
var result = MyJavaClass.func2('lowercase');
print(result);


MyJavaClass.mirrors({
    foo: 'bar',
    bar: 'foo'
});

function Person(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.getFullName = function() {
        return this.firstName + " " + this.lastName;
    }
}

var person1 = new Person("Peter", "Parker");
MyJavaClass.callJs(person1);