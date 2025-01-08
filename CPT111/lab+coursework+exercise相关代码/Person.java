public class Person {
    private String id;
    private String name;

    public Person(String id, String name) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String courseCode;
    private String courseTitle;
    private double units;
    private int mark;
    private Boolean isCompleted;

    public Course(String courseCode, String courseTitle, double units, int mark, Boolean isCompleted) {
        if (courseCode == null || courseCode.isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be null or empty");
        }
        if (courseTitle == null || courseTitle.isEmpty()) {
            throw new IllegalArgumentException("Course title cannot be null or empty");
        }
        if (units <= 0) {
            throw new IllegalArgumentException("Units must be greater than zero");
        }
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException("Mark must be between 0 and 100");
        }
        if (isCompleted == null) {
            throw new IllegalArgumentException("isCompleted cannot be null");
        }
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.units = units;
        this.mark = mark;
        this.isCompleted = isCompleted;
    }

    public Course() {
        this.courseCode = null;
        this.courseTitle = null;
        this.units = 0.0;
        this.mark = 0;
        this.isCompleted = false;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public double getUnits() {
        return units;
    }

    public int getMark() {
        return mark;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public String getFormattedMark() {
        return mark == 0 ? "--" : String.valueOf(mark);
    }

    @Override
    public String toString() {
        return courseCode + " (" + units + " units): " + courseTitle + "         " + getFormattedMark();
    }
}

class Staff extends Person {
    private String department;
    private String position;

    public Staff(String id, String name, String department, String position) {
        super(id, name);
        if (department == null || department.isEmpty()) {
            throw new IllegalArgumentException("Department cannot be null or empty");
        }
        if (position == null || position.isEmpty()) {
            throw new IllegalArgumentException("Position cannot be null or empty");
        }
        this.department = department;
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Staff " + super.getName() + "(Id: " + super.getId() + "):\n Department: " + this.getDepartment() + "\n Position: " + this.getPosition();
    }
}

class Student extends Person {
    private String programOfStudy;
    private int yearOfStudy;
    private Course[] courses;
    private int courseCount;

    public Student(String id, String name, String programOfStudy, int yearOfStudy, Course[] courses) {
        super(id, name);
        if (programOfStudy == null || programOfStudy.isEmpty()) {
            throw new IllegalArgumentException("Program of study cannot be null or empty");
        }
        if (yearOfStudy <= 0) {
            throw new IllegalArgumentException("Year of study must be greater than zero");
        }
        if (courses == null) {
            throw new IllegalArgumentException("Courses cannot be null");
        }
        this.programOfStudy = programOfStudy;
        this.yearOfStudy = yearOfStudy;
        this.courses = courses;
        this.courseCount = courses.length;
    }

    public String getProgramOfStudy() {
        return programOfStudy;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public int getNumOfCompletedCourses() {
        int count = 0;
        for (Course course : courses) {
            if (course != null && course.getIsCompleted()) {
                count++;
            }
        }
        return count;
    }

    public void addCourse(Course course) {
        if (courseCount == courses.length) {
            resizeCapacity();
        }
        courses[courseCount++] = course;
    }

    public void resizeCapacity() {
        Course[] newCourses = new Course[courses.length * 2];
        System.arraycopy(courses, 0, newCourses, 0, courses.length);
        courses = newCourses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student ").append(super.getName()).append(" (Id: ").append(super.getId()).append("):\n");
        sb.append(" Program of study: ").append(this.getProgramOfStudy()).append("\n");
        sb.append(" Year of study: ").append(this.getYearOfStudy()).append("\n");
        sb.append(" Courses completed (").append(this.getNumOfCompletedCourses()).append("):\n");

        for (Course course : courses) {
            if (course != null && course.getIsCompleted()) {
                sb.append("   ").append(course.toString()).append("\n");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            Course[] initialCourses = new Course[5];
            initialCourses[0] = new Course("CPT000", "Module Name-0", 3.5, 97, true);
            initialCourses[1] = new Course("CPT001", "Module Name-1", 3.0, 70, true);
            initialCourses[2] = new Course("CPT002", "Module Name-2", 2.5, 52, true);
            initialCourses[3] = new Course("CPT003", "Module Name-3", 1.5, 0, true);  // No mark, should show "--"
            initialCourses[4] = new Course("CPT004", "Module Name-4", 0.5, 41, true);

            Staff abc = new Staff("123456789", "ABC", "Department-13579", "Position-123");
            System.out.println(abc);

            Student def = new Student("987654321", "DEF", "Program-12345", 1, initialCourses);
            System.out.println(def);

            // Adding more courses to test resizing
            def.addCourse(new Course("CPT005", "Module Name-5", 3.0, 85, true));
            def.addCourse(new Course("CPT006", "Module Name-6", 2.0, 75, true));

            System.out.println(def);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}




