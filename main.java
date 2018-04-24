package C189;

/**
 * Created by Mike Anderson on 4/22/2018.
 */
public class main {
    /* This class will be the main method */
    public static void main(String[] args){
        System.out.println("Testing Hash Table:");
        C189.hashtable testHash = new C189.hashtable();
        testHash.add("Bob", "Smith", "bsmith@somewhere.com", "555-235-1111");
        testHash.add("Jane", "Williams", "jw@something.com", "555-235-1112");
        testHash.add("Mohammed", "al-Salam", "mas@someplace.com", "555-235-1113");
        testHash.add("Pat", "Jones", "pjones@homesweethome.com", "555-235-1114");
        testHash.add("Billy", "Kidd", "billy_the_kid@nowhere.com", "555-235-1115");
        testHash.add("H.", "Houdini", "houdini@noplace.com", "555-235-1116");
        testHash.add("Jack", "Jones", "jjones@hill.com", "555-235-1117");
        testHash.add("Jill", "Jones", "jillj@hill.com", "555-235-1118");
        testHash.add("John", "Doe", "jdoe@somedomain.com", "555-235-1119");
        testHash.add("Jane", "Doe", "jdoe@somedomain.com", "555-235-1120");
        testHash.find("Pat", "Jones");
        testHash.find("Billy", "Kidd");
        testHash.delete("John", "Doe");
        testHash.add("Test", "Case", "Test_Case@testcase.com", "555-235-1121");
        testHash.add("Nadezhda", "Kanachekhovskaya", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru", "555-235-1122");
        testHash.add("Jo", "Wu", "wu@h.com", "555-235-1123");
        testHash.add("Millard", "Fillmore", "millard@theactualwhitehouse.us", "555-235-1124");
        testHash.add("Bob", "vanDyke", "vandyke@nodomain.com", "555-235-1125");
        testHash.add("Upside", "Down", "upsidedown@rightsideup.com", "555-235-1126");
        testHash.find("Jack", "Jones");
        testHash.find("Nadezhda", "Kanachekhovskaya");
        testHash.delete("Jill", "Jones");
        testHash.delete("John", "Doe");
        testHash.find("Jill", "Jones");
        testHash.find("John", "Doe");
        System.out.println();
        System.out.println("Hash test complete");
        System.out.println();

    }

}