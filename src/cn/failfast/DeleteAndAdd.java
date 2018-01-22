/**
 * 
 */
package cn.failfast;

import java.util.Vector;

//线程任务类，删除&添加元素
class DeleteAndAdd implements Runnable{

  private Vector<Integer> list;
  
  public DeleteAndAdd(Vector<Integer> list) {
      this.list = list;
  }
  @Override
  public void run() {
      while(true){
          try{
              Test.deleteAndAdd(list);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println(e.getMessage() + " --- in class DeleteAndAdd");
              break;
          }
          
      }
      
  }
  
}