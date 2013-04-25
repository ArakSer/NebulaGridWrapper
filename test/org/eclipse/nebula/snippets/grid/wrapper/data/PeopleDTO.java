package org.eclipse.nebula.snippets.grid.wrapper.data;

public class PeopleDTO {
	private String name;
	private Integer age;
	private Boolean married;
	private String tags;

	public PeopleDTO(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public PeopleDTO(String name, Integer age, Boolean married, String tags) {
		this.name = name;
		this.age = age;
		this.married = married;
		this.tags = tags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getMarried() {
    	return married;
    }

	public void setMarried(Boolean married) {
    	this.married = married;
    }

	public String getTags() {
    	return tags;
    }

	public void setTags(String tags) {
    	this.tags = tags;
    }

	@Override
	public String toString() {
		return "PeopleDTO [name=" + name + ", age=" + age + ", married=" + married + ", tags=" + tags + "]";
	}
	
	

}
