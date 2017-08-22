import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Matcher {

	/*
	 * matches the inputs with the appropriate campaigns
	 */
	protected void matchData(ArrayList<Campaign> clist,
			ArrayList<Input> inptlist) {
		System.out.println(">>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<");
		System.out.println("matching data...");

		List tempCampaignSegmentList;

		// String matchItem = null;
		int matchingLevel = 0;
		// HashMap<String, String> matchingCampaings = new HashMap<String,
		// String>();

		// TODO separate method
		ArrayList<String> campMatch = new ArrayList<String>();
		ArrayList<String> cmatchLevel = new ArrayList<String>();
		ArrayList<Integer> cmatchID = new ArrayList<Integer>();


		// find the matching segments and create a temp list to decide which one
		// to show
		for (int x = 0; x < inptlist.size(); x++) {
			System.out.println("----------------------------------------");
			System.out.println("matching campaigns for user input # = "
					+ inptlist.get(x).getInputNumber());
			//show input line
			System.out.print("User input = ");
			for( int l = 0; l < inptlist.get(x).getSegmentList().length; l++ ){
				System.out.print(inptlist.get(x).segmentList[l] + " ");
			}
			System.out.print("\n");

			for (int i = 0; i < clist.size(); i++) {
				// compares the input item with all the campaigns listed
				tempCampaignSegmentList = Arrays.asList(
						clist.get(i).seglist[0], clist.get(i).seglist[1],
						clist.get(i).seglist[2], clist.get(i).seglist[3],
						clist.get(i).seglist[4], clist.get(i).seglist[5]);

				matchingLevel = 0;

				for (int y = 0; y < 6; y++) {

					// searches through the i campaign segment list to find
					// matches

					if (tempCampaignSegmentList
							.contains(inptlist.get(x).segmentList[y])) {
						// assign a matching level for the input
						matchingLevel += 1;
						/*Test System.out.println("match found!"); */
					}

				}
				// compares saved campaign matches by the matching level, living
				// the highest one as the main selection

				if (matchingLevel >= 1) {
					campMatch.add(clist.get(i).getCname());
					cmatchLevel.add(String.valueOf(matchingLevel));
					cmatchID.add(clist.get(i).getId());

				}

			}
			// should get the highest match and show the given campaign (or the
			// one that has the lesser number of shows)

			if (campMatch.size() <= 0) {
				System.out.println("no matching campaigns");
			}

			if (campMatch.size() > 0) {
				System.out.print("Matching campaigns = ");
				
				int highest = Integer.valueOf(cmatchLevel.get(0));
				int highest_Index = 0;

				for (int u = 0; u < campMatch.size(); u++) {
					

					// find the highest ranked campaigns by level
					//
					for (int s = 1; s < cmatchLevel.size(); s++) {
						int currentValue = Integer.valueOf(cmatchLevel.get(s));
						if (currentValue > highest) {
							highest = currentValue;
							highest_Index = s;
						} else if (currentValue == highest) {
							// verify # times the campaign has been shown
							int mac1 = clist.get(cmatchID.get(s)).numberOfMatches;
							int mac2 = clist.get(cmatchID.get(highest_Index)).numberOfMatches;
							// if there is one with lowest number, show it
							if (mac1 < mac2) {
								highest = currentValue;
								highest_Index = s;
							} else if (mac2 < mac1) {
								highest_Index = s;
								 // and selects the current 'highest' as
										// the matching campaign
							} else if (mac1 == mac2) {
								int[] random = { mac1, mac2 };
								highest = random[new Random()
										.nextInt((1 - 0) + 1) + 0];
								highest_Index = s;
								// randomly selects if equal
							}

						}
					}
					
				}
				
				System.out.print(campMatch.get(highest_Index) + " level "
						+ cmatchLevel.get(highest_Index) + "; \n");
				// increase the 'shown' variable for the campaigns
				clist.get(cmatchID.get(highest_Index)).numberOfMatches += 1;

			}

			campMatch.clear();// to restart the matching process
			cmatchLevel.clear();
			cmatchID.clear();

		}

	}
	
	
	/*
	 * matches the inputs with the appropriate campaigns
	 */
	protected void matchDataNO(ArrayList<Campaign> clist,
			ArrayList<Input> inptlist) {
		
		double start = System.currentTimeMillis();
		
		System.out.println(">>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<");
		System.out.println("matching data...");
		
		

		List tempCampaignSegmentList;

		// String matchItem = null;
		int matchingLevel = 0;
		// HashMap<String, String> matchingCampaings = new HashMap<String,
		// String>();

		// TODO separate method
		ArrayList<String> campMatch = new ArrayList<String>();
		ArrayList<String> cmatchLevel = new ArrayList<String>();
		ArrayList<Integer> cmatchID = new ArrayList<Integer>();
		// int index = 0;

		// find the matching segments and create a temp list to decide which one
		// to show
		for (int x = 0; x < inptlist.size(); x++) {


			for (int i = 0; i < clist.size(); i++) {
				// compares the input item with all the campaigns listed
				tempCampaignSegmentList = Arrays.asList(
						clist.get(i).seglist[0], clist.get(i).seglist[1],
						clist.get(i).seglist[2], clist.get(i).seglist[3],
						clist.get(i).seglist[4], clist.get(i).seglist[5]);

				matchingLevel = 0;

				for (int y = 0; y < 6; y++) {

					// searches through the i campaign segment list to find
					// matches

					if (tempCampaignSegmentList
							.contains(inptlist.get(x).segmentList[y])) {
						// assign a matching level for the input
						matchingLevel += 1;
						/*Test System.out.println("match found!"); */
					}

				}
				// compares saved campaign matches by the matching level, living
				// the highest one as the main selection

				if (matchingLevel >= 1) {
					campMatch.add(clist.get(i).getCname());
					cmatchLevel.add(String.valueOf(matchingLevel));
					cmatchID.add(clist.get(i).getId());

				}

			}
			// should get the highest match and show the given campaign (or the
			// one that has the lesser number of shows)

			if (campMatch.size() > 0) {
				
				int highest = Integer.valueOf(cmatchLevel.get(0));
				int highest_Index = 0;

				for (int u = 0; u < campMatch.size(); u++) {
					

					// find the highest ranked campaigns by level
					//
					for (int s = 1; s < cmatchLevel.size(); s++) {
						int currentValue = Integer.valueOf(cmatchLevel.get(s));
						if (currentValue > highest) {
							highest = currentValue;
							highest_Index = s;
						} else if (currentValue == highest) {
							// verify # times the campaign has been shown
							int mac1 = clist.get(cmatchID.get(currentValue)).numberOfMatches;
							int mac2 = clist.get(cmatchID.get(highest)).numberOfMatches;
							// if there is one with lowest number, show it
							if (mac1 < mac2) {
								highest = currentValue;
								highest_Index = s;
							} else if (mac2 < mac1) {
								highest_Index = s;
								break; // and selects the current 'highest' as
										// the matching campaign
							} else if (mac1 == mac2) {
								int[] random = { mac1, mac2 };
								highest = random[new Random()
										.nextInt((1 - 0) + 1) + 0];
								highest_Index = s;
								// randomly selects if equal
							}

						}
					}
					
				}
				
				
				// increase the 'shown' variable for the campaigns
				clist.get(cmatchID.get(highest_Index)).numberOfMatches += 1;

			}

			campMatch.clear();// to restart the matching process
			cmatchLevel.clear();
			cmatchID.clear();

		}
		
		double stop = System.currentTimeMillis();
		
		double time = stop = start;
		
		System.out.println("Match processing time = " + time/1000);

	}


}
