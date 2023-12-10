package chapter_7.revisionNotes.javaCode;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class WeighAnimalAction extends RecursiveAction {
	private int start;
	private int end;
	private Double[] weights;
	public WeighAnimalAction(Double[] weights, int start, int end) {
		this.start = start;
		this.end = end;
		this.weights = weights;
	}
	protected void compute() {
		if (end-start<4) {
			System.out.println("BASE CASE FROM: "+start
		            +", TO: "+end);
			for(int i=start;i<end;i++) {
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("Animal "+i+" weighs "+weights[i]);
            }
		} else {
			int middle = start+((end-start)/2);
            System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
            invokeAll(new WeighAnimalAction(weights,start,middle),
                       new WeighAnimalAction(weights,middle,end));
		}
	}
	public static void main(String[] args) {
		Double[] weights = new Double[10];
		ForkJoinTask task = 
			new WeighAnimalAction(weights, 0,weights.length);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
	}

}
