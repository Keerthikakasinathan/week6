class Scl{
Object scl, std;
Scl(Object scl, Object std)
{
this.scl=scl;
this.std=std;
}
}
class Resp1 extends Thread
{
	Scl s;
	Resp1(Scl s)
	{
		this.s=s;
	}
	public void run()
	{
	synchronized(s.scl){
	System.out.println("New School");
	try{
		Thread.sleep(100);
		}
	catch(Exception e){
		}
	synchronized(s.std){
		System.out.println("New Standard");
		}
	}
}
}
class Resp2 extends Thread
{
	Scl s;
	Resp2(Scl s)
	{
		this.s=s;
	}
	public void run()
	{
	synchronized(s.scl){
	System.out.println("School");
	try{
		Thread.sleep(100);
		}
	catch (Exception e){}
		}
		synchronized(s.std){
		System.out.println("Standard");
		}
	}	
}

class DeadLk{
		public static void main(String... args)
		{
			Object scl=new Object();
			Object std=new Object();
			Scl s=new Scl(scl, std);
			Resp1 r1=new Resp1(s);
			Resp2 r2=new Resp2(s);
			Thread t1=new Thread(r1);
			Thread t2=new Thread(r2);
			t1.start();
			t2.start();
		}
}