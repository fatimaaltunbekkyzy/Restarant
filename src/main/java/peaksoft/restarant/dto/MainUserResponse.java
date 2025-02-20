package peaksoft.restarant.dto;


import java.util.List;

public class MainUserResponse {
    private List<UserResponse> userResponse;
    private int numberOfEmployees;

    public MainUserResponse(List<UserResponse> userResponse, int numberOfEmployees) {
        this.userResponse = userResponse;
        this.numberOfEmployees = numberOfEmployees;
    }

    public List<UserResponse> getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(List<UserResponse> userResponse) {
        this.userResponse = userResponse;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}
