package uni.aed.model;

import java.util.Objects;

public class Persona implements Comparable{
    
    public static final int NAME=0;
    public static final int AGE=1;
    private static final int LESS=-1;
    private static final int EQUAL=0;
    private static final int MORE=1;
    private static int compareAttribute=NAME;
    private String name;
    private int age;
    private char gender;

    public Persona() {
        this("No Ingresado",0,'U');
    }

    public Persona(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public Persona(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }  

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

   

    public char getGender() {
        return gender;
    }   

    public static void setCompareAttribute(int compareAttribute) {
        Persona.compareAttribute = compareAttribute;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "Persona{" + "name=" + name + ", edad=" + age + ", gender=" + gender + '}';
    }  

    @Override
    public int compareTo(Object o) {
        return compareTo((Persona)o,compareAttribute);
    }
    
    public int compareTo(Persona persona, int attribute){
        int comparisonResult;
        if(attribute==AGE){
            int p2age=persona.getAge();
            if(this.age<p2age)
                comparisonResult=LESS;
            else if(this.age==p2age)
                comparisonResult=EQUAL;
            else
                comparisonResult=MORE;            
        }else{
            String p2name=persona.getName();
            comparisonResult=this.name.compareTo(p2name);
        }
        return comparisonResult;
    }
    
    
}
