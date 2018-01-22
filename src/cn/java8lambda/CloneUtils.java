/**
 * 
 */
package cn.java8lambda;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import cn.failfast.Stack;

/**
 * @Description:深clone
 * @author zhengjuntao@hjtechcn.cn
 * @Since:2017年9月11日
 * @Version:1.1.0
 */
public class CloneUtils {
	@SuppressWarnings("unchecked")  
    public static <T extends Serializable> T clone(T obj){  
        T cloneObj = null;  
        try {  
            //写入字节流  
            ByteArrayOutputStream out = new ByteArrayOutputStream();  
            ObjectOutputStream obs = new ObjectOutputStream(out);  
            obs.writeObject(obj);  
            obs.close();  
              
            //分配内存，写入原始对象，生成新对象  
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());  
            ObjectInputStream ois = new ObjectInputStream(ios);  
            //返回生成的新对象  
            cloneObj = (T) ois.readObject();  
            ois.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return cloneObj;  
    } 
	
	public static void main(String[] args) {
		Stack email = new Stack("请与今天12:30到二会议室参加会议...");  
        
        Person person1 =  new Person("张三",email);  
          
        Person person2 =  CloneUtils.clone(person1);  
        person2.setName("李四");  
        Person person3 =  CloneUtils.clone(person1);  
        person3.setName("王五");  
        person1.getStack().setName("请与今天12:00到二会议室参加会议...");   
          
        System.out.println(person1.getName() + "的邮件内容是：" + person1.getStack().getName());  
        System.out.println(person2.getName() + "的邮件内容是：" + person2.getStack().getName());  
        System.out.println(person3.getName() + "的邮件内容是：" + person3.getStack().getName());
	}
}
