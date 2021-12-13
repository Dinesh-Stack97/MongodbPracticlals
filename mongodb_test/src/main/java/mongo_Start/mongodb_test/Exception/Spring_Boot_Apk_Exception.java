package mongo_Start.mongodb_test.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Spring_Boot_Apk_Exception extends RuntimeException{
	
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	public Spring_Boot_Apk_Exception(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s is not found with %s: '%s'", resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResourceName() {
		return resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
	

	
	

}
