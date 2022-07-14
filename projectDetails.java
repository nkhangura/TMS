public class projectDetails {
    private String project;
    private String projectD;
    private String assignedTo;
    private int tier;

    public projectDetails(String project, String projectD, String assignedTo, int tier) {
        super();
        this.project = project;
        this.projectD = projectD;
        this.assignedTo = assignedTo;
        this.tier = tier;
    }

    public projectDetails() {

    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getProjectD() {
        return projectD;
    }

    public void setProjectD(String projectD) {
        this.projectD = projectD;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public String toString() {
        return "projectDetails [project=" + project + ", projectD=" + projectD + ", assignedTo: " + assignedTo
                + ", tier: " + tier + ", toString()=" + super.toString() + "]";
    }

    public void display() {
        System.out.println("Project name: " + project);
        System.out.println("Project description: " + projectD);
        System.out.println("Project assigned to: " + assignedTo);
        System.out.println("Project priority tier level: " + tier);
    }
}
