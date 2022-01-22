package com.vetan.data;
public class Component {
	private String componentName;
	private String componentValue;

	public Component(String componentName, String componentValue) {
		setComponentName(componentName);
		setComponentValue(componentValue);
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getComponentValue() {
		return componentValue;
	}

	public void setComponentValue(String componentValue) {
		this.componentValue = componentValue;
	}
}
