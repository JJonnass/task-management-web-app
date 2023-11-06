package haagahelia.fi.TaskMaster.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String description;
	private String priority;
	private String status;
	
	public Task() {}
	
	public Task(String description, String priority) {
		super();
		this.description = description;
		this.priority = priority;
		this.status = "PENDING";
	}

	public Long getId() {
		return id;
	}
		
	public void setId(Long id) {
		this.id = id;
	}
		
	public String getDescription() {
		return description;
	}
		
	public void setDescription(String description) {
		this.description = description;
	}
		
	public String getPriority() {
		return priority;
	}
		
	public void setPriority(String priority) {
		this.priority = priority;
	}
		
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
