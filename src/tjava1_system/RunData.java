package tjava1_system;

public class RunData {
	public static final String RUNDIR = System.getProperty("user.dir");
	public static final String BINDIR = getExecBinDir();
	public static final String dirSeparator = System.getProperty("file.separator");

	private static String getExecBinDir(){
		String runDir = RUNDIR;
		if (!(RUNDIR.endsWith("\\bin"))){              //後方一致
			runDir = RUNDIR+"\\bin";               //eclipseからの実行だったら
		}
		return runDir;
	}

}
