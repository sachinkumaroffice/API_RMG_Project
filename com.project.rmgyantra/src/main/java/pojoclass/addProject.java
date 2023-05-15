package pojoclass;

public class addProject {

	
	String  createdBy;
	String projectName;
	String status;
	int temSize;
	
	
	
	public addProject(String createdBy, String projectName, String status, int temSize) {
		super();
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.temSize = temSize;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getTemSize() {
		return temSize;
	}



	public void setTemSize(int temSize) {
		this.temSize = temSize;
	}
	
	
	
	
}
