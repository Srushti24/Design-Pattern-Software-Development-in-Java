
package multiThreadedHS.util;

public class MyLogger{

    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime the new thread is created]
      DEBUG_VALUE=2 [Print everytime there is an arraylist created for a new thread]
      DEBUG_VALUE=1 [Print everytime there is heap used]
      DEBUG_VALUE=0 [Print everytime reading from file]
    */

    public static enum DebugLevel {RELEASE, FROM_RESULTS, IN_RESULTS, IN_RUN, CONSTRUCTOR
                                   };

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	  case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	      // FIXME: add code for other cases
         case 3: debugLevel = DebugLevel.IN_RUN; break;
           case 2: debugLevel = DebugLevel.IN_RESULTS; break;
            case 1: debugLevel = DebugLevel.FROM_RESULTS; break;

	  case 0: debugLevel = DebugLevel.RELEASE; break;
	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String  message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    /**
	 * @return String
	 */
    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}
