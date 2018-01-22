/**
 * 
 */
package cn.java8lambda;

import java.io.Serializable;

import cn.failfast.Stack;

/**
 * @Description:
 * @author zhengjuntao@hjtechcn.cn
 * @Since:2017年9月11日
 * @Version:1.1.0
 */
public class Person implements Serializable {
	    /** 姓名 **/  
	    private String name;  
	      
	    /** 电子邮件 **/  
	    private Stack stack;  
	  
	    public String getName() {  
	        return name;  
	    }  
	  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	  
	    public Stack getStack() {  
	        return stack;  
	    }  
	  
	    public void setStack(Stack stack) {  
	        this.stack = stack;  
	    }  
	      
	    public Person(String name,Stack stack){  
	        this.name  = name;  
	        this.stack = stack;  
	    }  
	      
	    public Person(String name){  
	        this.name = name;  
	    }  
	  
	    protected Person clone() {  
	        Person person = null;  
	        try {  
	            person = (Person) super.clone();  
	        } catch (CloneNotSupportedException e) {  
	            e.printStackTrace();  
	        }  
	          
	        return person;  
	    }  
}
