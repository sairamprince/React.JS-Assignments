package TimeSpaceComplexity_Assignment_4;

import java.util.HashSet;
import java.util.TreeSet;

public class HashSet_TreeSet 
{
	private static long getMemoryUsage()
	{
		Runtime runtime = Runtime.getRuntime();
		return runtime.totalMemory() - runtime.freeMemory();
	}
	public static void main(String args[])
	{
		long startTime, memoryBefore, memoryAfter,endTime;

		HashSet<Integer> hashSet = new HashSet<Integer>();
		TreeSet<Integer> treeSet = new TreeSet<Integer>();

		//HashSet insertion
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		for(int i=0;i< 100000;i++)
		{
			hashSet.add(i);
		}
		memoryAfter = getMemoryUsage();
		endTime = System.nanoTime();
		System.out.println("*********************************************");
		System.out.println("HashSet insetion time: "+ (endTime - startTime) + " ns");
		System.out.println("HashSet memory usage: "+ (memoryAfter - memoryBefore) + " bytes");
		System.out.println("*********************************************");
		System.out.println(" ");

		//HashSet remove element
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		hashSet.remove(2000);
		memoryAfter = getMemoryUsage();
		endTime = System.nanoTime();
		System.out.println("*********************************************");
		System.out.println("HashSet remove element time: "+ (endTime - startTime) + " ns");
		System.out.println("HashSet memory usage: "+ (memoryAfter - memoryBefore) + " bytes");
		System.out.println("*********************************************");
		System.out.println(" ");

		//TreeSet insertion
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		for(int i=0;i< 100000;i++)
		{
			treeSet.add(i);
		}
		memoryAfter = getMemoryUsage();
		endTime = System.nanoTime();
		System.out.println("*********************************************");
		System.out.println("TreeSet insetion time: "+ (endTime - startTime) + " ns");
		System.out.println("TreeSet memory usage: "+ (memoryAfter - memoryBefore) + " bytes");
		System.out.println("*********************************************");
		System.out.println(" ");

		//TreeSet remove element
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		treeSet.remove(5678);
		memoryAfter = getMemoryUsage();
		endTime = System.nanoTime();
		System.out.println("*********************************************");
		System.out.println("TreeSet remove element time: "+ (endTime - startTime) + " ns");
		System.out.println("TreeSet memory usage: "+ (memoryAfter - memoryBefore) + " bytes");
		System.out.println("*********************************************");

	}
}
