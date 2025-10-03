public class BinarySearchStack {
    // No explicit constructor defined - initialize these
    // Define variables to capture run-time variables
    int inputArray[];
    int totalbinarysearchcalls = 0;
    int calllevel = 0;
    int inputarraysize1;
    RealTimeStackDisplay myRealTimeStackDisplay;

    // Instrumented for counts of recursion
    public boolean binarySearch(int[] data, int target, int low, int high) {
        totalbinarysearchcalls++;
        calllevel++;
        boolean result = false;
        String pushString = ("binarySearch called: low = " + low + " high = " + high
                + " numelements = " + (high - low + 1) + " totalBinarySearchCalls = "
                + totalbinarysearchcalls + " calllevel: " + calllevel);
        myRealTimeStackDisplay.addLastToStack(pushString);
        // Now wait 3 seconds so we can see the display
        try {
            // Wait for 3000 milliseconds (3 seconds)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // Handle the case where the thread is interrupted while sleeping
            Thread.currentThread().interrupt(); // Restore the interrupted status
            System.err.println("Thread was interrupted during sleep.");
        }
        System.out.println("Just pushed...");
        if (low > high) {
            result = false;
        } else {
            int mid = (low + high) / 2;                            // truncating division
            if (target == data[mid]) {
                System.out.println("Return: true");
                result = true;
            } // found a match
            else if (target < data[mid]) {
                result = binarySearch(data, target, low, mid - 1);   // recur left of the middle
            } else {
                result = binarySearch(data, target, mid + 1, high);  // recur right of the middle
            }
        }
        System.out.println("Exiting now: result = " + result + " calllevel = " + calllevel);
        myRealTimeStackDisplay.removeLastFromStack();
        // Now wait 1 seconds so we can see the display
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the case where the thread is interrupted while sleeping
            Thread.currentThread().interrupt(); // Restore the interrupted status
            System.err.println("Thread was interrupted during sleep.");
        }
        System.out.println("Just popped...");
        calllevel--;
        if (calllevel == 0)
            System.out.println("calllevel now 0: exiting entire recursive function");
        return result;
    }

    public boolean binarySearchNoStack(int[] data, int target, int low, int high) {
        totalbinarysearchcalls++;
        calllevel++;
        boolean result = false;
        String pushString = ("binarySearch called: low = " + low + " high = " + high
                + " numelements = " + (high - low + 1) + " totalBinarySearchCalls = "
                + totalbinarysearchcalls + " calllevel: " + calllevel);
        System.out.println(pushString);
        if (low > high) {
            result = false;
        } else {
            int mid = (low + high) / 2;                            // truncating division
            if (target == data[mid]) {
                System.out.println("Return: true");
                result = true;
            } // found a match
            else if (target < data[mid]) {
                result = binarySearchNoStack(data, target, low, mid - 1);   // recur left of the middle
            } else {
                result = binarySearchNoStack(data, target, mid + 1, high);  // recur right of the middle
            }
        }
        System.out.println("Exiting now: result = " + result + " calllevel = " + calllevel);
        calllevel--;
        if (calllevel == 0)
            System.out.println("calllevel now 0: exiting entire recursive function");
        return result;
    }

    // TODO: put in the code in this method to generate the summary String for output
    // Will look like:
    /*
    Final calllevel: 0
    Total binary search calls: 11
    Log of inputsize 512 is 9.00
    */
    // variables needed are part of the class
    // Recommended: use Stringbuilder sb to build the return string
    public String binarySearchSummary() {
        StringBuilder sb = new StringBuilder();

        sb.append("Will write the summary and replace this with the summary.");

        return sb.toString();
    }

    public void testWithDisplay() {
        //BinarySearchStack myBinarySearchStack = new BinarySearchStack();
        // Test run parameters
        // Make this more systematic later
        inputarraysize1 = 1048576;
        boolean answer = false;
        String testSummaryString;
        System.out.println("Building random array of search values...");
        // Generate 0..n array
        inputArray = HelperStaticMethods.generateSequentialIntArray(inputarraysize1);
        // Reset test variables
        totalbinarysearchcalls = 0;
        calllevel = 0;
        // Create the stack display for this run
        this.myRealTimeStackDisplay = new RealTimeStackDisplay();
        // Now actually make the run
        System.out.println("Running binary search...");
        answer = this.binarySearch(inputArray, inputArray.length,
                0, inputArray.length - 1);
        testSummaryString = this.binarySearchSummary();
        //PopupDialog myPopupDialog = new PopupDialog();
        myRealTimeStackDisplay.addLastToStack(testSummaryString);
        System.out.println(testSummaryString);
    }

    public String testNoDisplay() {
        //BinarySearchStack myBinarySearchStack = new BinarySearchStack();
        // Test run parameters
        // Make this more systematic later
        inputarraysize1 = 512;
        boolean answer = false;
        String testSummaryString;
        System.out.println("Building random array of search values...");
        // Generate 0..n array
        inputArray = HelperStaticMethods.generateSequentialIntArray(inputarraysize1);
        // Reset test variables
        totalbinarysearchcalls = 0;
        calllevel = 0;
        // Now actually make the run
        System.out.println("Running binary search...");
        answer = this.binarySearchNoStack(inputArray, inputArray.length,
                0, inputArray.length - 1);
        testSummaryString = this.binarySearchSummary();
        System.out.println("\n\n");
        System.out.println(testSummaryString);
        return testSummaryString;
    }

    public static void main(String[] args) {
        BinarySearchStack myBinarySearchStack = new BinarySearchStack();
        myBinarySearchStack.testNoDisplay();
    }
}

