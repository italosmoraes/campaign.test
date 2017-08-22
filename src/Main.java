import java.io.File;
import java.util.Timer;

public class Main {
	public static void main(String[] args) {
		if (args.length > 0) {
			
			File file = new File(args[0]);
			
			GlobalReader run = new GlobalReader();

			double start = System.currentTimeMillis();

			// read campaing file

			run.readCampaignFile(file);

			run.readInputFile();

			double stop = System.currentTimeMillis();

			double time = stop - start;
			System.out.println(">>> File processing time = " + time / 1000);

			start = System.currentTimeMillis();

			Matcher m = new Matcher();
			m.matchData(run.clist, run.inptlist);

			stop = System.currentTimeMillis();

			time = stop - start;
			System.out.println(">>> Match processing time = " + time / 1000
					+ " seconds <<<");

		}

	}
}
