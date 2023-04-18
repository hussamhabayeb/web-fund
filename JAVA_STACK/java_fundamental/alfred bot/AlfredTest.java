public class AlfredTest {
  
    public static void main(String[] args) {
        
        AlfredQuotes alfredBot = new AlfredQuotes();
        
     
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("hussam");
        String dateAnnouncement = alfredBot.dateAnnouncement();
        String respondBeforeAlexis1=alfredBot.respondBeforeAlexis("Alexis is ok");
        String respondBeforeAlexis2=alfredBot.respondBeforeAlexis("alfred is ok");
        String respondBeforeAlexis3=alfredBot.respondBeforeAlexis(" hi");
       

        // String testDateAnnouncement = alfredBot.dateAnnouncement();
        
        // String alexisTest = alfredBot.respondBeforeAlexis(
        //                     "Alexis! Play some low-fi beats."
        //                     );
        // String alfredTest = alfredBot.respondBeforeAlexis(
        //     "I can't find my yo-yo. Maybe Alfred will know where it is.");
        // String notRelevantTest = alfredBot.respondBeforeAlexis(
        //     "Maybe that's what Batman is about. Not winning. But failing.."
        // );
        
        // Print the greetings to test.
        System.out.println(testGreeting);
        System.out.println(testGuestGreeting);
        System.out.println(dateAnnouncement);
        System.out.println( respondBeforeAlexis1);

        
        // Uncomment these one at a time as you implement each method.
        // System.out.println(testGuestGreeting);
        // System.out.println(testDateAnnouncement);
        // System.out.println(alexisTest);
        // System.out.println(alfredTest);
        // System.out.println(notRelevantTest);
    }
}
