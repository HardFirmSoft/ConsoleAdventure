package ConsoleAdventure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class TextSequences extends Main{
	private static Scanner scanner = new Scanner(System.in);
	private static final String pathPrefix = "./resources/textsequences/";

	public static void displayMessagesWithDelay(ArrayList<String> messages, int delayInSeconds){

		try {
			for (String message : messages) {
				System.out.println(message);
				TimeUnit.SECONDS.sleep(delayInSeconds);
			}
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}

	private static ArrayList<String> textFileToArrayListFormatted(String filePath, HashMap<String, String> variables){
	    ArrayList<String> lines = new ArrayList<>();
		try {
			File file = new File(filePath);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(formatString(line, variables));
			}
			fileReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lines;
	}

	//TODO: FINISH PARSING
    private static String formatString(String inputString, HashMap<String, String> variables) {
        if(variables.size() == 0) return inputString;

	    String[] tokens = inputString.split("\\$");
        StringBuilder formattedString = new StringBuilder();

        //KIND OF DUMB, BAD WITH BIG FILES
        for(String token: tokens){
        	if(token.equals("$")){
        		continue;
			}
			formattedString.append(variables.getOrDefault(token, token));
        }

        return formattedString.toString();
    }

	static void introSequence() throws InterruptedException{
		String[] paths = new String[3];
		paths[0] = pathPrefix + "intro_sequence_01.txt";
		paths[1] = pathPrefix + "intro_sequence_02.txt";
		paths[2] = pathPrefix + "intro_sequence_03.txt";
		HashMap<String, String> variables = new HashMap<>();
		variables.put("name", player.getNAME());

		for(String path: paths){
			menus.clear();
			displayMessagesWithDelay(textFileToArrayListFormatted(path, variables), 3);
		}
		menus.clear();

		tutorialSequence();
	}
	
	static void tutorialSequence() throws InterruptedException{
		String[] paths = new String[2];
		paths[0] = pathPrefix + "tutorial_sequence_01.txt";
		paths[1] = pathPrefix + "tutorial_sequence_02.txt";
		HashMap<String, String> variables = new HashMap<>();
		for(String path: paths){
			menus.clear();
			displayMessagesWithDelay(textFileToArrayListFormatted(path, variables), 3);
		}
		scanner.reset();
		player.setSTORY_STATUS(1); //1 means done intro + tutorial.
		String option = "";
		while(option.length()==0) option = scanner.nextLine(); 
		while(option.charAt(0)!='q') {
			option="";
			while(option.length()==0) option = scanner.nextLine();
		}

		option="";
		menus.saveMenu();
		System.out.println("**  Excellent! Now try pressing 'm' to open your map  **");
		while(option.length()==0) option = scanner.nextLine(); 
		while(option.charAt(0)!='m') {
			option="";
			while(option.length()==0) option = scanner.nextLine();
		}
		menus.mapMenu();
		ArrayList<String> message = new ArrayList<>();
		message.add("**  ...You're ready... now remember, I'm watching  **");
		displayMessagesWithDelay(message, 3);
		GameLoop.launch(); //launch main game loop
	}
}
