import java.util.*;

public class CollegeDepartment {
    public static void main(String[] args) {
        List<String> studentName = new ArrayList<>();

        Map<String, Set<String>> studentSubject = new HashMap<>();

        Set<String> uniqueSubjects = new HashSet<>();

        studentName.add("Emily");
        studentName.add("Bobby");
        studentName.add("James");
        studentName.add("Tom");

        Set<String> emilySubjects = new HashSet<>();
        emilySubjects.add("Myanmar");
        emilySubjects.add("English");
        emilySubjects.add("Biography");

        Set<String> bobbySubjects = new HashSet<>();
        bobbySubjects.add("Physics");
        bobbySubjects.add("Biography");
        bobbySubjects.add("Chemistry");

        Set<String> jamesSubjects = new HashSet<>();
        jamesSubjects.add("Myanmar");
        jamesSubjects.add("Physics");
        jamesSubjects.add("Chemistry");
        jamesSubjects.add("Mathematics");

        Set<String> tomSubjects = new HashSet<>();
        tomSubjects.add("English");
        tomSubjects.add("Mathematics");
        tomSubjects.add("Physics");

        studentSubject.put("Emily",emilySubjects);
        studentSubject.put("Bobby",bobbySubjects);
        studentSubject.put("James",jamesSubjects);
        studentSubject.put("Tom",tomSubjects);

        Iterator<String> nameIterator = studentSubject.keySet().iterator();
        Iterator<Set<String>> subjectIterator = studentSubject.values().iterator();
        while (nameIterator.hasNext() && subjectIterator.hasNext())
        {
            String name = nameIterator.next();
            Set<String> subjects = subjectIterator.next();
            System.out.println(name + " --> " + subjects);
        }

        tomSubjects.add("Myanmar");
        System.out.println("\nOne subject is added to " + studentName.get(3));

        System.out.println("\nOne subject is removed from " + studentName.get(2));
        jamesSubjects.remove("Physics");

        for(Set<String> allSubjects : studentSubject.values())
        {
            uniqueSubjects.addAll(allSubjects);
        }
        System.out.println("\nThe Subjects we offer - "+ uniqueSubjects);




    }
}
