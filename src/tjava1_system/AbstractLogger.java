package tjava1_system;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public abstract class AbstractLogger {


	public String loggerName;
	public String logFilePath;
	public String INFOLogFilePath;

	public Logger mainLogger;
	public static Logger mainLoggerIns;

	private ConsoleHandler mainCslHandler;
	private FileHandler mainFileHandler;
	private FileHandler INFOmainFileHandler;


	public final Level mainCslLev    = Level.FINEST;
	public final Level mainFileLev   = Level.FINEST;
	public final Level mainLoggerLev = Level.FINEST;

	public abstract void setLoggerName();
	public abstract void setLogFilePath();
	public abstract void setINFOLogFilePath();



	public AbstractLogger(){
		this.setLoggerName();
		this.setLogFilePath();
		this.setINFOLogFilePath();
		this.logInit();
		this.getLoggers();
		this.setting();
		this.addHandler();
		mainLoggerIns = this.mainLogger;

	}


	public void logInit(){
		System.setProperty("java.util.logging.SimpleFormatter.format",
				"[%1$tc] %4$s : \"%5$s\" : %3$s %n");
		/**
		 * ログの書式の設定
		 * %4$s: %5$s [%1$tc]%n
		 * http://etc9.hatenablog.com/entry/2017/02/24/070608
		 * %1 : ログレコードのイベント時間(Date)
		 * %2 : 呼び出し元を表す文字列、使用できない場合はロガー名
		 * %3 : ロガー名
		 * %4 : ログレベル
		 * %5 : ログレコードのメッセージ文字列
		 * %6 : 例外時のスタックトレース
		 */
	}


	public void getLoggers(){
		try {
			//ロガー、ハンドラーの取得
			mainLogger = Logger.getLogger(this.loggerName);//ロガーの取得　引数はロガーの名前
			mainCslHandler   = new ConsoleHandler();
			mainFileHandler  = new FileHandler(logFilePath,true);
			INFOmainFileHandler = new FileHandler(INFOLogFilePath,true);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}


	public void setting(){

		mainLogger.setLevel(     mainLoggerLev);
		mainCslHandler.setLevel( mainCslLev);
		mainFileHandler.setLevel(mainFileLev);
		INFOmainFileHandler.setLevel(Level.INFO);

		mainFileHandler.setFormatter(new SimpleFormatter());//Formatterを設定
		INFOmainFileHandler.setFormatter(new SimpleFormatter());
		mainLogger.setUseParentHandlers(false);

	}

	public void addHandler(){

		mainLogger.addHandler(mainCslHandler);
		mainLogger.addHandler(mainFileHandler);
		mainLogger.addHandler(INFOmainFileHandler);

	}

	public static Logger getMainLoggerInstance(){
		return mainLoggerIns;
	}


	public static void loggingTest(){
		mainLoggerIns.fine("1-fineTEST");
		mainLoggerIns.severe("2-severeTEST");
		mainLoggerIns.finest("3-FNST");
		mainLoggerIns.finer("4-FNR");
		mainLoggerIns.fine("5-FNssss");
		mainLoggerIns.setLevel(Level.INFO);
		mainLoggerIns.info("changeLevel Info");
		mainLoggerIns.config("6-CFG");
		mainLoggerIns.info("7-INF");
		mainLoggerIns.fine("8-FINE");
		mainLoggerIns.warning("9-WNG");
		mainLoggerIns.severe("10-SVR");
		mainLoggerIns.info("changeLevel FINEST");
		mainLoggerIns.setLevel(Level.FINEST);
		mainLoggerIns.fine("11-fineTEST");
		mainLoggerIns.severe("12-severeTEST");
		mainLoggerIns.finest("13-FNST");
		mainLoggerIns.finer("14-FNR");
	}

}
