package fr.eni.doctorsAppt.bo;

public class GeneralPractitioner extends Person{
    protected TimeSlots[] timeSlots = new TimeSlots[15];
    protected static int apptPrice;

    private int counter = 0;

    public GeneralPractitioner(String lastName, String firstName, String phone, Address address) {
        super(lastName, firstName, phone, address);
        apptPrice = 25;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static int getApptPrice() {
        return apptPrice;
    }

    public static void setApptPrice(int apptPrice) {
        GeneralPractitioner.apptPrice = apptPrice;
    }

    public String getLastName() {
        return lastName;
    }

    public void addTimeSlot(TimeSlots timeSlot) {
        timeSlots[counter] = timeSlot;
        counter++;
    }

    public void display() {
        System.out.println(this.lastName.toUpperCase() + " " + this.firstName);
        System.out.println("Phone number : " + this.phone);
        System.out.println("Appointment price : " + apptPrice);
        System.out.println("Address :");
        this.address.display();
        for (TimeSlots timeSlot : timeSlots) {
            if (timeSlot != null) {
                timeSlot.displaySlot();
            }
        }
    }
}
