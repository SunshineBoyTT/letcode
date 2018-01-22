/**
 * 
 */
package cn.failfast;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//线程任务类，获取集合中的最后一个元素
class GetLast implements Runnable{

    private Vector<Integer> list;
    
    public GetLast(Vector<Integer> list) {
        this.list = list;
    }
    @Override
    public void run() {
        while(true){
            try{
                Test.getLast(list);
            }catch(Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage() + " --- in class GetLast");
                break;
            }
            
        }
        
    }
    
}