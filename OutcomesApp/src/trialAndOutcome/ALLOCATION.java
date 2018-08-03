package trialAndOutcome;

public enum ALLOCATION {
	

	RANDOM("Allocation: randomised"), QUASI("Allocation: randomised, quasi"), UNCLEAR("Allocation: unclear");
	
	private final String description;

	private ALLOCATION(String description) {
		this.description = description;
	}
	
	public String getContent() {
        return description;
    }



}
