package tests;
import java.util.concurrent.TimeUnit;

import gui.StartFrame;
import process.GroupPhaseSimulation;
import process.Start;

public class ExecutionTimeTest {

	/** Class to measure elapsed time in Java after the launch of the graphical interface **/
	
	static float start;

	static float end;

	static float time;
	
	/* Valeur de temps d'éxecution maximale exprimée en secondes */
	static int MaxTimeValue = 5;
	
		public static void startTime() {
			start = System.nanoTime();
		}

		public static void endTime() {
			 end = System.nanoTime();
		}

		public static void timeElapsed() {
			 time = end - start;
		/*	 System.out.println("temps d'éxecution en millisecondes : " + 
						time / 1000000); */
		}
		
		public static void TimeCompare() {
			if(time/1000000000 < MaxTimeValue) {
				System.out.println("temps d'execution "+time/1000000000+" secondes inférieur à 5 secondes : correcte");
			} else {
				System.out.println("temps d'execution incorrecte");
			}
		}
		
		public static void main(String[] args) {
			startTime();
			StartFrame StartFrame = new StartFrame();
			endTime();
			TimeCompare();
		}

}
