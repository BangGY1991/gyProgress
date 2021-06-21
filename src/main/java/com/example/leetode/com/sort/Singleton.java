package com.example.leetode.com.sort;

public class Singleton {
//	 private static volatile Singleton singleton = null;
//	 
//     private Singleton() {
//     }
//
//     public static Singleton getInstance(){
//         //第一次校验singleton是否为空
//         if(singleton==null){
//             synchronized (Singleton.class){
//                 //第二次校验singleton是否为空
//                 if(singleton==null){
//                     singleton = new Singleton();
//                 }
//             }
//         }
//         return singleton;
//     }
	private static volatile Singleton singleton=null;
	private Singleton()
	{
		
	}
	public static Singleton getInstance()
	{
		if(singleton==null)
		{
			synchronized (Singleton.class) {
				if(singleton==null)
				{
					singleton=new Singleton();
				}
			
		}
		}
		return singleton;
	}


     public static void main(String[] args) {
         for (int i = 0; i < 100; i++) {
             new Thread(new Runnable() {
                 public void run() {
                     System.out.println(Thread.currentThread().getName()+" : "+Singleton.getInstance().hashCode());
                 }
             }).start();
         }
     }


}
