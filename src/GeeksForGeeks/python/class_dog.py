class Dog:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def __repr__(self):
        return "Name: {}, Age: {}".format(self.name, self.age)


tommy_dog = Dog("tommy", 8)
print(tommy_dog)