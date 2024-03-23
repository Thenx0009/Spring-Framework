package common;

//Not using @component annotation on purpose

public class SwimCoach implements Coach {
	
	public SwimCoach() {
		System.out.println("In constructor: "+ getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "swim 1000 meters as a warm up";
	}

}
