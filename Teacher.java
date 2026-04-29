public class Teacher extends Person {
    private int numCourses = 0;
    private String[] courses = {};

    public Teacher(String name, String address) {
        super(name, address);
    }

    public boolean addCourse(String course) {
        // Return false if the course already existed
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                return false;
            }
        }

        String[] newCourses = new String[numCourses + 1];
        for (int i = 0; i < numCourses; i++) {
            newCourses[i] = courses[i];
        }
        newCourses[numCourses] = course;
        courses = newCourses;
        numCourses++;
        return true;
    }

    public boolean removeCourse(String course) {
        // Return false if the course does not exist
        int index = -1;
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;

        String[] newCourses = new String[numCourses - 1];
        int j = 0;
        for (int i = 0; i < numCourses; i++) {
            if (i != index) {
                newCourses[j++] = courses[i];
            }
        }
        courses = newCourses;
        numCourses--;
        return true;
    }

    public void printCourses() {
        if (numCourses == 0) {
            System.out.println("Tidak ada mata kuliah yang diampu.");
            return;
        }
        System.out.println("Mata kuliah yang diampu " + getName() + ":");
        for (int i = 0; i < numCourses; i++) {
            System.out.println("  " + (i + 1) + ". " + courses[i]);
        }
    }

    @Override
    public String toString() {
        return "Teacher: " + getName() + "(" + getAddress() + ")";
    }
}