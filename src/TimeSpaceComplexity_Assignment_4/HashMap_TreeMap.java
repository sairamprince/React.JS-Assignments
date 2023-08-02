package TimeSpaceComplexity_Assignment_4;

import java.util.HashMap;
import java.util.TreeMap;

public class HashMap_TreeMap 
{
	private static long getMemoryUsage()
	{
		Runtime runtime = Runtime.getRuntime();
		return runtime.totalMemory() - runtime.freeMemory();
	}
	public static void main(String args[])
	{
		long startTime, memoryBefore, memoryAfter,endTime;

		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();

		//HashMap insertion
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		for(int i=0;i< 100000;i++)
		{
			hashMap.put(33, "javaTraining" + i);
		}
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("*********************************************");
		System.out.println("HashMap insetion time: "+ (endTime - startTime) + " ns");
		System.out.println("HashSet memory usage: "+ (memoryAfter - memoryBefore) + " bytes");
		System.out.println("*********************************************");
		System.out.println(" ");

		//HashMap remove element
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		hashMap.remove(20000);
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("*********************************************");
		System.out.println("HashMap remove element time: "+ (endTime - startTime) + " ns");
		System.out.println("HashSet memory usage: "+ (memoryAfter - memoryBefore) + " bytes");
		System.out.println("*********************************************");
		System.out.println(" ");

		//HashMap get element
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		hashMap.get(23456);
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("*********************************************");
		System.out.println("HashMap get element time: "+ (endTime - startTime) + " ns");
		System.out.println("HashSet memory usage: "+ (memoryAfter - memoryBefore) + " bytes");
		System.out.println("*********************************************");
		System.out.println(" ");

		//TreeMap insertion
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		for(int i=0;i< 100000;i++)
		{
			treeMap.put(67, "javaTraining" + i);
		}
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("*********************************************");
		System.out.println("TreeSet insetion time: "+ (endTime - startTime) + " ns");
		System.out.println("TreeSet memory usage: "+ (memoryAfter - memoryBefore) + " bytes");
		System.out.println("*********************************************");
		System.out.println(" ");

		//TreeMap remove element
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		treeMap.remove(4000);
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("*********************************************");
		System.out.println("TreeSet remove element time: "+ (endTime - startTime) + " ns");
		System.out.println("TreeSet memory usage: "+ (memoryAfter - memoryBefore) + " bytes");
		System.out.println("*********************************************");
		System.out.println(" ");

		//TreeMap get element
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		treeMap.get(900);
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("*********************************************");
		System.out.println("TreeSet get element time: "+ (endTime - startTime) + " ns");
		System.out.println("TreeSet memory usage: "+ (memoryAfter - memoryBefore) + " bytes");
		System.out.println("*********************************************");
	}

}
