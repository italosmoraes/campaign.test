import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author Italo S. Moraes
 * 
 *         read campaign file put content into a data structure read input file
 *         compare input file with the content file according to the criteria
 *         output the campaigns into a file
 */

public class GlobalReader {

	ArrayList<Campaign> clist = new ArrayList<Campaign>();
	ArrayList<Input> inptlist = new ArrayList<Input>();

	protected void readCampaignFile(File file) {
		// read campaign file
		try {

			
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = null;
			int linecount = 0;
			int cgpcount = 0; // to iterate through the campaigns created
			int id = 0;

			System.out.println("Reading campaing data file...");
			
			System.out.println("------------------------");
			System.out.println("Campaign List");
			
			
			

			while ((line = br.readLine()) != null) {

				++linecount;

				String[] string = line.split(" ");
				/* Test System.out.println("line content = " + line); */
				

				// creates a new Campaign object and adds to the list
				clist.add(new Campaign(string[0], id));

				// adds the segment list to the campaign segments array

				int[] slist = new int[7];
				for (int i = 0; i < 7; i++) {
					int y = i + 1;
					slist[i] = Integer.valueOf(string[y]);

					clist.get(cgpcount).setSlist(slist);
				}

				// test- shows campaign´s segment list

				/* Test
				System.out.println("campaign id = "
						+ clist.get(cgpcount).getId());
				System.out.println("campaign name = "
						+ clist.get(cgpcount).getCname());
				for (int x = 0; x < 7; x++) {
					System.out.println("segment = "
							+ clist.get(cgpcount).seglist[x]);
				}
				*/

				cgpcount++;
				id++;
			}

			System.out.println("------------------------");
			System.out.println("line count = " + linecount);
			System.out.println("------------------------");
			System.out.println("campaigns added count = " + clist.size());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void readInputFile() {
		// read campaign file
		try {

			File file = new File("C:/campaign/examples/input.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = null;
			int linecount = 0;
			int inptcount = 0; // to iterate through the inputs created

			System.out.println("------------------------");
			System.out.println("User Input List");

			while ((line = br.readLine()) != null) {

				linecount++;

				String[] string = line.split(" ");
				/* Test
				System.out.println("-----------*------------");
				System.out.println("line content = " + line);
				System.out.println("User # = " + string[0]);
				
				for (int i = 1; i < 7; i++) {
					System.out.println("User Segment = " + string[i]);
				}
				*/

				// creates a new Campaign object and adds to the list
				inptlist.add(new Input(string[0]));

				// adds the segment list to the user input segments array
				int[] slist = new int[6];
				for (int i = 0; i < 6; i++) {
					int y = i + 1;
					slist[i] = Integer.valueOf(string[y]);

					inptlist.get(inptcount).setSegmentList(slist);
				}
				// TODO should I order the list to make it search easier?

				// test- shows campaign´s segment list

				/* Test
				System.out.println("User Input ID = " + Input.getId());
				System.out.println("User input # = "
						+ inptlist.get(inptcount).getInputNumber());
				System.out.println(">>>>>>>>>>>*<<<<<<<<<<<<<");
				*/

				++inptcount;

			}

			System.out.println("------------------------");
			System.out.println("Input line count = " + linecount);
			System.out.println("------------------------");
			System.out.println("User Input´s count = " + inptlist.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
