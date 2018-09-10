The first design decision made was to set the race strategy in Horse.java both in the constructor and in the setStrategy method. Because the strategy is specific to each instance of Horse, it makes sense to include it within the Horse class. Each strategy - SlowStartStrategy, SteadyRunStrategy, and EarlySprintStrategy, implement the GeneralStrategy interface. The only method for each strategy is horseSpeed which is dependent on each horse's unique maximum speed and current position in miles. This choice was made due to explicit requirements in the assignment. The other classes include the Race class and the Main class. The Race class has two methods: start() and runRace(). start() checks to make sure that the speeds of each of the horses is valid,
calls the runRace() method, and also prints the winner to the console. The race loop happens
in runRace(). For each iteration of the loop, each of the horses in the list are checked to 
see if they have reached 10 miles. Once there is a winner, it is returned and displayed to the
console. The choice to have two methods here separates the start of the race from the actual
running from the race and allows for better error-checking for the two functionalities.
Each loop is assumed to take a specific value of "seconds" which is then used to compute the
current position in the Horse class. One significant method in Horse is update(). This is 
the function that updates the current position of each instance of Horse each time it is called.
By placing this computation in Horse, each instance of Horse maintains its specific position 
in the race without affecting any other instance of Horse.

The Main class runs an instance of a sample race. It instantiates a few horses of type Horse
and adds them to a list of Horses before starting the race. The decision to add all horses to a
list lets as many horses as possible to run in the race without constraints. It also simplifies
the race loop and avoids code duplication. This data structure also grows with each horse
that is added which simplifies the code as well. 