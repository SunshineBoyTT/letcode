/**
 * 
 */
package cn.failfast;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

//    //获取最后一个元素
//    public static  Integer getLast(Vector<Integer> list){
//        //这里根据list.size()得到最后一个元素的索引
//        //换句话说，这条语句已经检查认为在集合list中存在索引为list.size() - 1的元素
//        int lastIndex = list.size() - 1;
//        
//        if(lastIndex < 0) return null;
//        
//        //返回指定索引处的元素
//        return list.get(lastIndex);
//    }
//    
//    //删除元素，添加元素
//    public static  void deleteAndAdd(Vector<Integer> list){
//        int lastIndex = list.size() - 1;
//        if(lastIndex < 0) return;
//        list.remove(lastIndex);
//        list.add(3);
//    }
	
	//改后
	//获取最后一个元素
    public static  Integer getLast(Vector<Integer> list){
        synchronized(list){
            //这里根据list.size()得到最后一个元素的索引
            //换句话说，这条语句已经检查认为在容器list中存在索引为list.size() - 1的元素
            int lastIndex = list.size() - 1;
            
            if(lastIndex < 0) return null;
            
            //返回指定索引处的元素
            return list.get(lastIndex);
        }
    }
    
    //删除元素，添加元素
    public static  void deleteAndAdd(Vector<Integer> list){
        synchronized(list){
            int lastIndex = list.size() - 1;
            if(lastIndex < 0) return;
            list.remove(lastIndex);
            list.add(3);
        }
    }
    
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<Integer>();
        vector.add(1);
        vector.add(2);
        
        ExecutorService exec = Executors.newCachedThreadPool();
        
        GetLast gl = new GetLast(vector);
        DeleteAndAdd daa = new DeleteAndAdd(vector);
        
        exec.execute(gl);
        exec.execute(daa);
        
    }
}
