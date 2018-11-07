
public class Person {
    String name; 
    int age; 
    BloodType bloodType; 

    public Person(String name, int age, BloodType bloodType) { 
        this.name = name; 
        this.age = age; 
        this.bloodType = bloodType; 
    }
    
    public String getName() { 
        return name; 
    }
    
    public int getAge() { 
        return age; 
    }
    
    public BloodType getBloodType() { 
        return bloodType; 
    }
    
    @Override 
    public boolean equals(Object obj) { 
        if ((obj instanceof Person) == false) return false; 
        Person p = (Person)obj; 
        return (this.name == null ? p.name == null : this.name.equals(p.name)) &&  
                this.bloodType == p.bloodType && 
                this.age == p.age; 
    }
    
    @Override
    public String toString() { 
        return String.format("Person{name=\"%s\", age=%d, bloodType=%s}", name, age, bloodType); 
    }
}
