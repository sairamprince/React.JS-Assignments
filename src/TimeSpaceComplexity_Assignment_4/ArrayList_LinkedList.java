package TimeSpaceComplexity_Assignment_4;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayList_LinkedList 
{
	private static long getMemoryUsage()
	{
		Runtime runtime = Runtime.getRuntime();
		return runtime.totalMemory() - runtime.freeMemory();
	}
	
	public static void main(String args[])
	{
		long startTime, memoryBefore, memoryAfter, endTime;
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		//ArrayList insertion
				startTime = System.nanoTime();
				memoryBefore = getMemoryUsage();
				for(int i=0;i< 100000;i++)
				{
					arrayList.add(i);
				}
				memoryAfter = getMemoryUsage();
				endTime = System.nanoTime();
				System.out.println("*********************************************");
				System.out.println("ArrayList insetion time: "+ (endTime - startTime) + " ns");
				System.out.println("ArrayList memory usage: "+ (memoryAfter - memoryBefore) + " bytes");
				System.out.println("*********************************************");
				System.out.println(" ");
				
		//ArrayList remove
				startTime = System.nanoTime();
				memoryBefore = getMemoryUsage();
					arrayList.remove(1000);
				memoryAfter = getMemoryUsage();
				endTime = System.nanoTime();
				System.out.println("*********************************************");
				System.out.println("ArrayList deletion time: "+ (endTime - startTime) + " ns");
				System.out.println("ArrayList memory usage: "+ (memoryAfter - memoryBefore) + " bytes");
				System.out.println("*********************************************");
				System.out.println(" ");
				
		//ArrayList get element
				startTime = System.nanoTime();
				memoryBefore = getMemoryUsage();
					arrayList.get(6000);
				memoryAfter = getMemoryUsage();
				endTime = System.nanoTime();
				System.out.println("*********************************************");
				System.out.println("ArrayList get element time: "+ (endTime - startTime) + " ns");
				System.out.println("ArrayList memory usage: "+ (memoryAfter - memoryBefore) + " bytes");
				System.out.println("*********************************************");
				System.out.println(" ");
				
		//LinkedList insertion
				startTime = System.nanoTime();
				memoryBefore = getMemoryUsage();
				for(int i=0;i< 100000;i++)
				{
					linkedList.add(i);
				}
				memoryAfter = getMemoryUsage();
				endTime = System.nanoTime();
				System.out.println("*********************************************");
				System.out.println("LinkedList insetion time: "+ (endTime - startTime) + " ns");
				System.out.println("LinkedList memory usage: "+ (memoryAfter - memoryBefore) + " bytes");
				System.out.println("*********************************************");
				System.out.println(" ");
				
		//LinkedList remove
				startTime = System.nanoTime();
				memoryBefore = getMemoryUsage();
					linkedList.add(8000);
				memoryAfter = getMemoryUsage();
				endTime = System.nanoTime();
				System.out.println("*********************************************");
				System.out.println("LinkedList deletion time: "+ (endTime - startTime) + " ns");
				System.out.println("LinkedList memory usage: "+ (memoryAfter - memoryBefore) + " bytes");
				System.out.println("*********************************************");
				System.out.println(" ");
				
		//LinkedList get element
				startTime = System.nanoTime();
				memoryBefore = getMemoryUsage();
					linkedList.get(4000);
				memoryAfter = getMemoryUsage();
				endTime = System.nanoTime();
				System.out.println("*********************************************");
				System.out.println("LinkedList get element time: "+ (endTime - startTime) + " ns");
				System.out.println("LinkedList memory usage: "+ (memoryAfter - memoryBefore) + " bytes");
				System.out.println("*********************************************");
	}
}
