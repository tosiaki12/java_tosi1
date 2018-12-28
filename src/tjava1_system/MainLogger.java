package tjava1_system;

import java.util.logging.Logger;


public class MainLogger extends AbstractLogger {




	@Override
	public void setLoggerName() {
		loggerName = "tosi.mainc";
	}


	@Override
	public void setLogFilePath() {
		logFilePath = "ccmainLogTEST.log";
	}


	@Override
	public void setINFOLogFilePath() {
		INFOLogFilePath = "ccmain_INFOLogTEST.log";
	}


	public static void makeInstance(){
		MainLogger ml = new MainLogger();
		Logger mltest = ml.getMainLoggerInstance();
		mltest.fine("dsfds");

	}



}






